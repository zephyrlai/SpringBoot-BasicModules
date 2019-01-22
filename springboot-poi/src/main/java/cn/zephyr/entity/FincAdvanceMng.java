package cn.zephyr.entity;

import java.math.BigDecimal;
import java.util.Date;

public class FincAdvanceMng {
    private Integer row;
    /**
     * 流水号
     */
    private Integer id;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 部门
     */
    private String department;

    /**
     * 业务日期
     */
    private Date busiDate;

    /**
     * 车商名称
     */
    private String distributorName;

    /**
     * 操作银行
     */
    private String bankName;

    /**
     * 垫款金额（逾期金额）
     */
    private BigDecimal advanceAmount;

    /**
     * 垫款类型
     */
    private String advanceType;

    /**
     * 备注
     */
    private String remarks;

    public Integer getRow() {
        return row;
    }

    public FincAdvanceMng setRow(Integer row) {
        this.row = row;
        return this;
    }

    /**
     * 流水号
     * @return id 流水号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 流水号
     * @param id 流水号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 订单编号
     * @return order_no 订单编号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 订单编号
     * @param orderNo 订单编号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }


    /**
     * 客户姓名
     * @return customer_name 客户姓名
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 客户姓名
     * @param customerName 客户姓名
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    /**
     * 部门
     * @return department 部门
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 部门
     * @param department 部门
     */
    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    /**
     * 业务日期
     * @return busi_date 业务日期
     */
    public Date getBusiDate() {
        return busiDate;
    }

    /**
     * 业务日期
     * @param busiDate 业务日期
     */
    public void setBusiDate(Date busiDate) {
        this.busiDate = busiDate;
    }

    /**
     * 车商名称
     * @return distributor_name 车商名称
     */
    public String getDistributorName() {
        return distributorName;
    }

    /**
     * 车商名称
     * @param distributorName 车商名称
     */
    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName == null ? null : distributorName.trim();
    }

    /**
     * 操作银行
     * @return bank_name 操作银行
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 操作银行
     * @param bankName 操作银行
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * 垫款金额（逾期金额）
     * @return advance_amount 垫款金额（逾期金额）
     */
    public BigDecimal getAdvanceAmount() {
        return advanceAmount;
    }

    /**
     * 垫款金额（逾期金额）
     * @param advanceAmount 垫款金额（逾期金额）
     */
    public void setAdvanceAmount(BigDecimal advanceAmount) {
        this.advanceAmount = advanceAmount;
    }

    /**
     * 垫款类型（PARTIAL-部分垫款/FULL-全额垫款/“”-[空]）
     * @return advance_type 垫款类型（PARTIAL-部分垫款/FULL-全额垫款/“”-[空]）
     */
    public String getAdvanceType() {
        return advanceType;
    }

    /**
     * 垫款类型（PARTIAL-部分垫款/FULL-全额垫款/“”-[空]）
     * @param advanceType 垫款类型（PARTIAL-部分垫款/FULL-全额垫款/“”-[空]）
     */
    public void setAdvanceType(String advanceType) {
        this.advanceType = advanceType == null ? null : advanceType.trim();
    }

    /**
     * 备注
     * @return remarks 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}