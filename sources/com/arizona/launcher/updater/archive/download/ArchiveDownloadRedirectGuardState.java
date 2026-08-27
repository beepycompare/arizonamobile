package com.arizona.launcher.updater.archive.download;

import com.adjust.sdk.Constants;
import java.net.URI;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ArchiveNetworkSecurity.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0000¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadRedirectGuardState;", "", "maxRedirectHops", "", "<init>", "(I)V", "lastUrl", "", "followUpAttempts", "accept", "", "url", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveDownloadRedirectGuardState {
    public static final int $stable = 8;
    private int followUpAttempts;
    private String lastUrl;
    private final int maxRedirectHops;

    public ArchiveDownloadRedirectGuardState() {
        this(0, 1, null);
    }

    public ArchiveDownloadRedirectGuardState(int i) {
        this.maxRedirectHops = i;
    }

    public /* synthetic */ ArchiveDownloadRedirectGuardState(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 5 : i);
    }

    public final synchronized boolean accept(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String str = this.lastUrl;
        if (str != null) {
            Result.Companion companion = Result.Companion;
            ArchiveDownloadRedirectGuardState archiveDownloadRedirectGuardState = this;
            Object m9919constructorimpl = Result.m9919constructorimpl(Boolean.valueOf(StringsKt.equals(new URI(str).getScheme(), Constants.SCHEME, true) && !StringsKt.equals(new URI(url).getScheme(), Constants.SCHEME, true)));
            if (Result.m9925isFailureimpl(m9919constructorimpl)) {
                m9919constructorimpl = true;
            }
            if (((Boolean) m9919constructorimpl).booleanValue()) {
                return false;
            }
            this.followUpAttempts++;
        }
        this.lastUrl = url;
        return this.followUpAttempts <= this.maxRedirectHops;
    }
}
