package reports;

// CODE SMELL: Parallel Inheritance Hierarchies
public abstract class Report {
    protected String title;
    
    public Report(String title) {
        this.title = title;
    }
    
    public abstract void generate();
}
