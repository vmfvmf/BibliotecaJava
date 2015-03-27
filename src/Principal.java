
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import lib.jdb.connection.JDBConnection;

public class Principal {

    public static String relPath="c:\\Program Files (x86)\\Biblioteca\\Relatorios\\";
    //public static String relPath="src/Relatorios/";
    private JFPrincipal jp;
    private JDBConnection jdb;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Principal();
    }
    public Principal(){
        promptLogin();
        jp = new JFPrincipal(jdb);
        jp.addWindowListener(new WindowListener() {
            @Override public void windowOpened(WindowEvent e) {}
            @Override public void windowClosing(WindowEvent e) {}
            @Override public void windowClosed(WindowEvent e) { }
            @Override public void windowIconified(WindowEvent e) {}
            @Override public void windowDeiconified(WindowEvent e) {}
            @Override public void windowActivated(WindowEvent e) {}
            @Override public void windowDeactivated(WindowEvent e) {
                if(!jp.isVisible()){
                    jdb.connectDB();
                    jp.show();
                }
            }
        });
        jp.show();
    }
    
    private void promptLogin(){
        jdb = new JDBConnection();
        jdb.setDriver("com.mysql.jdbc.Driver");
        jdb.setURL("jdbc:mysql://localhost/biblioteca");
        jdb.setLoginCancelButtonLabel("Cancelar");
        jdb.setLoginOKButtonLabel("Logar");
        jdb.setLoginPasswordLabel("Senha");
        jdb.setLoginUserLabel("Usuário");
        jdb.setLogInPromptTitle("SISTEMA DE BIBLIOTECA VMF");
        jdb.setUsingLogInPrompt(true);
        jdb.connectDB();
    }
}
