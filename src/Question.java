public class Question {

    private double id;
    private String question;
    private String answer;

    Question(String question, String answer) {

        this.id = Math.random();
        this.question = question;
        this.answer = answer;
    }

    public double getId() {
        return id;
    }

    String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return getQuestion() + " - " + getAnswer();
    }
}