package cn.vuax.main.wx.message.response;

import cn.vuax.main.wx.message.model.Article;

import java.util.List;

/**
 * 图文消息
 *
 * @Author: LiuJing
 * @Create: 2020/1/10 14:42
 */
public class NewsMessage extends BaseMessage {
    //图文消息个数,限制为10条以内
    private int articleCount;
    //多条图文消息信息，默认第一个item为大图
    private List<Article> articles;

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
