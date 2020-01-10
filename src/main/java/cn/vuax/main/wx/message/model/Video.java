package cn.vuax.main.wx.message.model;

/**
 * 视频消息 Model
 *
 * @Author: LiuJing
 * @Create: 2020/1/10 14:46
 */
public class Video {
    // 媒体文件 ID
    private String MediaId;
    // 视频消息缩略图的媒体 ID
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
