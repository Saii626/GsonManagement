package app.saikat.GsonManagement;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

class JsonClassAdapter implements JsonSerializer<Class<?>>, JsonDeserializer<Class<?>> {

	@Override
	public Class<?> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		try {
			return Class.forName(json.getAsString());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Unable to cast");
		}
	}

	@Override
	public JsonElement serialize(Class<?> src, Type typeOfSrc, JsonSerializationContext context) {
		return new JsonPrimitive(src.getName());
	}
}
