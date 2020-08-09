package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

	@GetMapping("/string")
	public String recibirTexto(@RequestParam(name = "texto",required = false,defaultValue = "Algun valor") String texto,Model model) {
		model.addAttribute("textoRecibido", "El texto recibido es : " +texto );
		model.addAttribute("titulo","Recibir parámetros del Request HTTP GET - URL");
		return "params/recibir";
	}
	
	@GetMapping("/")
	public String enviarTexto(Model model) {
		model.addAttribute("titulo","Enviar parámetros del Request HTTP GET - URL por THYMELEAF");
		return "params/enviar";
	}
	
	
}
