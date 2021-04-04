import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class Main3 {
    public static void main(String[] args) {
        try{
            Gson gson=new Gson();

            String json="{'name':'Vikram','age':'13','address':{'houseName':'J-78','floor':'abc'}}";

            Staff newStaff=gson.fromJson(json,Staff.class);

            System.out.println(newStaff);
        }catch(JsonSyntaxException e){
            System.out.println("Hi");
        }
    }
}
