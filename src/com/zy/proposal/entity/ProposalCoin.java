package com.zy.proposal.entity;

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
 * 虚拟币调整
 * @author Administrator
 *
 */
@Table(name="proposal_coin")
@Entity
public class ProposalCoin extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2131660388118786620L;

	
	private User applier;			//提案人员
	
	private User approvier;			//审核人员
	
	private Member member;			//
	
	private Integer coin;			//调整至多少
	
	private String msg;				//备注

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

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="member_id")
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Column(name="coin")
	public Integer getCoin() {
		return coin;
	}

	public void setCoin(Integer coin) {
		this.coin = coin;
	}

	@Column(name="msg", length=1024)
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
