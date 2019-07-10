package domain;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.File;
import java.io.IOException;

public class text {
    public static void main(String[] args) throws IOException {
        String path=text.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements elements = document.getElementsByTag("student");
        studentDAO studentDAO=new studentDAO();
        for (Element e : elements) {
            String scorename = e.select("scorename").attr("id");
            String ename = e.select("ename").get(0).text();
            String age = e.select("age").get(0).text();
            String gender = e.select("gender").get(0).text();
            //System.out.println(scorename+"  "+ename+"  "+age+"  "+gender);
            Student s=new Student();
            s.setAge(Integer.parseInt(age));
            s.setEname(ename);
            s.setGender(gender);
            s.setScroename(scorename);
            studentDAO.add(s);
        }



    }
}
