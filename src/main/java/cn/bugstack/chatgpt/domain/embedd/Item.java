package cn.bugstack.chatgpt.domain.embedd;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author LuckySJ
 * @description 条目信息
 * @gitee https://gitee.com/liushijie-kitie
 * @Copyright LuckySJ-刘仕杰
 */
@Data
public class Item implements Serializable {

    private String object;
    private List<BigDecimal> embedding;
    private Integer index;

}
