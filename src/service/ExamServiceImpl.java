package service;
import domain.*;
import java.util.List;
import dao.*;
public class ExamServiceImpl implements ExamService{
	private static ExamService instance = new ExamServiceImpl();
	public static ExamService getInstance() {return instance;}
	private ExamServiceImpl() {}
	@Override
	public void createExam(ExamBean exam) {
		System.out.println("===== ExamService ====="); 
		System.out.println(exam);
        // 과목SEQ=null,
        // 성적표SEQ=null
        System.out.println("----- RECORD TABLE INSERT ------");
        RecordBean rec = new RecordBean();
        rec.setAvg("80");
        rec.setGrade("");
        RecordDaoImpl.getInstance().insertRecord(rec);
        System.out.println("------ Exam TABLE INSERT ------");
        exam.setScore(exam.getScore().split("/")[0]);
        exam.setSubSeq(
                SubjectDaoImpl.getInstance().
                selectSubjectByWord("JAVA").get(0).getSubSeq());
        exam.setRecordSeq(RecordDaoImpl.getInstance()
                .selectFirstRowNum());    
        ExamDaoImpl.getInstance().insertExam(exam);
	}
	@Override
	public List<ExamBean> listExam() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ExamBean> findExamByWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ExamBean findExamBySeq(String seq) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countExam() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void modifyExam(ExamBean bean) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeExam(ExamBean bean) {
		// TODO Auto-generated method stub
		
	}

}