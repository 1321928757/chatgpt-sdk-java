package cn.bugstack.chatgpt.domain.other;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author LuckySJ
 * @description
 * @gitee https://gitee.com/liushijie-kitie
 * @Copyright LuckySJ-刘仕杰
 */
@Data
public class OpenAiResponse<T> implements Serializable {

    private String object;
    private List<T> data;
    private Error error;


    @Data
    public class Error {
        private String message;
        private String type;
        private String param;
        private String code;
    }

}
