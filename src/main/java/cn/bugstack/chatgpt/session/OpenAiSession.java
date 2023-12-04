package cn.bugstack.chatgpt.session;

import cn.bugstack.chatgpt.domain.chat.ChatCompletionRequest;
import cn.bugstack.chatgpt.domain.chat.ChatCompletionResponse;
import cn.bugstack.chatgpt.domain.qa.QACompletionRequest;
import cn.bugstack.chatgpt.domain.qa.QACompletionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;

/**
 * @author 小傅哥，微信：fustack
 * @description OpenAi 会话接口
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public interface OpenAiSession {

    /**
     * 文本问答；简单请求
     * @param question 请求信息
     * @return         返回结果
     */
    QACompletionResponse completions(String question);

    /**
     * 文本问答
     * @param qaCompletionRequest 请求信息
     * @return                    返回结果
     */
    QACompletionResponse completions(QACompletionRequest qaCompletionRequest);

    /**
     * 文本问答 & 流式反馈
     * @param qaCompletionRequest 请求信息
     * @param eventSourceListener 实现监听；通过监听的 onEvent 方法接收数据
     */
    EventSource completions(QACompletionRequest qaCompletionRequest, EventSourceListener eventSourceListener) throws JsonProcessingException;

    /**
     * 问答模型 GPT-3.5/4.0
     * @param chatCompletionRequest 请求信息
     * @return                      返回结果
     */
    ChatCompletionResponse completions(ChatCompletionRequest chatCompletionRequest);

    /**
     * 问答模型 GPT-3.5/4.0 & 流式反馈
     * @param chatCompletionRequest 请求信息
     * @param eventSourceListener   实现监听；通过监听的 onEvent 方法接收数据
     * @return                      返回结果
     */
    EventSource chatCompletions(ChatCompletionRequest chatCompletionRequest, EventSourceListener eventSourceListener) throws JsonProcessingException;

}
