package com.zyb.tjpkg.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "upsylsys")
public class OutInterfaceLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "serial_number")
    private String serialNumber;

    /**
     * 外部接口是否调用成功：0成功、1失败
     */
    @Column(name = "success_flag")
    private Integer successFlag;

    /**
     * 本次接口调用是否收费：0收费，1不收费
     */
    @Column(name = "pay_flag")
    private Integer payFlag;

    /**
     * 外部接口唯一标识
     */
    @Column(name = "interface_name")
    private String interfaceName;

    /**
     * 外部接口类型标识
     */
    @Column(name = "interface_type")
    private String interfaceType;

    /**
     * 业务调用方传递的业务号，方便后期统计
     */
    @Column(name = "business_num")
    private String businessNum;

    /**
     * 请求时间
     */
    @Column(name = "request_time")
    private Date requestTime;

    /**
     * 响应时间
     */
    @Column(name = "response_time")
    private Date responseTime;

    /**
     * 调用花费时间，但是是毫秒
     */
    @Column(name = "call_time")
    private Integer callTime;
 
	/**
     * 请求参数
     */
    private String params;

    /**
     * 请求结果
     */
    private String result;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return serial_number
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * @param serialNumber
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * 获取外部接口是否调用成功：0成功、1失败
     *
     * @return success_flag - 外部接口是否调用成功：0成功、1失败
     */
    public Integer getSuccessFlag() {
        return successFlag;
    }

    /**
     * 设置外部接口是否调用成功：0成功、1失败
     *
     * @param successFlag 外部接口是否调用成功：0成功、1失败
     */
    public void setSuccessFlag(Integer successFlag) {
        this.successFlag = successFlag;
    }

    /**
     * 获取本次接口调用是否收费：0收费，1不收费
     *
     * @return pay_flag - 本次接口调用是否收费：0收费，1不收费
     */
    public Integer getPayFlag() {
        return payFlag;
    }

    /**
     * 设置本次接口调用是否收费：0收费，1不收费
     *
     * @param payFlag 本次接口调用是否收费：0收费，1不收费
     */
    public void setPayFlag(Integer payFlag) {
        this.payFlag = payFlag;
    }

    /**
     * 获取外部接口唯一标识
     *
     * @return interface_name - 外部接口唯一标识
     */
    public String getInterfaceName() {
        return interfaceName;
    }

    /**
     * 设置外部接口唯一标识
     *
     * @param interfaceName 外部接口唯一标识
     */
    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    /**
     * 获取外部接口类型标识
     *
     * @return interface_type - 外部接口类型标识
     */
    public String getInterfaceType() {
        return interfaceType;
    }

    /**
     * 设置外部接口类型标识
     *
     * @param interfaceType 外部接口类型标识
     */
    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType;
    }

    /**
     * 获取业务调用方传递的业务号，方便后期统计
     *
     * @return business_num - 业务调用方传递的业务号，方便后期统计
     */
    public String getBusinessNum() {
        return businessNum;
    }

    /**
     * 设置业务调用方传递的业务号，方便后期统计
     *
     * @param businessNum 业务调用方传递的业务号，方便后期统计
     */
    public void setBusinessNum(String businessNum) {
        this.businessNum = businessNum;
    }

    /**
     * 获取请求时间
     *
     * @return request_time - 请求时间
     */
    public Date getRequestTime() {
        return requestTime;
    }

    /**
     * 设置请求时间
     *
     * @param requestTime 请求时间
     */
    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    /**
     * 获取响应时间
     *
     * @return response_time - 响应时间
     */
    public Date getResponseTime() {
        return responseTime;
    }

    /**
     * 设置响应时间
     *
     * @param responseTime 响应时间
     */
    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    /**
     * 获取调用花费时间，但是是毫秒
     *
     * @return call_time - 调用花费时间，但是是毫秒
     */
    public Integer getCallTime() {
        return callTime;
    }

    /**
     * 设置调用花费时间，但是是毫秒
     *
     * @param callTime 调用花费时间，但是是毫秒
     */
    public void setCallTime(Integer callTime) {
        this.callTime = callTime;
    }

    /**
     * 获取请求参数
     *
     * @return params - 请求参数
     */
    public String getParams() {
        return params;
    }

    /**
     * 设置请求参数
     *
     * @param params 请求参数
     */
    public void setParams(String params) {
        this.params = params;
    }

    /**
     * 获取请求结果
     *
     * @return result - 请求结果
     */
    public String getResult() {
        return result;
    }

    /**
     * 设置请求结果
     *
     * @param result 请求结果
     */
    public void setResult(String result) {
        this.result = result;
    }

}