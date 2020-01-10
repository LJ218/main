package cn.vuax.main.wx.message.response;

import cn.vuax.main.wx.message.model.Music;

/**
 * 音乐消息
 *
 * @Author: LiuJing
 * @Create: 2020/1/10 14:38
 */
public class MusicMessage extends BaseMessage {
    // 音乐
    private Music music;

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }
}
