package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import connect.EmpruntEtudiant;
import connect.EmpruntProf;
import connect.InterConnexion;
import connect.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import modele.Etudiant;
import modele.Livre;
import modele.Proffesseur;
public class Controlleur implements Initializable{
@FXML
private AnchorPane pnlHistorique,pnlDocuments,pnlAdherants,pnlParametre,pnlLivre,pnlMemoire,pnlNewcompte,pnlSupprimer,pnlProffesseur,pnlEtudiant;
@FXML
private Button btnHistorique,btnDocuments,btnAdherants,btnParametre,btnLivre,btnMemoire,btnNewcompte,btnSupprimer,btnProffesseur,btnEtudiants;
@FXML
private AnchorPane pnlGestionLiv;
//---------pour les etudiants ---------
@FXML private TableView<Etudiant>tableEtudiant;
@FXML private TableColumn<Etudiant, Integer> CodeEtd;
@FXML private TableColumn<Etudiant, String> Nom;
@FXML private TableColumn<Etudiant, String> prenom;
@FXML private TableColumn<Etudiant, String> tel;
@FXML private TableColumn<Etudiant, String> Email;
@FXML private TableColumn<Etudiant, String> depar;  
@FXML private TableColumn<Etudiant, String> filiere; 
@FXML private TableColumn<Etudiant, String> nationalt; 
//----------------pour proffesseur------------
@FXML private TableView<Proffesseur> tableProf;
@FXML private TableColumn<Proffesseur, Integer> id_pro;
@FXML private TableColumn<Proffesseur, String> nmp;
@FXML private TableColumn<Proffesseur, String> prP;
@FXML private TableColumn<Proffesseur, String> depP;
@FXML private TableColumn<Proffesseur, Integer> telPr;
@FXML private TableColumn<Proffesseur, String> EMpr;  

//----------------pour Emprunt proffesseur------------
@FXML private TableView<EmpruntProf> tableEmpruntprof;
@FXML private TableColumn<EmpruntProf, Integer> id_prof;
@FXML private TableColumn<EmpruntProf, Integer> ref_l;
@FXML private TableColumn<EmpruntProf, String> dateD;
@FXML private TableColumn<EmpruntProf, String> DateF;
@FXML private TableColumn<EmpruntProf, String>pr_ident;



//----------------pour livre------------
@FXML private TableView<Livre> tablelivre;
@FXML private TableColumn<Livre, String> ref_livre;
@FXML private TableColumn<Livre, String> id_auteur;
@FXML private TableColumn<Livre, String> classement;
@FXML private TableColumn<Livre, String> titre;
@FXML private TableColumn<Livre, String> edition;
@FXML private TableColumn<Livre, String> langue;
@FXML private TableColumn<Livre, String> type;
@FXML private TableColumn<Livre, Integer> quantite;
//----------------pour la gestion des retours des etudiants ---------
@FXML
private TableView<EmpruntEtudiant> tableEmpruntEtudiant;
@FXML
private TableColumn<EmpruntEtudiant,Integer> id_prof1;
@FXML
private TableColumn<EmpruntEtudiant,String> pr_ident1;
@FXML
private TableColumn<EmpruntEtudiant,Integer> ref_l1;
@FXML
private TableColumn<EmpruntEtudiant,String> dateD1;
@FXML
private TableColumn<EmpruntEtudiant,String > DateF1;


@FXML
private Button btnGestionLiv;

@FXML
private void buttonAction  (ActionEvent event ) {
	
	if(event.getSource()==btnDocuments) {
		pnlDocuments.toFront();
		
	}else if(event.getSource()==btnAdherants) {
		pnlAdherants.toFront();
	}else 
		
	if(event.getSource()==btnHistorique) {
		pnlHistorique.toFront();
	}else 
		
	if(event.getSource()==btnParametre) {
		pnlParametre.toFront();
	}else 
		
	if(event.getSource()==btnLivre) {
		pnlLivre.toFront();
	}else 
		
	if(event.getSource()==btnMemoire) {
		pnlMemoire.toFront();
	}
	else 
		
	if(event.getSource()==btnNewcompte) {
			pnlNewcompte.toFront();
	}
	else if(event.getSource()==btnSupprimer) {
			pnlSupprimer.toFront();
			}
	
	else if(event.getSource()==btnGestionLiv) {
		pnlGestionLiv.toFront();
		}
	
}
// -----------------Ajout pour un nouveau livre -----------

@FXML
private TextField txtType;
@FXML
private TextField txtqte;
@FXML
private TextField txtClassement;
@FXML
private TextField txtidAuteur;
@FXML
private TextField txtRefLivre;
@FXML
private TextField txttitre;
@FXML
private TextField txtlangue;
@FXML
private TextField txtEdition;
//-------------gestion Livre -------------
		public void AjouterLivre(ActionEvent event){
		    String tpe=txtType.getText();
		    String clssm=txtClassement.getText();
		    String auteur=txtidAuteur.getText();
		    String RefLiv=txtRefLivre.getText();
		    String Titr=txttitre.getText();
		    String Edit=txtEdition.getText();
		    String Lang=txtlangue.getText();
		    int Qte = Integer.parseInt(txtqte.getText());
		    Livre livr=new Livre(RefLiv,auteur,clssm,Titr,Edit,Lang,tpe,Qte); 
		    int status;
		    status = InterConnexion.save(livr);
		   if(status<=0){
		        Alert alert;
		        alert = new Alert(AlertType.ERROR);
		        alert.setTitle("Ajout Livre");
		        alert.setHeaderText("Information");
		        alert.setContentText("Echec de l'ajout");
		        alert.showAndWait();
		    }else {
		    	afficherLivr();
			}
} 
		static String total;
		  @FXML
		  private Text totalLivre;
		  public void AffichetotalLivre(){
			  try{
					  Connection con = dbConnection.connect();
				  	  String sql="select count(ref_livre) from livre" ;	
					    PreparedStatement stat=con.prepareStatement(sql);
				    ResultSet rs=stat.executeQuery();
				    while(rs.next()) {
				    	total=rs.getString(1);}
				    con.close(); 
				    }catch(SQLException e){
				        e.getMessage();
				    }
			  		totalLivre.setText(total); 
		  }
		  
// ------------Affichage des livres ------------------------------------
		    public ObservableList<Livre> donneLivre=FXCollections.observableArrayList();
		    public void AfficheLivre() {
		    	try{
		    		 Connection con=dbConnection.connect();
	    		    String sql="select* from livre";
	    		    PreparedStatement stat=con.prepareStatement(sql);
	    		    ResultSet rs=stat.executeQuery();
	    		  
	    		    while(rs.next()){
	    		    	donneLivre.add(new Livre(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8)));
	    		    }	
	    		    con.close();
	    		    }catch(SQLException e){
	    		        e.getMessage();
	    		    }
	    		        ref_livre.setCellValueFactory(new PropertyValueFactory<Livre,String>("reftitre"));
	    			    id_auteur.setCellValueFactory(new PropertyValueFactory<Livre,String>("auteur"));
	    			    classement.setCellValueFactory(new PropertyValueFactory<Livre,String>("classemnt"));
	    			    titre.setCellValueFactory(new PropertyValueFactory<Livre,String>("titre"));
	    			    edition.setCellValueFactory(new PropertyValueFactory<Livre,String>("edition"));
	    			    langue.setCellValueFactory(new PropertyValueFactory<Livre,String>("langue"));
	    			    type.setCellValueFactory(new PropertyValueFactory<Livre,String>("type"));
	    			    quantite.setCellValueFactory(new PropertyValueFactory<Livre,Integer>("quantite"));
	    			    tablelivre.setItems(donneLivre);
	    			   
				
			}
		  //------------// RECUPERER LES DONNEES LORS D'UN CLIC D'UNE LIGNE DANS LE TABLEAU VERS LES TEXTFIELDS ----------
		    
		    public void ClicLivre(){
			    try {
			        Connection con;
			        con = dbConnection.connect();
			        Livre lv=(Livre)tablelivre.getSelectionModel().getSelectedItem();
			        String sql="select* from livre";
			        PreparedStatement stat=con.prepareStatement(sql);
			        String c = Integer.toString(lv.getQuantite());
			        txtqte.setText(c);
			        txtType.setText(lv.getType());
			        txtClassement.setText(lv.getClassemnt());
			        txtidAuteur.setText(lv.getAuteur());
			        txtRefLivre.setText(lv.getReftitre());
			        txttitre.setText(lv.getTitre());
			        txtEdition.setText(lv.getEdition());
			        txtlangue.setText(lv.getLangue());    
			        stat.close();
			        con.close();
			        
			    }catch(SQLException e)
			    {
			        System.out.println(e);
			    }
			    }
		    //---------------suppression d'un livre ---------------   
		       @FXML
		 	  public void SupprimerLivre(){
		 	        	 Alert alert=new Alert(AlertType.CONFIRMATION);
		 	             alert.setTitle("Confirmation");
		 	             alert.setHeaderText(null);
		 	             alert.setContentText("Voulez-vous vraiment supprimer ce Livre ?");
		 	             Optional <ButtonType> action=alert.showAndWait();
		 	             
		 	             if(action.get()==ButtonType.OK){
		 	                 try{
		 	                 	     Connection con;
		 				        con = dbConnection.connect();
		 				        Livre lv=(Livre)tablelivre.getSelectionModel().getSelectedItem();
		 				        String sql="delete from livre where  ref_livre=?";
		 				        PreparedStatement stat=con.prepareStatement(sql);
		 				        stat.setString(1, lv.getReftitre());
		 				        stat.executeUpdate();
		 	        			con.close();
		 	        			afficherLivr();
		 	                 }catch(SQLException e){
		 	                     System.out.println(e);
		 	                 }
		 	                
		 	    }
		 	    
		 	        }
