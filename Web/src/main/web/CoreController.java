package web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoreController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
