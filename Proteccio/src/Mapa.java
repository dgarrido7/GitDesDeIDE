import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Mapa {
	
	public Mapa() {
	}
	//ARRAY DE CASES
	private static Casa[] Cases=new Casa[0];
	
	//FUNCIO QUE LLEGEIX EL MAPA I CREA LES CASES I LES AFEGEIX EN EL ARRAY DE CASES
	public static void MapaCases(String fitxer) {
		try {
			//DELCARACIO DEL FITXER D'ENTRADA,  EL FITXER DE SORTIDA, EL BUFFER DE SORTIDA I EL DE ENTRADA
		FileReader fileLectura =new FileReader(fitxer);
		BufferedReader buffEntrada = new BufferedReader(fileLectura);
		
		//VARIABLES FUNCIO
		String linia= buffEntrada.readLine();
		int contador=0;
		int longitud=0;
		int x=0;
		int y=0;
		String[] pagaments= new String[0];
		int numC=0;
		
		//QUE IDENTIFICARA LES CASES I GUARDARA LA SEVA POSICIO I PAGAMENT EN EL ARRAY DE CASES
		while(linia !=null && linia!=" ") {
			
			if(contador>=2 && longitud!=y) {
				for (int i=0; i<x;i++) {
						if(linia.charAt(i)=='X') {
							Cases[numC]=new Casa(Integer.valueOf(pagaments[numC]),i,longitud);
							numC++;
						}
				}
				longitud++;
			}
			
			if(contador==1) {
				pagaments=linia.split(", ");
				Cases=new Casa[pagaments.length];
				contador++;
			}
			
			if(contador==0) {
				String[] separat=linia.split("x");
				x=Integer.valueOf(separat[0]);
				y=Integer.valueOf(separat[1]);
				contador++;
				
			}
			linia = buffEntrada.readLine();
		}
		
		
		//UN COP REVISAT TOTS ELS CASOS, FAREM UNA SORTIDA AMB EL NOMBRE TOTALS DE LLIBRES REVISATS
		buffEntrada.close();
		} catch (IOException e) {
			System.out.println("no s'ha pogut trobar el fitxer");
			e.printStackTrace();
		}
	}




	public static Casa[] getCases() {
		return Cases;
	}

	public static void setCases(Casa[] cases) {
		Cases = cases;
	}



	

	
}
