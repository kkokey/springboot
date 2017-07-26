package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.modules.ControllerModule;

import java.util.HashMap;

@RestController
public class CoreController {

    @Autowired
    @Qualifier("controllerModule")
    private ControllerModule controllerModule;

    @RequestMapping("/")
    public String index() {
        HashMap viewModule = controllerModule.getViewModule();

        String rsViewStr = String.valueOf(viewModule.get("//"));
        return rsViewStr;
    }
}
