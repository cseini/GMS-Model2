package command;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import domain.ImageBean;
import domain.MemberBean;
import enums.Path;
import service.ImageServiceImpl;

public class FileCommand extends Command {

	public FileCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
		@Override
		public void execute() {
			System.out.println("====[1]파일커맨드진입====");
			if(!ServletFileUpload.isMultipartContent(request)){
				System.out.println("업로드파일이 없습니다.");
				return;
			}
			System.out.println("====[2]==== 업로드파일이 존재함");
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(1024*1024*40);//40MB
			upload.setSizeMax(1024*1024*50);//50MB
			List<FileItem> items = null;
			try {
				System.out.println("====[3]====try 내부로 진입");
				File file = null;
				items = upload.parseRequest(new ServletRequestContext(request));
				System.out.println("====[4]====items 생성");
				Iterator<FileItem> iter = items.iterator();
				while(iter.hasNext()) {
					System.out.println("====[5]====while 진입");
					FileItem item = (FileItem)iter.next();
					if(!item.isFormField()) {
						System.out.println("====[6]====if 진입");
						String fileName = item.getName();
						file = new File(Path.UPLOAD_PATH+fileName);
						item.write(file);
						System.out.println("====[7]====파일업로드 성공 !!!");
						//image table 에 id, image name, ext 저장.
						ImageBean bean = new ImageBean();
						bean.setUserid(((MemberBean)request.getSession().getAttribute("user")).getUserId());
						bean.setImgName(fileName.split("\\.")[0]);
						bean.setExtension(fileName.split("\\.")[1]);
						ImageServiceImpl.getInstance().insert(bean);
					} else {
						System.out.println("====[8]====파일업로드 실패 !!!");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("====[10]====");
			super.execute();
		}
}
	