package com.isitcom.formationSptingboot.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Produit {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private double prix;
	private int quantite;
	@ManyToOne
	private Categorie categorie;
	public Produit(String nom, double prix, int quantite, Categorie categorie) {
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
        this.categorie = categorie;
    }
}
