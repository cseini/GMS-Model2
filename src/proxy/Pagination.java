package proxy;

import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import lombok.Data;
import service.MemberServiceImpl;
@Data
public class Pagination implements Proxy {
	int count, pageNumber,beginRow, endRow, pageSize, blockSize, pageCount, blockCount, beginPage, endPage, prevBlock, nextBlock, lastBlockPage;
	boolean existPrev, existNext;

	@Override
	public void carryOut(Object o, Object i) {
		this.pageNumber = (int)o;
		this.count =MemberServiceImpl.getInstance().count();
		/*this.pageSize=5;*/
		this.pageSize=(int) i;
		this.blockSize=5;
		this.beginRow = pageNumber*pageSize-(pageSize-1);
		this.endRow = pageNumber*pageSize;
		this.pageCount = count/pageSize==0?count/pageSize:count/pageSize+1;
		this.blockCount = pageCount/blockSize==0?pageCount/blockSize:pageCount/blockSize+1;
		this.beginPage= pageNumber-((pageNumber-1)%blockSize);
		this.lastBlockPage=pageCount-((pageCount-1)%blockSize);
		this.endPage=((lastBlockPage+pageSize)>pageNumber&&pageNumber>=lastBlockPage)?pageCount:beginPage+(blockSize-1);
		this.prevBlock = beginPage - blockSize;
		this.nextBlock = beginPage + blockSize;
		this.existPrev=(prevBlock>=0);
		this.existNext=(nextBlock<=pageCount);
		
	}
}
