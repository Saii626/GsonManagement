package app.saikat.GsonManagement.Test_1;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.gson.Gson;

@Singleton
public class TestGson {

	private Gson gson;

	@Inject
	public TestGson(Gson gson) {
		this.gson = gson;
	}

	public Gson getGson() {
		return gson;
	}

 }