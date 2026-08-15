package com.arizona.launcher.updater.archive.range;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RemoteZipIndexModels.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003J\t\u0010$\u001a\u00020\fHÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003Jc\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\bHÆ\u0001J\u0014\u0010'\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010)\u001a\u00020\fHÖ\u0081\u0004J\n\u0010*\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016Ê\u0001\f\b,\u0012\b\b-\u0012\u0004\b\u0003\u0010\u0002¨\u0006+"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/RemoteZipEntry;", "", "path", "", TypedValues.AttributesType.S_TARGET, "isDirectory", "", "size", "", "compressedSize", "crc32", FirebaseAnalytics.Param.METHOD, "", DownloaderServiceMarshaller.PARAMS_FLAGS, "localHeaderOffset", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZJJJIIJ)V", "getPath", "()Ljava/lang/String;", "getTarget", "()Z", "getSize", "()J", "getCompressedSize", "getCrc32", "getMethod", "()I", "getFlags", "getLocalHeaderOffset", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RemoteZipEntry {
    public static final int $stable = 0;
    private final long compressedSize;
    private final long crc32;
    private final int flags;
    private final boolean isDirectory;
    private final long localHeaderOffset;
    private final int method;
    private final String path;
    private final long size;
    private final String target;

    public final String component1() {
        return this.path;
    }

    public final String component2() {
        return this.target;
    }

    public final boolean component3() {
        return this.isDirectory;
    }

    public final long component4() {
        return this.size;
    }

    public final long component5() {
        return this.compressedSize;
    }

    public final long component6() {
        return this.crc32;
    }

    public final int component7() {
        return this.method;
    }

    public final int component8() {
        return this.flags;
    }

    public final long component9() {
        return this.localHeaderOffset;
    }

    public final RemoteZipEntry copy(String path, String target, boolean z, long j, long j2, long j3, int i, int i2, long j4) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(target, "target");
        return new RemoteZipEntry(path, target, z, j, j2, j3, i, i2, j4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RemoteZipEntry) {
            RemoteZipEntry remoteZipEntry = (RemoteZipEntry) obj;
            return Intrinsics.areEqual(this.path, remoteZipEntry.path) && Intrinsics.areEqual(this.target, remoteZipEntry.target) && this.isDirectory == remoteZipEntry.isDirectory && this.size == remoteZipEntry.size && this.compressedSize == remoteZipEntry.compressedSize && this.crc32 == remoteZipEntry.crc32 && this.method == remoteZipEntry.method && this.flags == remoteZipEntry.flags && this.localHeaderOffset == remoteZipEntry.localHeaderOffset;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((this.path.hashCode() * 31) + this.target.hashCode()) * 31) + Boolean.hashCode(this.isDirectory)) * 31) + Long.hashCode(this.size)) * 31) + Long.hashCode(this.compressedSize)) * 31) + Long.hashCode(this.crc32)) * 31) + Integer.hashCode(this.method)) * 31) + Integer.hashCode(this.flags)) * 31) + Long.hashCode(this.localHeaderOffset);
    }

    public String toString() {
        String str = this.path;
        String str2 = this.target;
        boolean z = this.isDirectory;
        long j = this.size;
        long j2 = this.compressedSize;
        long j3 = this.crc32;
        int i = this.method;
        int i2 = this.flags;
        return "RemoteZipEntry(path=" + str + ", target=" + str2 + ", isDirectory=" + z + ", size=" + j + ", compressedSize=" + j2 + ", crc32=" + j3 + ", method=" + i + ", flags=" + i2 + ", localHeaderOffset=" + this.localHeaderOffset + ")";
    }

    public RemoteZipEntry(String path, String target, boolean z, long j, long j2, long j3, int i, int i2, long j4) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(target, "target");
        this.path = path;
        this.target = target;
        this.isDirectory = z;
        this.size = j;
        this.compressedSize = j2;
        this.crc32 = j3;
        this.method = i;
        this.flags = i2;
        this.localHeaderOffset = j4;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getTarget() {
        return this.target;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public final long getSize() {
        return this.size;
    }

    public final long getCompressedSize() {
        return this.compressedSize;
    }

    public final long getCrc32() {
        return this.crc32;
    }

    public final int getMethod() {
        return this.method;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final long getLocalHeaderOffset() {
        return this.localHeaderOffset;
    }
}
