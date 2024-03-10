package cn.bugstack.chatgpt.domain.edits;

import cn.bugstack.chatgpt.domain.other.Choice;
import cn.bugstack.chatgpt.domain.other.Usage;
import lombok.Data;

import java.io.Serializable;

/**
 * @author LuckySJ
 * @description
 * @gitee https://gitee.com/liushijie-kitie
 * @Copyright LuckySJ-刘仕杰
 */
@Data
public class EditResponse implements Serializable {

    /** ID */
    private String id;
    /** 对象 */
    private String object;
    /** 模型 */
    private String model;
    /** 对话 */
    private Choice[] choices;
    /** 创建 */
    private long created;
    /** 耗材 */
    private Usage usage;
}
