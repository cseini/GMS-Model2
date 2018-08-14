package service;

import java.util.Map;

import domain.ImageBean;

public interface ImageService {
	public void insert(ImageBean bean);
	public ImageBean read(String id);
}
