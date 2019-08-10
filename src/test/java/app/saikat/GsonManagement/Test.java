package app.saikat.GsonManagement;

import javax.inject.Inject;

import com.google.gson.Gson;

public class Test {

    private Gson gson;

    @Inject
    public Test(Gson gson) {
        this.gson = gson;
    }

    public Gson getGson() {
        return gson;
    }
}