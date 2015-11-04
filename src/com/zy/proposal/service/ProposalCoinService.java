package com.zy.proposal.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.common.entity.PageModel;
import com.zy.common.service.CommonService;
import com.zy.common.util.CommonConstants;
import com.zy.member.entity.Member;
import com.zy.member.service.MemberService;
import com.zy.org.entity.User;
import com.zy.personal.entity.MemCoinLog;
import com.zy.personal.service.MemCoinLogService;
import com.zy.proposal.dao.ProposalCoinDao;
import com.zy.proposal.entity.ProposalCoin;

@Service
public class ProposalCoinService extends CommonService<ProposalCoin, String> {

	@Autowired
	private MemCoinLogService memCoinLogService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ProposalCoinDao proposalCoinDao;
	
	@Autowired
	public void setProposalCoinDao(ProposalCoinDao proposalCoinDao){
		super.setCommonDao(proposalCoinDao);
	}
	
	public PageModel<ProposalCoin> queryPageModel(Map<String, Object> params, Integer pageSize, Integer currentPage) {
		return proposalCoinDao.queryPageModel(params, pageSize, currentPage);
	}
	
	public void updateBatchPosPass(String[] posIds, User user){
		for(String posId : posIds){
			updatePosPass(posId, user);
		}
	}
	
	/**
	 * 审核通过
	 * @param posId
	 * @param user
	 */
	public void updatePosPass(String posId, User user){
		ProposalCoin proposalCoin = this.find(posId);
		
		proposalCoin.setPosStatus(CommonConstants.proposalStatusPass.getIntKey());
		proposalCoin.setApprovier(user);
		proposalCoin.setApprovierDate(new Date());
		this.update(proposalCoin);
		
		Member member = proposalCoin.getMember();
		
		MemCoinLog memCoinLog = new MemCoinLog();
		memCoinLog.setBeforeCoin(member.getCoin() == null ? 0 : member.getCoin());
		memCoinLog.setCoin(proposalCoin.getCoin());
		int afterCoin = memCoinLog.getBeforeCoin() + proposalCoin.getCoin();
		memCoinLog.setAfterCoin(afterCoin);
		memCoinLog.setChangeId(proposalCoin.getId());
		memCoinLog.setChangeType(MemCoinLog.CHANGE_TYPE_EDTZ);
		memCoinLog.setCreateId(user.getId());
		memCoinLog.setMember(member);
		memCoinLog.setType(MemCoinLog.TYPE_PAY);
		memCoinLogService.save(memCoinLog);
		
		member.setCoin(afterCoin);
		memberService.update(member);
	}
	
	public void updateBatchPosCancel(String[] posIds, User user){
		for(String posId : posIds){
			updatePosCancel(posId, user);
		}
	}
	
	/**
	 * 审核不通过
	 * @param posId
	 * @param user
	 */
	public void updatePosCancel(String posId, User user){
		
		ProposalCoin proposalCoin = this.find(posId);
		proposalCoin.setPosStatus(CommonConstants.proposalStausCancel.getIntKey());
		proposalCoin.setApprovier(user);
		proposalCoin.setApprovierDate(new Date());
		this.update(proposalCoin);
		
	}
	
}
