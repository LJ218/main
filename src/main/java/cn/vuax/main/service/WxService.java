package cn.vuax.main.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 微信 Service
 *
 * @Author: LiuJing
 * @CreateData: 2020/1/10 11:21
 */
public interface WxService {

    public String MessageHandler(HttpServletRequest request, HttpServletResponse response);

}
