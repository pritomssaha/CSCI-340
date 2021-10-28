public class P1 {
    public static int numofstudent=13;
    public static int rowCapacity=4;
    public static int numRows=11;
    public static long time = System.currentTimeMillis();

    public static void main(String[] args) throws InterruptedException {

        Principal P = new Principal();
        //P.start();
        for (int i=0;i<numofstudent;i++){
            try{
                Thread.sleep(200);
            }catch (InterruptedException e){}
            Student.student[i]=new Student(i);
            Student.student[i].start();
            //if all the student are seated, the student must be blocked and the principal thread must be in run state
            /*if(Student.isSeated==true){
                Student.student[i].join();
                P.start();
            }
            //the student should be in run state
            Student.student[i].yield();*/


        }

        P.start();



        while(true){
            int j=numofstudent-1;
            while (j>=0){
                Student.student[j].interrupt();
                try {
                    Thread.sleep(200);
                }catch (InterruptedException e){}
                j--;
            }
        }


    }








    public static String age(){
        return "[" + (System.currentTimeMillis() - time) + "]";
    }


}