// -----------------------------vider table livre ---------------------------------
		     		       
		    		       public void vidertablelivre() {
		    			    	for ( int i = 0; i<tablelivre.getItems().size(); i++) {
		    			    		tablelivre.getItems().clear();
		    					    }
		    			    	}
//-------------------------vider les textsfields des livres-----------------
		    		       public void viderLivreText() {
			    		    	txtqte.clear();
			   			        txtType.clear();
			   			        txtClassement.clear();
			   			        txtidAuteur.clear();
			   			        txtRefLivre.clear();
			   			        txttitre.clear();
			   			        txtEdition.clear();
			   			        txtlangue.clear();
		    		       }
		    			       
//----------------------------------Afficher general livre -------------------------
		       public void afficherLivr() {
		    	   vidertablelivre();
		    	   AfficheLivre();
		    	   viderLivreText();
		       }
		  
		  
// -------------------------gestion etudiant----------------------------
		    @FXML
		    private TextField txtcdEt;
		    @FXML
		    private TextField txtNomEtd;
		    @FXML
		    private TextField txtEmail;
		    @FXML
		    private TextField txtPrenomEtd;
		    @FXML
		    private TextField TxtNatio;
		    @FXML
		    private TextField TxtTelEtd;
		    @FXML
		    private ComboBox<String> txtDepar;
		    @FXML
		    private  ComboBox<String> txtFiliere;
		    
		    public void AjouterEtudiant(ActionEvent event){
		    	
		    	int cdEtud = Integer.parseInt(txtcdEt.getText());
			    String nometd=txtNomEtd.getText();
			    String email=txtEmail.getText();
			    String prenomEtd=txtPrenomEtd.getText();
			    String nation=TxtNatio.getText();
			    String teletd=TxtTelEtd.getText();
			    String deprtm=txtDepar.getValue();
			    String filier=txtFiliere.getValue();
			    Etudiant et=new Etudiant(cdEtud,nometd,prenomEtd,teletd,email,nation,deprtm,filier); 
			    int status;
			    status = InterConnexion.saveEtudiant(et);
			   if(status<=0){
			        Alert alert;
			        alert = new Alert(AlertType.ERROR);
			        alert.setTitle("Ajout Etudiant");
			        alert.setHeaderText("Information");
			        alert.setContentText("Echec de l'ajout d'etudiant");
			        alert.showAndWait();
			    }else {
			    	afficherEtuGEN();
			    	
				}
	}
		    
