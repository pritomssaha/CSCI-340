public class Principal extends Thread{

    public void  run(){

        graduation_sppech();
        congratulating();
        leave();
    }

    private void leave() {
        message("Principal is leaving the auditorium");
    }

    private void congratulating() {
        for(int i=0;i<Student.student.length;i++) {
            message("Principal is congratulating " + Student.student[i].getName());
        }
    }

    private void graduation_sppech() {

            message("Principal is giving the graduation speech");
    }


    private void message(String msg) {
        System.out.println(P1.age()+getName()+" : "+msg );
    }


}
