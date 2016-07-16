package app;

import br.com.fiap.dao.AssentoDao;
import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.entity.Assento;
import br.com.fiap.entity.Usuario;

public class App {

	public static void main(String[] args) {

		
		TeatroManager tm = new TeatroManager();		
		AssentoDao aDao = new AssentoDao();
		UsuarioDao uDao = new UsuarioDao();
		enumerarAssentosDoTeatro(aDao);
		cadastrarUsuarios(uDao);
		
		try {
			tm.reservar(aDao.listarAssentos(), uDao.findByName("nome 15"), "Assento 17");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void enumerarAssentosDoTeatro(AssentoDao aDao){
		for(int i=0; i < 30; i++){
			Assento assento = new Assento();
			assento.setAssento("Assento " + i);
			try {
				aDao.add(assento);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void cadastrarUsuarios(UsuarioDao uDao){
		for(int i=0; i < 20; i++){
			try {
				Usuario usuario = new Usuario();
				usuario.setEmail("email " + i);
				usuario.setUsername("nome " + i);
				usuario.setNumeroReservas(i);
				uDao.add(usuario);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
