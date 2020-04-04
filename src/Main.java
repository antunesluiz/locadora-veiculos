import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Cliente> clientes;
		
		ClienteDaoImpl clienteDaoImpl = new ClienteDaoImpl();
		
		clientes = clienteDaoImpl.getAllClientes();
		
		for (Cliente cliente : clientes) {
			System.out.println(cliente.toString());
		}
	}
}
