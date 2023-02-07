package org.bk.sample.model;

import java.util.List;

public record BqResponse(String errorMessage, List<String> replies) {

    public BqResponse(List<String> replies) {
        this(null, replies);
    }
}
