package dao;

import java.util.HashMap;
import java.util.Map;

import domain.ImageBean;
import enums.Domain;
import template.AddQuery;
import template.QueryTemplate;
import template.RetrieveQuery;

public class ImageDaoImpl implements ImageDao{
	private static ImageDao instance = new ImageDaoImpl();
	public static ImageDao getInstance() {return instance;}
	public ImageDaoImpl() {}
	@Override
	public void insert(ImageBean bean) {
		Map<String,Object> map = new HashMap<>();
		QueryTemplate q = new AddQuery();
		map.put("table", Domain.IMAGE);
		map.put("imgName", bean.getImgName());
		map.put("extension", bean.getExtension());
		map.put("userid", bean.getUserid());
		q.play(map);
	}

	@Override
	public ImageBean read(String id) {
		QueryTemplate q = new RetrieveQuery();
		Map<String, Object> map = new HashMap<>();
		map.put("userid", id);
		map.put("table", Domain.IMAGE);
		q.play(map);
		return (ImageBean) q.getO();
	}

}
