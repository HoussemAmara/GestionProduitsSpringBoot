package com.isitcom.formationSptingboot.demo.service;

import java.util.List;

import com.isitcom.formationSptingboot.demo.entities.Produit;


public interface IServiceProduit {
	
	public void addProduct(Produit p);
	public void deleteProduct(Long id);
	public void updateProduct(Produit p);
	public Produit getProduct(Long id);
	public List<Produit>getAllProducts();
	public List<Produit> getProductsBMC(String mc);
	

}
