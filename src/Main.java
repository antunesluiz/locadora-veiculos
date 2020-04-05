import java.util.ArrayList;

import cliente.Cliente;
import cliente.ClienteDaoImpl;

public class Main {

	public static void main(String[] args) {	
		ClienteDaoImpl clienteDaoImpl = new ClienteDaoImpl();
		
		ArrayList<Cliente> clientes = clienteDaoImpl.getAllClientes();
		
		for (Cliente cliente : clientes) {
			System.out.println(cliente.toString());
		}
	}
}
