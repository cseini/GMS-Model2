package template;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import enums.Vendor;
import pool.DBConstant;
import lombok.Data;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;

@Data
public abstract class QueryTemplate {
	HashMap<String, Object>map;
	List<Object> list;
	PreparedStatement pstmt;
	protected HttpServletRequest request;

    public final void play(HashMap<String,Object>map){
    	this.pstmt = null;
    	this.list = new ArrayList<>();
    	this.map = map;
    	this.map.put("vender", Vendor.ORACLE);
    	this.map.put("username", DBConstant.USERNAME);
    	this.map.put("password", DBConstant.PASSWORD);
    	initialize();
    	startPlay();
    	endPlay();
   }
	abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();
}
