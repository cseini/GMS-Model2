package pool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;


public class FileDemo {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		final String PATH = "C:\\Users\\1027\\Documents\\sample.txt";
		try {
			File file = new File(PATH);
			FileWriter fw = new FileWriter(file, true);
			FileReader fr = new FileReader(file);
			BufferedWriter writer = new BufferedWriter(fw);
			BufferedReader reader = new BufferedReader(fr);
			while (true) {
				System.out.println("[메뉴] 1.전송 2.읽기 0.종료");
				switch (s.next()) {
				case "1":
					System.out.println("메시지 입력");
					writer.write(s.next());
					writer.newLine();
					writer.flush();
					break;
				case "2":
					System.out.println("메시지 보기");
					String msg = "";
					while((msg = reader.readLine()) != null) {
						System.out.println(msg);
					}
					reader.close();
					break;
				case "0":
					System.out.println("종료");
					return;
					
				default:
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		FileName fn = new FileName(PATH, "\\", ".");
		System.out.println("파일명 : "+fn.getFilename());
		System.out.println("확장자 : "+fn.getExt());
		
	}
}
class FileName{
	// inner class 는  public 을 갖지 않는다.
	// 이유는 이 클래스 내부에서만 사용하고자 함이다.
	// 만약 다른 곳에서 계속 사용한다면 독립시켜야 한다.
	// 1회용 사용 클래스라고 생각하자..
	private String path, sep, ext, filename;
	public FileName(String path, String sep, String ext) {
		this.path = path;
		this.sep = File.separator;
		this.ext=path.substring(path.lastIndexOf(".")+1); //substring() 사용해서 해결바람
		this.filename=path.substring(path.lastIndexOf(sep)+1, path.lastIndexOf("."));
		// lastIndexOf()
		// substring() 사용해서 해결바람
	}
	public String getPath() {
		return path;
	}
	public String getSep() {
		return sep;
	}
	public String getExt() {
		return ext;
	}
	public String getFilename() {
		return filename;
	}
	
}
