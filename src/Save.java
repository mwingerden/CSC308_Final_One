import Drawings.Blocks.*;
import Drawings.Draw;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Save {
    public static void save(List<Draw> drawings, String name) {
        JSONArray drawingsList = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        for(Draw drawing : drawings) {
            if(drawing instanceof CallMethodBlock) {
                jsonObject.put("Name", "CallMethodBlock");
            }
            else if(drawing instanceof ConditionBlock){
                jsonObject.put("Name", "ConditionBlock");
            }
            else if(drawing instanceof EndBlock){
                jsonObject.put("Name", "EndBlock");
            }
            else if(drawing instanceof InputOutputBlock){
                jsonObject.put("Name", "InputOutputBlock");
            }
            else if(drawing instanceof InstructionBlock){
                jsonObject.put("Name", "InstructionBlock");
            }
            else if(drawing instanceof StartBlock){
                jsonObject.put("Name", "StartBlock");
            }
            else if(drawing instanceof VariableDeclarationBlock){
                jsonObject.put("Name", "VariableDeclarationBlock");
            }
            jsonObject.put("X1", drawing.getX1());
            jsonObject.put("Y1", drawing.getY1());
            jsonObject.put("X2", drawing.getX2());
            jsonObject.put("Y2", drawing.getY2());
            jsonObject.put("Text", drawing.getText());
            drawingsList.add(jsonObject);
        }

        try (FileWriter file = new FileWriter("./CodeBlockFiles/" + name + ".json")) {
            file.write(drawingsList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
