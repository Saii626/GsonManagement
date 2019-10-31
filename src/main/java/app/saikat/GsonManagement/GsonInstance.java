package app.saikat.GsonManagement;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import app.saikat.DIManagement.Provides;
import app.saikat.GsonManagement.AnnotedExclusionStrategy;
import app.saikat.GsonManagement.PostProcessingAdapterFactory;

public class GsonInstance {

	// private static Gson gson;

	@Provides
	public static Gson getGson() {
		GsonBuilder builder = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
				.setExclusionStrategies(new AnnotedExclusionStrategy())
				.registerTypeAdapter(Class.class, new JsonClassAdapter())
				.registerTypeAdapterFactory(new PostProcessingAdapterFactory())
				.serializeNulls();

		String build = System.getProperty("build");
		if (build == null || !build.equals("prod")) builder.setPrettyPrinting();

		// gson = builder.create();
		return builder.create();
	}

}