package name.schnee.gpw;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SyncFailedException;
import java.util.Iterator;
import java.util.List;

public class FileCreator {

	public static void main(String args[]) {
		try {
			// Open or create the output file
			FileOutputStream os = new FileOutputStream("C:/temp/text.txt");
			FileDescriptor fd = os.getFD();
			
			String seed = Long.toString(System.currentTimeMillis());
			
			for (int k = 0; k < 1000; k++) {
				// 100 words, 10 characters long
				

				List<String> pwds = PasswordGenerator.generate(100, 10, seed
						.getBytes());

				for (Iterator<String> i = pwds.iterator(); i.hasNext();) {
					String pwd = i.next();

					os.write(pwd.getBytes());
					os.write("\r\n".getBytes());
					os.flush();
					fd.sync();
				}
				seed = pwds.get(0);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SyncFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} // main()
}
