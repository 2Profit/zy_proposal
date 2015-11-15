package com.zy.proposal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zy.broker.entity.BrokerInfo;
import com.zy.common.entity.BaseEntity;
import com.zy.member.entity.Member;
import com.zy.org.entity.User;

/**
 * 返佣提案
 * @author LL
 *
 */
@Table(name="proposal_back_discount")
@Entity
public class ProposalBackDiscount extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -577957195094999028L;

	private Integer proposalNo;					//提案编号
	
	private Member member;						//会员
	
	private BrokerInfo brokerInfo;				//开户平台
	
	private String email;						//开户邮箱
	
	private String mt4Card;						//MT4账号
	
	private String bankCard;					//银行卡号
	
	private String bankName;					//开户银行
	
	private String name;						//姓名

	private User applier;						//提案人员
	
	private User approvier;						//审核人员
	
	private Date approvierDate;					//审批时间
	
	private Integer posStatus;					//提案状态

	private String msg;
	
	private Integer registerStatus;				//0未激活 1 已激活
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="member_id")
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Column(name="proposal_no")
	public Integer getProposalNo() {
		return proposalNo;
	}

	public void setProposalNo(Integer proposalNo) {
		this.proposalNo = proposalNo;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="broker_info_id")
	public BrokerInfo getBrokerInfo() {
		return brokerInfo;
	}

	public void setBrokerInfo(BrokerInfo brokerInfo) {
		this.brokerInfo = brokerInfo;
	}

	@Column(name="email", length=64)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="mt4_card", length=128)
	public String getMt4Card() {
		return mt4Card;
	}

	public void setMt4Card(String mt4Card) {
		this.mt4Card = mt4Card;
	}

	@Column(name="bank_card", length=128)
	public String getBankCard() {
		return bankCard;
	}

	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}

	@Column(name="bank_name", length=128)
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Column(name="name", length=128)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="applier_id")
	public User getApplier() {
		return applier;
	}

	public void setApplier(User applier) {
		this.applier = applier;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="approvier_id")
	public User getApprovier() {
		return approvier;
	}

	public void setApprovier(User approvier) {
		this.approvier = approvier;
	}

	@Column(name="approvier_date")
	public Date getApprovierDate() {
		return approvierDate;
	}

	public void setApprovierDate(Date approvierDate) {
		this.approvierDate = approvierDate;
	}

	@Column(name="pos_status", precision=1)
	public Integer getPosStatus() {
		return posStatus;
	}

	public void setPosStatus(Integer posStatus) {
		this.posStatus = posStatus;
	}

	@Column(name="msg", length=1024)
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Column(name="register_status", precision=1)
	public Integer getRegisterStatus() {
		return registerStatus;
	}

	public void setRegisterStatus(Integer registerStatus) {
		this.registerStatus = registerStatus;
	}
	
}
