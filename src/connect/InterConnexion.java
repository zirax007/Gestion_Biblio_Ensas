package connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Etudiant;
import modele.Livre;
import modele.Proffesseur;
public class InterConnexion {
	 public static int save(Livre lv){
	        int st=0;
	        try{
	            String sql="INSERT INTO livre VALUES (?,?,?,?,?,?,?,?)";
	            Connection con=dbConnection.connect();
	            PreparedStatement stat;
	            stat=con.prepareStatement(sql);
	            stat.setString(1,lv.getReftitre());
	            stat.setString(2,lv.getAuteur());
	            stat.setString(3,lv.getClassemnt());
	            stat.setString(4,lv.getTitre());
	            stat.setString(5,lv.getEdition());
	            stat.setString(6,lv.getLangue());
	            stat.setString(7,lv.getType());
	            stat.setInt(8,lv.getQuantite());
	            st=stat.executeUpdate();
	            con.close();
	        }catch(SQLException e){
	        	 e.getMessage();
	        }
	    return st;
	    }
	 public static int saveProffesseur(Proffesseur pr) {
		 int st=0;
	        try{
	            String sql="INSERT INTO professeur VALUES (?,?,?,?,?,?)";
	            Connection con=dbConnection.connect();
	            PreparedStatement stat;
	            stat=con.prepareStatement(sql);
	            stat.setInt(1,pr.getId_prof());
	            stat.setString(2,pr.getNom());
	            stat.setString(3,pr.getPrenom());
	            stat.setString(4,pr.getDepartement());
	            stat.setInt(5,pr.getTelephone());
	            stat.setString(6,pr.getEmail());
	            st=stat.executeUpdate();
	            con.close();
	        }catch(SQLException e){
	        	 e.getMessage();
	        }
	    return st;
	 }
	 
	 public static int saveEtudiant(Etudiant et){
	        int st=0;
	        try{
	            String sql="INSERT INTO etudiant VALUES (?,?,?,?,?,?,?,?)";
	            Connection con=dbConnection.connect();
	            PreparedStatement stat;
	            stat=con.prepareStatement(sql);
	            stat.setInt(1,et.getCodeEtd());
	            stat.setString(2,et.getNom());
	            stat.setString(3,et.getPrenom());
	            stat.setString(4,et.getTel());
	            stat.setString(5,et.getEmail());
	            stat.setString(6,et.getNationalt());
	            stat.setString(7,et.getDepar());
	            stat.setString(8,et.getFiliere());
	            st=stat.executeUpdate();
	            con.close();
	        }catch(SQLException e){
	        	 e.getMessage();
	        }
	    return st;
	    }
	 
	 public static int saveEmpruntProf(EmpruntProf EP){
	        int st=0;
	        try{
	            String sql="INSERT INTO emprunt_prof VALUES (?,?,?,?)";
	            Connection con=dbConnection.connect();
	            PreparedStatement stat;
	            stat=con.prepareStatement(sql);
	            stat.setInt(1,EP.getId_prof());
	            stat.setInt(2,EP.getRef_livre());
	            stat.setString(3,EP.getDate_debut());
	            stat.setString(4,EP.getDate_fin());
	            st=stat.executeUpdate();
	            con.close();
	        }catch(SQLException e){
	        	 e.getMessage();
	        }
	    return st;
	    }
	 
	 public static int saveEmpruntEtudiant(EmpruntEtudiant EE){
	        int st=0;
	        try{
	            String sql="INSERT INTO emprunt_etudiant VALUES (?,?,?,?)";
	            Connection con=dbConnection.connect();
	            PreparedStatement stat;
	            stat=con.prepareStatement(sql);
	            stat.setInt(1,EE.getCodeetd());
	            stat.setInt(2,EE.getRef_livre());
	            stat.setString(3,EE.getDate_debut());
	            stat.setString(4,EE.getDate_retour());
	            st=stat.executeUpdate();
	            con.close();
	        }catch(SQLException e){
	        	 e.getMessage();
	        }
	    return st;
	    }
}
