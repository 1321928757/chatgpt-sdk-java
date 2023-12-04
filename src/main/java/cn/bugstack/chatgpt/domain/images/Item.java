package cn.bugstack.chatgpt.domain.images;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 小傅哥，微信：fustack
 * @description 条目
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Data
public class Item implements Serializable {

    private String url;
    @JsonProperty("b64_json")
    private String b64Json;

}
