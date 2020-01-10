package cn.vuax.main.wx.message.response;

import cn.vuax.main.wx.message.model.Video;

/**
 * @Author: LiuJing
 * @Create: 2020/1/10 14:46
 */
public class VideoMessage extends BaseMessage {
    private Video video;

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}
