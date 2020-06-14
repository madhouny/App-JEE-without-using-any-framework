package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IProduitDao;
import dao.ProduitDaoImp;
import metier.entites.Produit;

public class ControllerServlet extends HttpServlet {
	private IProduitDao metier;

	@Override
	public void init() throws ServletException {
		metier = new ProduitDaoImp();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();
		if (path.equals("/index.do")) {
			request.getRequestDispatcher("Produits.jsp").forward(request, response);
		} else if (path.equals("/chercher.do")) {
			String motCle = request.getParameter("motcle");
			ProduitModel model = new ProduitModel();
			model.setMotCle(motCle);
			List<Produit> produits = metier.produitParMC("%" + motCle + "%");
			model.setProduits(produits);
			request.setAttribute("model", model);
			request.getRequestDispatcher("Produits.jsp").forward(request, response);
		} else if (path.equals("/saisie.do")) {
			request.setAttribute("produit", new Produit());
			request.getRequestDispatcher("SaisieProduit.jsp").forward(request, response);
		} else if (path.equals("/save.do") && (request.getMethod().equals("POST"))) {
			String designation = request.getParameter("designation");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int quantite = Integer.parseInt(request.getParameter("quantite"));

			Produit p = metier.Save(new Produit(designation, prix, quantite));
			request.setAttribute("produit", p);

			request.getRequestDispatcher("Confirmation.jsp").forward(request, response);

		} else if (path.equals("/delete.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			metier.deleteProduit(id);
			// request.getRequestDispatcher("Produits.jsp").forward(request,
			// response);
			response.sendRedirect("chercher.do?motcle=");
		} else if (path.equals("/edit.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Produit p = metier.getProduit(id);
			request.setAttribute("produit", p);
			request.getRequestDispatcher("editProduit.jsp").forward(request, response);

		} else if (path.equals("/update.do") && (request.getMethod().equals("POST"))) {
			Long id = Long.parseLong(request.getParameter("id"));
			String designation = request.getParameter("designation");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int quantite = Integer.parseInt(request.getParameter("quantite"));

			Produit p = new Produit(designation, prix, quantite);
			p.setId(id);
			metier.updateProduit(p);
			request.setAttribute("produit", p);

			request.getRequestDispatcher("Confirmation.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
