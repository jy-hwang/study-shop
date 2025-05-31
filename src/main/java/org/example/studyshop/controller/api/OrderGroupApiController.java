package org.example.studyshop.controller.api;

import org.example.studyshop.controller.CrudController;
import org.example.studyshop.model.entity.OrderGroup;
import org.example.studyshop.model.network.request.OrderGroupApiRequest;
import org.example.studyshop.model.network.response.OrderGroupApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {

}
