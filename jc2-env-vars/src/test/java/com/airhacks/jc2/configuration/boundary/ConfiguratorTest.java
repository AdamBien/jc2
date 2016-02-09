package com.airhacks.jc2.configuration.boundary;

import javax.inject.Inject;
import static junit.framework.Assert.assertNotNull;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author airhacks.com
 */
@RunWith(CdiTestRunner.class)
public class ConfiguratorTest {

    @Inject
    InjectionTargetSupport cut;

    @Test
    public void javaHome() {
        assertNotNull(cut.getJavaHome());
    }

}
