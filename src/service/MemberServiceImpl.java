package service;

import java.util.List;
import java.util.Map;
import dao.MemberDaoImpl;
import domain.MemberBean;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {}
	@Override
	public void create(MemberBean Member) {
		MemberDaoImpl.getInstance().insert(Member);
	}
	@Override
	public List<MemberBean> search(Map<?, ?> param) {
		return MemberDaoImpl.getInstance().selectSome(param);
	}
	@Override
	public MemberBean retrieve(String seq) {
		return MemberDaoImpl.getInstance().selectOne(seq);
	}
	@Override
	public int count() {
		return MemberDaoImpl.getInstance().count();
	}
	@Override
	public void modify(Map<?, ?> param) {
		MemberDaoImpl.getInstance().update(param);
	}
	@Override
	public void remove(MemberBean mem) {
		MemberDaoImpl.getInstance().delete(mem);
	}
	@Override
	public boolean login(MemberBean bean) {
		return (MemberDaoImpl.getInstance().login(bean)!=null);
	}

}
