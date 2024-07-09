package test.com.testapp;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import test.com.testapp.components.ApplicationComponent;
import test.com.testapp.components.DaggerApplicationComponent;
import test.com.testapp.db.DataManager;
import test.com.testapp.module.ApplicationModule;

public class DemoApplication extends Application {

    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;

    public static DemoApplication get(Context context) {
        return (DemoApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}
