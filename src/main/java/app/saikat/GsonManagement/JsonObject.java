package app.saikat.GsonManagement;

import com.google.gson.annotations.JsonAdapter;

@JsonAdapter(JsonObjectAdapter.class)
public class JsonObject {
    private Object object;
    private String typeName, dataName;

    /**
     * Creates a new JsonObject wrapping this object such that this object can be read from or
     * written to json string
     * @param object the object to wrap
     */
    public JsonObject(Object object) {
        this(object, "type", "data");
    }

    /**
     * Internal API
     */
    JsonObject(Object object, String typeName, String dataName) {
        this.object = object;
        this.typeName = typeName;
        this.dataName = dataName;

    }

    /**
     * Gets the object stored in this
     * @return the object this holds
     */
    public Object getObject() {
        return object;
    }

    // void setObject(Object object) {
    //     this.object = object;
    // }

    String getTypeName() {
        return typeName;
    }

    String getDataName() {
        return dataName;
    }

    // public void setTypeName(String typeName) {
    //     this.typeName = typeName;
    // }

    // public void setDataName(String dataName) {
    //     this.dataName = dataName;
    // }
}
