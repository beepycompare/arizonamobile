package com.arizona.game.debug.backend;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BackendContractValidation.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fÊ\u0001\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0019"}, d2 = {"Lcom/arizona/game/debug/backend/BackendValidationReport;", "", "provider", "", FirebaseAnalytics.Param.SUCCESS, "", "summaryLines", "", "<init>", "(Ljava/lang/String;ZLjava/util/List;)V", "getProvider", "()Ljava/lang/String;", "getSuccess", "()Z", "getSummaryLines", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BackendValidationReport {
    public static final int $stable = 8;
    private final String provider;
    private final boolean success;
    private final List<String> summaryLines;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BackendValidationReport copy$default(BackendValidationReport backendValidationReport, String str, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = backendValidationReport.provider;
        }
        if ((i & 2) != 0) {
            z = backendValidationReport.success;
        }
        if ((i & 4) != 0) {
            list = backendValidationReport.summaryLines;
        }
        return backendValidationReport.copy(str, z, list);
    }

    public final String component1() {
        return this.provider;
    }

    public final boolean component2() {
        return this.success;
    }

    public final List<String> component3() {
        return this.summaryLines;
    }

    public final BackendValidationReport copy(String provider, boolean z, List<String> summaryLines) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(summaryLines, "summaryLines");
        return new BackendValidationReport(provider, z, summaryLines);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BackendValidationReport) {
            BackendValidationReport backendValidationReport = (BackendValidationReport) obj;
            return Intrinsics.areEqual(this.provider, backendValidationReport.provider) && this.success == backendValidationReport.success && Intrinsics.areEqual(this.summaryLines, backendValidationReport.summaryLines);
        }
        return false;
    }

    public int hashCode() {
        return (((this.provider.hashCode() * 31) + Boolean.hashCode(this.success)) * 31) + this.summaryLines.hashCode();
    }

    public String toString() {
        String str = this.provider;
        boolean z = this.success;
        return "BackendValidationReport(provider=" + str + ", success=" + z + ", summaryLines=" + this.summaryLines + ")";
    }

    public BackendValidationReport(String provider, boolean z, List<String> summaryLines) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(summaryLines, "summaryLines");
        this.provider = provider;
        this.success = z;
        this.summaryLines = summaryLines;
    }

    public final String getProvider() {
        return this.provider;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final List<String> getSummaryLines() {
        return this.summaryLines;
    }
}
