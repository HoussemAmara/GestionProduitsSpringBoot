package com.isitcom.formationSptingboot.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.isitcom.formationSptingboot.demo.entities.Categorie;
import com.isitcom.formationSptingboot.demo.entities.Produit;
public interface categorieRepository extends JpaRepository<Categorie,Long>{
	public List<Categorie> findByNomContains(String mc);
	@Query("select c from Categorie c where c.nom like %:x%")
	public List<Categorie> rechercherMC(@Param("x") String mc);
}
