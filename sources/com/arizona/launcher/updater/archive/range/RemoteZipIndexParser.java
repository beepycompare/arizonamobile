package com.arizona.launcher.updater.archive.range;

import androidx.collection.SieveCacheKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.launcher.updater.archive.range.RemoteZipDirectoryLocationResult;
import com.arizona.launcher.updater.archive.range.RemoteZipIndexParseResult;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: RemoteZipIndexParser.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 K2\u00020\u0001:\u0002JKB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fJ0\u0010\u0012\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J0\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J \u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J0\u0010&\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J \u0010'\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J(\u0010(\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J(\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0014H\u0002J\u0018\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%H\u0002JT\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u0002042\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u000204062\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u000204062\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c06H\u0002J$\u00109\u001a\u00020\u00172\u0006\u00103\u001a\u0002042\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0:H\u0002J \u0010;\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\u0014H\u0002J \u0010>\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\u0014H\u0002J$\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0018\u0010B\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010C\u001a\u00020\t2\u0006\u0010+\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0002J\u001c\u0010H\u001a\u00020I2\u0006\u0010F\u001a\u00020G2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\bM\u0012\b\bN\u0012\u0004\b\u0003\u0010\u0000¨\u0006L"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexParser;", "", "limits", "Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexLimits;", "<init>", "(Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexLimits;)V", "parseEocdTail", "Lcom/arizona/launcher/updater/archive/range/RemoteZipDirectoryLocationResult;", "archiveSize", "", "tailOffset", "tailBytes", "", "parseCentralDirectory", "Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexParseResult;", FirebaseAnalytics.Param.LOCATION, "Lcom/arizona/launcher/updater/archive/range/RemoteZipDirectoryLocation;", "centralDirectoryBytes", "parseEocdCandidate", TypedValues.CycleType.S_WAVE_OFFSET, "", "commentLength", "validateLocation", "", "validateFlagsAndMethod", DownloaderServiceMarshaller.PARAMS_FLAGS, FirebaseAnalytics.Param.METHOD, "entryPath", "", "validateClassicEntryFields", "compressedSize", "size", "diskStart", "localHeaderOffset", "validateEntryType", "externalAttributes", "isDirectory", "", "validateEntrySizes", "validateCompressionRatio", "validateLocalHeaderBounds", "centralDirectoryOffset", "validateExtraFields", "bytes", TtmlNode.START, TtmlNode.END, "decodeEntryName", "nameBytes", "validateAndStripPath", "rawName", "detectPathCollisions", "candidate", "Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexParser$CollisionEntry;", "seenExact", "", "seenCaseInsensitive", "directoryCasing", "rememberDirectoryCasing", "", "checkedArrayOffset", "length", "arraySize", "requireAvailable", "safeAdd", TtmlNode.LEFT, TtmlNode.RIGHT, "u16", "u32", "locationFailure", "Lcom/arizona/launcher/updater/archive/range/RemoteZipDirectoryLocationResult$Failure;", "code", "Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexErrorCode;", "fail", "", "CollisionEntry", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RemoteZipIndexParser {
    @Deprecated
    public static final int CENTRAL_ENTRY_FIXED_SIZE = 46;
    @Deprecated
    public static final long CENTRAL_ENTRY_SIGNATURE = 33639248;
    @Deprecated
    public static final int COMMENT_LENGTH_OFFSET = 32;
    @Deprecated
    public static final int COMPRESSED_SIZE_OFFSET = 20;
    private static final Charset CP437;
    @Deprecated
    public static final int CRC32_OFFSET = 16;
    @Deprecated
    public static final int DEFLATE_OPTION_FLAGS_MASK = 6;
    @Deprecated
    public static final int DISK_START_OFFSET = 34;
    @Deprecated
    public static final long DOS_DIRECTORY_ATTRIBUTE = 16;
    @Deprecated
    public static final int ENCRYPTION_FLAGS_MASK = 8257;
    @Deprecated
    public static final int EOCD_CENTRAL_DISK_OFFSET = 6;
    @Deprecated
    public static final int EOCD_CENTRAL_OFFSET_OFFSET = 16;
    @Deprecated
    public static final int EOCD_CENTRAL_SIZE_OFFSET = 12;
    @Deprecated
    public static final int EOCD_COMMENT_LENGTH_OFFSET = 20;
    @Deprecated
    public static final int EOCD_DISK_NUMBER_OFFSET = 4;
    @Deprecated
    public static final int EOCD_ENTRIES_ON_DISK_OFFSET = 8;
    @Deprecated
    public static final int EOCD_FIXED_SIZE = 22;
    @Deprecated
    public static final long EOCD_SIGNATURE = 101010256;
    @Deprecated
    public static final int EOCD_TOTAL_ENTRIES_OFFSET = 10;
    @Deprecated
    public static final int EXTERNAL_ATTRIBUTES_OFFSET = 38;
    @Deprecated
    public static final int EXTRA_FIELD_HEADER_SIZE = 4;
    @Deprecated
    public static final int EXTRA_LENGTH_OFFSET = 30;
    @Deprecated
    public static final int FLAGS_OFFSET = 8;
    @Deprecated
    public static final int LOCAL_HEADER_FIXED_SIZE = 30;
    @Deprecated
    public static final int LOCAL_HEADER_OFFSET_OFFSET = 42;
    @Deprecated
    public static final int MAX_EOCD_SEARCH_BYTES = 65557;
    @Deprecated
    public static final int MAX_ZIP_COMMENT_SIZE = 65535;
    @Deprecated
    public static final int METHOD_DEFLATED = 8;
    @Deprecated
    public static final int METHOD_OFFSET = 10;
    @Deprecated
    public static final int METHOD_STORED = 0;
    @Deprecated
    public static final int NAME_LENGTH_OFFSET = 28;
    @Deprecated
    public static final String REQUIRED_PREFIX = "files/";
    @Deprecated
    public static final int SIZE_OFFSET = 24;
    @Deprecated
    public static final int U16_MAX = 65535;
    @Deprecated
    public static final long U32_MAX = 4294967295L;
    @Deprecated
    public static final int UNIX_DIRECTORY = 16384;
    @Deprecated
    public static final int UNIX_FILE_TYPE_MASK = 61440;
    @Deprecated
    public static final int UNIX_REGULAR_FILE = 32768;
    @Deprecated
    public static final int UNIX_SYMLINK = 40960;
    @Deprecated
    public static final int UNSUPPORTED_FLAGS_MASK = 63473;
    @Deprecated
    public static final int UTF8_FLAG = 2048;
    @Deprecated
    public static final int ZIP64_EXTRA_FIELD_ID = 1;
    private final RemoteZipIndexLimits limits;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = RemoteZipIndexLimits.$stable;
    private static final Regex WINDOWS_ABSOLUTE_PATH = new Regex("^[A-Za-z]:[/\\\\].*");

    public RemoteZipIndexParser() {
        this(null, 1, null);
    }

    public RemoteZipIndexParser(RemoteZipIndexLimits limits) {
        Intrinsics.checkNotNullParameter(limits, "limits");
        this.limits = limits;
    }

    public /* synthetic */ RemoteZipIndexParser(RemoteZipIndexLimits remoteZipIndexLimits, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new RemoteZipIndexLimits(0, 0L, 0L, 0L, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 31, null) : remoteZipIndexLimits);
    }

    public final RemoteZipDirectoryLocationResult parseEocdTail(long j, long j2, byte[] bArr) {
        RemoteZipIndexErrorCode remoteZipIndexErrorCode;
        byte[] tailBytes = bArr;
        Intrinsics.checkNotNullParameter(tailBytes, "tailBytes");
        if (j < 0 || j2 < 0 || j2 > j || tailBytes.length != j - j2) {
            return locationFailure(RemoteZipIndexErrorCode.TAIL_IS_NOT_ARCHIVE_SUFFIX);
        }
        if (j < 22 || tailBytes.length < 22) {
            return locationFailure(RemoteZipIndexErrorCode.EOCD_NOT_FOUND);
        }
        int max = Math.max(0, tailBytes.length - MAX_EOCD_SEARCH_BYTES);
        int length = tailBytes.length - 22;
        RemoteZipParseFailure remoteZipParseFailure = null;
        if (max <= length) {
            int i = length;
            RemoteZipParseFailure remoteZipParseFailure2 = null;
            while (true) {
                if (u32(tailBytes, i) == EOCD_SIGNATURE) {
                    int u16 = u16(tailBytes, i + 20);
                    if (i + 22 + u16 == tailBytes.length) {
                        try {
                            return new RemoteZipDirectoryLocationResult.Success(parseEocdCandidate(j, j2, tailBytes, i, u16));
                        } catch (RemoteZipParseFailure e) {
                            if (remoteZipParseFailure2 == null) {
                                remoteZipParseFailure2 = e;
                            }
                        }
                    }
                }
                if (i == max) {
                    remoteZipParseFailure = remoteZipParseFailure2;
                    break;
                }
                i--;
                tailBytes = bArr;
            }
        }
        if (remoteZipParseFailure == null || (remoteZipIndexErrorCode = remoteZipParseFailure.getCode()) == null) {
            remoteZipIndexErrorCode = RemoteZipIndexErrorCode.EOCD_NOT_FOUND;
        }
        return locationFailure(remoteZipIndexErrorCode);
    }

    public final RemoteZipIndexParseResult parseCentralDirectory(RemoteZipDirectoryLocation location, byte[] centralDirectoryBytes) {
        long j;
        RemoteZipIndexParser remoteZipIndexParser = this;
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(centralDirectoryBytes, "centralDirectoryBytes");
        try {
            validateLocation(location);
            if (centralDirectoryBytes.length != location.getCentralDirectorySize()) {
                fail$default(remoteZipIndexParser, RemoteZipIndexErrorCode.CENTRAL_DIRECTORY_LENGTH_MISMATCH, null, 2, null);
                throw new KotlinNothingValueException();
            }
            ArrayList arrayList = new ArrayList(location.getEntryCount());
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            HashSet hashSet = new HashSet();
            int entryCount = location.getEntryCount();
            long j2 = 0;
            int i = 0;
            int i2 = 0;
            while (i < entryCount) {
                remoteZipIndexParser.requireAvailable(centralDirectoryBytes, i2, 46);
                if (remoteZipIndexParser.u32(centralDirectoryBytes, i2) != CENTRAL_ENTRY_SIGNATURE) {
                    fail$default(remoteZipIndexParser, RemoteZipIndexErrorCode.MALFORMED_CENTRAL_DIRECTORY, null, 2, null);
                    throw new KotlinNothingValueException();
                }
                int u16 = remoteZipIndexParser.u16(centralDirectoryBytes, i2 + 8);
                int u162 = remoteZipIndexParser.u16(centralDirectoryBytes, i2 + 10);
                long u32 = remoteZipIndexParser.u32(centralDirectoryBytes, i2 + 16);
                long u322 = remoteZipIndexParser.u32(centralDirectoryBytes, i2 + 20);
                long u323 = remoteZipIndexParser.u32(centralDirectoryBytes, i2 + 24);
                int u163 = remoteZipIndexParser.u16(centralDirectoryBytes, i2 + 28);
                int u164 = remoteZipIndexParser.u16(centralDirectoryBytes, i2 + 30);
                int u165 = remoteZipIndexParser.u16(centralDirectoryBytes, i2 + 32);
                int u166 = remoteZipIndexParser.u16(centralDirectoryBytes, i2 + 34);
                HashSet hashSet2 = hashSet;
                ArrayList arrayList2 = arrayList;
                long u324 = remoteZipIndexParser.u32(centralDirectoryBytes, i2 + 38);
                long u325 = remoteZipIndexParser.u32(centralDirectoryBytes, i2 + 42);
                int i3 = i2 + 46;
                int checkedArrayOffset = remoteZipIndexParser.checkedArrayOffset(i3, u163, centralDirectoryBytes.length);
                int checkedArrayOffset2 = remoteZipIndexParser.checkedArrayOffset(checkedArrayOffset, u164, centralDirectoryBytes.length);
                int checkedArrayOffset3 = remoteZipIndexParser.checkedArrayOffset(checkedArrayOffset2, u165, centralDirectoryBytes.length);
                String decodeEntryName = remoteZipIndexParser.decodeEntryName(ArraysKt.copyOfRange(centralDirectoryBytes, i3, checkedArrayOffset), u16);
                remoteZipIndexParser.validateExtraFields(centralDirectoryBytes, checkedArrayOffset, checkedArrayOffset2, decodeEntryName);
                remoteZipIndexParser.validateFlagsAndMethod(u16, u162, decodeEntryName);
                int i4 = entryCount;
                int i5 = i;
                remoteZipIndexParser.validateClassicEntryFields(u322, u323, u166, u325, decodeEntryName);
                boolean endsWith$default = StringsKt.endsWith$default((CharSequence) decodeEntryName, '/', false, 2, (Object) null);
                String validateAndStripPath = remoteZipIndexParser.validateAndStripPath(decodeEntryName, endsWith$default);
                remoteZipIndexParser.validateEntryType(u324, endsWith$default, decodeEntryName);
                remoteZipIndexParser.validateEntrySizes(u323, u322, u162, endsWith$default, decodeEntryName);
                validateLocalHeaderBounds(u325, u322, location.getCentralDirectoryOffset(), decodeEntryName);
                if (!hashSet2.add(Long.valueOf(u325))) {
                    fail(RemoteZipIndexErrorCode.LOCAL_HEADER_BOUNDS_INVALID, decodeEntryName);
                    throw new KotlinNothingValueException();
                }
                CollisionEntry collisionEntry = new CollisionEntry(validateAndStripPath, endsWith$default);
                remoteZipIndexParser = this;
                remoteZipIndexParser.detectPathCollisions(collisionEntry, decodeEntryName, hashMap, hashMap2, hashMap3);
                if (endsWith$default) {
                    j = u322;
                } else if (u323 > remoteZipIndexParser.limits.getMaxEntryUncompressedBytes()) {
                    remoteZipIndexParser.fail(RemoteZipIndexErrorCode.ENTRY_SIZE_LIMIT_EXCEEDED, decodeEntryName);
                    throw new KotlinNothingValueException();
                } else if (j2 > remoteZipIndexParser.limits.getMaxTotalUncompressedBytes() - u323) {
                    remoteZipIndexParser.fail(RemoteZipIndexErrorCode.TOTAL_SIZE_LIMIT_EXCEEDED, decodeEntryName);
                    throw new KotlinNothingValueException();
                } else {
                    j2 += u323;
                    j = u322;
                    remoteZipIndexParser.validateCompressionRatio(u323, j, decodeEntryName);
                }
                arrayList2.add(new RemoteZipEntry(decodeEntryName, validateAndStripPath, endsWith$default, u323, j, u32, u162, u16, u325));
                hashMap.put(validateAndStripPath, collisionEntry);
                Locale ROOT = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                String lowerCase = validateAndStripPath.toLowerCase(ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                hashMap2.put(lowerCase, collisionEntry);
                remoteZipIndexParser.rememberDirectoryCasing(collisionEntry, hashMap3);
                i = i5 + 1;
                hashSet = hashSet2;
                entryCount = i4;
                arrayList = arrayList2;
                i2 = checkedArrayOffset3;
            }
            ArrayList arrayList3 = arrayList;
            if (i2 != centralDirectoryBytes.length) {
                fail$default(remoteZipIndexParser, RemoteZipIndexErrorCode.MALFORMED_CENTRAL_DIRECTORY, null, 2, null);
                throw new KotlinNothingValueException();
            }
            return new RemoteZipIndexParseResult.Success(new RemoteZipIndex(location.getArchiveSize(), location.getCentralDirectoryOffset(), location.getCentralDirectorySize(), Sha256Digest.Companion.calculate(centralDirectoryBytes), CollectionsKt.toList(arrayList3), j2));
        } catch (RemoteZipParseFailure e) {
            return new RemoteZipIndexParseResult.Failure(e.getCode(), e.getEntryPath());
        }
    }

    private final RemoteZipDirectoryLocation parseEocdCandidate(long j, long j2, byte[] bArr, int i, int i2) {
        RemoteZipIndexParser remoteZipIndexParser;
        int u16 = u16(bArr, i + 4);
        int u162 = u16(bArr, i + 6);
        int u163 = u16(bArr, i + 8);
        int u164 = u16(bArr, i + 10);
        long u32 = u32(bArr, i + 12);
        long u322 = u32(bArr, i + 16);
        if (u16 != 0 || u162 != 0 || u163 != u164) {
            fail$default(this, RemoteZipIndexErrorCode.MULTI_DISK_ARCHIVE_UNSUPPORTED, null, 2, null);
            throw new KotlinNothingValueException();
        } else if (u163 == 65535 || u164 == 65535 || u32 == 4294967295L || u322 == 4294967295L) {
            fail$default(this, RemoteZipIndexErrorCode.ZIP64_UNSUPPORTED, null, 2, null);
            throw new KotlinNothingValueException();
        } else if (u164 == 0) {
            fail$default(this, RemoteZipIndexErrorCode.EMPTY_ARCHIVE, null, 2, null);
            throw new KotlinNothingValueException();
        } else if (u164 > this.limits.getMaxEntryCount()) {
            fail$default(this, RemoteZipIndexErrorCode.ENTRY_COUNT_LIMIT_EXCEEDED, null, 2, null);
            throw new KotlinNothingValueException();
        } else if (u32 > this.limits.getMaxCentralDirectoryBytes() || u32 > SieveCacheKt.NodeLinkMask) {
            fail$default(this, RemoteZipIndexErrorCode.CENTRAL_DIRECTORY_SIZE_LIMIT_EXCEEDED, null, 2, null);
            throw new KotlinNothingValueException();
        } else if (u32 < u164 * 46) {
            fail$default(this, RemoteZipIndexErrorCode.CENTRAL_DIRECTORY_BOUNDS_INVALID, null, 2, null);
            throw new KotlinNothingValueException();
        } else {
            long safeAdd$default = safeAdd$default(this, j2, i, null, 4, null);
            if (safeAdd$default(this, u322, u32, null, 4, null) == safeAdd$default) {
                remoteZipIndexParser = this;
                if (safeAdd$default(remoteZipIndexParser, safeAdd$default(remoteZipIndexParser, safeAdd$default, 22L, null, 4, null), i2, null, 4, null) == j) {
                    return new RemoteZipDirectoryLocation(j, safeAdd$default, u322, u32, u164, i2);
                }
            } else {
                remoteZipIndexParser = this;
            }
            fail$default(remoteZipIndexParser, RemoteZipIndexErrorCode.CENTRAL_DIRECTORY_BOUNDS_INVALID, null, 2, null);
            throw new KotlinNothingValueException();
        }
    }

    private final void validateLocation(RemoteZipDirectoryLocation remoteZipDirectoryLocation) {
        int commentLength;
        if (remoteZipDirectoryLocation.getArchiveSize() < 0 || remoteZipDirectoryLocation.getEocdOffset() < 0 || remoteZipDirectoryLocation.getCentralDirectoryOffset() < 0 || remoteZipDirectoryLocation.getCentralDirectorySize() < 0 || (commentLength = remoteZipDirectoryLocation.getCommentLength()) < 0 || commentLength >= 65536) {
            fail$default(this, RemoteZipIndexErrorCode.CENTRAL_DIRECTORY_BOUNDS_INVALID, null, 2, null);
            throw new KotlinNothingValueException();
        } else if (remoteZipDirectoryLocation.getEntryCount() <= 0) {
            fail$default(this, RemoteZipIndexErrorCode.EMPTY_ARCHIVE, null, 2, null);
            throw new KotlinNothingValueException();
        } else if (remoteZipDirectoryLocation.getEntryCount() > this.limits.getMaxEntryCount()) {
            fail$default(this, RemoteZipIndexErrorCode.ENTRY_COUNT_LIMIT_EXCEEDED, null, 2, null);
            throw new KotlinNothingValueException();
        } else if (remoteZipDirectoryLocation.getCentralDirectorySize() > this.limits.getMaxCentralDirectoryBytes() || remoteZipDirectoryLocation.getCentralDirectorySize() > SieveCacheKt.NodeLinkMask) {
            fail$default(this, RemoteZipIndexErrorCode.CENTRAL_DIRECTORY_SIZE_LIMIT_EXCEEDED, null, 2, null);
            throw new KotlinNothingValueException();
        } else {
            long safeAdd$default = safeAdd$default(this, remoteZipDirectoryLocation.getCentralDirectoryOffset(), remoteZipDirectoryLocation.getCentralDirectorySize(), null, 4, null);
            long safeAdd$default2 = safeAdd$default(this, safeAdd$default(this, remoteZipDirectoryLocation.getEocdOffset(), 22L, null, 4, null), remoteZipDirectoryLocation.getCommentLength(), null, 4, null);
            long entryCount = remoteZipDirectoryLocation.getEntryCount() * 46;
            if (safeAdd$default == remoteZipDirectoryLocation.getEocdOffset() && safeAdd$default2 == remoteZipDirectoryLocation.getArchiveSize() && remoteZipDirectoryLocation.getCentralDirectorySize() >= entryCount) {
                return;
            }
            fail$default(this, RemoteZipIndexErrorCode.CENTRAL_DIRECTORY_BOUNDS_INVALID, null, 2, null);
            throw new KotlinNothingValueException();
        }
    }

    private final void validateFlagsAndMethod(int i, int i2, String str) {
        if ((i & 8257) != 0) {
            fail(RemoteZipIndexErrorCode.ENCRYPTED_ENTRY, str);
            throw new KotlinNothingValueException();
        } else if ((63473 & i) != 0) {
            fail(RemoteZipIndexErrorCode.UNSUPPORTED_ENTRY_FLAGS, str);
            throw new KotlinNothingValueException();
        } else if (i2 != 8 && (i & 6) != 0) {
            fail(RemoteZipIndexErrorCode.UNSUPPORTED_ENTRY_FLAGS, str);
            throw new KotlinNothingValueException();
        } else if (i2 == 0 || i2 == 8) {
        } else {
            fail(RemoteZipIndexErrorCode.UNSUPPORTED_COMPRESSION_METHOD, str);
            throw new KotlinNothingValueException();
        }
    }

    private final void validateClassicEntryFields(long j, long j2, int i, long j3, String str) {
        if (j == 4294967295L || j2 == 4294967295L || i == 65535 || j3 == 4294967295L) {
            fail(RemoteZipIndexErrorCode.ZIP64_UNSUPPORTED, str);
            throw new KotlinNothingValueException();
        } else if (i == 0) {
        } else {
            fail(RemoteZipIndexErrorCode.MULTI_DISK_ARCHIVE_UNSUPPORTED, str);
            throw new KotlinNothingValueException();
        }
    }

    private final void validateEntryType(long j, boolean z, String str) {
        int i = ((int) ((j >>> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX)) & 61440;
        if (i != 0) {
            if (i != 16384) {
                if (i != 32768) {
                    if (i == 40960) {
                        fail(RemoteZipIndexErrorCode.SYMLINK_ENTRY, str);
                        throw new KotlinNothingValueException();
                    } else {
                        fail(RemoteZipIndexErrorCode.UNSUPPORTED_ENTRY_TYPE, str);
                        throw new KotlinNothingValueException();
                    }
                } else if (z) {
                    fail(RemoteZipIndexErrorCode.ENTRY_TYPE_MISMATCH, str);
                    throw new KotlinNothingValueException();
                }
            } else if (!z) {
                fail(RemoteZipIndexErrorCode.ENTRY_TYPE_MISMATCH, str);
                throw new KotlinNothingValueException();
            }
        }
        if ((j & 16) == 0 || z) {
            return;
        }
        fail(RemoteZipIndexErrorCode.ENTRY_TYPE_MISMATCH, str);
        throw new KotlinNothingValueException();
    }

    private final void validateEntrySizes(long j, long j2, int i, boolean z, String str) {
        if (z && (j != 0 || j2 != 0)) {
            fail(RemoteZipIndexErrorCode.DIRECTORY_HAS_DATA, str);
            throw new KotlinNothingValueException();
        } else if (i != 0 || j == j2) {
        } else {
            fail(RemoteZipIndexErrorCode.ENTRY_METADATA_INCONSISTENT, str);
            throw new KotlinNothingValueException();
        }
    }

    private final void validateCompressionRatio(long j, long j2, String str) {
        if (j == 0) {
            return;
        }
        if (j2 == 0) {
            fail(RemoteZipIndexErrorCode.COMPRESSION_RATIO_LIMIT_EXCEEDED, str);
            throw new KotlinNothingValueException();
        }
        double d = j / j2;
        if (Math.abs(d) > Double.MAX_VALUE || d > this.limits.getMaxCompressionRatio()) {
            fail(RemoteZipIndexErrorCode.COMPRESSION_RATIO_LIMIT_EXCEEDED, str);
            throw new KotlinNothingValueException();
        }
    }

    private final void validateLocalHeaderBounds(long j, long j2, long j3, String str) {
        long safeAdd = safeAdd(j, 30L, str);
        long safeAdd2 = safeAdd(safeAdd, j2, str);
        if (safeAdd > j3 || safeAdd2 > j3) {
            fail(RemoteZipIndexErrorCode.LOCAL_HEADER_BOUNDS_INVALID, str);
            throw new KotlinNothingValueException();
        }
    }

    private final void validateExtraFields(byte[] bArr, int i, int i2, String str) {
        while (i < i2) {
            if (i2 - i < 4) {
                fail(RemoteZipIndexErrorCode.MALFORMED_CENTRAL_DIRECTORY, str);
                throw new KotlinNothingValueException();
            }
            int u16 = u16(bArr, i);
            int u162 = u16(bArr, i + 2);
            int i3 = i + 4;
            if (u162 > i2 - i3) {
                fail(RemoteZipIndexErrorCode.MALFORMED_CENTRAL_DIRECTORY, str);
                throw new KotlinNothingValueException();
            } else if (u16 == 1) {
                fail(RemoteZipIndexErrorCode.ZIP64_UNSUPPORTED, str);
                throw new KotlinNothingValueException();
            } else {
                i = i3 + u162;
            }
        }
    }

    private final String decodeEntryName(byte[] bArr, int i) {
        try {
            String charBuffer = ((i & 2048) != 0 ? StandardCharsets.UTF_8 : CP437).newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(bArr)).toString();
            Intrinsics.checkNotNull(charBuffer);
            return charBuffer;
        } catch (CharacterCodingException unused) {
            fail$default(this, RemoteZipIndexErrorCode.ENTRY_NAME_INVALID_ENCODING, null, 2, null);
            throw new KotlinNothingValueException();
        }
    }

    private final String validateAndStripPath(String str, boolean z) {
        String str2 = str;
        if (str2.length() == 0) {
            fail(RemoteZipIndexErrorCode.ENTRY_NAME_EMPTY, str);
            throw new KotlinNothingValueException();
        } else if (StringsKt.contains$default((CharSequence) str2, (char) 0, false, 2, (Object) null)) {
            fail(RemoteZipIndexErrorCode.ENTRY_NAME_CONTAINS_NUL, str);
            throw new KotlinNothingValueException();
        } else if (StringsKt.contains$default((CharSequence) str2, (char) AbstractJsonLexerKt.STRING_ESC, false, 2, (Object) null)) {
            fail(RemoteZipIndexErrorCode.ENTRY_NAME_CONTAINS_BACKSLASH, str);
            throw new KotlinNothingValueException();
        } else if (StringsKt.startsWith$default((CharSequence) str2, '/', false, 2, (Object) null) || WINDOWS_ABSOLUTE_PATH.matches(str2)) {
            fail(RemoteZipIndexErrorCode.ABSOLUTE_ENTRY_PATH, str);
            throw new KotlinNothingValueException();
        } else if (!StringsKt.startsWith$default(str, "files/", false, 2, (Object) null)) {
            fail(RemoteZipIndexErrorCode.ENTRY_PREFIX_INVALID, str);
            throw new KotlinNothingValueException();
        } else {
            String removePrefix = StringsKt.removePrefix(str, (CharSequence) "files/");
            if (z) {
                removePrefix = StringsKt.dropLast(removePrefix, 1);
            }
            String str3 = removePrefix;
            if (str3.length() == 0) {
                fail(RemoteZipIndexErrorCode.ENTRY_NAME_EMPTY, str);
                throw new KotlinNothingValueException();
            }
            List<String> split$default = StringsKt.split$default((CharSequence) str3, new char[]{'/'}, false, 0, 6, (Object) null);
            for (String str4 : split$default) {
                if (str4.length() == 0) {
                    fail(RemoteZipIndexErrorCode.EMPTY_PATH_SEGMENT, str);
                    throw new KotlinNothingValueException();
                } else if (Intrinsics.areEqual(str4, ".")) {
                    fail(RemoteZipIndexErrorCode.DOT_PATH_SEGMENT, str);
                    throw new KotlinNothingValueException();
                } else if (Intrinsics.areEqual(str4, "..")) {
                    fail(RemoteZipIndexErrorCode.PATH_TRAVERSAL, str);
                    throw new KotlinNothingValueException();
                }
            }
            return CollectionsKt.joinToString$default(split$default, "/", null, null, 0, null, null, 62, null);
        }
    }

    private final void detectPathCollisions(CollisionEntry collisionEntry, String str, Map<String, CollisionEntry> map, Map<String, CollisionEntry> map2, Map<String, String> map3) {
        RemoteZipIndexErrorCode remoteZipIndexErrorCode;
        CollisionEntry collisionEntry2 = map.get(collisionEntry.getTarget());
        if (collisionEntry2 != null) {
            if (collisionEntry2.isDirectory() != collisionEntry.isDirectory()) {
                remoteZipIndexErrorCode = RemoteZipIndexErrorCode.FILE_DIRECTORY_COLLISION;
            } else {
                remoteZipIndexErrorCode = RemoteZipIndexErrorCode.DUPLICATE_ENTRY;
            }
            fail(remoteZipIndexErrorCode, str);
            throw new KotlinNothingValueException();
        }
        String target = collisionEntry.getTarget();
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = target.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (map2.containsKey(lowerCase)) {
            fail(RemoteZipIndexErrorCode.CASE_COLLISION, str);
            throw new KotlinNothingValueException();
        }
        String str2 = map3.get(lowerCase);
        if (str2 != null && !Intrinsics.areEqual(str2, collisionEntry.getTarget())) {
            fail(RemoteZipIndexErrorCode.CASE_COLLISION, str);
            throw new KotlinNothingValueException();
        }
        List split$default = StringsKt.split$default((CharSequence) collisionEntry.getTarget(), new char[]{'/'}, false, 0, 6, (Object) null);
        int lastIndex = CollectionsKt.getLastIndex(split$default);
        String str3 = "";
        for (int i = 0; i < lastIndex; i++) {
            str3 = str3.length() == 0 ? (String) split$default.get(i) : str3 + "/" + split$default.get(i);
            Locale ROOT2 = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
            String lowerCase2 = str3.toLowerCase(ROOT2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            CollisionEntry collisionEntry3 = map2.get(lowerCase2);
            if (collisionEntry3 != null && !collisionEntry3.isDirectory()) {
                fail(RemoteZipIndexErrorCode.FILE_DIRECTORY_COLLISION, str);
                throw new KotlinNothingValueException();
            }
            String str4 = map3.get(lowerCase2);
            if (str4 != null && !Intrinsics.areEqual(str4, str3)) {
                fail(RemoteZipIndexErrorCode.CASE_COLLISION, str);
                throw new KotlinNothingValueException();
            }
        }
        if (collisionEntry.isDirectory()) {
            return;
        }
        String str5 = lowerCase + "/";
        Set<String> keySet = map2.keySet();
        if (!(keySet instanceof Collection) || !keySet.isEmpty()) {
            for (String str6 : keySet) {
                if (StringsKt.startsWith$default(str6, str5, false, 2, (Object) null)) {
                    break;
                }
            }
        }
        Set<String> keySet2 = map3.keySet();
        if ((keySet2 instanceof Collection) && keySet2.isEmpty()) {
            return;
        }
        for (String str7 : keySet2) {
            if (StringsKt.startsWith$default(str7, str5, false, 2, (Object) null)) {
                fail(RemoteZipIndexErrorCode.FILE_DIRECTORY_COLLISION, str);
                throw new KotlinNothingValueException();
            }
        }
    }

    private final void rememberDirectoryCasing(CollisionEntry collisionEntry, Map<String, String> map) {
        int lastIndex;
        int i = 0;
        List split$default = StringsKt.split$default((CharSequence) collisionEntry.getTarget(), new char[]{'/'}, false, 0, 6, (Object) null);
        if (collisionEntry.isDirectory()) {
            lastIndex = CollectionsKt.getLastIndex(split$default);
        } else {
            lastIndex = CollectionsKt.getLastIndex(split$default) - 1;
        }
        if (lastIndex < 0) {
            return;
        }
        String str = "";
        while (true) {
            str = str.length() == 0 ? (String) split$default.get(i) : str + "/" + split$default.get(i);
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = str.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            map.putIfAbsent(lowerCase, str);
            if (i == lastIndex) {
                return;
            }
            i++;
        }
    }

    private final int checkedArrayOffset(int i, int i2, int i3) {
        if (i < 0 || i2 < 0 || i2 > i3 - i) {
            fail$default(this, RemoteZipIndexErrorCode.MALFORMED_CENTRAL_DIRECTORY, null, 2, null);
            throw new KotlinNothingValueException();
        }
        return i + i2;
    }

    private final void requireAvailable(byte[] bArr, int i, int i2) {
        if (i < 0 || i2 < 0 || i > bArr.length || i2 > bArr.length - i) {
            fail$default(this, RemoteZipIndexErrorCode.MALFORMED_CENTRAL_DIRECTORY, null, 2, null);
            throw new KotlinNothingValueException();
        }
    }

    static /* synthetic */ long safeAdd$default(RemoteZipIndexParser remoteZipIndexParser, long j, long j2, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        return remoteZipIndexParser.safeAdd(j, j2, str);
    }

    private final long safeAdd(long j, long j2, String str) {
        if (j < 0 || j2 < 0 || j > Long.MAX_VALUE - j2) {
            fail(RemoteZipIndexErrorCode.CENTRAL_DIRECTORY_BOUNDS_INVALID, str);
            throw new KotlinNothingValueException();
        }
        return j + j2;
    }

    private final int u16(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
    }

    private final long u32(byte[] bArr, int i) {
        return ((u16(bArr, i + 2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | (u16(bArr, i) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    private final RemoteZipDirectoryLocationResult.Failure locationFailure(RemoteZipIndexErrorCode remoteZipIndexErrorCode) {
        return new RemoteZipDirectoryLocationResult.Failure(remoteZipIndexErrorCode);
    }

    static /* synthetic */ Void fail$default(RemoteZipIndexParser remoteZipIndexParser, RemoteZipIndexErrorCode remoteZipIndexErrorCode, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return remoteZipIndexParser.fail(remoteZipIndexErrorCode, str);
    }

    private final Void fail(RemoteZipIndexErrorCode remoteZipIndexErrorCode, String str) {
        throw new RemoteZipParseFailure(remoteZipIndexErrorCode, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RemoteZipIndexParser.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexParser$CollisionEntry;", "", TypedValues.AttributesType.S_TARGET, "", "isDirectory", "", "<init>", "(Ljava/lang/String;Z)V", "getTarget", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class CollisionEntry {
        private final boolean isDirectory;
        private final String target;

        public static /* synthetic */ CollisionEntry copy$default(CollisionEntry collisionEntry, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = collisionEntry.target;
            }
            if ((i & 2) != 0) {
                z = collisionEntry.isDirectory;
            }
            return collisionEntry.copy(str, z);
        }

        public final String component1() {
            return this.target;
        }

        public final boolean component2() {
            return this.isDirectory;
        }

        public final CollisionEntry copy(String target, boolean z) {
            Intrinsics.checkNotNullParameter(target, "target");
            return new CollisionEntry(target, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CollisionEntry) {
                CollisionEntry collisionEntry = (CollisionEntry) obj;
                return Intrinsics.areEqual(this.target, collisionEntry.target) && this.isDirectory == collisionEntry.isDirectory;
            }
            return false;
        }

        public int hashCode() {
            return (this.target.hashCode() * 31) + Boolean.hashCode(this.isDirectory);
        }

        public String toString() {
            String str = this.target;
            return "CollisionEntry(target=" + str + ", isDirectory=" + this.isDirectory + ")";
        }

        public CollisionEntry(String target, boolean z) {
            Intrinsics.checkNotNullParameter(target, "target");
            this.target = target;
            this.isDirectory = z;
        }

        public final String getTarget() {
            return this.target;
        }

        public final boolean isDirectory() {
            return this.isDirectory;
        }
    }

    /* compiled from: RemoteZipIndexParser.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0086T¢\u0006\u0002\n\u0000R\u0011\u00100\u001a\u000201¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u00104\u001a\u000205¢\u0006\b\n\u0000\u001a\u0004\b6\u00107¨\u00068"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexParser$Companion;", "", "<init>", "()V", "EOCD_SIGNATURE", "", "CENTRAL_ENTRY_SIGNATURE", "EOCD_FIXED_SIZE", "", "MAX_ZIP_COMMENT_SIZE", "MAX_EOCD_SEARCH_BYTES", "CENTRAL_ENTRY_FIXED_SIZE", "LOCAL_HEADER_FIXED_SIZE", "EXTRA_FIELD_HEADER_SIZE", "EOCD_DISK_NUMBER_OFFSET", "EOCD_CENTRAL_DISK_OFFSET", "EOCD_ENTRIES_ON_DISK_OFFSET", "EOCD_TOTAL_ENTRIES_OFFSET", "EOCD_CENTRAL_SIZE_OFFSET", "EOCD_CENTRAL_OFFSET_OFFSET", "EOCD_COMMENT_LENGTH_OFFSET", "FLAGS_OFFSET", "METHOD_OFFSET", "CRC32_OFFSET", "COMPRESSED_SIZE_OFFSET", "SIZE_OFFSET", "NAME_LENGTH_OFFSET", "EXTRA_LENGTH_OFFSET", "COMMENT_LENGTH_OFFSET", "DISK_START_OFFSET", "EXTERNAL_ATTRIBUTES_OFFSET", "LOCAL_HEADER_OFFSET_OFFSET", "METHOD_STORED", "METHOD_DEFLATED", "UTF8_FLAG", "ENCRYPTION_FLAGS_MASK", "UNSUPPORTED_FLAGS_MASK", "DEFLATE_OPTION_FLAGS_MASK", "UNIX_FILE_TYPE_MASK", "UNIX_REGULAR_FILE", "UNIX_DIRECTORY", "UNIX_SYMLINK", "DOS_DIRECTORY_ATTRIBUTE", "ZIP64_EXTRA_FIELD_ID", "U16_MAX", "U32_MAX", "REQUIRED_PREFIX", "", "WINDOWS_ABSOLUTE_PATH", "Lkotlin/text/Regex;", "getWINDOWS_ABSOLUTE_PATH", "()Lkotlin/text/Regex;", "CP437", "Ljava/nio/charset/Charset;", "getCP437", "()Ljava/nio/charset/Charset;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Regex getWINDOWS_ABSOLUTE_PATH() {
            return RemoteZipIndexParser.WINDOWS_ABSOLUTE_PATH;
        }

        public final Charset getCP437() {
            return RemoteZipIndexParser.CP437;
        }
    }

    static {
        Charset forName = Charset.forName("IBM437");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
        CP437 = forName;
    }
}
