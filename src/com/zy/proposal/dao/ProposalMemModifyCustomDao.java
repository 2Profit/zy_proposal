package com.zy.proposal.dao;

import java.util.Map;

import com.zy.common.entity.PageModel;
import com.zy.proposal.entity.ProposalMemModify;

public interface ProposalMemModifyCustomDao {

	public PageModel<ProposalMemModify> queryPage(Map<String, Object> params, Integer currentPage, Integer pageSize);
	
}
