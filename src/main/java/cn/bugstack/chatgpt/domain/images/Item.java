package cn.bugstack.chatgpt.domain.images;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author LuckySJ
 * @description 条目
 * @gitee https://gitee.com/liushijie-kitie
 * @Copyright LuckySJ-刘仕杰
 */
@Data
public class Item implements Serializable {

    private String url;
    @JsonProperty("b64_json")
    private String b64Json;

}
