package com.arizona.launcher.di;

import com.arizona.launcher.data.repository.SecondaryUpdateApi;
import com.arizona.launcher.data.repository.UpdateApi;
import com.arizona.launcher.util.FlavorUtilKt;
import com.google.common.net.HttpHeaders;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.ui.DefaultQueryInterceptor;
/* compiled from: UpdateApiModule.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\f\u0010\b\u001a\u00020\tH\u0007b\u0002\b\nJ\f\u0010\u000b\u001a\u00020\fH\u0007b\u0002\b\nÊ\u0001\u0002\b\u000fÊ\u0001\u0010\b\u0010\u0012\f\b\u0011\u0012\b\b\fJ\u0004\b\t0\u0012Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u000e"}, d2 = {"Lcom/arizona/launcher/di/UpdateApiModule;", "", "<init>", "()V", "getRetrofit", "Lretrofit2/Retrofit;", "url", "", "provideApi", "Lcom/arizona/launcher/data/repository/UpdateApi;", "Ldagger/Provides;", "provideSecondaryApi", "Lcom/arizona/launcher/data/repository/SecondaryUpdateApi;", "Companion", "app", "Ldagger/Module;", "Ldagger/hilt/InstallIn;", "value", "Ldagger/hilt/components/SingletonComponent;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Module
/* loaded from: classes3.dex */
public final class UpdateApiModule {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final String SERVER_MAIN_URl_ARIZONA = "https://mob.maz-ins.com/game/release/";
    private static final String SERVER_MAIN_URl_RODINA = "https://mob.maz-ins.com/game/release/";
    private static final String SERVER_SECONDARY_URL_ARIZONA = "https://arz-mob.react-group.tech/game/release/";
    private static final String SERVER_SECONDARY_URL_RODINA = "https://arz-mob.react-group.tech/game/release/";

    private final Retrofit getRetrofit(String str) {
        Retrofit build = new Retrofit.Builder().baseUrl(str).client(new OkHttpClient.Builder().addInterceptor(new Interceptor() { // from class: com.arizona.launcher.di.UpdateApiModule$getRetrofit$$inlined$-addInterceptor$1
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                Intrinsics.checkNotNullParameter(chain, "chain");
                return chain.proceed(chain.request().newBuilder().addHeader(HttpHeaders.USER_AGENT, "Arizona Mobile: " + UtilsKt.isArizonaType()).build());
            }
        }).addInterceptor(new DefaultQueryInterceptor()).build()).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    @Provides
    public final UpdateApi provideApi() {
        if (FlavorUtilKt.isArizona()) {
            Object create = getRetrofit("https://mob.maz-ins.com/game/release/").create(UpdateApi.class);
            Intrinsics.checkNotNullExpressionValue(create, "create(...)");
            return (UpdateApi) create;
        }
        Object create2 = getRetrofit("https://mob.maz-ins.com/game/release/").create(UpdateApi.class);
        Intrinsics.checkNotNullExpressionValue(create2, "create(...)");
        return (UpdateApi) create2;
    }

    @Provides
    public final SecondaryUpdateApi provideSecondaryApi() {
        if (FlavorUtilKt.isArizona()) {
            Object create = getRetrofit("https://arz-mob.react-group.tech/game/release/").create(SecondaryUpdateApi.class);
            Intrinsics.checkNotNullExpressionValue(create, "create(...)");
            return (SecondaryUpdateApi) create;
        }
        Object create2 = getRetrofit("https://arz-mob.react-group.tech/game/release/").create(SecondaryUpdateApi.class);
        Intrinsics.checkNotNullExpressionValue(create2, "create(...)");
        return (SecondaryUpdateApi) create2;
    }

    /* compiled from: UpdateApiModule.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/arizona/launcher/di/UpdateApiModule$Companion;", "", "<init>", "()V", "SERVER_MAIN_URl_ARIZONA", "", "SERVER_SECONDARY_URL_ARIZONA", "SERVER_MAIN_URl_RODINA", "SERVER_SECONDARY_URL_RODINA", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
