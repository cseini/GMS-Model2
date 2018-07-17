package service;

import java.util.List;

import domain.SubjectBean;

public class SubjectServiceImpl implements SubjectService{
	private static SubjectService instance = new SubjectServiceImpl();
	public static SubjectService getInstance() {return instance;}
	private SubjectServiceImpl() {}
	@Override
	public void createSubject(SubjectBean Subject) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<SubjectBean> listSubject() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SubjectBean> findSubjectByWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SubjectBean findSubjectBySeq(String seq) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countSubject() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void modifySubject(SubjectBean bean) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeSubject(SubjectBean bean) {
		// TODO Auto-generated method stub
		
	}

}
