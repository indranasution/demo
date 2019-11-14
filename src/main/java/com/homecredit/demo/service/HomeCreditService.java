package com.homecredit.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homecredit.demo.dto.Modules;
import com.homecredit.demo.dto.UserMenuRequest;
import com.homecredit.demo.entity.UserMenu;
import com.homecredit.demo.entity.UsersGroup;
import com.homecredit.demo.exception.ResourceNotFoundException;
import com.homecredit.demo.repository.UserMenuRepository;
import com.homecredit.demo.repository.UsersGroupRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HomeCreditService {

    private final UserMenuRepository userMenuRepository;
    private final UsersGroupRepository usersGroupRepository;
    private final ObjectMapper objectMapper;
    private static Integer NUM_USER_ID=40;

    public HomeCreditService(UserMenuRepository userMenuRepository, UsersGroupRepository usersGroupRepository, ObjectMapper objectMapper) {
        this.userMenuRepository = userMenuRepository;
        this.usersGroupRepository = usersGroupRepository;
        this.objectMapper = objectMapper;
    }

    public List<Modules> getUserIdAndModule(Integer userId) throws IOException {
       Optional<UserMenu> userMenu = Optional.ofNullable(userMenuRepository.findByUserId(userId).orElseThrow(() ->
               new ResourceNotFoundException("userMenu", "userId", userId)));
       if(userMenu.isPresent()) {
           return Arrays.asList(objectMapper.readValue(userMenu.get().getUserProperties(), Modules[].class));
       }
       throw new ResourceNotFoundException("userMenu","userId",userId);
    }

    public UserMenu createOrUpdate(UserMenuRequest request,Integer id) {

        Optional<UserMenu> userMenu = userMenuRepository.findByUserId(id);
        Optional<UsersGroup> usersGroup = usersGroupRepository.findByUserType(request.getUserType());
        if(!userMenu.isPresent()) {
            UserMenu menu = UserMenu.builder()
                    .userId(++NUM_USER_ID)
                    .userProperties(usersGroup.map(UsersGroup::getUserTypeProperties).orElse(null))
                    .build();
            userMenuRepository.save(menu);
            return userMenuRepository.findByUserId(menu.getUserId()).get();
        } else {
             userMenu.get().setUserProperties(usersGroup.get().getUserTypeProperties());
             userMenuRepository.save(userMenu.get());
             return userMenu.get();
        }

    }
}
