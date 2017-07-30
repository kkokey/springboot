package web.modules;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ModuleController {

    public static HashMap viewModuleMap = new HashMap();

    public ModuleController() {
        getViewModule();
        System.out.println(viewModuleMap);
    }

    /*
        Desc : Get View Name.
    */
    public HashMap getViewModule() {
        // TODO How about make jar file from implementation??
        // get Jar file.
        // Just thinking - 2017.07.26

        // Add View name.
        // If you want view name save db.
        this.viewModuleMap.put("/","getViewModule path '/'<br>This page is root.");
        this.viewModuleMap.put("/index","getViewModule path '/index'<br>This page is index");
        return viewModuleMap;
    }

    public String getViewName(String viewNameKeyValue){
        System.out.println("viewNameKeyValue ["+viewNameKeyValue+"]");

        if(String.valueOf(this.viewModuleMap.get("/"+viewNameKeyValue)).equals("") || viewNameKeyValue.equals("/")){
            return String.valueOf(this.viewModuleMap.get("/"));
        }
        return String.valueOf(this.viewModuleMap.get("/"+viewNameKeyValue));
    }
}
