package web.modules.db.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.sql.ResultSet;

@Mapper
public interface DbInfoMapper {

    //@Select(value = "select user from mysql.user where user = #{conVal}")
    @Select(value = {"SELECT DISTINCT user FROM mysql.user WHERE user = 'root';" } )
    public ResultSet getSelectOne(String conVal);
}
