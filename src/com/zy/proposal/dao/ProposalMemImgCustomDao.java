package com.zy.proposal.dao;

import java.util.Map;

import com.zy.common.entity.PageModel;
import com.zy.proposal.entity.ProposalMemImg;

public interface ProposalMemImgCustomDao {

	public PageModel<ProposalMemImg> queryPageModel(Map<String, Object> params, Integer pageSize, Integer currentPage);
	
}
