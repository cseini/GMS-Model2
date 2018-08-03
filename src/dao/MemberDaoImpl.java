package dao;
import java.util.*;
import domain.*;
import enums.Domain;
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
	public void insertMember(MemberBean Member) {
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection()
			.createStatement()
			.executeUpdate(String.format(MemberQuery.INSERT_MEMBER.toString(),
							Member.getUserId(), Member.getName(), Member.getPassword(), Member.getSsn(), Member.getAge(), Member.getRoll(), Member.getGender(), Member.getTeamId()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberBean> selectAllMember() {
		List<MemberBean> lst = new ArrayList<>();
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection().createStatement().executeQuery(MemberQuery.SELECT_ALL.toString());
			MemberBean mem = null;
			while(rs.next()) {
				mem = new MemberBean();
				mem.setUserId(rs.getString("MEMID"));
				mem.setTeamId(rs.getString("TEAMID"));
				mem.setName(rs.getString("NAME"));
				mem.setSsn(rs.getString("SSN"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setAge(rs.getString("AGE"));
				mem.setGender(rs.getString("GENDER"));
				lst.add(mem);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}

	@Override
	public List<MemberBean> selectMemberByWord(String word) {
		QueryTemplate q = new PstmtQuery();
		List<MemberBean> list = new ArrayList<>();
		HashMap<String, Object> map = new HashMap<>();
		map.put("column", word.split("/")[0]);
		map.put("value", word.split("/")[1]);
		map.put("table", Domain.MEMBER);
		q.play(map);
		for (Object s : q.getList()) {
			list.add((MemberBean)s);
		}
		return list;
	}

	@Override
	public MemberBean selectMemberBySeq(String seq) {
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
	public int countMember() {
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
	public void updateMember(MemberBean bean) {
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeUpdate(String.format(MemberQuery.UPDATE_MEMBER.toString(),bean.getPassword(),bean.getTeamId(),bean.getRoll(),bean.getUserId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteMember(MemberBean bean) {
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
