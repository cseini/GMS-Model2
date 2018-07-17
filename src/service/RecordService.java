package service;
import java.util.List;

import domain.*;
public interface RecordService {
	public void createRecord(RecordBean Record);
	public List<RecordBean> listRecord();
	public List<RecordBean> findRecordByWord(String word);
	public RecordBean findRecordBySeq(String seq);
	public int countRecord();
	public void modifyRecord(RecordBean bean);
	public void removeRecord(RecordBean bean);
}
