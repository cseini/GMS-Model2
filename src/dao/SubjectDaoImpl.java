package dao;

import java.util.List;

import domain.SubjectBean;

public class SubjectDaoImpl implements SubjectDao{
	private static SubjectDao instance = new SubjectDaoImpl();
	public static SubjectDao getInstance() {return instance;}
	private SubjectDaoImpl() {}
	@Override
	public void insertSubject(SubjectBean Subject) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<SubjectBean> selectAllSubject() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SubjectBean> selectSubjectByWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SubjectBean selectSubjectBySeq(String seq) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countSubject() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void updateSubject(SubjectBean bean) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteSubject(SubjectBean bean) {
		// TODO Auto-generated method stub
		
	}
	

}
