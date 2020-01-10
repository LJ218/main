package cn.vuax.main.wx;

import cn.vuax.main.wx.message.response.TextMessage;
import cn.vuax.main.wx.util.MessageUtil;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @Author: LiuJing
 * @CreateData: 2020/1/3 21:46
 */
@Component
public class MessageDispatcher {
    public static String processMessage(Map<String, String> map) {
        String openid = map.get("FromUserName");    // 用户 openid
        String mpid = map.get("ToUserName");        // 公众号原始 ID
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
            // 普通文本消息
            TextMessage txtmsg = new TextMessage();
            txtmsg.setToUserName(openid);
            txtmsg.setFromUserName(mpid);
            txtmsg.setCreateTime(new Date().getTime());
            txtmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            txtmsg.setContent("Hello World!");
            return MessageUtil.textMessageToXml(txtmsg);
        }
        return null;
    }

    public String processEvent(Map<String, String> map) {
        // 在这里处理事件
        return "Event";
    }
}
