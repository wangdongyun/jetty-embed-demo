package contorller.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wang.dongyun  on 2018/2/8.
 */
@Controller
public class SampleController {

    @RequestMapping("/hello")
    @ResponseBody
    public String helloword() {
        return "hello world";
    }

    @RequestMapping("/world")
    @ResponseBody
    public String wordHello() {
        return " world hello";
    }
}
