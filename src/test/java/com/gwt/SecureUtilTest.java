package com.gwt;

import com.gwt.server.utils.SecureUtil;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.gwt.server.utils.SecureUtil.encrypt;
import static org.junit.Assert.assertTrue;

/**
 * @author Sergiy_Solovyov
 */
@RunWith(DataProviderRunner.class)
public class SecureUtilTest {
    @DataProvider
    public static Object[][] data() {
        return new Object[][] {
                { "test1"},
                { "test2"},
                { "test3"},
                { "12345"},
                { "/*+-+"}
        };
    }
    @Test
    @UseDataProvider("data")
    public void testMatches(String password) {
        assertTrue(SecureUtil.matches(password, encrypt(password)));
    }
}
