package enums;

public enum Path {
	 WEBPATH, MAIN, RESOURCES, UPLOAD_PATH;

	@Override
	public String toString() {
		String res="";
			switch (this) {
			case WEBPATH:res = "/WEB-INF/view/";break;
			case MAIN:res = "/main.jsp";break;
			case RESOURCES:res = "/resources/";break;
			case UPLOAD_PATH:res = "C:\\Users\\1027\\JavaWorkspace\\jeeWorkspace\\GMS-Model2\\WebContent\\resources\\img\\upload\\";break;
			default:break;}
		return res;
	}
}
