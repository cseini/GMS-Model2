package dao;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		List<String> lst = TestDao.getInstance().getAge();
		int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()));
		for(int i =0;i<lst.size();i++) {
			String month=String.format("%02d",(int)(Math.random()*12)+1);
			String day=String.format("%02d",(int)(Math.random()*31)+1);
			lst.set(i, String.valueOf(year-Integer.parseInt(lst.get(i))+1-1900)+month+day+"-");
		}
		
		//age를 몇년생인지 추출
		//1998 년생 남자
		//98000-1
		//98 + 00 + 00 + - + 1
		//980504-1
	}
}
