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
import com.zy.proposal.dao.ProposalMemImgDao;
import com.zy.proposal.entity.ProposalMemImg;

@Service
public class ProposalMemImgService extends CommonService<ProposalMemImg, String> {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ProposalMemImgDao proposalMemImgDao;
	
	@Autowired
	public void setProposalMemImgDao(ProposalMemImgDao proposalMemImgDao){
		super.setCommonDao(proposalMemImgDao);
	}
	
	public void saveProposalMemImg(ProposalMemImg proposalMemImg, Member member){
		memberService.update(member);
		proposalMemImgDao.save(proposalMemImg);
	}
	
	public PageModel<ProposalMemImg> queryPageModel(Map<String, Object> params, Integer pageSize, Integer currentPage) {
		return proposalMemImgDao.queryPageModel(params, pageSize, currentPage);
	}
	
	public void updateBatchPosPass(String[] posIds, User user){
		for(String posId : posIds){
			updatePosPass(posId, user);
		}
	}
	
	/**
	 * 审核通过
	 * @param posId
	 */
	public void updatePosPass(String posId, User user){
		
		ProposalMemImg proposalMemImg = this.find(posId);
		proposalMemImg.setPosStatus(CommonConstants.proposalStatusPass.getIntKey());
		proposalMemImg.setApprovier(user);
		proposalMemImg.setApproveDate(new Date());
		this.update(proposalMemImg);
		
		Member member = proposalMemImg.getMember();
		if(proposalMemImg.getType() == ProposalMemImg.TYPE_ID_CARD){
			member.setImgIDCardA(proposalMemImg.getImgPath());
			member.setImgIDCardStatus(Member.IMG_STATUS_TG);
		}else if(proposalMemImg.getType() == ProposalMemImg.TYPE_BANK){
			member.setImgBankCard(proposalMemImg.getImgPath());
			member.setImgBackCardStatus(Member.IMG_STATUS_TG);
		}
		memberService.update(member);
		
	}
	
	public void updateBatchPosCancel(String[] posIds, User user){
		for(String posId : posIds){
			updatePosCancel(posId, user);
		}
	}
	
	/**
	 * 审核不通过
	 * @param podId
	 */
	public void updatePosCancel(String posId, User user){
		
		ProposalMemImg proposalMemImg = this.find(posId);
		proposalMemImg.setPosStatus(CommonConstants.proposalStausCancel.getIntKey());
		proposalMemImg.setApprovier(user);
		proposalMemImg.setApproveDate(new Date());
		this.update(proposalMemImg);
		
		Member member = proposalMemImg.getMember();
		if(proposalMemImg.getType() == ProposalMemImg.TYPE_ID_CARD){
			member.setImgIDCardA(proposalMemImg.getImgPath());
			member.setImgIDCardStatus(Member.IMG_STATUS_WTG);
		}else if(proposalMemImg.getType() == ProposalMemImg.TYPE_BANK){
			member.setImgBankCard(proposalMemImg.getImgPath());
			member.setImgBackCardStatus(Member.IMG_STATUS_WTG);
		}
		memberService.update(member);
		
	}
	
}
