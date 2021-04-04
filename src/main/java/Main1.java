import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main1 {
    public static void main(String[] args) {
        BufferedReader br=null;
        JSONParser parser=new JSONParser();

        try{
            String sCurrentLine;
            br=new BufferedReader(new FileReader("./src/main/java/file.jsonl"));
            System.out.println("List of record: ");
            int index=1;
            while((sCurrentLine=br.readLine())!=null){
                //System.out.println("Record:\t"+sCurrentLine);

                Object obj=parser.parse(sCurrentLine);

                JSONObject jsonObject=(JSONObject) obj;
                System.out.println("***************************");
                System.out.println("Record "+index);

                parseTransactionDocument(jsonObject);

                index++;

            }

        }catch (IOException | ParseException e){
            e.printStackTrace();
        }finally {
            try{
                if(br!=null){
                    br.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
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

