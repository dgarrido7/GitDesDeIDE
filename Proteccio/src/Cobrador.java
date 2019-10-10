import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Cobrador {
	
	//VARIABLES
	private String nom=" ";
	private int recaudacio=0;
	private String[] ruta;
	


//CONSTRUCTOR
public Cobrador(String nom, String[] ruta) {
		super();
		this.nom = nom;
		this.ruta = ruta;
	}


//GETTERS I SETTERS

public String getNom() {
	return nom;
}



public void setNom(String nom) {
	this.nom = nom;
}



public int getRecaudacio() {
	return recaudacio;
}



public void setRecaudacio(int recaudacio) {
	this.recaudacio = recaudacio;
}



public String[] getRuta() {
	return ruta;
}



public void setRuta(String[] ruta) {
	this.ruta = ruta;
}




}


