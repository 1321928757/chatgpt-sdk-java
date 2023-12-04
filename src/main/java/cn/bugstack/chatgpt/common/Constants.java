package cn.bugstack.chatgpt.common;

/**
 * @author 小傅哥，微信：fustack
 * @description 通用类
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class Constants {

    /**
     * 官网支持的请求角色类型；system、user、assistant
     * https://platform.openai.com/docs/guides/chat/introduction
     */
    public enum Role {

        SYSTEM("system"),
        USER("user"),
        ASSISTANT("assistant"),
        ;

        private String code;

        Role(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

    }

}
