import java.lang.*;
import java.awt.*;
import java.awt.event.*;

class Withdraw extends Thread{
    Label box;
    String src = "";
    String dest = "";
    long tmp;
    public Withdraw(Frame UI){
        box = new Label("count");
        UI.add(box);
    }

    public void costly(){
        for(int i =0;i<256;i++){
            src+="aa"+i;
            dest+="aa"+i;
        }
        src.compareTo(dest);
        //System.out.println(src+"\n"+dest);

    }

    public void run() {
        // DO SOME COMPUTATION
        // now wait for others to finish
        int j=0;
        long tmp2;
        while(true){
            while(!Test.stop){

                j++;
                tmp2 = Test.pubCounter;
                box.setText(j+"Withdraw "+tmp2+"-"+tmp+"-"+Test.pubCounter);
                try{
                    Thread.sleep(Test.sleepTime);
                }
                catch(Exception e){
                }
                tmp = tmp2 - 2;
                box.setText(j+"Withdraw "+tmp2+"-"+tmp+"-"+Test.pubCounter);
                try{
                    Thread.sleep(Test.sleepTime);
                }
                catch(Exception e){
                }

                Test.pubCounter= tmp;
                box.setText(j+"Withdraw "+tmp2+"-"+tmp+"-"+Test.pubCounter);
                System.out.println(j+"Withdraw "+tmp2+"-"+tmp+"-"+Test.pubCounter);


                try{
                    Thread.sleep(Test.sleepTime*5);
                }
                catch(Exception e){
                }

            }
            try{

                wait();
            }
            catch(Exception e){
            }
        }
    }
}

class Deposit extends Thread{
    Label box;
    String src = "";
    String dest = "";
    long tmp;
    public Deposit(Frame UI){
        box = new Label("count");
        UI.add(box);
    }

    public void costly(){
        for(int i =0;i<256;i++){
            src+="aa"+i;
            dest+="aa"+i;
        }
        src.compareTo(dest);
        //System.out.println(src+"\n"+dest);

    }

    public void run() {
        // DO SOME COMPUTATION
        // now wait for others to finish
        int j=0;
        long tmp2=0;
        while(true){
            while(!Test.stop){

                j++;
                tmp2 = Test.pubCounter;
                box.setText(j+"Deposit "+tmp2+"-"+tmp+"-"+Test.pubCounter);
                try{
                    Thread.sleep(Test.sleepTime);
                }
                catch(Exception e){
                }
                tmp = tmp2 + 2;
                box.setText(j+"Deposit "+tmp2+"-"+tmp+"-"+Test.pubCounter);
                try{
                    Thread.sleep(Test.sleepTime);
                }
                catch(Exception e){
                }

                Test.pubCounter= tmp;
                box.setText(j+"Deposit "+tmp2+"-"+tmp+"-"+Test.pubCounter);
                System.out.println(j+"Deposit "+tmp2+"-"+tmp+"-"+Test.pubCounter);


                try{
                    Thread.sleep(Test.sleepTime*5);
                }
                catch(Exception e){
                }
            }
            try{

                wait();
            }
            catch(Exception e){
            }
        }
    }
}

class TestGUI extends Frame{
    Button stopBtn;
    Button countBtn;
    Button addBtn;
    int count=1;
    public TestGUI(){

        super("BasicApplication Title");

        setSize(200, 200);
        // add a demo component to this frame
        setLayout(new FlowLayout());
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false); dispose();
                System.exit(0);
            }

        });
        init();

    }

    public void stop(){
        if(!Test.stop){
            stopBtn.setLabel("Start");
            Test.pubCounter=100;
        }
        else
            stopBtn.setLabel("Stop");
        Test.stop = !Test.stop;
        if(!Test.stop){
            try{

                notifyAll();
            }
            catch(Exception e){
            }
        }
    }

    public void count(){
        if(!Test.count)
            countBtn.setLabel("Heavy CPU");
        else
            countBtn.setLabel("Light CPU");
        Test.count = !Test.count;
    }

    public void add(){
        //setVisible(false);
        (new Withdraw(this)).start();
        (new Deposit(this)).start();
        count++;
        addBtn.setLabel("Add "+count);
        setVisible(true);
    }
    public void init(){

        Button b1 = new Button("Stop");
        b1.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        stop();
                    }
                }
        );
        add(b1);
        stopBtn=b1;

        b1 = new Button("Light");
        b1.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        count();
                    }
                }
        );
        add(b1);
        countBtn =b1;

        b1 = new Button("Add");
        b1.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        add();
                    }
                }
        );
        add(b1);
        addBtn = b1;

        b1 = new Button("Fast");
        b1.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){

                        if(Test.sleepTime <100)
                            Test.sleepTime=100;
                        else
                            Test.sleepTime=Test.sleepTime-100;

                    }
                }
        );
        add(b1);

        b1 = new Button("Slow");
        b1.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        Test.sleepTime=Test.sleepTime+100;
                    }
                }
        );
        add(b1);

        setVisible(true);
    }
}
class MyBool {
    boolean val;
    public MyBool(boolean v){
        val=v;
    }
    boolean get(){
        return val;
    }
    void set(boolean v){
        val =v;
    }
}

public class Test{
    public static boolean stop = false;
    public static boolean count = true;
    public static int sleepTime = 100;
    public static  long pubCounter = 100;
    public static volatile MyBool lock = new MyBool(false);

    public static synchronized boolean TestandSet(MyBool val){
        boolean temp = val.get();
        val.set(true);
        return temp;
    }


    public static void main(String[] args) {
        TestGUI test = new TestGUI();
        //System.out.println("before "+Test.lock.get());
        //Test.TestandSet(Test.lock);
        //System.out.println("After "+Test.lock.get());
        //Test.lock.set(false);
        (new Deposit (test)).start();
        (new Withdraw (test)).start();
        //(new ParallelComputation (test)).start();
        //(new ParallelComputation (test)).start();

    	/*try{
    		Process p = new ProcessBuilder("java", "Test").start();
		} catch (Exception e){

		}
		*/

    }
}
