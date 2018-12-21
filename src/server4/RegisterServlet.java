package server4;

public class RegisterServlet extends Servlet {
    @Override
    public void doGet(Request req, Response rep) throws Exception {

    }
    @Override
    public void service(Request req, Response rep) throws Exception{
     if(req.getMethod().equalsIgnoreCase("get"))
            this.doGet(req,rep);
        if(req.getMethod().equalsIgnoreCase("post"))
            this.doPost(req,rep);
    }
    @Override
    public void doPost(Request req, Response rep) throws Exception {
//        rep.println("<html lang=\"en\">\n" +
//                "<head>\n" +
//                "    <title>return register</title>\n" +
//                "</head>\n" +
//                "<body>" );
//        rep.println("register:\nwelcome:").println(req.getParameter("uname")).println("go back");
//        rep.println(
//                "</body>\n" +
//                        "</html>");
    }
}
