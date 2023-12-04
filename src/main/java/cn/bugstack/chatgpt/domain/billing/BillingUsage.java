package cn.bugstack.chatgpt.domain.billing;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description 消耗账单
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Data
public class BillingUsage {

    @JsonProperty("object")
    private String object;
    /**  账号金额消耗明细 */
    @JsonProperty("daily_costs")
    private List<DailyCost> dailyCosts;
    /** 总使用金额/美分 */
    @JsonProperty("total_usage")
    private BigDecimal totalUsage;

}
