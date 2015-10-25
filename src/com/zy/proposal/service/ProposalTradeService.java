package com.zy.proposal.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.base.entity.ExchangeRate;
import com.zy.base.service.ExchangeRateService;
import com.zy.common.entity.PageModel;
import com.zy.common.service.CommonService;
import com.zy.common.util.CommonConstants;
import com.zy.member.entity.Member;
import com.zy.member.service.MemberService;
import com.zy.org.entity.User;
import com.zy.personal.entity.MemCoinLog;
import com.zy.personal.service.MemCoinLogService;
import com.zy.proposal.dao.ProposalTradeDao;
import com.zy.proposal.entity.ProposalTrade;

@Service
public class ProposalTradeService extends CommonService<ProposalTrade, String> {

	@Autowired
	private MemCoinLogService memCoinLogService;
	
	@Autowired
	private ExchangeRateService exchangeRateService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ProposalTradeDao proposalTradeDao;
	
	@Autowired
	public void setProposalTradeDao(ProposalTradeDao proposalTradeDao){
		super.setCommonDao(proposalTradeDao);
	}
	
	public PageModel<ProposalTrade> findPageModel(Map<String, Object> params, Integer currentPage, Integer pageSize) {
		return proposalTradeDao.findPageModel(params, currentPage, pageSize);
	}
	
	
	public void updateBatchPosPass(String[] posIds, User user){
		for(String posId : posIds){
			updatePosPass(posId, user);
		}
	}
	
	/**
	 * 审批通过
	 * @param posId
	 */
	public void updatePosPass(String posId, User user){
		
		ProposalTrade proposalTrade = this.find(posId);
		proposalTrade.setStatus(CommonConstants.proposalStatusPass.getIntKey());
		proposalTrade.setApprovier(user);
		proposalTrade.setApproveDate(new Date());
		this.update(proposalTrade);
		
		Member member = proposalTrade.getMember();
		//充值
		double amount = proposalTrade.getAmount();
		ExchangeRate exchangeRate = exchangeRateService.findCurrentExchangeRate();
		int coin = 0;
		if(exchangeRate != null){
			coin = new BigDecimal(amount * exchangeRate.getCoin() / exchangeRate.getRmb()).intValue();
		}else{
			coin = (int) (amount * 1);
		}
		
		MemCoinLog memCoinLog = new MemCoinLog();
		memCoinLog.setBeforeCoin(member.getCoin() == null ? 0 : member.getCoin());
		memCoinLog.setCoin(coin);
		memCoinLog.setAfterCoin(memCoinLog.getBeforeCoin() + coin);
		memCoinLog.setChangeId(proposalTrade.getId());
		memCoinLog.setChangeType(MemCoinLog.CHANGE_TYPE_HTCZ);
		memCoinLog.setCreateId(user.getId());
		memCoinLog.setMember(member);
		memCoinLog.setType(MemCoinLog.TYPE_PAY);
		memCoinLogService.save(memCoinLog);
		
		member.setCoin(memCoinLog.getAfterCoin());
		
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
		
		ProposalTrade proposalTrade = this.find(posId);
		proposalTrade.setStatus(CommonConstants.proposalStausCancel.getIntKey());
		proposalTrade.setApprovier(user);
		proposalTrade.setApproveDate(new Date());
		this.update(proposalTrade);
		
	}
	
}
