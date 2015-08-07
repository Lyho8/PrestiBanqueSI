package com.prestibanque.models;

public class Client extends Personne {
	private String adresse;
	private String ville;
	private int code_postal;
	private String telephone;
	private CompteCourant compteCourant;
	private CompteEpargne compteEpargne;
	private CarteBancaire carteBancaire;
	private boolean isEntreprise;

	public Client(String nom, String prenom, String adresse, String ville, int code_postal, String telephone) {
		this(nom, prenom, adresse, ville, code_postal, telephone, false);
	}
	
	public Client(String nom, String prenom, String adresse, String ville, int code_postal, String telephone, boolean isEntreprise) {
		super(nom, prenom);
		this.adresse = adresse;
		this.ville = ville;
		this.code_postal = code_postal;
		this.telephone = telephone;
		this.isEntreprise = isEntreprise;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(int code_postal) {
		this.code_postal = code_postal;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	public CarteBancaire getCarteBancaire() {
		return carteBancaire;
	}

	public void setCarteBancaire(CarteBancaire carteBancaire) {
		this.carteBancaire = carteBancaire;
	}

	public boolean isEntreprise() {
		return isEntreprise;
	}

	public void setEntreprise(boolean isEntreprise) {
		this.isEntreprise = isEntreprise;
	}

}
