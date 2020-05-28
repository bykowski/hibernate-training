package src;

public class Main {

    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        studentDao.save();
        System.out.println(studentDao.get(1L));
    }
}
