package web.modules;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ModuleController {

    public static HashMap viewModuleMap = new HashMap();
    /*
        Desc : Get View Name.
     */
    public HashMap getViewModule() {
        // TODO How about make jar file from implementation??
        // get Jar file.
        // Just thinking - 2017.07.26

        // Add View name.
        // If you want view name save db.
        viewModuleMap.put("/","getViewModule path '/'<br>This page is root.");
        viewModuleMap.put("/index","getViewModule path '/index'<br>This page is index");
        return viewModuleMap;
    }

    public String getViewName(String viewNameKeyValue){
        return String.valueOf(this.viewModuleMap.get("/"+viewNameKeyValue));
    }
}
