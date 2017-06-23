import java.io.File;

public class ProjectFolder {
	public static void main(String[] args) {
	}
		public void createFolder() {
			NewProject newProject = new NewProject();
			String projectPath = ("C:\\Jibberish\\");
			File folder = new File(projectPath);
		try {
			if(folder.exists()) {
			System.out.println("Folder already exists.");
	}else{
		folder.mkdir();
		System.out.println("Folder created.");	
	}
} 	catch (Exception e) {
		e.printStackTrace();
}
} }

