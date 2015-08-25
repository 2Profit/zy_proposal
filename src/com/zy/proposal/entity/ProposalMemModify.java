package com.zy.proposal.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zy.common.entity.BaseEntity;
import com.zy.org.entity.User;

/**
 * 用户资料修改申请提案
 * 
 * @author Jeff Xu
 *
 */
@Entity
@Table(name = "proposal_mem_modify")
public class ProposalMemModify extends BaseEntity {

	private static final long serialVersionUID = 7521414597751164269L;

	// 申请人
	private User applier;

	// 审批人
	private User approvier;

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

}
