import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JSONParser jsonParser=new JSONParser();

        try(FileReader reader=new FileReader("./src/main/java/data.json")){
            Object obj=jsonParser.parse(reader);

            JSONObject jsonObject=(JSONObject) obj;

            parseTransactionDocument(jsonObject);


        } catch(IOException | ParseException e){
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void parseTransactionDocument(JSONObject jsonObject){
        String paymentTransactionId=jsonObject.get("paymentTransactionId").toString();

        System.out.println("Payment transaction id: "+paymentTransactionId);

        System.out.println("Transaction: ");
        JSONObject transaction= (JSONObject) jsonObject.get("transaction");

        transaction.forEach((key,value)->{
            System.out.println(key+" : "+value);
        });

        System.out.println("Current State");
        JSONObject currentState=(JSONObject) jsonObject.get("currentState");
        currentState.forEach((key,value)->{
            System.out.println(key+" : "+value);
        });

        JSONArray stateHistory=(JSONArray) jsonObject.get("stateHistory");
        for (int i = 0; i < stateHistory.size(); i++) {
            System.out.println("Transaction index: "+(i+1));
            JSONObject temp=(JSONObject) stateHistory.get(i);

            temp.forEach((key,value)->{
                System.out.println(key+" : "+value);
            });

        }


    }

}
