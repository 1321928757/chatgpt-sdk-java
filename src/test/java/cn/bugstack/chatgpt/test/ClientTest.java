package cn.bugstack.chatgpt.test;

import cn.bugstack.chatgpt.common.Constants;
import cn.bugstack.chatgpt.domain.chat.ChatCompletionRequest;
import cn.bugstack.chatgpt.domain.chat.ChatCompletionResponse;
import cn.bugstack.chatgpt.domain.chat.Message;
import cn.bugstack.chatgpt.session.Configuration;
import cn.bugstack.chatgpt.session.OpenAiSession;
import cn.bugstack.chatgpt.session.OpenAiSessionFactory;
import cn.bugstack.chatgpt.session.defaults.DefaultOpenAiSessionFactory;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 小傅哥，微信：fustack
 * @description 客户端输入测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class ClientTest {

    public static void main(String[] args) throws InterruptedException {
        // 1. 配置文件
        Configuration configuration = new Configuration();
        configuration.setApiHost("https://api.xfg.im/b8b6/");
        configuration.setApiKey("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");
        // 测试时候，需要先获得授权token：http://api.xfg.im:8080/authorize?username=xfg&password=123 - 此地址暂时有效，后续根据课程首页说明获取token；https://t.zsxq.com/0d3o5FKvc
        configuration.setAuthToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4ZmciLCJleHAiOjE2ODQ2MzEwNjAsImlhdCI6MTY4NDYyNzQ2MCwianRpIjoiMGU2M2Q3NDctNDk1YS00NDU3LTk1ZTAtOWVjMzkwNTlkNmQzIiwidXNlcm5hbWUiOiJ4ZmcifQ.xX4kaw-Pz2Jm4LBSvADzijud4nlNLFQUOaN6UgxrK9E");

        // 2. 会话工厂
        OpenAiSessionFactory factory = new DefaultOpenAiSessionFactory(configuration);
        OpenAiSession openAiSession = factory.openSession();

        System.out.println("我是 OpenAI ChatGPT，请输入你的问题：");

        ChatCompletionRequest chatCompletion = ChatCompletionRequest
                .builder()
                .messages(new ArrayList<>())
                .model(ChatCompletionRequest.Model.GPT_3_5_TURBO.getCode())
                .user("testUser01")
                .build();

        // 3. 等待输入
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String text = scanner.nextLine();
            chatCompletion.getMessages().add(Message.builder().role(Constants.Role.USER).content(text).build());
            ChatCompletionResponse chatCompletionResponse = openAiSession.completions(chatCompletion);
            chatCompletion.getMessages().add(Message.builder().role(Constants.Role.USER).content(chatCompletionResponse.getChoices().get(0).getMessage().getContent()).build());
            // 输出结果
            System.out.println(chatCompletionResponse.getChoices().get(0).getMessage().getContent());
            System.out.println("请输入你的问题：");
        }

    }

}
