package test.com.testapp.components;

import android.app.Application;
import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import test.com.testapp.DemoApplication;
import test.com.testapp.SharedPrefsHelper;
import test.com.testapp.db.DataManager;
import test.com.testapp.db.DbHelper;
import test.com.testapp.module.ApplicationModule;

/**
 * Here we have written a method inject where we pass the DemoApplication instance.
 * Why do we do it?
 * <p>
 * When the dependencies are provided through field injection i.e. @inject
 * on the member variables, we have to tell the Dagger to scan this class
 * through the implementation of this interface.
 * <p>
 * This class also provides methods that are used to access the dependencies that
 * exist in the dependency graph.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(DemoApplication demoApplication);

    @Named("application_context")
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();

}
