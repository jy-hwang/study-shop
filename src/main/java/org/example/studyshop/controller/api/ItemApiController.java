package org.example.studyshop.controller.api;

import org.example.studyshop.ifs.CrudInterface;
import org.example.studyshop.model.network.Header;
import org.example.studyshop.model.network.request.ItemApiRequest;
import org.example.studyshop.model.network.response.ItemApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/item")
public class ItemApiController implements CrudInterface<ItemApiRequest, ItemApiResponse> {

  @Override
  @PostMapping("") // /api/item
  public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
    return null;
  }

  @Override
  @GetMapping("{id}") // /api/item/1 ... 1000
  public Header<ItemApiResponse> read(@PathVariable Long id) {
    return null;
  }

  @Override
  @PutMapping("") // /api/item
  public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {
    return null;
  }

  @Override
  @DeleteMapping("{id}") // /api/item
  public Header delete(@PathVariable Long id) {
    return null;
  }
}
