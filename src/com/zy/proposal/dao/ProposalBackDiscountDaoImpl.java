package com.zy.proposal.dao;

import java.util.Map;

import com.zy.common.dao.CustomBaseSqlDaoImpl;
import com.zy.common.entity.PageModel;
import com.zy.proposal.entity.ProposalBackDiscount;

public class ProposalBackDiscountDaoImpl extends CustomBaseSqlDaoImpl implements ProposalBackDiscountCustomDao {

	@SuppressWarnings("unchecked")
	@Override
	public PageModel<ProposalBackDiscount> findPageModel(Map<String, Object> params, Integer currentPage,
			Integer pageSize) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("select p from ProposalBackDiscount p where p.deleteFlag = 0 ");
		
		Object proposalNo = params.get("proposalNo");
		if(proposalNo != null){
			sb.append(" and p.proposalNo = :proposalNo ");
		}
		
		Object posStatus = params.get("posStatus");
		if(posStatus != null){
			sb.append(" and p.posStatus = :posStatus ");
		}
		
		Object brokerInfoId = params.get("brokerInfoId");
		if(brokerInfoId != null){
			sb.append(" and p.brokerInfo.id = :brokerInfoId ");
		}
		
		Object email = params.get("email");
		if(email != null){
			sb.append(" and p.email = :email ");
		}
		
		Object mt4Card = params.get("mt4Card");
		if(mt4Card != null){
			sb.append(" and p.mt4Card = :mt4Card ");
		}
		
		sb.append(" order by p.proposalNo desc ");
		
		return this.queryForPageWithParams(sb.toString(), params, currentPage, pageSize);
	}

}
