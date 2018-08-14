package service;

import java.util.Map;

import dao.ImageDaoImpl;
import domain.ImageBean;

public class ImageServiceImpl implements ImageService{
	private static ImageService instance = new ImageServiceImpl();
	public static ImageService getInstance() {return instance;}
	private ImageServiceImpl() {	}

	@Override
	public void insert(ImageBean bean) {
		ImageDaoImpl.getInstance().insert(bean);
	}

	@Override
	public ImageBean read(String id) {
		return ImageDaoImpl.getInstance().read(id);
	}

}
