/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objeto;

import java.io.Serializable;
import java.util.Date;

/**
 * UNICARIOCA
 * @author Danielle Pereira da Silva Custodio
 * Turma 836
 * Disciplina: Desenvolvimento de Aplicações Distribuídas
 * Ano: 2018
 */
public class Request implements Serializable {
    public static final int SEND_FILE_LIST = 1;
    public static final int UPLOADING = 2;
    public static final int DOWNLOAD = 3;
    
    private int requestType;
    private String fileName;
    private Date dataModFile;
    private byte[] fileByte;

    public int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getDataModFile() {
        return dataModFile;
    }

    public void setDataModFile(Date dataModFile) {
        this.dataModFile = dataModFile;
    }

    public byte[] getFileByte() {
        return fileByte;
    }

    public void setFileByte(byte[] fileByte) {
        this.fileByte = fileByte;
    }
    
    
}
