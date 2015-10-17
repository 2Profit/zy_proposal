package com.zy.proposal.dao;

import java.util.Map;

import com.zy.common.dao.CustomBaseSqlDaoImpl;
import com.zy.common.entity.PageModel;
import com.zy.proposal.entity.ProposalMemModify;

public class ProposalMemModifyDaoImpl extends CustomBaseSqlDaoImpl implements ProposalMemModifyCustomDao {

	@SuppressWarnings("unchecked")
	@Override
	public PageModel<ProposalMemModify> queryPage(Map<String, Object> params, Integer currentPage, Integer pageSize) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("select p from ProposalMemModify p where p.deleteFlag = 0 ");
		
		Object proposalNo = params.get("proposalNo");
		if(proposalNo != null){
			sb.append(" and p.proposalNo = :proposalNo ");
		}
		
		Object no = params.get("no");
		if(no != null){
			sb.append(" and p.no = :no ");
		}
		
		Object posStatus = params.get("posStatus");
		if(posStatus != null){
			sb.append(" and p.posStatus = :posStatus ");
		}
		
		Object cnName = params.get("cnName");
		if(cnName != null){
			sb.append(" and p.cnName = :cnName ");
		}
		
		Object mobile = params.get("mobile");
		if(mobile != null){
			sb.append(" and p.mobile = :mobile ");
		}
		
		sb.append(" order by p.proposalNo desc ");
		
		return this.queryForPageWithParams(sb.toString(), params, currentPage, pageSize);
	}

}
