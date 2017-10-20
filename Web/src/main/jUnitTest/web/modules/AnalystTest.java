package jUnitTest.web.modules;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import web.modules.Analyst;
import web.modules.CreateDummy;
import web.modules.db.dto.TableInfo;

import static org.junit.Assert.*;

public class AnalystTest {

    public static final String testQuery = "CREATE TABLE `user` (\n" +
            "      `Host` char(60) COLLATE utf8_bin NOT NULL DEFAULT '',\n" +
            "      `User` char(16) COLLATE utf8_bin NOT NULL DEFAULT '',\n" +
            "      `Password` char(41) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL DEFAULT '',\n" +
            "      `Select_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Insert_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Update_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Delete_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Create_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Drop_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Reload_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Shutdown_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Process_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `File_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Grant_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `References_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Index_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Alter_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Show_db_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Super_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Create_tmp_table_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Lock_tables_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Execute_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Repl_slave_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Repl_client_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Create_view_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Show_view_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Create_routine_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Alter_routine_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Create_user_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Event_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Trigger_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `Create_tablespace_priv` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      `ssl_type` enum('','ANY','X509','SPECIFIED') CHARACTER SET utf8 NOT NULL DEFAULT '',\n" +
            "      `ssl_cipher` blob NOT NULL,\n" +
            "      `x509_issuer` blob NOT NULL,\n" +
            "      `x509_subject` blob NOT NULL,\n" +
            "      `max_questions` int(11) unsigned NOT NULL DEFAULT '0',\n" +
            "      `max_updates` int(11) unsigned NOT NULL DEFAULT '0',\n" +
            "      `max_connections` int(11) unsigned NOT NULL DEFAULT '0',\n" +
            "      `max_user_connections` int(11) unsigned NOT NULL DEFAULT '0',\n" +
            "      `plugin` char(64) COLLATE utf8_bin DEFAULT 'mysql_native_password',\n" +
            "      `authentication_string` text COLLATE utf8_bin,\n" +
            "      `password_expired` enum('N','Y') CHARACTER SET utf8 NOT NULL DEFAULT 'N',\n" +
            "      PRIMARY KEY (`Host`,`User`)\n" +
            "    ) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Users and global privileges'";

    @Test
    public void getColumnList() throws Exception {

    }

    public static void main(String[] args) {
        String dataCheck = "";
        Analyst analyst = new Analyst();
        TableInfo tbInfo = analyst.getTableInfo(testQuery);

        CreateDummy createDummy = new CreateDummy();
        dataCheck = createDummy.makeInsertQuery(tbInfo);
        System.out.println(dataCheck);

    }

}