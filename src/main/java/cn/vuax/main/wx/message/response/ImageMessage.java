package cn.vuax.main.wx.message.response;

import cn.vuax.main.wx.message.model.Image;

/**
 * @Author: LiuJing
 * @Create: 2020/1/10 14:35
 */
public class ImageMessage extends BaseMessage {
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
