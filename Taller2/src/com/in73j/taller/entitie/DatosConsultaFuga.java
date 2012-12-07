package com.in73j.taller.entitie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DatosConsultaFuga 
	implements Serializable {
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//OBLIGATORIOS
	  protected int Cod_Cliente;
	  protected int COD_OFI;
	  protected int COM; 
	  protected int ED; 
	  protected String SX; 
	  protected String NIV_EDUC; 
	  protected int RENTA;
	  protected String E_CIVIL;
	  protected int VIG; 
	  protected int TRX_T;
	  protected int TRX_T_1; 
	  protected int TRX_T_2; 
	  protected double SALDO_T_5; 
	  protected double SALDO_T_4; 
	  protected double SALDO_T_3; 
	  protected double SALDO_T_2; 
	  protected double SALDO_T_1; 
	  protected double SALDO_T;
	  
	  //DERIVADOS
	  protected double REN_T; 
	  protected double REN_T_1;
	  protected double REN_T_2;
	  protected double REN_T_3;
	  protected double REN_T_4;
	  
	  //LISTA DE ATRIBUTOS (PARA HACER A ELLOS DE UNA MANERA MÁS FACIL)
	  protected List<String> list = new ArrayList<String>();
	  
	 
	  //METODOS POJO (PLAIN OLD JAVA OBJECT)
	public int getCod_Cliente() {
		return Cod_Cliente;
	}
	public int getCOD_OFI() {
		return COD_OFI;
	}
	public int getCOM() {
		return COM;
	}
	public int getED() {
		return ED;
	}
	public String setSX() {
		return SX;
	}
	public String getNIV_EDUC() {
		return NIV_EDUC;
	}
	public int getRENTA() {
		return RENTA;
	}
	public String getE_CIVIL() {
		return E_CIVIL;
	}
	public int getVIG() {
		return VIG;
	}
	public int getTRX_T() {
		return TRX_T;
	}
	public int getTRX_T_1() {
		return TRX_T_1;
	}
	public int getTRX_T_2() {
		return TRX_T_2;
	}
	public double getSALDO_T_5() {
		return SALDO_T_5;
	}
	public double getSALDO_T_4() {
		return SALDO_T_4;
	}
	public double getSALDO_T_3() {
		return SALDO_T_3;
	}
	public double getSALDO_T_2() {
		return SALDO_T_2;
	}
	public double getSALDO_T_1() {
		return SALDO_T_1;
	}
	public double getSALDO_T() {
		return SALDO_T;
	}
	public double getREN_T() {
		return REN_T;
	}
	public double getREN_T_1() {
		return REN_T_1;
	}
	public double getREN_T_2() {
		return REN_T_2;
	}
	public double getREN_T_3() {
		return REN_T_3;
	}
	public double getREN_T_4() {
		return REN_T_4;
	}
	//SETTERS
	public void setCod_Cliente(int cod_Cliente) {
		Cod_Cliente = cod_Cliente;
		list.add(""+Cod_Cliente);
	}
	public void setCOD_OFI(int cOD_OFI) {
		COD_OFI = cOD_OFI;
		list.add(""+COD_OFI);
	}
	public void setCOM(int cOM) {
		COM = cOM;
		list.add(""+COM);
	}
	public void setED(int eD) {
		ED = eD;
		list.add(""+ED);
	}
	public void setSX(String sX) {
		SX = sX;
		list.add(""+SX);
	}
	public void setNIV_EDUC(String nIV_EDUC) {
		NIV_EDUC = nIV_EDUC;
		list.add(""+NIV_EDUC);
	}
	public void setRENTA(int rENTA) {
		RENTA = rENTA;
		list.add(""+RENTA);
	}
	public void setE_CIVIL(String e_CIVIL) {
		E_CIVIL = e_CIVIL;
		list.add(""+E_CIVIL);
	}
	public void setVIG(int vIG) {
		VIG = vIG;
		list.add(""+VIG);
	}
	public void setTRX_T(int tRX_T) {
		TRX_T = tRX_T;
		list.add(""+TRX_T);
	}
	public void setTRX_T_1(int tRX_T_1) {
		TRX_T_1 = tRX_T_1;
		list.add(""+TRX_T_1);
	}
	public void setTRX_T_2(int tRX_T_2) {
		TRX_T_2 = tRX_T_2;
		list.add(""+TRX_T_2);
	}
	public void setSALDO_T_5(double sALDO_T_5) {
		SALDO_T_5 = sALDO_T_5;
		list.add(""+SALDO_T_5);
	}
	public void setSALDO_T_4(double sALDO_T_4) {
		SALDO_T_4 = sALDO_T_4;
		list.add(""+SALDO_T_4);
	}
	public void setSALDO_T_3(double sALDO_T_3) {
		SALDO_T_3 = sALDO_T_3;
		list.add(""+SALDO_T_3);
	}
	public void setSALDO_T_2(double sALDO_T_2) {
		SALDO_T_2 = sALDO_T_2;
		list.add(""+SALDO_T_2);
	}
	public void setSALDO_T_1(double sALDO_T_1) {
		SALDO_T_1 = sALDO_T_1;
		list.add(""+SALDO_T_1);
	}
	public void setSALDO_T(double sALDO_T) {
		SALDO_T = sALDO_T;
		list.add(""+SALDO_T);
	}
	
	//DERIVADOS
	protected void setREN_T() {
		REN_T = SALDO_T/SALDO_T_1;
		list.add(""+REN_T);
	}
	protected void setREN_T_1() {
		REN_T_1 = SALDO_T_1/SALDO_T_2;
		list.add(""+REN_T_1);
	}
	protected void setREN_T_2() {
		REN_T_2 = SALDO_T_2/SALDO_T_3;
		list.add(""+REN_T_2);
	}
	protected void setREN_T_3() {
		REN_T_3 = SALDO_T_3/SALDO_T_4;
		list.add(""+REN_T_3);
	}
	protected void setREN_T_4() {
		REN_T_4 = SALDO_T_4/SALDO_T_5;
		list.add(""+REN_T_4);
	}
	  
	public List<String> getList(){
		return list;
	}  
	
	public void setRENTS(){
		this.setREN_T();
		this.setREN_T_1();
		this.setREN_T_2();
		this.setREN_T_3();
		this.setREN_T_4();
	}
	
}
