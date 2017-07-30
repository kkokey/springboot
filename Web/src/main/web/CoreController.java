package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.modules.ModuleController;

@RestController
public class CoreController {

    @Autowired
    @Qualifier("moduleController")
    private ModuleController moduleController;

    /*
        Desc : Load /
     */
    @RequestMapping(value="/")
    public String index(@PathVariable String path) {
        return moduleController.getViewName("/");
    }

    /*
        Desc : Load page
     */
    @RequestMapping(value="/{path}")
    public String page(@PathVariable String path) {

        if(path.isEmpty()){
            System.out.println("Path is empty.");
        }else{
            System.out.println("Path is "+path);
        }

        return moduleController.getViewName(path);
    }
}
