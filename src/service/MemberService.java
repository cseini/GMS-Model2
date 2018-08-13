package service;

import java.util.List;
import java.util.Map;
import domain.*;

public interface MemberService {
	public void add(MemberBean Member);
	public List<MemberBean> search(Map<?,?>param);  /*?는 와일드카드*/
	public MemberBean retrieve(String seq);
	public int count();
	public int count(Map<?,?>param);
	public void modify(Map<?,?>param);
	public void remove(MemberBean mem);
	public boolean login(MemberBean bean);
}