// ......................afficher les etudiants ..........
		    public ObservableList<Etudiant> data1=FXCollections.observableArrayList();
		    public void AfficheEtudiant() {
		    	try{
		    		 Connection con=dbConnection.connect();
	    		    String sql="select* from etudiant";
	    		    PreparedStatement stat=con.prepareStatement(sql);
	    		    ResultSet rs=stat.executeQuery();
	    		  
	    		    while(rs.next()){
	    		    	data1.add(new Etudiant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
	    		    }	
	    		    con.close();
	    		    }catch(SQLException e){
	    		        e.getMessage();
	    		    }
	    		        CodeEtd.setCellValueFactory(new PropertyValueFactory<Etudiant,Integer>("CodeEtd"));
	    			    Nom.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("nom"));
	    			    prenom.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("prenom"));
	    			    tel.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("tel"));
	    			    Email.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("email"));
	    			    nationalt.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("nationalt"));
	    			    depar.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("depar"));
	    			    filiere.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("filiere"));
	    			    tableEtudiant.setItems(data1);
	    			   
				
			}
//------------ RECUPERER LES DONNEES LORS D'UN CLIC D'UNE LIGNE DANS LE TABLEAU VERS LES TEXTFIELDS ----------
		    public void ClicEtudiant(){
			    try {
			        Connection con;
			        con = dbConnection.connect();
			        Etudiant etu=(Etudiant)tableEtudiant.getSelectionModel().getSelectedItem();
			        String sql="select* from Etudiant";
			        PreparedStatement stat=con.prepareStatement(sql);
			        String c = Integer.toString(etu.getCodeEtd());
			        txtcdEt.setText(c);
			        txtNomEtd.setText(etu.getNom());
			        txtEmail.setText(etu.getEmail());
			        txtPrenomEtd.setText(etu.getPrenom());
			        TxtNatio.setText(etu.getNationalt());
			        TxtTelEtd.setText(etu.getTel());
			       
			        stat.close();
			        con.close();
			        
			    }catch(SQLException e)
			    {
			        System.out.println(e);
			    }
			    }
 //---------------suppression d'un etudiant ---------------   
		       @FXML
		 	  public void SupprimerEtudiant(){
		 	        	 Alert alert=new Alert(AlertType.CONFIRMATION);
		 	             alert.setTitle("Confirmation");
		 	             alert.setHeaderText(null);
		 	             alert.setContentText("Voulez-vous vraiment supprimer cet Etudiant  ?");
		 	             Optional <ButtonType> action=alert.showAndWait();
		 	             
		 	             if(action.get()==ButtonType.OK){
		 	                 try{
		 	                 	     Connection con;
		 				        con = dbConnection.connect();
		 				     Etudiant etu=(Etudiant)tableEtudiant.getSelectionModel().getSelectedItem();
		 				        String sql="delete from etudiant where  CODEETD=?";
		 				        PreparedStatement stat=con.prepareStatement(sql);
		 				        stat.setInt(1, etu.getCodeEtd());
		 				        stat.executeUpdate();
		 	        			con.close();
		 	        			afficherEtuGEN();
		 	                 }catch(SQLException e){
		 	                     System.out.println(e);
		 	                 }
		 	                
		 	    }
		 	    
		 	        }
		       
