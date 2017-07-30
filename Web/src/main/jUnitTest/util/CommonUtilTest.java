package jUnitTest.util;

import org.junit.Assert;
import org.junit.Test;
import util.CommonUtil;

public class CommonUtilTest {

    @Test
    public void isNullString() throws Exception {
        String str = "";
        Assert.assertTrue(CommonUtil.isNullString(str));

        str = "string";
        Assert.assertTrue(!CommonUtil.isNullString(str));

        str = null;
        Assert.assertTrue(!CommonUtil.isNullString(str));

    }

}