package cn.vuax.main.controller;

import cn.vuax.main.service.WxService;
import cn.vuax.main.wx.util.CheckUtil;
import cn.vuax.main.wx.MessageDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 微信订阅号
 * mp 是微信公众平台的域名，是媒体平台 Media Platform 的英文缩写。
 * 微信公众平台,给个人、企业和组织提供业务服务与用户管理能力的全新服务平台。
 *
 * @Author: LiuJing
 * @CreateData: 2020/1/3 21:13
 */
@RestController
public class WxController {

    @Autowired
    private MessageDispatcher messageDispatcher;

    @Autowired
    private WxService wxService;

    /**
     * 微信登录校验
     *
     * @param request
     * @param response
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/wx")
    public void login(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
                out.write(echostr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

//    @PostMapping("/wx")
//    public void handler(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        PrintWriter out = response.getWriter();
//        Map<String, String> parseXml = WxMessageUtil.parseXml(request);
//        String msgType = parseXml.get("MsgType");
//        String content = parseXml.get("Content");
//        String fromusername = parseXml.get("FromUserName");
//        String tousername = parseXml.get("ToUserName");
//        System.out.println(msgType);
//        System.out.println(content);
//        System.out.println(fromusername);
//        System.out.println(tousername);
//    }

    /**
     * 微信服务器给我发来的普通文本消息格式如下：
     * <xml>
     *      <ToUserName><![CDATA[toUser]]></ToUserName>
     *      <FromUserName><![CDATA[fromUser]]></FromUserName>
     *      <CreateTime>1348831860</CreateTime>
     *      <MsgType><![CDATA[text]]></MsgType>
     *      <Content><![CDATA[this is a test]]></Content>
     *      <MsgId>1234567890123456</MsgId>
     * </xml>
     *
     * @param request
     * @param response
     * @return          返回微信要求的 XMl 格式
     * @throws Exception
     */
    @PostMapping(value = "/wx", produces = "application/xml;charset=utf-8")
    public String handler(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");

//        InputStreamReader reader = new InputStreamReader(request.getInputStream(), "utf-8");
//        BufferedReader re = new BufferedReader(reader);
//        StringBuffer buffer = new StringBuffer();
//        String line;
//        while ((line = re.readLine()) != null) {
//            buffer.append(line);
//        }
//        System.out.println("微信传来的 XML");
//        System.out.println(buffer.toString());

//        Map<String, String> map = MessageUtil.parseXml(request);
//        String msgType = map.get("MsgType");
//        if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgType)) {
//            return messageDispatcher.processEvent(map);
//        } else {
//            return messageDispatcher.processMessage(map);
//        }

        return wxService.MessageHandler(request, response);
    }

}
