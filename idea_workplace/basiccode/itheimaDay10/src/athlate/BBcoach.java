package athlate;

public class BBcoach extends Coach implements LearnEnglish{
    @Override
    public void teach() {
        System.out.println("教学扣篮");
    }

    @Override
    public void english() {
        System.out.println("中老年英语");
    }
}
