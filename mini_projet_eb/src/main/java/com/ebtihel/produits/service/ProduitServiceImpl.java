package com.ebtihel.produits.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ebtihel.produits.entities.Categorie;
import com.ebtihel.produits.entities.Norriture;
import com.ebtihel.produits.repos.ProduitRepository;
	@Service
	public class ProduitServiceImpl implements ProduitService {
	@Autowired
	ProduitRepository produitRepository;
	@Override
	public Norriture saveProduit(Norriture p) {

	return produitRepository.save(p);
	}
	@Override
	public Norriture updateProduit(Norriture p) {
	return produitRepository.save(p);
	}
	@Override
	public void deleteProduit(Norriture p) {
	produitRepository.delete(p);
	}
	@Override
	public void deleteProduitById(Long id) {
	produitRepository.deleteById(id);
	}
	@Override
	public Norriture getProduit(Long id) {
	return produitRepository.findById(id).get();
	}
	@Override
	public List<Norriture> getAllProduits() {
	return produitRepository.findAll();
	}
	@Override
	public Page<Norriture> getAllProduitsParPage(int page, int size) {
		return produitRepository.findAll(PageRequest.of(page, size));
		}
	/*@Override
	public List<Norriture> findByNomProduit(String nom) {
	return produitRepository.findByNomProduit(nom);
	}
	@Override
	public List<Norriture> findByNomProduitContains(String nom) {
	return produitRepository.findByNomProduitContains(nom);
	}
	@Override
	public List<Norriture> findByNomPrix(String nom, Double prix) {
	return produitRepository.findByNomPrix(nom, prix);
	}
	@Override
	public List<Norriture> findByCategorie(Categorie categorie) {
	return produitRepository.findByCategorie(categorie);
	}
	@Override
	public List<Norriture> findByCategorieIdCat(Long id) {
	return produitRepository.findByCategorieIdCat(id);
	}
	@Override
	public List<Norriture> findByOrderByNomProduitAsc() {
	return produitRepository.findByOrderByNomProduitAsc();
	}
	@Override
	public List<Norriture> trierProduitsNomsPrix() {
	return produitRepository.trierProduitsNomsPrix();
	}*/
	@Override
	public List<Norriture> findByNomProduit(String nom) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Norriture> findByNomProduitContains(String nom) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Norriture> findByNomPrix(String nom, Double prix) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Norriture> findByCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Norriture> findByCategorieIdCat(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Norriture> findByOrderByNomProduitAsc() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Norriture> trierProduitsNomsPrix() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Norriture> findByNorritureName(String nomNorriture) {
		// TODO Auto-generated method stub
		return produitRepository.findByNorritureName(nomNorriture);
	}
}
