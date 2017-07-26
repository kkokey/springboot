package web.modules;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ControllerModule {

    public HashMap getViewModule() {
        // TODO How about make jar file from implementation??
        // get Jar file.
        // Just thinking - 2017.07.26

        HashMap viewModuleMap = new HashMap();

        viewModuleMap.put("//","getViewModule path '/' index page.");
        return viewModuleMap;
    }
}
