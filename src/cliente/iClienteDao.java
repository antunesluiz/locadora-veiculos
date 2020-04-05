package cliente;

import java.util.ArrayList;

public interface iClienteDao {
	public ArrayList<Cliente> getAllClientes();
	public void addCliente(Cliente cliente);
}
