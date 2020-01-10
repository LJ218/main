package cn.vuax.main.wx.message.response;

import cn.vuax.main.wx.message.model.Voice;

/**
 * @Author: LiuJing
 * @Create: 2020/1/10 14:47
 */
public class VoiceMessage extends BaseMessage {
    private Voice voice;

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }
}
