package com.ebtihel.produits.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ebtihel.produits.entities.Norriture;


    @Repository
	public interface ProduitRepository extends JpaRepository<Norriture, Long> {
    	
       	@Query("select n from Norriture n where n.nomNorriture like %:nomNorr% ")
    		List<Norriture> findByNorritureName( String nomNorr);
    
	}
	

