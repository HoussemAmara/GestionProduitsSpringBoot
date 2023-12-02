package com.isitcom.formationSptingboot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isitcom.formationSptingboot.demo.dao.ProduitRepository;
import com.isitcom.formationSptingboot.demo.dao.categorieRepository;
import com.isitcom.formationSptingboot.demo.entities.Categorie;
@Service
public class ServiceCategorie implements IServiceCategorie{
	@Autowired
	private categorieRepository cr;
	@Override
	public void addCategorie(Categorie c) {
		cr.save(c);
		
	}

	@Override
	public List<Categorie> getAllCategories() {
		return cr.findAll();
	}

	@Override
	public Categorie getCategorie(Long id) {
		return cr.findById(id).get();
	}

	@Override
	public void deleteCategorie(Long id) {
		cr.deleteById(id);
	}

	@Override
	public void updateCategorie(Categorie g) {
		cr.save(g);
		
	}

	@Override
	public List<Categorie> getCategorieBMC(String mc) {
		return cr.findByNomContains(mc);
	}

}
