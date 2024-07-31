package test.task.filterstask.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import test.task.filterstask.model.CriteriaType;

public class CriteriaTypeDeserializer extends JsonDeserializer<CriteriaType> {

    // Makes them uppercase so CriteriaType matches with enum uppercase values.
    @Override
    public CriteriaType deserialize(JsonParser p, DeserializationContext ctxt) throws IOException,
            JsonProcessingException {
        String value = p.getText().toUpperCase();
        return CriteriaType.valueOf(value);
    }
}

