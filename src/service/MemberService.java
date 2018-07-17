package service;

import java.util.List;
import domain.*;

public interface MemberService {
	public void createMember(MemberBean Member);
	public List<MemberBean> listMember();
	public List<MemberBean> findMemberByWord(String word);
	public MemberBean findMemberBySeq(String seq);
	public int countMember();
	public void modifyMember(MemberBean bean);
	public void removeMember(MemberBean bean);
	public boolean login(MemberBean bean);
}
