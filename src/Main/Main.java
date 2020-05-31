package Main;


import cliente.ClienteCadastro;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new ClienteCadastro().setVisible(true);
        });
    }
}
