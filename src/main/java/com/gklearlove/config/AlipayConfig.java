package com.gklearlove.config;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author: GK
 * @Date: 2020/6/6 19:20
 */
public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号,开发时使用沙箱提供的APPID，生产环境改成自己的APPID
    public static String APP_ID = "2016102800774610";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDVLP7ubz5qqeDp++ZltOMvsYBKyHvlmncadWTRked2238wj9GjqdDyXkIvVfr3ZpV2pWaIiEjYtCCbJJntqnxpff45b5DR9sdAZHFDnyt+2Sm8MuZa3FPBFEpHglVWxEJ84NwJURgwQ09Ae+zPzpzf77q4wCtg7U+iTEkdNOv2I0o8pc1OUGWa+QliR6Vu4ldmEnFX7dq2lOzA8OR5LSDLXWkRpauNMD74mqHx3MVgs6diBKFVYh50Sx0gVfUnmjyvZE87AY6CkSIIohWCOagEBTj+FcwSH42jYVqL5TqOIo1F26uw3jC89bWtdCSEJfco6sXpDWkVJ2MFtXROmihdAgMBAAECggEAMIz06rzvTD+wd9nlGVjfPSeB/oY2oY5SffYqpghC3TEUgKzgpBOzAOAy1rEQXXRBqin1djcD0EcF/g+R9y0S9Lu7QL2GECvSKXo2yZ3gvB0dgj1ddWgksx655Bts8Dv2oJZdxslvZt6NmDQhNRrrY50nu5gYyRSDRIV3SW2aKA5q0XktqpbjLcisS0QfLKZaLzwsapeugDOIud0zLdLtwoLocXph34Iy3dukyUjxxDoF49o9ADDJlO4rCRfXcH8KrP0FNeM6UZDSIgGgxF306lgIwOHYrRag5Ya81lcysTJ3Oqi3Tf72Kn5BCjJ/7J4Arb9wsqwMpZGN9pvrTidNgQKBgQD7aakG/xiXJrzVLzk5hlQeEjfOhn/40y+WoIgTqu2GKclKOp69kgpShFL1gj5ddrXkjimeFPNk9ndLLB9DSkZ8wy92UxaFTaIkL7II5Chwp31mn32HN6KCxI2GjxCyZX5ouMJiLGMhoLV4Igcam1uFtEEwVo8OwQ7iO8BnNgrArQKBgQDZELtoohVe4/7V1YpZXy6S95u7KOYpprbKAs6+te0URxO1qWP4IvAYtBu4kC0wfsyjRXag964wLubKP6FDgecPIHRWgZ7P6GtX8jBAGw2pPaRXuN5s3leeXmeqdoj63Beh1tDgBmFCvrwmNg4EvqsjFCIMFe2blBnQih9HcX8McQKBgC7otAT+K9RoAeu09/Rnv+IsfAUoy0/d948fPMSOq+rQeSJEdcHhMdPbpK7yMji2IZIXhGRefFtmMTPxc5PWk/hLYtus/RK6PXqK+6j1CSab2aYANCe6lbPYgJ+OqgrfLQrVDk/LAGQR3Eoh7zljq1vzGgau39pc4y4LAAdB6hexAoGAFVVQperwIMBVplxzWW9CW41cT9uoK0XIRzhZa2Lj5w9JP5xjR9rfL/5bjxsUZeTAZfeIvi85fmDNq+jvB3x34gO1i1735cUY767M0TAXep+lTD3OFnMPt2/dzmIR+l2xMOW055+Y5X9rbHH5lLvMhAkRg5CQJq86jkVU56ee7fECgYEAymNNSV9gM1sgu0G6TEqYKR8lfppzJ8qJbWz9blW+pG/XrlH3UAt/M7psAEvVcxTFOt3X+A8PhTaG1nD/31bfdZvIe/n9HTfOR01dYZnpEmJrSd2yBpEJc+cM9sYtltivYFZ4rrNzVNfAmysf+susYgFVIwITXbJC86/Ir6gn/ME=";


    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAj+y7oHVbHNVtXpnb4fOyISK4nz/Jghy6Igwx2nzTznDjKoIe6+XPmHaGN5x9RyKlz2klWfrcIIC7HuVWbMR69anr+K5Gcj2NNlvRdyYj9vX/+52RLaleCLIkWZNHnUJ+ogCxGnXgoUcZ0xHVC08yulx/W8VRM7GFO+CRoGhUGbKZJO/8W64DU2g3vmo64stMufmVmrTp12lo/ne64NenGLHFNJx5/wAFOQ0lwDxs6AOX7cVjNsN2aRqqgfGkAEZp/lymkW2IrQOK6fckyCWFTBS04a7/GJwng2rr7HGu8V36OT6HPZEKetN3JWa1swoEqNeTGBUKNkqk2VhXN5YWkQIDAQAB";


    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://http://gklearlove.qicp.vip/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问(其实就是支付成功后返回的页面)
    public static String return_url = "http://121.199.42.126:8081/callback";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String CHARSET = "utf-8";

    // 支付宝网关，这是沙箱的网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
