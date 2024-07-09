package test.com.testapp.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * In the constructor, we have passed the Application instance. This instance is used to provide other dependencies.
 * This class provides all the dependencies that we listed in the above step.
 */
@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application app) {
        mApplication = app;
    }

    @Provides
    @Named("application_context")
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Named("string")
    String provideDatabaseName() {
        return "demo-dagger.db";
    }

    @Provides
    @Named("integer")
    Integer provideDatabaseVersion() {
        return 2;
    }

    @Provides
    SharedPreferences provideSharedPrefs() {
        return mApplication.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }
}