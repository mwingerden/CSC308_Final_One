import Drawings.Blocks.*;
import Drawings.Draw;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Load {
    private static final List<Draw> drawingsList = new ArrayList<>();
    @SuppressWarnings("unchecked")
    public static List<Draw> load(String name) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("./DrawingJSONFiles/" + name + ".json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray drawings = (JSONArray) obj;
            drawings.forEach(emp -> parseDrawingObject((JSONObject) emp));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return drawingsList;
    }

    private static void parseDrawingObject(JSONObject drawing) {
        JSONObject drawingObject = (JSONObject) drawing.get("Drawing");
        Draw temp = null;
        if(drawingObject.get("Name").equals("CallMethodBlock")) {
            temp = new CallMethodBlock(Integer.parseInt((String)drawingObject.get("X1")),
                    Integer.parseInt((String)drawingObject.get("Y1")));
            temp.setText((String)drawingObject.get("Text"));
        } else if(drawingObject.get("Name").equals("ConditionBlock")) {
            temp = new ConditionBlock(Integer.parseInt((String)drawingObject.get("X1")),
                    Integer.parseInt((String)drawingObject.get("Y1")));
            temp.setText((String)drawingObject.get("Text"));
        }else if(drawingObject.get("Name").equals("EndBlock")) {
            temp = new EndBlock(Integer.parseInt((String)drawingObject.get("X1")),
                    Integer.parseInt((String)drawingObject.get("Y1")));
            temp.setText((String)drawingObject.get("Text"));
        }else if(drawingObject.get("Name").equals("InputOutputBlock")) {
            temp = new InputOutputBlock(Integer.parseInt((String)drawingObject.get("X1")),
                    Integer.parseInt((String)drawingObject.get("Y1")));
            temp.setText((String)drawingObject.get("Text"));
        }else if(drawingObject.get("Name").equals("InstructionBlock")) {
            temp = new InstructionBlock(Integer.parseInt((String)drawingObject.get("X1")),
                    Integer.parseInt((String)drawingObject.get("Y1")));
            temp.setText((String)drawingObject.get("Text"));
        }else if(drawingObject.get("Name").equals("StartBlock")) {
            temp = new StartBlock(Integer.parseInt((String)drawingObject.get("X1")),
                                  Integer.parseInt((String)drawingObject.get("Y1")));
            temp.setText((String)drawingObject.get("Text"));
        }else if(drawingObject.get("Name").equals("VariableDeclarationBlock")) {
            temp = new VariableDeclarationBlock(Integer.parseInt((String)drawingObject.get("X1")),
                    Integer.parseInt((String)drawingObject.get("Y1")));
            temp.setText((String)drawingObject.get("Text"));
        }
        drawingsList.add(temp);
    }
}
