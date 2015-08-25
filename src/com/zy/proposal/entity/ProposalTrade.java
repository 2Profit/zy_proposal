package com.zy.proposal.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zy.common.entity.BaseEntity;
import com.zy.org.entity.User;

/**
 * ����ҽ��������᰸
 * 
 * @author Jeff Xu
 *
 */
@Entity
@Table(name = "proposal_mem_trade")
public class ProposalTrade extends BaseEntity {

	private static final long serialVersionUID = -785028101882562247L;

	// ������
	private User applier;

	// ������
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
