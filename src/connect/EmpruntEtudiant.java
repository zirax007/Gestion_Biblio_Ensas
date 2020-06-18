package connect;
public class EmpruntEtudiant {
	private int codeetd;
	private int ref_livre;
	private String date_debut;
	private String date_retour;
	private String id_empr;
	public EmpruntEtudiant(int codeetd, int ref_livre, String date_debut, String date_retour) {
		super();
		this.codeetd = codeetd;
		this.ref_livre = ref_livre;
		this.date_debut = date_debut;
		this.date_retour = date_retour;
	}
	
	public EmpruntEtudiant(int codeetd, int ref_livre, String date_debut, String date_retour, String id_empr) {
		super();
		this.codeetd = codeetd;
		this.ref_livre = ref_livre;
		this.date_debut = date_debut;
		this.date_retour = date_retour;
		this.id_empr = id_empr;
	}

	public String getId_empr() {
		return id_empr;
	}

	public void setId_empr(String id_empr) {
		this.id_empr = id_empr;
	}

	public int getCodeetd() {
		return codeetd;
	}
	public void setCodeetd(int codeetd) {
		this.codeetd = codeetd;
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
	public String getDate_retour() {
		return date_retour;
	}
	public void setDate_retour(String date_retour) {
		this.date_retour = date_retour;
	}
	
		
	}


