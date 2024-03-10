package cn.bugstack.chatgpt.domain.files;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author LuckySJ
 * @description
 * @gitee https://gitee.com/liushijie-kitie
 * @Copyright LuckySJ-刘仕杰
 */
@Data
public class File implements Serializable {

    /** ID */
    private String id;
    /** 对象 */
    private String object;
    /** 字节 */
    private long bytes;
    /** 时间 */
    private long created_at;
    /** 名称 */
    private String filename;
    /** 类型；search */
    private String purpose;
    /** 状态 */
    private String status;
    @JsonProperty("status_details")
    private String statusDetails;

}
