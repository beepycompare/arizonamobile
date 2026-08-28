package com.arizona.launcher.updater.archive.orchestrator;

import com.adjust.sdk.Constants;
import java.net.URI;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ArchiveBootstrapPrefetcher.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageUrlResolver;", "", "<init>", "()V", "resolve", "", "baseUrl", "packageUrl", "allowInsecureLoopback", "", "LOOPBACK_HOSTS", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchivePackageUrlResolver {
    public static final int $stable = 0;
    public static final ArchivePackageUrlResolver INSTANCE = new ArchivePackageUrlResolver();
    private static final Set<String> LOOPBACK_HOSTS = SetsKt.setOf((Object[]) new String[]{"127.0.0.1", "localhost", "::1"});

    private ArchivePackageUrlResolver() {
    }

    public final String resolve(String baseUrl, String packageUrl, boolean z) {
        Object m9920constructorimpl;
        String str;
        String host;
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(packageUrl, "packageUrl");
        boolean z2 = false;
        try {
            Result.Companion companion = Result.Companion;
            ArchivePackageUrlResolver archivePackageUrlResolver = this;
            URI uri = new URI(packageUrl);
            if (!StringsKt.endsWith$default((CharSequence) baseUrl, '/', false, 2, (Object) null)) {
                baseUrl = baseUrl + "/";
            }
            if (!uri.isAbsolute()) {
                uri = new URI(baseUrl).resolve(uri);
            }
            m9920constructorimpl = Result.m9920constructorimpl(uri);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9920constructorimpl = Result.m9920constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9926isFailureimpl(m9920constructorimpl)) {
            m9920constructorimpl = null;
        }
        URI uri2 = (URI) m9920constructorimpl;
        if (uri2 != null) {
            boolean z3 = (!StringsKt.equals(uri2.getScheme(), Constants.SCHEME, true) || (host = uri2.getHost()) == null || StringsKt.isBlank(host)) ? false : true;
            if (z && StringsKt.equals(uri2.getScheme(), "http", true)) {
                Set<String> set = LOOPBACK_HOSTS;
                String host2 = uri2.getHost();
                if (host2 != null) {
                    Locale ROOT = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                    str = host2.toLowerCase(ROOT);
                    Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
                } else {
                    str = null;
                }
                if (CollectionsKt.contains(set, str)) {
                    z2 = true;
                }
            }
            if (!z3 && !z2) {
                uri2 = null;
            }
            if (uri2 != null) {
                return uri2.toString();
            }
            return null;
        }
        return null;
    }
}
