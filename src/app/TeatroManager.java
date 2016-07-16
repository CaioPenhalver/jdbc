package app;

import javax.sql.rowset.CachedRowSet;

import br.com.fiap.dao.Dao;
import br.com.fiap.entity.Usuario;

public class TeatroManager extends Dao{

	public void reservar(CachedRowSet crs, Usuario usuario, String assento){
		try {
			openConn();
			conn.setAutoCommit(false);
			String sql = "UPDATE USUARIO SET N_RESERVAS=? WHERE ID=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, usuario.getNumeroReservas()+1);
			stmt.setInt(2, usuario.getId());
			stmt.executeUpdate();
			while(crs.next()){
				System.out.println(usuario.getId());
				if(crs.getString("ASSENTO").equals(assento)){
					crs.updateInt("USUARIO_ID", usuario.getId());
					crs.updateRow();
					break;
				}
			}
			crs.acceptChanges(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
