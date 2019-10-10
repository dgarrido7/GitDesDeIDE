//proba

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	
	public static void Main(String[] args) {
		// TODO Auto-generated method stub
		
		//Arraylist on tindrem tots els membres que realitzaran els cobraments
		ArrayList<Cobrador> Membres=new ArrayList<Cobrador>();
		//Creem un array de cases on nomes tindrem les cases amb contingut
		Casa[] Loc = new Casa[0];
		
		//Creacio del mapa de cases mitjançant el fitxer del mapa i guardarem les cases en el array anteriorment creat
		Mapa.MapaCases("cendrassi.txt");
		Loc=Mapa.getCases();
		
		//Generem els trebalaldors mitjançant el fitxer de les rutes i el arraylist de membres
		Treballadors("cendrassi-rutes.txt",Membres);
		
		//Funcio que comparara les posicions les rutes de tots els treballadors amb les posicions de les cases i també revisara si la casa ha sigut visitada o no
		for(int i=0;i<Membres.size();i++) {
			for(int z=0;z<Loc.length;z++) {
				for(int j=0;j<Membres.get(i).getRuta().length;j++) {
					if(Integer.parseInt(Membres.get(i).getRuta()[j].substring(1,2))==Loc[z].getX()) {
						if(Integer.parseInt(Membres.get(i).getRuta()[j].substring(3,4))==Loc[z].getY()) {
							if(Loc[z].isVisitada()==false) {
								Membres.get(i).setRecaudacio(Membres.get(i).getRecaudacio()+Loc[z].getPagament());
								Loc[z].setVisitada(true);
							System.out.println(Membres.get(i).getNom()+"   "+Membres.get(i).getRuta()[j]+"  CERT");
							}
						}
					}
				}
				
			}
			}
		
		//Sortida per pantlla del que ha recaudat cada treballador
		for(int i=0;i<Membres.size();i++) {
			
			System.out.println(Membres.get(i).getNom()+" Ha recaudat"+Membres.get(i).getRecaudacio());
		}
		
		//sortida per pantalla de les cases no visitades
		for(int i=0;i<Loc.length;i++) {
			if(Loc[i].isVisitada()==false) {
			System.out.println("La casa en les coordenades ("+Loc[i].getX()+","+Loc[i].getY()+") No ha sigut visitada i no s'han recaudat "+Loc[i].getPagament()+"€");
			}
		}
		
		
		
		
		
	}
	
	
	
	//FUNCIO QUE LLEGEIS EL FITXER DE RUTES ON AFEGEIX EN UN ARRAYLIST ELS TREBALLADOS AMB LES VARIABLES DE LES RUTES
	public static void Treballadors(String fitxer,ArrayList Membres) {
		try {
			//DELCARACIO DEL FITXER D'ENTRADA,  EL FITXER DE SORTIDA, EL BUFFER DE SORTIDA I EL DE ENTRADA
		FileReader fileLectura =new FileReader(fitxer);
		BufferedReader buffEntrada = new BufferedReader(fileLectura);
		
		//VARIABLES
		String linia= buffEntrada.readLine();
		String[] Separat;
		String[] Rutes;

		
		while(linia !=null && linia!=" ") {
			Separat=linia.split(", ",2);
			Rutes=Separat[1].split(", ");
			Membres.add(new Cobrador(Separat[0],Rutes));
			linia = buffEntrada.readLine();
		}
		
		
		buffEntrada.close();
		} catch (IOException e) {
			System.out.println("no s'ha pogut trobar el fitxer");
			e.printStackTrace();
		}
		
		
		}
		
	}


