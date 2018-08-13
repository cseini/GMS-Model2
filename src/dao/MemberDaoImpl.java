package dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import domain.MemberBean;
import template.AddQuery;
import template.CountQuery;
import template.LoginQuery;
import template.ModifyQuery;
import template.QueryTemplate;
import template.RemoveQuery;
import template.RetrieveQuery;
import template.SearchQuery;

public class MemberDaoImpl implements MemberDao {
	private static MemberDao instance = new MemberDaoImpl();
	public static MemberDao getInstance() {return instance;}
	private MemberDaoImpl() {}
	private QueryTemplate q = null;
	@Override
	public void insert(MemberBean member) {
		q = new AddQuery();
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
		q.play(map);
	}
	@Override
	public List<MemberBean> selectSome(Map<?, ?> param) {
		q = new SearchQuery();
		List<MemberBean> list = new ArrayList<>();
		q.play(param);
		for(Object o : q.getList()) {
			list.add((MemberBean) o);
		}
		return list;
	}
	@Override
	public MemberBean selectOne(String seq) {
		q= new RetrieveQuery();
		Map<String, Object> map = new HashMap<>();
		map.put("userid", seq);
		q.play(map);
		return (MemberBean) q.getO();
	}
	@Override
	public int count() {
		q = new CountQuery();
		q.play();
		return q.getNumber();
	}
	@Override
	public int count(Map<?, ?> param) {
		q = new CountQuery();
		q.play(param);
		return q.getNumber();
	}
	@Override
	public void update(Map<?, ?> param) {
		q = new ModifyQuery();
		q.play(param);
	}
	@Override
	public void delete(MemberBean bean) {
		q = new RemoveQuery();
		HashMap<String,Object> map = new HashMap<>();
		map.put("userid", bean.getUserId());
		map.put("pass", bean.getPassword());
		q.play(map);
	}
	@Override
	public MemberBean login(MemberBean bean) {
		q = new LoginQuery();
		Map<String, Object> map = new HashMap<>();
		map.put("userid", bean.getUserId());
		map.put("pass", bean.getPassword());
		q.play(map);
		return (MemberBean) q.getO();
	}
	
}
