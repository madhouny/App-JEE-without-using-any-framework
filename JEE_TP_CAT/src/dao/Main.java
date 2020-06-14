package dao;

import java.util.List;

import metier.entites.Produit;

public class Main {

	public static void main(String[] args) {
		
		ProduitDaoImp dao = new ProduitDaoImp();
		/*
		Produit p1 = dao.Save(new Produit("HP", 900, 2));
		Produit p2 = dao.Save(new Produit("ASUS", 1000, 10));
		Produit p3 = dao.Save(new Produit("DELL", 500, 9));
		
		*/
		
		List<Produit> pdts = dao.produitParMC("%H%");
		for(Produit p : pdts){
			System.out.println(p.toString());
		}
		

	}

}
