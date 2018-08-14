package command;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import domain.ImageBean;
import domain.MemberBean;
import enums.Path;
import service.ImageServiceImpl;
import service.MemberServiceImpl;

public class FileCommand extends Command {

	public FileCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
		@Override
		public void execute() {
			/*System.out.println("파일커맨드 진입");
			ImageBean bean = new ImageBean();
			bean.setUserid(((MemberBean) request.getSession().getAttribute("member")).getUserId());
			bean.setImgName("aaa");
			bean.setExtension("jpg");*/
			/*ImageServiceImpl.getInstance().insert(bean);*/
			super.execute();
		}
}
	