package org.example.studyshop.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.example.studyshop.controller.CrudController;
import org.example.studyshop.model.network.request.UserApiRequest;
import org.example.studyshop.model.network.response.UserApiResponse;
import org.example.studyshop.service.UserApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse> {

  @Autowired
  private UserApiLogicService userApiLogicService;

  @PostConstruct
  public void init() {
    this.baseService = userApiLogicService;
  }
}
