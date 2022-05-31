package com.ebtihel.produits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.ebtihel.produits.entities.Categorie;
import com.ebtihel.produits.entities.Norriture;
import com.ebtihel.produits.repos.ProduitRepository;
import com.ebtihel.produits.service.ProduitService;

@SpringBootTest
class ProduitApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private ProduitService produitService ;
	@Test
	public void testCreateProduit() {
	Norriture prod = new Norriture("PC Dell",2200.500,new Date());
	produitRepository.save(prod);
	}
	
	
	@Test
	public void testFindProduit()
	{
	Norriture p = produitRepository.findById(1L).get();

	System.out.println(p);
	}
	@Test
	public void testUpdateProduit()
	{
	Norriture p = produitRepository.findById(1L).get();
	p.setPrixNorriture(1000.0);
	produitRepository.save(p);
	}
	@Test
	public void testDeleteProduit()
	{
	produitRepository.deleteById(1L);;
	}
	@Test
	public void testListerTousProduits()
	{
	List<Norriture> prods = produitRepository.findAll();
	for (Norriture p : prods)
	{
	System.out.println(p);
	}
}
	
	/*@Test
	public void testFindByNomProduit()
	{
	List<Norriture> prods = produitRepository.findByNomProduit("PC Dell");
	for (Norriture p : prods)
	{
	System.out.println(p);
	}}
	@Test
	public void testFindByNomProduitContains()
	{
	List<Norriture> prods=produitRepository.findByNomProduitContains("P");
	for (Norriture p : prods)
	{
	System.out.println(p);
	}}
	@Test
	public void testfindByNomPrix()
	{
	List<Norriture> prods = produitRepository.findByNomPrix("PC Dell", 2200.5);
	for (Norriture p : prods)
	{
	System.out.println(p);
	}}
	@Test
	public void testfindByCategorie()
	{
	Categorie cat = new Categorie();
	cat.setIdCat(1L);
	List<Norriture> prods = produitRepository.findByCategorie(cat);
	for (Norriture p : prods)
	{
	System.out.println(p);
	}}
	@Test
	public void findByCategorieIdCat()
	{
	List<Norriture> prods = produitRepository.findByCategorieIdCat(1L);
	for (Norriture p : prods)
	{
	System.out.println(p);
	}}
	@Test
	public void testfindByOrderByNomProduitAsc()
	{
	List<Norriture> prods =

	produitRepository.findByOrderByNomProduitAsc();
	for (Norriture p : prods)
	{
	System.out.println(p);
	}}
	@Test
	public void testTrierProduitsNomsPrix()
	{
	List<Norriture> prods = produitRepository.trierProduitsNomsPrix();
	for (Norriture p : prods)
	{
	System.out.println(p);
	}}*/
	
}
