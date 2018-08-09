package dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import domain.MemberBean;
import enums.Action;
import template.PstmtQuery;
import template.QueryTemplate;

public class MemberDaoImpl implements MemberDao {
	private static MemberDao instance = new MemberDaoImpl();
	public static MemberDao getInstance() {return instance;}
	private MemberDaoImpl() {}
	@Override
	public void insert(MemberBean member) {
		QueryTemplate q = new PstmtQuery();
		HashMap<String,Object> map = new HashMap<>();
		map.put("userid", member.getUserId());
		map.put("teamid", member.getTeamId());
		map.put("name", member.getName());
		map.put("ssn", member.getSsn());
		map.put("roll", member.getRoll());
		map.put("pass", member.getPassword());
		map.put("subject", member.getSubject());
		map.put("age", member.getAge());
		map.put("gender", member.getGender());
		map.put("flag", Action.ADD.toString());
		q.play(map);
	}
	@Override
	public List<MemberBean> selectSome(Map<?, ?> param) {
		QueryTemplate q = new PstmtQuery();
		HashMap<String,Object> map = new HashMap<>();
		map.put("beginRow", param.get("beginRow"));
		map.put("endRow",  param.get("endRow"));
		map.put("searchOption", param.get("searchOption"));
		map.put("searchWord", param.get("searchWord"));
		map.put("flag", Action.SEARCH.toString());
		q.play(map);
		List<MemberBean> list = new ArrayList<>();
		for(Object o : q.getList()) {
			list.add((MemberBean) o);
		}
		return list;
	}
	@Override
	public MemberBean selectOne(String seq) {
		QueryTemplate q = new PstmtQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("userid", seq);
		map.put("flag", Action.RETRIEVE.toString());
		q.play(map);
		List<MemberBean> list = new ArrayList<>();
		for(Object o : q.getList()) {
			list.add((MemberBean) o);
		}
		return list.get(0);
	}
	@Override
	public int count() {
		QueryTemplate q = new PstmtQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("flag", Action.COUNT.toString());
		int count =0;
		q.play(map);
		for(Object o : q.getList()) {
			count = (int) o;
		}
		return count;
	}
	@Override
	public void update(Map<?, ?> param) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(MemberBean bean) {
		QueryTemplate q = new PstmtQuery();
		HashMap<String,Object> map = new HashMap<>();
		map.put("userid", bean.getUserId());
		map.put("pass", bean.getPassword());
		map.put("flag", Action.REMOVE.toString());
		q.play(map);
	}
	@Override
	public MemberBean login(MemberBean bean) {
		QueryTemplate q = new PstmtQuery();
		MemberBean mem = new MemberBean();
		HashMap<String, Object> map = new HashMap<>();
		List<MemberBean> list = new ArrayList<>();
		map.put("userid", bean.getUserId().toString());
		map.put("password", bean.getPassword().toString());
		map.put("flag", Action.LOGIN.toString());
		q.play(map);
		for(Object o : q.getList()) {
			list.add((MemberBean) o);
		}
		
		return mem;
	}

	
}
