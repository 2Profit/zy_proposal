package com.zy.proposal.dao;

import java.util.Map;

import com.zy.common.dao.CustomBaseSqlDaoImpl;
import com.zy.common.entity.PageModel;
import com.zy.proposal.entity.ProposalTrade;

public class ProposalTradeDaoImpl extends CustomBaseSqlDaoImpl implements ProposalTradeCustomDao {

	@SuppressWarnings("unchecked")
	@Override
	public PageModel<ProposalTrade> findPageModel(Map<String, Object> params, Integer currentPage, Integer pageSize) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("select t from ProposalTrade t where t.deleteFlag = 0 ");
		
		Object proposalNo = params.get("proposalNo");
		if(proposalNo != null){
			sb.append(" and t.proposalNo = :proposalNo ");
		}
		
		Object payType = params.get("payType");
		if(payType != null){
			sb.append(" and t.payType = :payType ");
		}
		
		Object status = params.get("status");
		if(status != null){
			sb.append(" and t.status = :status ");
		}
		
		Object memberNo = params.get("memberNo");
		if(memberNo != null){
			sb.append(" and t.member.no = :memberNo ");
		}
		
		Object mobile = params.get("mobile");
		if(mobile != null){
			sb.append(" and t.member.mobile = :mobile ");
		}
		
		Object cnName = params.get("cnName");
		if(cnName != null){
			sb.append(" and t.member.cnName like :cnName ");
		}
		
		
		sb.append(" order by t.createDate desc ");
		
		return this.queryForPageWithParams(sb.toString(), params, currentPage, pageSize);
	}

}
