package spring_hello_test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class Application {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
              return "Hello World!";
            }
        };
    }

  public static void main(String[] args) {
      ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);//解析配置文件
      MessagePrinter printer = context.getBean(MessagePrinter.class);//获取bean的id
      printer.printMessage();
  }
}
