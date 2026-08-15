package ru.mrlargha.commonui.utils.ui;

import android.app.Activity;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.net.HttpHeaders;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mrlargha.commonui.utils.TokenManagerKt;
/* compiled from: ArizonaRetrofit.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\tJE\u0010\u0013\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "", "targetActivity", "Landroid/content/Context;", "backendID", "", "<init>", "(Landroid/content/Context;I)V", "Landroid/app/Activity;", "(Landroid/app/Activity;I)V", "onError", "Lkotlin/Function0;", "", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "create", ExifInterface.GPS_DIRECTION_TRUE, NotificationCompat.CATEGORY_SERVICE, "Ljava/lang/Class;", "useDebug", "", "baseUrl", "", "(Ljava/lang/Class;ZLjava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "normalizeBaseUrl", "raw", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaRetrofit {
    @Deprecated
    public static final long CALL_TIMEOUT_SECONDS = 80;
    @Deprecated
    public static final long CONNECT_TIMEOUT_SECONDS = 10;
    @Deprecated
    public static final int MAX_REQUESTS_PER_HOST = 32;
    @Deprecated
    public static final long READ_TIMEOUT_SECONDS = 30;
    @Deprecated
    public static final long WRITE_TIMEOUT_SECONDS = 15;
    private final CoroutineExceptionHandler handler;
    private Function0<Unit> onError;
    private final CoroutineScope scope;
    private static final Companion Companion = new Companion(null);
    private static final Lazy<OkHttpClient> httpClient$delegate = LazyKt.lazy(new Function0() { // from class: ru.mrlargha.commonui.utils.ui.ArizonaRetrofit$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ArizonaRetrofit.httpClient_delegate$lambda$0();
        }
    });

    public ArizonaRetrofit(Context targetActivity, int i) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.onError = new Function0() { // from class: ru.mrlargha.commonui.utils.ui.ArizonaRetrofit$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        };
        ArizonaRetrofit$special$$inlined$CoroutineExceptionHandler$1 arizonaRetrofit$special$$inlined$CoroutineExceptionHandler$1 = new ArizonaRetrofit$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, targetActivity, i, this);
        this.handler = arizonaRetrofit$special$$inlined$CoroutineExceptionHandler$1;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob((Job) null)).plus(arizonaRetrofit$special$$inlined$CoroutineExceptionHandler$1));
    }

    /* compiled from: ArizonaRetrofit.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit$Companion;", "", "<init>", "()V", "CONNECT_TIMEOUT_SECONDS", "", "READ_TIMEOUT_SECONDS", "WRITE_TIMEOUT_SECONDS", "CALL_TIMEOUT_SECONDS", "MAX_REQUESTS_PER_HOST", "", "httpClient", "Lokhttp3/OkHttpClient;", "getHttpClient", "()Lokhttp3/OkHttpClient;", "httpClient$delegate", "Lkotlin/Lazy;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OkHttpClient getHttpClient() {
            return (OkHttpClient) ArizonaRetrofit.httpClient$delegate.getValue();
        }
    }

    public static final OkHttpClient httpClient_delegate$lambda$0() {
        HttpLoggingInterceptor.Level level;
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
        httpLoggingInterceptor.redactHeader(HttpHeaders.AUTHORIZATION);
        if (ru.mrlargha.commonui.utils.UtilsKt.isDebug()) {
            level = HttpLoggingInterceptor.Level.BODY;
        } else {
            level = HttpLoggingInterceptor.Level.HEADERS;
        }
        httpLoggingInterceptor.level(level);
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(32);
        return new OkHttpClient.Builder().dispatcher(dispatcher).connectTimeout(10L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(15L, TimeUnit.SECONDS).callTimeout(80L, TimeUnit.SECONDS).addInterceptor(new Interceptor() { // from class: ru.mrlargha.commonui.utils.ui.ArizonaRetrofit$httpClient_delegate$lambda$0$$inlined$-addInterceptor$1
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                Intrinsics.checkNotNullParameter(chain, "chain");
                return chain.proceed(chain.request().newBuilder().addHeader(HttpHeaders.AUTHORIZATION, TokenManagerKt.getToken()).addHeader(HttpHeaders.USER_AGENT, "Arizona Mobile: " + ru.mrlargha.commonui.utils.UtilsKt.isArizonaType()).build());
            }
        }).addInterceptor(httpLoggingInterceptor).addInterceptor(new DefaultQueryInterceptor()).build();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArizonaRetrofit(Activity targetActivity, int i) {
        this(r2, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Context applicationContext = targetActivity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object create$default(ArizonaRetrofit arizonaRetrofit, Class cls, boolean z, String str, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            function0 = new Function0() { // from class: ru.mrlargha.commonui.utils.ui.ArizonaRetrofit$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        return arizonaRetrofit.create(cls, z, str, function0);
    }

    public final <T> T create(Class<T> service, boolean z, String str, Function0<Unit> onError) {
        String normalizeBaseUrl;
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.onError = onError;
        if (ru.mrlargha.commonui.utils.UtilsKt.isDebug() && z && TokenManagerKt.getServerId() == 0) {
            normalizeBaseUrl = "https://dev-api.arizona.games/";
        } else {
            normalizeBaseUrl = normalizeBaseUrl(FirebaseConfigHelper.INSTANCE.getServerApiUrl());
            if (normalizeBaseUrl == null) {
                normalizeBaseUrl = "https://server-api.arizona.games/";
            }
        }
        Retrofit.Builder builder = new Retrofit.Builder();
        if (str == null) {
            str = normalizeBaseUrl;
        }
        return (T) builder.baseUrl(str).client(Companion.getHttpClient()).addConverterFactory(GsonConverterFactory.create()).build().create(service);
    }

    private final String normalizeBaseUrl(String str) {
        String obj = StringsKt.trim((CharSequence) str).toString();
        if ((StringsKt.startsWith$default(obj, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(obj, "https://", false, 2, (Object) null)) && StringsKt.endsWith$default(obj, "/", false, 2, (Object) null)) {
            return obj;
        }
        return null;
    }
}
