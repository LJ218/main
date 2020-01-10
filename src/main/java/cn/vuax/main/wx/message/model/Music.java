package cn.vuax.main.wx.message.model;

/**
 * 音乐 Model
 *
 * @Author: LiuJing
 * @Create: 2020/1/10 14:39
 */
public class Music {

    // 音乐标题
    private String title;
    // 音乐描述
    private String description;
    // 音乐链接
    private String musicUrl;
    // 高品质音乐链接，Wi-Fi 环境优先使用该链接播放音乐
    private String hqMusicUrl;
    // 缩略图的媒体 ID，通过上传多媒体文件得到的 ID
    private String thumbMediaId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String getHqMusicUrl() {
        return hqMusicUrl;
    }

    public void setHqMusicUrl(String hqMusicUrl) {
        this.hqMusicUrl = hqMusicUrl;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
}
