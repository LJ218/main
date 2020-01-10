package cn.vuax.main.wx.message.response;

/**
 * 文本消息
 *
 * @Author: LiuJing
 * @Create: 2020/1/3 21:53
 */
public class TextMessage extends BaseMessage {
    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
