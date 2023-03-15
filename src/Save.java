import Drawings.Blocks.*;
import Drawings.Draw;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Save {
    @SuppressWarnings("unchecked")
    public static void save(List<Draw> drawings, String name) {
        JSONArray drawingsList = new JSONArray();
        JSONObject jsonObject;
        JSONObject jsonObjectDetails;
        for (Draw drawing : drawings) {
            jsonObject = new JSONObject();
            jsonObjectDetails = new JSONObject();
            jsonObjectDetails.put("X1", Integer.toString(drawing.getX1()));
            jsonObjectDetails.put("Y1", Integer.toString(drawing.getY1()));
            jsonObjectDetails.put("Text", drawing.getText());
            if (drawing instanceof CallMethodBlock) {
                jsonObjectDetails.put("Name", "CallMethodBlock");
                jsonObject.put("Drawing", jsonObjectDetails);
            } else if (drawing instanceof ConditionBlock) {
                jsonObjectDetails.put("Name", "ConditionBlock");
                jsonObject.put("Drawing", jsonObjectDetails);
            } else if (drawing instanceof EndBlock) {
                jsonObjectDetails.put("Name", "EndBlock");
                jsonObject.put("Drawing", jsonObjectDetails);
            } else if (drawing instanceof InputOutputBlock) {
                jsonObjectDetails.put("Name", "InputOutputBlock");
                jsonObject.put("Drawing", jsonObjectDetails);
            } else if (drawing instanceof InstructionBlock) {
                jsonObjectDetails.put("Name", "InstructionBlock");
                jsonObject.put("Drawing", jsonObjectDetails);
            } else if (drawing instanceof StartBlock) {
                jsonObjectDetails.put("Name", "StartBlock");
                jsonObject.put("Drawing", jsonObjectDetails);
            } else if (drawing instanceof VariableDeclarationBlock) {
                jsonObjectDetails.put("Name", "VariableDeclarationBlock");
                jsonObject.put("Drawing", jsonObjectDetails);
            }
            drawingsList.add(jsonObject);
        }

        try (FileWriter file = new FileWriter("./DrawingJSONFiles/" + name + ".json")) {
            file.write(drawingsList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
