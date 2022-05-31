package com.ebtihel.produits.service;
import java.util.List;

import org.springframework.data.domain.Page;

import com.ebtihel.produits.entities.Categorie;
import com.ebtihel.produits.entities.Norriture;
public interface ProduitService {
	Norriture saveProduit(Norriture p);
	Norriture updateProduit(Norriture p);
	void deleteProduit(Norriture p);
	void deleteProduitById(Long id);
	Norriture getProduit(Long id);
    List<Norriture> findByNorritureName(String nomNorriture);

	List<Norriture> getAllProduits();	
	Page<Norriture> getAllProduitsParPage(int page, int size);
	List<Norriture> findByNomProduit(String nom);
	List<Norriture> findByNomProduitContains(String nom);
	List<Norriture> findByNomPrix (String nom, Double prix);
	List<Norriture> findByCategorie (Categorie categorie);
	List<Norriture> findByCategorieIdCat(Long id);
	List<Norriture> findByOrderByNomProduitAsc();
	List<Norriture> trierProduitsNomsPrix();
}
