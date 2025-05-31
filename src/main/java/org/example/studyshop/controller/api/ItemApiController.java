package org.example.studyshop.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.example.studyshop.controller.CrudController;
import org.example.studyshop.model.network.request.ItemApiRequest;
import org.example.studyshop.model.network.response.ItemApiResponse;
import org.example.studyshop.service.ItemApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse> {

  @Autowired
  private ItemApiLogicService itemApiLogicService;

  @PostConstruct
  public void init() {
    this.baseService = itemApiLogicService;
  }
}
