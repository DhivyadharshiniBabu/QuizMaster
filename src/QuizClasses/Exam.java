package QuizClasses;

public class Exam {

    public Exam(String ExamId, String language, int totalQuestions) {
        this.ExamId = ExamId;
        this.language = language;
        this.totalQuestions = totalQuestions;
    }

    private String ExamId;
    private String language;
    private int totalQuestions;

    @Override
    public String toString() {
        return "Exam{" + "ExamId=" + ExamId + ", language=" + language + ", totalQuestions=" + totalQuestions + '}';
    }

    public String getExamId() {
        return ExamId;
    }

    public void setExamId(String ExamId) {
        this.ExamId = ExamId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }


}