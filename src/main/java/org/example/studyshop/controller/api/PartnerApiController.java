package org.example.studyshop.controller.api;

import org.example.studyshop.controller.CrudController;
import org.example.studyshop.model.entity.Partner;
import org.example.studyshop.model.network.request.PartnerApiRequest;
import org.example.studyshop.model.network.response.PartnerApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse, Partner> {

}
