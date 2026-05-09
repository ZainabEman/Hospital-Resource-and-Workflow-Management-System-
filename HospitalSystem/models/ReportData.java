package models;

// CODE SMELL: Lazy Class
public class ReportData {
    public String title;
    public String content;

    public ReportData(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
