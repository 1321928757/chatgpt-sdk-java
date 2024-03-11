# ChatGPT大模型开放SDK - By 刘仕杰

为了让研发伙伴更快，更方便的接入使用Openai的大模型。从而开发的 chatgpt-sdk-java 也欢迎👏🏻大家基于openai开放api接口补充需要的功能。

此SDK设计，以 Session 会话模型，提供会话工厂🏭创建服务会话。代码非常清晰，易于扩展、易于维护。

---

>**作者**：LuckySJ-刘仕杰 - 在线演示地址 [**www.luckysj.online**](https://www.luckysj.online/)

## 👣目录

1. 组件配置
2. 功能测试
   1. 代码执行 - `使用：代码的方式主要用于程序接入`
3. 程序接入

## 1. 组件配置

- 申请ApiKey：可以去OpenAI官网注册申请开通，也可到某宝购买key
- 运行环境：JDK 1.8+
- maven pom - `未推送到Maven中央仓库，需要下载代码本地 install 后使用`

## 2. 功能测试

### 2.1 代码执行

```java
@Slf4j
public class ApiTest {

    private OpenAiSession openAiSession;

    @Before
    public void test_OpenAiSessionFactory() {
        // 1. 配置文件 [联系小傅哥获取key]
        // 1.1 官网原始 apiHost https://api.openai.com/ - 官网的Key可直接使用
        // 1.2 三方公司 apiHost https://pro-share-aws-api.zcyai.com/  不能用就换其他地址
        Configuration configuration = new Configuration();
        configuration.setApiHost("https://pro-share-aws-api.zcyai.com/");
        configuration.setApiKey("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");
        // 2. 会话工厂
        OpenAiSessionFactory factory = new DefaultOpenAiSessionFactory(configuration);
        // 3. 开启会话
        this.openAiSession = factory.openSession();
    }

    /**
     * 【常用对话模式，推荐使用此模型进行测试】
     * 此对话模型 3.5/4.0 接近于官网体验 & 流式应答
     */
    @Test
    public void test_chat_completions_stream_channel() throws JsonProcessingException, InterruptedException {
        // 1. 创建参数
        ChatCompletionRequest chatCompletion = ChatCompletionRequest
                .builder()
                .stream(true)
                .messages(Collections.singletonList(Message.builder().role(Constants.Role.USER).content("1+1").build()))
                .model(ChatCompletionRequest.Model.GPT_3_5_TURBO.getCode())
                .maxTokens(1024)
                .build();

        // 2. 用户配置 【可选参数，支持不同渠道的 apiHost、apiKey】- 方便给每个用户都分配了自己的key，用于售卖场景
        String apiHost = "https://pro-share-aws-api.zcyai.com/";
        String apiKey = "sk-b0A0eSKTNxgBqrHv7aAa0808EdB849C89499D928648bD416";

        // 3. 发起请求
        EventSource eventSource = openAiSession.chatCompletions(apiHost, apiKey, chatCompletion, new EventSourceListener() {
            @Override
            public void onEvent(EventSource eventSource, String id, String type, String data) {
                log.info("测试结果 id:{} type:{} data:{}", id, type, data);
            }

            @Override
            public void onFailure(EventSource eventSource, Throwable t, Response response) {
                log.error("失败 code:{} message:{}", response.code(), response.message());
            }
        });
        // 等待
        new CountDownLatch(1).await();
    }

    /**
     * 【常用对话模式，推荐使用此模型进行测试】
     * 此对话模型 3.5/4.0 接近于官网体验 & 流式应答
     */
    @Test
    public void test_chat_completions_stream() throws JsonProcessingException, InterruptedException {
        // 1. 创建参数
        ChatCompletionRequest chatCompletion = ChatCompletionRequest
                .builder()
                .stream(true)
                .messages(Collections.singletonList(Message.builder().role(Constants.Role.USER).content("1+1").build()))
                .model(ChatCompletionRequest.Model.GPT_3_5_TURBO.getCode())
                .maxTokens(1024)
                .build();

        // 2. 发起请求
        EventSource eventSource = openAiSession.chatCompletions(chatCompletion, new EventSourceListener() {
            @Override
            public void onEvent(EventSource eventSource, String id, String type, String data) {
                log.info("测试结果 id:{} type:{} data:{}", id, type, data);
            }

            @Override
            public void onFailure(EventSource eventSource, Throwable t, Response response) {
                log.error("失败 code:{} message:{}", response.code(), response.message());
            }
        });

        // 等待
        new CountDownLatch(1).await();
    }


    /**
     * 简单问答模式
     */
    @Test
    public void test_qa_completions() throws JsonProcessingException {
        QACompletionResponse response01 = openAiSession.completions("您好");
        log.info("测试结果：{}", new ObjectMapper().writeValueAsString(response01.getChoices()));
    }

    /**
     * 简单问答模式 * 流式应答
     */
    @Test
    public void test_qa_completions_stream() throws JsonProcessingException, InterruptedException {
        // 1. 创建参数
        QACompletionRequest request = QACompletionRequest
                .builder()
                .prompt("写个java冒泡排序")
                .stream(true)
                .build();

        for (int i = 0; i < 1; i++) {
            // 2. 发起请求
            EventSource eventSource = openAiSession.completions(request, new EventSourceListener() {
                @Override
                public void onEvent(EventSource eventSource, String id, String type, String data) {
                    log.info("测试结果：{}", data);
                }
            });
        }

        // 等待
        new CountDownLatch(1).await();
    }

    /**
     * 此对话模型 3.5 接近于官网体验
     */
    @Test
    public void test_chat_completions() {
        // 1. 创建参数
        ChatCompletionRequest chatCompletion = ChatCompletionRequest
                .builder()
                .messages(Collections.singletonList(Message.builder().role(Constants.Role.USER).content("写一个java冒泡排序").build()))
                .model(ChatCompletionRequest.Model.GPT_3_5_TURBO.getCode())
                .build();
        // 2. 发起请求
        ChatCompletionResponse chatCompletionResponse = openAiSession.completions(chatCompletion);
        // 3. 解析结果
        chatCompletionResponse.getChoices().forEach(e -> {
            log.info("测试结果：{}", e.getMessage());
        });
    }

    /**
     * 上下文对话
     */
    @Test
    public void test_chat_completions_context() {
        // 1-1. 创建参数
        ChatCompletionRequest chatCompletion = ChatCompletionRequest
                .builder()
                .messages(new ArrayList<>())
                .model(ChatCompletionRequest.Model.GPT_3_5_TURBO.getCode())
                .user("testUser01")
                .build();
        // 写入请求信息
        chatCompletion.getMessages().add(Message.builder().role(Constants.Role.USER).content("写一个java冒泡排序").build());

        // 1-2. 发起请求
        ChatCompletionResponse chatCompletionResponse01 = openAiSession.completions(chatCompletion);
        log.info("测试结果：{}", chatCompletionResponse01.getChoices());

        // 写入请求信息
        chatCompletion.getMessages().add(Message.builder().role(Constants.Role.USER).content(chatCompletionResponse01.getChoices().get(0).getMessage().getContent()).build());
        chatCompletion.getMessages().add(Message.builder().role(Constants.Role.USER).content("换一种写法").build());

        ChatCompletionResponse chatCompletionResponse02 = openAiSession.completions(chatCompletion);
        log.info("测试结果：{}", chatCompletionResponse02.getChoices());
    }

    /**
     * 文本修复
     */
    @Test
    public void test_edit() {
        // 文本请求
        EditRequest textRequest = EditRequest.builder()
                .input("码农会锁")
                .instruction("帮我修改错字")
                .model(EditRequest.Model.TEXT_DAVINCI_EDIT_001.getCode()).build();
        EditResponse textResponse = openAiSession.edit(textRequest);
        log.info("测试结果：{}", textResponse);

        // 代码请求
        EditRequest codeRequest = EditRequest.builder()
                // j <= 10 应该修改为 i <= 10
                .input("for (int i = 1; j <= 10; i++) {\n" +
                        "    System.out.println(i);\n" +
                        "}")
                .instruction("这段代码执行时报错，请帮我修改").model(EditRequest.Model.CODE_DAVINCI_EDIT_001.getCode()).build();
        EditResponse codeResponse = openAiSession.edit(codeRequest);
        log.info("测试结果：{}", codeResponse);
    }

    /**
     * 生成图片
     */
    @Test
    public void test_genImages() {
        // 方式1，简单调用
        ImageResponse imageResponse01 = openAiSession.genImages("画一个996加班的程序员");
        log.info("测试结果：{}", imageResponse01);

//        // 方式2，调参调用
//        ImageResponse imageResponse02 = openAiSession.genImages(ImageRequest.builder()
//                .prompt("画一个996加班的程序员")
//                .size(ImageEnum.Size.size_256.getCode())
//                .responseFormat(ImageEnum.ResponseFormat.B64_JSON.getCode()).build());
//        log.info("测试结果：{}", imageResponse02);
    }

}
```


## 3. 程序接入

SpringBoot 配置类

```java
@Configuration
@EnableConfigurationProperties(ChatGPTSDKConfigProperties.class)
public class ChatGPTSDKConfig {
    @Bean(name = "chatGPTOpenAiSession")
    @ConditionalOnProperty(value = "chatgpt.sdk.config.enabled", havingValue = "true", matchIfMissing = false)
    public OpenAiSession openAiSession(ChatGPTSDKConfigProperties properties) {
        // 1. 配置文件
        configuration = new Configuration();
        configuration.setApiHost(properties.getApiHost());
        configuration.setAuthToken(properties.getAuthToken());
        configuration.setApiKey(properties.getApiKey());

        // 2. 会话工厂
        OpenAiSessionFactory factory = new DefaultOpenAiSessionFactory(configuration);

        // 3. 开启会话
        return factory.openSession();
    }
}

@Data
@ConfigurationProperties(prefix = "chatgpt.sdk.config", ignoreInvalidFields = true)
public class ChatGPTSDKConfigProperties {
    /** openai 代理地址 */
    private String apiHost;
    /** apikey，*/
    private String apiKey;
    /** 验证tokne（这里暂时用不到，openai不需要，如果需要中转服务进行会话前认证可以使用该字段） */
    private String authToken;
}

```

```java
@Autowired(required = false)
private OpenAiSession openAiSession;
```

- 注意：如果你在服务中配置了关闭启动 ChatGPT SDK 那么注入 openAiSession 为 null

yml 配置

```pom
# ChatGLM SDK Config
chatgpt:
  sdk:
    config:
      # 状态；true = 开启、false 关闭
      enabled: true
      # 官网地址 https://api.openai.com/,国内代理地址 https://api.openai-proxy.com/
#      api-host: https://api.openai.com/
      api-host: https://api.openai-proxy.com/
      # 官网申请 https://platform.openai.com/account/api-keys
      api-key: sk-cRdJvyq123123
      # 认证token，这个配置暂时没用到，假如自己搭建了gpt的代理转发地址，而不想让这代理网站公开使用，就可以加一层token校验，限制使用
      auth-token: 123123


