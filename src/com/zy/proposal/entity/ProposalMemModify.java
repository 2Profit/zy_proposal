package com.zy.proposal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zy.common.entity.BaseEntity;
import com.zy.member.entity.Member;
import com.zy.org.entity.User;

/**
 * 用户资料添加修改申请提案
 * 
 * @author Jeff Xu
 *
 */
@Entity
@Table(name = "proposal_mem_modify")
public class ProposalMemModify extends BaseEntity {

	private static final long serialVersionUID = 7521414597751164269L;

	private Integer proposalNo;			//提案号
	
	private String posType;				//提案类型	add、update
	
	private Integer posStatus;			//提案状态	0 待审批、1 通过、2拒绝
	
	private Integer no;					//会员编号
	
	private String mobile;				//电话号码
	
	private String email;				//邮箱
	
	private String accountType;			//账号类型（全部、真实、测试）
	
	private String accountCategory;		//账号类别（全部、客户、老师）
	
	private String bankAccount;			
	
	private String bankCardNum;
	
	private String bankAddress;
	
	private String cnName;				//中文名
	
	private String enName;				//英文名
	
	private String nickName;			//昵称
	
	private Date createAccountDate;		//开户日期
	
	private String status;				//状态（0-启用，1-冻结，2-黑名单，3-销户）

	private Integer sex;				//性别 0男  1女
	
	private Integer cardType;			//证件类型
	
	private String card;				//证件号
	
	private String address;				//联系地址
	
	private String nationalityId;		//国籍
	
	private String imgIDCardA;			//身份证正面
	
	private String imgIDCardB;			//身份证反面
	
	private String imgBankCard;			//银行卡证明
	
	private Member member;				//修改的用户
	
	private String msg;					//审核意见
	
	private String pwd;					//密码
	
	// 申请人
	private User applier;

	// 审批人
	private User approvier;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "applier_id")
	public User getApplier() {
		return applier;
	}

	public void setApplier(User applier) {
		this.applier = applier;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "approvier_id")
	public User getApprovier() {
		return approvier;
	}

	public void setApprovier(User approvier) {
		this.approvier = approvier;
	}

	@Column(name="no")
	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	@Column(name="mobile")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name="account_type")
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Column(name="account_category")
	public String getAccountCategory() {
		return accountCategory;
	}

	public void setAccountCategory(String accountCategory) {
		this.accountCategory = accountCategory;
	}

	@Column(name="bank_account")
	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Column(name="bank_card_num")
	public String getBankCardNum() {
		return bankCardNum;
	}

	public void setBankCardNum(String bankCardNum) {
		this.bankCardNum = bankCardNum;
	}

	@Column(name="bank_address")
	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	@Column(name="cn_name")
	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	@Column(name="en_name")
	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	@Column(name="creator_account_date")
	public Date getCreateAccountDate() {
		return createAccountDate;
	}

	public void setCreateAccountDate(Date createAccountDate) {
		this.createAccountDate = createAccountDate;
	}

	@Column(name="status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="sex", precision=1)
	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Column(name="card_type", precision=1)
	public Integer getCardType() {
		return cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	@Column(name="card")
	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	@Column(name="address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="nationality_id")
	public String getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(String nationalityId) {
		this.nationalityId = nationalityId;
	}

	@Column(name="img_id_card_a")
	public String getImgIDCardA() {
		return imgIDCardA;
	}

	public void setImgIDCardA(String imgIDCardA) {
		this.imgIDCardA = imgIDCardA;
	}

	@Column(name="img_id_card_b")
	public String getImgIDCardB() {
		return imgIDCardB;
	}

	public void setImgIDCardB(String imgIDCardB) {
		this.imgIDCardB = imgIDCardB;
	}

	@Column(name="img_bank_card")
	public String getImgBankCard() {
		return imgBankCard;
	}

	public void setImgBankCard(String imgBankCard) {
		this.imgBankCard = imgBankCard;
	}

	@Column(name="pos_type")
	public String getPosType() {
		return posType;
	}

	public void setPosType(String posType) {
		this.posType = posType;
	}

	@Column(name="pos_status", precision=1)
	public Integer getPosStatus() {
		return posStatus;
	}

	public void setPosStatus(Integer posStatus) {
		this.posStatus = posStatus;
	}

	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="member_id")
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Column(name="proposal_no", insertable=false)
	public Integer getProposalNo() {
		return proposalNo;
	}

	public void setProposalNo(Integer proposalNo) {
		this.proposalNo = proposalNo;
	}

	@Column(name="msg", length=1024)
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Column(name="nick_name", length=128)
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name="pwd", length=128)
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
