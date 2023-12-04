package cn.bugstack.chatgpt.domain.whisper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author 小傅哥，微信：fustack
 * @description 请求信息；语音转文字
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Data
public class WhisperEnum implements Serializable {

    @Getter
    @AllArgsConstructor
    public enum Model {
        WHISPER_1("whisper-1"),
        ;
        private String code;
    }

    @Getter
    @AllArgsConstructor
    public enum ResponseFormat {
        JSON("json"),
        TEXT("text"),
        SRT("srt"),
        VERBOSE_JSON("verbose_json"),
        VTT("vtt"),
        ;
        private String code;
    }

}
