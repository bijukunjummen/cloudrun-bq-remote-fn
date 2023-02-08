package org.bk.sample.web;

import org.bk.sample.model.BqRequest;
import org.bk.sample.model.BqResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BqRemoteController {
    @PostMapping("/")
    public ResponseEntity<BqResponse> handle(@RequestBody BqRequest request) {
        List<String> responseElements = new ArrayList<>();
        for (List<String> callElements : request.calls()) {
            responseElements.add(callElements.get(0));
        }
        return ResponseEntity.ok(new BqResponse(responseElements));
    }

}