// ------------- pour vider le tableau d'etudiant --------
		       
		       public void vidertableEtudiant() {
			    	for ( int i = 0; i<tableEtudiant.getItems().size(); i++) {
			    		tableEtudiant.getItems().clear();
					    }
			       }
		       public void viderChampEtudiant() {
		    	   txtcdEt.clear();
			        txtNomEtd.clear();
			        txtEmail.clear();
			        txtPrenomEtd.clear();
			        TxtNatio.clear();
			        TxtTelEtd.clear();
			        txtFiliere.getItems().clear();
			        txtDepar.getItems().clear();
			        
		       }
//------------Affiche general des etudiants ---------------------
			  public void afficherEtuGEN() {
				  vidertableEtudiant();
				  AfficheEtudiant();
				  viderChampEtudiant();
				  setData();
				  
			  }
//----------Envoyez du texte dans la liste deroulante des Combobox --------
		    public void setData(){
				txtDepar.getItems().addAll("departement informatique","departement industriel");
				txtFiliere.getItems().addAll("GINFO","GPMC","GINDUS");
				}
		    
//----------------afficher dans l'historique le total des etudiants 
		    
		    
		    static String totalet;
		    @FXML
		    private Text totaletudi;
		    public void AffichetotalEtudiant(){
		  	  try{
		  			  Connection con = dbConnection.connect();
		  		  	  String sql="select count(codeetd) from etudiant" ;	
		  			    PreparedStatement stat=con.prepareStatement(sql);
		  		    ResultSet rs=stat.executeQuery();
		  		    while(rs.next()) {
		  		    	totalet=rs.getString(1);}
		  		    con.close(); 
		  		    }catch(SQLException e){
		  		        e.getMessage();
		  		    }
		  	  		totaletudi.setText(totalet); 
		    }
	//------------------gestion des proffesseurs ----------------
		    
		    
		    //------------Ajout d'un proffesseurs -----------------
		    @FXML
		    private TextField id_proffesseur;
		    @FXML
		    private TextField prenomProf;
		    @FXML
		    private TextField NomProf;
		    @FXML
		    private TextField telephone;
		    @FXML
		    private TextField emailp;
		    @FXML
		    private ComboBox<String> department;

		    
  public void AjouterProffesseur(ActionEvent event){
		    	
		    	int id_prof = Integer.parseInt(id_proffesseur.getText());
			    String nomProf=NomProf.getText();
			    String prenomP=prenomProf.getText();
			    int telp=Integer.parseInt(telephone.getText());
			    String emailpr=emailp.getText();
			    String deprtmP=department.getValue();
			    Proffesseur et=new Proffesseur(id_prof,nomProf,prenomP,deprtmP,telp,emailpr); 
			    int status;
			    status = InterConnexion.saveProffesseur(et);
			   
			   if(status<=0){
			        Alert alert;
			        alert = new Alert(AlertType.ERROR);
			        alert.setTitle("Ajout Etudiant");
			        alert.setHeaderText("Information");
			        alert.setContentText("Echec de l'ajout de proffesseur ");
			        alert.showAndWait();
			    }else {
			    	 afficherProGen();
				}
	}
  //---------set data dans combobox departmeent prof------
  public void setDataProf(){
	  department.getItems().addAll("departement informatique","departement industriel");
		}
 //------------affiche proffesseurs ----------

  public ObservableList<Proffesseur> donneProf=FXCollections.observableArrayList();
  public void AfficheProffesseur() {
  	try{
  		 Connection con=dbConnection.connect();
		    String sql="select* from professeur";
		    PreparedStatement stat=con.prepareStatement(sql);
		    ResultSet rs=stat.executeQuery();
		  
		    while(rs.next()){
		    	donneProf.add(new Proffesseur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6)));
		    }	
		    con.close();
		    }catch(SQLException e){
		        e.getMessage();
		    }
		        id_pro.setCellValueFactory(new PropertyValueFactory<Proffesseur,Integer>("id_prof"));
			    nmp.setCellValueFactory(new PropertyValueFactory<Proffesseur,String>("nom"));
			    prP.setCellValueFactory(new PropertyValueFactory<Proffesseur,String>("prenom"));
			    depP.setCellValueFactory(new PropertyValueFactory<Proffesseur,String>("departement"));
			    telPr.setCellValueFactory(new PropertyValueFactory<Proffesseur,Integer>("telephone"));
			    EMpr.setCellValueFactory(new PropertyValueFactory<Proffesseur,String>("email"));
			    
			    tableProf.setItems(donneProf);
	}
  //----------------suppression Proffesseur-------------------------
  
  @FXML
	  public void SupprimerProf(){
	        	 Alert alert=new Alert(AlertType.CONFIRMATION);
	             alert.setTitle("Confirmation");
	             alert.setHeaderText(null);
	             alert.setContentText("Voulez-vous vraiment supprimer ce Prof  ?");
	             Optional <ButtonType> action=alert.showAndWait();
	             
	             if(action.get()==ButtonType.OK){
	                 try{
	                 	     Connection con;
				        con = dbConnection.connect();
				     Proffesseur pr=(Proffesseur)tableProf.getSelectionModel().getSelectedItem();
				        String sql="delete from Professeur where  id_prof=?";
				        PreparedStatement stat=con.prepareStatement(sql);
				        stat.setInt(1, pr.getId_prof());
				        stat.executeUpdate();
	        			con.close();
	        			afficherProGen();
	                 }catch(SQLException e){
	                     System.out.println(e);
	                 }
	                
	    }
	    
	        } 
  
