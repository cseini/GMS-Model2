package template;

import java.util.List;
import java.util.Map;

import enums.Vendor;
import factory.DatabaseFactory;
import pool.DBConstant;
import lombok.Data;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@Data
public abstract class QueryTemplate {
	int number;
	Object o;
	List<Object> list;
	Map<String, Object>map;
	PreparedStatement pstmt;

    public final void play(Map<?,?>param){
    	this.number = 0;
    	this.o = null;
    	this.list = new ArrayList<>();
    	this.map = new HashMap<>();
    	this.pstmt = null;
    	this.map.put("vender", Vendor.ORACLE);
    	this.map.put("username", DBConstant.USERNAME);
    	this.map.put("password", DBConstant.PASSWORD);
    	Iterator<?> keys =param.keySet().iterator();
    	while(keys.hasNext()) {
    		String key = (String) keys.next();
    		this.map.put(key, param.get(key));
    	}
    	initialize();
    	pstmtInit();
    	startPlay();
    	endPlay();
   }
    
    public final void play() {
    	this.number = 0;
    	this.pstmt = null;
    	this.map = new HashMap<>();
    	this.map.put("vender", Vendor.ORACLE);
    	this.map.put("username", DBConstant.USERNAME);
    	this.map.put("password", DBConstant.PASSWORD);
    	initialize();
    	pstmtInit();
    	startPlay();
    	endPlay();
    }
    public void pstmtInit() {
    	try {
			this.pstmt = DatabaseFactory.createDatabase2(map).getConnection()
					.prepareStatement((String) map.get("sql"));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();
}
