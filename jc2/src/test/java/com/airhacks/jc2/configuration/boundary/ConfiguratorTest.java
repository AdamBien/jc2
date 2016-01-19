package com.airhacks.jc2.configuration.boundary;

import javax.inject.Inject;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 *
 * @author airhacks.com
 */
@RunWith(CdiTestRunner.class)
public class ConfiguratorTest {

    @Inject
    InjectionTargetSupport cut;

    @Inject
    TestPreloader testPreloader;

    @Test
    public void injectUnknownValue() {
        String value = this.cut.getGreeting();
        assertNull(value);
    }

    @Test
    public void injectConfiguredValue() {
        String actual = this.cut.getConfigured();
        assertThat(actual, is(TestPreloader.EXPECTED));
    }

}
