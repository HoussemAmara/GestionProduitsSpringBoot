package com.isitcom.formationSptingboot.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.isitcom.formationSptingboot.demo.entities.Categorie;
public interface categorieRepository extends JpaRepository<Categorie,Long>{
	public List<Categorie> findByNomContains(String mc);
}
