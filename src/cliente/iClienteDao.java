package cliente;

import java.util.ArrayList;

public interface iClienteDao {

    public ArrayList<Cliente> getAllClientes();

    public Cliente getClientById(int id);

    public long addCliente(Cliente cliente);

    public boolean deletarCliente(int id);

    public void atualizarCliente(Cliente cliente);
    
    public Cliente checkLogin(String email, String senha);
}
