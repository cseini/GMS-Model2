package domain;

import lombok.Data;

@Data
public class ExamBean{
	private String examSeq, memId, subSeq, score, month, recordSeq; 
	
	@Override
	public String toString() {
		return "시험정보 [시험SEQ=" + examSeq + ", 학생Id=" + memId + ", 과목Seq=" + subSeq + ", 점수=" + score
				+ ", 월=" + month + ", 성적Seq=" + recordSeq + "]";
	}
}
