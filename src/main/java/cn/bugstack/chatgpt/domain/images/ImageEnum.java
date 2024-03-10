package cn.bugstack.chatgpt.domain.images;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author LuckySJ
 * @description 图片枚举配置
 * @gitee https://gitee.com/liushijie-kitie
 * @Copyright LuckySJ-刘仕杰
 */
public class ImageEnum {

    @Getter
    @AllArgsConstructor
    public enum Size {
        size_256("256x256"),
        size_512("512x512"),
        size_1024("1024x1024"),
        ;
        private String code;
    }

    @Getter
    @AllArgsConstructor
    public enum ResponseFormat {
        URL("url"),
        B64_JSON("b64_json"),
        ;
        private String code;
    }

}
