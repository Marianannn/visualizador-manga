package com.manga.visualizador_manga.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class WelcomeController {
    @GetMapping("/")
    public String welcome(){
        return "Bem vindeeeeee esse é um site que visa ser um visualizador de mangás, quadrinhos e webtoons, mas principalmente mangás!";
    }

}
