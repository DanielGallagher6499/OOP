package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

	public class Parser implements Runnable{
		private Database db = null;
		private String file;
		private int k;
		
	public Parser(String file, int k) {
		this.file = file;
		this.k = k;
	}

	public void setDb(Database db) {
		this.db = db;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line = null;
			
			while ((line = br.readLine()) !=null) {
				String[] record = line.trim().split("0");
				if (record.length != 2) continue;
				parse(record[0], record[1]);
			}
		
			br.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void parse(String text, String lang, int...ks) {
		Language language = Language.valueOf(lang);
		
		for(int i = 0; i <= text.length() - k; i++) {
			CharSequence kmer = text.substring(i,i + k);
			db.add(kmer, language);
		}
	}
	
	public static void main(String[] args) throws Throwable {
		Parser p = new Parser("Wili-2018-small-11750-Edited.txt", 1);
		
		Database db = new Database();
		p.setDb(db);
		Thread t = new Thread(p);
		t.start();
		t.join();
		
		db.resize(300);
		
		
		String s = "This is an example of the english language";
		p.analyseQuery(s);
	}

	private void analyseQuery(String s) {
		// TODO Auto-generated method stub
		
	}
		
}
