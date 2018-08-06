package service;

import java.util.List;
import java.util.Map;

import domain.*;

public interface MemberService {
	public void createMember(MemberBean Member);
	public List<MemberBean> listMember();
	public List<MemberBean> getList(Map<?,?>param);  /*?는 와일드카드*/
	public List<MemberBean> findMemberByWord(String word);
	public MemberBean findMemberBySeq(String seq);
	public int countMember();
	public void modifyMember(MemberBean bean);
	public void removeMember(MemberBean bean);
	public boolean login(MemberBean bean);
}
