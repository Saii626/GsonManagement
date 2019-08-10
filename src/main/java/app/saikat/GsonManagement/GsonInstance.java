package app.saikat.GsonManagement;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import app.saikat.DIManagement.Provides;

class GsonInstance {

    @Provides
    public Gson getGson() {
        return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .setExclusionStrategies(new AnnotedExclusionStrategy())
                .registerTypeAdapterFactory(new PostProcessingAdapterFactory())
                .setPrettyPrinting().serializeNulls()
                .create();
    }
}