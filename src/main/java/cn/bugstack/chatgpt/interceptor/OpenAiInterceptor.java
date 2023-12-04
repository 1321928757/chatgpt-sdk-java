package cn.bugstack.chatgpt.interceptor;

import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * @author 小傅哥，微信：fustack
 * @description 自定义拦截器
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class OpenAiInterceptor implements Interceptor {

    /** OpenAi apiKey 需要在官网申请 */
    private String apiKey;
    /** 访问授权接口的认证 Token */
    private String authToken;

    public OpenAiInterceptor(String apiKey, String authToken) {
        this.apiKey = apiKey;
        this.authToken = authToken;
    }

    @NotNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(this.auth(apiKey, chain.request()));
    }

    private Request auth(String apiKey, Request original) {
        // 设置Token信息；如果没有此类限制，是不需要设置的。
        HttpUrl url = original.url().newBuilder()
                .addQueryParameter("token", authToken)
                .build();

        // 创建请求
        return original.newBuilder()
                .url(url)
                .header(Header.AUTHORIZATION.getValue(), "Bearer " + apiKey)
                .header(Header.CONTENT_TYPE.getValue(), ContentType.JSON.getValue())
                .method(original.method(), original.body())
                .build();
    }

}
