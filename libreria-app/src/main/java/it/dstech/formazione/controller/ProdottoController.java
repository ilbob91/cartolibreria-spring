package it.dstech.formazione.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import it.dstech.formazione.model.Prodotto;
import it.dstech.formazione.service.ProdottoService;

@Controller
public class ProdottoController {
@Autowired
private ProdottoService service;

@RequestMapping("/")
public ModelAndView home() {
	List<Prodotto> listaProdotti = service.listAll();
	ModelAndView mav = new ModelAndView("home");
	mav.addObject("listaProdotti", listaProdotti);
	return mav;
}
@RequestMapping("/new")
public String nuovoProdotto(Model model) {
	Prodotto prodotto = new Prodotto();
	model.addAttribute("prodotto", prodotto);
	return "new_prodotto";
}

@RequestMapping(value = "/save", method = RequestMethod.POST)
public String saveCustomer(@ModelAttribute("prodotto") Prodotto prodotto) {
	service.save(prodotto);
	return "redirect:/";
}

@RequestMapping(value = "/edit")
public ModelAndView editProdotto(@RequestParam long id) {
	ModelAndView mav = new ModelAndView("edit_prodotto");
	Prodotto prodotto = service.get(id);
	mav.addObject("prodotto", prodotto);
	
	return mav;
}

@RequestMapping("/delete")
public String deleteProdotto(@RequestParam long id) {
	service.delete(id);
	return "redirect:/";		
}
@RequestMapping(value = "/indietro", method = RequestMethod.POST)
public String tornaIndietro() {
	return "redirect:/";		
}

}
