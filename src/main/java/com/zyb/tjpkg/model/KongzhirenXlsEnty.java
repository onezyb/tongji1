package com.zyb.tjpkg.model;

import com.zyb.tjpkg.anno.ExcelColumn;

import java.util.List;

public class KongzhirenXlsEnty {

    /**
     * NUMBER : 0
     * PID :
     * ID : 8AFE92676634728A2B4F658CAF7E5514
     * NUMBERTYPE : null
     * LASTNODE : 0
     * TYPE : GS
     * CHILDREN : [{"NUMBER":0.3981,"PID":"8AFE92676634728A2B4F658CAF7E5514","NUMBERTYPE":"控股","ID":"6665D85ED45E09DED5426094C7C0F719","LASTNODE":"1","TYPE":"GS","CHILDREN":null,"NAME":"中国航天科工集团有限公司","ATTR":"2"},{"NUMBER":0.0332,"PID":"8AFE92676634728A2B4F658CAF7E5514","NUMBERTYPE":"参股","ID":"DA04E5FD74F056EE4F2099BDE5B02458","LASTNODE":"0","TYPE":"GS","CHILDREN":null,"NAME":"中国航天科工飞航技术研究院（中国航天海鹰机电技术研究院）","ATTR":"1"},{"NUMBER":0.029,"PID":"8AFE92676634728A2B4F658CAF7E5514","NUMBERTYPE":"参股","ID":"9D027A843EC20FC45737786A088DAC35","LASTNODE":"0","TYPE":"GS","CHILDREN":null,"NAME":"中国证券金融股份有限公司","ATTR":"1"},{"NUMBER":0.0276,"PID":"8AFE92676634728A2B4F658CAF7E5514","NUMBERTYPE":"参股","ID":"BBA4058FB2C5904A73850DE4939208A2","LASTNODE":"0","TYPE":"GS","CHILDREN":null,"NAME":"北京航天爱威电子技术有限公司","ATTR":"1"},{"NUMBER":0.0155,"PID":"8AFE92676634728A2B4F658CAF7E5514","NUMBERTYPE":"参股","ID":"072CC9ECFFF65AAC433630A52029525E","LASTNODE":"0","TYPE":"GS","CHILDREN":null,"NAME":"中央汇金资产管理有限责任公司","ATTR":"1"},{"NUMBER":0.0145,"PID":"8AFE92676634728A2B4F658CAF7E5514","NUMBERTYPE":"参股","ID":"C0C7772D9C3BE21721C89365567D210C","LASTNODE":"0","TYPE":"GS","CHILDREN":null,"NAME":"香港中央结算有限公司","ATTR":"1"},{"NUMBER":0.0118,"PID":"8AFE92676634728A2B4F658CAF7E5514","NUMBERTYPE":"参股","ID":"C60084A814174FA4F7AD5BBAFC8DF8EF","LASTNODE":"0","TYPE":"GS","CHILDREN":null,"NAME":"全国社保基金一零三组合","ATTR":"1"},{"NUMBER":0.0089,"PID":"8AFE92676634728A2B4F658CAF7E5514","NUMBERTYPE":"参股","ID":"F3414230A39584D93867ACA3617D3B65","LASTNODE":"0","TYPE":"GS","CHILDREN":null,"NAME":"北京机电工程总体设计部","ATTR":"1"},{"NUMBER":0.008,"PID":"8AFE92676634728A2B4F658CAF7E5514","NUMBERTYPE":"参股","ID":"BB987279C16050A2E0AB5ED6B3DF2BAD","LASTNODE":"0","TYPE":"GS","CHILDREN":null,"NAME":"中国长城工业集团有限公司","ATTR":"1"},{"NUMBER":0.0079,"PID":"8AFE92676634728A2B4F658CAF7E5514","NUMBERTYPE":"参股","ID":"1265329E5A6F64FBAF04E448409A5B13","LASTNODE":"0","TYPE":"GS","CHILDREN":null,"NAME":"博时基金－农业银行－博时中证金融资产管理计划","ATTR":"1"}]
     * NAME : 航天信息股份有限公司
     * ATTR : 2
     */

