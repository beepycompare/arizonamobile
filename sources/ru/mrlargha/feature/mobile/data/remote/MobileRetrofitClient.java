package ru.mrlargha.feature.mobile.data.remote;

import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mrlargha.feature.mobile.data.remote.rent.api_services.MobileRentApiService;
/* compiled from: MobileRetrofitClient.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lru/mrlargha/feature/mobile/data/remote/MobileRetrofitClient;", "", "<init>", "()V", "okHttpClient", "Lokhttp3/OkHttpClient;", "retrofit", "Lretrofit2/Retrofit;", "rentApiService", "Lru/mrlargha/feature/mobile/data/remote/rent/api_services/MobileRentApiService;", "kotlin.jvm.PlatformType", "getRentApiService", "()Lru/mrlargha/feature/mobile/data/remote/rent/api_services/MobileRentApiService;", "mobile_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobileRetrofitClient {
    public static final MobileRetrofitClient INSTANCE = new MobileRetrofitClient();
    private static final OkHttpClient okHttpClient;
    private static final MobileRentApiService rentApiService;
    private static Retrofit retrofit;

    private MobileRetrofitClient() {
    }

    static {
        OkHttpClient build = new OkHttpClient().newBuilder().addInterceptor(new HttpLoggingInterceptor(null, 1, null).setLevel(HttpLoggingInterceptor.Level.BODY)).build();
        okHttpClient = build;
        Retrofit build2 = new Retrofit.Builder().baseUrl(FirebaseConfigHelper.INSTANCE.getServerApiUrl()).addConverterFactory(GsonConverterFactory.create()).client(build).build();
        Intrinsics.checkNotNullExpressionValue(build2, "build(...)");
        retrofit = build2;
        rentApiService = (MobileRentApiService) build2.create(MobileRentApiService.class);
    }

    public final MobileRentApiService getRentApiService() {
        return rentApiService;
    }
}