//------------// RECUPERER LES DONNEES LORS D'UN CLIC D'UNE LIGNE DANS LE TABLEAU VERS LES TEXTFIELDS ----------
  public void ClicProffesseur(){
	    try {
	        Connection con;
	        con = dbConnection.connect();
	        Proffesseur pr=(Proffesseur)tableProf.getSelectionModel().getSelectedItem();
	        String sql="select* from Professeur";
	        PreparedStatement stat=con.prepareStatement(sql);
	        String c = Integer.toString(pr.getId_prof());
	        id_proffesseur.setText(c);
	        NomProf.setText(pr.getNom());
	        prenomProf.setText(pr.getPrenom());
	       // department.setText(pr.getDepartement());
	        emailp.setText(pr.getEmail());
	        String d= Integer.toString(pr.getTelephone());
	        telephone.setText(d);
	        stat.close();
	        con.close();
	        
	    }catch(SQLException e)
	    {
	        System.out.println(e);
	    }
	    }
  
//------------- pour vider le tableau de proffesseur --------
  
  public void vidertableProffesseur() {
   	for ( int i = 0; i<tableProf.getItems().size(); i++) {
   		tableProf.getItems().clear();
		    }
      }
  public void viderChampProffesseur() {
	  id_proffesseur.clear();
      NomProf.clear();
      prenomProf.clear();
      department.getItems().clear();
      emailp.clear();
      telephone.clear();
  }
  
  
 //---------affiche total des proffesseurs 
  
  static String totale;
  @FXML
  private Text totalprof;
  @FXML
  public void afficheProf(){
 			 try{
 				  Connection con = dbConnection.connect();
 			  	  String sql="select count(id_prof) from professeur" ;	
 				    PreparedStatement stat=con.prepareStatement(sql);
 			    ResultSet rs=stat.executeQuery();
 			    while(rs.next()) {
 			    	totale=rs.getString(1);}
 			    con.close(); 
 			    }catch(SQLException e){
 			        e.getMessage();
 			    }
 		    	totalprof.setText(totale); 
  } 
