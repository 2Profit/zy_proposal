package com.zy.proposal.service;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.broker.entity.MemBrokerRel;
import com.zy.broker.service.MemBrokerRelService;
import com.zy.common.entity.PageModel;
import com.zy.common.service.CommonService;
import com.zy.common.util.CommonConstants;
import com.zy.member.entity.Member;
import com.zy.member.service.MemberService;
import com.zy.org.entity.User;
import com.zy.personal.entity.MemBankInfo;
import com.zy.personal.service.MemBankInfoService;
import com.zy.proposal.dao.ProposalBackDiscountDao;
import com.zy.proposal.entity.ProposalBackDiscount;

@Service
public class ProposalBackDiscountService extends CommonService<ProposalBackDiscount, String> {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ProposalBackDiscountDao proposalBackDiscountDao;
	
	@Autowired
	private MemBrokerRelService memBrokerRelService;
	
	@Autowired
	private MemBankInfoService memBankInfoService;
	
	@Autowired
	public void setProposalBackDiscountDao(ProposalBackDiscountDao proposalBackDiscountDao){
		super.setCommonDao(proposalBackDiscountDao);
	}
	
	public PageModel<ProposalBackDiscount> findPageModel(Map<String, Object> params, Integer currentPage,
			Integer pageSize) {
		return proposalBackDiscountDao.findPageModel(params, currentPage, pageSize);
	}
	
	/**
	 * 审核通过
	 * @param posId
	 */
	public boolean updatePosPass(String posId, User user){
		ProposalBackDiscount proposalBackDiscount = this.find(posId);
		
		proposalBackDiscount.setPosStatus(CommonConstants.proposalStatusPass.getIntKey());
		proposalBackDiscount.setApprovier(user);
		proposalBackDiscount.setApprovierDate(new Date());
		
		//查找邮箱用户是否存在
		boolean hasMember = false;
		Member member = memberService.findMemberByEmail(proposalBackDiscount.getEmail());
		if(member != null){
			hasMember = true;
			proposalBackDiscount.setMember(member);
			
			//更新银行资料
			MemBankInfo memBankInfo = member.getMemBankInfo();
			if(memBankInfo == null){
				memBankInfo = new MemBankInfo();
			}
			memBankInfo.setBankAccount(proposalBackDiscount.getBankName());
			memBankInfo.setBankCardNum(proposalBackDiscount.getBankCard());
			memBankInfo.setBankAddress(proposalBackDiscount.getName());
			if(StringUtils.isNotBlank(memBankInfo.getId())){
				memBankInfoService.update(memBankInfo);
			}else{
				memBankInfoService.save(memBankInfo);
				member.setMemBankInfo(memBankInfo);
				memberService.update(member);
			}
			
			//用户与经纪商关系
			MemBrokerRel memBrokerRel = new MemBrokerRel();
			memBrokerRel.setBrokerInfo(proposalBackDiscount.getBrokerInfo());
			memBrokerRel.setMember(member);
			memBrokerRel.setMt4Card(proposalBackDiscount.getMt4Card());
			memBrokerRelService.save(memBrokerRel);
			
		}		
		
		this.update(proposalBackDiscount);
		
		
		
		return hasMember;
	}
	
	public void updatePosCancel(String posId, String msg, User user){
		
		ProposalBackDiscount proposalBackDiscount = this.find(posId);
		
		proposalBackDiscount.setPosStatus(CommonConstants.proposalStausCancel.getIntKey());
		proposalBackDiscount.setApprovier(user);
		proposalBackDiscount.setApprovierDate(new Date());
		proposalBackDiscount.setMsg(msg);
		
		this.update(proposalBackDiscount);
		
	}
	
}
