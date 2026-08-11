package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DownloadFailureClassifier.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ$\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0018"}, d2 = {"Lcom/arizona/launcher/DownloadFailureDetails;", "", "subtypeSuffix", "", "httpStatus", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getSubtypeSuffix", "()Ljava/lang/String;", "getHttpStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "subtypeFor", "errorType", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/arizona/launcher/DownloadFailureDetails;", "equals", "", "other", "hashCode", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DownloadFailureDetails {
    public static final int $stable = 0;
    private final Integer httpStatus;
    private final String subtypeSuffix;

    public static /* synthetic */ DownloadFailureDetails copy$default(DownloadFailureDetails downloadFailureDetails, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = downloadFailureDetails.subtypeSuffix;
        }
        if ((i & 2) != 0) {
            num = downloadFailureDetails.httpStatus;
        }
        return downloadFailureDetails.copy(str, num);
    }

    public final String component1() {
        return this.subtypeSuffix;
    }

    public final Integer component2() {
        return this.httpStatus;
    }

    public final DownloadFailureDetails copy(String subtypeSuffix, Integer num) {
        Intrinsics.checkNotNullParameter(subtypeSuffix, "subtypeSuffix");
        return new DownloadFailureDetails(subtypeSuffix, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DownloadFailureDetails) {
            DownloadFailureDetails downloadFailureDetails = (DownloadFailureDetails) obj;
            return Intrinsics.areEqual(this.subtypeSuffix, downloadFailureDetails.subtypeSuffix) && Intrinsics.areEqual(this.httpStatus, downloadFailureDetails.httpStatus);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.subtypeSuffix.hashCode() * 31;
        Integer num = this.httpStatus;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        String str = this.subtypeSuffix;
        return "DownloadFailureDetails(subtypeSuffix=" + str + ", httpStatus=" + this.httpStatus + ")";
    }

    public DownloadFailureDetails(String subtypeSuffix, Integer num) {
        Intrinsics.checkNotNullParameter(subtypeSuffix, "subtypeSuffix");
        this.subtypeSuffix = subtypeSuffix;
        this.httpStatus = num;
    }

    public /* synthetic */ DownloadFailureDetails(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : num);
    }

    public final String getSubtypeSuffix() {
        return this.subtypeSuffix;
    }

    public final Integer getHttpStatus() {
        return this.httpStatus;
    }

    public final String subtypeFor(String errorType) {
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        return errorType + "_" + this.subtypeSuffix;
    }
}
