package com.arizona.launcher.updater.apk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: LauncherApkResumeStore.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ'\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u001cJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003JX\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010%J\u0014\u0010&\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020)HÖ\u0081\u0004J\n\u0010*\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fÊ\u0001\f\b,\u0012\b\b-\u0012\u0004\b\u0003\u0010\u0002¨\u0006+"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkResumeMetadata;", "", "sourceUrl", "", "totalBytes", "", "committedBytes", "validatorKind", "Lcom/arizona/launcher/updater/apk/LauncherApkValidatorKind;", "validatorValue", "expectedSizeBytes", "expectedSha256", "<init>", "(Ljava/lang/String;JJLcom/arizona/launcher/updater/apk/LauncherApkValidatorKind;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getSourceUrl", "()Ljava/lang/String;", "getTotalBytes", "()J", "getCommittedBytes", "getValidatorKind", "()Lcom/arizona/launcher/updater/apk/LauncherApkValidatorKind;", "getValidatorValue", "getExpectedSizeBytes", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExpectedSha256", "matches", "", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;JJLcom/arizona/launcher/updater/apk/LauncherApkValidatorKind;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/arizona/launcher/updater/apk/LauncherApkResumeMetadata;", "equals", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherApkResumeMetadata {
    public static final int $stable = 0;
    private final long committedBytes;
    private final String expectedSha256;
    private final Long expectedSizeBytes;
    private final String sourceUrl;
    private final long totalBytes;
    private final LauncherApkValidatorKind validatorKind;
    private final String validatorValue;

    public static /* synthetic */ LauncherApkResumeMetadata copy$default(LauncherApkResumeMetadata launcherApkResumeMetadata, String str, long j, long j2, LauncherApkValidatorKind launcherApkValidatorKind, String str2, Long l, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = launcherApkResumeMetadata.sourceUrl;
        }
        if ((i & 2) != 0) {
            j = launcherApkResumeMetadata.totalBytes;
        }
        if ((i & 4) != 0) {
            j2 = launcherApkResumeMetadata.committedBytes;
        }
        if ((i & 8) != 0) {
            launcherApkValidatorKind = launcherApkResumeMetadata.validatorKind;
        }
        if ((i & 16) != 0) {
            str2 = launcherApkResumeMetadata.validatorValue;
        }
        if ((i & 32) != 0) {
            l = launcherApkResumeMetadata.expectedSizeBytes;
        }
        if ((i & 64) != 0) {
            str3 = launcherApkResumeMetadata.expectedSha256;
        }
        long j3 = j2;
        return launcherApkResumeMetadata.copy(str, j, j3, launcherApkValidatorKind, str2, l, str3);
    }

    public final String component1() {
        return this.sourceUrl;
    }

    public final long component2() {
        return this.totalBytes;
    }

    public final long component3() {
        return this.committedBytes;
    }

    public final LauncherApkValidatorKind component4() {
        return this.validatorKind;
    }

    public final String component5() {
        return this.validatorValue;
    }

    public final Long component6() {
        return this.expectedSizeBytes;
    }

    public final String component7() {
        return this.expectedSha256;
    }

    public final LauncherApkResumeMetadata copy(String sourceUrl, long j, long j2, LauncherApkValidatorKind validatorKind, String validatorValue, Long l, String str) {
        Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
        Intrinsics.checkNotNullParameter(validatorKind, "validatorKind");
        Intrinsics.checkNotNullParameter(validatorValue, "validatorValue");
        return new LauncherApkResumeMetadata(sourceUrl, j, j2, validatorKind, validatorValue, l, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LauncherApkResumeMetadata) {
            LauncherApkResumeMetadata launcherApkResumeMetadata = (LauncherApkResumeMetadata) obj;
            return Intrinsics.areEqual(this.sourceUrl, launcherApkResumeMetadata.sourceUrl) && this.totalBytes == launcherApkResumeMetadata.totalBytes && this.committedBytes == launcherApkResumeMetadata.committedBytes && this.validatorKind == launcherApkResumeMetadata.validatorKind && Intrinsics.areEqual(this.validatorValue, launcherApkResumeMetadata.validatorValue) && Intrinsics.areEqual(this.expectedSizeBytes, launcherApkResumeMetadata.expectedSizeBytes) && Intrinsics.areEqual(this.expectedSha256, launcherApkResumeMetadata.expectedSha256);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((this.sourceUrl.hashCode() * 31) + Long.hashCode(this.totalBytes)) * 31) + Long.hashCode(this.committedBytes)) * 31) + this.validatorKind.hashCode()) * 31) + this.validatorValue.hashCode()) * 31;
        Long l = this.expectedSizeBytes;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.expectedSha256;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        String str = this.sourceUrl;
        long j = this.totalBytes;
        long j2 = this.committedBytes;
        LauncherApkValidatorKind launcherApkValidatorKind = this.validatorKind;
        String str2 = this.validatorValue;
        Long l = this.expectedSizeBytes;
        return "LauncherApkResumeMetadata(sourceUrl=" + str + ", totalBytes=" + j + ", committedBytes=" + j2 + ", validatorKind=" + launcherApkValidatorKind + ", validatorValue=" + str2 + ", expectedSizeBytes=" + l + ", expectedSha256=" + this.expectedSha256 + ")";
    }

    public LauncherApkResumeMetadata(String sourceUrl, long j, long j2, LauncherApkValidatorKind validatorKind, String validatorValue, Long l, String str) {
        Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
        Intrinsics.checkNotNullParameter(validatorKind, "validatorKind");
        Intrinsics.checkNotNullParameter(validatorValue, "validatorValue");
        this.sourceUrl = sourceUrl;
        this.totalBytes = j;
        this.committedBytes = j2;
        this.validatorKind = validatorKind;
        this.validatorValue = validatorValue;
        this.expectedSizeBytes = l;
        this.expectedSha256 = str;
    }

    public final String getSourceUrl() {
        return this.sourceUrl;
    }

    public final long getTotalBytes() {
        return this.totalBytes;
    }

    public final long getCommittedBytes() {
        return this.committedBytes;
    }

    public final LauncherApkValidatorKind getValidatorKind() {
        return this.validatorKind;
    }

    public final String getValidatorValue() {
        return this.validatorValue;
    }

    public final Long getExpectedSizeBytes() {
        return this.expectedSizeBytes;
    }

    public final String getExpectedSha256() {
        return this.expectedSha256;
    }

    public final boolean matches(String sourceUrl, Long l, String str) {
        Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
        if (Intrinsics.areEqual(this.sourceUrl, sourceUrl) && Intrinsics.areEqual(this.expectedSizeBytes, l) && Intrinsics.areEqual(this.expectedSha256, str)) {
            long j = this.totalBytes;
            if (j > 0) {
                long j2 = this.committedBytes;
                return 0 <= j2 && j2 < j && !StringsKt.isBlank(this.validatorValue);
            }
            return false;
        }
        return false;
    }
}
