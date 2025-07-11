package ru.mrlargha.commonui.elements.donate.data.remote;

import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mrlargha.commonui.elements.donate.data.remote.apiservices.DonateApiService;
/* compiled from: DonateRetrofitClient.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lru/mrlargha/commonui/elements/donate/data/remote/DonateRetrofitClient;", "", "token", "", "<init>", "(Ljava/lang/String;)V", "client", "Lokhttp3/OkHttpClient;", "retrofit", "Lretrofit2/Retrofit;", "donateApiService", "Lru/mrlargha/commonui/elements/donate/data/remote/apiservices/DonateApiService;", "getDonateApiService", "()Lru/mrlargha/commonui/elements/donate/data/remote/apiservices/DonateApiService;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateRetrofitClient {
    private final OkHttpClient client;
    private final DonateApiService donateApiService;
    private final Retrofit retrofit;

    public DonateRetrofitClient(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        OkHttpClient.Builder addInterceptor = new OkHttpClient.Builder().addInterceptor(new Interceptor() { // from class: ru.mrlargha.commonui.elements.donate.data.remote.DonateRetrofitClient$special$$inlined$-addInterceptor$1
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                Intrinsics.checkNotNullParameter(chain, "chain");
                return chain.proceed(chain.request().newBuilder().addHeader(HttpHeaders.AUTHORIZATION, "Bearer aaf5231dd5925db9888b61b856494f90").build());
            }
        });
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        Unit unit = Unit.INSTANCE;
        OkHttpClient build = addInterceptor.addInterceptor(httpLoggingInterceptor).build();
        this.client = build;
        Retrofit build2 = new Retrofit.Builder().baseUrl("https://server-api.arizona.games/").addConverterFactory(GsonConverterFactory.create()).client(build).build();
        Intrinsics.checkNotNullExpressionValue(build2, "build(...)");
        this.retrofit = build2;
        Object create = build2.create(DonateApiService.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        this.donateApiService = (DonateApiService) create;
    }

    public final DonateApiService getDonateApiService() {
        return this.donateApiService;
    }
}
