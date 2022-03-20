package com.gigatechltd.pim.admin.service.security;

/// Created by taohid on 17 Feb, 2022
/// Email: taohid32@gmail.com
/// Mobile: 01673260344

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

//    private final AuthenticationManager authenticationManager;
//    private final UserDetailsService userDetailsService;
//
//    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

//    public SecurityServiceImpl(AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
//        this.authenticationManager = authenticationManager;
//        this.userDetailsService = userDetailsService;
//    }

    @Override
    public boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || AnonymousAuthenticationToken.class.isAssignableFrom(authentication.getClass())){
            return false;
        }
        return authentication.isAuthenticated();
    }
}