    @ExcelColumn(value="NUMBER" ,col = 1)private int NUMBER;
    @ExcelColumn(value="PID" ,col = 2)private String PID;
    @ExcelColumn(value="ID" ,col = 3)private String ID;
    private Object NUMBERTYPE;
    @ExcelColumn(value="LASTNODE" ,col = 4)private String LASTNODE;
    @ExcelColumn(value="TYPE" ,col = 5)private String TYPE;
    @ExcelColumn(value="NAME" ,col = 6)private String NAME;
    @ExcelColumn(value="ATTR" ,col = 7)private String ATTR;
    private List<CHILDRENBean> CHILDREN;
    @ExcelColumn(value="KGGS" ,col = 8)private String KGGS;

    public String getKGGR() {
        return KGGR;
    }

    public void setKGGR(String KGGR) {
        this.KGGR = KGGR;
    }

    @ExcelColumn(value="KGGR" ,col = 9)private String KGGR;

    public String getKGGS() {
        return KGGS;
    }

    public void setKGGS(String KGGS) {
        this.KGGS = KGGS;
    }

    public int getNUMBER() {
        return NUMBER;
    }

    public void setNUMBER(int NUMBER) {
        this.NUMBER = NUMBER;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Object getNUMBERTYPE() {
        return NUMBERTYPE;
    }

    public void setNUMBERTYPE(Object NUMBERTYPE) {
        this.NUMBERTYPE = NUMBERTYPE;
    }

    public String getLASTNODE() {
        return LASTNODE;
    }

    public void setLASTNODE(String LASTNODE) {
        this.LASTNODE = LASTNODE;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getATTR() {
        return ATTR;
    }

    public void setATTR(String ATTR) {
        this.ATTR = ATTR;
    }

    public List<CHILDRENBean> getCHILDREN() {
        return CHILDREN;
    }

    public void setCHILDREN(List<CHILDRENBean> CHILDREN) {
        this.CHILDREN = CHILDREN;
    }

    public static class CHILDRENBean {
        /**
         * NUMBER : 0.3981
         * PID : 8AFE92676634728A2B4F658CAF7E5514
         * NUMBERTYPE : 控股
         * ID : 6665D85ED45E09DED5426094C7C0F719
         * LASTNODE : 1
         * TYPE : GS
         * CHILDREN : null
         * NAME : 中国航天科工集团有限公司
         * ATTR : 2
         */

        private double NUMBER;
        private String PID;
        private String NUMBERTYPE;
        private String ID;
        private String LASTNODE;
        private String TYPE;
        private Object CHILDREN;
        private String NAME;
        private String ATTR;

        public double getNUMBER() {
            return NUMBER;
        }

        public void setNUMBER(double NUMBER) {
            this.NUMBER = NUMBER;
        }

        public String getPID() {
            return PID;
        }

        public void setPID(String PID) {
            this.PID = PID;
        }

        public String getNUMBERTYPE() {
            return NUMBERTYPE;
        }

        public void setNUMBERTYPE(String NUMBERTYPE) {
            this.NUMBERTYPE = NUMBERTYPE;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getLASTNODE() {
            return LASTNODE;
        }

        public void setLASTNODE(String LASTNODE) {
            this.LASTNODE = LASTNODE;
        }

        public String getTYPE() {
            return TYPE;
        }

        public void setTYPE(String TYPE) {
            this.TYPE = TYPE;
        }

        public Object getCHILDREN() {
            return CHILDREN;
        }

        public void setCHILDREN(Object CHILDREN) {
            this.CHILDREN = CHILDREN;
        }

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }

        public String getATTR() {
            return ATTR;
        }

        public void setATTR(String ATTR) {
            this.ATTR = ATTR;
        }
    }
}
