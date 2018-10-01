import java.io.*;
import java.util.*;

public class UrlList {
	

	private List<String> urls = new ArrayList<String>();;
	private File file;
	
	
	public UrlList(String filename) throws Exception {
		String line = "";
		file = new File(filename);
		if(!file.isFile()) {
			file.createNewFile();
		}
		FileReader fileReader;
		fileReader = new FileReader(file);
		BufferedReader bufferedReader = 
	            new BufferedReader(fileReader);
	        
	        while((line = bufferedReader.readLine()) != null) {
	            urls.add(line);
	        } 
	        bufferedReader.close();
		
	}
	
	public boolean verifyUrl(String url) {
		return urls.contains(url);
	}
	
	public String readList() {
		String aux = "";
		for(String currUrl:urls) {
			aux+=System.lineSeparator()+currUrl;
		}
		return aux;
	}
	
	public void writeList(String url) {
		if(verifyUrl(url)) {
			return;
		}
		urls.add(url);
		updateFile();
		
	}
	
	public void removeUrl(String url) {
		urls.remove(url);
		updateFile();
	}
	
	private void updateFile() {
		try {
			
			FileWriter fileWriter = new FileWriter(file,false);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for(String str: urls) {
				bufferedWriter.write(str);
				}
			bufferedWriter.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return;
		}
	}

}
