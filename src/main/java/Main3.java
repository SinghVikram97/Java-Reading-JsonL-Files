import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Date;

public class Main3 {
    public static void main(String[] args) {
        try{

            GsonBuilder gsonBuilder=new GsonBuilder();
            Gson gson=new Gson();

            JsonDeserializer<Staff> deserializer=new JsonDeserializer<Staff>() {
                @Override
                public Staff deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                    JsonObject jsonObject=jsonElement.getAsJsonObject();

                    Date date=new Date(jsonObject.get("dateOfJoining").getAsLong());
                    Address address=gson.fromJson(jsonObject.get("address"),Address.class);

                    return new Staff(jsonObject.get("name").getAsString(),jsonObject.get("age").getAsInt(),address,date);



                }

            };

            gsonBuilder.registerTypeAdapter(Staff.class,deserializer);

            Gson customGson=gsonBuilder.create();

            String json="{'name':'Vikram','age':'13','address':{'houseName':'J-78','floor':2},'dateOfJoining':'12345'}";

            Staff newStaff=customGson.fromJson(json,Staff.class);

            System.out.println(newStaff);
        }catch(JsonSyntaxException e){
            e.printStackTrace();
        }
    }
}
