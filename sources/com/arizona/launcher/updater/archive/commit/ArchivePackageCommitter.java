package com.arizona.launcher.updater.archive.commit;

import coil3.util.UtilsKt;
import com.arizona.launcher.updater.archive.commit.ArchivePackageCommitResult;
import com.arizona.launcher.updater.archive.install.WholeFileCrc32Verifier;
import com.arizona.launcher.updater.archive.install.WholeFileVerificationResult;
import com.arizona.launcher.updater.archive.io.ArchiveDirectoryCreator;
import com.arizona.launcher.updater.archive.io.ArchiveStorageFailureClassifier;
import com.arizona.launcher.updater.archive.io.JvmArchiveDirectoryCreator;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser;
import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: ArchivePackageCommitter.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 22\u00020\u0001:\u000212BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\"\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\u0018\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0002J\u001a\u0010&\u001a\u0004\u0018\u00010\u00032\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0013H\u0002J\u0018\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003H\u0002J\u0018\u0010+\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0002J\u0018\u0010,\u001a\u00020-2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0002J\u0018\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n \u000f*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n \u000f*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b4\u0012\b\b5\u0012\u0004\b\u0003\u0010\u0000¨\u00063"}, d2 = {"Lcom/arizona/launcher/updater/archive/commit/ArchivePackageCommitter;", "", "gameRoot", "Ljava/io/File;", "updaterWorkRoot", "fileOps", "Lcom/arizona/launcher/updater/archive/commit/ArchiveCommitFileOps;", "verifyFile", "Lkotlin/Function3;", "", "Lcom/arizona/launcher/updater/archive/install/WholeFileVerificationResult;", "directoryCreator", "Lcom/arizona/launcher/updater/archive/io/ArchiveDirectoryCreator;", "<init>", "(Ljava/io/File;Ljava/io/File;Lcom/arizona/launcher/updater/archive/commit/ArchiveCommitFileOps;Lkotlin/jvm/functions/Function3;Lcom/arizona/launcher/updater/archive/io/ArchiveDirectoryCreator;)V", "kotlin.jvm.PlatformType", "commit", "Lcom/arizona/launcher/updater/archive/commit/ArchivePackageCommitResult;", "packageId", "", "stagingRoot", OriginalTzArchiveManifestParser.FILES_ROOT, "", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageFileRecord;", "validateRoots", "Lcom/arizona/launcher/updater/archive/commit/ArchivePackageCommitter$CommitRoots;", "validateFiles", "commitFile", "Lcom/arizona/launcher/updater/archive/commit/ArchivePackageCommitResult$Failure;", "roots", "backupRoot", "record", "matches", "", UtilsKt.SCHEME_FILE, "ensureDirectory", "directory", "allowedRoot", "containedFile", "root", "relativePath", "isStrictChild", "candidate", "safeDeleteFile", "safeDeleteTree", "", "deleteTreeNode", "node", "deletionRoot", "CommitRoots", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchivePackageCommitter {
    @Deprecated
    public static final String BACKUP_DIRECTORY = ".backup";
    @Deprecated
    public static final String DEFAULT_WORK_DIRECTORY = ".archive-installing";
    @Deprecated
    public static final long MAX_CRC32 = 4294967295L;
    private final ArchiveDirectoryCreator directoryCreator;
    private final ArchiveCommitFileOps fileOps;
    private final File gameRoot;
    private final File updaterWorkRoot;
    private final Function3<File, Long, Long, WholeFileVerificationResult> verifyFile;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Regex PACKAGE_ID = new Regex("^[A-Za-z0-9._-]{1,96}$");

    /* JADX WARN: Multi-variable type inference failed */
    public ArchivePackageCommitter(File gameRoot, File updaterWorkRoot, ArchiveCommitFileOps fileOps, Function3<? super File, ? super Long, ? super Long, ? extends WholeFileVerificationResult> verifyFile, ArchiveDirectoryCreator directoryCreator) {
        Intrinsics.checkNotNullParameter(gameRoot, "gameRoot");
        Intrinsics.checkNotNullParameter(updaterWorkRoot, "updaterWorkRoot");
        Intrinsics.checkNotNullParameter(fileOps, "fileOps");
        Intrinsics.checkNotNullParameter(verifyFile, "verifyFile");
        Intrinsics.checkNotNullParameter(directoryCreator, "directoryCreator");
        this.fileOps = fileOps;
        this.verifyFile = verifyFile;
        this.directoryCreator = directoryCreator;
        this.gameRoot = gameRoot.getAbsoluteFile();
        this.updaterWorkRoot = updaterWorkRoot.getAbsoluteFile();
    }

    public /* synthetic */ ArchivePackageCommitter(File file, File file2, AndroidArchiveCommitFileOps androidArchiveCommitFileOps, AnonymousClass1 anonymousClass1, JvmArchiveDirectoryCreator jvmArchiveDirectoryCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i & 2) != 0 ? new File(file, ".archive-installing") : file2, (i & 4) != 0 ? AndroidArchiveCommitFileOps.INSTANCE : androidArchiveCommitFileOps, (i & 8) != 0 ? new AnonymousClass1(WholeFileCrc32Verifier.INSTANCE) : anonymousClass1, (i & 16) != 0 ? JvmArchiveDirectoryCreator.INSTANCE : jvmArchiveDirectoryCreator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArchivePackageCommitter.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* renamed from: com.arizona.launcher.updater.archive.commit.ArchivePackageCommitter$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<File, Long, Long, WholeFileVerificationResult> {
        AnonymousClass1(Object obj) {
            super(3, obj, WholeFileCrc32Verifier.class, "verify", "verify(Ljava/io/File;JJ)Lcom/arizona/launcher/updater/archive/install/WholeFileVerificationResult;", 0);
        }

        public final WholeFileVerificationResult invoke(File p0, long j, long j2) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((WholeFileCrc32Verifier) this.receiver).verify(p0, j, j2);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ WholeFileVerificationResult invoke(File file, Long l, Long l2) {
            return invoke(file, l.longValue(), l2.longValue());
        }
    }

    public final ArchivePackageCommitResult commit(String packageId, File stagingRoot, List<ArchivePackageFileRecord> files) {
        ArchivePackageCommitErrorCode archivePackageCommitErrorCode;
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Intrinsics.checkNotNullParameter(stagingRoot, "stagingRoot");
        Intrinsics.checkNotNullParameter(files, "files");
        String obj = StringsKt.trim((CharSequence) packageId).toString();
        if (!PACKAGE_ID.matches(obj)) {
            return ArchivePackageCommitterKt.failure$default(ArchivePackageCommitErrorCode.INVALID_PACKAGE_ID, null, 2, null);
        }
        if (files.isEmpty()) {
            return ArchivePackageCommitterKt.failure$default(ArchivePackageCommitErrorCode.EMPTY_PACKAGE, null, 2, null);
        }
        try {
            CommitRoots validateRoots = validateRoots(stagingRoot);
            if (validateRoots == null) {
                return ArchivePackageCommitterKt.failure$default(ArchivePackageCommitErrorCode.INVALID_ROOT, null, 2, null);
            }
            List<ArchivePackageFileRecord> validateFiles = validateFiles(files);
            if (validateFiles == null) {
                return ArchivePackageCommitterKt.failure$default(ArchivePackageCommitErrorCode.INVALID_ENTRY, null, 2, null);
            }
            File file = new File(validateRoots.getWorkRoot(), ".backup/" + obj);
            long j = 0;
            for (ArchivePackageFileRecord archivePackageFileRecord : validateFiles) {
                ArchivePackageCommitResult.Failure commitFile = commitFile(validateRoots, file, archivePackageFileRecord);
                if (commitFile != null) {
                    return commitFile;
                }
                j = Math.addExact(j, archivePackageFileRecord.getSize());
            }
            safeDeleteTree(file, validateRoots.getWorkRoot());
            safeDeleteTree(validateRoots.getStagingRoot(), validateRoots.getWorkRoot());
            this.fileOps.syncDirectory(validateRoots.getWorkRoot());
            this.fileOps.syncDirectory(validateRoots.getGameRoot());
            return new ArchivePackageCommitResult.Success(validateFiles.size(), j);
        } catch (IOException e) {
            if (ArchiveStorageFailureClassifier.INSTANCE.isNoSpace(e)) {
                archivePackageCommitErrorCode = ArchivePackageCommitErrorCode.NO_SPACE_LEFT;
            } else {
                archivePackageCommitErrorCode = ArchivePackageCommitErrorCode.IO_ERROR;
            }
            return ArchivePackageCommitterKt.failure$default(archivePackageCommitErrorCode, null, 2, null);
        } catch (ArithmeticException unused) {
            return ArchivePackageCommitterKt.failure$default(ArchivePackageCommitErrorCode.INVALID_ENTRY, null, 2, null);
        } catch (SecurityException unused2) {
            return ArchivePackageCommitterKt.failure$default(ArchivePackageCommitErrorCode.IO_ERROR, null, 2, null);
        }
    }

    private final CommitRoots validateRoots(File file) {
        File canonicalFile = this.gameRoot.getCanonicalFile();
        if (canonicalFile.isDirectory()) {
            File canonicalFile2 = this.updaterWorkRoot.getCanonicalFile();
            Intrinsics.checkNotNull(canonicalFile2);
            Intrinsics.checkNotNull(canonicalFile);
            if (isStrictChild(canonicalFile2, canonicalFile)) {
                if ((canonicalFile2.exists() || this.directoryCreator.createDirectories(canonicalFile2)) && canonicalFile2.isDirectory()) {
                    File canonicalFile3 = file.getCanonicalFile();
                    if (!canonicalFile3.exists() || canonicalFile3.isDirectory()) {
                        Intrinsics.checkNotNull(canonicalFile3);
                        if (isStrictChild(canonicalFile3, canonicalFile2)) {
                            return new CommitRoots(canonicalFile, canonicalFile2, canonicalFile3);
                        }
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    private final List<ArchivePackageFileRecord> validateFiles(List<ArchivePackageFileRecord> list) {
        HashSet hashSet = new HashSet();
        List<ArchivePackageFileRecord> sortedWith = CollectionsKt.sortedWith(list, new Comparator() { // from class: com.arizona.launcher.updater.archive.commit.ArchivePackageCommitter$validateFiles$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                String relativePath = ((ArchivePackageFileRecord) t).getRelativePath();
                Locale ROOT = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                String lowerCase = relativePath.toLowerCase(ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String relativePath2 = ((ArchivePackageFileRecord) t2).getRelativePath();
                Locale ROOT2 = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
                String lowerCase2 = relativePath2.toLowerCase(ROOT2);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                return ComparisonsKt.compareValues(lowerCase, lowerCase2);
            }
        });
        loop0: for (ArchivePackageFileRecord archivePackageFileRecord : sortedWith) {
            String relativePath = archivePackageFileRecord.getRelativePath();
            String str = relativePath;
            List split$default = StringsKt.split$default((CharSequence) str, new char[]{'/'}, false, 0, 6, (Object) null);
            if (!StringsKt.isBlank(str) && !StringsKt.startsWith$default((CharSequence) str, '/', false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str, (char) AbstractJsonLexerKt.STRING_ESC, false, 2, (Object) null)) {
                List<String> list2 = split$default;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    for (String str2 : list2) {
                        if (str2.length() != 0) {
                            if (Intrinsics.areEqual(str2, ".")) {
                                break loop0;
                            } else if (Intrinsics.areEqual(str2, "..")) {
                                break loop0;
                            }
                        } else {
                            break loop0;
                        }
                    }
                }
                if (!StringsKt.equals((String) CollectionsKt.first((List<? extends Object>) split$default), ".archive-installing", true) && archivePackageFileRecord.getSize() >= 0) {
                    long crc32 = archivePackageFileRecord.getCrc32();
                    if (0 <= crc32 && crc32 < 4294967296L) {
                        Locale ROOT = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                        String lowerCase = relativePath.toLowerCase(ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        if (!hashSet.add(lowerCase)) {
                        }
                    }
                }
            }
            return null;
        }
        return sortedWith;
    }

    private final ArchivePackageCommitResult.Failure commitFile(CommitRoots commitRoots, File file, ArchivePackageFileRecord archivePackageFileRecord) {
        ArchivePackageCommitResult.Failure failure;
        ArchivePackageCommitResult.Failure failure2;
        ArchivePackageCommitResult.Failure failure3;
        ArchivePackageCommitResult.Failure failure4;
        ArchivePackageCommitResult.Failure failure5;
        ArchivePackageCommitResult.Failure failure6;
        ArchivePackageCommitResult.Failure failure7;
        ArchivePackageCommitResult.Failure failure8;
        ArchivePackageCommitResult.Failure failure9;
        ArchivePackageCommitResult.Failure failure10;
        ArchivePackageCommitResult.Failure failure11;
        ArchivePackageCommitResult.Failure failure12;
        ArchivePackageCommitResult.Failure failure13;
        File containedFile = containedFile(commitRoots.getStagingRoot(), archivePackageFileRecord.getRelativePath());
        if (containedFile == null) {
            failure13 = ArchivePackageCommitterKt.failure(ArchivePackageCommitErrorCode.INVALID_ENTRY, archivePackageFileRecord.getRelativePath());
            return failure13;
        }
        File containedFile2 = containedFile(commitRoots.getGameRoot(), archivePackageFileRecord.getRelativePath());
        if (containedFile2 == null) {
            failure12 = ArchivePackageCommitterKt.failure(ArchivePackageCommitErrorCode.INVALID_ENTRY, archivePackageFileRecord.getRelativePath());
            return failure12;
        }
        File canonicalFile = file.getCanonicalFile();
        Intrinsics.checkNotNullExpressionValue(canonicalFile, "getCanonicalFile(...)");
        File containedFile3 = containedFile(canonicalFile, archivePackageFileRecord.getRelativePath());
        if (containedFile3 == null) {
            failure11 = ArchivePackageCommitterKt.failure(ArchivePackageCommitErrorCode.INVALID_ENTRY, archivePackageFileRecord.getRelativePath());
            return failure11;
        } else if (matches(containedFile2, archivePackageFileRecord)) {
            if (containedFile.exists() && !safeDeleteFile(containedFile, commitRoots.getStagingRoot())) {
                failure10 = ArchivePackageCommitterKt.failure(ArchivePackageCommitErrorCode.CLEANUP_FAILED, archivePackageFileRecord.getRelativePath());
                return failure10;
            }
            this.fileOps.syncFile(containedFile2);
            File parentFile = containedFile2.getParentFile();
            if (parentFile != null) {
                this.fileOps.syncDirectory(parentFile);
            }
            return null;
        } else if (!containedFile.isFile()) {
            failure9 = ArchivePackageCommitterKt.failure(ArchivePackageCommitErrorCode.SOURCE_MISSING, archivePackageFileRecord.getRelativePath());
            return failure9;
        } else if (!matches(containedFile, archivePackageFileRecord)) {
            failure8 = ArchivePackageCommitterKt.failure(ArchivePackageCommitErrorCode.SOURCE_VERIFICATION_FAILED, archivePackageFileRecord.getRelativePath());
            return failure8;
        } else if (containedFile2.isDirectory()) {
            failure7 = ArchivePackageCommitterKt.failure(ArchivePackageCommitErrorCode.TARGET_TYPE_CONFLICT, archivePackageFileRecord.getRelativePath());
            return failure7;
        } else {
            File parentFile2 = containedFile2.getParentFile();
            if (parentFile2 == null) {
                failure = ArchivePackageCommitterKt.failure(ArchivePackageCommitErrorCode.TARGET_PARENT_INVALID, archivePackageFileRecord.getRelativePath());
                return failure;
            } else if (!ensureDirectory(parentFile2, commitRoots.getGameRoot())) {
                failure6 = ArchivePackageCommitterKt.failure(ArchivePackageCommitErrorCode.TARGET_PARENT_INVALID, archivePackageFileRecord.getRelativePath());
                return failure6;
            } else {
                if (containedFile2.exists()) {
                    if (containedFile3.exists()) {
                        failure5 = ArchivePackageCommitterKt.failure(ArchivePackageCommitErrorCode.BACKUP_CONFLICT, archivePackageFileRecord.getRelativePath());
                        return failure5;
                    }
                    File parentFile3 = containedFile3.getParentFile();
                    if (parentFile3 == null) {
                        failure3 = ArchivePackageCommitterKt.failure(ArchivePackageCommitErrorCode.BACKUP_CONFLICT, archivePackageFileRecord.getRelativePath());
                        return failure3;
                    } else if (!ensureDirectory(parentFile3, commitRoots.getWorkRoot())) {
                        failure4 = ArchivePackageCommitterKt.failure(ArchivePackageCommitErrorCode.BACKUP_CONFLICT, archivePackageFileRecord.getRelativePath());
                        return failure4;
                    } else {
                        this.fileOps.atomicRename(containedFile2, containedFile3);
                        File parentFile4 = containedFile3.getParentFile();
                        if (parentFile4 != null) {
                            this.fileOps.syncDirectory(parentFile4);
                        }
                        File parentFile5 = containedFile2.getParentFile();
                        if (parentFile5 != null) {
                            this.fileOps.syncDirectory(parentFile5);
                        }
                    }
                }
                this.fileOps.atomicRename(containedFile, containedFile2);
                this.fileOps.syncFile(containedFile2);
                File parentFile6 = containedFile.getParentFile();
                if (parentFile6 != null) {
                    this.fileOps.syncDirectory(parentFile6);
                }
                File parentFile7 = containedFile2.getParentFile();
                if (parentFile7 != null) {
                    this.fileOps.syncDirectory(parentFile7);
                }
                if (matches(containedFile2, archivePackageFileRecord)) {
                    return null;
                }
                failure2 = ArchivePackageCommitterKt.failure(ArchivePackageCommitErrorCode.TARGET_VERIFICATION_FAILED, archivePackageFileRecord.getRelativePath());
                return failure2;
            }
        }
    }

    private final boolean matches(File file, ArchivePackageFileRecord archivePackageFileRecord) {
        return this.verifyFile.invoke(file, Long.valueOf(archivePackageFileRecord.getSize()), Long.valueOf(archivePackageFileRecord.getCrc32())) instanceof WholeFileVerificationResult.Success;
    }

    private final boolean ensureDirectory(File file, File file2) {
        File canonicalFile = file.getCanonicalFile();
        if (!Intrinsics.areEqual(canonicalFile, file2)) {
            Intrinsics.checkNotNull(canonicalFile);
            if (!isStrictChild(canonicalFile, file2)) {
                return false;
            }
        }
        if (canonicalFile.exists()) {
            return canonicalFile.isDirectory();
        }
        ArchiveDirectoryCreator archiveDirectoryCreator = this.directoryCreator;
        Intrinsics.checkNotNull(canonicalFile);
        return archiveDirectoryCreator.createDirectories(canonicalFile) || canonicalFile.isDirectory();
    }

    private final File containedFile(File file, String str) {
        File canonicalFile = file.getCanonicalFile();
        File canonicalFile2 = new File(canonicalFile, str).getCanonicalFile();
        Intrinsics.checkNotNull(canonicalFile2);
        Intrinsics.checkNotNull(canonicalFile);
        if (isStrictChild(canonicalFile2, canonicalFile)) {
            return canonicalFile2;
        }
        return null;
    }

    private final boolean isStrictChild(File file, File file2) {
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        String path2 = file2.getPath();
        return StringsKt.startsWith$default(path, path2 + File.separator, false, 2, (Object) null);
    }

    private final boolean safeDeleteFile(File file, File file2) {
        File canonicalFile = file.getCanonicalFile();
        Intrinsics.checkNotNull(canonicalFile);
        File canonicalFile2 = file2.getCanonicalFile();
        Intrinsics.checkNotNullExpressionValue(canonicalFile2, "getCanonicalFile(...)");
        if (!isStrictChild(canonicalFile, canonicalFile2) || canonicalFile.isDirectory()) {
            return false;
        }
        return !canonicalFile.exists() || canonicalFile.delete();
    }

    private final void safeDeleteTree(File file, File file2) {
        if (file.exists()) {
            File canonicalFile = file2.getCanonicalFile();
            File canonicalFile2 = file.getCanonicalFile();
            Intrinsics.checkNotNull(canonicalFile2);
            Intrinsics.checkNotNull(canonicalFile);
            if (!isStrictChild(canonicalFile2, canonicalFile)) {
                throw new IOException("Refusing to delete updater path outside managed root");
            }
            deleteTreeNode(canonicalFile2, canonicalFile2);
        }
    }

    private final void deleteTreeNode(File file, File file2) {
        File canonicalFile = file.getCanonicalFile();
        if (!Intrinsics.areEqual(canonicalFile, file2)) {
            Intrinsics.checkNotNull(canonicalFile);
            if (!isStrictChild(canonicalFile, file2)) {
                throw new IOException("Refusing to follow path outside updater deletion root");
            }
        }
        if (canonicalFile.isDirectory()) {
            File[] listFiles = canonicalFile.listFiles();
            if (listFiles == null) {
                throw new IOException("Unable to list updater directory");
            }
            for (File file3 : listFiles) {
                Intrinsics.checkNotNull(file3);
                deleteTreeNode(file3, file2);
            }
        }
        if (canonicalFile.exists() && !canonicalFile.delete()) {
            throw new IOException("Unable to delete updater path");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchivePackageCommitter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/arizona/launcher/updater/archive/commit/ArchivePackageCommitter$CommitRoots;", "", "gameRoot", "Ljava/io/File;", "workRoot", "stagingRoot", "<init>", "(Ljava/io/File;Ljava/io/File;Ljava/io/File;)V", "getGameRoot", "()Ljava/io/File;", "getWorkRoot", "getStagingRoot", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class CommitRoots {
        private final File gameRoot;
        private final File stagingRoot;
        private final File workRoot;

        public static /* synthetic */ CommitRoots copy$default(CommitRoots commitRoots, File file, File file2, File file3, int i, Object obj) {
            if ((i & 1) != 0) {
                file = commitRoots.gameRoot;
            }
            if ((i & 2) != 0) {
                file2 = commitRoots.workRoot;
            }
            if ((i & 4) != 0) {
                file3 = commitRoots.stagingRoot;
            }
            return commitRoots.copy(file, file2, file3);
        }

        public final File component1() {
            return this.gameRoot;
        }

        public final File component2() {
            return this.workRoot;
        }

        public final File component3() {
            return this.stagingRoot;
        }

        public final CommitRoots copy(File gameRoot, File workRoot, File stagingRoot) {
            Intrinsics.checkNotNullParameter(gameRoot, "gameRoot");
            Intrinsics.checkNotNullParameter(workRoot, "workRoot");
            Intrinsics.checkNotNullParameter(stagingRoot, "stagingRoot");
            return new CommitRoots(gameRoot, workRoot, stagingRoot);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CommitRoots) {
                CommitRoots commitRoots = (CommitRoots) obj;
                return Intrinsics.areEqual(this.gameRoot, commitRoots.gameRoot) && Intrinsics.areEqual(this.workRoot, commitRoots.workRoot) && Intrinsics.areEqual(this.stagingRoot, commitRoots.stagingRoot);
            }
            return false;
        }

        public int hashCode() {
            return (((this.gameRoot.hashCode() * 31) + this.workRoot.hashCode()) * 31) + this.stagingRoot.hashCode();
        }

        public String toString() {
            File file = this.gameRoot;
            File file2 = this.workRoot;
            return "CommitRoots(gameRoot=" + file + ", workRoot=" + file2 + ", stagingRoot=" + this.stagingRoot + ")";
        }

        public CommitRoots(File gameRoot, File workRoot, File stagingRoot) {
            Intrinsics.checkNotNullParameter(gameRoot, "gameRoot");
            Intrinsics.checkNotNullParameter(workRoot, "workRoot");
            Intrinsics.checkNotNullParameter(stagingRoot, "stagingRoot");
            this.gameRoot = gameRoot;
            this.workRoot = workRoot;
            this.stagingRoot = stagingRoot;
        }

        public final File getGameRoot() {
            return this.gameRoot;
        }

        public final File getWorkRoot() {
            return this.workRoot;
        }

        public final File getStagingRoot() {
            return this.stagingRoot;
        }
    }

    /* compiled from: ArchivePackageCommitter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/arizona/launcher/updater/archive/commit/ArchivePackageCommitter$Companion;", "", "<init>", "()V", "DEFAULT_WORK_DIRECTORY", "", "BACKUP_DIRECTORY", "MAX_CRC32", "", "PACKAGE_ID", "Lkotlin/text/Regex;", "getPACKAGE_ID", "()Lkotlin/text/Regex;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Regex getPACKAGE_ID() {
            return ArchivePackageCommitter.PACKAGE_ID;
        }
    }
}
