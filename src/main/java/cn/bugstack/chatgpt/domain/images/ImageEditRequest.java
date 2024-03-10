package cn.bugstack.chatgpt.domain.images;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @author LuckySJ
 * @description 修改图片
 * @gitee https://gitee.com/liushijie-kitie
 * @Copyright LuckySJ-刘仕杰
 */
@Slf4j
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class ImageEditRequest extends ImageEnum implements Serializable {

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
