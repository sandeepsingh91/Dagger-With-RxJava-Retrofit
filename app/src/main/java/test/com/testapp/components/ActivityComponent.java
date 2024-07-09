package test.com.testapp.components;

import dagger.Component;
import test.com.testapp.MainActivity;
import test.com.testapp.module.ActivityModule;
import test.com.testapp.module.NetworkModule;
import test.com.testapp.scope.PerActivity;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, NetworkModule.class})
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    void inject(NetworkModule networkModule);

}