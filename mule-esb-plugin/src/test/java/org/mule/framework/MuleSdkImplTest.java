package org.mule.framework;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.mule.tooling.esb.sdk.MuleSdk;

public class MuleSdkImplTest {

    @Test
    public void detectCorrectVersion(){
        final MuleSdk muleSdk = new MuleSdk("/tmp/mule-distro/mule-enterprise-standalone-3.8.0-SNAPSHOT");
        final String version = muleSdk.getVersion();
        Assert.assertThat(version, CoreMatchers.is("3.8.0"));
    }
}
