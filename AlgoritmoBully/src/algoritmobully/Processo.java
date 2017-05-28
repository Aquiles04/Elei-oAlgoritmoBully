/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmobully;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexandre.chaves
 */
public class Processo implements Runnable {

    private int id;
    private Boolean coordenador;
    //mensagens se fossem boolean mais facil?
    private String aya = "Are you alive?";
    private String iaa = "I am alive";
    private String aic = "Am i coordinator?";
    private String group = "224.0.0.1";
    private MulticastSocket mSocket;
    private DatagramSocket socket;
    private Random rand = new Random();
    private int opcao;
    private byte[] receive = new byte[1024];
    //private byte[] send = new byte[1024];
    private int portaCoordenador;
    private int portaGrupo = 77777;

    public Processo() throws SocketException, IOException {

        //int espera = rand.nextInt((30 - 5 + 1)+5);
        this.id = rand.nextInt(1000);
        this.coordenador = false;
        this.mSocket = new MulticastSocket(portaGrupo);
        this.socket = new DatagramSocket();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Boolean coordenador) {
        this.coordenador = coordenador;
    }

    public String getAya() {
        return aya;
    }

    public void setAya(String aya) {
        this.aya = aya;
    }

    public String getIaa() {
        return iaa;
    }

    public void setIaa(String iaa) {
        this.iaa = iaa;
    }

    public String getAic() {
        return aic;
    }

    public void setAic(String aic) {
        this.aic = aic;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public MulticastSocket getmSocket() {
        return mSocket;
    }

    public void setmSocket(MulticastSocket mSocket) {
        this.mSocket = mSocket;
    }

    public DatagramSocket getSocket() {
        return socket;
    }

    public void setSocket(DatagramSocket socket) {
        this.socket = socket;
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    public byte[] getReceive() {
        return receive;
    }

    public void setReceive(byte[] receive) {
        this.receive = receive;
    }

    public int getPortaCoordenador() {
        return portaCoordenador;
    }

    public void setPortaCoordenador(int portaCoordenador) {
        this.portaCoordenador = portaCoordenador;
    }

    public int getPortaGrupo() {
        return portaGrupo;
    }

    public void setPortaGrupo(int portaGrupo) {
        this.portaGrupo = portaGrupo;
    }
    
    

    // Referencia ? http://tutorials.jenkov.com/java-multithreaded-servers/multithreaded-server.html
    @Override
    public void run() {

        //criar socket
        // criar multicast socket entrar no grupo
        try {
            Processo p = new Processo();
            InetAddress iGroup = InetAddress.getByName(p.group);
            p.mSocket.joinGroup(iGroup);
            DatagramPacket sendPacket = new DatagramPacket(p.aic.getBytes(), p.aic.length(), iGroup, p.portaGrupo);
            DatagramPacket receivePacket = new DatagramPacket(receive, receive.length);
            // 1 mensagem para grupo who the fuck is the coordenador?
            p.mSocket.send(sendPacket);
            p.mSocket.receive(receivePacket);
            
            // Colocar tempo aguardando ... se nao houver resposta coordenador = true else false
            System.out.println(receivePacket);
            
            while (true) {

                // fazer um if para cada situacao setar um case = x que eh a opcao da thread
                //if eleicao
                //if coordenador
                //if 
                if (p.getCoordenador() == true)
                {
                    // Sou coordenador do ?
                    opcao = 1;
                }
                
                if (p.getCoordenador() == false)
                {
                    portaCoordenador = receivePacket.getPort();
                    opcao = 2;
                }
                
                switch (opcao) {
                    case 1:
                        break;
                    case 2:
                        break;

                    default:

                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Processo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
