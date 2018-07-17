package dao;

import java.util.List;
import domain.*;

public interface MemberDao {
	public void insertMember(MemberBean Member);
	public List<MemberBean> selectAllMember();
	public List<MemberBean> selectMemberByWord(String word);
	public MemberBean selectMemberBySeq(String seq);
	public int countMember();
	public void updateMember(MemberBean bean);
	public void deleteMember(MemberBean bean);
	public MemberBean login(MemberBean bean);
}
