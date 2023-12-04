package cn.bugstack.chatgpt.domain.images;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description 图片响应
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Data
public class ImageResponse implements Serializable {
    /** 条目数据 */
    private List<Item> data;
    /** 创建时间 */
    private long created;
}
