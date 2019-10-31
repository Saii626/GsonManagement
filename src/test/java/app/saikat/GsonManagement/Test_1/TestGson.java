package app.saikat.GsonManagement.Test_1;

import javax.inject.Inject;

import com.google.gson.Gson;

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