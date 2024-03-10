package cn.bugstack.chatgpt.domain.images;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author LuckySJ
 * @description 图片响应
 * @gitee https://gitee.com/liushijie-kitie
 * @Copyright LuckySJ-刘仕杰
 */
@Data
public class ImageResponse implements Serializable {
    /** 条目数据 */
    private List<Item> data;
    /** 创建时间 */
    private long created;
}
