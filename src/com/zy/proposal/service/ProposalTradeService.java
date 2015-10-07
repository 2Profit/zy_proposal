package com.zy.proposal.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.common.entity.PageModel;
import com.zy.common.service.CommonService;
import com.zy.proposal.dao.ProposalTradeDao;
import com.zy.proposal.entity.ProposalTrade;

@Service
public class ProposalTradeService extends CommonService<ProposalTrade, String> {

	@Autowired
	private ProposalTradeDao proposalTradeDao;
	
	@Autowired
	public void setProposalTradeDao(ProposalTradeDao proposalTradeDao){
		super.setCommonDao(proposalTradeDao);
	}
	
	public PageModel<ProposalTrade> findPageModel(Map<String, Object> params, Integer currentPage, Integer pageSize) {
		return proposalTradeDao.findPageModel(params, currentPage, pageSize);
	}
	
}
