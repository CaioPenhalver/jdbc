package br.com.fiap.dao;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import br.com.fiap.entity.Assento;

public class AssentoDao extends Dao{
	
	public CachedRowSet listarAssentos() throws Exception{
		try {
			openConn();
			CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
			String sql = "SELECT * FROM ASSENTOS";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			crs.populate(rs);
			return crs;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			closeConn();
		}
	}
	
	public void add(Assento assento) throws Exception{
		try {
			openConn();
			String sql = "INSERT INTO ASSENTOS (ASSENTO) VALUES (?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, assento.getAssento());
			stmt.executeUpdate();
		} catch (Exception e) { 
			e.printStackTrace();
			throw e;
		}finally{
			closeConn();
		}
	}
}
