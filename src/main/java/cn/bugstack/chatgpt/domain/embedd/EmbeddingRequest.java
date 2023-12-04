package cn.bugstack.chatgpt.domain.embedd;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description Creates a variation of a given image.
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Slf4j
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class EmbeddingRequest implements Serializable {

    /** 模型 */
    @NonNull
    @Builder.Default
    private String model = Model.TEXT_EMBEDDING_ADA_002.getCode();
    /** 输入信息 */
    @NonNull
    private List<String> input;
    @Setter
    private String user;

    @Getter
    @AllArgsConstructor
    public enum Model {
        TEXT_EMBEDDING_ADA_002("text-embedding-ada-002"),
        ;
        private String code;
    }

}
