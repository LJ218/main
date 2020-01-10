package cn.vuax.main.wx.util;

import cn.vuax.main.wx.message.MessageInfo;
import cn.vuax.main.wx.message.model.Article;
import cn.vuax.main.wx.message.model.Image;
import cn.vuax.main.wx.message.response.ImageMessage;
import cn.vuax.main.wx.message.response.NewsMessage;
import cn.vuax.main.wx.message.response.TextMessage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 微信消息处理，将关注回复消息等写成方法
 * 封装微信回复消息，各种回复消息对应不同的方法
 *
 * @Author: LiuJing
 * @Create: 2020/1/10 14:49
 */
@Component
public class MessageModelUtil {

    /**
     * 当系统出错时，默认回复的文本消息
     *
     * @param messageInfo
     * @return
     */
    public String systemErrorResponseMessageModel(MessageInfo messageInfo) {
        // 回复文本消息
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(messageInfo.getFromUserName());
        textMessage.setFromUserName(messageInfo.getToUserName());
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
//        textMessage.setFuncFlag(0);
        textMessage.setContent("系统出错啦，请稍后再试！");
        return MessageUtil.textMessageToXml(textMessage);
    }

    /**
     * 用户关注时发送的图文消息
     *
     * @param messageInfo
     * @return
     */
    public String followResponseMessageModel(MessageInfo messageInfo) {
        ImageMessage imageMessage = new ImageMessage();
        Image image = new Image();
        image.setMediaID("https://s2.ax1x.com/2020/01/01/lJ1HWn.jpg");
        imageMessage.setImage(image);
        return MessageUtil.imageMessageToXml(imageMessage);


//        NewsMessage newsMessage = new NewsMessage();
//        newsMessage.setToUserName(messageInfo.getFromUserName());
//        newsMessage.setFromUserName(messageInfo.getToUserName());
//        newsMessage.setCreateTime(new Date().getTime());
//        newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
////        textMessage.setFuncFlag(0);
//
//        // 图文消息
//        List<Article> articleList = new ArrayList<Article>();
//        Article article = new Article();
//        // 设置图文消息的标题
//        String string = "尊敬的用户，你好！";
//        article.setTitle(string);
////        article.setPicUrl(webConfigBean.getWeixinPicture() + "meetingLogo2.png");
////        article.setUrl(webConfigBean.getDoMainNameurl() + "/WeixinParticipantFouce");
//        article.setPicUrl("https://s2.ax1x.com/2020/01/01/lJ1HWn.jpg");
//        article.setUrl("http://www.vuax.cn/");
//        articleList.add(article);
//        newsMessage.setArticleCount(articleList.size());
//        newsMessage.setArticles(articleList);
//        return MessageUtil.newsMessageToXml(newsMessage);
    }

    /**
     * 用户取消关注，先判断用户是否绑定，如果已经绑定则解除绑定
     *
     * @param fromUserName
     */
    public void cancelAttention(String fromUserName) {
//        if (userService.isAlreadyBinding(fromUserName)) {
//            userService.userUnbinding(fromUserName);
//        } else {
//            System.out.println("取消关注用户{}" + fromUserName + "还未绑定");
//        }
    }

}
