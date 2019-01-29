/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objeto;

import java.io.File;
import java.io.Serializable;
import java.util.List;

/**
 * UNICARIOCA
 * @author Danielle Pereira da Silva Custodio
 * Turma 836
 * Disciplina: Desenvolvimento de Aplicações Distribuídas
 * Ano: 2018
 */
public class Reply implements Serializable {
    public static final int SENDIND_FILE_LIST = 1;
    public static final int SENDIND_FILE = 2;
    
    private int replyType;
    private String fileName;
    private List<File> directoryList;
    private byte[] fileByte;

    public byte[] getFileByte() {
        return fileByte;
    }

    public void setFileByte(byte[] fileByte) {
        this.fileByte = fileByte;
    }

    public int getReplyType() {
        return replyType;
    }

    public void setReplyType(int replyType) {
        this.replyType = replyType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<File> getDirectoryList() {
        return directoryList;
    }

    public void setDirectoryList(List<File> directoryList) {
        this.directoryList = directoryList;
    }
    
    
    
}
