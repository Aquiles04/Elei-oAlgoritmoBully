/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmobully;

import java.net.Socket;

/**
 *
 * @author alexandre.chaves
 */
public class Processo implements Runnable{
 
    private int id;
    private Boolean coordenador;
    private Boolean participante;
    private String aya;
    private String iaa;
    private String group;
    private Socket socket;

    public Processo(int id, Boolean coordenador, Boolean participante) {
        this.id = id;
        this.coordenador = coordenador;
        this.participante = participante;
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

    public Boolean getParticipante() {
        return participante;
    }

    public void setParticipante(Boolean participante) {
        this.participante = participante;
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

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
