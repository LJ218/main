package cn.vuax.main.wx.message.model;

/**
 * @Author: LiuJing
 * @Create: 2020/1/10 14:43
 */
public class Article {
    // 图文消息名称
    private String title;
    // 图文消息描述
    private String description;
    // 图片链接，支持 JPG、PNG 格式，较好的效果为大图 640 像素 * 320 像素，小图 80 像素 * 80 像素
    private String picUrl;
    // 点击图文消息跳转链接
    private String url;

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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
