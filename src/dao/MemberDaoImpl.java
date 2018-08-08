package dao;
import java.util.*;
import domain.*;
import enums.MemberQuery;
import enums.Vendor;
import factory.*;
import pool.DBConstant;
import template.PstmtQuery;
import template.QueryTemplate;

import java.sql.*;

public class MemberDaoImpl implements MemberDao {
	private static MemberDao instance = new MemberDaoImpl();
	public static MemberDao getInstance() {return instance;}
	private MemberDaoImpl() {}

	@Override
	public void insert(MemberBean member) {
		/*try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection()
			.createStatement()
			.executeUpdate(String.format(MemberQuery.INSERT_MEMBER.toString(),
							member.getUserId(), 
							member.getName(), 
							member.getPassword(), 
							member.getSsn(), 
							member.getAge(), 
							member.getRoll(), 
							member.getGender(), 
							member.getTeamId()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		QueryTemplate q = new PstmtQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("userid", member.getUserId());
		map.put("name", member.getName());
		map.put("password", member.getPassword());
		map.put("ssn", member.getSsn());
		map.put("age", member.getAge());
		map.put("roll", member.getRoll());
		map.put("gender", member.getGender());
		map.put("teamid", member.getTeamId());
		q.play(map);
	}
	@Override
	public List<MemberBean> selectSome(Map<?,?> param) {
		QueryTemplate q = new PstmtQuery();
		List<MemberBean> list = new ArrayList<>();
		HashMap<String, Object> map = new HashMap<>();
		map.put("beginRow", param.get("beginRow"));
		map.put("endRow", param.get("endRow"));
		q.play(map);
		for (Object s : q.getList()) {
			list.add((MemberBean)s);
		}
		return list;
	}

	@Override
	public MemberBean selectOne(String seq) {
		MemberBean m = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection().createStatement().executeQuery(String.format(MemberQuery.SELECT_MEMBER_BY_SEQ.toString(),seq));
			while(rs.next()) {
				m = new MemberBean();
				m.setUserId(rs.getString("MEMID"));
				m.setTeamId(rs.getString("TEAMID"));
				m.setName(rs.getString("NAME"));
				m.setSsn(rs.getString("SSN"));
				m.setRoll(rs.getString("ROLL"));
				m.setPassword(rs.getString("PASSWORD"));
				m.setAge(rs.getString("AGE"));
				m.setGender(rs.getString("GENDER"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public int count() {
		int count = 0;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection().createStatement().executeQuery(MemberQuery.MEMBER_COUNT.toString());
			while(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public void update(Map<?,?>param) {
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeUpdate(String.format(MemberQuery.UPDATE_MEMBER.toString(),param.get("password"),param.get("teamid"),param.get("roll"),param.get("userid")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(MemberBean bean) {
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection().createStatement().executeUpdate(String.format(MemberQuery.MEMBER_DELETE.toString(),bean.getUserId(),bean.getPassword()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public MemberBean login(MemberBean bean) {
		MemberBean result = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE,DBConstant.USERNAME,DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(String.format(MemberQuery.LOGIN.toString(),
							bean.getUserId(), bean.getPassword()));
			while (rs.next()){
				result = new MemberBean();
				result.setUserId(rs.getString("MEMID"));
				result.setPassword(rs.getString("PASSWORD"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
