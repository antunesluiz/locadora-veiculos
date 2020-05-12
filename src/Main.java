import java.util.ArrayList;

import cliente.Cliente;
import cliente.ClienteDaoImpl;
import cliente.StatusCliente;

public class Main {

	public static void main(String[] args) {	
		ClienteDaoImpl clienteDaoImpl = new ClienteDaoImpl();
		
		ArrayList<Cliente> clientes = clienteDaoImpl.getAllClientes();
		
		for (Cliente cliente : clientes) {
			System.out.println(cliente.toString());
		}
		
		//clienteDaoImpl.deletarCliente(1);
		
		clienteDaoImpl.addCliente(new Cliente(1, new StatusCliente(1, "Adiplente"), "Jose", "12345678910", "12345", "M", "31940028922",
				"Rua seila", "000000", 30, "teste", "teste", "teste", "teste", "teste", "teste", 123456, 1));
		
		clienteDaoImpl.close();
	}
}
