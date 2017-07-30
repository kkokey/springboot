package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.CommonUtil;
import web.modules.ModuleController;

@RestController
public class CoreController {

    @Autowired
    @Qualifier("moduleController")
    public static ModuleController moduleController = new ModuleController();

    /*
        Desc : Load "/"
     */
    @RequestMapping(value="/")
    public String index() {
        return moduleController.getViewName("/");
    }

    /*
        Desc : Load page
     */
    @RequestMapping(value="{path}")
    public String page(@PathVariable String path) {

        if(CommonUtil.isNullString(path)){
            System.out.println("Path is empty.");
        }else{
            System.out.println("Path is "+path);
        }

        return moduleController.getViewName(path);
    }
}
