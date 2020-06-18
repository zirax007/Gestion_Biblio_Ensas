package modele;

public class Etudiant {
	private int CodeEtd;
	private String nom;
	private String prenom;
	private String tel;
	private String email;
	private String nationalt;
	private String depar;
	private String filiere;
	public Etudiant(int codeEtd, String nom, String prenom, String tel, String email, String nationalt, String depar,
			String filiere) {
		CodeEtd = codeEtd;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.email = email;
		this.nationalt = nationalt;
		this.depar = depar;
		this.filiere = filiere;
	}
	public int getCodeEtd() {
		return CodeEtd;
	}
	public void setCodeEtd(int codeEtd) {
		CodeEtd = codeEtd;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNationalt() {
		return nationalt;
	}
	public void setNationalt(String nationalt) {
		this.nationalt = nationalt;
	}
	public String getDepar() {
		return depar;
	}
	public void setDepar(String depar) {
		this.depar = depar;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	
	

}
