package cn.vuax.main.wx.message;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 将发送方，接收方，微信用户名封装
 *
 * @Author: LiuJing
 * @CreateData: 2020/1/10 14:14
 */
@Component
public class MessageInfo implements Serializable {
    private static final long serialVersionUID = -724359228548360783L;

    private String fromUserName;    // 发送方微信账号

    private String toUserName;      // 接受方微信账号

    private String weixinUserName;  // 微信用户名

    private String messageType;     // 消息类型

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getWeixinUserName() {
        return weixinUserName;
    }

    public void setWeixinUserName(String weixinUserName) {
        this.weixinUserName = weixinUserName;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @Override
    public String toString() {
        return "MessageInfo{" +
                "fromUserName='" + fromUserName + '\'' +
                ", toUserName='" + toUserName + '\'' +
                ", weixinUserName='" + weixinUserName + '\'' +
                ", messageType='" + messageType + '\'' +
                '}';
    }
}
