package modelo;

import excepciones.UserNameRepetido_Exception;

public class Operario
{
    private String NyA;
    private String userName;
    private String password;
    private boolean activo;
    
    public Operario(String nyA, String userName, String password, boolean activo) {
		super();
		NyA = nyA;
		this.userName = userName;
		this.password = password;
		this.activo = activo;
	}

	public void modificaOperario(String NyA, String userName, String password, boolean activo){}
    
    // Al comienzo de la jornada, el operario asignará a cada mozo las mesas que le correspondan
    //public void asignaMesas(Mozo mozo, Mesa mesa) {}
    
    public boolean verificaPassword(String password) {
		return password == this.password;
	}

	public void setNyA(String nyA) {
		NyA = nyA;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getNyA() {
		return NyA;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public boolean isActivo() {
		return activo;
	}
    
}
