package com.zy.proposal.dao;

import java.util.Map;

import com.zy.common.dao.CustomBaseSqlDaoImpl;
import com.zy.common.entity.PageModel;
import com.zy.proposal.entity.ProposalCoin;

public class ProposalCoinDaoImpl extends CustomBaseSqlDaoImpl implements ProposalCoinCustomDao {

	@SuppressWarnings("unchecked")
	@Override
	public PageModel<ProposalCoin> queryPageModel(Map<String, Object> params, Integer pageSize, Integer currentPage) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("select p from ProposalCoin p where p.deleteFlag = 0 ");
		
		Object proposalNo = params.get("proposalNo");
		if(proposalNo != null){
			sb.append(" and p.proposalNo = :proposalNo ");
		}
		
		Object posStatus = params.get("posStatus");
		if(posStatus != null){
			sb.append(" and p.posStatus = :posStatus ");
		}
		
		Object memberNo = params.get("memberNo");
		if(memberNo != null){
			sb.append(" and p.member.no = :memberNo ");
		}
		
		Object mobile = params.get("mobile");
		if(mobile != null){
			sb.append(" and p.member.mobile = :mobile ");
		}
		
		Object cnName = params.get("cnName");
		if(cnName != null){
			sb.append(" and p.member.cnName like :cnName ");
		}
		
		sb.append(" order by p.proposalNo desc ");
		
		return this.queryForPageWithParams(sb.toString(), params, currentPage, pageSize);
	}

}
