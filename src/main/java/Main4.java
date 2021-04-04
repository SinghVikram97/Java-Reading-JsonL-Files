import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Date;

public class Main4 {
    public static void main(String[] args) {
        try{

            GsonBuilder gsonBuilder=new GsonBuilder();
            Gson gson=new Gson();

            JsonDeserializer<Date> deserializer=new JsonDeserializer<Date>() {
                @Override
                public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {


                    return new Date(jsonElement.getAsLong());
                }

            };

            // Only for Date class use this deserializer
            gsonBuilder.registerTypeAdapter(Date.class,deserializer);

            Gson customGson=gsonBuilder.create();

            String json="{'name':'Vikram','age':'13','address':{'houseName':'J-78','floor':2},'dateOfJoining':'1616149532427'}";

            Staff newStaff=customGson.fromJson(json,Staff.class);

            System.out.println(newStaff);
        }catch(JsonSyntaxException e){
            e.printStackTrace();
        }
    }
}
