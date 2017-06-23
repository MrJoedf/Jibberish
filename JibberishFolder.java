import java.io.File;
/*Create the main "Jibberish" folder
 * where all of the program files
 * will be held.
 */
public class JibberishFolder {
	public static void main(String[] args) {}
	public void createFolder() {
		String path = "C:\\Jibberish";
		File folder = new File(path);
		try {
			if(folder.exists()) {
				System.out.println("Folder already exists.");
			}else{
				folder.mkdir();
				System.out.println("Folder created.");	
			}
		} catch (Exception e) {
			e.printStackTrace();	}
		}
	}

