package com.miami.game.core.network.extensions;

import android.content.Context;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;
/* compiled from: OkHttpClientExtensions.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a,\u0010\b\u001a\u00020\u0005*\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u001a\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"CACHE_SIZE_BYTES", "", "CACHE_DIR_DEFAULT", "", "withLoggingInterceptor", "Lokhttp3/OkHttpClient$Builder;", "isLogEnabled", "", "initHttpCache", "isNeedSupportEtag", "context", "Landroid/content/Context;", "cacheDirectoryChild", "buildHttpCache", "Lokhttp3/Cache;", "network_release_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OkHttpClientExtensionsKt {
    private static final String CACHE_DIR_DEFAULT = "http-cache";
    private static final long CACHE_SIZE_BYTES = 10485760;

    public static final OkHttpClient.Builder withLoggingInterceptor(OkHttpClient.Builder builder, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        if (z) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
            httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(httpLoggingInterceptor);
        }
        return builder;
    }

    public static /* synthetic */ OkHttpClient.Builder initHttpCache$default(OkHttpClient.Builder builder, boolean z, Context context, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            context = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        return initHttpCache(builder, z, context, str);
    }

    public static final OkHttpClient.Builder initHttpCache(OkHttpClient.Builder builder, boolean z, Context context, String str) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        if (z && context != null) {
            if (str == null) {
                str = CACHE_DIR_DEFAULT;
            }
            builder.cache(buildHttpCache(context, str));
        }
        return builder;
    }

    private static final Cache buildHttpCache(Context context, String str) {
        try {
            return new Cache(new File(context.getCacheDir(), str), CACHE_SIZE_BYTES);
        } catch (Exception e) {
            Timber.Forest.e(e);
            return null;
        }
    }
}
