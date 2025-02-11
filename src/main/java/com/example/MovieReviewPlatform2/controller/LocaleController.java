package com.example.MovieReviewPlatform2.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class LocaleController {

    @PostMapping("/locate")
    public String changeLocale(@RequestParam("lang") String language,
                               @RequestHeader(value = "Referer", required = false) String referer,
                               @SessionAttribute(value = "lang", required = false) String currentLang,
                               RedirectAttributes redirectAttributes,
                               @AuthenticationPrincipal UserDetails userDetails) {

        if (currentLang == null || !currentLang.equals(language)) {
            redirectAttributes.addFlashAttribute("lang", language);
        }
        String redirectUrl = (referer != null) ? referer : "/login";
        return "redirect:" + redirectUrl;
    }
}
