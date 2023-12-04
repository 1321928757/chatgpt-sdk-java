package cn.bugstack.chatgpt;

import cn.bugstack.chatgpt.domain.chat.ChatCompletionRequest;
import cn.bugstack.chatgpt.domain.chat.ChatCompletionResponse;
import cn.bugstack.chatgpt.domain.qa.QACompletionRequest;
import cn.bugstack.chatgpt.domain.qa.QACompletionResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author 小傅哥，微信：fustack
 * @description 以 ChatGPT 官网 API 模型，定义接口。官网：https://platform.openai.com/playground
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public interface IOpenAiApi {

    String v1_completions = "v1/completions";
    /**
     * 文本问答
     * @param qaCompletionRequest 请求信息
     * @return                    返回结果
     */
    @POST(v1_completions)
    Single<QACompletionResponse> completions(@Body QACompletionRequest qaCompletionRequest);

    String v1_chat_completions = "v1/chat/completions";
    /**
     * 默认 GPT-3.5 问答模型
     * @param chatCompletionRequest 请求信息
     * @return                      返回结果
     */
    @POST(v1_chat_completions)
    Single<ChatCompletionResponse> completions(@Body ChatCompletionRequest chatCompletionRequest);

}
