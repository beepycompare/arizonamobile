package ru.mrlargha.feature.arizona.cases.data.remote;

import com.google.common.net.HttpHeaders;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mrlargha.feature.arizona.cases.data.remote.apiservices.CasesApiService;
/* compiled from: CasesRetrofitClient.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lru/mrlargha/feature/arizona/cases/data/remote/CasesRetrofitClient;", "", "token", "", "<init>", "(Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "client", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "retrofit", "Lretrofit2/Retrofit;", "casesApiService", "Lru/mrlargha/feature/arizona/cases/data/remote/apiservices/CasesApiService;", "kotlin.jvm.PlatformType", "getCasesApiService", "()Lru/mrlargha/feature/arizona/cases/data/remote/apiservices/CasesApiService;", "cases_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CasesRetrofitClient {
    private final CasesApiService casesApiService;
    private final OkHttpClient client;
    private final Retrofit retrofit;
    private final String token;

    public CasesRetrofitClient(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        this.token = token;
        OkHttpClient.Builder addInterceptor = new OkHttpClient.Builder().addInterceptor(new Interceptor() { // from class: ru.mrlargha.feature.arizona.cases.data.remote.CasesRetrofitClient$special$$inlined$-addInterceptor$1
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                Intrinsics.checkNotNullParameter(chain, "chain");
                return chain.proceed(chain.request().newBuilder().addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + CasesRetrofitClient.this.getToken()).build());
            }
        });
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        Unit unit = Unit.INSTANCE;
        OkHttpClient build = addInterceptor.addInterceptor(httpLoggingInterceptor).build();
        this.client = build;
        Retrofit build2 = new Retrofit.Builder().baseUrl(FirebaseConfigHelper.INSTANCE.getServerApiUrl()).addConverterFactory(GsonConverterFactory.create()).client(build).build();
        Intrinsics.checkNotNullExpressionValue(build2, "build(...)");
        this.retrofit = build2;
        this.casesApiService = (CasesApiService) build2.create(CasesApiService.class);
    }

    public final String getToken() {
        return this.token;
    }

    public final OkHttpClient getClient() {
        return this.client;
    }

    public final CasesApiService getCasesApiService() {
        return this.casesApiService;
    }
}
