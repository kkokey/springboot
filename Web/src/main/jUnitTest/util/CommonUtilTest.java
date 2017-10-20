package jUnitTest.util;

import junit.framework.TestCase;
import org.junit.Assert;
import util.CommonUtil;

public class CommonUtilTest extends TestCase {
    @org.junit.Test
    public void isNullString1() throws Exception {
        String str = "";

        Assert.assertTrue(CommonUtil.isNullString(str));

        str = "string";
        Assert.assertTrue(!CommonUtil.isNullString(str));

        str = null;
        Assert.assertTrue(!CommonUtil.isNullString(str));
    }


}