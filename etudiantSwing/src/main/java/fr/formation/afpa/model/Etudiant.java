package fr.formation.afpa.model;

public class Etudiant {
private String nom;
private String prenom;
private int dateNaissance;



public Etudiant(String nom, String prenom, int dateNaissance) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.dateNaissance = dateNaissance;
	
}





@Override
public String toString() {
	return "Etudiant [nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + "]";
}


	
	
}
