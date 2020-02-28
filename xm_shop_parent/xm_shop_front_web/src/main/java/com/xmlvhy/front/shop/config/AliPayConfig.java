package com.xmlvhy.front.shop.config;

/**
 * Author: 小莫
 * Date: 2019-04-02 14:35
 * Description:<描述>
 */
public class AliPayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092600601077";
    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCylqgEnzPA1urV92Gpwj30ZLn9/tK481BmDFz/8J6gDJvOrD0daA794mX/sOcK61yaA9Rix1AiSpQaBCLqfL/Wedtj/5XPBcgWzKkJKzDw6CXjzQLHp4gsRfQfLgQ88hNJguPiD4eD9caXsoGCJpS3yK9TlZFhMURn9O7fqxwuLNZenbA0RZwhGeBnX7DID2KlbSR27zug0AG85nkhXlPFZiprMdTb8zjDU7q/w2KtVBYhXxAhJToCXUJW9wk+KiLOn/1ppcd//jYL02Nm9iLhcOByU8pyRuWJ8FYP/NIBUtivlvm33Hy+0cxrZO8w5rlfsEseaVB8T5tm3kaHuuXvAgMBAAECggEAZqwy4KVeralhza2x2lUwJUebnqlYILjSKjlFZmfB6qYVFZb0c+mVZOU6WuwriJ2T2YAGJNwN+AkEaIikQkeCSx43wZ/5UtIyHNmA/SJ1uqrczcDZrktlAH8fQKXGDfvmlsbHmPnwoS82A5S+3EKuEZMxKU6+DDC08Udh5fmL9AchBfQqUYjconBymE2zO09DyUtnoYePDmJyNsQMwBd7ug1WSPXBxG6udFo16IrNnQCwQ9iw90aLZ23uoZZcK578H6IuQNa96ctH4pan0pFjdra06CIZap3WE28uT2df9tOXRJ2TUiv9d7WzNb1XxBJq+vGTbGU3kgsd+QBximN00QKBgQDfh2mWTI/L0MP9qADgqwyZhczPp6SZtPSDzC+gRQEAQlOLWxNz9JrkedTordS7EZgnlZrR+x96IJ6JWdmaodfqx/J9ynxv8ZNEaYR/Y5nIBY6kC9ywBHI7NaswfgkAYeSovAf/wSEegttlGXitjYkgAaa1zrFGFSl/vHBQktvg3QKBgQDMh//ui5HltRbeBvDT/iyosmCpTHoz+XaTxPFdKSPOUUMvfyOebsEzqrgOEr4kO5rLK6xnBiH/AIq0Q1lR19wNVuB/iIQHXW98F2032RBoHvUBM5vnpIflt6L+MwXh+AFk/LmozKbn4Ka2YjZOKE3NPYCCnQV7zocsSLkW+MOvOwKBgQCcPRogZANegt17PyLd5rE33b36p0L17PW76cygSZsZg0LB9TbzpdVePYoD2P0IhJPFl1xPySeHRaWKe7MN0nIJORjVs+KmnERDXT2vjP7AQKIjJ+dpYLI3kJvHmVDRY5tgFY3BxkxP90dCszsWlAd0x7KvAXoHcmM/VYdryjrGQQKBgD/IseHcmNVAEi+Pjo8uFxNM/aQOe5W12Grg4jyhVc9DvGYVijAgbhQEy31oDvARvoZZylwep3901cy9rB8/6Boo274p/rKlSt0yGRdvlBREgzeqtpYY02CqUiRgGReNVjH+NpATsoFhp9v86N6a5xh4c5lICqu/jpwa2c32KmB9AoGAMn+82qi7HGaGLIP86B0jtCWKn+rFn/nAJjKcGl6z1uoC3FVZ/pEZ2h3v0vw4VY6qm8cGduN3F2ryaBHRb1g/DA/F7xm+lfpaCip2zl0NbDgY8yLH9Ou/HmpvECa126T2D07dPYMbQ4epR4FlEpajM6F6IvbavbNjwjwJLe8of50=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAz9xYZrFs/yGZMF4E5HbgUll4ZUX7Wnm3zxyUh8mgpkD499bqKKDpBnyyxCCzExSN5/LV+tO7PDbu5IWt+ooaBdEamyKZInIXpfCTPSFGqR3X8tQPoVzHuHXnmNlMN271Tdb4/yBK2YA2hGhMpuZFCTpRqYdqy51hkzIEK6PK954rA7pXGs9BDzVCE2RLa4lscXGEfEoCBbREVzsXai98xnoypfy3H66v19ka7Ngiy2FqSBAKWmDUrspFOu8uSHp13sApC4M7GFQhMxulGoQ9Q5q3MoUIi0EwSGKOYHLpJN86HXqDpWe7vNzq40Se5eF0FuG5w3JqZJ3rBQMX8DBSrQIDAQAB";

    /***
     功能描述: 服务器异步通知页面路径  需 http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    //public static String notify_url = "http://xiaomo.mynatapp.cc/front/pay/aliPayNotifyNotice";

    //部署服务器上，注意修改地址：
    public static String notify_url = "http://localhost:8080/xm_shop_front_web_war_exploded/front/pay/aliPayNotifyNotice";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //public static String return_url = "https://xiaomo.mynatapp.cc/front/pay/aliPayReturnNotice";
    //部署服务器上注意修改地址
    public static String return_url = "http://localhost:8080/xm_shop_front_web_war_exploded/front/pay/aliPayReturnNotice";


    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    /*//修改后的，自己修改了

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101900723268";
    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQClcRomf952j3nMNnWvUEJHiYABw+KSM/k/wzhcDiBz6g7iFaGfy8uZ4QcVoUY+g3XUi2mITk5ceNJJXqwlgTv7gl8dspQoqdQW/7lRS2HaweDFHfj7P0UJgCrjk48h3FkGYLT9JF5mKCIaaa8UP/KKBDE0+M63ixY2DQFEotJNwlFrU9rLG2Bw9uIZk51xpCdzNoGE1dxjlct4vawhLA8VXKkUhM0xhgYV5mspn/gby9VQPv1z7tMXXXq58d41wSBR/nlja2t/GfI2jqAk1UXKj5eiHwJFMSJCAz5Q4fT7Ve25fxyuCQcdJWNbO5xIMWbc5tbeUhVmlTEK5F7ZB3frAgMBAAECggEAGiZ5grJdgJIHJ39INNDT2SjjweOrkX6DnE+IPgzBlnDdr2DJ7k8xPH50NzgJuWHgIxtyL+hovHcgjhZX0YnO6F9gF3qdrpvBeW0sZqwqqIBSvfWR4GzMxcargNNXIXwJ2lc45HZ2MWGQmmowEVxWQviMqpnVWu+yMBL4K1gtM7sMVAc169ITxm/klKOZ8wFjr5cym+OnrtQ46+vyh/YMjN4yWdZLy3TRBAMaAfB0vMnV3e3gQFe4gQ4VWmMPRkIKYwOuNgkv+LlnX8yGFO1u+yBCDAqRl64I6H3Rf+DkSxXlIlJYEbhSvF9YQykqA2gP6H4y+CNPx2F6mYJYcOHjkQKBgQDzrqYDnsXZW0yjUpneXtg3a5iUOxvSmZpit+hCne+gd8I0f56xASaVAjRloXyqOpF6XKBbyHDTs1PR0OYOdDsSDeTKKXZGwAqXyj55kNtQRZn9mh2Y/MloNW5zhOedC5ORraoWCOSCnzu22CFGVDmQH8Oen9OsCyC1HeSb4IbgeQKBgQCtzf1LH/pMR7d3VOvkheaJRj32TldrhCVgsX1/XGwwdwhsB7kqpu4F4IMkE2howuQkC6vsLHG+bSRp59/bF15AjiNkG0Ein4q3ldubp/slxQimpvFuXhZoNkdLA6vApTIt+edNxFhg42GwNOBUmrpxxfUYG/A3Uke6y6NclHTqgwKBgD/Zfz5rl8PAHHCe8BpIF7dNxgjxA/VGsiEztvPdljAhsQ04c0hF2OoqTbhje9rOxded9ZaXCpkt38SWS/F1mxS79zrRamBXaW8kWwJXZl++HP9KJn8znUJk3a//HwETS3NcYbisU9O2DVt3fiCDaSHOcN9bWYc20zchwgjl5/FhAoGBAIt2DXf5idMpfLrBJqNxGiIufcuk4xq/p2pmIUhP9fQRn21n6RmjZrzKgRAyjoX5VCzkPKi+pOpjE2Pzjjl0D8oHA7jw8ZwBnsJe+h91c93Ds4Rd0r53us0WOLClmmxzYcdojkRld3EPIzTLyPG6Uj621ErrKB6L5Eir3EKOUR5XAoGAMhkHGj+gfXIM7lud/8wGdHh00VhJngd3U3XIeShSDYA0KBjR6MyTShLoHY2dxqSe4wnGqO1E2HB2+j6vQ+/XIfjBbf6wF+Q6hvKvSuvovfIgECFK73AM1z12mpZKFjjiGIEJJoq3tJJzUsGr2W7+v3rUlduyMqKyAhN8IRx8vN0=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApXEaJn/edo95zDZ1r1BCR4mAAcPikjP5P8M4XA4gc+oO4hWhn8vLmeEHFaFGPoN11ItpiE5OXHjSSV6sJYE7+4JfHbKUKKnUFv+5UUth2sHgxR34+z9FCYAq45OPIdxZBmC0/SReZigiGmmvFD/yigQxNPjOt4sWNg0BRKLSTcJRa1PayxtgcPbiGZOdcaQnczaBhNXcY5XLeL2sISwPFVypFITNMYYGFeZrKZ/4G8vVUD79c+7TF116ufHeNcEgUf55Y2trfxnyNo6gJNVFyo+Xoh8CRTEiQgM+UOH0+1XtuX8crgkHHSVjWzucSDFm3ObW3lIVZpUxCuRe2Qd36wIDAQAB";

    *//***
     *功能描述: 服务器异步通知页面路径  需 http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     *//*
    //public static String notify_url = "http://xiaomo.mynatapp.cc/front/pay/aliPayNotifyNotice";

    //部署服务器上，注意修改地址：
    public static String notify_url = "http://116.62.244.46/xmShopFront/front/pay/aliPayNotifyNotice";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //public static String return_url = "https://xiaomo.mynatapp.cc/front/pay/aliPayReturnNotice";
    //部署服务器上注意修改地址
    public static String return_url = "http://116.62.244.46/xmShopFront/front/pay/aliPayReturnNotice";


    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";*/
}
