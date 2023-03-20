import Drawings.Arrow;
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
        if (name.equals("")) {
            return;
        }
        JSONArray drawingsList = new JSONArray();
        JSONObject jsonObject = null;
        for (Draw drawing : drawings) {
            if (drawing instanceof CodeBlock) {
                jsonObject = storeCodeBlock((CodeBlock) drawing);
            } else if (drawing instanceof Arrow) {
                jsonObject = storeArrow((Arrow) drawing);
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

    @SuppressWarnings("unchecked")
    private static JSONObject storeCodeBlock(CodeBlock codeBlock) {
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObjectDetails = new JSONObject();
        jsonObjectDetails.put("X1", Integer.toString(codeBlock.getX1()));
        jsonObjectDetails.put("Y1", Integer.toString(codeBlock.getY1()));
        jsonObjectDetails.put("Text", codeBlock.getText());
        if (codeBlock instanceof CallMethodBlock) {
            jsonObjectDetails.put("Name", "CallMethodBlock");
            jsonObject.put("CodeBlock", jsonObjectDetails);
        } else if (codeBlock instanceof ConditionBlock) {
            jsonObjectDetails.put("Name", "ConditionBlock");
            jsonObject.put("CodeBlock", jsonObjectDetails);
        } else if (codeBlock instanceof EndBlock) {
            jsonObjectDetails.put("Name", "EndBlock");
            jsonObject.put("CodeBlock", jsonObjectDetails);
        } else if (codeBlock instanceof InputOutputBlock) {
            jsonObjectDetails.put("Name", "InputOutputBlock");
            jsonObject.put("CodeBlock", jsonObjectDetails);
        } else if (codeBlock instanceof InstructionBlock) {
            jsonObjectDetails.put("Name", "InstructionBlock");
            jsonObject.put("CodeBlock", jsonObjectDetails);
        } else if (codeBlock instanceof StartBlock) {
            jsonObjectDetails.put("Name", "StartBlock");
            jsonObject.put("CodeBlock", jsonObjectDetails);
        } else if (codeBlock instanceof VariableDeclarationBlock) {
            jsonObjectDetails.put("Name", "VariableDeclarationBlock");
            jsonObject.put("CodeBlock", jsonObjectDetails);
        }
        return jsonObject;
    }

    @SuppressWarnings("unchecked")
    private static JSONObject storeArrow(Arrow arrow) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        jsonArray.add(storeCodeBlock(arrow.getBlock1()));
        jsonArray.add(storeCodeBlock(arrow.getBlock2()));

//        List<CodeBlock> codeBlocks = arrow.getCodeBlocks();
//        for (CodeBlock codeBlock : codeBlocks) {
//            jsonObjectDetails = storeCodeBlock(codeBlock);
//            jsonArray.add(jsonObjectDetails);
//        }
        jsonObject.put("Arrow", jsonArray);
        return jsonObject;
    }
}
