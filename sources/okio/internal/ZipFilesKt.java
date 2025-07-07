package okio.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.BufferedSource;
import okio.FileHandle;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.ZipFileSystem;
/* compiled from: ZipFiles.kt */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a.\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0000\u001a\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00170\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u001cH\u0002\u001a\f\u0010\u001d\u001a\u00020\u0017*\u00020\u001eH\u0000\u001a\f\u0010\u001f\u001a\u00020 *\u00020\u001eH\u0002\u001a\u0014\u0010!\u001a\u00020 *\u00020\u001e2\u0006\u0010\"\u001a\u00020 H\u0002\u001a.\u0010#\u001a\u00020$*\u00020\u001e2\u0006\u0010%\u001a\u00020\u00012\u0018\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020$0'H\u0002\u001a\f\u0010(\u001a\u00020$*\u00020\u001eH\u0000\u001a\u0014\u0010)\u001a\u00020\u0017*\u00020\u001e2\u0006\u0010*\u001a\u00020\u0017H\u0000\u001a\u0018\u0010+\u001a\u0004\u0018\u00010\u0017*\u00020\u001e2\b\u0010*\u001a\u0004\u0018\u00010\u0017H\u0002\u001a\u0010\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000bH\u0000\u001a\u001f\u0010.\u001a\u0004\u0018\u00010\u000b2\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u0001H\u0000¢\u0006\u0002\u00101\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u00102\u001a\u000203*\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00066"}, d2 = {"LOCAL_FILE_HEADER_SIGNATURE", "", "CENTRAL_FILE_HEADER_SIGNATURE", "END_OF_CENTRAL_DIRECTORY_SIGNATURE", "ZIP64_LOCATOR_SIGNATURE", "ZIP64_EOCD_RECORD_SIGNATURE", "COMPRESSION_METHOD_DEFLATED", "COMPRESSION_METHOD_STORED", "BIT_FLAG_ENCRYPTED", "BIT_FLAG_UNSUPPORTED_MASK", "MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE", "", "HEADER_ID_ZIP64_EXTENDED_INFO", "HEADER_ID_NTFS_EXTRA", "HEADER_ID_EXTENDED_TIMESTAMP", "openZip", "Lokio/ZipFileSystem;", "zipPath", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "predicate", "Lkotlin/Function1;", "Lokio/internal/ZipEntry;", "", "buildIndex", "", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "readCentralDirectoryZipEntry", "Lokio/BufferedSource;", "readEocdRecord", "Lokio/internal/EocdRecord;", "readZip64EocdRecord", "regularRecord", "readExtra", "", "extraSize", "block", "Lkotlin/Function2;", "skipLocalHeader", "readLocalHeader", "centralDirectoryZipEntry", "readOrSkipLocalHeader", "filetimeToEpochMillis", "filetime", "dosDateTimeToEpochMillis", "date", "time", "(II)Ljava/lang/Long;", "hex", "", "getHex", "(I)Ljava/lang/String;", "okio"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ZipFilesKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    private static final int HEADER_ID_NTFS_EXTRA = 10;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 4294967295L;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;

    public static final boolean openZip$lambda$0(ZipEntry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    public static /* synthetic */ ZipFileSystem openZip$default(Path path, FileSystem fileSystem, Function1 function1, int i, Object obj) throws IOException {
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: okio.internal.ZipFilesKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    boolean openZip$lambda$0;
                    openZip$lambda$0 = ZipFilesKt.openZip$lambda$0((ZipEntry) obj2);
                    return Boolean.valueOf(openZip$lambda$0);
                }
            };
        }
        return openZip(path, fileSystem, function1);
    }

    public static final ZipFileSystem openZip(Path zipPath, FileSystem fileSystem, Function1<? super ZipEntry, Boolean> predicate) throws IOException {
        int readIntLe;
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        FileHandle openReadOnly = fileSystem.openReadOnly(zipPath);
        try {
            FileHandle fileHandle = openReadOnly;
            long size = fileHandle.size() - 22;
            long j = 0;
            if (size < 0) {
                throw new IOException("not a zip: size=" + fileHandle.size());
            }
            long max = Math.max(size - PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH, 0L);
            while (true) {
                BufferedSource buffer = Okio.buffer(fileHandle.source(size));
                if (buffer.readIntLe() == END_OF_CENTRAL_DIRECTORY_SIGNATURE) {
                    EocdRecord readEocdRecord = readEocdRecord(buffer);
                    String readUtf8 = buffer.readUtf8(readEocdRecord.getCommentByteCount());
                    buffer.close();
                    long j2 = size - 20;
                    Throwable th = null;
                    if (j2 > j) {
                        BufferedSource buffer2 = Okio.buffer(fileHandle.source(j2));
                        BufferedSource bufferedSource = buffer2;
                        if (bufferedSource.readIntLe() == ZIP64_LOCATOR_SIGNATURE) {
                            int readIntLe2 = bufferedSource.readIntLe();
                            long readLongLe = bufferedSource.readLongLe();
                            if (bufferedSource.readIntLe() != 1 || readIntLe2 != 0) {
                                throw new IOException("unsupported zip: spanned");
                            }
                            BufferedSource buffer3 = Okio.buffer(fileHandle.source(readLongLe));
                            BufferedSource bufferedSource2 = buffer3;
                            if (bufferedSource2.readIntLe() != ZIP64_EOCD_RECORD_SIGNATURE) {
                                throw new IOException("bad zip: expected " + getHex(ZIP64_EOCD_RECORD_SIGNATURE) + " but was " + getHex(readIntLe));
                            }
                            readEocdRecord = readZip64EocdRecord(bufferedSource2, readEocdRecord);
                            Unit unit = Unit.INSTANCE;
                            if (buffer3 != null) {
                                try {
                                    buffer3.close();
                                    Unit unit2 = Unit.INSTANCE;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                            th = null;
                            if (th != null) {
                                throw th;
                            }
                            Unit unit3 = unit;
                        }
                        Unit unit4 = Unit.INSTANCE;
                        if (buffer2 != null) {
                            try {
                                buffer2.close();
                                Unit unit5 = Unit.INSTANCE;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        th = null;
                        if (th != null) {
                            throw th;
                        }
                        Unit unit6 = unit4;
                    }
                    ArrayList arrayList = new ArrayList();
                    BufferedSource buffer4 = Okio.buffer(fileHandle.source(readEocdRecord.getCentralDirectoryOffset()));
                    BufferedSource bufferedSource3 = buffer4;
                    long entryCount = readEocdRecord.getEntryCount();
                    for (long j3 = 0; j3 < entryCount; j3++) {
                        ZipEntry readCentralDirectoryZipEntry = readCentralDirectoryZipEntry(bufferedSource3);
                        if (readCentralDirectoryZipEntry.getOffset() >= readEocdRecord.getCentralDirectoryOffset()) {
                            throw new IOException("bad zip: local file header offset >= central directory offset");
                        }
                        if (predicate.invoke(readCentralDirectoryZipEntry).booleanValue()) {
                            arrayList.add(readCentralDirectoryZipEntry);
                        }
                    }
                    Unit unit7 = Unit.INSTANCE;
                    if (buffer4 != null) {
                        try {
                            buffer4.close();
                            Unit unit8 = Unit.INSTANCE;
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    }
                    Throwable th5 = th;
                    if (th5 != null) {
                        throw th5;
                    }
                    Unit unit9 = unit7;
                    ZipFileSystem zipFileSystem = new ZipFileSystem(zipPath, fileSystem, buildIndex(arrayList), readUtf8);
                    if (openReadOnly != null) {
                        try {
                            openReadOnly.close();
                            Unit unit10 = Unit.INSTANCE;
                        } catch (Throwable unused) {
                        }
                    }
                    return zipFileSystem;
                }
                buffer.close();
                size--;
                if (size < max) {
                    throw new IOException("not a zip: end of central directory signature not found");
                }
                j = 0;
            }
        } catch (Throwable th6) {
            if (openReadOnly != null) {
                try {
                    openReadOnly.close();
                    Unit unit11 = Unit.INSTANCE;
                } catch (Throwable th7) {
                    ExceptionsKt.addSuppressed(th6, th7);
                }
            }
            throw th6;
        }
    }

    private static final Map<Path, ZipEntry> buildIndex(List<ZipEntry> list) {
        Path path = Path.Companion.get$default(Path.Companion, RemoteSettings.FORWARD_SLASH_STRING, false, 1, (Object) null);
        Map<Path, ZipEntry> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(path, new ZipEntry(path, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, null, null, null, 65532, null)));
        for (ZipEntry zipEntry : CollectionsKt.sortedWith(list, new Comparator() { // from class: okio.internal.ZipFilesKt$buildIndex$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((ZipEntry) t).getCanonicalPath(), ((ZipEntry) t2).getCanonicalPath());
            }
        })) {
            if (mutableMapOf.put(zipEntry.getCanonicalPath(), zipEntry) == null) {
                while (true) {
                    Path parent = zipEntry.getCanonicalPath().parent();
                    if (parent != null) {
                        ZipEntry zipEntry2 = mutableMapOf.get(parent);
                        if (zipEntry2 != null) {
                            zipEntry2.getChildren().add(zipEntry.getCanonicalPath());
                            break;
                        }
                        ZipEntry zipEntry3 = new ZipEntry(parent, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, null, null, null, 65532, null);
                        mutableMapOf.put(parent, zipEntry3);
                        zipEntry3.getChildren().add(zipEntry.getCanonicalPath());
                        zipEntry = zipEntry3;
                    }
                }
            }
        }
        return mutableMapOf;
    }

    public static final ZipEntry readCentralDirectoryZipEntry(final BufferedSource bufferedSource) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe != CENTRAL_FILE_HEADER_SIGNATURE) {
            throw new IOException("bad zip: expected " + getHex(CENTRAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
        }
        bufferedSource.skip(4L);
        short readShortLe = bufferedSource.readShortLe();
        int i = readShortLe & UShort.MAX_VALUE;
        if ((readShortLe & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(i));
        }
        int readShortLe2 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        int readShortLe3 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        int readShortLe4 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        long readIntLe2 = bufferedSource.readIntLe() & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = bufferedSource.readIntLe() & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        final Ref.LongRef longRef2 = new Ref.LongRef();
        longRef2.element = bufferedSource.readIntLe() & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        int readShortLe5 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        int readShortLe6 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        int readShortLe7 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        bufferedSource.skip(8L);
        final Ref.LongRef longRef3 = new Ref.LongRef();
        longRef3.element = bufferedSource.readIntLe() & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        String readUtf8 = bufferedSource.readUtf8(readShortLe5);
        if (StringsKt.contains$default((CharSequence) readUtf8, (char) 0, false, 2, (Object) null)) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        long j = longRef2.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? 8 : 0L;
        long j2 = longRef.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? j + 8 : j;
        if (longRef3.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
            j2 += 8;
        }
        final long j3 = j2;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        readExtra(bufferedSource, readShortLe6, new Function2() { // from class: okio.internal.ZipFilesKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit readCentralDirectoryZipEntry$lambda$8;
                readCentralDirectoryZipEntry$lambda$8 = ZipFilesKt.readCentralDirectoryZipEntry$lambda$8(Ref.BooleanRef.this, j3, longRef2, bufferedSource, longRef, longRef3, objectRef, objectRef2, objectRef3, ((Integer) obj).intValue(), ((Long) obj2).longValue());
                return readCentralDirectoryZipEntry$lambda$8;
            }
        });
        if (j3 > 0 && !booleanRef.element) {
            throw new IOException("bad zip: zip64 extra required but absent");
        }
        return new ZipEntry(Path.Companion.get$default(Path.Companion, RemoteSettings.FORWARD_SLASH_STRING, false, 1, (Object) null).resolve(readUtf8), StringsKt.endsWith$default(readUtf8, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null), bufferedSource.readUtf8(readShortLe7), readIntLe2, longRef.element, longRef2.element, readShortLe2, longRef3.element, readShortLe4, readShortLe3, (Long) objectRef.element, (Long) objectRef2.element, (Long) objectRef3.element, null, null, null, 57344, null);
    }

    public static final Unit readCentralDirectoryZipEntry$lambda$8(Ref.BooleanRef booleanRef, long j, Ref.LongRef longRef, final BufferedSource bufferedSource, Ref.LongRef longRef2, Ref.LongRef longRef3, final Ref.ObjectRef objectRef, final Ref.ObjectRef objectRef2, final Ref.ObjectRef objectRef3, int i, long j2) {
        if (i != 1) {
            if (i == 10) {
                if (j2 < 4) {
                    throw new IOException("bad zip: NTFS extra too short");
                }
                bufferedSource.skip(4L);
                readExtra(bufferedSource, (int) (j2 - 4), new Function2() { // from class: okio.internal.ZipFilesKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit readCentralDirectoryZipEntry$lambda$8$lambda$7;
                        readCentralDirectoryZipEntry$lambda$8$lambda$7 = ZipFilesKt.readCentralDirectoryZipEntry$lambda$8$lambda$7(Ref.ObjectRef.this, bufferedSource, objectRef2, objectRef3, ((Integer) obj).intValue(), ((Long) obj2).longValue());
                        return readCentralDirectoryZipEntry$lambda$8$lambda$7;
                    }
                });
            }
        } else if (booleanRef.element) {
            throw new IOException("bad zip: zip64 extra repeated");
        } else {
            booleanRef.element = true;
            if (j2 < j) {
                throw new IOException("bad zip: zip64 extra too short");
            }
            longRef.element = longRef.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? bufferedSource.readLongLe() : longRef.element;
            longRef2.element = longRef2.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? bufferedSource.readLongLe() : 0L;
            longRef3.element = longRef3.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? bufferedSource.readLongLe() : 0L;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [T, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r2v6, types: [T, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.Long] */
    public static final Unit readCentralDirectoryZipEntry$lambda$8$lambda$7(Ref.ObjectRef objectRef, BufferedSource bufferedSource, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, int i, long j) {
        if (i == 1) {
            if (objectRef.element != 0) {
                throw new IOException("bad zip: NTFS extra attribute tag 0x0001 repeated");
            }
            if (j != 24) {
                throw new IOException("bad zip: NTFS extra attribute tag 0x0001 size != 24");
            }
            objectRef.element = Long.valueOf(bufferedSource.readLongLe());
            objectRef2.element = Long.valueOf(bufferedSource.readLongLe());
            objectRef3.element = Long.valueOf(bufferedSource.readLongLe());
        }
        return Unit.INSTANCE;
    }

    private static final EocdRecord readEocdRecord(BufferedSource bufferedSource) throws IOException {
        int readShortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        int readShortLe2 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        long readShortLe3 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        if (readShortLe3 != (bufferedSource.readShortLe() & UShort.MAX_VALUE) || readShortLe != 0 || readShortLe2 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        bufferedSource.skip(4L);
        return new EocdRecord(readShortLe3, MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE & bufferedSource.readIntLe(), bufferedSource.readShortLe() & UShort.MAX_VALUE);
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource bufferedSource, EocdRecord eocdRecord) throws IOException {
        bufferedSource.skip(12L);
        int readIntLe = bufferedSource.readIntLe();
        int readIntLe2 = bufferedSource.readIntLe();
        long readLongLe = bufferedSource.readLongLe();
        if (readLongLe != bufferedSource.readLongLe() || readIntLe != 0 || readIntLe2 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        bufferedSource.skip(8L);
        return new EocdRecord(readLongLe, bufferedSource.readLongLe(), eocdRecord.getCommentByteCount());
    }

    private static final void readExtra(BufferedSource bufferedSource, int i, Function2<? super Integer, ? super Long, Unit> function2) {
        long j = i;
        while (j != 0) {
            if (j < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int readShortLe = bufferedSource.readShortLe() & UShort.MAX_VALUE;
            long readShortLe2 = bufferedSource.readShortLe() & WebSocketProtocol.PAYLOAD_SHORT_MAX;
            long j2 = j - 4;
            if (j2 < readShortLe2) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            bufferedSource.require(readShortLe2);
            long size = bufferedSource.getBuffer().size();
            function2.invoke(Integer.valueOf(readShortLe), Long.valueOf(readShortLe2));
            long size2 = (bufferedSource.getBuffer().size() + readShortLe2) - size;
            int i2 = (size2 > 0L ? 1 : (size2 == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IOException("unsupported zip: too many bytes processed for " + readShortLe);
            }
            if (i2 > 0) {
                bufferedSource.getBuffer().skip(size2);
            }
            j = j2 - readShortLe2;
        }
    }

    public static final void skipLocalHeader(BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        readOrSkipLocalHeader(bufferedSource, null);
    }

    public static final ZipEntry readLocalHeader(BufferedSource bufferedSource, ZipEntry centralDirectoryZipEntry) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(centralDirectoryZipEntry, "centralDirectoryZipEntry");
        ZipEntry readOrSkipLocalHeader = readOrSkipLocalHeader(bufferedSource, centralDirectoryZipEntry);
        Intrinsics.checkNotNull(readOrSkipLocalHeader);
        return readOrSkipLocalHeader;
    }

    private static final ZipEntry readOrSkipLocalHeader(final BufferedSource bufferedSource, ZipEntry zipEntry) {
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe != LOCAL_FILE_HEADER_SIGNATURE) {
            throw new IOException("bad zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
        }
        bufferedSource.skip(2L);
        short readShortLe = bufferedSource.readShortLe();
        int i = readShortLe & UShort.MAX_VALUE;
        if ((readShortLe & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(i));
        }
        bufferedSource.skip(18L);
        long readShortLe2 = bufferedSource.readShortLe() & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        int readShortLe3 = bufferedSource.readShortLe() & UShort.MAX_VALUE;
        bufferedSource.skip(readShortLe2);
        if (zipEntry == null) {
            bufferedSource.skip(readShortLe3);
            return null;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        readExtra(bufferedSource, readShortLe3, new Function2() { // from class: okio.internal.ZipFilesKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit readOrSkipLocalHeader$lambda$10;
                readOrSkipLocalHeader$lambda$10 = ZipFilesKt.readOrSkipLocalHeader$lambda$10(BufferedSource.this, objectRef, objectRef2, objectRef3, ((Integer) obj).intValue(), ((Long) obj2).longValue());
                return readOrSkipLocalHeader$lambda$10;
            }
        });
        return zipEntry.copy$okio((Integer) objectRef.element, (Integer) objectRef2.element, (Integer) objectRef3.element);
    }

    /* JADX WARN: Type inference failed for: r10v2, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r13v6, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r9v5, types: [T, java.lang.Integer] */
    public static final Unit readOrSkipLocalHeader$lambda$10(BufferedSource bufferedSource, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, int i, long j) {
        if (i == HEADER_ID_EXTENDED_TIMESTAMP) {
            if (j < 1) {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            byte readByte = bufferedSource.readByte();
            boolean z = (readByte & 1) == 1;
            boolean z2 = (readByte & 2) == 2;
            boolean z3 = (readByte & 4) == 4;
            long j2 = z ? 5L : 1L;
            if (z2) {
                j2 += 4;
            }
            if (z3) {
                j2 += 4;
            }
            if (j < j2) {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            if (z) {
                objectRef.element = Integer.valueOf(bufferedSource.readIntLe());
            }
            if (z2) {
                objectRef2.element = Integer.valueOf(bufferedSource.readIntLe());
            }
            if (z3) {
                objectRef3.element = Integer.valueOf(bufferedSource.readIntLe());
            }
        }
        return Unit.INSTANCE;
    }

    public static final long filetimeToEpochMillis(long j) {
        return (j / 10000) - 11644473600000L;
    }

    public static final Long dosDateTimeToEpochMillis(int i, int i2) {
        if (i2 == -1) {
            return null;
        }
        return Long.valueOf(_ZlibJvmKt.datePartsToEpochMillis(((i >> 9) & 127) + 1980, (i >> 5) & 15, i & 31, (i2 >> 11) & 31, (i2 >> 5) & 63, (i2 & 31) << 1));
    }

    private static final String getHex(int i) {
        StringBuilder sb = new StringBuilder("0x");
        String num = Integer.toString(i, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        return sb.append(num).toString();
    }
}
