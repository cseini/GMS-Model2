package service;

import java.util.List;
import domain.ExamBean;

public interface ExamService {
	public void createExam(ExamBean exam);
	public List<ExamBean> listExam();
	public List<ExamBean> findExamByWord(String word);
	public ExamBean findExamBySeq(String seq);
	public int countExam();
	public void modifyExam(ExamBean bean);
	public void removeExam(ExamBean bean);
	
}
