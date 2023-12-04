package cn.bugstack.chatgpt.domain.images;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 小傅哥，微信：fustack
 * @description 图片枚举配置
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
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
