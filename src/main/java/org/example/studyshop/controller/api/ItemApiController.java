package org.example.studyshop.controller.api;

import org.example.studyshop.controller.CrudController;
import org.example.studyshop.model.entity.Item;
import org.example.studyshop.model.network.request.ItemApiRequest;
import org.example.studyshop.model.network.response.ItemApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {

}
