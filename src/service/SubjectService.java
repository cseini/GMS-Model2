package service;
import domain.*;
import java.util.List;

public interface SubjectService {
	public void createSubject(SubjectBean Subject);
	public List<SubjectBean> listSubject();
	public List<SubjectBean> findSubjectByWord(String word);
	public SubjectBean findSubjectBySeq(String seq);
	public int countSubject();
	public void modifySubject(SubjectBean bean);
	public void removeSubject(SubjectBean bean);
}