//------------Affiche general des proffesseurs ---------------------
 public void afficherProGen() {
	  vidertableProffesseur() ;
	  AfficheProffesseur();
	  viderChampProffesseur();
	  afficheProf();
	  setDataProf();
	  
	  
 }
 @FXML
 private  ComboBox<String> identifiate;
 @FXML
 private TextField txtid;
 @FXML
 private TextField txrefLivr;
 @FXML
 private DatePicker txtdteDebu;
 @FXML
 private DatePicker txtDateRetr;
 //----------------envoyer les donnes dans le combobox des adherants dans emprunts ---------
 public void setDataEmprut(){
	 identifiate.getItems().addAll("proffesseur","Etudiant");
		}
 
//---------------------------gestion Emprunt--------------------------
  
 public void AjouterEmpruntProff(ActionEvent event){
	 String identifiat=identifiate.getValue();
	 if(identifiat.equals("proffesseur")) {
	 	    int id_prof = Integer.parseInt(txtid.getText());
		    int refLvr=Integer.parseInt(txrefLivr.getText());
		    LocalDate date_debut =txtdteDebu.getValue();
			String dateD =date_debut.toString(); 
			
			LocalDate date_fin =txtDateRetr.getValue();
			String dateF =date_fin.toString(); 
		    
		    EmpruntProf ep=new EmpruntProf(id_prof,refLvr,dateD,dateF); 
		    int status;
		    status = InterConnexion.saveEmpruntProf(ep);
		   
		   if(status<=0){
		        Alert alert;
		        alert = new Alert(AlertType.ERROR);
		        alert.setTitle("Ajout emprunt proffesseur");
		        alert.setHeaderText("Information");
		        alert.setContentText("L'emprunt du proffesseur a echoué ");
		        alert.showAndWait();
		    }else {
		    	affichEmpruntGeneral();
			}
	 }else {
		   int id_prof = Integer.parseInt(txtid.getText());
		    int refLvr=Integer.parseInt(txrefLivr.getText());
		    LocalDate date_debut =txtdteDebu.getValue();
			String dateD =date_debut.toString(); 
			
			LocalDate date_fin =txtDateRetr.getValue();
			String dateF =date_fin.toString(); 
		    
		    EmpruntEtudiant ee=new EmpruntEtudiant(id_prof,refLvr,dateD,dateF); 
		    int status;
		    status = InterConnexion.saveEmpruntEtudiant(ee);
		   
		   if(status<=0){
		        Alert alert;
		        alert = new Alert(AlertType.ERROR);
		        alert.setTitle("Ajout Emprunt etudiant");
		        alert.setHeaderText("Information");
		        alert.setContentText("l'emprunt de cet etudiant a echoue ");
		        alert.showAndWait();
		    }else {
		    	affichEmpruntGeneral();
			}
		 
		 
	 }
	 
}
 //------------------vider les textes fields -------------
 public void vidertextfieldempr() {
	 txtid.clear();;
	 txrefLivr.clear();
	 identifiate.getItems().clear();
	 //txtdteDebu.getItems().clear();
	// txtDateRetr.getItems().clear();
 }
 //------------vider table emprunt------------
 public void viderTbleEmpr() {
	 for ( int i = 0; i<tableEmpruntprof.getItems().size(); i++) {
		 tableEmpruntprof.getItems().clear();
			    }
 }
 
 //--------------------afficher emprunt--------------------
 public ObservableList<EmpruntProf> donneEmpruntprof=FXCollections.observableArrayList();
 public void AfficheEmpruntProf() {
 	try{
 		 Connection con=dbConnection.connect();
		    String sql="select p.id_prof,ref_livre,date_debut,date_fin,prenom from emprunt_prof e ,professeur p where E.ID_PROF=p.ID_PROF ";
		    PreparedStatement stat=con.prepareStatement(sql);
		    ResultSet rs=stat.executeQuery();
		  
		    while(rs.next()){
		    	donneEmpruntprof.add(new EmpruntProf(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5)));
		    }	
		    con.close();
		    }catch(SQLException e){
		        e.getMessage();
		    }
		        id_prof.setCellValueFactory(new PropertyValueFactory<EmpruntProf,Integer>("id_prof"));
			    ref_l.setCellValueFactory(new PropertyValueFactory<EmpruntProf,Integer>("ref_livre"));
			    dateD.setCellValueFactory(new PropertyValueFactory<EmpruntProf,String>("date_debut"));
			    DateF.setCellValueFactory(new PropertyValueFactory<EmpruntProf,String>("date_fin"));
			    pr_ident.setCellValueFactory(new PropertyValueFactory<EmpruntProf,String>("pr_identifiant"));
			    tableEmpruntprof.setItems(donneEmpruntprof);
	}
 
	public void affichEmpruntGeneral()	{
		viderTbleEmpr();
		AfficheEmpruntProf();
		vidertextfieldempr();
		setDataEmprut();
		affichEmpruntEtudG();
	}
