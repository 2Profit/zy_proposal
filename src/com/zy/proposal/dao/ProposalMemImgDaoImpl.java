package com.zy.proposal.dao;

import java.util.Map;

import com.zy.common.dao.CustomBaseSqlDaoImpl;
import com.zy.common.entity.PageModel;
import com.zy.proposal.entity.ProposalMemImg;

public class ProposalMemImgDaoImpl extends CustomBaseSqlDaoImpl implements ProposalMemImgCustomDao {

	@SuppressWarnings("unchecked")
	@Override
	public PageModel<ProposalMemImg> queryPageModel(Map<String, Object> params, Integer pageSize, Integer currentPage) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("select p from ProposalMemImg p where p.deleteFlag = 0 ");
		
		Object proposalNo = params.get("proposalNo");
		if(proposalNo != null){
			sb.append(" and p.proposalNo = :proposalNo ");
		}
		
		Object no = params.get("no");
		if(no != null){
			sb.append(" and p.member.no = :no ");
		}
		
		Object posStatus = params.get("posStatus");
		if(posStatus != null){
			sb.append(" and p.posStatus = :posStatus ");
		}
		
		Object cnName = params.get("cnName");
		if(cnName != null){
			sb.append(" and p.member.cnName like :cnName ");
		}
		
		Object mobile = params.get("mobile");
		if(mobile != null){
			sb.append(" and p.member.mobile = :mobile ");
		}
		
		sb.append(" order by p.proposalNo desc ");
		
		return this.queryForPageWithParams(sb.toString(), params, currentPage, pageSize);
	}

}
