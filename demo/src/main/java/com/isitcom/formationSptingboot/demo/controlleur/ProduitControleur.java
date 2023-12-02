package com.isitcom.formationSptingboot.demo.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.isitcom.formationSptingboot.demo.entities.Produit;
import com.isitcom.formationSptingboot.demo.service.IServiceProduit;

@Controller
public class ProduitControleur {
	@Autowired
	private IServiceProduit sp;
	@GetMapping("/produits")
	public String getAllProducts(Model m) {
		List<Produit> liste=sp.getAllProducts();
		m.addAttribute("productList",liste);
		return "index";
	}
	@GetMapping("/search")
	public String search(@RequestParam String mc,Model m) {
		m.addAttribute("productList",sp.getProductsBMC(mc));
		return "index";
	}
	@GetMapping("/delete/{id}")
	public String supprierProduit(@PathVariable("id") Long idProduit) {
		sp.deleteProduct(idProduit);
		return "redirect:/produits";
	}
	
}
