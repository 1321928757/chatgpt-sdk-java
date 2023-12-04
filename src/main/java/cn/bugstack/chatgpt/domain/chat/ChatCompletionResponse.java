package cn.bugstack.chatgpt.domain.chat;

import cn.bugstack.chatgpt.domain.other.Usage;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description 对话请求结果信息
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Data
public class ChatCompletionResponse implements Serializable {

    /** ID */
    private String id;
    /** 对象 */
    private String object;
    /** 模型 */
    private String model;
    /** 对话 */
    private List<ChatChoice> choices;
    /** 创建 */
    private long created;
    /** 耗材 */
    private Usage usage;
    /** 后端配置 */
    private String system_fingerprint;

}
