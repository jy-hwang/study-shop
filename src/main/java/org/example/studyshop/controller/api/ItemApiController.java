package org.example.studyshop.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.example.studyshop.ifs.CrudInterface;
import org.example.studyshop.model.network.Header;
import org.example.studyshop.model.network.request.ItemApiRequest;
import org.example.studyshop.model.network.response.ItemApiResponse;
import org.example.studyshop.service.ItemApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/item")
public class ItemApiController implements CrudInterface<ItemApiRequest, ItemApiResponse> {

  @Autowired
  private ItemApiLogicService itemApiLogicService;

  @Override
  @PostMapping("") // /api/item
  public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
    log.info("Create Item request: {}", request);
    return itemApiLogicService.create(request);
  }

  @Override
  @GetMapping("{id}") // /api/item/1 ... 1000
  public Header<ItemApiResponse> read(@PathVariable Long id) {
    log.info("Read Item by id: {}", id);
    return itemApiLogicService.read(id);
  }

  @Override
  @PutMapping("") // /api/item
  public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {
    log.info("Update Item request: {}", request);
    return itemApiLogicService.update(request);
  }

  @Override
  @DeleteMapping("{id}") // /api/item
  public Header delete(@PathVariable Long id) {
    log.info("Delete Item by id: {}", id);
    return itemApiLogicService.delete(id);
  }
}
