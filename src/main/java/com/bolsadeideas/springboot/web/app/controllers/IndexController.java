package com.bolsadeideas.springboot.web.app.controllers;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
//Controller : Anotacion de tipo controlador 
//Hace que el Component Scan lo escanee y haga la Inversion de Control
//en el Application Context diciendole
//que es un controller y hace el IOC como un bean mas
@RequestMapping("/app")
//Esta anotacion hace que nuestra ruta en el navegador para ingresar a las demas 
//rutas, tienen que pasar primero por esta
//ejemplo : localhost:8080/app/index
public class IndexController {
	
	//Ahora vamos a pasar datos del controlador a la vista
	//con Model
	@GetMapping({"/index","/","/home"})	
	public String index(Model model) {		
		model.addAttribute("titulo","Hola Spring Framework con la Interfaz Model");		
		return "index";
	}
	
	/*@GetMapping({"/index","/","/home"})	
	public String index(ModelMap modelMap) {
		//Podemos pasar informacion con la interfaz Model o la clase ModelMap
		//Diferentes implementaciones pero hacen el mismo trabajo		
		modelMap.addAttribute("titulo","Hola Spring Framework");
		return "index";
	}
	*/
	
	/*@GetMapping({"/index","/","/home"})	
	public String index(Map<String, Object> map) {
		//Una tercera forma de enviar datos es utilizando la clase 
		// Map de java.util		
		map.put("titulo","Hola Spring Framework");
		return "index";
	}
	*/
	
	/* 
	 @GetMapping({"/index","/","/home"})	
	public ModelAndView index(ModelAndView mv) {		
		//Esta es una cuarta forma de pasar informacion del controlador a la vista
		mv.addObject("titulo","Hola Spring Framework con MV");
		mv.setViewName("index");
		return mv;
	}
	  
	 */
	
	@GetMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario=new Usuario();
		usuario.setNombre("Beatriz");
		usuario.setApellido("Vargas");
		usuario.setEmail("betamvl1998@gmail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo","Perfil del usuario : ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {		
		model.addAttribute("titulo","Lista de usuarios");
		return "listar";
	}
	
	/*
	 * @GetMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios=Arrays.asList(new Usuario("Alice","Benji","alice@correo.com"),
										     new Usuario("Ramon","Cito","ramoncito@correo.com"),
										     new Usuario("Lolita","Mepones","lolita@correo.com"),
										     new Usuario("Mari","Lol","marilol@correo.com")
										     );
		//List<Usuario> usuarios=new ArrayList<Usuario>();
		usuarios.add(new Usuario("Alice","Benji","alice@correo.com"));
		usuarios.add(new Usuario("Ramon","Cito","ramoncito@correo.com"));
		usuarios.add(new Usuario("Lolita","Mepones","lolita@correo.com"));
										     
										     
		model.addAttribute("usuarios" ,usuarios);
		model.addAttribute("titulo","Lista de usuarios");
		return "listar";
	}
	*/
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios=Arrays.asList(new Usuario("Alice","Benji","alice@correo.com"),
			     new Usuario("Ramon","Cito","ramoncito@correo.com"),
			     new Usuario("Lolita","Mepones","lolita@correo.com"),
			     new Usuario("Mari","Lol","marilol@correo.com")
			     );
		return usuarios;
	}
	
	
}
