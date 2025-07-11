package com.miami.game.core.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DownloaderInfo.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010(\u001a\u00020\fHÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u008e\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\f2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001dR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001e\u0010\u0018R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001f\u0010\u0018R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b \u0010\u0018¨\u00063"}, d2 = {"Lcom/miami/game/core/domain/model/DownloaderInfo;", "", "id", "", "path", "", "nameFromGameInfoFile", "sizeFromGameInfoFile", "hashFromGameInfoFile", "dateChangeFromGameInfoFile", "gpuTypeFromGameInfoFile", "isCompletedDownload", "", "downloadStartAt", "downloadFinishAt", "createdAt", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ZLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getId", "()J", "getPath", "()Ljava/lang/String;", "getNameFromGameInfoFile", "getSizeFromGameInfoFile", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getHashFromGameInfoFile", "getDateChangeFromGameInfoFile", "getGpuTypeFromGameInfoFile", "()Z", "getDownloadStartAt", "getDownloadFinishAt", "getCreatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ZLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/miami/game/core/domain/model/DownloaderInfo;", "equals", "other", "hashCode", "", "toString", "domain-model_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DownloaderInfo {
    private final Long createdAt;
    private final Long dateChangeFromGameInfoFile;
    private final Long downloadFinishAt;
    private final Long downloadStartAt;
    private final String gpuTypeFromGameInfoFile;
    private final String hashFromGameInfoFile;
    private final long id;
    private final boolean isCompletedDownload;
    private final String nameFromGameInfoFile;
    private final String path;
    private final Long sizeFromGameInfoFile;

    public static /* synthetic */ DownloaderInfo copy$default(DownloaderInfo downloaderInfo, long j, String str, String str2, Long l, String str3, Long l2, String str4, boolean z, Long l3, Long l4, Long l5, int i, Object obj) {
        if ((i & 1) != 0) {
            j = downloaderInfo.id;
        }
        return downloaderInfo.copy(j, (i & 2) != 0 ? downloaderInfo.path : str, (i & 4) != 0 ? downloaderInfo.nameFromGameInfoFile : str2, (i & 8) != 0 ? downloaderInfo.sizeFromGameInfoFile : l, (i & 16) != 0 ? downloaderInfo.hashFromGameInfoFile : str3, (i & 32) != 0 ? downloaderInfo.dateChangeFromGameInfoFile : l2, (i & 64) != 0 ? downloaderInfo.gpuTypeFromGameInfoFile : str4, (i & 128) != 0 ? downloaderInfo.isCompletedDownload : z, (i & 256) != 0 ? downloaderInfo.downloadStartAt : l3, (i & 512) != 0 ? downloaderInfo.downloadFinishAt : l4, (i & 1024) != 0 ? downloaderInfo.createdAt : l5);
    }

    public final long component1() {
        return this.id;
    }

    public final Long component10() {
        return this.downloadFinishAt;
    }

    public final Long component11() {
        return this.createdAt;
    }

    public final String component2() {
        return this.path;
    }

    public final String component3() {
        return this.nameFromGameInfoFile;
    }

    public final Long component4() {
        return this.sizeFromGameInfoFile;
    }

    public final String component5() {
        return this.hashFromGameInfoFile;
    }

    public final Long component6() {
        return this.dateChangeFromGameInfoFile;
    }

    public final String component7() {
        return this.gpuTypeFromGameInfoFile;
    }

    public final boolean component8() {
        return this.isCompletedDownload;
    }

    public final Long component9() {
        return this.downloadStartAt;
    }

    public final DownloaderInfo copy(long j, String str, String str2, Long l, String str3, Long l2, String str4, boolean z, Long l3, Long l4, Long l5) {
        return new DownloaderInfo(j, str, str2, l, str3, l2, str4, z, l3, l4, l5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DownloaderInfo) {
            DownloaderInfo downloaderInfo = (DownloaderInfo) obj;
            return this.id == downloaderInfo.id && Intrinsics.areEqual(this.path, downloaderInfo.path) && Intrinsics.areEqual(this.nameFromGameInfoFile, downloaderInfo.nameFromGameInfoFile) && Intrinsics.areEqual(this.sizeFromGameInfoFile, downloaderInfo.sizeFromGameInfoFile) && Intrinsics.areEqual(this.hashFromGameInfoFile, downloaderInfo.hashFromGameInfoFile) && Intrinsics.areEqual(this.dateChangeFromGameInfoFile, downloaderInfo.dateChangeFromGameInfoFile) && Intrinsics.areEqual(this.gpuTypeFromGameInfoFile, downloaderInfo.gpuTypeFromGameInfoFile) && this.isCompletedDownload == downloaderInfo.isCompletedDownload && Intrinsics.areEqual(this.downloadStartAt, downloaderInfo.downloadStartAt) && Intrinsics.areEqual(this.downloadFinishAt, downloaderInfo.downloadFinishAt) && Intrinsics.areEqual(this.createdAt, downloaderInfo.createdAt);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.id) * 31;
        String str = this.path;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.nameFromGameInfoFile;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.sizeFromGameInfoFile;
        int hashCode4 = (hashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        String str3 = this.hashFromGameInfoFile;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l2 = this.dateChangeFromGameInfoFile;
        int hashCode6 = (hashCode5 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str4 = this.gpuTypeFromGameInfoFile;
        int hashCode7 = (((hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31) + Boolean.hashCode(this.isCompletedDownload)) * 31;
        Long l3 = this.downloadStartAt;
        int hashCode8 = (hashCode7 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.downloadFinishAt;
        int hashCode9 = (hashCode8 + (l4 == null ? 0 : l4.hashCode())) * 31;
        Long l5 = this.createdAt;
        return hashCode9 + (l5 != null ? l5.hashCode() : 0);
    }

    public String toString() {
        long j = this.id;
        String str = this.path;
        String str2 = this.nameFromGameInfoFile;
        Long l = this.sizeFromGameInfoFile;
        String str3 = this.hashFromGameInfoFile;
        Long l2 = this.dateChangeFromGameInfoFile;
        String str4 = this.gpuTypeFromGameInfoFile;
        boolean z = this.isCompletedDownload;
        Long l3 = this.downloadStartAt;
        Long l4 = this.downloadFinishAt;
        return "DownloaderInfo(id=" + j + ", path=" + str + ", nameFromGameInfoFile=" + str2 + ", sizeFromGameInfoFile=" + l + ", hashFromGameInfoFile=" + str3 + ", dateChangeFromGameInfoFile=" + l2 + ", gpuTypeFromGameInfoFile=" + str4 + ", isCompletedDownload=" + z + ", downloadStartAt=" + l3 + ", downloadFinishAt=" + l4 + ", createdAt=" + this.createdAt + ")";
    }

    public DownloaderInfo(long j, String str, String str2, Long l, String str3, Long l2, String str4, boolean z, Long l3, Long l4, Long l5) {
        this.id = j;
        this.path = str;
        this.nameFromGameInfoFile = str2;
        this.sizeFromGameInfoFile = l;
        this.hashFromGameInfoFile = str3;
        this.dateChangeFromGameInfoFile = l2;
        this.gpuTypeFromGameInfoFile = str4;
        this.isCompletedDownload = z;
        this.downloadStartAt = l3;
        this.downloadFinishAt = l4;
        this.createdAt = l5;
    }

    public final long getId() {
        return this.id;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getNameFromGameInfoFile() {
        return this.nameFromGameInfoFile;
    }

    public final Long getSizeFromGameInfoFile() {
        return this.sizeFromGameInfoFile;
    }

    public final String getHashFromGameInfoFile() {
        return this.hashFromGameInfoFile;
    }

    public final Long getDateChangeFromGameInfoFile() {
        return this.dateChangeFromGameInfoFile;
    }

    public final String getGpuTypeFromGameInfoFile() {
        return this.gpuTypeFromGameInfoFile;
    }

    public final boolean isCompletedDownload() {
        return this.isCompletedDownload;
    }

    public final Long getDownloadStartAt() {
        return this.downloadStartAt;
    }

    public final Long getDownloadFinishAt() {
        return this.downloadFinishAt;
    }

    public final Long getCreatedAt() {
        return this.createdAt;
    }
}
