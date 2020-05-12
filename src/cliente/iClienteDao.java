package cliente;

import java.util.ArrayList;

public interface iClienteDao {
	public ArrayList<Cliente> getAllClientes();
	public void addCliente(Cliente cliente);
	public void deletarCliente(int id);
	public void atualizarCliente(Cliente cliente);
}
