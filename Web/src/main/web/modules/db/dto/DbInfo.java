package web.modules.db.dto;

import org.springframework.stereotype.Repository;

@Repository
public class DbInfo {

    private String name;
    private String user;

    public DbInfo() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
