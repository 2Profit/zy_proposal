package com.zy.proposal.dao;

import java.util.Map;

import com.zy.common.entity.PageModel;
import com.zy.proposal.entity.ProposalCoin;

public interface ProposalCoinCustomDao {

	public PageModel<ProposalCoin> queryPageModel(Map<String, Object> params, Integer pageSize, Integer currentPage);
	
}
