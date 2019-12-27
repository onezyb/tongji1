package com.zyb.tjpkg.model;

import com.zyb.tjpkg.anno.ExcelColumn;

public class BasicInfoXlsEnty {


    /**
     * INDUSTRY_CODE : C
     * ENTSTATUS : 在营（开业）企业
     * CANDATE :
     * REGORG : 深圳市市场监督管理局
     * OLDNAME :
     * JWD : 东经：113.864950 北纬：22.807750
     * APPRDATE : 2019-06-28
     * OPFROM : 2004-06-30
     * SHXYDM : 91440300763492613P
     * ORGID : 763492613
     * DOM : 深圳市宝安区松岗街道燕川社区红湖路108号2号楼2楼、3号楼2、3楼
     * INDUSTRY : 制造业
     * REGCAP : 500
     * REGCAPCUR : 人民币
     * REVDATE :
     * ENTTYPE : 有限责任公司
     * FRDB : 冯坚
     * ENDDATE :
     * OPSCOPE : 一般经营项目是：电子元器件、光纤耦合器、连接器、半导体光电照明产品、LED光电产品、家用电器、电脑周边设备、手机及配件、通讯设备及其零配件、软件、全球通多功能插座、IEC精密插座、USB精密插座、消费电子、电源、模具的研发、设计与销售；办公用品、劳保用品、礼品、广告促销品（不含食品及其他须经前置审批的项目）的销售；国内贸易、货物及技术进出口。（法律、行政法规或者国务院决定禁止和规定在登记前须经批准的项目除外），许可经营项目是：电子元器件、光纤耦合器、连接器、半导体光电照明产品、LED光电产品、家用电器、电脑周边设备、手机及配件、通讯设备及其零配件、软件、全球通多功能插座、IEC精密插座、USB精密插座、消费电子、电源、模具的生产。
     * ESDATE : 2004-06-30
     * OPTO : 长期
     * PROVINCE : 广东省
     * ENTNAME : 深圳市仁达电子有限公司
     * ENGNAME : STEADY ELECTRONICS CORPORATION
     * WEBSITE : http://www.steady.cn
     */

    @ExcelColumn(value="INDUSTRY_CODE" ,col = 1)private String INDUSTRY_CODE;
    @ExcelColumn(value="ENTSTATUS" ,col = 2)private String ENTSTATUS;
    @ExcelColumn(value="CANDATE" ,col = 3)private String CANDATE;
    @ExcelColumn(value="REGORG" ,col = 4)private String REGORG;
    @ExcelColumn(value="OLDNAME" ,col = 5)private String OLDNAME;
    @ExcelColumn(value="JWD" ,col = 6)private String JWD;
    @ExcelColumn(value="APPRDATE" ,col = 7)private String APPRDATE;
    @ExcelColumn(value="OPFROM" ,col = 8)private String OPFROM;
    @ExcelColumn(value="SHXYDM" ,col = 9)private String SHXYDM;
    @ExcelColumn(value="ORGID" ,col = 10)private String ORGID;
    @ExcelColumn(value="DOM" ,col = 11)private String DOM;
    @ExcelColumn(value="INDUSTRY" ,col = 12)private String INDUSTRY;
    @ExcelColumn(value="REGCAP" ,col = 13)private int REGCAP;
    @ExcelColumn(value="REGCAPCUR" ,col = 14)private String REGCAPCUR;
    @ExcelColumn(value="REVDATE" ,col = 15)private String REVDATE;
    @ExcelColumn(value="ENTTYPE" ,col = 16)private String ENTTYPE;
    @ExcelColumn(value="FRDB" ,col = 17)private String FRDB;
    @ExcelColumn(value="ENDDATE" ,col = 18)private String ENDDATE;
    @ExcelColumn(value="OPSCOPE" ,col = 19)private String OPSCOPE;
    @ExcelColumn(value="ESDATE" ,col = 20)private String ESDATE;
    @ExcelColumn(value="OPTO" ,col = 21)private String OPTO;
    @ExcelColumn(value="PROVINCE" ,col = 22)private String PROVINCE;
    @ExcelColumn(value="ENTNAME" ,col = 23)private String ENTNAME;
    @ExcelColumn(value="ENGNAME" ,col = 24)private String ENGNAME;
    @ExcelColumn(value="WEBSITE" ,col = 25)private String WEBSITE;

