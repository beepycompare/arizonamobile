package ru.mrlargha.commonui.utils.ui;

import com.arizona.game.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import ru.mrlargha.commonui.utils.TokenManagerKt;
/* compiled from: ArizonaRetrofit.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/utils/ui/DefaultQueryInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DefaultQueryInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        return chain.proceed(request.newBuilder().url(request.url().newBuilder().addQueryParameter("project", ru.mrlargha.commonui.utils.UtilsKt.isArizonaType() ? BuildConfig.FLAVOR : "rodina").addQueryParameter("server", String.valueOf(TokenManagerKt.getServerId())).build()).build());
    }
}
