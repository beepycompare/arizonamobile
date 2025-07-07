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
/* compiled from: NetworkApiModule.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0007H\u0007J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u00072\b\b\u0001\u0010\r\u001a\u00020\u0005H\u0007¨\u0006\u000e"}, d2 = {"Lcom/miami/game/core/api/network/di/NetworkApiModule;", "", "<init>", "()V", "provideGson", "Lcom/google/gson/Gson;", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "provideAppNetworkDataSource", "Lcom/miami/game/core/api/network/NetworkDataSource;", "connectionResolver", "Lcom/miami/game/core/connection/resolver/api/ConnectionResolver;", "okHttpClient", "gson", "api-network_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class NetworkApiModule {
    public static final NetworkApiModule INSTANCE = new NetworkApiModule();

    /* JADX INFO: Access modifiers changed from: private */
    public static final OkHttpClient provideAppNetworkDataSource$lambda$0(OkHttpClient okHttpClient) {
        return okHttpClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
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
        return new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).protocols(CollectionsKt.listOf(Protocol.HTTP_1_1)).build();
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
                OkHttpClient provideAppNetworkDataSource$lambda$0;
                provideAppNetworkDataSource$lambda$0 = NetworkApiModule.provideAppNetworkDataSource$lambda$0(OkHttpClient.this);
                return provideAppNetworkDataSource$lambda$0;
            }
        }, new Function0() { // from class: com.miami.game.core.api.network.di.NetworkApiModule$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                HttpUrl provideAppNetworkDataSource$lambda$1;
                provideAppNetworkDataSource$lambda$1 = NetworkApiModule.provideAppNetworkDataSource$lambda$1(r1);
                return provideAppNetworkDataSource$lambda$1;
            }
        }, new Function0() { // from class: com.miami.game.core.api.network.di.NetworkApiModule$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Gson provideAppNetworkDataSource$lambda$2;
                provideAppNetworkDataSource$lambda$2 = NetworkApiModule.provideAppNetworkDataSource$lambda$2(Gson.this);
                return provideAppNetworkDataSource$lambda$2;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HttpUrl provideAppNetworkDataSource$lambda$1(String str) {
        return HttpUrl.Companion.get(str);
    }
}
