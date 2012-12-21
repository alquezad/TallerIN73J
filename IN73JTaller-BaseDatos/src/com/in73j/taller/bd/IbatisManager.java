package com.in73j.taller.bd;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;


/**
 * 
 * @author Alejandro Quezada
 * Clase controladora de persistencia de bases de datos con el
 * framework ibatis.
 */
public class IbatisManager {

protected SqlMapClient sqlMap;
	
	//Constructor por defecto para base de datos taller
	public IbatisManager(){
		this("com/in73j/taller/bd/resources/sqlMapConfig.xml");
	}
	
	//Constructor para otras bases de datos (otros proyectos)
	public IbatisManager(String path){
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
	}
	
	public void insert(String s, Object obj){
		try {sqlMap.insert(s, obj);}
		catch (SQLException e) { e.printStackTrace();}
	}
	
	public void delete(String s, Object obj) {
		try {sqlMap.delete(s, obj);}
		catch (SQLException e) {e.printStackTrace();}	
	}
	
	@SuppressWarnings("rawtypes")
	public List selectList(String s, Object obj) {
		try {return sqlMap.queryForList(s, obj); }
		catch (SQLException e) {e.printStackTrace(); }
		return null;
	}

	public Object select(String s, Object obj) {
		try {return sqlMap.queryForObject(s, obj);}
		catch (SQLException e) {e.printStackTrace();}
		return null;
	}
	public void update(String s, Object obj) {
		try{ sqlMap.update(s, obj);}
		catch (SQLException e) {e.printStackTrace();}
	}

}
