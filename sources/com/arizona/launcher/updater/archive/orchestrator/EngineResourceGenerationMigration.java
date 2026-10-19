package com.arizona.launcher.updater.archive.orchestrator;

import coil3.util.UtilsKt;
import com.arizona.launcher.UpdateServiceContract;
import com.arizona.launcher.updater.archive.commit.ArchivePackageCommitter;
import com.arizona.launcher.updater.archive.io.AndroidArchiveNodeInspector;
import com.arizona.launcher.updater.archive.io.ArchiveFsNodeType;
import com.arizona.launcher.updater.archive.io.ArchiveLivePathSafety;
import com.arizona.launcher.updater.archive.io.ArchiveNodeInspector;
import com.arizona.launcher.updater.archive.model.ArchiveEntryMetadata;
import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import com.arizona.launcher.updater.archive.model.ArchivePackage;
import com.arizona.launcher.updater.archive.orchestrator.EngineResourceCleanupResult;
import com.arizona.launcher.updater.archive.state.ArchiveFileRetirementRecord;
import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import com.arizona.launcher.updater.archive.state.ArchivePackageJournalEntry;
import com.arizona.launcher.updater.archive.state.ArchiveStateLoadResult;
import com.arizona.launcher.updater.archive.state.ArchiveUpdaterState;
import com.arizona.launcher.updater.archive.state.DurableArchiveStateStore;
import com.arizona.launcher.updater.archive.transaction.ArchiveOwnershipDiffPlanner;
import com.arizona.launcher.updater.archive.transaction.ArchiveOwnershipException;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.miami.game.core.settings.game_test.GameTestScriptPreferences;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: EngineResourceGenerationMigration.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 :2\u00020\u0001:\u00029:B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\"\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J4\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!H\u0002J0\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u001bH\u0002J\u0018\u0010(\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\rH\u0002J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0010H\u0002J\u0018\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\rH\u0002J\u0010\u00100\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u0010H\u0002J\u0018\u00101\u001a\u0002022\u0006\u0010 \u001a\u00020!2\u0006\u00103\u001a\u00020\rH\u0002J\u0018\u00104\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\rH\u0002J\u0018\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b<\u0012\b\b=\u0012\u0004\b\u0003\u0010\u0000¨\u0006;"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationMigration;", "", "nodeInspector", "Lcom/arizona/launcher/updater/archive/io/ArchiveNodeInspector;", "<init>", "(Lcom/arizona/launcher/updater/archive/io/ArchiveNodeInspector;)V", "cleanup", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceCleanupResult;", "request", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceCleanupRequest;", "legacyDirectoryTargets", "", "Lkotlin/Pair;", "", "Lcom/arizona/launcher/updater/archive/io/ArchiveFsNodeType;", "gameRoot", "Ljava/io/File;", "ownedRelativePaths", "baseDesired", "Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", "viceDesired", "baseState", "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "viceState", "preflightOwnedRoots", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceCleanupResult$Failure;", "isFallbackCacheAnchor", "", "validateFallbackAnchor", "restoreEmptyFallbackAnchor", "", "stateRoot", "store", "Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;", "requireExpectedChain", "root", "actual", "relative", Constants.ScionAnalytics.PARAM_LABEL, "allowFinalSymlink", "inspectLiveFile", "relativePath", "validateMapCache", "deleteMapCache", "deleteOwnedTree", "deleteExact", UtilsKt.SCHEME_FILE, "description", "inspect", "loadJournal", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationMigration$JournalLoad;", "lane", "relativeFile", "failure", "code", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckBlockCode;", UpdateServiceContract.BundleKey.DETAIL, "JournalLoad", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EngineResourceGenerationMigration {
    public static final String MAP_CACHE_FILE = "MAPCACHE.BIN";
    private final ArchiveNodeInspector nodeInspector;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Set<String> PROTECTED_ROOTS = SetsKt.setOf((Object[]) new String[]{"logcat", "recent-log-share", "azvoice", "modloader", GameTestScriptPreferences.IMPORTED_SCRIPT_DIR, GameTestScriptPreferences.SCREENSHOT_OUTPUT_DIR});

    /* compiled from: EngineResourceGenerationMigration.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArchiveFsNodeType.values().length];
            try {
                iArr[ArchiveFsNodeType.ABSENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArchiveFsNodeType.REGULAR_FILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ArchiveFsNodeType.DIRECTORY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ArchiveFsNodeType.SYMBOLIC_LINK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ArchiveFsNodeType.OTHER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public EngineResourceGenerationMigration(ArchiveNodeInspector nodeInspector) {
        Intrinsics.checkNotNullParameter(nodeInspector, "nodeInspector");
        this.nodeInspector = nodeInspector;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x00fd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00ad A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final EngineResourceCleanupResult cleanup(EngineResourceCleanupRequest request) {
        Object obj;
        EngineResourceCleanupResult.Failure validateFallbackAnchor;
        Intrinsics.checkNotNullParameter(request, "request");
        EngineResourceCleanupResult.Failure preflightOwnedRoots = preflightOwnedRoots(request);
        if (preflightOwnedRoots != null) {
            return preflightOwnedRoots;
        }
        boolean isFallbackCacheAnchor = isFallbackCacheAnchor(request);
        if (!isFallbackCacheAnchor || (validateFallbackAnchor = validateFallbackAnchor(request)) == null) {
            File absoluteFile = request.getGameRoot().getAbsoluteFile();
            JournalLoad loadJournal = loadJournal(request.getBaseStateStore(), "BASE");
            if (!(loadJournal instanceof JournalLoad.Ready)) {
                if (loadJournal instanceof JournalLoad.Failed) {
                    return ((JournalLoad.Failed) loadJournal).getFailure();
                }
                throw new NoWhenBranchMatchedException();
            }
            ArchiveUpdaterState state = ((JournalLoad.Ready) loadJournal).getState();
            JournalLoad loadJournal2 = loadJournal(request.getViceStateStore(), "VICE");
            if (!(loadJournal2 instanceof JournalLoad.Ready)) {
                if (loadJournal2 instanceof JournalLoad.Failed) {
                    return ((JournalLoad.Failed) loadJournal2).getFailure();
                }
                throw new NoWhenBranchMatchedException();
            }
            try {
                List<String> ownedRelativePaths = ownedRelativePaths(request.getBaseDesired(), request.getViceDesired(), state, ((JournalLoad.Ready) loadJournal2).getState());
                Companion companion = Companion;
                Iterator<T> it = ownedRelativePaths.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (companion.isProtectedRelativePath$app((String) obj)) {
                        break;
                    }
                }
                String str = (String) obj;
                if (str != null) {
                    return failure(ArchiveUpdateCheckBlockCode.STATE_INVALID, "Resource generation migration refuses protected path '" + str + "'");
                }
                try {
                    ArrayList arrayList = new ArrayList();
                    for (String str2 : ownedRelativePaths) {
                        Intrinsics.checkNotNull(absoluteFile);
                        int i = WhenMappings.$EnumSwitchMapping$0[inspectLiveFile(absoluteFile, str2).ordinal()];
                        if (i != 1) {
                            if (i == 2) {
                                if (!StringsKt.contains$default((CharSequence) str2, '/', false, 2, (Object) null)) {
                                    if (str2 == null) {
                                        arrayList.add(str2);
                                    }
                                }
                            } else {
                                throw new IOException("Live resource path '" + str2 + "' is not a regular file");
                            }
                        }
                        str2 = null;
                        if (str2 == null) {
                        }
                    }
                    ArrayList<String> arrayList2 = arrayList;
                    Intrinsics.checkNotNull(absoluteFile);
                    List<Pair<String, ArchiveFsNodeType>> legacyDirectoryTargets = legacyDirectoryTargets(absoluteFile);
                    validateMapCache(absoluteFile);
                    try {
                        for (String str3 : arrayList2) {
                            int i2 = WhenMappings.$EnumSwitchMapping$0[inspectLiveFile(absoluteFile, str3).ordinal()];
                            if (i2 != 1) {
                                if (i2 == 2) {
                                    deleteExact(relativeFile(absoluteFile, str3), "live resource file '" + str3 + "'");
                                } else {
                                    throw new IOException("Live resource path '" + str3 + "' is not a regular file");
                                }
                            }
                        }
                        Iterator<T> it2 = legacyDirectoryTargets.iterator();
                        while (it2.hasNext()) {
                            Pair pair = (Pair) it2.next();
                            String str4 = (String) pair.component1();
                            ArchiveFsNodeType archiveFsNodeType = (ArchiveFsNodeType) pair.component2();
                            ArchiveFsNodeType inspectLiveFile = inspectLiveFile(absoluteFile, str4);
                            if (WhenMappings.$EnumSwitchMapping$0[inspectLiveFile.ordinal()] != 1) {
                                if (inspectLiveFile == archiveFsNodeType) {
                                    deleteExact(relativeFile(absoluteFile, str4), "legacy resource '" + str4 + "'");
                                } else {
                                    throw new IOException("Legacy resource '" + str4 + "' changed type to " + inspectLiveFile);
                                }
                            }
                        }
                        deleteMapCache(absoluteFile);
                        File absoluteFile2 = request.getWorkRoot().getAbsoluteFile();
                        Intrinsics.checkNotNullExpressionValue(absoluteFile2, "getAbsoluteFile(...)");
                        deleteOwnedTree(absoluteFile2);
                        File absoluteFile3 = request.getBaseDownloadRoot().getAbsoluteFile();
                        Intrinsics.checkNotNullExpressionValue(absoluteFile3, "getAbsoluteFile(...)");
                        deleteOwnedTree(absoluteFile3);
                        File absoluteFile4 = request.getViceDownloadRoot().getAbsoluteFile();
                        Intrinsics.checkNotNullExpressionValue(absoluteFile4, "getAbsoluteFile(...)");
                        deleteOwnedTree(absoluteFile4);
                        request.getBaseStateStore().clear();
                        request.getViceStateStore().clear();
                        if (isFallbackCacheAnchor) {
                            restoreEmptyFallbackAnchor(request.getGameRoot());
                        }
                        return EngineResourceCleanupResult.Success.INSTANCE;
                    } catch (IOException e) {
                        ArchiveUpdateCheckBlockCode archiveUpdateCheckBlockCode = ArchiveUpdateCheckBlockCode.STATE_IO_FAILED;
                        String message = e.getMessage();
                        if (message == null) {
                            message = "resource generation cleanup failed";
                        }
                        return failure(archiveUpdateCheckBlockCode, message);
                    }
                } catch (IOException e2) {
                    ArchiveUpdateCheckBlockCode archiveUpdateCheckBlockCode2 = ArchiveUpdateCheckBlockCode.STATE_INVALID;
                    String message2 = e2.getMessage();
                    if (message2 == null) {
                        message2 = "unsafe live resource path";
                    }
                    return failure(archiveUpdateCheckBlockCode2, message2);
                }
            } catch (ArchiveOwnershipException e3) {
                ArchiveUpdateCheckBlockCode archiveUpdateCheckBlockCode3 = ArchiveUpdateCheckBlockCode.STATE_INVALID;
                String message3 = e3.getMessage();
                return failure(archiveUpdateCheckBlockCode3, message3 != null ? message3 : "unsafe path");
            } catch (IllegalArgumentException e4) {
                ArchiveUpdateCheckBlockCode archiveUpdateCheckBlockCode4 = ArchiveUpdateCheckBlockCode.STATE_INVALID;
                String message4 = e4.getMessage();
                return failure(archiveUpdateCheckBlockCode4, message4 != null ? message4 : "unsafe path");
            }
        }
        return validateFallbackAnchor;
    }

    private final List<Pair<String, ArchiveFsNodeType>> legacyDirectoryTargets(File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("Unable to list game root for legacy resource cleanup");
        }
        for (File file2 : listFiles) {
            if (!Intrinsics.areEqual(file2.getName(), ArchivePackageCommitter.DEFAULT_WORK_DIRECTORY) && !Intrinsics.areEqual(file2.getName(), MAP_CACHE_FILE)) {
                Companion companion = Companion;
                String name = file2.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                if (companion.isProtectedRelativePath$app(name)) {
                    continue;
                } else {
                    Intrinsics.checkNotNull(file2);
                    int i = WhenMappings.$EnumSwitchMapping$0[inspect(file2).ordinal()];
                    if (i != 1 && i != 2) {
                        if (i != 3) {
                            if (i == 4 || i == 5) {
                                throw new IOException("Refusing linked or special legacy resource '" + file2.getName() + "'");
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        String name2 = file2.getName();
                        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                        legacyDirectoryTargets$collect(this, arrayList, file2, name2);
                    }
                }
            }
        }
        return arrayList;
    }

    private static final boolean legacyDirectoryTargets$collect(EngineResourceGenerationMigration engineResourceGenerationMigration, List<Pair<String, ArchiveFsNodeType>> list, File file, String str) {
        if (Companion.isProtectedRelativePath$app(str)) {
            return true;
        }
        ArchiveFsNodeType inspect = engineResourceGenerationMigration.inspect(file);
        int i = WhenMappings.$EnumSwitchMapping$0[inspect.ordinal()];
        if (i != 1) {
            if (i == 2) {
                list.add(TuplesKt.to(str, inspect));
            } else if (i != 3) {
                if (i == 4 || i == 5) {
                    throw new IOException("Refusing linked or special legacy resource '" + str + "'");
                }
                throw new NoWhenBranchMatchedException();
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    throw new IOException("Unable to list legacy resource directory '" + str + "'");
                }
                boolean z = false;
                for (File file2 : listFiles) {
                    Intrinsics.checkNotNull(file2);
                    if (legacyDirectoryTargets$collect(engineResourceGenerationMigration, list, file2, str + "/" + file2.getName())) {
                        z = true;
                    }
                }
                if (z) {
                    return true;
                }
                list.add(TuplesKt.to(str, inspect));
            }
        }
        return false;
    }

    private final List<String> ownedRelativePaths(ArchiveManifest archiveManifest, ArchiveManifest archiveManifest2, ArchiveUpdaterState archiveUpdaterState, ArchiveUpdaterState archiveUpdaterState2) {
        List<ArchiveFileRetirementRecord> pendingRetirements;
        List<ArchivePackageJournalEntry> packages;
        List<ArchivePackage> packages2;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (ArchiveManifest archiveManifest3 : CollectionsKt.listOf((Object[]) new ArchiveManifest[]{archiveManifest, archiveManifest2})) {
            if (archiveManifest3 != null && (packages2 = archiveManifest3.getPackages()) != null) {
                for (ArchivePackage archivePackage : packages2) {
                    List<ArchiveEntryMetadata> entries = archivePackage.getEntries();
                    if (entries == null) {
                        throw new IllegalArgumentException("Resource generation requires a complete entry inventory for '" + archivePackage.getId() + "'");
                    }
                    for (ArchiveEntryMetadata archiveEntryMetadata : entries) {
                        ownedRelativePaths$add(linkedHashSet, archiveEntryMetadata.getTargetRelativePath());
                    }
                }
                continue;
            }
        }
        for (ArchiveUpdaterState archiveUpdaterState3 : CollectionsKt.listOf((Object[]) new ArchiveUpdaterState[]{archiveUpdaterState, archiveUpdaterState2})) {
            if (archiveUpdaterState3 != null && (packages = archiveUpdaterState3.getPackages()) != null) {
                for (ArchivePackageJournalEntry archivePackageJournalEntry : packages) {
                    for (ArchivePackageFileRecord archivePackageFileRecord : archivePackageJournalEntry.getFiles()) {
                        ownedRelativePaths$add(linkedHashSet, archivePackageFileRecord.getRelativePath());
                    }
                    for (ArchivePackageFileRecord archivePackageFileRecord2 : archivePackageJournalEntry.getDesiredFiles()) {
                        ownedRelativePaths$add(linkedHashSet, archivePackageFileRecord2.getRelativePath());
                    }
                    for (ArchivePackageFileRecord archivePackageFileRecord3 : archivePackageJournalEntry.getPreviousFiles()) {
                        ownedRelativePaths$add(linkedHashSet, archivePackageFileRecord3.getRelativePath());
                    }
                }
            }
            if (archiveUpdaterState3 != null && (pendingRetirements = archiveUpdaterState3.getPendingRetirements()) != null) {
                for (ArchiveFileRetirementRecord archiveFileRetirementRecord : pendingRetirements) {
                    ownedRelativePaths$add(linkedHashSet, archiveFileRetirementRecord.getRelativePath());
                }
            }
        }
        return CollectionsKt.toList(linkedHashSet);
    }

    private static final void ownedRelativePaths$add(LinkedHashSet<String> linkedHashSet, String str) {
        ArchiveOwnershipDiffPlanner.INSTANCE.validateRelativePath(str, "resource generation");
        linkedHashSet.add(str);
    }

    private final EngineResourceCleanupResult.Failure preflightOwnedRoots(EngineResourceCleanupRequest engineResourceCleanupRequest) {
        EngineResourceGenerationMigration engineResourceGenerationMigration;
        EngineResourceGenerationMigration engineResourceGenerationMigration2;
        File absoluteFile = engineResourceCleanupRequest.getGameRoot().getAbsoluteFile();
        File absoluteFile2 = engineResourceCleanupRequest.getCacheRoot().getAbsoluteFile();
        File absoluteFile3 = engineResourceCleanupRequest.getNoBackupRoot().getAbsoluteFile();
        Intrinsics.checkNotNull(absoluteFile);
        if (inspect(absoluteFile) != ArchiveFsNodeType.DIRECTORY) {
            return failure(ArchiveUpdateCheckBlockCode.GAME_ROOT_UNAVAILABLE, "Game root is not a real directory");
        }
        Intrinsics.checkNotNull(absoluteFile2);
        if (inspect(absoluteFile2) != ArchiveFsNodeType.DIRECTORY) {
            return failure(ArchiveUpdateCheckBlockCode.STATE_INVALID, "Cache root is not a real directory");
        }
        Intrinsics.checkNotNull(absoluteFile3);
        if (inspect(absoluteFile3) != ArchiveFsNodeType.DIRECTORY) {
            return failure(ArchiveUpdateCheckBlockCode.STATE_INVALID, "noBackup root is not a real directory");
        }
        try {
            engineResourceGenerationMigration = this;
            try {
                engineResourceGenerationMigration.requireExpectedChain(absoluteFile2, engineResourceCleanupRequest.getBaseDownloadRoot(), "archive-updater/downloads", "BASE download root", true);
                engineResourceGenerationMigration.requireExpectedChain(absoluteFile2, engineResourceCleanupRequest.getViceDownloadRoot(), "archive-updater/vice/downloads", "VICE download root", true);
                engineResourceGenerationMigration2 = engineResourceGenerationMigration;
                try {
                } catch (IOException e) {
                    e = e;
                    engineResourceGenerationMigration = engineResourceGenerationMigration2;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e = e3;
            engineResourceGenerationMigration = this;
        }
        try {
            engineResourceGenerationMigration2.requireExpectedChain(absoluteFile, engineResourceCleanupRequest.getWorkRoot(), ArchivePackageCommitter.DEFAULT_WORK_DIRECTORY, "archive work root", true);
            engineResourceGenerationMigration = engineResourceGenerationMigration2;
            engineResourceGenerationMigration.requireExpectedChain(absoluteFile3, engineResourceGenerationMigration.stateRoot(engineResourceCleanupRequest.getBaseStateStore()), "archive-updater", "BASE journal root", false);
            engineResourceGenerationMigration2 = engineResourceGenerationMigration;
            engineResourceGenerationMigration2.requireExpectedChain(absoluteFile3, engineResourceGenerationMigration.stateRoot(engineResourceCleanupRequest.getViceStateStore()), "archive-updater/vice", "VICE journal root", false);
            return null;
        } catch (IOException e4) {
            e = e4;
            engineResourceGenerationMigration = engineResourceGenerationMigration2;
            ArchiveUpdateCheckBlockCode archiveUpdateCheckBlockCode = ArchiveUpdateCheckBlockCode.STATE_INVALID;
            String message = e.getMessage();
            if (message == null) {
                message = "unsafe updater root";
            }
            return engineResourceGenerationMigration.failure(archiveUpdateCheckBlockCode, message);
        }
    }

    private final boolean isFallbackCacheAnchor(EngineResourceCleanupRequest engineResourceCleanupRequest) {
        File absoluteFile = engineResourceCleanupRequest.getGameRoot().getAbsoluteFile();
        Intrinsics.checkNotNullExpressionValue(absoluteFile, "getAbsoluteFile(...)");
        File normalize = FilesKt.normalize(absoluteFile);
        File absoluteFile2 = engineResourceCleanupRequest.getCacheRoot().getAbsoluteFile();
        Intrinsics.checkNotNullExpressionValue(absoluteFile2, "getAbsoluteFile(...)");
        File normalize2 = FilesKt.normalize(absoluteFile2);
        File absoluteFile3 = ArchiveUpdaterStorageRoots.Companion.fallbackCacheAnchor(normalize).getAbsoluteFile();
        Intrinsics.checkNotNullExpressionValue(absoluteFile3, "getAbsoluteFile(...)");
        return new ArchiveLivePathSafety(this.nodeInspector).isSamePathIgnoringCase(FilesKt.normalize(absoluteFile3), normalize2);
    }

    private final EngineResourceCleanupResult.Failure validateFallbackAnchor(EngineResourceCleanupRequest engineResourceCleanupRequest) {
        EngineResourceGenerationMigration engineResourceGenerationMigration;
        File absoluteFile;
        try {
            absoluteFile = engineResourceCleanupRequest.getGameRoot().getAbsoluteFile();
            Intrinsics.checkNotNullExpressionValue(absoluteFile, "getAbsoluteFile(...)");
            engineResourceGenerationMigration = this;
        } catch (IOException e) {
            e = e;
            engineResourceGenerationMigration = this;
        }
        try {
            engineResourceGenerationMigration.requireExpectedChain(absoluteFile, engineResourceCleanupRequest.getCacheRoot(), ArchiveUpdaterStorageRoots.FALLBACK_CACHE_ANCHOR_RELATIVE, "fallback download anchor", false);
            return null;
        } catch (IOException e2) {
            e = e2;
            ArchiveUpdateCheckBlockCode archiveUpdateCheckBlockCode = ArchiveUpdateCheckBlockCode.STATE_INVALID;
            String message = e.getMessage();
            if (message == null) {
                message = "unsafe fallback download anchor";
            }
            return engineResourceGenerationMigration.failure(archiveUpdateCheckBlockCode, message);
        }
    }

    private final void restoreEmptyFallbackAnchor(File file) {
        File absoluteFile = file.getAbsoluteFile();
        Intrinsics.checkNotNullExpressionValue(absoluteFile, "getAbsoluteFile(...)");
        File normalize = FilesKt.normalize(absoluteFile);
        if (inspect(normalize) != ArchiveFsNodeType.DIRECTORY) {
            throw new IOException("Game root is not a real directory");
        }
        File absoluteFile2 = ArchiveUpdaterStorageRoots.Companion.fallbackCacheAnchor(normalize).getAbsoluteFile();
        Intrinsics.checkNotNullExpressionValue(absoluteFile2, "getAbsoluteFile(...)");
        File normalize2 = FilesKt.normalize(absoluteFile2);
        ArchiveLivePathSafety archiveLivePathSafety = new ArchiveLivePathSafety(this.nodeInspector);
        if (archiveLivePathSafety.isStrictChild(normalize2, normalize)) {
            File absoluteFile3 = ArchiveUpdaterStorageRoots.Companion.fallbackCacheAnchor(normalize).getAbsoluteFile();
            Intrinsics.checkNotNullExpressionValue(absoluteFile3, "getAbsoluteFile(...)");
            if (archiveLivePathSafety.isSamePathIgnoringCase(FilesKt.normalize(absoluteFile3), normalize2)) {
                File file2 = normalize;
                for (String str : StringsKt.split$default((CharSequence) ArchiveUpdaterStorageRoots.FALLBACK_CACHE_ANCHOR_RELATIVE, new char[]{'/'}, false, 0, 6, (Object) null)) {
                    File file3 = new File(file2, str);
                    int i = WhenMappings.$EnumSwitchMapping$0[inspect(file3).ordinal()];
                    if (i == 1) {
                        if (inspect(file2) != ArchiveFsNodeType.DIRECTORY) {
                            throw new IOException("Fallback download anchor parent is not a real directory");
                        }
                        if (!file3.mkdir() && inspect(file3) != ArchiveFsNodeType.DIRECTORY) {
                            throw new IOException("Unable to restore fallback download anchor");
                        }
                        if (inspect(file3) != ArchiveFsNodeType.DIRECTORY) {
                            throw new IOException("Fallback download anchor is not a real directory");
                        }
                    } else {
                        if (i != 2) {
                            if (i != 3) {
                                if (i != 4 && i != 5) {
                                    throw new NoWhenBranchMatchedException();
                                }
                            }
                        }
                        throw new IOException("Fallback download anchor refuses '" + file3.getPath() + "'");
                    }
                    file2 = file3;
                }
                requireExpectedChain(normalize, normalize2, ArchiveUpdaterStorageRoots.FALLBACK_CACHE_ANCHOR_RELATIVE, "fallback download anchor", false);
                File[] listFiles = normalize2.listFiles();
                if (listFiles == null) {
                    throw new IOException("Unable to list fallback download anchor");
                }
                if (!(listFiles.length == 0)) {
                    throw new IOException("Fallback download anchor is not empty");
                }
                return;
            }
        }
        throw new IOException("Fallback download anchor escapes the game root");
    }

    private final File stateRoot(DurableArchiveStateStore durableArchiveStateStore) {
        File parentFile = ((File) CollectionsKt.first((List<? extends Object>) durableArchiveStateStore.managedFiles())).getParentFile();
        if (parentFile != null) {
            return parentFile;
        }
        throw new IOException("Archive journal root is unavailable");
    }

    private final void requireExpectedChain(File file, File file2, String str, String str2, boolean z) {
        File absoluteFile = new File(file, str).getAbsoluteFile();
        Intrinsics.checkNotNullExpressionValue(absoluteFile, "getAbsoluteFile(...)");
        File normalize = FilesKt.normalize(absoluteFile);
        File absoluteFile2 = file2.getAbsoluteFile();
        Intrinsics.checkNotNullExpressionValue(absoluteFile2, "getAbsoluteFile(...)");
        File normalize2 = FilesKt.normalize(absoluteFile2);
        if (!new ArchiveLivePathSafety(this.nodeInspector).isSamePathIgnoringCase(normalize, normalize2)) {
            throw new IOException(str2 + " is not the owned path under '" + file.getPath() + "'");
        }
        List split$default = StringsKt.split$default((CharSequence) str, new char[]{'/'}, false, 0, 6, (Object) null);
        File absoluteFile3 = file.getAbsoluteFile();
        Intrinsics.checkNotNullExpressionValue(absoluteFile3, "getAbsoluteFile(...)");
        File normalize3 = FilesKt.normalize(absoluteFile3);
        int i = 0;
        for (Object obj : split$default) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            File file3 = new File(normalize3, (String) obj);
            boolean z2 = i == CollectionsKt.getLastIndex(split$default);
            int i3 = WhenMappings.$EnumSwitchMapping$0[inspect(file3).ordinal()];
            if (i3 == 1) {
                if (!z2 && inspect(normalize2) != ArchiveFsNodeType.ABSENT) {
                    throw new IOException(str2 + " exists through a missing parent");
                }
                return;
            }
            if (i3 != 2) {
                if (i3 == 3) {
                    i = i2;
                    normalize3 = file3;
                } else if (i3 == 4) {
                    if (!z2 || !z) {
                        throw new IOException(str2 + " refuses symbolic link '" + file3.getPath() + "'");
                    }
                    return;
                } else if (i3 != 5) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            throw new IOException(str2 + " refuses non-directory '" + file3.getPath() + "'");
        }
    }

    private final ArchiveFsNodeType inspectLiveFile(File file, String str) {
        List split$default = StringsKt.split$default((CharSequence) str, new char[]{'/'}, false, 0, 6, (Object) null);
        int i = 0;
        for (Object obj : split$default) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            File file2 = new File(file, (String) obj);
            ArchiveFsNodeType inspect = inspect(file2);
            boolean z = i == CollectionsKt.getLastIndex(split$default);
            int i3 = WhenMappings.$EnumSwitchMapping$0[inspect.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4 || i3 == 5) {
                            throw new IOException("Refusing to follow or delete a linked live resource path '" + str + "'");
                        }
                        throw new NoWhenBranchMatchedException();
                    } else if (!z) {
                        i = i2;
                        file = file2;
                    }
                } else if (!z) {
                    throw new IOException("A file is used as a parent of '" + str + "'");
                }
                return inspect;
            }
            return ArchiveFsNodeType.ABSENT;
        }
        return ArchiveFsNodeType.ABSENT;
    }

    private final void validateMapCache(File file) {
        int i = WhenMappings.$EnumSwitchMapping$0[inspect(new File(file, MAP_CACHE_FILE)).ordinal()];
        if (i != 1 && i != 2 && i != 4) {
            throw new IOException("MAPCACHE.BIN is not a file owned by the updater");
        }
    }

    private final void deleteMapCache(File file) {
        File file2 = new File(file, MAP_CACHE_FILE);
        int i = WhenMappings.$EnumSwitchMapping$0[inspect(file2).ordinal()];
        if (i != 1) {
            if (i == 2) {
                deleteExact(file2, MAP_CACHE_FILE);
                return;
            }
            if (i != 3) {
                if (i == 4) {
                    deleteExact(file2, "MAPCACHE.BIN symbolic link");
                    return;
                } else if (i != 5) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            throw new IOException("MAPCACHE.BIN is not a file owned by the updater");
        }
    }

    private final void deleteOwnedTree(File file) {
        int i = WhenMappings.$EnumSwitchMapping$0[inspect(file).ordinal()];
        if (i != 1) {
            if (i == 2) {
                deleteExact(file, "updater-owned file '" + file.getPath() + "'");
            } else if (i == 3) {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    throw new IOException("Unable to list updater-owned directory '" + file.getPath() + "'");
                }
                for (File file2 : listFiles) {
                    File parentFile = file2.getParentFile();
                    if (!Intrinsics.areEqual(parentFile != null ? parentFile.getAbsoluteFile() : null, file.getAbsoluteFile()) || Intrinsics.areEqual(file2.getName(), ".") || Intrinsics.areEqual(file2.getName(), "..")) {
                        throw new IOException("Updater cleanup received a child outside '" + file.getPath() + "'");
                    }
                    Intrinsics.checkNotNull(file2);
                    deleteOwnedTree(file2);
                }
                deleteExact(file, "updater-owned directory '" + file.getPath() + "'");
            } else if (i != 4) {
                if (i == 5) {
                    throw new IOException("Refusing to delete special updater node '" + file.getPath() + "'");
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                deleteExact(file, "updater-owned symbolic link '" + file.getPath() + "'");
            }
        }
    }

    private final void deleteExact(File file, String str) {
        if (!file.delete() && inspect(file) != ArchiveFsNodeType.ABSENT) {
            throw new IOException("Unable to delete " + str);
        }
    }

    private final ArchiveFsNodeType inspect(File file) {
        try {
            return this.nodeInspector.nodeType(file);
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            throw new IOException("Unable to inspect '" + file.getPath() + "'", e2);
        }
    }

    private final JournalLoad loadJournal(DurableArchiveStateStore durableArchiveStateStore, String str) {
        try {
            ArchiveStateLoadResult load = durableArchiveStateStore.load();
            if (Intrinsics.areEqual(load, ArchiveStateLoadResult.Missing.INSTANCE)) {
                return new JournalLoad.Ready(null);
            }
            if (load instanceof ArchiveStateLoadResult.Loaded) {
                return new JournalLoad.Ready(((ArchiveStateLoadResult.Loaded) load).getState());
            }
            if (!(load instanceof ArchiveStateLoadResult.Corrupt)) {
                throw new NoWhenBranchMatchedException();
            }
            return new JournalLoad.Failed(failure(ArchiveUpdateCheckBlockCode.STATE_CORRUPT, str + " archive journal is corrupt: " + ((ArchiveStateLoadResult.Corrupt) load).getReason()));
        } catch (Exception e) {
            return new JournalLoad.Failed(failure(ArchiveUpdateCheckBlockCode.STATE_IO_FAILED, "Unable to read " + str + " archive journal: " + e.getMessage()));
        }
    }

    private final File relativeFile(File file, String str) {
        for (String str2 : StringsKt.split$default((CharSequence) str, new char[]{'/'}, false, 0, 6, (Object) null)) {
            file = new File(file, str2);
        }
        return file;
    }

    private final EngineResourceCleanupResult.Failure failure(ArchiveUpdateCheckBlockCode archiveUpdateCheckBlockCode, String str) {
        return new EngineResourceCleanupResult.Failure(archiveUpdateCheckBlockCode, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EngineResourceGenerationMigration.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationMigration$JournalLoad;", "", "Ready", "Failed", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationMigration$JournalLoad$Failed;", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationMigration$JournalLoad$Ready;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface JournalLoad {

        /* compiled from: EngineResourceGenerationMigration.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationMigration$JournalLoad$Ready;", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationMigration$JournalLoad;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "<init>", "(Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;)V", "getState", "()Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Ready implements JournalLoad {
            public static final int $stable = ArchiveUpdaterState.$stable;
            private final ArchiveUpdaterState state;

            public static /* synthetic */ Ready copy$default(Ready ready, ArchiveUpdaterState archiveUpdaterState, int i, Object obj) {
                if ((i & 1) != 0) {
                    archiveUpdaterState = ready.state;
                }
                return ready.copy(archiveUpdaterState);
            }

            public final ArchiveUpdaterState component1() {
                return this.state;
            }

            public final Ready copy(ArchiveUpdaterState archiveUpdaterState) {
                return new Ready(archiveUpdaterState);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Ready) && Intrinsics.areEqual(this.state, ((Ready) obj).state);
            }

            public int hashCode() {
                ArchiveUpdaterState archiveUpdaterState = this.state;
                if (archiveUpdaterState == null) {
                    return 0;
                }
                return archiveUpdaterState.hashCode();
            }

            public String toString() {
                return "Ready(state=" + this.state + ")";
            }

            public Ready(ArchiveUpdaterState archiveUpdaterState) {
                this.state = archiveUpdaterState;
            }

            public final ArchiveUpdaterState getState() {
                return this.state;
            }
        }

        /* compiled from: EngineResourceGenerationMigration.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationMigration$JournalLoad$Failed;", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationMigration$JournalLoad;", "failure", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceCleanupResult$Failure;", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceCleanupResult$Failure;)V", "getFailure", "()Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceCleanupResult$Failure;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Failed implements JournalLoad {
            public static final int $stable = 0;
            private final EngineResourceCleanupResult.Failure failure;

            public static /* synthetic */ Failed copy$default(Failed failed, EngineResourceCleanupResult.Failure failure, int i, Object obj) {
                if ((i & 1) != 0) {
                    failure = failed.failure;
                }
                return failed.copy(failure);
            }

            public final EngineResourceCleanupResult.Failure component1() {
                return this.failure;
            }

            public final Failed copy(EngineResourceCleanupResult.Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                return new Failed(failure);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Failed) && Intrinsics.areEqual(this.failure, ((Failed) obj).failure);
            }

            public int hashCode() {
                return this.failure.hashCode();
            }

            public String toString() {
                return "Failed(failure=" + this.failure + ")";
            }

            public Failed(EngineResourceCleanupResult.Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "failure");
                this.failure = failure;
            }

            public final EngineResourceCleanupResult.Failure getFailure() {
                return this.failure;
            }
        }
    }

    /* compiled from: EngineResourceGenerationMigration.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\rJ\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationMigration$Companion;", "", "<init>", "()V", "MAP_CACHE_FILE", "", "PROTECTED_ROOTS", "", "forAndroid", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationMigration;", "isProtectedRelativePath", "", "relativePath", "isProtectedRelativePath$app", "isLauncherApkName", "name", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EngineResourceGenerationMigration forAndroid() {
            return new EngineResourceGenerationMigration(AndroidArchiveNodeInspector.INSTANCE);
        }

        public final boolean isProtectedRelativePath$app(String relativePath) {
            Intrinsics.checkNotNullParameter(relativePath, "relativePath");
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = relativePath.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (Intrinsics.areEqual(lowerCase, "settings.json") || Intrinsics.areEqual(lowerCase, "samp/settings.json")) {
                return true;
            }
            if (EngineResourceGenerationMigration.PROTECTED_ROOTS.contains(StringsKt.substringBefore$default(lowerCase, '/', (String) null, 2, (Object) null))) {
                return true;
            }
            return !StringsKt.contains$default((CharSequence) lowerCase, '/', false, 2, (Object) null) && isLauncherApkName(lowerCase);
        }

        private final boolean isLauncherApkName(String str) {
            return StringsKt.startsWith$default(str, "app-", false, 2, (Object) null) && (StringsKt.endsWith$default(str, ".apk", false, 2, (Object) null) || StringsKt.endsWith$default(str, ".apk.part", false, 2, (Object) null) || StringsKt.endsWith$default(str, ".apk.resume", false, 2, (Object) null) || StringsKt.endsWith$default(str, ".apk.resume.tmp", false, 2, (Object) null));
        }
    }
}
