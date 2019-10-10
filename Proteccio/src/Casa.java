
public class Casa {
	
	//VARIABLES
	private int pagament=0;
	private boolean visitada=false;
	private int x=0;
	private int y=0;
	
	//CONSTRUCTOR
	
	public Casa(int pagament,int x, int y) {
		this.pagament=pagament;
		this.x=x;
		this.y=y;
	}

	
	//GETTERS I SETTERS

	public int getPagament() {
		return pagament;
	}




	public void setPagament(int pagament) {
		this.pagament = pagament;
	}




	public boolean isVisitada() {
		return visitada;
	}




	public void setVisitada(boolean visitada) {
		this.visitada = visitada;
	}




	public int getX() {
		return x;
	}




	public void setX(int x) {
		this.x = x;
	}




	public int getY() {
		return y;
	}




	public void setY(int y) {
		this.y = y;
	}
	
	

	
	
	
	
	
}
