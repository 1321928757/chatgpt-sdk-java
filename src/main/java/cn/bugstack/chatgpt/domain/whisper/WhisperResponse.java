package cn.bugstack.chatgpt.domain.whisper;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LuckySJ
 * @description
 * @gitee https://gitee.com/liushijie-kitie
 * @Copyright LuckySJ-刘仕杰
 */
@Data
public class WhisperResponse implements Serializable {
    private String text;
}
