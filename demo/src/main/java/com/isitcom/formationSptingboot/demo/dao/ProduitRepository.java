package com.isitcom.formationSptingboot.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.isitcom.formationSptingboot.demo.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit,Long>{

	public List<Produit> findByNomContains(String mc);
@Query("select p from Produit p where p.nom like %:x%")
	public List<Produit> rechercherMC(@Param("x") String mc);
}
