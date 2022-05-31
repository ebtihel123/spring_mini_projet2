package com.ebtihel.produits.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomNor", types = { Norriture.class })
public interface ProduitProjection {
public String getNomProduit();
}