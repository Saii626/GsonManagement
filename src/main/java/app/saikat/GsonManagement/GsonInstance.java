package app.saikat.GsonManagement;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import app.saikat.Annotations.DIManagement.Provides;
import app.saikat.Annotations.GsonManagement.NoPretty;
import app.saikat.Annotations.GsonManagement.Pretty;

public class GsonInstance {

	// private static Gson gson;

	@Provides
	public static Gson getGson(@Pretty Gson pretty, @NoPretty Gson noPretty) {
		String build = System.getProperty("build");
		if (build == null || !build.equals("prod")) {
			return pretty;
		} else {
			return noPretty;
		}
	}

	@Pretty
	@Provides
	public static Gson prettyGson() {
		return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
				.setExclusionStrategies(new AnnotedExclusionStrategy())
				.registerTypeAdapter(Class.class, new JsonClassAdapter())
				.registerTypeAdapterFactory(new PostProcessingAdapterFactory())
				.setPrettyPrinting()
				.serializeNulls()
				.create();
	}

	@NoPretty
	@Provides
	public static Gson noPrettyGson() {
		return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
				.setExclusionStrategies(new AnnotedExclusionStrategy())
				.registerTypeAdapter(Class.class, new JsonClassAdapter())
				.registerTypeAdapterFactory(new PostProcessingAdapterFactory())
				.serializeNulls()
				.create();
	}

}