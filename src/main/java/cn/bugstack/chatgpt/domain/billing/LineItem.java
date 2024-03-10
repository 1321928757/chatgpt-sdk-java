package cn.bugstack.chatgpt.domain.billing;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author LuckySJ
 * @description 消耗列表数据
 * @gitee https://gitee.com/liushijie-kitie
 * @Copyright LuckySJ-刘仕杰
 */
@Data
public class LineItem {
    /** 模型 */
    private String name;
    /** 金额 */
    private BigDecimal cost;
}
