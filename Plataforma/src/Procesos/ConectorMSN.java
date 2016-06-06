/*
 * ****PLATAFORMA SHUY VERSION****
 * -VALOR Y CONFIANZA-
 * Software desarrollado completamente en las poderosas manos de Jose Jesus Garcia Cuadra
 */
package Procesos;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chuy
 */
public class ConectorMSN {

    private Socket s;
    private ServerSocket ss;
    private InputStreamReader entradaSocket;
    private DataOutputStream salida;
    private BufferedReader entrada;
    final int puerto = 4314;

    public ConectorMSN() {
        try {

            ss = new ServerSocket(puerto);
            s = ss.accept();

            entradaSocket = new InputStreamReader(s.getInputStream());
            entrada = new BufferedReader(entradaSocket);

            salida = new DataOutputStream(s.getOutputStream());

        } catch (IOException ex) {
        };

    }

    public ConectorMSN(String ip) {
        try {
            s = new Socket(ip, puerto);
            entradaSocket = new InputStreamReader(s.getInputStream());
            entrada = new BufferedReader(entradaSocket);

            salida = new DataOutputStream(s.getOutputStream());

        } catch (IOException ex) {
        };

    }

    public void Send(String msg) {
        try {
            salida.writeUTF(msg);
        } catch (IOException ex) {
        };
    }

    public String Read() {
        try {
            return entrada.readLine();
        } catch (IOException ex) {
        };
        return null;
    }
}


