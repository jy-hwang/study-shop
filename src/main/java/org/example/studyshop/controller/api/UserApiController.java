package org.example.studyshop.controller.api;

import org.example.studyshop.controller.CrudController;
import org.example.studyshop.model.entity.User;
import org.example.studyshop.model.network.request.UserApiRequest;
import org.example.studyshop.model.network.response.UserApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse, User> {

}
