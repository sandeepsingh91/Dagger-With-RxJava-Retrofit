package test.com.testapp.module;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;
import test.com.testapp.PostApi;

@Module
public class NetworkModule {

    @Provides
    public PostApi providePostAPI(Retrofit retrofit) {

        return retrofit.create(PostApi.class);
    }

    @Provides
    public Retrofit provideRetrofitInterface() {
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
    }
}
