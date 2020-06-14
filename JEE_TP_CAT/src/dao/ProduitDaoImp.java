package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entites.Produit;

public class ProduitDaoImp implements IProduitDao {

	@Override
	public Produit Save(Produit p) {
		Connection connection = SingletonConnection.getConnection();

		try {
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO PRODUITS (DESIGNATION,PRIX,QUANTITE) VALUES(?,?,?)");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());

			ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(ID) AS MAX_ID FROM PRODUITS");
			ResultSet res = ps2.executeQuery();
			if (res.next()) {
				p.setId(res.getLong("MAX_ID"));
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Produit> produitParMC(String mc) {
		List<Produit> listP = new ArrayList<Produit>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM PRODUITS WHERE DESIGNATION LIKE ?");
			ps.setString(1, mc);
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				Produit p = new Produit();
				p.setId(res.getLong("ID"));
				p.setDesignation(res.getString("DESIGNATION"));
				p.setPrix(res.getDouble("PRIX"));
				p.setQuantite(res.getInt("QUANTITE"));
				listP.add(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listP;
	}

	@Override
	public Produit getProduit(Long id) {
		Produit p = null;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM PRODUITS WHERE ID = ?");
			ps.setLong(1, id);
			ResultSet res = ps.executeQuery();

			if (res.next()) {
				p = new Produit();
				p.setId(res.getLong("ID"));
				p.setDesignation(res.getString("DESIGNATION"));
				p.setPrix(res.getDouble("PRIX"));
				p.setQuantite(res.getInt("QUANTITE"));
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Produit updateProduit(Produit p) {
		Connection connection = SingletonConnection.getConnection();

		try {
			PreparedStatement ps = connection
					.prepareStatement("UPDATE  PRODUITS SET DESIGNATION=?, PRIX=?, QUANTITE=? WHERE ID =?");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setLong(4, p.getId());
			
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void deleteProduit(Long id) {
		Connection connection = SingletonConnection.getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM PRODUITS WHERE ID = ?");
			ps.setLong(1, id);

			ps.executeUpdate();

			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
