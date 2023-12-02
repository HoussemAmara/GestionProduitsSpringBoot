package com.isitcom.formationSptingboot.demo.service;

import java.util.List;

import com.isitcom.formationSptingboot.demo.entities.Categorie;


public interface IServiceCategorie {
	public void addCategorie(Categorie c);
	public List<Categorie> getAllCategories();
	public Categorie getCategorie(Long id);
	public void deleteCategorie(Long id);
	public void updateCategorie(Categorie g);
	public List<Categorie> getCategorieBMC(String mc);
}
