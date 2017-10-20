package web.modules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.modules.db.mapper.DbInfoMapper;

import java.sql.ResultSet;
import java.util.HashMap;

@Repository
public class ModuleController {

    private Logger logger = LoggerFactory.getLogger(ModuleController.class);

    @Autowired
    private DbInfoMapper dbInfoMapper;
    private HashMap viewModuleMap;


    public ModuleController() {
        viewModuleMap = new HashMap();
        viewModuleMap.put("/","getViewModule path '/'<br>This page is root.");
        viewModuleMap.put("/index","getViewModule path '/index'<br>This page is index");
    }

    /*
        Desc : Get View Name.
    */
    public void setDefaultData() {
        // TODO How about make jar file from implementation??
        // get Jar file.
        // Just default concept is get view name from db.
        // Just thinking - 2017.07.26

        // Add View name.

    }

    public String getViewName(String viewNameKeyValue){
//        System.out.println("viewNameKeyValue ["+viewNameKeyValue+"]");
//        System.out.println("viewModuleMap:::START");
//        System.out.println(viewModuleMap);
//        System.out.println("viewModuleMap:::END");

        if(String.valueOf(viewModuleMap.get("/"+viewNameKeyValue)).equals("") || viewNameKeyValue.equals("/")){
            return String.valueOf(viewModuleMap.get("/"));
        }
        return String.valueOf(viewModuleMap.get("/"+viewNameKeyValue));
    }

    public String getSelectOne(String conVal){
        String rsStr = "";
        try {
            ResultSet rs = dbInfoMapper.getSelectOne(conVal);
            logger.info(String.valueOf(rs));
            rsStr = rs.getString(0);
        }catch (Exception e){
            logger.error("error: ",e.getMessage());
        }

        return rsStr;
    }
}
