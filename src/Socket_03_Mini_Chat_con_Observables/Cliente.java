package Socket_03_Mini_Chat_con_Observables;

import Socket_01_Conexion_TCP.*;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Cliente implements Runnable {

  private String host;
  private int puerto;
  private String mensaje;

  public Cliente(String host, int puerto, String mensaje) {
    this.host = host;
    this.puerto = puerto;
    this.mensaje = mensaje;
  }

  @Override
  public void run() {
    DataOutputStream out;

    try {
      Socket sc = new Socket(host, puerto);
      out = new DataOutputStream(sc.getOutputStream());

      out.writeUTF(mensaje);

      sc.close();

    } catch (IOException ex) {
      Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
