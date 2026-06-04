package ru.mrlargha.commonui.utils;

import android.content.Context;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import ru.mrlargha.commonui.utils.Picasso;
/* compiled from: Picasso.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lru/mrlargha/commonui/utils/Picasso;", "", "<init>", "()V", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Picasso {
    public static final Companion Companion = new Companion(null);

    /* compiled from: Picasso.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/utils/Picasso$Companion;", "", "<init>", "()V", "initPicasso", "", "context", "Landroid/content/Context;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void initPicasso(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            com.squareup.picasso.Picasso.setSingletonInstance(new Picasso.Builder(context).downloader(new OkHttp3Downloader(new OkHttpClient.Builder().addInterceptor(new Interceptor() { // from class: ru.mrlargha.commonui.utils.Picasso$Companion$$ExternalSyntheticLambda0
                @Override // okhttp3.Interceptor
                public final Response intercept(Interceptor.Chain chain) {
                    return Picasso.Companion.initPicasso$lambda$0(chain);
                }
            }).build())).build());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final Response initPicasso$lambda$0(Interceptor.Chain chain) {
            Intrinsics.checkNotNullParameter(chain, "chain");
            return chain.proceed(chain.request().newBuilder().addHeader("User-Agent", "Arizona Mobile: " + UtilsKt.isArizonaType()).build());
        }
    }
}
