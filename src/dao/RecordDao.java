package dao;
import java.util.List;

import domain.*;
public interface RecordDao {
	public void insertRecord(RecordBean Record);
	public List<RecordBean> selectAllRecord();
	public List<RecordBean> selectRecordByWord(String word);
	public RecordBean selectRecordBySeq(String seq);
	public int countRecord();
	public void updateRecord(RecordBean bean);
	public void deleteRecord(RecordBean bean);
	public String selectFirstRowNum(); 
}
