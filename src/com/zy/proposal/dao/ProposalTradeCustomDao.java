package com.zy.proposal.dao;

import java.util.Map;

import com.zy.common.entity.PageModel;
import com.zy.proposal.entity.ProposalTrade;

public interface ProposalTradeCustomDao {

	public PageModel<ProposalTrade> findPageModel(Map<String, Object> params, Integer currentPage, Integer pageSize);
	
}
