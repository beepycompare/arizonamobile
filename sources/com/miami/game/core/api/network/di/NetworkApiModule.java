package com.miami.game.core.api.network.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.miami.game.core.api.network.NetworkDataSource;
import com.miami.game.core.api.network.NetworkDataSourceImpl;
import com.miami.game.core.connection.resolver.api.ConnectionResolver;
import com.miami.game.core.network.error_handler.CoroutineErrorHandlerRetrofitFactory;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.logging.HttpLoggingInterceptor;
/* compiled from: NetworkApiModule.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u0005H\u0007b\u0002\b\u0006b\u0002\b\u0007b\u0002\b\bJ\u0014\u0010\t\u001a\u00020\nH\u0007b\u0002\b\u0007b\u0002\b\u0006b\u0002\b\bJ4\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\b\u0001\u0010\u000f\u001a\u00020\n:\u0002\b\b2\f\b\u0001\u0010\u0010\u001a\u00020\u0005:\u0002\b\bH\u0007b\u0002\b\u0006b\u0002\b\u0007Ê\u0001\u0002\b\u0012Ê\u0001\u0010\b\u0013\u0012\f\b\u0014\u0012\b\b\fJ\u0004\b\t0\u0015¨\u0006\u0011"}, d2 = {"Lcom/miami/game/core/api/network/di/NetworkApiModule;", "", "<init>", "()V", "provideGson", "Lcom/google/gson/Gson;", "Ljavax/inject/Singleton;", "Ldagger/Provides;", "Lcom/miami/game/core/api/network/di/NetworkApiClient;", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "provideAppNetworkDataSource", "Lcom/miami/game/core/api/network/NetworkDataSource;", "connectionResolver", "Lcom/miami/game/core/connection/resolver/api/ConnectionResolver;", "okHttpClient", "gson", "api-network", "Ldagger/Module;", "Ldagger/hilt/InstallIn;", "value", "Ldagger/hilt/components/SingletonComponent;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Module
/* loaded from: classes5.dex */
public final class NetworkApiModule {
    public static final NetworkApiModule INSTANCE = new NetworkApiModule();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final OkHttpClient provideAppNetworkDataSource$lambda$0(OkHttpClient okHttpClient) {
        return okHttpClient;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Gson provideAppNetworkDataSource$lambda$2(Gson gson) {
        return gson;
    }

    private NetworkApiModule() {
    }

    @Provides
    @Singleton
    public final Gson provideGson() {
        Gson create = new GsonBuilder().setLenient().create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return create;
    }

    @Provides
    @Singleton
    public final OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.HEADERS);
        return new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).connectTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).readTimeout(60L, TimeUnit.SECONDS).protocols(CollectionsKt.listOf(Protocol.HTTP_1_1)).build();
    }

    @Provides
    @Singleton
    public final NetworkDataSource provideAppNetworkDataSource(ConnectionResolver connectionResolver, final OkHttpClient okHttpClient, final Gson gson) {
        Intrinsics.checkNotNullParameter(connectionResolver, "connectionResolver");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        Intrinsics.checkNotNullParameter(gson, "gson");
        return new NetworkDataSourceImpl(connectionResolver, new CoroutineErrorHandlerRetrofitFactory(new Function0() { // from class: com.miami.game.core.api.network.di.NetworkApiModule$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NetworkApiModule.provideAppNetworkDataSource$lambda$0(OkHttpClient.this);
            }
        }, new Function0() { // from class: com.miami.game.core.api.network.di.NetworkApiModule$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                HttpUrl httpUrl;
                httpUrl = HttpUrl.Companion.get(r1);
                return httpUrl;
            }
        }, new Function0() { // from class: com.miami.game.core.api.network.di.NetworkApiModule$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NetworkApiModule.provideAppNetworkDataSource$lambda$2(Gson.this);
            }
        }));
    }
}
