package com.blogs.duckweed.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author dingfan
 */
public class RequestUtil {

    /**
     * 发起get请求
     */
    public static String sendGet(String url) {
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try {
            // 打开和URL之间的连接
            URLConnection connection = initConnection(url);
            // 建立实际的连接
            connection.connect();
            // BufferedReader输入流来读取URL的响应
            String line;
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while (null != (line = in.readLine())) {
                result.append(line);
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result.toString();
    }

    /**
     * 发送post请求
     *
     * @param url   url
     * @param param 参数
     * @return 返回值
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try {
            // 打开和URL之间的连接
            URLConnection connection = initConnection(url);
            // 设置通用的请求属性
            initConnection(url);
            // 发送POST请求必须设置如下两行
            connection.setDoOutput(true);
            connection.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(connection.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while (null != (line = in.readLine())) {
                result.append(line);
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result.toString();
    }

    private static URLConnection initConnection(String url) throws IOException {
        URL realUrl = new URL(url);
        URLConnection connection = realUrl.openConnection();
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("user-agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        return connection;
    }
}
