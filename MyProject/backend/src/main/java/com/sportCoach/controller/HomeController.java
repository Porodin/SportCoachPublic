package com.sportCoach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class HomeController {
    @GetMapping
    public Principal getUser(Principal user) {
        return user;
    }
    @GetMapping("/")
    public String home(Principal principal) {
        Map<String, Object> authDetails = (Map<String, Object>) ((OAuth2Authentication) principal)
                .getUserAuthentication()
                .getDetails();

        String userName = (String) authDetails.get("name");

        return "Hey " + userName + ", Welcome to Daily Code Buffer!!";
    }
}
    /*@RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        return "login";
    }
}
        /*@Autowired
        private SocialAuthService authService;

        @RequestMapping(value = "/")
        public String home(Principal principal, Model model) {
                User user = authService.extractUserFromAuthInfo(principal);

                model.addAttribute("user", user);

                return "home";
        }
        @RequestMapping(value = "/login")
        public String login() {
                return "login";
        }

        @RequestMapping(value = "/logout")
        public String logout() {
                return "login";
        }


         */











 //   @GetMapping("/home")
    //public String displayHomePage(Model model, @AuthenticationPrincipal OAuth2User principal) {

        //if (principal != null) {
           // String name = principal.getAttribute("name");
 //           model.addAttribute("name", name);
//        }


        //return "home";
   // }


//Depensencies spring.security.oauth2.client.registration.google.scope=openid,email,profile
//spring.security.oauth2.client.provider.google.token-uri=https://www.googleapis.com/oauth2/v4/token
//spring.security.oauth2.client.provider.google.user-info-uri=https://graph.google.com/me?fields=id,name,email
//spring.security.oauth2.client.registration.google.client-authentication-method=form
