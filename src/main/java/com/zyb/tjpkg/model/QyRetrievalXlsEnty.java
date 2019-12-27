package com.zyb.tjpkg.model;

import com.zyb.tjpkg.anno.ExcelColumn;

public class QyRetrievalXlsEnty {

    /**
     * IS_JYZXGS :
     * DOM : 北京市海淀区紫竹院路116号B座一层B109及二层
     * ESDATE : 2015-11-02
     * ENTSTATUS : 在营（开业）企业
     * REGCAP : 10000
     * WEBURL : www.i-xinnuo.com
     * TEL : 010-68778917
     * ENTNAME : 爱信诺征信有限公司
     * FRDB : 管延安
     * EMAIL : hxzx.liuguangli@aisino.com
     * SHXYDM : 91110108MA001K7YXU
     * OLDNAME :
     */

    @ExcelColumn(value="IS_JYZXGS" ,col = 1)private String IS_JYZXGS;
    @ExcelColumn(value="DOM" ,col = 2)private String DOM;
    @ExcelColumn(value="ESDATE" ,col = 3)private String ESDATE;
    @ExcelColumn(value="ENTSTATUS" ,col = 4)private String ENTSTATUS;
    @ExcelColumn(value="REGCAP" ,col = 5)private int REGCAP;
    @ExcelColumn(value="WEBURL" ,col = 6)private String WEBURL;
    @ExcelColumn(value="TEL" ,col = 7)private String TEL;
    @ExcelColumn(value="ENTNAME" ,col = 8)private String ENTNAME;
    @ExcelColumn(value="FRDB" ,col = 9)private String FRDB;
    @ExcelColumn(value="EMAIL" ,col = 10)private String EMAIL;
    @ExcelColumn(value="SHXYDM" ,col = 11)private String SHXYDM;
    @ExcelColumn(value="OLDNAME" ,col = 12)private String OLDNAME;

    public String getIS_JYZXGS() {
        return IS_JYZXGS;
    }

    public void setIS_JYZXGS(String IS_JYZXGS) {
        this.IS_JYZXGS = IS_JYZXGS;
    }

    public String getDOM() {
        return DOM;
    }

    public void setDOM(String DOM) {
        this.DOM = DOM;
    }

    public String getESDATE() {
        return ESDATE;
    }

    public void setESDATE(String ESDATE) {
        this.ESDATE = ESDATE;
    }

    public String getENTSTATUS() {
        return ENTSTATUS;
    }

    public void setENTSTATUS(String ENTSTATUS) {
        this.ENTSTATUS = ENTSTATUS;
    }

    public int getREGCAP() {
        return REGCAP;
    }

    public void setREGCAP(int REGCAP) {
        this.REGCAP = REGCAP;
    }

    public String getWEBURL() {
        return WEBURL;
    }

    public void setWEBURL(String WEBURL) {
        this.WEBURL = WEBURL;
    }

    public String getTEL() {
        return TEL;
    }

    public void setTEL(String TEL) {
        this.TEL = TEL;
    }

    public String getENTNAME() {
        return ENTNAME;
    }

    public void setENTNAME(String ENTNAME) {
        this.ENTNAME = ENTNAME;
    }

    public String getFRDB() {
        return FRDB;
    }

    public void setFRDB(String FRDB) {
        this.FRDB = FRDB;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getSHXYDM() {
        return SHXYDM;
    }

    public void setSHXYDM(String SHXYDM) {
        this.SHXYDM = SHXYDM;
    }

    public String getOLDNAME() {
        return OLDNAME;
    }

    public void setOLDNAME(String OLDNAME) {
        this.OLDNAME = OLDNAME;
    }
}
