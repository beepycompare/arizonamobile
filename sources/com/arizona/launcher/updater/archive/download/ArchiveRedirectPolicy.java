package com.arizona.launcher.updater.archive.download;

import com.adjust.sdk.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.net.URI;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ArchiveResumableHttpEngine.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000Ê\u0001\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\u0003\u0010\u0002¨\u0006\r"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveRedirectPolicy;", "", "<init>", "()V", "MAX_REDIRECT_HOPS", "", "resolve", "", "fromUrl", FirebaseAnalytics.Param.LOCATION, "redirectsFollowed", "allowInsecureLoopback", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveRedirectPolicy {
    public static final int $stable = 0;
    public static final ArchiveRedirectPolicy INSTANCE = new ArchiveRedirectPolicy();
    private static final int MAX_REDIRECT_HOPS = 5;

    private ArchiveRedirectPolicy() {
    }

    public final String resolve(String fromUrl, String str, int i, boolean z) {
        String str2;
        Object m9919constructorimpl;
        Boolean m9919constructorimpl2;
        Intrinsics.checkNotNullParameter(fromUrl, "fromUrl");
        if (i >= 5 || (str2 = str) == null || StringsKt.isBlank(str2)) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            ArchiveRedirectPolicy archiveRedirectPolicy = this;
            m9919constructorimpl = Result.m9919constructorimpl(new URI(fromUrl).resolve(str).toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9919constructorimpl = Result.m9919constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9925isFailureimpl(m9919constructorimpl)) {
            m9919constructorimpl = null;
        }
        String str3 = (String) m9919constructorimpl;
        if (str3 == null) {
            return null;
        }
        try {
            Result.Companion companion3 = Result.Companion;
            ArchiveRedirectPolicy archiveRedirectPolicy2 = this;
            m9919constructorimpl2 = Result.m9919constructorimpl(Boolean.valueOf(StringsKt.equals(new URI(fromUrl).getScheme(), Constants.SCHEME, true) && !StringsKt.equals(new URI(str3).getScheme(), Constants.SCHEME, true)));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            m9919constructorimpl2 = Result.m9919constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m9925isFailureimpl(m9919constructorimpl2)) {
            m9919constructorimpl2 = true;
        }
        if (!((Boolean) m9919constructorimpl2).booleanValue() && ArchiveRemoteNetworkPolicy.INSTANCE.isAllowedUrl(str3, z)) {
            return str3;
        }
        return null;
    }
}
