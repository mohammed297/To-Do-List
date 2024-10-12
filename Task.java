import java.util.ArrayList;

import java.util.Scanner;

public class Task {

    String title;
    String discription;
    int time;
    boolean completed;
    static Task task=new Task();
    static ArrayList<Task> tasks=new ArrayList<>();
    static Scanner obj =new Scanner(System.in);

    public Task(){}

    public Task(String title,String discription,int time){
        this.title=title;
        this.discription=discription;
        this.time=time;
        this.completed=false;
    }

    public static void create( ){
        System.out.println("enter the time :");
        int time1=obj.nextInt();
        System.out.println("enter the title:");
        obj.nextLine();
        String title1=obj.nextLine();
        System.out.println("enter the discription:");
        String discription1=obj.nextLine();
        tasks.add(new Task(title1,discription1,time1));
        System.out.println("* the task added *");
    }

    public static void update(){
        System.out.println("enter the id :");
        int id=obj.nextInt();
        System.out.println("enter the time :");
        int time1=obj.nextInt();
        System.out.println("enter the title:");
        obj.nextLine();
        String title1=obj.nextLine();
        System.out.println("enter the discription:");
        String discription1=obj.nextLine();
        tasks.set(id-1, new Task(title1,discription1,time1));
        sort();
    }

    public static void delete(){

        System.out.println("enter the id :");
        int id=obj.nextInt();
        tasks.remove(id-1);
        sort();
    }
    public static void read(){
        System.out.println("****** the tasks ****** :");
        for(int i=0;i<tasks.size() ;i++){
            System.out.println((i+1)+"."+tasks.get(i).title+"\t"+" : "+tasks.get(i).discription+"\t("+tasks.get(i).completed+")\t\t"+tasks.get(i).time);
        }
    }
    public static void completed(){
        System.out.println("enter the id :");
        int id=obj.nextInt();
        tasks.get(id-1).completed=true;
    }

    public static void sort(){
        Task temp = new Task();
        for (int i=0;i<tasks.size();i++){
            for (int j = i + 1; j < tasks.size(); j++){
                if (tasks.get(i).time > tasks.get(j).time) {
                    temp = tasks.get(i);
                    tasks.set(i,tasks.get(j));
                    tasks.set(j,temp);
                }
            }
        }
    }

    public static void mainMenu(){
        boolean flag=false;
        Task task=new Task();
        do {
            System.out.println(" 1. add new task: ");
            System.out.println(" 2. update the task: ");
            System.out.println(" 3. delete the task: ");
            System.out.println(" 4. read the task:");
            System.out.println(" 5. completed task");
            System.out.println(" 0. exit :");
            System.out.println("enter your choice: ");
            Scanner obj = new Scanner(System.in);
            int choice = obj.nextInt();
            obj.nextLine();
            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    read();
                    break;
                case 5:
                    completed();
                    break;
                case 0:
                    flag=true;
                    break;
                default:
                    System.out.println("* This task not exist *");
            }

            if(flag==true){
                break;
            }
            System.out.println("\n-------------------------------------------------------\n");
        }while (true);

    }
}
