package service;

import java.util.List;

import domain.*;

public class RecordServiceImpl implements RecordService{
	private static RecordService instance = new RecordServiceImpl();
	public static RecordService getInstance() {return instance;}
	private RecordServiceImpl() {}
	@Override
	public void createRecord(RecordBean Record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<RecordBean> listRecord() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<RecordBean> findRecordByWord(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public RecordBean findRecordBySeq(String seq) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countRecord() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void modifyRecord(RecordBean bean) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeRecord(RecordBean bean) {
		// TODO Auto-generated method stub
		
	}

}
