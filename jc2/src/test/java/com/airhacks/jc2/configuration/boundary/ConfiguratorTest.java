package com.airhacks.jc2.configuration.boundary;

import javax.inject.Inject;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
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

    @Test
    public void customNamedValue() {
        String actual = this.cut.getWithCustomKey();
        assertThat(actual, is(TestPreloader.CUSTOM_EXPECTED));

    }

    @Test
    public void intValue() {
        assertThat(this.cut.getIntValue(), is(21));
    }

    @Test
    public void longValue() {
        assertThat(this.cut.getLongValue(), is(42l));
    }

    @Test
    public void booleanValue() {
        assertTrue(this.cut.isBooleanValue());
    }

    @Test
    public void notExistingBoolean() {
        assertFalse(this.cut.isNotExistingBoolean());
    }

    @Test
    public void notExistingInteger() {
        assertThat(this.cut.getNotExistingInt(), is(0));
    }

    @Test
    public void notExistingLong() {
        assertThat(this.cut.getNotExistingLong(), is(0l));
    }

    public void notExistingString() {
        assertNull(this.cut.getNotExistingString());
    }

}
