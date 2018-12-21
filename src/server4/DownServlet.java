package server4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class DownServlet extends Servlet {

	@Override
	public void service(Request request, Response response) {
		// TODO Auto-generated method stub
		/*response.print(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("com.server.index.html"));*/

		String url = request.getUrl();

        for (String str:Server.list
             ) {
            //System.out.println(str);

            if(str.equals(url.trim())){
                url="D:\\QQ\\1874980400\\FileRecv\\socket\\src\\server4\\"+url;
                String content = readToString(url);
                //System.out.println("***************");
                response.println(content);
                return;
            }

        }
        response.println("404 not found");
	}

    @Override
    public void doGet(Request req, Response rep) throws Exception {

    }

    @Override
    public void doPost(Request req, Response rep) throws Exception {

    }

    public String readToString(String fileName) {
        String encoding = "gbk";
        File file = new File(fileName);  
        Long filelength = file.length();  
        byte[] filecontent = new byte[filelength.intValue()];  
        try {  
            FileInputStream in = new FileInputStream(file);  
            in.read(filecontent);  
            in.close();  
        } catch (FileNotFoundException e) {
            System.out.println("3");
            e.printStackTrace();  
        } catch (IOException e) {
            System.out.println("2");
            e.printStackTrace();  
        }  
        try {  
            return new String(filecontent, encoding);  
        } catch (UnsupportedEncodingException e) {  
            System.err.println("The OS does not support " + encoding);
            System.out.println("1");
            e.printStackTrace();  
            return null;  
        }  
    }

}
