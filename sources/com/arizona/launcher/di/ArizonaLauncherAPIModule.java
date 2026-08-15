package com.arizona.launcher.di;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.game.BuildConfig;
import com.arizona.launcher.data.repository.notifications.NotificationsAPI;
import com.arizona.launcher.util.FlavorUtilKt;
import com.google.common.net.HttpHeaders;
import com.miami.game.core.firebase.notification.NotificationStatsPayloadFactory;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: ArizonaLauncherAPIModule.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\t\u001a\u00020\nH\u0007b\u0002\b\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\u0002\b\rÊ\u0001\u0010\b\u000e\u0012\f\b\u000f\u0012\b\b\fJ\u0004\b\t0\u0010Ê\u0001\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\u0003\u0010\u0000¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/di/ArizonaLauncherAPIModule;", "", "<init>", "()V", "okHttpClient", "Lokhttp3/OkHttpClient;", "retrofit", "Lretrofit2/Retrofit;", "kotlin.jvm.PlatformType", "provideNotificationsApi", "Lcom/arizona/launcher/data/repository/notifications/NotificationsAPI;", "Ldagger/Provides;", "app", "Ldagger/Module;", "Ldagger/hilt/InstallIn;", "value", "Ldagger/hilt/components/SingletonComponent;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Module
/* loaded from: classes3.dex */
public final class ArizonaLauncherAPIModule {
    public static final int $stable = 8;
    private final OkHttpClient okHttpClient;
    private final Retrofit retrofit;

    public ArizonaLauncherAPIModule() {
        OkHttpClient build = new OkHttpClient().newBuilder().connectTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).readTimeout(60L, TimeUnit.SECONDS).protocols(CollectionsKt.listOf(Protocol.HTTP_1_1)).cache(null).addInterceptor(new Interceptor() { // from class: com.arizona.launcher.di.ArizonaLauncherAPIModule$special$$inlined$-addInterceptor$1
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                Intrinsics.checkNotNullParameter(chain, "chain");
                Request build2 = chain.request().newBuilder().addHeader(HttpHeaders.USER_AGENT, "Arizona Mobile: " + UtilsKt.isArizonaType()).build();
                return chain.proceed(build2.newBuilder().url(build2.url().newBuilder().addQueryParameter("project", (String) FlavorUtilKt.rodinaOrArizona(new Function0<String>() { // from class: com.arizona.launcher.di.ArizonaLauncherAPIModule$okHttpClient$1$url$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "rodina";
                    }
                }, new Function0<String>() { // from class: com.arizona.launcher.di.ArizonaLauncherAPIModule$okHttpClient$1$url$2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return BuildConfig.FLAVOR;
                    }
                })).addQueryParameter(NotificationStatsPayloadFactory.KEY_PLATFORM, TtmlNode.COMBINE_ALL).build()).build());
            }
        }).build();
        this.okHttpClient = build;
        this.retrofit = new Retrofit.Builder().baseUrl("https://api.arizona-five.com/").client(build).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
    }

    @Provides
    public final NotificationsAPI provideNotificationsApi() {
        Object create = this.retrofit.create(NotificationsAPI.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return (NotificationsAPI) create;
    }
}
