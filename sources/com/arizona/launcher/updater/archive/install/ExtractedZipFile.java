package com.arizona.launcher.updater.archive.install;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SafeZipExtractor.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001b"}, d2 = {"Lcom/arizona/launcher/updater/archive/install/ExtractedZipFile;", "", "relativePath", "", "size", "", "crc32", "md5", "<init>", "(Ljava/lang/String;JJLjava/lang/String;)V", "getRelativePath", "()Ljava/lang/String;", "getSize", "()J", "getCrc32", "getMd5", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ExtractedZipFile {
    public static final int $stable = 0;
    private final long crc32;
    private final String md5;
    private final String relativePath;
    private final long size;

    public static /* synthetic */ ExtractedZipFile copy$default(ExtractedZipFile extractedZipFile, String str, long j, long j2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = extractedZipFile.relativePath;
        }
        if ((i & 2) != 0) {
            j = extractedZipFile.size;
        }
        if ((i & 4) != 0) {
            j2 = extractedZipFile.crc32;
        }
        if ((i & 8) != 0) {
            str2 = extractedZipFile.md5;
        }
        String str3 = str2;
        return extractedZipFile.copy(str, j, j2, str3);
    }

    public final String component1() {
        return this.relativePath;
    }

    public final long component2() {
        return this.size;
    }

    public final long component3() {
        return this.crc32;
    }

    public final String component4() {
        return this.md5;
    }

    public final ExtractedZipFile copy(String relativePath, long j, long j2, String md5) {
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        Intrinsics.checkNotNullParameter(md5, "md5");
        return new ExtractedZipFile(relativePath, j, j2, md5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ExtractedZipFile) {
            ExtractedZipFile extractedZipFile = (ExtractedZipFile) obj;
            return Intrinsics.areEqual(this.relativePath, extractedZipFile.relativePath) && this.size == extractedZipFile.size && this.crc32 == extractedZipFile.crc32 && Intrinsics.areEqual(this.md5, extractedZipFile.md5);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.relativePath.hashCode() * 31) + Long.hashCode(this.size)) * 31) + Long.hashCode(this.crc32)) * 31) + this.md5.hashCode();
    }

    public String toString() {
        String str = this.relativePath;
        long j = this.size;
        long j2 = this.crc32;
        return "ExtractedZipFile(relativePath=" + str + ", size=" + j + ", crc32=" + j2 + ", md5=" + this.md5 + ")";
    }

    public ExtractedZipFile(String relativePath, long j, long j2, String md5) {
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        Intrinsics.checkNotNullParameter(md5, "md5");
        this.relativePath = relativePath;
        this.size = j;
        this.crc32 = j2;
        this.md5 = md5;
    }

    public final String getRelativePath() {
        return this.relativePath;
    }

    public final long getSize() {
        return this.size;
    }

    public final long getCrc32() {
        return this.crc32;
    }

    public final String getMd5() {
        return this.md5;
    }
}
