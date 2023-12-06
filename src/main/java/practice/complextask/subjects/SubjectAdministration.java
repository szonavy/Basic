package practice.complextask.subjects;

public class SubjectAdministration {
    //Albatrosz Aladin
    //biologia
    //9.a
    //2
    String name;
    String subject;
    String schoolClass;
    int subjectNumber;

    public SubjectAdministration(String name, String subject, String schoolClass, int subjectNumber) {
        this.name = name;
        this.subject = subject;
        this.schoolClass = schoolClass;
        this.subjectNumber = subjectNumber;
    }

    @Override
    public String toString() {
        return "SubjectAdministration{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", schoolClass='" + schoolClass + '\'' +
                ", subjectNumber='" + subjectNumber + '\'' +
                '}';
    }
}
