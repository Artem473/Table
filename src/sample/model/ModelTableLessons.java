package sample.model;

public class ModelTableLessons {

    private String id;
    private String teacher;
    private String course;
    private String room;
    private String lesson_date;

    public ModelTableLessons (String id, String teacher, String course,String room,String lesson_date){
    }
    public String getId(){
        return id;
    }
    public String getTeacher(){
        return teacher;
    }
    public String getCourse(){
        return course;
    }
    public String getRoom(){
        return room;
    }
    public String getLesson_date(){
        return lesson_date;
    }
}
