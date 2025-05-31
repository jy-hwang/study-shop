package org.example.studyshop.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.example.studyshop.controller.CrudController;
import org.example.studyshop.model.network.request.OrderGroupApiRequest;
import org.example.studyshop.model.network.response.OrderGroupApiResponse;
import org.example.studyshop.service.OrderGroupApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse> {

  @Autowired
  private OrderGroupApiLogicService orderGroupApiLogicService;

  @PostConstruct
  public void init() {
    this.baseService = orderGroupApiLogicService;
  }
}
