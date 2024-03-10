package cn.bugstack.chatgpt.domain.embedd;

import cn.bugstack.chatgpt.domain.other.Usage;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author LuckySJ
 * @description 反馈对象
 * @gitee https://gitee.com/liushijie-kitie
 * @Copyright LuckySJ-刘仕杰
 */
@Data
public class EmbeddingResponse implements Serializable {

    private String object;
    private List<Item> data;
    private String model;
    private Usage usage;

}
