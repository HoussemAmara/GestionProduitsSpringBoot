package com.isitcom.formationSptingboot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isitcom.formationSptingboot.demo.dao.ProduitRepository;
import com.isitcom.formationSptingboot.demo.entities.Produit;
@Service
public class ServiceProduit implements IServiceProduit{
	@Autowired
	private ProduitRepository pr;
	@Override
	public void addProduct(Produit p) {
		pr.save(p);		
	}

	@Override
	public void deleteProduct(Long id) {
		pr.deleteById(id);
		
	}

	@Override
	public void updateProduct(Produit p) {
		pr.save(p);
		
	}

	@Override
	public Produit getProduct(Long id) {
		return pr.findById(id).get();
	}

	@Override
	public List<Produit> getAllProducts() {
		return pr.findAll();
	}

	@Override
	public List<Produit> getProductsBMC(String mc) {
		return pr.findByNomContains(mc);
	}

}
