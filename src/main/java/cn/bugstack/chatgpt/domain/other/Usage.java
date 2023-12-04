package cn.bugstack.chatgpt.domain.other;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author 小傅哥，微信：fustack
 * @description 使用量
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class Usage implements Serializable {

    /** 提示令牌 */
    @JsonProperty("prompt_tokens")
    private long promptTokens;
    /** 完成令牌 */
    @JsonProperty("completion_tokens")
    private long completionTokens;
    /** 总量令牌 */
    @JsonProperty("total_tokens")
    private long totalTokens;

    public long getPromptTokens() {
        return promptTokens;
    }

    public void setPromptTokens(long promptTokens) {
        this.promptTokens = promptTokens;
    }

    public long getCompletionTokens() {
        return completionTokens;
    }

    public void setCompletionTokens(long completionTokens) {
        this.completionTokens = completionTokens;
    }

    public long getTotalTokens() {
        return totalTokens;
    }

    public void setTotalTokens(long totalTokens) {
        this.totalTokens = totalTokens;
    }

}
