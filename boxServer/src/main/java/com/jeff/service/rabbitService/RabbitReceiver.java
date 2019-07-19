package com.jeff.service.rabbitService;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.jeff.pojo.SceneMsg;
import com.jeff.pojo.adminBoxs.AdminBoxs;
import com.jeff.service.adminBoxs.IAdminBoxsService;
import com.jeff.utill.RedisUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


/**
 * @Desciption: 接受RabbitMQ消息service
 * @Date: 2019/7/15
 * @author :tangfa
 */
@Component
public class RabbitReceiver {

    @Autowired
    protected RabbitTemplate rabbitTemplate;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private IAdminBoxsService adminBoxsService;

    /**
     * @Description 订阅队列：onlineboxes消息，数据库中改变盒子上线离线状态
     * @param message
     */
    @RabbitListener(queues = "onlineboxes")
    public void receive(@Payload Message message) {
        byte[] messageBody = message.getBody();
        String msg = "";
        try{
            msg = new String(messageBody);
            logger.info("监听到消息:" + msg);
            AdminBoxs adminBoxs = new Gson().fromJson(msg, AdminBoxs.class);
            boolean bool = this.saveMessage(adminBoxs);
            if(bool == true){
                logger.info("消息修改成功:" + msg);
            }
        } catch (JsonSyntaxException | NumberFormatException e){
            logger.error("格式错误:" + msg);
        } catch (Exception e){
            logger.error("监听消息出现异常", e.fillInStackTrace());
        }
    }

    /**
     * @Desciption 订阅队列：playstatus消息，消息存入redis中
     * @param message
     */
    @RabbitListener(queues = "playstatus")
    public void receiveBox(@Payload Message message) {
        byte[] messageBody = message.getBody();
        String msg = "";
        try{
            msg = new String(messageBody);
            logger.info("监听到消息:" + msg);
            SceneMsg sceneMsg = new Gson().fromJson(msg, SceneMsg.class);
            //boolean bool = this.saveScenMsg(sceneMsg);
            boolean bool = this.saveScenMsg(sceneMsg.getBoxId(), msg);
        } catch (JsonSyntaxException | NumberFormatException e){
            logger.error("格式错误:" + msg, e.getMessage());
        } catch (Exception e){
            logger.error("监听消息出现异常", e.fillInStackTrace());
        }
    }

    /***
     * 将消息存入数据库
     */
    private boolean saveMessage(AdminBoxs adminBoxs){
        Boolean bool = adminBoxsService.updateById(adminBoxs);
        return bool;
    }

    /***
     * @Description: 将消息写入到redis中
     * @param：SceneMsg
     */
    private boolean saveScenMsg(SceneMsg sceneMsg){
        redisUtils.put(sceneMsg.getBoxId(), sceneMsg.toString());
        boolean bool = StringUtils.equals(sceneMsg.toString()
                , redisUtils.get(sceneMsg.getBoxId()).toString());
        return bool;
    }

    /**
     * @Description: 存储消息到redis中
     * @param boxId，msg
     * @return
     */
    private boolean saveScenMsg(String boxId, String msg){
        redisUtils.put(boxId, msg);
        boolean bool = StringUtils.equals(msg
                , redisUtils.get(boxId).toString());
        return bool;
    }
}
