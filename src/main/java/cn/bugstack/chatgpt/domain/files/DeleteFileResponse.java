package cn.bugstack.chatgpt.domain.files;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 小傅哥，微信：fustack
 * @description 删除文件应答
 * {
 *   "id": "file-XjGxS3KTG0uNmNOK362iJua3",
 *   "object": "file",
 *   "deleted": true
 * }
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Data
public class DeleteFileResponse implements Serializable {

    /** 文件ID */
    private String id;
    /** 对象；file */
    private String object;
    /** 删除；true */
    private boolean deleted;

}
