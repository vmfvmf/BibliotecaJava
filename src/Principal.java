
import lib.jdb.connection.JDBConnection;

public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JDBConnection jdb = new JDBConnection();
        jdb.setDriver("com.mysql.jdbc.Driver");
        jdb.setURL("jdbc:mysql://localhost/biblioteca");
        jdb.setLoginCancelButtonLabel("Cancelar");
        jdb.setLoginOKButtonLabel("Logar");
        jdb.setLoginPasswordLabel("Senha");
        jdb.setLoginUserLabel("Usuário");
        
        jdb.setUsingLogInPrompt(true);
        jdb.connectDB();
        JFPrincipal jp = new JFPrincipal(jdb);
        jp.show();
    }
    
}
