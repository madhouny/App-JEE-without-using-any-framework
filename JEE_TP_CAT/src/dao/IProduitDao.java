package dao;

import java.util.List;

import metier.entites.Produit;

public interface IProduitDao {
	
	public Produit Save(Produit p);

	public List<Produit> produitParMC(String mc);

	public Produit getProduit(Long id);

	public Produit updateProduit(Produit p);

	public void deleteProduit(Long id);
}
