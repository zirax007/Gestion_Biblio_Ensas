package modele;

public class Livre {
	String reftitre;
	String edition;
	String auteur;
	String langue;
	String classemnt;
	String titre;
	int  quantite;
	String type;
	
	public Livre(String reftitre,  String auteur,String classemnt, String titre,String edition, String langue, 
			String type,int quantite) {
		this.reftitre = reftitre;
		this.auteur = auteur;
		this.classemnt = classemnt;
		this.titre = titre;
		this.edition = edition;
		this.langue = langue;
		this.type = type;
		this.quantite = quantite;
		
	}
	public Livre() {
		// TODO Auto-generated constructor stub
	}
	public String getReftitre() {
		return reftitre;
	}
	public void setReftitre(String reftitre) {
		this.reftitre = reftitre;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	public String getClassemnt() {
		return classemnt;
	}
	public void setClassemnt(String classemnt) {
		this.classemnt = classemnt;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
