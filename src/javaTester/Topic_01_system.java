package javaTester;
// Ví dụ lấy các file của máy
public class Topic_01_system {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String projectPath = System.getProperty("user.dir");//Lấy đường dẩn của project
		System.out.println(projectPath);
		
		String osName= System.getProperty("os.name"); // Lấy tên hệ điều hành trên mấy
		System.out.println(osName);
	}

}
