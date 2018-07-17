package dao;

import java.util.List;
import domain.ExamBean;

public interface ExamDao {
	public void insertExam(ExamBean exam);
	public List<ExamBean> selectAllExam();
	public List<ExamBean> selectExamByWord(String word);
	public ExamBean selectExamBySeq(String seq);
	public int countExam();
	public void updateExam(ExamBean bean);
	public void deleteExam(ExamBean bean);
}
