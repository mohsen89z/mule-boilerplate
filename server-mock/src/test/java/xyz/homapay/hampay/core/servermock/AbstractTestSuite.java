package xyz.homapay.hampay.core.servermock;

import org.mule.munit.runner.functional.FunctionalMunitSuite;

/**
 * Created by Ebrahim Pasbani.
 */
public class AbstractTestSuite extends FunctionalMunitSuite {
    @Override
    protected boolean haveToDisableInboundEndpoints() {
        return true;
    }

    @Override
    protected boolean haveToMockMuleConnectors() {
        return true;
    }

    @Override
    protected String getConfigResources() {
        return "mule-test-config.xml";
    }
}
