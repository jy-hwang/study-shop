package org.example.studyshop.service;

import org.example.studyshop.model.entity.Partner;
import org.example.studyshop.model.network.Header;
import org.example.studyshop.model.network.request.PartnerApiRequest;
import org.example.studyshop.model.network.response.PartnerApiResponse;
import org.example.studyshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartnerApiLogicService extends BaseService<PartnerApiRequest, PartnerApiResponse, Partner> {

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public Header<PartnerApiResponse> create(Header<PartnerApiRequest> request) {
    PartnerApiRequest body = request.getData();

    Partner partner
        = Partner.builder()
        .name(body.getName())
        .status(body.getStatus())
        .address(body.getAddress())
        .callCenter(body.getCallCenter())
        .partnerNumber(body.getPartnerNumber())
        .businessNumber(body.getBusinessNumber())
        .ceoName(body.getCeoName())
        .registeredAt(body.getRegisteredAt())
        .unregisteredAt(body.getUnregisteredAt())
        .build();

    Partner newPartner = baseRepository.save(partner);

    return response(newPartner);
  }

  @Override
  public Header<PartnerApiResponse> read(Long id) {

    return baseRepository.findById(id)
        .map(this::response)
        .orElseGet(() -> Header.ERROR("데이터 없음"));
  }

  @Override
  public Header<PartnerApiResponse> update(Header<PartnerApiRequest> request) {
    PartnerApiRequest body = request.getData();

    return baseRepository.findById(body.getId())
        .map(entityItem -> {
          entityItem
              .setName(body.getName())
              .setStatus(body.getStatus())
              .setAddress(body.getAddress())
              .setCallCenter(body.getCallCenter())
              .setPartnerNumber(body.getPartnerNumber())
              .setBusinessNumber(body.getBusinessNumber())
              .setCeoName(body.getCeoName())
              .setRegisteredAt(body.getRegisteredAt())
              .setUnregisteredAt(body.getUnregisteredAt())
              .setCategory(categoryRepository.getOne(body.getCategoryId()));

          return entityItem;
        })
        .map(newEntityItem -> baseRepository.save(newEntityItem))
        .map(this::response)
        .orElseGet(() -> Header.ERROR("데이터 없음"));
  }

  @Override
  public Header delete(Long id) {
    return baseRepository.findById(id)
        .map(item -> {
          baseRepository.delete(item);
          return Header.OK();
        })
        .orElseGet(() -> Header.ERROR("데이터 없음"));
  }

  private Header<PartnerApiResponse> response(Partner partner) {
    PartnerApiResponse body
        = PartnerApiResponse.builder()
        .id(partner.getId())
        .name(partner.getName())
        .status(partner.getStatus())
        .address(partner.getAddress())
        .callCenter(partner.getCallCenter())
        .partnerNumber(partner.getPartnerNumber())
        .businessNumber(partner.getBusinessNumber())
        .ceoName(partner.getCeoName())
        .registeredAt(partner.getRegisteredAt())
        .unregisteredAt(partner.getUnregisteredAt())
        .categoryId(partner.getCategory().getId())
        .build();

    return Header.OK(body);
  }
}