//---------------------gestion Emprunt Etudiant(retour)---------------------
	
	//--------------------afficher emprunt--------------------
	 public ObservableList<EmpruntEtudiant> donneEmpruntEtud=FXCollections.observableArrayList();
	 public void AfficheEmpruntEtud() {
	 	try{
	 		 Connection con=dbConnection.connect();
			    String sql="select e.CODEETD,ref_livre,date_debut,date_fin,prenom from emprunt_etudiant e ,etudiant ee where ee.CODEETD=e.CODEETD ";
			    PreparedStatement stat=con.prepareStatement(sql);
			    ResultSet rs=stat.executeQuery();
			  
			    while(rs.next()){
			    	donneEmpruntEtud.add(new EmpruntEtudiant(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			    }	
			    con.close();
			    }catch(SQLException e){
			        e.getMessage();
			    }
			        id_prof1.setCellValueFactory(new PropertyValueFactory<EmpruntEtudiant,Integer>("codeetd"));
				    ref_l1.setCellValueFactory(new PropertyValueFactory<EmpruntEtudiant,Integer>("ref_livre"));
				    dateD1.setCellValueFactory(new PropertyValueFactory<EmpruntEtudiant,String>("date_debut"));
				    DateF1.setCellValueFactory(new PropertyValueFactory<EmpruntEtudiant,String>("date_retour"));
				    pr_ident1.setCellValueFactory(new PropertyValueFactory<EmpruntEtudiant,String>("id_empr"));
				    tableEmpruntEtudiant.setItems(donneEmpruntEtud);
		}
//-----------------vider table -------------
	 public void viderTbleEmprEtd() {
		 for ( int i = 0; i<tableEmpruntEtudiant.getItems().size(); i++) {
			 tableEmpruntEtudiant.getItems().clear();
				    }
	 }
public void affichEmpruntEtudG() {
	 viderTbleEmprEtd();
	 AfficheEmpruntEtud();
}
	 
@Override
	public void initialize(URL location, ResourceBundle resources) {
	setDataEmprut();
	setData();
	setDataProf();
	AfficheLivre();
	AfficheProffesseur();
	AfficheEtudiant();
	afficheProf();
	AffichetotalLivre();
	AffichetotalEtudiant();
	affichEmpruntGeneral();
	affichEmpruntEtudG();
 }
}
