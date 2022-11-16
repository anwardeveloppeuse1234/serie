package com.example.series.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.series.service.SerieService;
import com.example.series.service.UsersService;
import com.example.series.entities.Genre;
import com.example.series.entities.Role;
import com.example.series.entities.Serie;
import com.example.series.entities.User;
import com.example.series.service.GenService;
import com.example.series.service.RoleService;

@Controller
public class SerieController {
	@Autowired
	SerieService serieService;
	@Autowired
	GenService genService;
	@Autowired
	RoleService roleService;
	@Autowired
	UsersService usersService;
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
	List<Genre> gens = genService.findAll();
	modelMap.addAttribute("genres", gens);
	modelMap.addAttribute("serie", new Serie());
	modelMap.addAttribute("mode", "new");
	return "formSerie";
	}
@RequestMapping("/saveSerie")
public String saveSerie(ModelMap modelMap,@Valid Serie serie,
BindingResult bindingResult)
{
	List<Genre> gens = genService.findAll();
	modelMap.addAttribute("genres", gens);
System.out.println(serie);
if (bindingResult.hasErrors()) return "formSerie";
serieService.saveSerie(serie);
return "redirect:/ListeSeries";
}

@RequestMapping("/showCreateGen")
public String showCreateGen(ModelMap modelMap)
{
modelMap.addAttribute("genres", new Genre());
modelMap.addAttribute("mode", "new");
return "formGenre";
}
@RequestMapping("/saveGenre")
public String saveGenre(@ModelAttribute("genre") Genre genre,ModelMap modelMap) throws ParseException 
{
Genre saveGenre = genService.saveGenre(genre);
return "redirect:/ListeGen";
}

@RequestMapping("/ListeGen")
public String listeSeries(ModelMap modelMap)
{
List <Genre> gens =genService.findAll();
modelMap.addAttribute("genres", gens);
return "ListeGen";
}

@RequestMapping("/ListeSeries")
public String listeSeries(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
Page<Serie> sers = serieService.getAllSeriesParPage(page, size);
modelMap.addAttribute("series", sers);
 modelMap.addAttribute("pages", new int[sers.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "listeSeries";
}


@RequestMapping("/supprimerSerie")
public String supprimerSerie(@RequestParam("id") Long id,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
serieService.deleteSerieById(id);
Page<Serie> sers = serieService.getAllSeriesParPage(page, 
size);
modelMap.addAttribute("series", sers);
modelMap.addAttribute("pages", new int[sers.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "listeSeries";
}
@RequestMapping("/supprimerGenre")
public String supprimerGenre(@RequestParam("id") Long id,
 ModelMap modelMap)
{ 
genService.deleteGenreById(id);
List<Genre> gens = genService.findAll();
modelMap.addAttribute("genres", gens);
return "ListeGen";
}

@RequestMapping("/modifierSerie")
public String editerSerie(@RequestParam("id") Long id,ModelMap modelMap)
{
Serie s= serieService.getSerie(id);
List<Genre> gens = genService.findAll();
gens.remove(s.getGenre());
modelMap.addAttribute("genres", gens);
modelMap.addAttribute("serie", s);
modelMap.addAttribute("mode", "edit");
return "formSerie";
}
@RequestMapping("/updateSerie")
public String updateSerie(@ModelAttribute("serie") Serie serie,
@RequestParam("date") String date,ModelMap modelMap) throws ParseException {
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 serie.setDateCreation(dateCreation);
	 
	 serieService.updateSerie(serie);
	 List<Serie> sers = serieService.getAllSeries();
	 modelMap.addAttribute("series", sers);
	return "listeSeries";
	}
@RequestMapping("/modifierGenre")
public String editerGenre(@RequestParam("id") Long id,ModelMap modelMap)
{
Genre c= genService.getGenre(id);
modelMap.addAttribute("genres", c);
modelMap.addAttribute("mode", "edit");
return "formGenre";
}
@RequestMapping("/updateGenre")
public String updateGenre(@ModelAttribute("genre") Genre genre,ModelMap modelMap) throws ParseException {
	genService.updateGenre(genre);
	 List<Genre> gens = genService.findAll();
	 modelMap.addAttribute("genres", gens);
	return "ListeGen";
	}
@RequestMapping("/rechercher")
public String rechercher(@RequestParam("nom") String nom,
ModelMap modelMap)
{
	List<Genre> gens = genService.findAll();
	modelMap.addAttribute("genres", gens);
List<Serie> sers = serieService.findByNomSerie(nom);
modelMap.addAttribute("series",sers);
return "listeSeries";
}


@RequestMapping("/saveRole")
public String saveRole(@ModelAttribute("role") Role role, ModelMap modelMap) throws ParseException {
	Role saveRole = roleService.saveRole(role);
	return "redirect:/ListeUsers";
}

@RequestMapping("/showCreateUser")
public String showCreateUser(ModelMap modelMap) {
	List<Role> roles = roleService.findAll();
	modelMap.addAttribute("roles", roles);
	modelMap.addAttribute("users", new User());
	modelMap.addAttribute("mode", "new");
	return "FormUser";
}

@RequestMapping("/saveUser")
public String saveUser(@ModelAttribute("user") User user, ModelMap modelMap) throws ParseException {
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder() ;
	String encodedPassword = encoder. encode (user.getPassword());
	user.setPassword(encodedPassword);
	 usersService.saveUser(user);
	return "redirect:/ListeUsers";
}

@RequestMapping("/ListeUsers")
public String ListeUser(ModelMap modelMap) {
	List<User> users = usersService.findAll();
	modelMap.addAttribute("users", users);
	return "ListeUsers";
}

@RequestMapping("/supprimerUser")
public String supprimerUser(@RequestParam("id") Long id, ModelMap modelMap) {
	usersService.deleteUserById(id);
	List<User> roles = usersService.findAll();
	modelMap.addAttribute("users", roles);
	return "ListeUsers";
}

@RequestMapping("/modifierUser")
public String modifierUser(@RequestParam("id") Long id, ModelMap modelMap) {
	User u = usersService.getUser(id);
	List<Role> role = roleService.findAll();
	modelMap.addAttribute("roles", role);
	modelMap.addAttribute("users", u);
	modelMap.addAttribute("mode", "edit");
	return "FormUser";
}

@RequestMapping("/updateUser")
public String updateUser(@ModelAttribute("user") User user,ModelMap modelMap) throws ParseException {
	usersService.updateUser(user);
	 List<User> roles = usersService.findAll();
	 modelMap.addAttribute("users", roles);
	return "ListeUsers";
}
}