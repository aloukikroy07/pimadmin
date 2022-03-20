package com.gigatechltd.pim.admin.service.security;

import com.gigatechltd.pim.admin.model.NavViewModel;
import com.gigatechltd.pim.admin.model.MenuPermissionModel;
import com.gigatechltd.pim.admin.model.UserModel;
import com.gigatechltd.pim.admin.repository.MenuPermissionRepository;
import com.gigatechltd.pim.admin.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LoggedUserDetails implements UserDetailsService {

    private final UserRepository userRepository;
    private final MenuPermissionRepository menuPermissionRepository;
    private final HttpSession session;

    public LoggedUserDetails(UserRepository userRepository, MenuPermissionRepository menuPermissionRepository, HttpSession httpSession) {
        this.userRepository = userRepository;
        this.session = httpSession;
        this.menuPermissionRepository = menuPermissionRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserModel userModel = userRepository.findByEmail(email);
        if (userModel == null || userModel.getStatus() != 1) throw new UsernameNotFoundException(email);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        for (Role role : user.getRoles()){
//            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
        setUserDataToSession(userModel);
        return new User(userModel.getName(), userModel.getPassword(), grantedAuthorities);

    }

    private void setUserDataToSession(@NotNull UserModel userModel) {

        List<MenuPermissionModel> menuPermissionModels = menuPermissionRepository.findAllByRoleIdOrderByMenuId(userModel.getRoleId());
        List<NavViewModel> navViewModels = new ArrayList<>();
        menuPermissionModels.stream().filter(rolePermissionModel -> Objects.equals(rolePermissionModel.getMenuModel().getMenuType(), "P") && rolePermissionModel.getMenuModel().getStatus() == 1).forEach(rolePermissionModel -> {
            NavViewModel parentModel = new NavViewModel(rolePermissionModel);
            List<MenuPermissionModel> child = menuPermissionModels.stream().filter(childModel -> childModel.getMenuModel().getMenuType().equals("S")  && childModel.getMenuModel().getStatus() == 1 && childModel.getMenuModel().getMenuGroup().equals(parentModel.getMenuModel().getMenuGroup())).collect(Collectors.toList());
            if (!child.isEmpty()) {
                parentModel.setGroupMenu(true);
                parentModel.setChild(child);
            }
            navViewModels.add(parentModel);
        });


        session.setAttribute("userId", userModel.getId());
        session.setAttribute("userName", userModel.getName());
        session.setAttribute("userRole", userModel.getRoleModel());
        session.setAttribute("userPermissions", navViewModels);
    }
}
