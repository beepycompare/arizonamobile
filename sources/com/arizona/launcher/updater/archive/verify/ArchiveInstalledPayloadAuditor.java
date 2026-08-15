package com.arizona.launcher.updater.archive.verify;

import com.arizona.launcher.UpdateActivity;
import com.arizona.launcher.updater.archive.io.ArchiveLivePathSafety;
import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import com.arizona.launcher.updater.archive.state.ArchivePackageJournalEntry;
import com.arizona.launcher.updater.archive.state.ArchivePackagePhase;
import com.arizona.launcher.updater.archive.state.ArchiveUpdaterState;
import com.arizona.launcher.updater.archive.verify.ArchiveInstalledPayloadFileVerification;
import com.arizona.launcher.updater.archive.verify.GameRootResolution;
import com.arizona.launcher.updater.archive.verify.TargetResolution;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: ArchiveInstalledPayloadAuditor.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 $2\u00020\u0001:\u0001$B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eJ\"\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0002J\u001e\u0010 \u001a\u00020\b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\"2\u0006\u0010#\u001a\u00020\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b&\u0012\b\b'\u0012\u0004\b\u0003\u0010\u0002¨\u0006%"}, d2 = {"Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadAuditor;", "", "verifier", "Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadFileVerifier;", "metadataVerifier", "<init>", "(Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadFileVerifier;Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadFileVerifier;)V", "audit", "Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadAuditResult;", "gameRoot", "Ljava/io/File;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", UpdateActivity.UPDATE_MODE, "Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadAuditMode;", "auditPackage", "Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadMismatch;", "canonicalRoot", "archivePackage", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry;", "resolveGameRoot", "Lcom/arizona/launcher/updater/archive/verify/GameRootResolution;", "resolveTarget", "Lcom/arizona/launcher/updater/archive/verify/TargetResolution;", "relativePath", "", "unsafePathReason", "Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadMismatchReason;", "isStrictChild", "", "candidate", "root", "allPackagesMismatch", "packages", "", "reason", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveInstalledPayloadAuditor {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final String WORK_ROOT = ".archive-installing";
    private final ArchiveInstalledPayloadFileVerifier metadataVerifier;
    private final ArchiveInstalledPayloadFileVerifier verifier;

    /* compiled from: ArchiveInstalledPayloadAuditor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArchiveInstalledPayloadAuditMode.values().length];
            try {
                iArr[ArchiveInstalledPayloadAuditMode.FULL_INTEGRITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArchiveInstalledPayloadAuditMode.METADATA_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ArchiveInstalledPayloadAuditor() {
        this(null, null, 3, null);
    }

    public ArchiveInstalledPayloadAuditor(ArchiveInstalledPayloadFileVerifier verifier, ArchiveInstalledPayloadFileVerifier metadataVerifier) {
        Intrinsics.checkNotNullParameter(verifier, "verifier");
        Intrinsics.checkNotNullParameter(metadataVerifier, "metadataVerifier");
        this.verifier = verifier;
        this.metadataVerifier = metadataVerifier;
    }

    public /* synthetic */ ArchiveInstalledPayloadAuditor(JvmArchiveInstalledPayloadFileVerifier jvmArchiveInstalledPayloadFileVerifier, JvmArchiveInstalledPayloadMetadataVerifier jvmArchiveInstalledPayloadMetadataVerifier, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? JvmArchiveInstalledPayloadFileVerifier.INSTANCE : jvmArchiveInstalledPayloadFileVerifier, (i & 2) != 0 ? JvmArchiveInstalledPayloadMetadataVerifier.INSTANCE : jvmArchiveInstalledPayloadMetadataVerifier);
    }

    public static /* synthetic */ ArchiveInstalledPayloadAuditResult audit$default(ArchiveInstalledPayloadAuditor archiveInstalledPayloadAuditor, File file, ArchiveUpdaterState archiveUpdaterState, ArchiveInstalledPayloadAuditMode archiveInstalledPayloadAuditMode, int i, Object obj) {
        if ((i & 4) != 0) {
            archiveInstalledPayloadAuditMode = ArchiveInstalledPayloadAuditMode.FULL_INTEGRITY;
        }
        return archiveInstalledPayloadAuditor.audit(file, archiveUpdaterState, archiveInstalledPayloadAuditMode);
    }

    public final ArchiveInstalledPayloadAuditResult audit(File gameRoot, ArchiveUpdaterState state, ArchiveInstalledPayloadAuditMode mode) {
        Intrinsics.checkNotNullParameter(gameRoot, "gameRoot");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(mode, "mode");
        ArrayList arrayList = new ArrayList();
        for (Object obj : state.getPackages()) {
            if (((ArchivePackageJournalEntry) obj).getPhase() == ArchivePackagePhase.COMMITTED) {
                arrayList.add(obj);
            }
        }
        ArrayList<ArchivePackageJournalEntry> arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return ArchiveInstalledPayloadAuditResult.Companion.getVALID();
        }
        GameRootResolution resolveGameRoot = resolveGameRoot(gameRoot);
        if (resolveGameRoot instanceof GameRootResolution.Failure) {
            return allPackagesMismatch(arrayList2, ((GameRootResolution.Failure) resolveGameRoot).getReason());
        }
        Intrinsics.checkNotNull(resolveGameRoot, "null cannot be cast to non-null type com.arizona.launcher.updater.archive.verify.GameRootResolution.Success");
        File canonicalRoot = ((GameRootResolution.Success) resolveGameRoot).getCanonicalRoot();
        ArrayList arrayList3 = new ArrayList();
        ArchiveInstalledPayloadMismatch archiveInstalledPayloadMismatch = null;
        for (ArchivePackageJournalEntry archivePackageJournalEntry : arrayList2) {
            ArchiveInstalledPayloadMismatch auditPackage = auditPackage(canonicalRoot, archivePackageJournalEntry, mode);
            if (auditPackage != null) {
                arrayList3.add(archivePackageJournalEntry.getPackageId());
                if (archiveInstalledPayloadMismatch == null) {
                    archiveInstalledPayloadMismatch = auditPackage;
                }
            }
        }
        return new ArchiveInstalledPayloadAuditResult(arrayList3, archiveInstalledPayloadMismatch);
    }

    private final ArchiveInstalledPayloadMismatch auditPackage(File file, ArchivePackageJournalEntry archivePackageJournalEntry, ArchiveInstalledPayloadAuditMode archiveInstalledPayloadAuditMode) {
        ArchiveInstalledPayloadFileVerification.Mismatch mismatch;
        if (archivePackageJournalEntry.getFiles().isEmpty()) {
            return new ArchiveInstalledPayloadMismatch(archivePackageJournalEntry.getPackageId(), null, ArchiveInstalledPayloadMismatchReason.NO_COMMITTED_FILE_RECORDS);
        }
        for (ArchivePackageFileRecord archivePackageFileRecord : archivePackageJournalEntry.getFiles()) {
            TargetResolution resolveTarget = resolveTarget(file, archivePackageFileRecord.getRelativePath());
            if (!(resolveTarget instanceof TargetResolution.Success)) {
                if (!(resolveTarget instanceof TargetResolution.Failure)) {
                    throw new NoWhenBranchMatchedException();
                }
                return new ArchiveInstalledPayloadMismatch(archivePackageJournalEntry.getPackageId(), archivePackageFileRecord.getRelativePath(), ((TargetResolution.Failure) resolveTarget).getReason());
            }
            File file2 = ((TargetResolution.Success) resolveTarget).getFile();
            try {
                int i = WhenMappings.$EnumSwitchMapping$0[archiveInstalledPayloadAuditMode.ordinal()];
                if (i == 1) {
                    mismatch = this.verifier.verify(file2, archivePackageFileRecord.getSize(), archivePackageFileRecord.getCrc32());
                } else if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                    break;
                } else {
                    mismatch = this.metadataVerifier.verify(file2, archivePackageFileRecord.getSize(), archivePackageFileRecord.getCrc32());
                }
            } catch (IOException unused) {
                mismatch = new ArchiveInstalledPayloadFileVerification.Mismatch(ArchiveInstalledPayloadMismatchReason.IO_ERROR);
            } catch (SecurityException unused2) {
                mismatch = new ArchiveInstalledPayloadFileVerification.Mismatch(ArchiveInstalledPayloadMismatchReason.FILE_NOT_READABLE);
            }
            if (mismatch instanceof ArchiveInstalledPayloadFileVerification.Mismatch) {
                return new ArchiveInstalledPayloadMismatch(archivePackageJournalEntry.getPackageId(), archivePackageFileRecord.getRelativePath(), ((ArchiveInstalledPayloadFileVerification.Mismatch) mismatch).getReason());
            }
        }
        return null;
    }

    private final GameRootResolution resolveGameRoot(File file) {
        try {
            File file2 = file.toPath().toAbsolutePath().normalize().toFile();
            try {
                File canonicalFile = file.getCanonicalFile();
                if (Intrinsics.areEqual(file2.getPath(), canonicalFile.getPath())) {
                    ArchiveLivePathSafety archiveLivePathSafety = ArchiveLivePathSafety.INSTANCE;
                    Intrinsics.checkNotNull(file2);
                    if (!archiveLivePathSafety.isSymbolicLink(file2)) {
                        try {
                            if (!canonicalFile.exists()) {
                                return new GameRootResolution.Failure(ArchiveInstalledPayloadMismatchReason.ROOT_MISSING);
                            }
                            if (!canonicalFile.isDirectory()) {
                                return new GameRootResolution.Failure(ArchiveInstalledPayloadMismatchReason.ROOT_NOT_DIRECTORY);
                            }
                            if (!canonicalFile.canRead()) {
                                return new GameRootResolution.Failure(ArchiveInstalledPayloadMismatchReason.ROOT_NOT_READABLE);
                            }
                            Intrinsics.checkNotNull(canonicalFile);
                            return new GameRootResolution.Success(canonicalFile);
                        } catch (SecurityException unused) {
                            return new GameRootResolution.Failure(ArchiveInstalledPayloadMismatchReason.ROOT_NOT_READABLE);
                        }
                    }
                }
                return new GameRootResolution.Failure(ArchiveInstalledPayloadMismatchReason.SYMLINK_LIKE_CANONICAL_MISMATCH);
            } catch (IOException unused2) {
                return new GameRootResolution.Failure(ArchiveInstalledPayloadMismatchReason.ROOT_UNSAFE);
            } catch (SecurityException unused3) {
                return new GameRootResolution.Failure(ArchiveInstalledPayloadMismatchReason.ROOT_NOT_READABLE);
            }
        } catch (RuntimeException unused4) {
            return new GameRootResolution.Failure(ArchiveInstalledPayloadMismatchReason.ROOT_UNSAFE);
        }
    }

    private final TargetResolution resolveTarget(File file, String str) {
        ArchiveInstalledPayloadMismatchReason unsafePathReason = unsafePathReason(str);
        if (unsafePathReason != null) {
            return new TargetResolution.Failure(unsafePathReason);
        }
        try {
            File file2 = file;
            for (String str2 : StringsKt.split$default((CharSequence) str, new char[]{'/'}, false, 0, 6, (Object) null)) {
                file2 = new File(file2, str2);
            }
            File file3 = file2.toPath().toAbsolutePath().normalize().toFile();
            Intrinsics.checkNotNull(file3);
            if (!isStrictChild(file3, file)) {
                return new TargetResolution.Failure(ArchiveInstalledPayloadMismatchReason.PATH_ESCAPE);
            }
            if (ArchiveLivePathSafety.INSTANCE.isSymbolicLink(file3)) {
                return new TargetResolution.Failure(ArchiveInstalledPayloadMismatchReason.SYMLINK_LIKE_CANONICAL_MISMATCH);
            }
            try {
                File canonicalFile = file3.getCanonicalFile();
                Intrinsics.checkNotNull(canonicalFile);
                if (!isStrictChild(canonicalFile, file)) {
                    return new TargetResolution.Failure(ArchiveInstalledPayloadMismatchReason.PATH_ESCAPE);
                }
                if (ArchiveLivePathSafety.INSTANCE.hasUnsafeCanonicalAlias(file, file3, canonicalFile)) {
                    return new TargetResolution.Failure(ArchiveInstalledPayloadMismatchReason.SYMLINK_LIKE_CANONICAL_MISMATCH);
                }
                try {
                    if (!canonicalFile.exists()) {
                        return new TargetResolution.Failure(ArchiveInstalledPayloadMismatchReason.FILE_MISSING);
                    }
                    if (!canonicalFile.isFile()) {
                        return new TargetResolution.Failure(ArchiveInstalledPayloadMismatchReason.NOT_REGULAR_FILE);
                    }
                    return new TargetResolution.Success(canonicalFile);
                } catch (SecurityException unused) {
                    return new TargetResolution.Failure(ArchiveInstalledPayloadMismatchReason.FILE_NOT_READABLE);
                }
            } catch (IOException unused2) {
                return new TargetResolution.Failure(ArchiveInstalledPayloadMismatchReason.PATH_UNSAFE);
            } catch (SecurityException unused3) {
                return new TargetResolution.Failure(ArchiveInstalledPayloadMismatchReason.FILE_NOT_READABLE);
            }
        } catch (RuntimeException unused4) {
            return new TargetResolution.Failure(ArchiveInstalledPayloadMismatchReason.PATH_UNSAFE);
        }
    }

    private final ArchiveInstalledPayloadMismatchReason unsafePathReason(String str) {
        String str2 = str;
        int i = 0;
        List split$default = StringsKt.split$default((CharSequence) str2, new char[]{'/'}, false, 0, 6, (Object) null);
        List<String> list = split$default;
        boolean z = list instanceof Collection;
        if (!z || !list.isEmpty()) {
            for (String str3 : list) {
                if (Intrinsics.areEqual(str3, "..")) {
                    break;
                }
            }
        }
        if (StringsKt.startsWith$default((CharSequence) str2, '/', false, 2, (Object) null) || new File(str).isAbsolute()) {
            return ArchiveInstalledPayloadMismatchReason.PATH_ESCAPE;
        }
        if (!StringsKt.isBlank(str2) && Intrinsics.areEqual(str, StringsKt.trim((CharSequence) str2).toString()) && !StringsKt.contains$default((CharSequence) str2, (char) AbstractJsonLexerKt.STRING_ESC, false, 2, (Object) null)) {
            while (true) {
                if (i < str2.length()) {
                    if (Character.isISOControl(str2.charAt(i))) {
                        break;
                    }
                    i++;
                } else {
                    if (!z || !list.isEmpty()) {
                        for (String str4 : list) {
                            if (str4.length() != 0) {
                                if (Intrinsics.areEqual(str4, ".")) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    if (!StringsKt.equals((String) CollectionsKt.first((List<? extends Object>) split$default), ".archive-installing", true)) {
                        return null;
                    }
                }
            }
        }
        return ArchiveInstalledPayloadMismatchReason.PATH_UNSAFE;
    }

    private final boolean isStrictChild(File file, File file2) {
        Path path = file.toPath();
        Path path2 = file2.toPath();
        return !Intrinsics.areEqual(path, path2) && path.startsWith(path2);
    }

    private final ArchiveInstalledPayloadAuditResult allPackagesMismatch(List<ArchivePackageJournalEntry> list, ArchiveInstalledPayloadMismatchReason archiveInstalledPayloadMismatchReason) {
        List<ArchivePackageJournalEntry> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ArchivePackageJournalEntry archivePackageJournalEntry : list2) {
            arrayList.add(archivePackageJournalEntry.getPackageId());
        }
        return new ArchiveInstalledPayloadAuditResult(arrayList, new ArchiveInstalledPayloadMismatch(((ArchivePackageJournalEntry) CollectionsKt.first((List<? extends Object>) list)).getPackageId(), null, archiveInstalledPayloadMismatchReason));
    }

    /* compiled from: ArchiveInstalledPayloadAuditor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadAuditor$Companion;", "", "<init>", "()V", "WORK_ROOT", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
