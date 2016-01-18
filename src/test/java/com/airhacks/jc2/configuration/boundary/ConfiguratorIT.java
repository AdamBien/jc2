package com.airhacks.jc2.configuration.boundary;

import javax.inject.Inject;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author airhacks.com
 */
@RunWith(CdiTestRunner.class)
public class ConfiguratorIT {

    @Inject
    InjectionTargetSupport cut;

    @Test
    public void injectUnknownValue() {
        String value = this.cut.getGreeting();
        assertNull(value);
    }

}
