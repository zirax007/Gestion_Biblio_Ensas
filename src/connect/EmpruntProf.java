package connect;

public class EmpruntProf {
	private int id_prof;
	private int ref_livre;
	private String date_debut;
	private String pr_identifiant;
	private String date_fin;
	
	
	public EmpruntProf(int id_prof, int ref_livre, String date_debut, String date_fin) {
		this.id_prof = id_prof;
		this.ref_livre = ref_livre;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}
	
	
	public EmpruntProf(int id_prof, int ref_livre, String date_debut,  String date_fin,String pr_identifiant) {
		this.id_prof = id_prof;
		this.ref_livre = ref_livre;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.pr_identifiant = pr_identifiant;
	}


	public String getPr_identifiant() {
		return pr_identifiant;
	}


	public void setPr_identifiant(String pr_identifiant) {
		this.pr_identifiant = pr_identifiant;
	}


	public int getId_prof() {
		return id_prof;
	}
	public void setId_prof(int id_prof) {
		this.id_prof = id_prof;
	}
	public int getRef_livre() {
		return ref_livre;
	}
	public void setRef_livre(int ref_livre) {
		this.ref_livre = ref_livre;
	}
	public String getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}
	public String getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}
	

}
