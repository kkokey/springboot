package web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import util.CommonUtil;
import web.modules.ModuleController;

@Controller
public class CoreController {
    private Logger logger = LoggerFactory.getLogger(ModuleController.class);

    @Autowired
    public ModuleController moduleController;

    /*
        Desc : Load "/"
     */
    @RequestMapping(value="/")
    public String index(Model model) {
        System.out.println("[[[[[Into the /]]]]]");
        String viewName = moduleController.getViewName("/");
        logger.info(viewName);
        viewName = "index";
        model.addAttribute("header","path \\");
        model.addAttribute("rs","index page");
        return viewName;
    }

    /*
        Desc : Load page
     */
    @RequestMapping(value="{path}")
    public String page(@PathVariable String path, Model model) {
        System.out.println("[[[[[Into the path]]]]]");

        if(CommonUtil.isNullString(path)){
            System.out.println("Path is empty.");
        }else{
            System.out.println("Path is "+path);
        }

        String viewName = moduleController.getViewName(path);
        logger.info(viewName);
        viewName = "index";

        String rs = moduleController.getSelectOne("root");

        model.addAttribute("header","path is ["+path+"]");
        model.addAttribute("rs", rs);
        return viewName;
    }
}
