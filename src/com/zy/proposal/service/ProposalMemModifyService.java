package com.zy.proposal.service;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.base.entity.Nationality;
import com.zy.common.entity.PageModel;
import com.zy.common.service.CommonService;
import com.zy.common.util.CommonConstants;
import com.zy.member.entity.Member;
import com.zy.member.service.MemberService;
import com.zy.personal.entity.MemBankInfo;
import com.zy.personal.service.MemBankInfoService;
import com.zy.proposal.dao.ProposalMemModifyDao;
import com.zy.proposal.entity.ProposalMemModify;

@Service
public class ProposalMemModifyService extends CommonService<ProposalMemModify, String> {

	@Autowired
	private ProposalMemModifyDao proposalMemModifyDao;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemBankInfoService memBankInfoService;
	
	@Autowired
	public void setProposalMemModifyDao(ProposalMemModifyDao proposalMemModifyDao){
		super.setCommonDao(proposalMemModifyDao);
	}
	
	public PageModel<ProposalMemModify> queryPage(Map<String, Object> params, Integer currentPage, Integer pageSize) {
		return proposalMemModifyDao.queryPage(params, currentPage, pageSize);
	}
	
	public void updateBatchPosPass(String[] ids, String msg){
		for(String id : ids){
			updatePosPass(id, msg);
		}
	}
	
	/**
	 * 提案通过
	 * @param id
	 */
	public void updatePosPass(String id, String msg){
		
		ProposalMemModify proposalMemModify = proposalMemModifyDao.findOne(id);
		proposalMemModify.setPosStatus(CommonConstants.proposalStatusPass.getIntKey());
		proposalMemModify.setMsg(msg);
		proposalMemModifyDao.save(proposalMemModify);
		
		Member member = null;
		if(proposalMemModify.getMember() == null){
			//添加
			member = new Member();
		}else{
			//修改
			member = proposalMemModify.getMember();
		}
		
		member.setNo(proposalMemModify.getNo());
		member.setMobile(proposalMemModify.getMobile());
		member.setEmail(proposalMemModify.getEmail());
		member.setAccountCategory(proposalMemModify.getAccountCategory());
		member.setAccountType(proposalMemModify.getAccountType());
		
		MemBankInfo memBankInfo = member.getMemBankInfo();
		if(memBankInfo == null){
			memBankInfo = new MemBankInfo();
			member.setMemBankInfo(memBankInfo);
		}
		memBankInfo.setBankAccount(proposalMemModify.getBankAccount());
		memBankInfo.setBankCardNum(proposalMemModify.getBankCardNum());
		memBankInfo.setBankAddress(proposalMemModify.getBankAddress());
		memBankInfoService.save(memBankInfo);
		
		member.setCnName(proposalMemModify.getCnName());
		member.setEnName(proposalMemModify.getEnName());
		member.setCreateAccountDate(proposalMemModify.getCreateAccountDate());
		member.setStatus(proposalMemModify.getStatus());
		member.setSex(proposalMemModify.getSex());
		member.setCardType(proposalMemModify.getCardType());
		member.setCard(proposalMemModify.getCard());
		member.setAddress(proposalMemModify.getAddress());
		
		Nationality nationality = new Nationality();
		if(StringUtils.isNotBlank(proposalMemModify.getNationalityId())){
			nationality.setId(proposalMemModify.getNationalityId());
			member.setNationality(nationality);
		}else{
			member.setNationality(null);
		}
		
		member.setImgIDCardA(proposalMemModify.getImgIDCardA());
		member.setImgIDCardB(proposalMemModify.getImgIDCardB());
		member.setImgBankCard(proposalMemModify.getImgBankCard());
		
		memberService.save(member);
	}
	
	public void updateBatchPosCancel(String[] ids, String msg){
		for(String id : ids){
			updatePosCancel(id, msg);
		}
	}
	
	/**
	 * 提案不通过
	 * @param id
	 * @param msg
	 */
	public void updatePosCancel(String id, String msg){
		
		ProposalMemModify proposalMemModify = proposalMemModifyDao.findOne(id);
		proposalMemModify.setPosStatus(CommonConstants.proposalStausCancel.getIntKey());
		proposalMemModify.setMsg(msg);
		
		proposalMemModifyDao.save(proposalMemModify);
	}
	
}
