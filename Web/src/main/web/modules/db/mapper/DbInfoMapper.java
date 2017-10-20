package web.modules.db.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;

@Mapper
@Repository
public interface DbInfoMapper {

    //@Select(value = "select user from mysql.user where user = #{conVal}")
    @Select(value = {"SELECT DISTINCT user FROM mysql.user WHERE user = 'root' limit 1;" } )
    public ResultSet getSelectOne(String conVal);
}
