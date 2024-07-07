package org.example.studyshop.controller;

import org.example.studyshop.model.SearchParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostController {

    @PostMapping(value = "/postMethod")//, produces = {"application/json"})
    public SearchParam postMethod(@RequestBody SearchParam searchParam) {
        return searchParam;
    }

}
