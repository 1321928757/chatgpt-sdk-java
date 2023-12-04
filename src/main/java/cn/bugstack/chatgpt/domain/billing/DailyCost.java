package cn.bugstack.chatgpt.domain.billing;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description 金额消耗
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Data
public class DailyCost {
    @JsonProperty("timestamp")
    private long timestamp;
    @JsonProperty("line_items")
    private List<LineItem> lineItems;
}
