package com.wty;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;
import io.github.yedaxia.apidocs.plugin.markdown.MarkdownDocPlugin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TODO
 *
 * @author wty
 * @date 2021 /3/14 21:57
 */
@SpringBootApplication
public class JapiDocsApplication {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(JapiDocsApplication.class,args);
        createDoc();

    }

    public static void createDoc(){
        DocsConfig config = new DocsConfig();
        config.setProjectPath("E:\\自主项目\\springboot-course\\springboot-api\\springboot-JapiDocs"); // 项目根目录
        config.setProjectName("springboot-JapiDocs"); // 项目名称
        config.setApiVersion("V1.0");       // 声明该API的版本
        config.setDocsPath("E:\\test"); // 生成API 文档所在目录
        config.setAutoGenerate(Boolean.TRUE);  // 配置自动生成
        config.addPlugin(new MarkdownDocPlugin());//导出格式
        Docs.buildHtmlDocs(config); // 执行生成文档
    }
}
