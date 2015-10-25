package com.zy.proposal.dao;

import org.springframework.data.jpa.repository.Query;

import com.zy.common.dao.CommonDao;
import com.zy.proposal.entity.ProposalMemModify;

public interface ProposalMemModifyDao extends ProposalMemModifyCustomDao, CommonDao<ProposalMemModify, String> {

	@Query("select count(*) from ProposalMemModify p where p.deleteFlag = 0 and p.mobile = ?1 and p.posStatus = ?2 and p.posType='添加' ")
	public int findCountByMobile(String mobile, Integer posStatus);
	
	@Query("select count(*) from ProposalMemModify p where p.deleteFlag = 0 and p.email = ?1 and p.posStatus = ?2 and p.posType='添加' ")
	public int findCountByEmail(String email, Integer posStatus);
	
}