    public String getINDUSTRY_CODE() {
        return INDUSTRY_CODE;
    }

    public void setINDUSTRY_CODE(String INDUSTRY_CODE) {
        this.INDUSTRY_CODE = INDUSTRY_CODE;
    }

    public String getENTSTATUS() {
        return ENTSTATUS;
    }

    public void setENTSTATUS(String ENTSTATUS) {
        this.ENTSTATUS = ENTSTATUS;
    }

    public String getCANDATE() {
        return CANDATE;
    }

    public void setCANDATE(String CANDATE) {
        this.CANDATE = CANDATE;
    }

    public String getREGORG() {
        return REGORG;
    }

    public void setREGORG(String REGORG) {
        this.REGORG = REGORG;
    }

    public String getOLDNAME() {
        return OLDNAME;
    }

    public void setOLDNAME(String OLDNAME) {
        this.OLDNAME = OLDNAME;
    }

    public String getJWD() {
        return JWD;
    }

    public void setJWD(String JWD) {
        this.JWD = JWD;
    }

    public String getAPPRDATE() {
        return APPRDATE;
    }

    public void setAPPRDATE(String APPRDATE) {
        this.APPRDATE = APPRDATE;
    }

    public String getOPFROM() {
        return OPFROM;
    }

    public void setOPFROM(String OPFROM) {
        this.OPFROM = OPFROM;
    }

    public String getSHXYDM() {
        return SHXYDM;
    }

    public void setSHXYDM(String SHXYDM) {
        this.SHXYDM = SHXYDM;
    }

    public String getORGID() {
        return ORGID;
    }

    public void setORGID(String ORGID) {
        this.ORGID = ORGID;
    }

    public String getDOM() {
        return DOM;
    }

    public void setDOM(String DOM) {
        this.DOM = DOM;
    }

    public String getINDUSTRY() {
        return INDUSTRY;
    }

    public void setINDUSTRY(String INDUSTRY) {
        this.INDUSTRY = INDUSTRY;
    }

    public int getREGCAP() {
        return REGCAP;
    }

    public void setREGCAP(int REGCAP) {
        this.REGCAP = REGCAP;
    }

    public String getREGCAPCUR() {
        return REGCAPCUR;
    }

    public void setREGCAPCUR(String REGCAPCUR) {
        this.REGCAPCUR = REGCAPCUR;
    }

    public String getREVDATE() {
        return REVDATE;
    }

    public void setREVDATE(String REVDATE) {
        this.REVDATE = REVDATE;
    }

    public String getENTTYPE() {
        return ENTTYPE;
    }

    public void setENTTYPE(String ENTTYPE) {
        this.ENTTYPE = ENTTYPE;
    }

    public String getFRDB() {
        return FRDB;
    }

    public void setFRDB(String FRDB) {
        this.FRDB = FRDB;
    }

    public String getENDDATE() {
        return ENDDATE;
    }

    public void setENDDATE(String ENDDATE) {
        this.ENDDATE = ENDDATE;
    }

    public String getOPSCOPE() {
        return OPSCOPE;
    }

    public void setOPSCOPE(String OPSCOPE) {
        this.OPSCOPE = OPSCOPE;
    }

    public String getESDATE() {
        return ESDATE;
    }

    public void setESDATE(String ESDATE) {
        this.ESDATE = ESDATE;
    }

    public String getOPTO() {
        return OPTO;
    }

    public void setOPTO(String OPTO) {
        this.OPTO = OPTO;
    }

    public String getPROVINCE() {
        return PROVINCE;
    }

    public void setPROVINCE(String PROVINCE) {
        this.PROVINCE = PROVINCE;
    }

    public String getENTNAME() {
        return ENTNAME;
    }

    public void setENTNAME(String ENTNAME) {
        this.ENTNAME = ENTNAME;
    }

    public String getENGNAME() {
        return ENGNAME;
    }

    public void setENGNAME(String ENGNAME) {
        this.ENGNAME = ENGNAME;
    }

    public String getWEBSITE() {
        return WEBSITE;
    }

    public void setWEBSITE(String WEBSITE) {
        this.WEBSITE = WEBSITE;
    }
}
