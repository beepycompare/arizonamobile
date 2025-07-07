package coil3.network.okhttp;

import coil3.PlatformContext;
import coil3.network.CacheStrategy;
import coil3.network.ConnectivityChecker;
import coil3.network.NetworkClient;
import coil3.network.NetworkFetcher;
import coil3.network.okhttp.internal.CallFactoryNetworkClient;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import okhttp3.Call;
import okhttp3.OkHttpClient;
/* compiled from: OkHttpNetworkFetcher.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\b\u0002\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005H\u0007¢\u0006\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u00012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005H\u0007¢\u0006\u0002\b\u0002\u001aC\u0010\u0000\u001a\u00020\u00012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00052\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0007¢\u0006\u0002\b\u0002\u001a\n\u0010\f\u001a\u00020\r*\u00020\u0004¨\u0006\u000e"}, d2 = {"OkHttpNetworkFetcherFactory", "Lcoil3/network/NetworkFetcher$Factory;", "factory", "callFactory", "Lokhttp3/Call$Factory;", "Lkotlin/Function0;", "cacheStrategy", "Lcoil3/network/CacheStrategy;", "connectivityChecker", "Lkotlin/Function1;", "Lcoil3/PlatformContext;", "Lcoil3/network/ConnectivityChecker;", "asNetworkClient", "Lcoil3/network/NetworkClient;", "coil-network-okhttp"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OkHttpNetworkFetcher {
    public static final NetworkFetcher.Factory factory() {
        return new NetworkFetcher.Factory(new Function0() { // from class: coil3.network.okhttp.OkHttpNetworkFetcher$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                NetworkClient OkHttpNetworkFetcherFactory$lambda$0;
                OkHttpNetworkFetcherFactory$lambda$0 = OkHttpNetworkFetcher.OkHttpNetworkFetcherFactory$lambda$0();
                return OkHttpNetworkFetcherFactory$lambda$0;
            }
        }, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NetworkClient OkHttpNetworkFetcherFactory$lambda$0() {
        return asNetworkClient(new OkHttpClient());
    }

    public static final NetworkFetcher.Factory factory(final Call.Factory factory) {
        return new NetworkFetcher.Factory(new Function0() { // from class: coil3.network.okhttp.OkHttpNetworkFetcher$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                NetworkClient asNetworkClient;
                asNetworkClient = OkHttpNetworkFetcher.asNetworkClient(Call.Factory.this);
                return asNetworkClient;
            }
        }, null, null, 6, null);
    }

    public static final NetworkFetcher.Factory factory(final Function0<? extends Call.Factory> function0) {
        return new NetworkFetcher.Factory(new Function0() { // from class: coil3.network.okhttp.OkHttpNetworkFetcher$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                NetworkClient OkHttpNetworkFetcherFactory$lambda$2;
                OkHttpNetworkFetcherFactory$lambda$2 = OkHttpNetworkFetcher.OkHttpNetworkFetcherFactory$lambda$2(Function0.this);
                return OkHttpNetworkFetcherFactory$lambda$2;
            }
        }, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NetworkClient OkHttpNetworkFetcherFactory$lambda$2(Function0 function0) {
        return asNetworkClient((Call.Factory) function0.invoke());
    }

    public static /* synthetic */ NetworkFetcher.Factory factory$default(Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$4.INSTANCE;
        }
        if ((i & 2) != 0) {
            function02 = new Function0() { // from class: coil3.network.okhttp.OkHttpNetworkFetcher$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    CacheStrategy cacheStrategy;
                    cacheStrategy = CacheStrategy.DEFAULT;
                    return cacheStrategy;
                }
            };
        }
        return factory(function0, function02);
    }

    public static final NetworkFetcher.Factory factory(final Function0<? extends Call.Factory> function0, Function0<? extends CacheStrategy> function02) {
        return new NetworkFetcher.Factory(new Function0() { // from class: coil3.network.okhttp.OkHttpNetworkFetcher$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                NetworkClient OkHttpNetworkFetcherFactory$lambda$4;
                OkHttpNetworkFetcherFactory$lambda$4 = OkHttpNetworkFetcher.OkHttpNetworkFetcherFactory$lambda$4(Function0.this);
                return OkHttpNetworkFetcherFactory$lambda$4;
            }
        }, function02, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NetworkClient OkHttpNetworkFetcherFactory$lambda$4(Function0 function0) {
        return asNetworkClient((Call.Factory) function0.invoke());
    }

    public static /* synthetic */ NetworkFetcher.Factory factory$default(Function0 function0, Function0 function02, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$7.INSTANCE;
        }
        if ((i & 2) != 0) {
            function02 = new Function0() { // from class: coil3.network.okhttp.OkHttpNetworkFetcher$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    CacheStrategy cacheStrategy;
                    cacheStrategy = CacheStrategy.DEFAULT;
                    return cacheStrategy;
                }
            };
        }
        if ((i & 4) != 0) {
            function1 = OkHttpNetworkFetcher$OkHttpNetworkFetcherFactory$9.INSTANCE;
        }
        return factory(function0, function02, function1);
    }

    public static final NetworkFetcher.Factory factory(final Function0<? extends Call.Factory> function0, Function0<? extends CacheStrategy> function02, Function1<? super PlatformContext, ? extends ConnectivityChecker> function1) {
        return new NetworkFetcher.Factory(new Function0() { // from class: coil3.network.okhttp.OkHttpNetworkFetcher$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                NetworkClient OkHttpNetworkFetcherFactory$lambda$6;
                OkHttpNetworkFetcherFactory$lambda$6 = OkHttpNetworkFetcher.OkHttpNetworkFetcherFactory$lambda$6(Function0.this);
                return OkHttpNetworkFetcherFactory$lambda$6;
            }
        }, function02, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NetworkClient OkHttpNetworkFetcherFactory$lambda$6(Function0 function0) {
        return asNetworkClient((Call.Factory) function0.invoke());
    }

    public static final NetworkClient asNetworkClient(Call.Factory factory) {
        return CallFactoryNetworkClient.m7796boximpl(CallFactoryNetworkClient.m7797constructorimpl(factory));
    }
}
