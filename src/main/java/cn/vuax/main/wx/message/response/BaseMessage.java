package cn.vuax.main.wx.message.response;

/**
 * 响应消息基类（公众账号 → 普通用户）
 *
 * @Author: LiuJing
 * @Create: 2020/1/3 21:52
 */
public class BaseMessage {
    private String ToUserName;      // 接受方账号（收到的 OpenID）
    private String FromUserName;    // 开发者微信号
    private long CreateTime;        // 消息创建时间（整型）
    private String MsgType;         // 消息类型（text/music/news）
    private long MsgId;             // 消息 ID

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }
}
