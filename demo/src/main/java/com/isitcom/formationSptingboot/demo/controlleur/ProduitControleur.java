package com.isitcom.formationSptingboot.demo.controlleur;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.isitcom.formationSptingboot.demo.entities.Produit;
import com.isitcom.formationSptingboot.demo.entities.Categorie;
import com.isitcom.formationSptingboot.demo.service.IServiceCategorie;
import com.isitcom.formationSptingboot.demo.service.IServiceProduit;


@Controller
public class ProduitControleur {
	@Autowired
	private IServiceProduit sp;
	@Autowired
	private IServiceCategorie sc;
	@GetMapping("/produits")
	public String getAllProducts(Model m) {
		List<Produit> liste=sp.getAllProducts();
		m.addAttribute("productList",liste);
		return "index";
	}
	@GetMapping("/")
	public String getProducts(Model m) {
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
	@GetMapping("/produit/ajouter")
	public String AjouterProduitView(Model m) {
		List<Categorie> l=sc.getAllCategories();
		m.addAttribute("categorieList", l);
		return "ajout";
	}
	@GetMapping("/controleur")
	public String AjouterProduitDB(@RequestParam String action,@RequestParam String productId,@RequestParam String productName,@RequestParam String productPrice,@RequestParam String productQuantity,@RequestParam String selectedCategorie) {
		double parsedProductPrice = Double.parseDouble(productPrice);
	    int parsedProductQuantity = Integer.parseInt(productQuantity);
	    Long productCategorieID = Long.parseLong(selectedCategorie);
	    Categorie cat = sc.getCategorie(productCategorieID);
	    Produit p = new Produit(productName, parsedProductPrice, parsedProductQuantity, cat);
    	sp.addProduct(p);
		return "redirect:/produits";
	}
	@GetMapping("/produits/{id}")
	public String modifierProduit(@PathVariable("id") Long idProduit,Model m) {
		Produit p=sp.getProduct(idProduit);
		m.addAttribute("product", p);
		List<Categorie> l=sc.getAllCategories();
		m.addAttribute("categorieList", l);
		return "edit";
	}
	@GetMapping("/edit")
	public String modifierProduitDB(@RequestParam String action,@RequestParam String productId,@RequestParam String productName,@RequestParam String productPrice,@RequestParam String productQuantity,@RequestParam String selectedCategorie) {
		int parsedProductId = Integer.parseInt(productId);
		double parsedProductPrice = Double.parseDouble(productPrice);
	    int parsedProductQuantity = Integer.parseInt(productQuantity);
	    Long productCategorieID = Long.parseLong(selectedCategorie);
	    Categorie cat = sc.getCategorie(productCategorieID);
	    Produit p = new Produit(parsedProductId,productName, parsedProductPrice, parsedProductQuantity, cat);
    	sp.updateProduct(p);
		return "redirect:/produits";	
	}
	@GetMapping("/categories")
	public String getAllCategories(Model m) {
		List<Categorie> liste=sc.getAllCategories();
		m.addAttribute("categorieList",liste);
		return "categorie";
	}
	@GetMapping("categories/search")
	public String categoriesSearch(@RequestParam String mc,Model m) {
		m.addAttribute("categorieList",sc.getCategorieBMC(mc));
		return "categorie";
	}
	@GetMapping("/categories/ajouter")
	public String AjouterCategorieView(Model m) {
		return "addCategorie";
	}
	
	@GetMapping("/ajouterCategorieLogic")
	public String AjouterCategorieDB(@RequestParam String categorieName) {
	    Categorie cat = new Categorie(categorieName);
    	sc.addCategorie(cat);
		return "redirect:/categories";
	}
	@GetMapping("/categories/delete/{id}")
	public String supprierCategorie(@PathVariable("id") Long idCategorie) {
		Categorie c=sc.getCategorie(idCategorie);
		List<Produit> p=c.getListe();
		for (Produit produit : p) {
            produit.setCategorie(null);
        }
		sc.deleteCategorie(idCategorie);
		return "redirect:/categories";
	}
	@GetMapping("/categories/{id}")
	public String modifierCategorie(@PathVariable("id") Long idCategorie,Model m) {
		Categorie c=sc.getCategorie(idCategorie);
		m.addAttribute("categorie", c);
		return "editCategorie";
	}
	@GetMapping("/categories/controleur")
	public String modifierCategorieDB(@RequestParam String categorieId,@RequestParam String categorieName) {
		int parsedCategorieId = Integer.parseInt(categorieId);
		Categorie c=new Categorie(parsedCategorieId,categorieName);
		sc.updateCategorie(c);
		return "redirect:/categories";
	}
	
	
	
	
	
	
	
	
}
