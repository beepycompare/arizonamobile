package com.arizona.launcher.updater.archive.download;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/* compiled from: ArchiveNetworkSecurity.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016Ê\u0001\f\b\t\u0012\b\b\n\u0012\u0004\b\u0003\u0010\u0002¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadGuardTaggingInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveDownloadGuardTaggingInterceptor implements Interceptor {
    public static final int $stable = 0;

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        if (!Intrinsics.areEqual(request.header(ArchiveNetworkSecurityKt.ARCHIVE_DOWNLOAD_GUARD_HEADER), "1")) {
            return chain.proceed(request);
        }
        return chain.proceed(request.newBuilder().removeHeader(ArchiveNetworkSecurityKt.ARCHIVE_DOWNLOAD_GUARD_HEADER).tag((Class<? super Class>) ArchiveDownloadRedirectGuardState.class, (Class) new ArchiveDownloadRedirectGuardState(0, 1, null)).build());
    }
}
