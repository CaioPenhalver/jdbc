package br.com.fiap.dao;

import br.com.fiap.entity.Usuario;

public class UsuarioDao extends Dao{

	public void add(Usuario usuario) throws Exception{
		try {
			openConn();
			String sql = "INSERT INTO USUARIO (USERNAME, EMAIL, N_RESERVAS) VALUES (?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, usuario.getUsername());
			stmt.setString(2, usuario.getUsername());
			stmt.setInt(3, usuario.getNumeroReservas());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			closeConn();
		}
	}
	
	public Usuario findByName(String username) throws Exception{
		try {
			openConn();
			String sql = "SELECT * FROM USUARIO WHERE USERNAME=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			Usuario usuario = null;
			if(rs.next()){
				usuario = new Usuario();
				usuario.setEmail(rs.getString("EMAIL"));
				usuario.setUsername(rs.getString("USERNAME"));
				usuario.setId(rs.getInt("ID"));
				usuario.setNumeroReservas(rs.getInt("N_RESERVAS"));
			}
			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
