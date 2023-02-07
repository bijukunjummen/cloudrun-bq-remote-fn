package org.bk.sample.model;

import java.util.List;
import java.util.Map;

public record BqRequest(
        String requestId,
        String caller,
        String sessionUser,
        Map<String, String> userDefinedContext,
        List<List<String>> calls
) {
}
