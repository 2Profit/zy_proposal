package com.zy.proposal.dao;

import java.util.Map;

import com.zy.common.entity.PageModel;
import com.zy.proposal.entity.ProposalBackDiscount;

public interface ProposalBackDiscountCustomDao {

	public PageModel<ProposalBackDiscount> findPageModel(Map<String, Object> params, Integer currentPage, Integer pageSize);
	
}
