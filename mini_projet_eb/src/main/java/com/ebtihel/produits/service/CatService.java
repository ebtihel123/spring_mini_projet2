package com.ebtihel.produits.service;

import java.util.List;

import com.ebtihel.produits.entities.Categorie;

public interface CatService {
	
	
	//afficher tout table categorie
    public List <Categorie> findAll();
    //ajouter dans la table categoire
    Categorie saveCategorie(Categorie c);
    Categorie updateCategorie(Categorie c);
    void deleteCategorie(Categorie c);
     void deleteCategorieById(Long id);
     Categorie getCategorie (Long idCat);

}