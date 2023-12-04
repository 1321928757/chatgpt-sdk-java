package cn.bugstack.chatgpt.session;

import cn.bugstack.chatgpt.IOpenAiApi;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSources;
import org.jetbrains.annotations.NotNull;

/**
 * @author 小傅哥，微信：fustack
 * @description 配置信息
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Configuration {

    @Getter
    @Setter
    private IOpenAiApi openAiApi;

    @Getter
    @Setter
    private OkHttpClient okHttpClient;

    @Getter
    @NotNull
    private String apiKey;

    @Getter
    private String apiHost;

    @Getter
    private String authToken;

    public EventSource.Factory createRequestFactory() {
        return EventSources.createFactory(okHttpClient);
    }

}
