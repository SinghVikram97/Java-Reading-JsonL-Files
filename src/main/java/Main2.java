import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class Main2 {
    public static void main(String[] args) {
        try{
            Gson gson=new Gson();

            String json="{'name':'Vikram','age':'13','address':{'houseName':'J-78','floor':2}}";

            Staff newStaff=gson.fromJson(json,Staff.class);

            System.out.println(newStaff);
        }catch(JsonSyntaxException e){
            e.printStackTrace();
        }
    }
}
