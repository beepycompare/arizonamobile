package ru.mrlargha.arizonaui.mobile.presentation.page.messenger.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/* compiled from: MessengerRetrofitClient.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/api/MessengerRetrofitClient;", "", "<init>", "()V", "retrofit", "Lretrofit2/Retrofit;", "api", "Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/api/MessagesApi;", "kotlin.jvm.PlatformType", "getApi", "()Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/api/MessagesApi;", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MessengerRetrofitClient {
    public static final MessengerRetrofitClient INSTANCE = new MessengerRetrofitClient();
    private static final MessagesApi api;
    private static Retrofit retrofit;

    private MessengerRetrofitClient() {
    }

    static {
        Retrofit.Builder addConverterFactory = new Retrofit.Builder().baseUrl("http://messenger.arizona-five.com/messenger/").addConverterFactory(GsonConverterFactory.create());
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(httpLoggingInterceptor);
        Retrofit build = addConverterFactory.client(builder.build()).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        retrofit = build;
        api = (MessagesApi) build.create(MessagesApi.class);
    }

    public final MessagesApi getApi() {
        return api;
    }
}
