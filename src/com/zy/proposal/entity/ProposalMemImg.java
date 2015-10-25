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
 * 用户图片资提案
 * @author Administrator
 *
 */
@Entity
@Table(name="proposal_mem_img")
public class ProposalMemImg extends BaseEntity {

	public final static Integer TYPE_ID_CARD = 0;	//身份证
	public final static Integer TYPE_BANK = 1;		//银行卡
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3688261467820638465L;

	private Integer proposalNo;			//提案号
	
	private Member member;				//
	
	private Integer type;				//类型
	
	private String imgPath;				//图片路径
	
	private Integer posStatus;				//状态  0待审核  1通过 2拒绝

	private User approvier;				// 审批人
	
	private Date approveDate;			//审批时间
	
	@Column(name="proposal_no", insertable=false)
	public Integer getProposalNo() {
		return proposalNo;
	}

	public void setProposalNo(Integer proposalNo) {
		this.proposalNo = proposalNo;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="member_id")
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Column(name="type", precision=1)
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name="img_path", length=256)
	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	@Column(name="pos_status", precision=1)
	public Integer getPosStatus() {
		return posStatus;
	}

	public void setPosStatus(Integer posStatus) {
		this.posStatus = posStatus;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="approvier_id")
	public User getApprovier() {
		return approvier;
	}

	public void setApprovier(User approvier) {
		this.approvier = approvier;
	}

	@Column(name="approve_date")
	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}
	
}
