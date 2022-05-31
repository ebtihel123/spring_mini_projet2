package com.ebtihel.produits.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ebtihel.produits.entities.Categorie;
import com.ebtihel.produits.entities.Norriture;
import com.ebtihel.produits.service.CatService;
import com.ebtihel.produits.service.ProduitService;

@Controller
public class ProduitController {
@Autowired
ProduitService produitService;
@Autowired
CatService catService;

@RequestMapping("/showCreate")
public String showCreate(ModelMap modelMap)
{
List<Categorie> cats = catService.findAll();
Norriture prod = new Norriture();
Categorie cat = new Categorie();
cat = cats.get(0); // prendre la première catégorie de la liste
prod.setCategorie(cat); //affedter une catégorie par défaut au produit pour éviter le pb avec une catégorie null
modelMap.addAttribute("categories", cats);
modelMap.addAttribute("produit", new Norriture());
modelMap.addAttribute("mode", "new");
return "formProduit";
}

@RequestMapping("/saveProduit")
public String saveProduit(@Valid Norriture Norriture,
BindingResult bindingResult)
{
System.out.println(Norriture);
if (bindingResult.hasErrors()) return "formProduit";
produitService.saveProduit(Norriture);

return "redirect:/ListeNorritures";
}

@RequestMapping("/showCreateCat")
public String showCreateCat(ModelMap modelMap)
{
modelMap.addAttribute("categories", new Categorie());
modelMap.addAttribute("mode", "new");
return "formCategorie";
}
@RequestMapping("/saveCategorie")
public String saveCategorie(@ModelAttribute("categorie") Categorie categorie,ModelMap modelMap) throws ParseException 
{
Categorie saveCategorie = catService.saveCategorie(categorie);
return "redirect:/ListeCat";
}

@RequestMapping("/ListeCat")
public String listeProduits(ModelMap modelMap)
{
List <Categorie> cats = catService.findAll();
modelMap.addAttribute("categories", cats);
return "ListeCat";
}

@RequestMapping("/ListeNorritures")
public String listeProduits(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
Page<Norriture> prods = produitService.getAllProduitsParPage(page, size);
modelMap.addAttribute("produits", prods);
 modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "listeNorritures";
}


@RequestMapping("/supprimerProduit")
public String supprimerProduit(@RequestParam("id") Long id,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
produitService.deleteProduitById(id);
Page<Norriture> prods = produitService.getAllProduitsParPage(page, 
size);
modelMap.addAttribute("produits", prods);
modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "listeNorritures";
}
@RequestMapping("/supprimerCategorie")
public String supprimerCategorie(@RequestParam("id") Long id,
 ModelMap modelMap)
{ 
catService.deleteCategorieById(id);
List<Categorie> cats = catService.findAll();
modelMap.addAttribute("categories", cats);
return "ListeCat";
}

@RequestMapping("/modifierProduit")
public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap)
{
Norriture p= produitService.getProduit(id);
List<Categorie> cats = catService.findAll();
cats.remove(p.getCategorie());
modelMap.addAttribute("categories", cats);
modelMap.addAttribute("produit", p);
modelMap.addAttribute("mode", "edit");
return "formProduit";
}
@RequestMapping("/updateProduit")
public String updateProduit(@ModelAttribute("produit") Norriture Norriture,
@RequestParam("date") String date,ModelMap modelMap) throws ParseException {
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 Norriture.setDateCreation(dateCreation);
	 
	 produitService.updateProduit(Norriture);
	 List<Norriture> prods = produitService.getAllProduits();
	 modelMap.addAttribute("produits", prods);
	return "listeNorritures";
	}
@RequestMapping("/modifierCategorie")
public String editerCategorie(@RequestParam("id") Long id,ModelMap modelMap)
{
Categorie c= catService.getCategorie(id);
modelMap.addAttribute("categories", c);
modelMap.addAttribute("mode", "edit");
return "formCategorie";
}
@RequestMapping("/updateCategorie")
public String updateCategorie(@ModelAttribute("categorie") Categorie categorie,ModelMap modelMap) throws ParseException {
	catService.updateCategorie(categorie);
	 List<Categorie> cats = catService.findAll();
	 modelMap.addAttribute("categories", cats);
	return "ListeCat";
	}



@RequestMapping("/searchNorriture")
public String chercherTask(@RequestParam("nomNorriture")  String nomNorriture,ModelMap modelMap)
{
	List<Categorie> cat = catService.findAll();
	modelMap.addAttribute("categories", cat);
	List<Norriture> nor =produitService.findByNorritureName(nomNorriture);
	modelMap.addAttribute("norritures",nor);
	modelMap.addAttribute("mode", "SearchNorriture");
	return "listSearch";
}



}