package service;

import java.util.List;

import dao.MemberDaoImpl;
import domain.MemberBean;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {}
	@Override
	public void createMember(MemberBean Member) {
		MemberDaoImpl.getInstance().insertMember(Member);
	}
	@Override
	public List<MemberBean> listMember() {
		return MemberDaoImpl.getInstance().selectAllMember();
	}
	@Override
	public List<MemberBean> findMemberByWord(String word) {
		return MemberDaoImpl.getInstance().selectMemberByWord(word);
	}
	@Override
	public MemberBean findMemberBySeq(String seq) {
		return MemberDaoImpl.getInstance().selectMemberBySeq(seq);
	}
	@Override
	public int countMember() {
		return MemberDaoImpl.getInstance().countMember();
	}
	@Override
	public void modifyMember(MemberBean bean) {
		MemberDaoImpl.getInstance().updateMember(bean);
	}
	@Override
	public void removeMember(MemberBean bean) {
		MemberDaoImpl.getInstance().deleteMember(bean);
	}
	@Override
	public boolean login(MemberBean bean) {
		return (MemberDaoImpl.getInstance().login(bean)!=null);
	}
}

