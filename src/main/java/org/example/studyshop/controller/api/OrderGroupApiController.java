package org.example.studyshop.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.example.studyshop.ifs.CrudInterface;
import org.example.studyshop.model.network.Header;
import org.example.studyshop.model.network.request.OrderGroupApiRequest;
import org.example.studyshop.model.network.response.OrderGroupApiResponse;
import org.example.studyshop.service.OrderGroupApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController implements CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse> {

  @Autowired
  private OrderGroupApiLogicService orderGroupApiLogicService;

  @Override
  @PostMapping("")
  public Header<OrderGroupApiResponse> create(@RequestBody Header<OrderGroupApiRequest> request) {
    log.info("Create OrderGroupApi requst : {}", request);
    return orderGroupApiLogicService.create(request);
  }

  @Override
  @GetMapping("{id}")
  public Header<OrderGroupApiResponse> read(@PathVariable Long id) {
    log.info("Read OrderGroupApi id : {}", id);
    return orderGroupApiLogicService.read(id);
  }

  @Override
  @PutMapping("")
  public Header<OrderGroupApiResponse> update(@RequestBody Header<OrderGroupApiRequest> request) {
    return null;
  }

  @Override
  @DeleteMapping("{id}")
  public Header delete(Long id) {
    return null;
  }
}
