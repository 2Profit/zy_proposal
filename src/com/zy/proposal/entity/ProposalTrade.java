package com.zy.proposal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zy.common.entity.BaseEntity;
import com.zy.org.entity.User;

/**
 * 虚拟币交易申请提案
 * 
 * @author Jeff Xu
 *
 */
@Entity
@Table(name = "proposal_mem_trade")
public class ProposalTrade extends BaseEntity {

	private static final long serialVersionUID = -785028101882562247L;

	// 申请人
	private User applier;

	// 审批人
	private User approvier;

	private Integer proposalNo;		//提案号
	
	private String tradeId;			//交易号
	
	private String account;			//账号
	
	private double amount;			//金额
	
	private Integer payType;		//存款途经
	
	private Integer curType;		//币种
	
	private Integer status;			//提案状态
	
	private String ip;				//操作IP
	
	private String frontMsg;		//前台msg
	
	private String bgMsg;			//后台msg
	
	@Column(name="account")
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@ManyToOne
	@JoinColumn(name = "applier_id")
	public User getApplier() {
		return applier;
	}

	public void setApplier(User applier) {
		this.applier = applier;
	}

	@ManyToOne
	@JoinColumn(name = "approvier_id")
	public User getApprovier() {
		return approvier;
	}

	public void setApprovier(User approvier) {
		this.approvier = approvier;
	}

	@Column(name="proposal_no", insertable=false)
	public Integer getProposalNo() {
		return proposalNo;
	}

	public void setProposalNo(Integer proposalNo) {
		this.proposalNo = proposalNo;
	}

	@Column(name="trade_id")
	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	@Column(name="amount")
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Column(name="pay_type", precision=1)
	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	@Column(name="cur_type", precision=1)
	public Integer getCurType() {
		return curType;
	}

	public void setCurType(Integer curType) {
		this.curType = curType;
	}

	@Column(name="status", precision=1)
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name="ip", length=128)
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name="front_msg", length=512)
	public String getFrontMsg() {
		return frontMsg;
	}

	public void setFrontMsg(String frontMsg) {
		this.frontMsg = frontMsg;
	}

	@Column(name="bg_msg", length=512)
	public String getBgMsg() {
		return bgMsg;
	}

	public void setBgMsg(String bgMsg) {
		this.bgMsg = bgMsg;
	}

}
