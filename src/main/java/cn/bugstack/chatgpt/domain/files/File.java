package cn.bugstack.chatgpt.domain.files;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 小傅哥，微信：fustack
 * @description
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
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
