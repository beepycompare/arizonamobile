package com.arizona.launcher.updater.archive.install;

import androidx.collection.SieveCacheKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import coil3.util.UtilsKt;
import com.arizona.launcher.updater.archive.orchestrator.RemoteOriginalTzArchivePackageIndexSource;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: SafeZipExtractor.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001:\u0002()B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0002J\u0018\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\nH\u0002J\u0018\u0010\"\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\nH\u0002J\u0018\u0010#\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\nH\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/arizona/launcher/updater/archive/install/ZipCentralDirectoryInspector;", "", "<init>", "()V", "EOCD_SIGNATURE", "", "ZIP64_EOCD_SIGNATURE", "ZIP64_LOCATOR_SIGNATURE", "CENTRAL_ENTRY_SIGNATURE", "EOCD_MIN_SIZE", "", "MAX_ZIP_COMMENT_SIZE", "ZIP64_LOCATOR_SIZE", "CENTRAL_ENTRY_FIXED_SIZE", "inspect", "", "Lcom/arizona/launcher/updater/archive/install/RawCentralDirectoryEntry;", UtilsKt.SCHEME_FILE, "Ljava/io/File;", "maxEntryCount", "findEocd", "Lcom/arizona/launcher/updater/archive/install/ZipCentralDirectoryInspector$Eocd;", "input", "Ljava/io/RandomAccessFile;", "readDirectorySummary", "Lcom/arizona/launcher/updater/archive/install/ZipCentralDirectoryInspector$DirectorySummary;", "eocd", "safeAdd", TtmlNode.LEFT, TtmlNode.RIGHT, "u16", "bytes", "", TypedValues.CycleType.S_WAVE_OFFSET, "u32", "u64", "inspectorFailure", "Lcom/arizona/launcher/updater/archive/install/ExtractionFailure;", "code", "Lcom/arizona/launcher/updater/archive/install/SafeZipExtractionErrorCode;", "Eocd", "DirectorySummary", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final class ZipCentralDirectoryInspector {
    private static final int CENTRAL_ENTRY_FIXED_SIZE = 46;
    private static final long CENTRAL_ENTRY_SIGNATURE = 33639248;
    private static final int EOCD_MIN_SIZE = 22;
    private static final long EOCD_SIGNATURE = 101010256;
    public static final ZipCentralDirectoryInspector INSTANCE = new ZipCentralDirectoryInspector();
    private static final int MAX_ZIP_COMMENT_SIZE = 65535;
    private static final long ZIP64_EOCD_SIGNATURE = 101075792;
    private static final long ZIP64_LOCATOR_SIGNATURE = 117853008;
    private static final int ZIP64_LOCATOR_SIZE = 20;

    private ZipCentralDirectoryInspector() {
    }

    public final List<RawCentralDirectoryEntry> inspect(File file, int i) {
        Intrinsics.checkNotNullParameter(file, "file");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            RandomAccessFile randomAccessFile2 = randomAccessFile;
            ZipCentralDirectoryInspector zipCentralDirectoryInspector = INSTANCE;
            DirectorySummary readDirectorySummary = zipCentralDirectoryInspector.readDirectorySummary(randomAccessFile2, zipCentralDirectoryInspector.findEocd(randomAccessFile2));
            if (readDirectorySummary.getEntryCount() <= 0) {
                throw zipCentralDirectoryInspector.inspectorFailure(SafeZipExtractionErrorCode.EMPTY_ARCHIVE);
            }
            if (readDirectorySummary.getEntryCount() > i || readDirectorySummary.getEntryCount() > SieveCacheKt.NodeLinkMask) {
                throw zipCentralDirectoryInspector.inspectorFailure(SafeZipExtractionErrorCode.ENTRY_COUNT_LIMIT_EXCEEDED);
            }
            long safeAdd = zipCentralDirectoryInspector.safeAdd(readDirectorySummary.getOffset(), readDirectorySummary.getSize());
            if (readDirectorySummary.getOffset() < 0 || readDirectorySummary.getSize() < 0 || safeAdd > readDirectorySummary.getBoundary()) {
                throw zipCentralDirectoryInspector.inspectorFailure(SafeZipExtractionErrorCode.MALFORMED_ARCHIVE);
            }
            randomAccessFile2.seek(readDirectorySummary.getOffset());
            ArrayList arrayList = new ArrayList((int) readDirectorySummary.getEntryCount());
            int entryCount = (int) readDirectorySummary.getEntryCount();
            int i2 = 0;
            int i3 = 0;
            while (i3 < entryCount) {
                byte[] bArr = new byte[46];
                randomAccessFile2.readFully(bArr);
                ZipCentralDirectoryInspector zipCentralDirectoryInspector2 = INSTANCE;
                if (zipCentralDirectoryInspector2.u32(bArr, i2) != 33639248) {
                    throw zipCentralDirectoryInspector2.inspectorFailure(SafeZipExtractionErrorCode.MALFORMED_ARCHIVE);
                }
                int u16 = zipCentralDirectoryInspector2.u16(bArr, 8);
                int u162 = zipCentralDirectoryInspector2.u16(bArr, 10);
                int u163 = zipCentralDirectoryInspector2.u16(bArr, 28);
                int u164 = zipCentralDirectoryInspector2.u16(bArr, 30);
                int u165 = zipCentralDirectoryInspector2.u16(bArr, 32);
                int i4 = i3;
                long u32 = zipCentralDirectoryInspector2.u32(bArr, 38);
                ArrayList arrayList2 = arrayList;
                int i5 = entryCount;
                long safeAdd2 = zipCentralDirectoryInspector2.safeAdd(randomAccessFile2.getFilePointer(), u163 + u164 + u165);
                if (safeAdd2 > safeAdd) {
                    throw zipCentralDirectoryInspector2.inspectorFailure(SafeZipExtractionErrorCode.MALFORMED_ARCHIVE);
                }
                arrayList2.add(new RawCentralDirectoryEntry(u16, u162, u32));
                randomAccessFile2.seek(safeAdd2);
                i3 = i4 + 1;
                arrayList = arrayList2;
                entryCount = i5;
                i2 = 0;
            }
            ArrayList arrayList3 = arrayList;
            if (randomAccessFile2.getFilePointer() != safeAdd) {
                throw INSTANCE.inspectorFailure(SafeZipExtractionErrorCode.MALFORMED_ARCHIVE);
            }
            ArrayList arrayList4 = arrayList3;
            CloseableKt.closeFinally(randomAccessFile, null);
            return arrayList4;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(randomAccessFile, th);
                throw th2;
            }
        }
    }

    private final Eocd findEocd(RandomAccessFile randomAccessFile) {
        long length = randomAccessFile.length();
        if (length < 22) {
            throw inspectorFailure(SafeZipExtractionErrorCode.MALFORMED_ARCHIVE);
        }
        int min = (int) Math.min(length, (long) RemoteOriginalTzArchivePackageIndexSource.ZIP_EOCD_TAIL_BYTES);
        long j = length - min;
        byte[] bArr = new byte[min];
        randomAccessFile.seek(j);
        randomAccessFile.readFully(bArr);
        for (int i = min - 22; -1 < i; i--) {
            if (u32(bArr, i) == 101010256) {
                int i2 = i + 22;
                if (u16(bArr, i + 20) + i2 == min) {
                    return new Eocd(j + i, ArraysKt.copyOfRange(bArr, i, i2));
                }
            }
        }
        throw inspectorFailure(SafeZipExtractionErrorCode.MALFORMED_ARCHIVE);
    }

    private final DirectorySummary readDirectorySummary(RandomAccessFile randomAccessFile, Eocd eocd) {
        int u16 = u16(eocd.getHeader(), 4);
        int u162 = u16(eocd.getHeader(), 6);
        int u163 = u16(eocd.getHeader(), 8);
        int u164 = u16(eocd.getHeader(), 10);
        long u32 = u32(eocd.getHeader(), 12);
        long u322 = u32(eocd.getHeader(), 16);
        if (u16 == 0 && u162 == 0 && u163 == u164) {
            if (u163 != 65535 && u164 != 65535 && u32 != 4294967295L && u322 != 4294967295L) {
                return new DirectorySummary(u164, u32, u322, eocd.getOffset());
            }
            long offset = eocd.getOffset() - 20;
            if (offset < 0) {
                throw inspectorFailure(SafeZipExtractionErrorCode.MALFORMED_ARCHIVE);
            }
            byte[] bArr = new byte[20];
            randomAccessFile.seek(offset);
            randomAccessFile.readFully(bArr);
            if (u32(bArr, 0) != ZIP64_LOCATOR_SIGNATURE) {
                throw inspectorFailure(SafeZipExtractionErrorCode.MALFORMED_ARCHIVE);
            }
            if (u32(bArr, 4) != 0 || u32(bArr, 16) != 1) {
                throw inspectorFailure(SafeZipExtractionErrorCode.MULTI_DISK_ARCHIVE_UNSUPPORTED);
            }
            long u64 = u64(bArr, 8);
            if (u64 < 0 || u64 >= offset) {
                throw inspectorFailure(SafeZipExtractionErrorCode.MALFORMED_ARCHIVE);
            }
            byte[] bArr2 = new byte[56];
            randomAccessFile.seek(u64);
            randomAccessFile.readFully(bArr2);
            if (u32(bArr2, 0) != ZIP64_EOCD_SIGNATURE) {
                throw inspectorFailure(SafeZipExtractionErrorCode.MALFORMED_ARCHIVE);
            }
            long u642 = u64(bArr2, 4);
            if (u642 < 44 || safeAdd(u64, safeAdd(12L, u642)) > offset) {
                throw inspectorFailure(SafeZipExtractionErrorCode.MALFORMED_ARCHIVE);
            }
            if (u32(bArr2, 16) != 0 || u32(bArr2, 20) != 0) {
                throw inspectorFailure(SafeZipExtractionErrorCode.MULTI_DISK_ARCHIVE_UNSUPPORTED);
            }
            long u643 = u64(bArr2, 24);
            long u644 = u64(bArr2, 32);
            if (u643 != u644) {
                throw inspectorFailure(SafeZipExtractionErrorCode.MULTI_DISK_ARCHIVE_UNSUPPORTED);
            }
            return new DirectorySummary(u644, u64(bArr2, 40), u64(bArr2, 48), u64);
        }
        throw inspectorFailure(SafeZipExtractionErrorCode.MULTI_DISK_ARCHIVE_UNSUPPORTED);
    }

    private final long safeAdd(long j, long j2) {
        if (j < 0 || j2 < 0 || j > Long.MAX_VALUE - j2) {
            throw inspectorFailure(SafeZipExtractionErrorCode.MALFORMED_ARCHIVE);
        }
        return j + j2;
    }

    private final int u16(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
    }

    private final long u32(byte[] bArr, int i) {
        return ((u16(bArr, i + 2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | (u16(bArr, i) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    private final long u64(byte[] bArr, int i) {
        long u32 = u32(bArr, i);
        long u322 = u32(bArr, i + 4);
        if ((2147483648L & u322) == 0) {
            return (u322 << 32) | u32;
        }
        throw inspectorFailure(SafeZipExtractionErrorCode.MALFORMED_ARCHIVE);
    }

    private final ExtractionFailure inspectorFailure(SafeZipExtractionErrorCode safeZipExtractionErrorCode) {
        return new ExtractionFailure(safeZipExtractionErrorCode, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeZipExtractor.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/install/ZipCentralDirectoryInspector$Eocd;", "", TypedValues.CycleType.S_WAVE_OFFSET, "", "header", "", "<init>", "(J[B)V", "getOffset", "()J", "getHeader", "()[B", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Eocd {
        private final byte[] header;
        private final long offset;

        public static /* synthetic */ Eocd copy$default(Eocd eocd, long j, byte[] bArr, int i, Object obj) {
            if ((i & 1) != 0) {
                j = eocd.offset;
            }
            if ((i & 2) != 0) {
                bArr = eocd.header;
            }
            return eocd.copy(j, bArr);
        }

        public final long component1() {
            return this.offset;
        }

        public final byte[] component2() {
            return this.header;
        }

        public final Eocd copy(long j, byte[] header) {
            Intrinsics.checkNotNullParameter(header, "header");
            return new Eocd(j, header);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Eocd) {
                Eocd eocd = (Eocd) obj;
                return this.offset == eocd.offset && Intrinsics.areEqual(this.header, eocd.header);
            }
            return false;
        }

        public int hashCode() {
            return (Long.hashCode(this.offset) * 31) + Arrays.hashCode(this.header);
        }

        public String toString() {
            long j = this.offset;
            return "Eocd(offset=" + j + ", header=" + Arrays.toString(this.header) + ")";
        }

        public Eocd(long j, byte[] header) {
            Intrinsics.checkNotNullParameter(header, "header");
            this.offset = j;
            this.header = header;
        }

        public final long getOffset() {
            return this.offset;
        }

        public final byte[] getHeader() {
            return this.header;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeZipExtractor.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/arizona/launcher/updater/archive/install/ZipCentralDirectoryInspector$DirectorySummary;", "", "entryCount", "", "size", TypedValues.CycleType.S_WAVE_OFFSET, "boundary", "<init>", "(JJJJ)V", "getEntryCount", "()J", "getSize", "getOffset", "getBoundary", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DirectorySummary {
        private final long boundary;
        private final long entryCount;
        private final long offset;
        private final long size;

        public static /* synthetic */ DirectorySummary copy$default(DirectorySummary directorySummary, long j, long j2, long j3, long j4, int i, Object obj) {
            if ((i & 1) != 0) {
                j = directorySummary.entryCount;
            }
            long j5 = j;
            if ((i & 2) != 0) {
                j2 = directorySummary.size;
            }
            long j6 = j2;
            if ((i & 4) != 0) {
                j3 = directorySummary.offset;
            }
            return directorySummary.copy(j5, j6, j3, (i & 8) != 0 ? directorySummary.boundary : j4);
        }

        public final long component1() {
            return this.entryCount;
        }

        public final long component2() {
            return this.size;
        }

        public final long component3() {
            return this.offset;
        }

        public final long component4() {
            return this.boundary;
        }

        public final DirectorySummary copy(long j, long j2, long j3, long j4) {
            return new DirectorySummary(j, j2, j3, j4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DirectorySummary) {
                DirectorySummary directorySummary = (DirectorySummary) obj;
                return this.entryCount == directorySummary.entryCount && this.size == directorySummary.size && this.offset == directorySummary.offset && this.boundary == directorySummary.boundary;
            }
            return false;
        }

        public int hashCode() {
            return (((((Long.hashCode(this.entryCount) * 31) + Long.hashCode(this.size)) * 31) + Long.hashCode(this.offset)) * 31) + Long.hashCode(this.boundary);
        }

        public String toString() {
            long j = this.entryCount;
            long j2 = this.size;
            long j3 = this.offset;
            return "DirectorySummary(entryCount=" + j + ", size=" + j2 + ", offset=" + j3 + ", boundary=" + this.boundary + ")";
        }

        public DirectorySummary(long j, long j2, long j3, long j4) {
            this.entryCount = j;
            this.size = j2;
            this.offset = j3;
            this.boundary = j4;
        }

        public final long getEntryCount() {
            return this.entryCount;
        }

        public final long getSize() {
            return this.size;
        }

        public final long getOffset() {
            return this.offset;
        }

        public final long getBoundary() {
            return this.boundary;
        }
    }
}
