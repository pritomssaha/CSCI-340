import java.util.Random;

public class Student extends Thread{


    public static Student[] student=new Student[13];
    private int number;
    public int defaultPriority;
    public static long time = System.currentTimeMillis();
    private P1 p1=new P1();
    public int i=0;
    public int[][] sit=new int[P1.numRows][P1.rowCapacity];
    public static boolean isSeated=false;

    public Student(int i){
        this.number=i;
        setName("Student: "+i);
    }

    public void priority(){
        try{
            defaultPriority = Thread.currentThread().getPriority();
            Thread.currentThread().setPriority(Thread.currentThread().getPriority() + 1);
            Thread.sleep((int)Math.random() * 11000 + 1);
            Thread.currentThread().setPriority(defaultPriority);
        }
        catch (InterruptedException e) {
        }

    }

    public void run(){


        //student sit in rows

        student_sit();
        family_sit();
        Terminate();
    }

    private void student_sit() {
        int j=0,s=0;
        try{
            Thread.sleep(200);
        }catch (InterruptedException e){}
        /*while(j<P1.numRows){
            System.out.println(P1.age()+getName()+" sits in row: "+j );
            j++;
            try{
                Thread.sleep(600);
            }catch (InterruptedException e){}
        }
        isSeated=true;*/
        while(j<P1.numRows && !isSeated){
            System.out.println(P1.age()+getName()+" sits in row: "+j );
            j++;
            s++;
            if(s-1==P1.numofstudent){
                isSeated=true;
            }
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){}
        }

    }

    private void family_sit() {
        int j=6;
        int f=0;
        try {
            Thread.sleep(200);
        }catch (InterruptedException e){}
        while(j<P1.numRows){
            System.out.println(P1.age()+getName()+"family"+f+" sits in row: "+j );
            System.out.println(P1.age()+getName()+"family"+f+++" sits in row: "+j );
            System.out.println(P1.age()+getName()+"family"+f+++" sits in row: "+j );

            j++;
        }

    }


    private int randomNumber(){
        Random rand = new Random();
        int int_random = rand.nextInt(3);
        return int_random%10;
    }

    private void Terminate() {
        message_family("is leaving the auditorium");
        try{
            Thread.sleep(2000);

        }catch (InterruptedException e){}
        message("is leaving the auditorium");
    }


    private void message(String msg) {
        System.out.println(P1.age()+getName()+" : "+msg );
    }
    private void message_family(String msg) {
        System.out.println(P1.age()+getName()+" family"+randomNumber()+" : "+msg );
    }

}
