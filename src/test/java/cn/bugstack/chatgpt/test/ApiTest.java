package cn.bugstack.chatgpt.test;

import cn.bugstack.chatgpt.common.Constants;
import cn.bugstack.chatgpt.domain.chat.ChatCompletionRequest;
import cn.bugstack.chatgpt.domain.chat.ChatCompletionResponse;
import cn.bugstack.chatgpt.domain.chat.Message;
import cn.bugstack.chatgpt.domain.qa.QACompletionRequest;
import cn.bugstack.chatgpt.domain.qa.QACompletionResponse;
import cn.bugstack.chatgpt.session.Configuration;
import cn.bugstack.chatgpt.session.OpenAiSession;
import cn.bugstack.chatgpt.session.OpenAiSessionFactory;
import cn.bugstack.chatgpt.session.defaults.DefaultOpenAiSessionFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.concurrent.CountDownLatch;

/**
 * @author 小傅哥，微信：fustack
 * @description 单元测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Slf4j
public class ApiTest {

    private OpenAiSession openAiSession;

    @Before
    public void test_OpenAiSessionFactory() {
        // 1. 配置文件
        Configuration configuration = new Configuration();
        configuration.setApiHost("https://api.openai-proxy.com/");
        configuration.setApiKey("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");
        // 测试时候，需要先获得授权token：http://api.xfg.im:8080/authorize?username=xfg&password=123 - 此地址暂时有效，后续根据课程首页说明获取token；https://t.zsxq.com/0d3o5FKvc
        configuration.setAuthToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4ZmciLCJleHAiOjE2ODM5NDU3NDcsImlhdCI6MTY4Mzk0MjE0NywianRpIjoiM2QyMDExMTYtNmVjMS00Y2UzLWJhYzgtYzYxYmVmN2ZmNWE5IiwidXNlcm5hbWUiOiJ4ZmcifQ.3FDvUNuNoGemKLhcgagy8WH7xHwRU37t--BuH0N9skg");
        // 2. 会话工厂
        OpenAiSessionFactory factory = new DefaultOpenAiSessionFactory(configuration);
        // 3. 开启会话
        this.openAiSession = factory.openSession();
    }

    /**
     * 简单问答模式
     */
    @Test
    public void test_qa_completions() throws JsonProcessingException {
        QACompletionResponse response01 = openAiSession.completions("写个java冒泡排序");
        log.info("测试结果：{}", new ObjectMapper().writeValueAsString(response01.getChoices()));
    }

    /**
     * 简单问答模式 * 流式应答
     */
    @Test
    public void test_qa_completions_stream() throws JsonProcessingException, InterruptedException {
        // 1. 创建参数
        QACompletionRequest request = QACompletionRequest
                .builder()
                .prompt("写个java冒泡排序")
                .stream(true)
                .build();

        for (int i = 0; i < 1; i++) {
            // 2. 发起请求
            EventSource eventSource = openAiSession.completions(request, new EventSourceListener() {
                @Override
                public void onEvent(EventSource eventSource, String id, String type, String data) {
                    log.info("测试结果：{}", data);
                }
            });
        }

        // 等待
        new CountDownLatch(1).await();
    }

    /**
     * 此对话模型 3.5 接近于官网体验
     */
    @Test
    public void test_chat_completions() {
        // 1. 创建参数
        ChatCompletionRequest chatCompletion = ChatCompletionRequest
                .builder()
                .messages(Collections.singletonList(Message.builder().role(Constants.Role.USER).content("你好").build()))
                .model(ChatCompletionRequest.Model.GPT_3_5_TURBO.getCode())
                .build();
        // 2. 发起请求
        ChatCompletionResponse chatCompletionResponse = openAiSession.completions(chatCompletion);
        // 3. 解析结果
        chatCompletionResponse.getChoices().forEach(e -> {
            log.info("测试结果：{}", e.getMessage());
        });
    }

    /**
     * 此对话模型 3.5 接近于官网体验 & 流式应答
     */
    @Test
    public void test_chat_completions_stream() throws JsonProcessingException, InterruptedException {
        // 1. 创建参数
        ChatCompletionRequest chatCompletion = ChatCompletionRequest
                .builder()
                .stream(true)
                .messages(Collections.singletonList(Message.builder().role(Constants.Role.USER).content("你好").build()))
                .model(ChatCompletionRequest.Model.GPT_3_5_TURBO.getCode())
                .build();
        // 2. 发起请求
        EventSource eventSource = openAiSession.chatCompletions(chatCompletion, new EventSourceListener() {
            @Override
            public void onEvent(EventSource eventSource, String id, String type, String data) {
                log.info("测试结果：{}", data);
            }
        });
        // 等待
        new CountDownLatch(1).await();
    }

}
