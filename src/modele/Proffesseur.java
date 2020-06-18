package modele;

public class Proffesseur {
	private int id_prof;
	private String nom;
	private String prenom;
	private String departement;
	private int telephone;
	private String email;
	public Proffesseur(int id_prof, String nom, String prenom, String departement, int telephone, String email) {
		this.id_prof = id_prof;
		this.nom = nom;
		this.prenom = prenom;
		this.departement = departement;
		this.telephone = telephone;
		this.email = email;
	}
	public int getId_prof() {
		return id_prof;
	}
	public void setId_prof(int id_prof) {
		this.id_prof = id_prof;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	

}
