public class Time{
    public static void main(String[] args) {
        String time = "13:44";
        int ftwo = Integer.parseInt(time.substring(0,2));
        if(ftwo > 24 || ftwo < 0){
            System.out.println("invalid");
        }

        if(ftwo>=0 && ftwo<=11){
            System.out.println("AM");
        }
        if(ftwo >=12 && ftwo<=23){
            System.out.println("Pm");
        }

    }
}