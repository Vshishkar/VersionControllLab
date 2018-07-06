package by.tc.vcl.entity.repository;

public class Repository  {

    String title;

    public Repository() {}

    public Repository(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "title='" + title + '\'' +
                '}';
    }
}
