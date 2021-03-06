package proxy;
import java.util.Map;

import lombok.Data;
@Data
public class Pagination implements Proxy {
	int countRow, pageNumber,beginRow, endRow, pageSize, blockSize, pageCount, blockCount, beginPage, endPage, prevBlock, nextBlock, lastBlockPage;
	boolean existPrev, existNext;

	/*@Override
	public void carryOut(Object o) {
		this.pageNumber = (int)o;
		this.pageSize=5;
		this.blockSize=5;
		this.beginRow = pageNumber*pageSize-(pageSize-1);
		this.endRow = pageNumber*pageSize;
		this.countRow =MemberServiceImpl.getInstance().count();
		this.pageCount = countRow/pageSize==0?countRow/pageSize:countRow/pageSize+1;
		this.blockCount = pageCount/blockSize==0?pageCount/blockSize:pageCount/blockSize+1;
		this.beginPage= pageNumber-((pageNumber-1)%blockSize);
		this.lastBlockPage=pageCount-((pageCount-1)%blockSize);
		this.endPage=((lastBlockPage+pageSize)>pageNumber&&pageNumber>=lastBlockPage)?pageCount:beginPage+(blockSize-1);
		this.prevBlock = beginPage - blockSize;
		this.nextBlock = beginPage + blockSize;
		this.existPrev=(prevBlock>=0);
		this.existNext=(nextBlock<=pageCount);
	}*/
	
	@Override
	public void carryOut(Map<?,?> param) {
		this.pageNumber = (int) param.get("pageNumber");
/*		this.pageNumber = (int)o);*/
		this.pageSize=5;
		this.blockSize=5;
		this.beginRow = pageNumber*pageSize-(pageSize-1);
		this.endRow = pageNumber*pageSize;
		/*this.countRow =MemberServiceImpl.getInstance().count();*/
		this.countRow =(int) param.get("countRow");
		this.pageCount = countRow%pageSize==0?countRow/pageSize:countRow/pageSize+1;
		this.blockCount = pageCount%blockSize==0?pageCount/blockSize:pageCount/blockSize+1;
		this.beginPage= pageNumber-((pageNumber-1)%blockSize);
		this.lastBlockPage=pageCount-((pageCount-1)%blockSize);
		this.endPage=((lastBlockPage+pageSize)>pageNumber&&pageNumber>=lastBlockPage)?pageCount:beginPage+(blockSize-1);
		this.prevBlock = beginPage - blockSize;
		this.nextBlock = beginPage + blockSize;
		this.existPrev=(prevBlock>=0);
		this.existNext=(nextBlock<=pageCount);
	}
}
