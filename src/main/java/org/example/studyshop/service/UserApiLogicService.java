package org.example.studyshop.service;

import org.example.studyshop.ifs.CrudInterface;
import org.example.studyshop.model.entity.User;
import org.example.studyshop.model.network.Header;
import org.example.studyshop.model.network.request.UserApiRequest;
import org.example.studyshop.model.network.response.UserApiResponse;
import org.example.studyshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {
  @Autowired
  private UserRepository userRepository;

  /**
   * 1. request data
   * 2. user 생성
   * 3. 생성된 데이터 -> UserApiResponse return
   */
  @Override
  public Header<UserApiResponse> create(Header<UserApiRequest> request) {

    // 1. request data
    UserApiRequest userApiRequest = request.getData();

    // 2. user 생성
    User user = User.builder()
        .account(userApiRequest.getAccount())
        .password(userApiRequest.getPassword())
        .status("REGISTERED")
        .phoneNumber(String.valueOf(userApiRequest.getPhoneNumber()))
        .email(userApiRequest.getEmail())
        .registeredAt(LocalDateTime.now())
        .build();

    User newUser = userRepository.save(user);

    // 3. 생성된 데이터 -> UserApiResponse return
    return response(newUser);
  }

  /**
   * 1. id -> repository getOne or getById
   * 2. user -> userApiResponse return
   */
  @Override
  public Header<UserApiResponse> read(Long id) {

    // id -> repository getOne or getById
    Optional<User> optionalUser = userRepository.findById(id);

    // user -> userApiResponse return
    Header<UserApiResponse> response = optionalUser.map(this::response).orElseGet(() -> Header.ERROR("데이터 없음"));

    //return userRepository.findById(id).map(this::response).orElseGet(() -> Header.ERROR("데이터 없음"))
    return response;
  }

  @Override
  public Header<UserApiResponse> update(Header<UserApiRequest> request) {
    return null;
  }

  @Override
  public Header delete(Long id) {
    return null;
  }

  private Header<UserApiResponse> response(User user) {
    // user -> userApiResponse
    UserApiResponse userApiResponse
        = UserApiResponse.builder()
        .id(user.getId())
        .account(user.getAccount())
        .password(user.getPassword()) // todo 암호화, 길이
        .email(user.getEmail())
        .phoneNumber(user.getPhoneNumber())
        .status(user.getStatus())
        .registeredAt(user.getRegisteredAt())
        .unregisteredAt(user.getUnregisteredAt())
        .build();

    // Header + data return

    return Header.OK(userApiResponse);
  }
}
