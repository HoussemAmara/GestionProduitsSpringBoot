package com.isitcom.formationSptingboot.demo.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.isitcom.formationSptingboot.demo.entities.Categorie;
import com.isitcom.formationSptingboot.demo.entities.Produit;
import com.isitcom.formationSptingboot.demo.service.IServiceCategorie;
import com.isitcom.formationSptingboot.demo.service.IServiceProduit;

@Controller
public class CategorieControleur {
	@Autowired
	private IServiceCategorie sc;

		
}

