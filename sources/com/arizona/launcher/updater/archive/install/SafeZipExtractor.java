package com.arizona.launcher.updater.archive.install;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.arizona.launcher.updater.archive.install.SafeZipExtractionResult;
import com.arizona.launcher.updater.archive.io.ArchiveDirectoryCreator;
import com.arizona.launcher.updater.archive.io.ArchiveStorageFailureClassifier;
import com.arizona.launcher.updater.archive.io.JvmArchiveDirectoryCreator;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: SafeZipExtractor.kt */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 C2\u00020\u0001:\u0003ABCB1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u001a\u0010!\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0018\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020'H\u0002J \u0010(\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010)\u001a\u00020#2\u0006\u0010\"\u001a\u00020#H\u0002JL\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020,0.2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020,0.2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0.H\u0002J$\u00101\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#02H\u0002J\u0010\u00103\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u00104\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u00105\u001a\u0002062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u0015H\u0002J$\u00108\u001a\u00020'2\u0006\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020;2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0018\u0010<\u001a\u00020=2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010>\u001a\u00020,H\u0002J\f\u0010?\u001a\u00020#*\u00020@H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\bE\u0012\b\bF\u0012\u0004\b\u0003\u0010\u0000¨\u0006D"}, d2 = {"Lcom/arizona/launcher/updater/archive/install/SafeZipExtractor;", "", "limits", "Lcom/arizona/launcher/updater/archive/install/SafeZipLimits;", "fileOutputStreamFactory", "Lkotlin/Function1;", "Ljava/io/File;", "Ljava/io/FileOutputStream;", "directoryCreator", "Lcom/arizona/launcher/updater/archive/io/ArchiveDirectoryCreator;", "<init>", "(Lcom/arizona/launcher/updater/archive/install/SafeZipLimits;Lkotlin/jvm/functions/Function1;Lcom/arizona/launcher/updater/archive/io/ArchiveDirectoryCreator;)V", "extract", "Lcom/arizona/launcher/updater/archive/install/SafeZipExtractionResult;", "archive", "stagingRoot", "validateArchiveFile", "Lcom/arizona/launcher/updater/archive/install/SafeZipExtractionResult$Failure;", "validateStagingRoot", "root", "buildPlan", "Lcom/arizona/launcher/updater/archive/install/SafeZipExtractor$ExtractionPlan;", "zipFile", "Ljava/util/zip/ZipFile;", "rawEntries", "", "Lcom/arizona/launcher/updater/archive/install/RawCentralDirectoryEntry;", "canonicalRoot", "validateRawEntry", "", "raw", "entry", "Ljava/util/zip/ZipEntry;", "validateRawSecurityMetadata", "entryName", "", "validateAndStripPath", "rawName", "isDirectory", "", "containedTarget", "relativePath", "detectPathCollisions", "candidate", "Lcom/arizona/launcher/updater/archive/install/SafeZipExtractor$PlannedEntry;", "seenExact", "", "seenCaseInsensitive", "directoryCasing", "rememberDirectoryCasing", "", "validateEntryMetadata", "validateCompressionRatio", "extractPlan", "Lcom/arizona/launcher/updater/archive/install/SafeZipExtractionResult$Success;", "plan", "createDirectories", "directory", "fallbackCode", "Lcom/arizona/launcher/updater/archive/install/SafeZipExtractionErrorCode;", "extractFileEntry", "Lcom/arizona/launcher/updater/archive/install/ExtractedZipFile;", "planned", "toLowerHex", "", "PlannedEntry", "ExtractionPlan", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SafeZipExtractor {
    @Deprecated
    public static final int BUFFER_SIZE = 65536;
    @Deprecated
    public static final int DEFLATE_OPTION_FLAGS_MASK = 6;
    @Deprecated
    public static final int ENCRYPTION_FLAGS_MASK = 8257;
    @Deprecated
    public static final String HEX_DIGITS = "0123456789abcdef";
    @Deprecated
    public static final long MAX_CRC32 = 4294967295L;
    @Deprecated
    public static final String REQUIRED_PREFIX = "files/";
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
    private final ArchiveDirectoryCreator directoryCreator;
    private final Function1<File, FileOutputStream> fileOutputStreamFactory;
    private final SafeZipLimits limits;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Regex WINDOWS_ABSOLUTE_PATH = new Regex("^[A-Za-z]:[/\\\\].*");

    public SafeZipExtractor() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SafeZipExtractor(SafeZipLimits limits, Function1<? super File, ? extends FileOutputStream> fileOutputStreamFactory, ArchiveDirectoryCreator directoryCreator) {
        Intrinsics.checkNotNullParameter(limits, "limits");
        Intrinsics.checkNotNullParameter(fileOutputStreamFactory, "fileOutputStreamFactory");
        Intrinsics.checkNotNullParameter(directoryCreator, "directoryCreator");
        this.limits = limits;
        this.fileOutputStreamFactory = fileOutputStreamFactory;
        this.directoryCreator = directoryCreator;
    }

    public /* synthetic */ SafeZipExtractor(SafeZipLimits safeZipLimits, Function1 function1, JvmArchiveDirectoryCreator jvmArchiveDirectoryCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new SafeZipLimits(0, 0L, 0L, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 15, null) : safeZipLimits, (i & 2) != 0 ? new Function1() { // from class: com.arizona.launcher.updater.archive.install.SafeZipExtractor$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SafeZipExtractor._init_$lambda$0((File) obj);
            }
        } : function1, (i & 4) != 0 ? JvmArchiveDirectoryCreator.INSTANCE : jvmArchiveDirectoryCreator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final FileOutputStream _init_$lambda$0(File target) {
        Intrinsics.checkNotNullParameter(target, "target");
        return new FileOutputStream(target, false);
    }

    public final SafeZipExtractionResult extract(File archive, File stagingRoot) {
        SafeZipExtractionErrorCode safeZipExtractionErrorCode;
        SafeZipExtractionResult.Failure failure;
        SafeZipExtractor safeZipExtractor;
        Intrinsics.checkNotNullParameter(archive, "archive");
        Intrinsics.checkNotNullParameter(stagingRoot, "stagingRoot");
        SafeZipExtractionResult.Failure validateArchiveFile = validateArchiveFile(archive);
        if (validateArchiveFile != null) {
            return validateArchiveFile;
        }
        try {
            File canonicalFile = stagingRoot.getCanonicalFile();
            Intrinsics.checkNotNull(canonicalFile);
            SafeZipExtractionResult.Failure validateStagingRoot = validateStagingRoot(canonicalFile);
            if (validateStagingRoot != null) {
                return validateStagingRoot;
            }
            try {
                List<RawCentralDirectoryEntry> inspect = ZipCentralDirectoryInspector.INSTANCE.inspect(archive, this.limits.getMaxEntryCount());
                for (RawCentralDirectoryEntry rawCentralDirectoryEntry : inspect) {
                    validateRawSecurityMetadata(rawCentralDirectoryEntry, null);
                }
                ZipFile zipFile = new ZipFile(archive);
                try {
                    ZipFile zipFile2 = zipFile;
                    ExtractionPlan buildPlan = buildPlan(zipFile2, inspect, canonicalFile);
                    if (canonicalFile.exists()) {
                        safeZipExtractor = this;
                    } else {
                        safeZipExtractor = this;
                        if (!createDirectories$default(safeZipExtractor, canonicalFile, SafeZipExtractionErrorCode.CANNOT_CREATE_STAGING_ROOT, null, 4, null)) {
                            throw new ExtractionFailure(SafeZipExtractionErrorCode.CANNOT_CREATE_STAGING_ROOT, null, 2, null);
                        }
                    }
                    if (!canonicalFile.isDirectory()) {
                        throw new ExtractionFailure(SafeZipExtractionErrorCode.STAGING_ROOT_INVALID, null, 2, null);
                    }
                    SafeZipExtractionResult.Success extractPlan = safeZipExtractor.extractPlan(zipFile2, buildPlan);
                    CloseableKt.closeFinally(zipFile, null);
                    return extractPlan;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(zipFile, th);
                        throw th2;
                    }
                }
            } catch (ExtractionFailure e) {
                failure = SafeZipExtractorKt.failure(e.getCode(), e.getEntryName());
                return failure;
            } catch (EOFException unused) {
                return SafeZipExtractorKt.failure$default(SafeZipExtractionErrorCode.MALFORMED_ARCHIVE, null, 2, null);
            } catch (IOException e2) {
                if (ArchiveStorageFailureClassifier.INSTANCE.isNoSpace(e2)) {
                    safeZipExtractionErrorCode = SafeZipExtractionErrorCode.NO_SPACE_LEFT;
                } else {
                    safeZipExtractionErrorCode = SafeZipExtractionErrorCode.MALFORMED_ARCHIVE;
                }
                return SafeZipExtractorKt.failure$default(safeZipExtractionErrorCode, null, 2, null);
            } catch (SecurityException unused2) {
                return SafeZipExtractorKt.failure$default(SafeZipExtractionErrorCode.IO_ERROR, null, 2, null);
            } catch (ZipException unused3) {
                return SafeZipExtractorKt.failure$default(SafeZipExtractionErrorCode.MALFORMED_ARCHIVE, null, 2, null);
            }
        } catch (IOException unused4) {
            return SafeZipExtractorKt.failure$default(SafeZipExtractionErrorCode.STAGING_ROOT_INVALID, null, 2, null);
        } catch (SecurityException unused5) {
            return SafeZipExtractorKt.failure$default(SafeZipExtractionErrorCode.STAGING_ROOT_INVALID, null, 2, null);
        }
    }

    private final SafeZipExtractionResult.Failure validateArchiveFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                if (file.canRead()) {
                    return null;
                }
                return SafeZipExtractorKt.failure$default(SafeZipExtractionErrorCode.ARCHIVE_NOT_READABLE, null, 2, null);
            }
            return SafeZipExtractorKt.failure$default(SafeZipExtractionErrorCode.ARCHIVE_NOT_FILE, null, 2, null);
        }
        return SafeZipExtractorKt.failure$default(SafeZipExtractionErrorCode.ARCHIVE_NOT_FOUND, null, 2, null);
    }

    private final SafeZipExtractionResult.Failure validateStagingRoot(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                return SafeZipExtractorKt.failure$default(SafeZipExtractionErrorCode.STAGING_ROOT_INVALID, null, 2, null);
            }
            try {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    return SafeZipExtractorKt.failure$default(SafeZipExtractionErrorCode.STAGING_ROOT_INVALID, null, 2, null);
                }
                if (listFiles.length == 0) {
                    return null;
                }
                return SafeZipExtractorKt.failure$default(SafeZipExtractionErrorCode.STAGING_ROOT_NOT_EMPTY, null, 2, null);
            } catch (SecurityException unused) {
                return SafeZipExtractorKt.failure$default(SafeZipExtractionErrorCode.STAGING_ROOT_INVALID, null, 2, null);
            }
        }
        return null;
    }

    private final ExtractionPlan buildPlan(ZipFile zipFile, List<RawCentralDirectoryEntry> list, File file) {
        HashMap hashMap;
        ArrayList arrayList = new ArrayList(list.size());
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            if (arrayList.size() >= this.limits.getMaxEntryCount()) {
                throw new ExtractionFailure(SafeZipExtractionErrorCode.ENTRY_COUNT_LIMIT_EXCEEDED, null, 2, null);
            }
            arrayList.add(entries.nextElement());
        }
        if (arrayList.isEmpty()) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.EMPTY_ARCHIVE, null, 2, null);
        }
        if (arrayList.size() != list.size()) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.MALFORMED_ARCHIVE, null, 2, null);
        }
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        long j = 0;
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            ZipEntry zipEntry = (ZipEntry) obj;
            validateRawEntry(list.get(i), zipEntry);
            String name = zipEntry.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            String validateAndStripPath = validateAndStripPath(name, zipEntry.isDirectory());
            String name2 = zipEntry.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            ArrayList arrayList3 = arrayList;
            PlannedEntry plannedEntry = new PlannedEntry(zipEntry, validateAndStripPath, containedTarget(file, validateAndStripPath, name2), zipEntry.isDirectory());
            HashMap hashMap5 = hashMap2;
            HashMap hashMap6 = hashMap3;
            HashMap hashMap7 = hashMap2;
            HashMap hashMap8 = hashMap4;
            detectPathCollisions(plannedEntry, hashMap5, hashMap6, hashMap8);
            validateEntryMetadata(zipEntry);
            if (zipEntry.isDirectory()) {
                hashMap = hashMap3;
            } else {
                long size2 = zipEntry.getSize();
                hashMap = hashMap3;
                if (size2 > this.limits.getMaxEntryUncompressedBytes()) {
                    throw new ExtractionFailure(SafeZipExtractionErrorCode.ENTRY_SIZE_LIMIT_EXCEEDED, zipEntry.getName());
                }
                if (j > this.limits.getMaxTotalUncompressedBytes() - size2) {
                    throw new ExtractionFailure(SafeZipExtractionErrorCode.TOTAL_SIZE_LIMIT_EXCEEDED, zipEntry.getName());
                }
                j += size2;
                validateCompressionRatio(zipEntry);
            }
            arrayList2.add(plannedEntry);
            hashMap5.put(validateAndStripPath, plannedEntry);
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = validateAndStripPath.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            hashMap6.put(lowerCase, plannedEntry);
            rememberDirectoryCasing(plannedEntry, hashMap8);
            i++;
            hashMap2 = hashMap7;
            arrayList = arrayList3;
            hashMap3 = hashMap;
        }
        return new ExtractionPlan(arrayList2, j);
    }

    private final void validateRawEntry(RawCentralDirectoryEntry rawCentralDirectoryEntry, ZipEntry zipEntry) {
        validateRawSecurityMetadata(rawCentralDirectoryEntry, zipEntry.getName());
        if (zipEntry.getMethod() != rawCentralDirectoryEntry.getMethod()) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.MALFORMED_ARCHIVE, zipEntry.getName());
        }
        int externalAttributes = ((int) ((rawCentralDirectoryEntry.getExternalAttributes() >>> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX)) & 61440;
        if (externalAttributes == 16384) {
            if (!zipEntry.isDirectory()) {
                throw new ExtractionFailure(SafeZipExtractionErrorCode.ENTRY_TYPE_MISMATCH, zipEntry.getName());
            }
        } else if (externalAttributes == 32768 && zipEntry.isDirectory()) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.ENTRY_TYPE_MISMATCH, zipEntry.getName());
        }
    }

    private final void validateRawSecurityMetadata(RawCentralDirectoryEntry rawCentralDirectoryEntry, String str) {
        if ((rawCentralDirectoryEntry.getGeneralPurposeFlags() & 8257) != 0) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.ENCRYPTED_ENTRY, str);
        }
        if ((rawCentralDirectoryEntry.getGeneralPurposeFlags() & 63473) != 0) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.UNSUPPORTED_ENTRY_FLAGS, str);
        }
        if (rawCentralDirectoryEntry.getMethod() != 8 && (rawCentralDirectoryEntry.getGeneralPurposeFlags() & 6) != 0) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.UNSUPPORTED_ENTRY_FLAGS, str);
        }
        if (rawCentralDirectoryEntry.getMethod() != 0 && rawCentralDirectoryEntry.getMethod() != 8) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.UNSUPPORTED_COMPRESSION_METHOD, str);
        }
        int externalAttributes = ((int) ((rawCentralDirectoryEntry.getExternalAttributes() >>> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX)) & 61440;
        if (externalAttributes == 0 || externalAttributes == 16384 || externalAttributes == 32768) {
            return;
        }
        if (externalAttributes == 40960) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.SYMLINK_ENTRY, str);
        }
        throw new ExtractionFailure(SafeZipExtractionErrorCode.UNSUPPORTED_ENTRY_TYPE, str);
    }

    private final String validateAndStripPath(String str, boolean z) {
        String str2 = str;
        if (str2.length() == 0) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.ENTRY_NAME_EMPTY, str);
        }
        if (StringsKt.contains$default((CharSequence) str2, (char) 0, false, 2, (Object) null)) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.ENTRY_NAME_CONTAINS_NUL, str);
        }
        if (StringsKt.contains$default((CharSequence) str2, (char) AbstractJsonLexerKt.STRING_ESC, false, 2, (Object) null)) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.ENTRY_NAME_CONTAINS_BACKSLASH, str);
        }
        if (StringsKt.startsWith$default((CharSequence) str2, '/', false, 2, (Object) null) || WINDOWS_ABSOLUTE_PATH.matches(str2)) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.ABSOLUTE_ENTRY_PATH, str);
        }
        if (!StringsKt.startsWith$default(str, "files/", false, 2, (Object) null)) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.ENTRY_PREFIX_INVALID, str);
        }
        String removePrefix = StringsKt.removePrefix(str, (CharSequence) "files/");
        if (z && StringsKt.endsWith$default((CharSequence) removePrefix, '/', false, 2, (Object) null)) {
            removePrefix = StringsKt.dropLast(removePrefix, 1);
        }
        String str3 = removePrefix;
        if (str3.length() == 0) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.ENTRY_NAME_EMPTY, str);
        }
        List<String> split$default = StringsKt.split$default((CharSequence) str3, new char[]{'/'}, false, 0, 6, (Object) null);
        for (String str4 : split$default) {
            if (str4.length() == 0) {
                throw new ExtractionFailure(SafeZipExtractionErrorCode.EMPTY_PATH_SEGMENT, str);
            }
            if (Intrinsics.areEqual(str4, ".")) {
                throw new ExtractionFailure(SafeZipExtractionErrorCode.DOT_PATH_SEGMENT, str);
            }
            if (Intrinsics.areEqual(str4, "..")) {
                throw new ExtractionFailure(SafeZipExtractionErrorCode.PATH_TRAVERSAL, str);
            }
        }
        return CollectionsKt.joinToString$default(split$default, "/", null, null, 0, null, null, 62, null);
    }

    private final File containedTarget(File file, String str, String str2) {
        try {
            File canonicalFile = new File(file, str).getCanonicalFile();
            String str3 = file.getPath() + File.separator;
            if (!Intrinsics.areEqual(canonicalFile, file)) {
                String path = canonicalFile.getPath();
                Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                if (StringsKt.startsWith$default(path, str3, false, 2, (Object) null)) {
                    Intrinsics.checkNotNull(canonicalFile);
                    return canonicalFile;
                }
            }
            throw new ExtractionFailure(SafeZipExtractionErrorCode.ENTRY_OUTSIDE_STAGING_ROOT, str2);
        } catch (IOException unused) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.ENTRY_OUTSIDE_STAGING_ROOT, str2);
        } catch (SecurityException unused2) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.ENTRY_OUTSIDE_STAGING_ROOT, str2);
        }
    }

    private final void detectPathCollisions(PlannedEntry plannedEntry, Map<String, PlannedEntry> map, Map<String, PlannedEntry> map2, Map<String, String> map3) {
        SafeZipExtractionErrorCode safeZipExtractionErrorCode;
        PlannedEntry plannedEntry2 = map.get(plannedEntry.getRelativePath());
        if (plannedEntry2 != null) {
            if (plannedEntry2.isDirectory() != plannedEntry.isDirectory()) {
                safeZipExtractionErrorCode = SafeZipExtractionErrorCode.FILE_DIRECTORY_COLLISION;
            } else {
                safeZipExtractionErrorCode = SafeZipExtractionErrorCode.DUPLICATE_ENTRY;
            }
            throw new ExtractionFailure(safeZipExtractionErrorCode, plannedEntry.getEntry().getName());
        }
        String relativePath = plannedEntry.getRelativePath();
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = relativePath.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (map2.containsKey(lowerCase)) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.CASE_COLLISION, plannedEntry.getEntry().getName());
        }
        String str = map3.get(lowerCase);
        if (str != null && !Intrinsics.areEqual(str, plannedEntry.getRelativePath())) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.CASE_COLLISION, plannedEntry.getEntry().getName());
        }
        List split$default = StringsKt.split$default((CharSequence) plannedEntry.getRelativePath(), new char[]{'/'}, false, 0, 6, (Object) null);
        int lastIndex = CollectionsKt.getLastIndex(split$default);
        String str2 = "";
        for (int i = 0; i < lastIndex; i++) {
            str2 = str2.length() == 0 ? (String) split$default.get(i) : str2 + "/" + split$default.get(i);
            Locale ROOT2 = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
            String lowerCase2 = str2.toLowerCase(ROOT2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            PlannedEntry plannedEntry3 = map2.get(lowerCase2);
            if (plannedEntry3 != null && !plannedEntry3.isDirectory()) {
                throw new ExtractionFailure(SafeZipExtractionErrorCode.FILE_DIRECTORY_COLLISION, plannedEntry.getEntry().getName());
            }
            String str3 = map3.get(lowerCase2);
            if (str3 != null && !Intrinsics.areEqual(str3, str2)) {
                throw new ExtractionFailure(SafeZipExtractionErrorCode.CASE_COLLISION, plannedEntry.getEntry().getName());
            }
        }
        if (plannedEntry.isDirectory()) {
            return;
        }
        String str4 = lowerCase + "/";
        Set<String> keySet = map2.keySet();
        if (!(keySet instanceof Collection) || !keySet.isEmpty()) {
            for (String str5 : keySet) {
                if (StringsKt.startsWith$default(str5, str4, false, 2, (Object) null)) {
                    break;
                }
            }
        }
        Set<String> keySet2 = map3.keySet();
        if ((keySet2 instanceof Collection) && keySet2.isEmpty()) {
            return;
        }
        for (String str6 : keySet2) {
            if (StringsKt.startsWith$default(str6, str4, false, 2, (Object) null)) {
                throw new ExtractionFailure(SafeZipExtractionErrorCode.FILE_DIRECTORY_COLLISION, plannedEntry.getEntry().getName());
            }
        }
    }

    private final void rememberDirectoryCasing(PlannedEntry plannedEntry, Map<String, String> map) {
        int lastIndex;
        int i = 0;
        List split$default = StringsKt.split$default((CharSequence) plannedEntry.getRelativePath(), new char[]{'/'}, false, 0, 6, (Object) null);
        if (plannedEntry.isDirectory()) {
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

    private final void validateEntryMetadata(ZipEntry zipEntry) {
        if (zipEntry.getMethod() != 0 && zipEntry.getMethod() != 8) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.UNSUPPORTED_COMPRESSION_METHOD, zipEntry.getName());
        }
        if (zipEntry.getSize() < 0 || zipEntry.getCompressedSize() < 0) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.ENTRY_SIZE_UNKNOWN, zipEntry.getName());
        }
        long crc = zipEntry.getCrc();
        if (0 > crc || crc >= 4294967296L) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.ENTRY_CRC_UNKNOWN, zipEntry.getName());
        }
        if (zipEntry.isDirectory() && (zipEntry.getSize() != 0 || zipEntry.getCompressedSize() != 0)) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.DIRECTORY_HAS_DATA, zipEntry.getName());
        }
        if (zipEntry.getMethod() == 0 && zipEntry.getSize() != zipEntry.getCompressedSize()) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.ENTRY_METADATA_INCONSISTENT, zipEntry.getName());
        }
    }

    private final void validateCompressionRatio(ZipEntry zipEntry) {
        if (zipEntry.getSize() == 0) {
            return;
        }
        if (zipEntry.getCompressedSize() == 0) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.COMPRESSION_RATIO_LIMIT_EXCEEDED, zipEntry.getName());
        }
        double size = zipEntry.getSize() / zipEntry.getCompressedSize();
        if (Math.abs(size) > Double.MAX_VALUE || size > this.limits.getMaxCompressionRatio()) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.COMPRESSION_RATIO_LIMIT_EXCEEDED, zipEntry.getName());
        }
    }

    private final SafeZipExtractionResult.Success extractPlan(ZipFile zipFile, ExtractionPlan extractionPlan) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        long j = 0;
        for (PlannedEntry plannedEntry : extractionPlan.getEntries()) {
            if (plannedEntry.isDirectory()) {
                if (!plannedEntry.getTarget().exists() && !createDirectories(plannedEntry.getTarget(), SafeZipExtractionErrorCode.CANNOT_CREATE_DIRECTORY, plannedEntry.getEntry().getName())) {
                    throw new ExtractionFailure(SafeZipExtractionErrorCode.CANNOT_CREATE_DIRECTORY, plannedEntry.getEntry().getName());
                }
                if (!plannedEntry.getTarget().isDirectory()) {
                    throw new ExtractionFailure(SafeZipExtractionErrorCode.CANNOT_CREATE_DIRECTORY, plannedEntry.getEntry().getName());
                }
                i2++;
            } else {
                File parentFile = plannedEntry.getTarget().getParentFile();
                if (parentFile == null) {
                    throw new ExtractionFailure(SafeZipExtractionErrorCode.CANNOT_CREATE_DIRECTORY, plannedEntry.getEntry().getName());
                }
                if (!parentFile.exists() && !createDirectories(parentFile, SafeZipExtractionErrorCode.CANNOT_CREATE_DIRECTORY, plannedEntry.getEntry().getName())) {
                    throw new ExtractionFailure(SafeZipExtractionErrorCode.CANNOT_CREATE_DIRECTORY, plannedEntry.getEntry().getName());
                }
                if (!parentFile.isDirectory() || plannedEntry.getTarget().exists()) {
                    throw new ExtractionFailure(SafeZipExtractionErrorCode.OUTPUT_TARGET_ALREADY_EXISTS, plannedEntry.getEntry().getName());
                }
                ExtractedZipFile extractFileEntry = extractFileEntry(zipFile, plannedEntry);
                arrayList.add(extractFileEntry);
                j += extractFileEntry.getSize();
                i++;
            }
        }
        if (j != extractionPlan.getTotalUncompressedBytes()) {
            throw new ExtractionFailure(SafeZipExtractionErrorCode.TOTAL_SIZE_MISMATCH, null, 2, null);
        }
        return new SafeZipExtractionResult.Success(extractionPlan.getEntries().size(), i, i2, j, CollectionsKt.toList(arrayList));
    }

    static /* synthetic */ boolean createDirectories$default(SafeZipExtractor safeZipExtractor, File file, SafeZipExtractionErrorCode safeZipExtractionErrorCode, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        return safeZipExtractor.createDirectories(file, safeZipExtractionErrorCode, str);
    }

    private final boolean createDirectories(File file, SafeZipExtractionErrorCode safeZipExtractionErrorCode, String str) {
        try {
            return this.directoryCreator.createDirectories(file);
        } catch (IOException e) {
            if (ArchiveStorageFailureClassifier.INSTANCE.isNoSpace(e)) {
                safeZipExtractionErrorCode = SafeZipExtractionErrorCode.NO_SPACE_LEFT;
            }
            throw new ExtractionFailure(safeZipExtractionErrorCode, str);
        }
    }

    private final ExtractedZipFile extractFileEntry(ZipFile zipFile, PlannedEntry plannedEntry) {
        SafeZipExtractionErrorCode safeZipExtractionErrorCode;
        CRC32 crc32 = new CRC32();
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bArr = new byte[65536];
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(plannedEntry.getEntry()), 65536);
            try {
                BufferedInputStream bufferedInputStream2 = bufferedInputStream;
                FileOutputStream invoke = this.fileOutputStreamFactory.invoke(plannedEntry.getTarget());
                FileOutputStream fileOutputStream = invoke;
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 65536);
                long j = 0;
                while (true) {
                    int read = bufferedInputStream2.read(bArr);
                    if (read < 0) {
                        bufferedOutputStream.flush();
                        fileOutputStream.getFD().sync();
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(invoke, null);
                        Unit unit2 = Unit.INSTANCE;
                        CloseableKt.closeFinally(bufferedInputStream, null);
                        if (j != plannedEntry.getEntry().getSize()) {
                            plannedEntry.getTarget().delete();
                            throw new ExtractionFailure(SafeZipExtractionErrorCode.ENTRY_SIZE_MISMATCH, plannedEntry.getEntry().getName());
                        } else if (crc32.getValue() != plannedEntry.getEntry().getCrc()) {
                            plannedEntry.getTarget().delete();
                            throw new ExtractionFailure(SafeZipExtractionErrorCode.ENTRY_CRC32_MISMATCH, plannedEntry.getEntry().getName());
                        } else {
                            String relativePath = plannedEntry.getRelativePath();
                            long value = crc32.getValue();
                            byte[] digest = messageDigest.digest();
                            Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
                            return new ExtractedZipFile(relativePath, j, value, toLowerHex(digest));
                        }
                    } else if (read != 0) {
                        long j2 = read;
                        if (j > plannedEntry.getEntry().getSize() - j2) {
                            throw new ExtractionFailure(SafeZipExtractionErrorCode.ENTRY_SIZE_MISMATCH, plannedEntry.getEntry().getName());
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                        crc32.update(bArr, 0, read);
                        messageDigest.update(bArr, 0, read);
                        j += j2;
                    }
                }
            } finally {
            }
        } catch (ExtractionFailure e) {
            plannedEntry.getTarget().delete();
            throw e;
        } catch (ZipException unused) {
            plannedEntry.getTarget().delete();
            throw new ExtractionFailure(SafeZipExtractionErrorCode.ENTRY_DATA_CORRUPT, plannedEntry.getEntry().getName());
        } catch (IOException e2) {
            plannedEntry.getTarget().delete();
            if (ArchiveStorageFailureClassifier.INSTANCE.isNoSpace(e2)) {
                safeZipExtractionErrorCode = SafeZipExtractionErrorCode.NO_SPACE_LEFT;
            } else {
                safeZipExtractionErrorCode = SafeZipExtractionErrorCode.ENTRY_IO_ERROR;
            }
            throw new ExtractionFailure(safeZipExtractionErrorCode, plannedEntry.getEntry().getName());
        } catch (SecurityException unused2) {
            plannedEntry.getTarget().delete();
            throw new ExtractionFailure(SafeZipExtractionErrorCode.ENTRY_IO_ERROR, plannedEntry.getEntry().getName());
        }
    }

    private final String toLowerHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append("0123456789abcdef".charAt((b & 255) >>> 4));
            sb.append("0123456789abcdef".charAt(b & Ascii.SI));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeZipExtractor.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/arizona/launcher/updater/archive/install/SafeZipExtractor$PlannedEntry;", "", "entry", "Ljava/util/zip/ZipEntry;", "relativePath", "", TypedValues.AttributesType.S_TARGET, "Ljava/io/File;", "isDirectory", "", "<init>", "(Ljava/util/zip/ZipEntry;Ljava/lang/String;Ljava/io/File;Z)V", "getEntry", "()Ljava/util/zip/ZipEntry;", "getRelativePath", "()Ljava/lang/String;", "getTarget", "()Ljava/io/File;", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class PlannedEntry {
        private final ZipEntry entry;
        private final boolean isDirectory;
        private final String relativePath;
        private final File target;

        public static /* synthetic */ PlannedEntry copy$default(PlannedEntry plannedEntry, ZipEntry zipEntry, String str, File file, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                zipEntry = plannedEntry.entry;
            }
            if ((i & 2) != 0) {
                str = plannedEntry.relativePath;
            }
            if ((i & 4) != 0) {
                file = plannedEntry.target;
            }
            if ((i & 8) != 0) {
                z = plannedEntry.isDirectory;
            }
            return plannedEntry.copy(zipEntry, str, file, z);
        }

        public final ZipEntry component1() {
            return this.entry;
        }

        public final String component2() {
            return this.relativePath;
        }

        public final File component3() {
            return this.target;
        }

        public final boolean component4() {
            return this.isDirectory;
        }

        public final PlannedEntry copy(ZipEntry entry, String relativePath, File target, boolean z) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            Intrinsics.checkNotNullParameter(relativePath, "relativePath");
            Intrinsics.checkNotNullParameter(target, "target");
            return new PlannedEntry(entry, relativePath, target, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PlannedEntry) {
                PlannedEntry plannedEntry = (PlannedEntry) obj;
                return Intrinsics.areEqual(this.entry, plannedEntry.entry) && Intrinsics.areEqual(this.relativePath, plannedEntry.relativePath) && Intrinsics.areEqual(this.target, plannedEntry.target) && this.isDirectory == plannedEntry.isDirectory;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.entry.hashCode() * 31) + this.relativePath.hashCode()) * 31) + this.target.hashCode()) * 31) + Boolean.hashCode(this.isDirectory);
        }

        public String toString() {
            ZipEntry zipEntry = this.entry;
            String str = this.relativePath;
            File file = this.target;
            return "PlannedEntry(entry=" + zipEntry + ", relativePath=" + str + ", target=" + file + ", isDirectory=" + this.isDirectory + ")";
        }

        public PlannedEntry(ZipEntry entry, String relativePath, File target, boolean z) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            Intrinsics.checkNotNullParameter(relativePath, "relativePath");
            Intrinsics.checkNotNullParameter(target, "target");
            this.entry = entry;
            this.relativePath = relativePath;
            this.target = target;
            this.isDirectory = z;
        }

        public final ZipEntry getEntry() {
            return this.entry;
        }

        public final String getRelativePath() {
            return this.relativePath;
        }

        public final File getTarget() {
            return this.target;
        }

        public final boolean isDirectory() {
            return this.isDirectory;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeZipExtractor.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/arizona/launcher/updater/archive/install/SafeZipExtractor$ExtractionPlan;", "", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "Lcom/arizona/launcher/updater/archive/install/SafeZipExtractor$PlannedEntry;", "totalUncompressedBytes", "", "<init>", "(Ljava/util/List;J)V", "getEntries", "()Ljava/util/List;", "getTotalUncompressedBytes", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ExtractionPlan {
        private final List<PlannedEntry> entries;
        private final long totalUncompressedBytes;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ExtractionPlan copy$default(ExtractionPlan extractionPlan, List list, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                list = extractionPlan.entries;
            }
            if ((i & 2) != 0) {
                j = extractionPlan.totalUncompressedBytes;
            }
            return extractionPlan.copy(list, j);
        }

        public final List<PlannedEntry> component1() {
            return this.entries;
        }

        public final long component2() {
            return this.totalUncompressedBytes;
        }

        public final ExtractionPlan copy(List<PlannedEntry> entries, long j) {
            Intrinsics.checkNotNullParameter(entries, "entries");
            return new ExtractionPlan(entries, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ExtractionPlan) {
                ExtractionPlan extractionPlan = (ExtractionPlan) obj;
                return Intrinsics.areEqual(this.entries, extractionPlan.entries) && this.totalUncompressedBytes == extractionPlan.totalUncompressedBytes;
            }
            return false;
        }

        public int hashCode() {
            return (this.entries.hashCode() * 31) + Long.hashCode(this.totalUncompressedBytes);
        }

        public String toString() {
            List<PlannedEntry> list = this.entries;
            return "ExtractionPlan(entries=" + list + ", totalUncompressedBytes=" + this.totalUncompressedBytes + ")";
        }

        public ExtractionPlan(List<PlannedEntry> entries, long j) {
            Intrinsics.checkNotNullParameter(entries, "entries");
            this.entries = entries;
            this.totalUncompressedBytes = j;
        }

        public final List<PlannedEntry> getEntries() {
            return this.entries;
        }

        public final long getTotalUncompressedBytes() {
            return this.totalUncompressedBytes;
        }
    }

    /* compiled from: SafeZipExtractor.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/install/SafeZipExtractor$Companion;", "", "<init>", "()V", "REQUIRED_PREFIX", "", "BUFFER_SIZE", "", "MAX_CRC32", "", "ENCRYPTION_FLAGS_MASK", "UNSUPPORTED_FLAGS_MASK", "DEFLATE_OPTION_FLAGS_MASK", "UNIX_FILE_TYPE_MASK", "UNIX_REGULAR_FILE", "UNIX_DIRECTORY", "UNIX_SYMLINK", "HEX_DIGITS", "WINDOWS_ABSOLUTE_PATH", "Lkotlin/text/Regex;", "getWINDOWS_ABSOLUTE_PATH", "()Lkotlin/text/Regex;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Regex getWINDOWS_ABSOLUTE_PATH() {
            return SafeZipExtractor.WINDOWS_ABSOLUTE_PATH;
        }
    }
}
