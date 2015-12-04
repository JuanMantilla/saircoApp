/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.utb.softeng.moviesapp.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author William
 */

@Controller
public class PagesController {
    
    private final String apiUrl = "http://localhost:8080/SaircoApp/";
    
    @RequestMapping(value = "/")
    public ModelAndView getHomePage() {
        Map<String, Object> params = new HashMap<>();
        params.put("apiUrl", apiUrl);
        return new ModelAndView("index", params);
    }
    @RequestMapping(value = "/salones/{salonId}")
    public ModelAndView getSalonPage(@PathVariable Long salonId) {
        Map<String, Object> params = new HashMap<>();
        params.put("apiUrl", apiUrl);
        params.put("salonId", salonId);
        return new ModelAndView("salon", params);
    }
}
