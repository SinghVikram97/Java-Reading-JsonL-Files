import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

public class Main6 {
    public static void main(String[] args) throws IOException {
        Emp emp=new Emp("Vikram",12,new Date(1616149532427L));
        JsonSerializer<Date> dateSerializer=new JsonSerializer<Date>() {
            @Override
            public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
                System.out.println(date.getTime());
                return null;
            }
        };
        try(FileWriter writer=new FileWriter("./src/main/java/abc.json")){
            GsonBuilder gsonBuilder=new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Date.class,dateSerializer);
            Gson customGson=gsonBuilder.create();
            customGson.toJson(emp,writer);
        }
    }
}
