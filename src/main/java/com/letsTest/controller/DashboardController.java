package com.letsTest.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    @ResponseBody
    public void dashboard(HttpServletRequest httpServletRequest, HttpSession session, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        if (authorities != null && authorities.size() > 0) {
            Set<String> roles = authorities.stream().map(auth -> auth.getAuthority()).collect(Collectors.toSet());
            if (roles.contains("Faculty"))
                httpServletResponse.sendRedirect("/faculty");
            else if (roles.contains("Student"))
                httpServletResponse.sendRedirect("/results/dashboard");

        } else {
            httpServletResponse.sendRedirect("/");
        }
    }
}

