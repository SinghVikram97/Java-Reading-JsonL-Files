import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Main5 {
    public static void main(String[] args) {
        try{

            GsonBuilder gsonBuilder=new GsonBuilder();
            Gson gson=new Gson();

            JsonDeserializer<Date> dateDeserializer=new JsonDeserializer<Date>() {
                @Override
                public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                    return new Date(jsonElement.getAsLong());
                }

            };

            JsonDeserializer<Instant> instantDeserializer=new JsonDeserializer<Instant>() {
                @Override
                public Instant deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                    try{
                        return Instant.parse(jsonElement.getAsString());
                    }
                    catch(DateTimeParseException e){
                        System.out.println("Invalid instant");
                        return null;
                    }
                }
            };

            // Only for Date class use this deserializer
            gsonBuilder.registerTypeAdapter(Date.class,dateDeserializer).registerTypeAdapter(Instant.class,instantDeserializer);

            Gson customGson=gsonBuilder.create();

            String json="{'name':'Vikram','age':'13','address':{'houseName':'J-78','floor':2,'instantVar':'abc'},'dateOfJoining':'1616149532427'}";

            Staff newStaff=customGson.fromJson(json,Staff.class);

            System.out.println(newStaff);


        }catch(JsonSyntaxException e){
            e.printStackTrace();
        }
    }
}
