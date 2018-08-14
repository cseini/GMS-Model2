package dao;

import java.util.Map;

import domain.ImageBean;

public interface ImageDao {
	public void insert(ImageBean bean);
	public ImageBean read(String id);
}
