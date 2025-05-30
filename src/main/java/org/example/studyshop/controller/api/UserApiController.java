package org.example.studyshop.controller.api;

import org.example.studyshop.ifs.CrudInterface;
import org.example.studyshop.model.network.Header;
import org.example.studyshop.model.network.request.UserApiRequest;
import org.example.studyshop.model.network.response.UserApiResponse;
import org.example.studyshop.service.UserApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

  @Autowired
  private UserApiLogicService userApiLogicService;

  @Override
  @PostMapping("") // /api/user
  public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> userApiRequest) {
    return userApiLogicService.create(userApiRequest);
  }

  @Override
  @GetMapping("{id}") // /api/user/{id}
  public Header<UserApiResponse> read(@PathVariable(name = "id") Long id) {
    return null;
  }

  @Override
  @PutMapping("") // /api/user
  public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> userApiRequest) {
    return null;
  }

  @Override
  @DeleteMapping("{id}")
  public Header delete(@PathVariable Long id) {
    return null;
  }
}
