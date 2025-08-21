package com.chatapplication.chatapplication.userService.internals;


import com.chatapplication.chatapplication.userService.UserCreateOrUpdate;
import com.chatapplication.chatapplication.userService.UserServiceAPI;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserServiceAPI {

    private final UserRepository userRepository;
    private final EntityManager entityManager;

    public UserService(UserRepository userRepository, EntityManager entityManager) {
        this.userRepository = userRepository;
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void createOrUpdate(UserCreateOrUpdate user) {
        Optional<UserEntity> optionalUser = userRepository.findBySub(user.sub());

        if (optionalUser.isPresent()) {
            UserEntity userEntity = optionalUser.get();
            userEntity.setEmail(user.email());
            userEntity.setUserName(user.username());
        } else {
            UserEntity userEntity = UserEntity.builder()
                    .sub(user.sub())
                    .email(user.email())
                    .userName(user.username())
                    .build();

            entityManager.persist(userEntity);
        }
    }
}
