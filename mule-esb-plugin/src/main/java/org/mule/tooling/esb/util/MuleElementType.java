package org.mule.tooling.esb.util;

import java.util.Arrays;

public enum MuleElementType {
    MESSAGE_SOURCE("abstractMessageSourceType", "inboundEndpointType"),
    MESSAGE_PROCESSOR("abstractMessageProcessorType", "outboundEndpointType"),
    EXCEPTION_STRATEGY("abstractExceptionStrategyType");

    private String[] validTypes;

    MuleElementType(String... validTypes) {
        this.validTypes = validTypes;
    }

    public boolean isValidType(String type) {
        return Arrays.asList(validTypes).contains(type);
    }
}
