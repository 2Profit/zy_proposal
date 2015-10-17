package com.zy.proposal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.common.service.CommonService;
import com.zy.proposal.dao.ProposalCoinDao;
import com.zy.proposal.entity.ProposalCoin;

@Service
public class ProposalCoinService extends CommonService<ProposalCoin, String> {

	@Autowired
	private ProposalCoinDao proposalCoinDao;
	
	@Autowired
	public void setProposalCoinDao(ProposalCoinDao proposalCoinDao){
		super.setCommonDao(proposalCoinDao);
	}
	
}
