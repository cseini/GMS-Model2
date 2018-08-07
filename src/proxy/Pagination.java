package proxy;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;
@Data
public class Pagination implements Proxy {
	int pageNumber,beginRow, endRow, pageSize, blockSize, pageCount, blockCount, beginPage, endPage, prevBlock, nextBlock;
	boolean existPrev, existNext;

	@Override
	public Map<?, ?> carryOut(Map<?, ?> param) {
		Map<String,Object> map=new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("endRow", endRow);
		return map;
	}
}
