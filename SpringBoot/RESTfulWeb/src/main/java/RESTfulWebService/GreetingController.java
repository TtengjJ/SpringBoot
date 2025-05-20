package RESTfulWebService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    // 定义一个GET请求，路径为/greeting
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        // 定义一个Greeting类型的返回值，参数为name，默认值为World
        if (name == null || name.trim().isEmpty()) {
            // 如果name为空，抛出异常
            throw new IllegalArgumentException("Name parameter cannot be empty");
        }
        // 返回一个Greeting对象，参数为counter自增后的值和格式化后的字符串
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
