/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utb.softeng.moviesapp.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author William
 */
@Controller
@RequestMapping("/user")
public class AuthController {

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> user(@AuthenticationPrincipal UserDetails user) {
        
        Map<String, Object> details = new HashMap<>();
        if (user != null) {
            details.put("name", user.getUsername());
            details.put("roles", user.getAuthorities());
        }
        return details;

    }
    @RequestMapping(value = {"/isLoggedIn"}, method = RequestMethod.GET)
    public @ResponseBody Object isLoggedIn() {
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user instanceof UserDetails;
    }

}
