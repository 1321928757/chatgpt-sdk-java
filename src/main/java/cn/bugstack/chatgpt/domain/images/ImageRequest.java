package cn.bugstack.chatgpt.domain.images;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @author 小傅哥，微信：fustack
 * @description 图片请求
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Slf4j
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class ImageRequest extends ImageEnum implements Serializable {

    /** 问题描述 */
    @NonNull
    private String prompt;
    /** 为每个提示生成的完成次数 */
    @Builder.Default
    private Integer n = 1;
    /** 图片大小 */
    @Builder.Default
    private String size = Size.size_256.getCode();
    /** 图片格式化方式；URL、B64_JSON */
    @JsonProperty("response_format")
    @Builder.Default
    private String responseFormat = ResponseFormat.URL.getCode();
    @Setter
    private String user;

}
