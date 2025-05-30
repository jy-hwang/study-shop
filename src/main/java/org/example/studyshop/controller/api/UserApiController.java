package org.example.studyshop.controller.api;

import org.example.studyshop.ifs.CrudInterface;
import org.example.studyshop.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface {
  @Override
  @PostMapping("") // /api/user
  public Header create() {
    return null;
  }

  @Override
  @GetMapping("{id}") // /api/user/{id}
  public Header read(@PathVariable(name = "id") Long id) {
    return null;
  }

  @Override
  @PutMapping("") // /api/user
  public Header update() {
    return null;
  }

  @Override
  @DeleteMapping("{id}")
  public Header delete(@PathVariable Long id) {
    return null;
  }
}
