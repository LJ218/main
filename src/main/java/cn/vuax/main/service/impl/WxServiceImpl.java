package cn.vuax.main.service.impl;

import cn.vuax.main.wx.message.MessageInfo;
import cn.vuax.main.wx.message.response.TextMessage;
import cn.vuax.main.service.WxService;
import cn.vuax.main.wx.util.MessageModelUtil;
import cn.vuax.main.wx.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * 微信 Service 实现类
 *
 * @Author: LiuJing
 * @Create: 2020/1/10 11:23
 */
@Service("WxService")
public class WxServiceImpl implements WxService {

    @Autowired
    private MessageInfo messageInfo;

    @Autowired
    private MessageModelUtil messageModelUtil;

    @Override
    public String MessageHandler(HttpServletRequest request, HttpServletResponse response) {
        // 返回给微信的消息，默认为空
        String respMessage = null;
        // 默认返回的文本消息内容
        String respContent;

        // 解析微信传来的 XML 数据
        try {
            Map<String, String> map = MessageUtil.parseXml(request);
            // 发送方账号
            String fromUserName = map.get("FromUserName");
            messageInfo.setFromUserName(fromUserName);
            System.out.println("FromUserName: " + fromUserName);

            // 接受方账号（公众号）
            String toUserName = map.get("ToUserName");
            messageInfo.setToUserName(toUserName);
            System.out.println("ToUserName: " + toUserName);

            // 消息类型
            String msgType = map.get("MsgType");
            messageInfo.setMessageType(msgType);
            System.out.println("MsgType: " + msgType);

            // 默认回复文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);  // 设置接受方
            textMessage.setFromUserName(toUserName);  // 设置发送方
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
            textMessage.setMsgId(0);

            // 分析用户发送的消息类型，并作出相应的处理

            if (MessageUtil.REQ_MESSAGE_TYPE_TEXT.equals(msgType)) {

                if ("666".equals(map.get("Content"))) {
                    respMessage = messageModelUtil.followResponseMessageModel(messageInfo);
                } else {
                    // 文本信息
                    respContent = "亲，这是文本消息！";
                    textMessage.setContent(respContent);
                    respMessage = MessageUtil.textMessageToXml(textMessage);
                }
            } else if (MessageUtil.REQ_MESSAGE_TYPE_IMAGE.equals(msgType)) {
                // 图片消息
                respContent = "您发送的是图片消息！";
                textMessage.setContent(respContent);
                respMessage = MessageUtil.textMessageToXml(textMessage);
            } else if (MessageUtil.REQ_MESSAGE_TYPE_VOICE.equals(msgType)) {
                // 语音消息
                respContent = "您发送的是语音消息！";
                textMessage.setContent(respContent);
                respMessage = MessageUtil.textMessageToXml(textMessage);
            } else if (MessageUtil.REQ_MESSAGE_TYPE_VIDEO.equals(msgType)) {
                // 视频消息
                respContent = "您发送的是视频消息！";
                textMessage.setContent(respContent);
                respMessage = MessageUtil.textMessageToXml(textMessage);
            } else if (MessageUtil.REQ_MESSAGE_TYPE_LOCATION.equals(msgType)) {
                // 地理位置消息
                respContent = "您发送的消息为地理位置消息";
                textMessage.setContent(respContent);
                respMessage = MessageUtil.textMessageToXml(textMessage);
            } else if (MessageUtil.REQ_MESSAGE_TYPE_LINK.equals(msgType)) {
                // 链接消息
                respContent = "您发送的消息为链接消息";
                textMessage.setContent(respContent);
                respMessage = MessageUtil.textMessageToXml(textMessage);
            } else if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgType)) {
                // 事件推送（当用户主动点击菜单，或者扫描二维码等事件）
                // 事件类型
                String eventType = map.get("Event");
                System.out.println("EventType: " + eventType);
                if (MessageUtil.EVENT_TYPE_SUBSCRIBE.equals(eventType)) {
                    // 关注
                    respMessage = messageModelUtil.followResponseMessageModel(messageInfo);
                } else if (MessageUtil.EVENT_TYPE_UNSUBSCRIBE.equals(eventType)) {
                    // 取消关注
                    messageModelUtil.cancelAttention(fromUserName);
                } else if (MessageUtil.EVENT_TYPE_SCAN.equals(eventType)) {
                    // 扫描带参数二维码
                    System.out.println("扫描带参数二维码");
                } else if (MessageUtil.EVENT_TYPE_LOCATION.equals(eventType)) {
                    // 上报地理位置
                    System.out.println("上报地理位置");
                } else if (MessageUtil.EVENT_TYPE_CLICK.equals(eventType)) {
                    // 自定义菜单（点击菜单拉取消息）
                    // 事件KEY值，与创建自定义菜单时指定的KEY值对应
                    String eventKey = map.get("EventKey");
                    System.out.println("EventKey: " + eventKey);
                } else if (MessageUtil.EVENT_TYPE_VIEW.equals(eventType)) {
                    // 自定义菜单（(自定义菜单URl视图)）
                    System.out.println("处理自定义菜单URI视图");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("系统出错！");
            respMessage = null;
        } finally {
            if (respMessage == null)
                respMessage = messageModelUtil.systemErrorResponseMessageModel(messageInfo);
        }

        return respMessage;
    }
}
