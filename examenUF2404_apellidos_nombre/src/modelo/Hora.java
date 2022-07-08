package modelo;

public class Hora {
	private int Horas;
	private int Minutos;
	private int Segundos;
	
	
	public Hora() {
		this.Horas=00;
		this.Minutos=00;
		this.Segundos=00;
	}


	public Hora(int horas, int minutos, int segundos) {
		if (valida(horas,minutos,segundos)) {
			this.Horas=horas;
			this.Minutos=minutos;
			this.Segundos=segundos;
		} else {
			this.Horas=00;
			this.Minutos=00;
			this.Segundos=00;
		}
	}

	public Hora(Hora h) {
		this.Horas=h.Horas;
		this.Minutos=h.Minutos;
		this.Segundos=h.Segundos;
	}
	
	private static boolean valida(int horas,int minutos, int segundos) {
		if ((horas<=23 && horas>=0) && (minutos<60 && minutos>=0) && (segundos<60 && segundos>=0)){
			return true;
		} else {
			return false;
		}
	}
	
	
	public int getHoras() {
		return Horas;
	}


	public int getMinutos() {
		return Minutos;
	}


	public int getSegundos() {
		return Segundos;
	}

	public void setHora(int horas,int minutos,int segundos) {
		if (valida(horas,minutos,segundos)) {
			this.Horas=horas;
			this.Minutos=minutos;
			this.Segundos=segundos;
		} else {
			this.Horas=00;
			this.Minutos=00;
			this.Segundos=00;
		}
	}
	
	@Override
	public String toString() {
		return "Hora: "+ String.format("%02d:%02d:%02d",this.Horas,this.Minutos,this.Segundos);
	}
	
	public int aSegundos() {
		return this.Horas*3600+this.Minutos*60+this.Segundos;
	}
	
	public void deSegundos(int s) {
		int minuto=s/60;
		int hora=minuto/60;
		int segundo=s%60;
		minuto=minuto%60;
		hora=hora%24;
		setHora(hora,minuto,segundo);
	}
	
	public int segundosEntre(Hora h) {
		//return (this.Horas*3600+this.Minutos*60+this.Segundos)-(h.Horas*3600+h.Minutos*60+h.Segundos);	
		return this.aSegundos()-h.aSegundos();
	}
	
}
