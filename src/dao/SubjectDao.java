package dao;
import domain.*;
import java.util.List;

public interface SubjectDao {
	public void insertSubject(SubjectBean Subject);
	public List<SubjectBean> selectAllSubject();
	public List<SubjectBean> selectSubjectByWord(String word);
	public SubjectBean selectSubjectBySeq(String seq);
	public int countSubject();
	public void updateSubject(SubjectBean bean);
	public void deleteSubject(SubjectBean bean);
}
