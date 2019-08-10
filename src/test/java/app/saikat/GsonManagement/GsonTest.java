package app.saikat.GsonManagement;

import static org.junit.Assert.assertEquals;

import com.google.gson.Gson;

import org.junit.Test;

import app.saikat.DIManagement.DIManager;

public class GsonTest {

    @Test
    public void gsonInstanceCreate() {
        DIManager.initialize("app.saikat.GsonManagement");

        app.saikat.GsonManagement.Test t = DIManager.get(app.saikat.GsonManagement.Test.class);
        Gson gson = DIManager.get(Gson.class);

        assertEquals("gson created and injected successfully", t.getGson(), gson);
    }
}