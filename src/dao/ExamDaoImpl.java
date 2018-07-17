package dao;
import domain.*;
import java.util.List;
public class ExamDaoImpl implements ExamDao{
	private static ExamDao instance = new ExamDaoImpl();
	public static ExamDao getInstance() {return instance;}
	private ExamDaoImpl() {}
	@Override
	public void insertExam(ExamBean exam) {
				
	}
	@Override
	public List<ExamBean> selectAllExam() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ExamBean> selectExamByWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ExamBean selectExamBySeq(String seq) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countExam() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void updateExam(ExamBean bean) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteExam(ExamBean bean) {
		// TODO Auto-generated method stub
		
	}
	
}
