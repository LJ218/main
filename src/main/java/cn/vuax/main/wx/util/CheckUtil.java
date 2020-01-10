package cn.vuax.main.wx.util;

import cn.vuax.main.wx.util.SHA1;

import java.util.Arrays;

/**
 * 微信请求校验
 *
 * @Author: LiuJing
 * @CreateData: 2020/1/3 21:21
 */
public class CheckUtil {
    private static final String token = "Hello_WX";     // 自定义 ToKen
    public static boolean checkSignature(String signature, String timestamp, String nonce){
        String[] str = new String[]{token, timestamp, nonce};
        // 排序
        Arrays.sort(str);
        // 拼接字符串
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            buffer.append(str[i]);
        }
        // 进行 sha1 加密
        String temp = SHA1.encode(buffer.toString());
        // 与微信提供的 signature 进行匹对
        return signature.equals(temp);
    }
}
