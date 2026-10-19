package com.arizona.launcher.updater.archive.orchestrator;

import android.content.Context;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Log;
import coil3.util.UtilsKt;
import com.arizona.launcher.updater.archive.io.AndroidArchiveDirectoryCreator;
import com.arizona.launcher.updater.archive.io.AndroidArchiveNodeInspector;
import com.arizona.launcher.updater.archive.io.ArchiveDirectoryCreator;
import com.arizona.launcher.updater.archive.io.ArchiveFsNodeType;
import com.arizona.launcher.updater.archive.io.ArchiveLivePathSafety;
import com.arizona.launcher.updater.archive.io.ArchiveNodeInspector;
import com.arizona.launcher.updater.archive.io.ArchiveStorageFailureClassifier;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdaterStorageRoots;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ArchiveDownloadRootResolver.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 W2\u00020\u0001:\u0005STUVWB1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\u0015J#\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\b\u001bJ3\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u001dJ\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010J\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0002J\u001a\u0010#\u001a\u0004\u0018\u00010\u00102\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020\u0010H\u0002J\u001a\u0010%\u001a\u0004\u0018\u00010\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0002J\"\u0010&\u001a\u0004\u0018\u00010\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0010H\u0002J\"\u0010)\u001a\u0004\u0018\u00010\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0010H\u0002J\u001a\u0010*\u001a\u0004\u0018\u00010\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010+\u001a\u00020\bH\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0010H\u0002J\u0018\u00101\u001a\u00020/2\u0006\u0010'\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u0010H\u0002J\u0018\u00102\u001a\u00020/2\u0006\u0010'\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u0010H\u0002J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00020\u0010052\u0006\u00100\u001a\u00020\u0010H\u0002J\u0018\u00106\u001a\u0002072\u0006\u0010'\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0010H\u0002J\u0018\u00109\u001a\u00020:2\u0006\u0010'\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u0010H\u0002J\u0018\u0010;\u001a\u00020:2\u0006\u0010'\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u0010H\u0002J\u0018\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020\bH\u0002J\u0012\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020\u0010H\u0002J\u0010\u0010B\u001a\u00020/2\u0006\u0010C\u001a\u00020\u0010H\u0002J\u0012\u0010D\u001a\u0004\u0018\u00010/2\u0006\u0010C\u001a\u00020\u0010H\u0002J\u0010\u0010E\u001a\u00020/2\u0006\u0010C\u001a\u00020\u0010H\u0002J\u0018\u0010F\u001a\u00020\t2\u0006\u0010C\u001a\u00020\u00102\u0006\u0010G\u001a\u000207H\u0002J\u0010\u0010H\u001a\u00020\b2\u0006\u0010I\u001a\u00020JH\u0002J\u0012\u0010K\u001a\u0004\u0018\u00010\b2\u0006\u0010\"\u001a\u00020!H\u0002J\u0010\u0010L\u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010M\u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001a\u0010N\u001a\u00020!2\b\u0010C\u001a\u0004\u0018\u00010\u00102\u0006\u0010O\u001a\u00020\bH\u0002J\u0010\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\bH\u0002J\u0010\u0010R\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\f\bY\u0012\b\bZ\u0012\u0004\b\u0003\u0010\u0000¨\u0006X"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver;", "", "directoryCreator", "Lcom/arizona/launcher/updater/archive/io/ArchiveDirectoryCreator;", "nodeInspector", "Lcom/arizona/launcher/updater/archive/io/ArchiveNodeInspector;", "log", "Lkotlin/Function1;", "", "", "<init>", "(Lcom/arizona/launcher/updater/archive/io/ArchiveDirectoryCreator;Lcom/arizona/launcher/updater/archive/io/ArchiveNodeInspector;Lkotlin/jvm/functions/Function1;)V", "selectionLock", "probeSequence", "Ljava/util/concurrent/atomic/AtomicLong;", "selectedAnchor", "Ljava/io/File;", "lastLoggedFailure", "resolve", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterStorageRoots;", "context", "Landroid/content/Context;", "scope", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterStorageScope;", "resolveAnchor", "externalCache", "externalFiles", "resolveAnchor$app", "noBackupRoot", "resolve$app", "pinnedAnchor", "resolveLocated", "cache", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$LocatedDirectory;", OriginalTzArchiveManifestParser.FILES_ROOT, "revalidate", "pinned", "choose", "chooseExistingFallback", "gameRoot", "fallback", "choosePrimaryThenFallback", "choosePrimaryOrReject", "fallbackReason", "probePrimary", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$Candidate;", "probeLaneDirectories", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$ProbeResult;", "anchor", "probeFallback", "probeFallbackZip", "zip", "laneZipDirectories", "", "isFallbackAnchor", "", "candidate", "classifyFallback", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$FallbackPresence;", "classifyFallbackZip", "walkRealDirectories", "root", "relative", "inspected", "Lcom/arizona/launcher/updater/archive/io/ArchiveFsNodeType;", UtilsKt.SCHEME_FILE, "probe", "directory", "ensureDirectory", "writeProbe", "discardEmptyCreatedDirectory", "existed", "failureDetail", "error", "", "gameStorageFailure", "readExternalCache", "readExternalFiles", "locate", "unavailable", "logChoice", "message", "logFailure", "ProbeResult", "Candidate", "FallbackPresence", "LocatedDirectory", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveDownloadRootResolver {
    private static final String TAG = "ArchiveDownloadRoot";
    private final ArchiveDirectoryCreator directoryCreator;
    private String lastLoggedFailure;
    private final Function1<String, Unit> log;
    private final ArchiveNodeInspector nodeInspector;
    private final AtomicLong probeSequence;
    private volatile File selectedAnchor;
    private final Object selectionLock;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final ArchiveDownloadRootResolver process = new ArchiveDownloadRootResolver(null, null, null, 7, null);

    /* compiled from: ArchiveDownloadRootResolver.kt */
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
                iArr[ArchiveFsNodeType.DIRECTORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ArchiveFsNodeType.SYMBOLIC_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ArchiveFsNodeType.REGULAR_FILE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ArchiveFsNodeType.OTHER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ArchiveDownloadRootResolver() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArchiveDownloadRootResolver(ArchiveDirectoryCreator directoryCreator, ArchiveNodeInspector nodeInspector, Function1<? super String, Unit> log) {
        Intrinsics.checkNotNullParameter(directoryCreator, "directoryCreator");
        Intrinsics.checkNotNullParameter(nodeInspector, "nodeInspector");
        Intrinsics.checkNotNullParameter(log, "log");
        this.directoryCreator = directoryCreator;
        this.nodeInspector = nodeInspector;
        this.log = log;
        this.selectionLock = new Object();
        this.probeSequence = new AtomicLong();
    }

    public /* synthetic */ ArchiveDownloadRootResolver(AndroidArchiveDirectoryCreator androidArchiveDirectoryCreator, AndroidArchiveNodeInspector androidArchiveNodeInspector, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? AndroidArchiveDirectoryCreator.INSTANCE : androidArchiveDirectoryCreator, (i & 2) != 0 ? AndroidArchiveNodeInspector.INSTANCE : androidArchiveNodeInspector, (i & 4) != 0 ? new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.ArchiveDownloadRootResolver$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ArchiveDownloadRootResolver._init_$lambda$0((String) obj);
            }
        } : function1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$0(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Log.w(TAG, message);
        return Unit.INSTANCE;
    }

    public final ArchiveUpdaterStorageRoots resolve(Context context, ArchiveUpdaterStorageScope scope) {
        File directory;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        File resolveAnchor = resolveAnchor(context);
        if (resolveAnchor == null) {
            return null;
        }
        LocatedDirectory readExternalFiles = readExternalFiles(context);
        if (gameStorageFailure(readExternalFiles) == null && (directory = readExternalFiles.getDirectory()) != null) {
            ArchiveUpdaterStorageRoots.Companion companion = ArchiveUpdaterStorageRoots.Companion;
            File noBackupFilesDir = context.getNoBackupFilesDir();
            Intrinsics.checkNotNullExpressionValue(noBackupFilesDir, "getNoBackupFilesDir(...)");
            return companion.resolve(directory, resolveAnchor, noBackupFilesDir, scope);
        }
        return null;
    }

    public final File resolveAnchor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return resolveLocated(readExternalCache(context), readExternalFiles(context));
    }

    public final File resolveAnchor$app(File file, File file2) {
        return resolveLocated(locate(file, "external cache unavailable"), locate(file2, "game storage unavailable"));
    }

    public final ArchiveUpdaterStorageRoots resolve$app(File file, File file2, File noBackupRoot, ArchiveUpdaterStorageScope scope) {
        Intrinsics.checkNotNullParameter(noBackupRoot, "noBackupRoot");
        Intrinsics.checkNotNullParameter(scope, "scope");
        File resolveAnchor$app = resolveAnchor$app(file, file2);
        if (resolveAnchor$app == null || file2 == null || !file2.isDirectory()) {
            return null;
        }
        return ArchiveUpdaterStorageRoots.Companion.resolve(file2, resolveAnchor$app, noBackupRoot, scope);
    }

    public final File pinnedAnchor() {
        File file;
        synchronized (this.selectionLock) {
            file = this.selectedAnchor;
        }
        return file;
    }

    private final File resolveLocated(LocatedDirectory locatedDirectory, LocatedDirectory locatedDirectory2) {
        synchronized (this.selectionLock) {
            File file = this.selectedAnchor;
            if (file != null) {
                return revalidate(locatedDirectory2, file);
            }
            File choose = choose(locatedDirectory, locatedDirectory2);
            if (choose == null) {
                return null;
            }
            this.selectedAnchor = choose;
            return choose;
        }
    }

    private final File revalidate(LocatedDirectory locatedDirectory, File file) {
        ProbeResult probeLaneDirectories;
        String gameStorageFailure = gameStorageFailure(locatedDirectory);
        if (gameStorageFailure != null) {
            logFailure("Archive download root unavailable; " + gameStorageFailure);
            return null;
        }
        File directory = locatedDirectory.getDirectory();
        if (directory == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        if (isFallbackAnchor(directory, file)) {
            probeLaneDirectories = probeFallback(directory, file);
        } else {
            probeLaneDirectories = probeLaneDirectories(file);
        }
        if (Intrinsics.areEqual(probeLaneDirectories, ProbeResult.Usable.INSTANCE) || Intrinsics.areEqual(probeLaneDirectories, ProbeResult.NoSpace.INSTANCE)) {
            if (this.lastLoggedFailure != null) {
                logChoice("Archive download root pinned directory recovered");
            }
            return file;
        } else if (!(probeLaneDirectories instanceof ProbeResult.Unusable)) {
            throw new NoWhenBranchMatchedException();
        } else {
            logFailure("Archive download root unavailable; pinned " + ((ProbeResult.Unusable) probeLaneDirectories).getReason());
            return null;
        }
    }

    private final File choose(LocatedDirectory locatedDirectory, LocatedDirectory locatedDirectory2) {
        String gameStorageFailure = gameStorageFailure(locatedDirectory2);
        if (gameStorageFailure != null) {
            logFailure("Archive download root unavailable; " + gameStorageFailure);
            return null;
        }
        File directory = locatedDirectory2.getDirectory();
        if (directory == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        File fallbackCacheAnchor = ArchiveUpdaterStorageRoots.Companion.fallbackCacheAnchor(directory);
        FallbackPresence classifyFallback = classifyFallback(directory, fallbackCacheAnchor);
        if (Intrinsics.areEqual(classifyFallback, FallbackPresence.Directory.INSTANCE)) {
            return chooseExistingFallback(locatedDirectory, directory, fallbackCacheAnchor);
        }
        if (Intrinsics.areEqual(classifyFallback, FallbackPresence.Absent.INSTANCE)) {
            return choosePrimaryThenFallback(locatedDirectory, directory, fallbackCacheAnchor);
        }
        if (classifyFallback instanceof FallbackPresence.Rejected) {
            return choosePrimaryOrReject(locatedDirectory, ((FallbackPresence.Rejected) classifyFallback).getReason());
        }
        throw new NoWhenBranchMatchedException();
    }

    private final File chooseExistingFallback(LocatedDirectory locatedDirectory, File file, File file2) {
        ProbeResult probeFallback = probeFallback(file, file2);
        if (Intrinsics.areEqual(probeFallback, ProbeResult.Usable.INSTANCE)) {
            logChoice("Archive download root keeping existing fallback");
            return file2;
        } else if (Intrinsics.areEqual(probeFallback, ProbeResult.NoSpace.INSTANCE)) {
            logChoice("Archive download root probe has no space; using fallback");
            return file2;
        } else if (!(probeFallback instanceof ProbeResult.Unusable)) {
            throw new NoWhenBranchMatchedException();
        } else {
            Candidate probePrimary = probePrimary(locatedDirectory);
            if (probePrimary instanceof Candidate.Ready) {
                logChoice("Archive download root existing fallback unusable (" + ((ProbeResult.Unusable) probeFallback).getReason() + "); using primary");
                return ((Candidate.Ready) probePrimary).getDirectory();
            } else if (!(probePrimary instanceof Candidate.Failed)) {
                throw new NoWhenBranchMatchedException();
            } else {
                String reason = ((Candidate.Failed) probePrimary).getReason();
                logFailure("Archive download root unavailable; primary=" + reason + " fallback=" + ((ProbeResult.Unusable) probeFallback).getReason());
                return null;
            }
        }
    }

    private final File choosePrimaryThenFallback(LocatedDirectory locatedDirectory, File file, File file2) {
        Candidate probePrimary = probePrimary(locatedDirectory);
        if (probePrimary instanceof Candidate.Ready) {
            Candidate.Ready ready = (Candidate.Ready) probePrimary;
            if (ready.getNoSpace()) {
                logChoice("Archive download root probe has no space; using primary");
            } else if (this.lastLoggedFailure != null) {
                logChoice("Archive download root primary recovered");
            }
            return ready.getDirectory();
        } else if (!(probePrimary instanceof Candidate.Failed)) {
            throw new NoWhenBranchMatchedException();
        } else {
            ProbeResult probeFallback = probeFallback(file, file2);
            if (Intrinsics.areEqual(probeFallback, ProbeResult.Usable.INSTANCE)) {
                logChoice("Archive download root primary failed (" + ((Candidate.Failed) probePrimary).getReason() + "); using fallback");
                return file2;
            } else if (Intrinsics.areEqual(probeFallback, ProbeResult.NoSpace.INSTANCE)) {
                logChoice("Archive download root probe has no space; using fallback");
                return file2;
            } else if (!(probeFallback instanceof ProbeResult.Unusable)) {
                throw new NoWhenBranchMatchedException();
            } else {
                String reason = ((Candidate.Failed) probePrimary).getReason();
                logFailure("Archive download root unavailable; primary=" + reason + " fallback=" + ((ProbeResult.Unusable) probeFallback).getReason());
                return null;
            }
        }
    }

    private final File choosePrimaryOrReject(LocatedDirectory locatedDirectory, String str) {
        Candidate probePrimary = probePrimary(locatedDirectory);
        if (probePrimary instanceof Candidate.Ready) {
            logChoice("Archive download root existing fallback unusable (" + str + "); using primary");
            return ((Candidate.Ready) probePrimary).getDirectory();
        } else if (!(probePrimary instanceof Candidate.Failed)) {
            throw new NoWhenBranchMatchedException();
        } else {
            logFailure("Archive download root unavailable; primary=" + ((Candidate.Failed) probePrimary).getReason() + " fallback=" + str);
            return null;
        }
    }

    private final Candidate probePrimary(LocatedDirectory locatedDirectory) {
        String failure = locatedDirectory.getFailure();
        if (failure != null) {
            return new Candidate.Failed(failure);
        }
        File directory = locatedDirectory.getDirectory();
        if (directory == null) {
            return new Candidate.Failed("external cache unavailable");
        }
        ProbeResult probeLaneDirectories = probeLaneDirectories(directory);
        if (Intrinsics.areEqual(probeLaneDirectories, ProbeResult.Usable.INSTANCE)) {
            return new Candidate.Ready(directory, false);
        }
        if (Intrinsics.areEqual(probeLaneDirectories, ProbeResult.NoSpace.INSTANCE)) {
            return new Candidate.Ready(directory, true);
        }
        if (probeLaneDirectories instanceof ProbeResult.Unusable) {
            return new Candidate.Failed(((ProbeResult.Unusable) probeLaneDirectories).getReason());
        }
        throw new NoWhenBranchMatchedException();
    }

    private final ProbeResult probeLaneDirectories(File file) {
        boolean z = false;
        for (File file2 : laneZipDirectories(file)) {
            ProbeResult probe = probe(file2);
            if (probe instanceof ProbeResult.Unusable) {
                return probe;
            }
            if (Intrinsics.areEqual(probe, ProbeResult.NoSpace.INSTANCE)) {
                z = true;
            } else if (!Intrinsics.areEqual(probe, ProbeResult.Usable.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return z ? ProbeResult.NoSpace.INSTANCE : ProbeResult.Usable.INSTANCE;
    }

    private final ProbeResult probeFallback(File file, File file2) {
        FallbackPresence classifyFallback = classifyFallback(file, file2);
        if (classifyFallback instanceof FallbackPresence.Rejected) {
            return new ProbeResult.Unusable(((FallbackPresence.Rejected) classifyFallback).getReason());
        }
        if (!Intrinsics.areEqual(classifyFallback, FallbackPresence.Absent.INSTANCE) && !Intrinsics.areEqual(classifyFallback, FallbackPresence.Directory.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        List<File> laneZipDirectories = laneZipDirectories(file2);
        for (File file3 : laneZipDirectories) {
            FallbackPresence classifyFallbackZip = classifyFallbackZip(file, file3);
            if (classifyFallbackZip instanceof FallbackPresence.Rejected) {
                return new ProbeResult.Unusable(((FallbackPresence.Rejected) classifyFallbackZip).getReason());
            }
            if (!Intrinsics.areEqual(classifyFallbackZip, FallbackPresence.Absent.INSTANCE) && !Intrinsics.areEqual(classifyFallbackZip, FallbackPresence.Directory.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
        }
        boolean z = false;
        for (File file4 : laneZipDirectories) {
            ProbeResult probeFallbackZip = probeFallbackZip(file, file4);
            if (probeFallbackZip instanceof ProbeResult.Unusable) {
                return probeFallbackZip;
            }
            if (Intrinsics.areEqual(probeFallbackZip, ProbeResult.NoSpace.INSTANCE)) {
                z = true;
            } else if (!Intrinsics.areEqual(probeFallbackZip, ProbeResult.Usable.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return z ? ProbeResult.NoSpace.INSTANCE : ProbeResult.Usable.INSTANCE;
    }

    private static final ProbeResult probeFallbackZip$rejected(ArchiveDownloadRootResolver archiveDownloadRootResolver, File file, File file2) {
        FallbackPresence classifyFallbackZip = archiveDownloadRootResolver.classifyFallbackZip(file, file2);
        if (classifyFallbackZip instanceof FallbackPresence.Rejected) {
            return new ProbeResult.Unusable(((FallbackPresence.Rejected) classifyFallbackZip).getReason());
        }
        if (Intrinsics.areEqual(classifyFallbackZip, FallbackPresence.Absent.INSTANCE) || Intrinsics.areEqual(classifyFallbackZip, FallbackPresence.Directory.INSTANCE)) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final ProbeResult probeFallbackZip(File file, File file2) {
        ProbeResult probeFallbackZip$rejected = probeFallbackZip$rejected(this, file, file2);
        if (probeFallbackZip$rejected != null) {
            return probeFallbackZip$rejected;
        }
        ProbeResult ensureDirectory = ensureDirectory(file2);
        ProbeResult probeFallbackZip$rejected2 = probeFallbackZip$rejected(this, file, file2);
        if (probeFallbackZip$rejected2 != null) {
            return probeFallbackZip$rejected2;
        }
        if (ensureDirectory != null) {
            return ensureDirectory;
        }
        ProbeResult probeFallbackZip$rejected3 = probeFallbackZip$rejected(this, file, file2);
        return probeFallbackZip$rejected3 != null ? probeFallbackZip$rejected3 : writeProbe(file2);
    }

    private final List<File> laneZipDirectories(File file) {
        List<ArchiveUpdaterStorageScope> listOf = CollectionsKt.listOf((Object[]) new ArchiveUpdaterStorageScope[]{ArchiveUpdaterStorageScope.BASE, ArchiveUpdaterStorageScope.VICE});
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf, 10));
        for (ArchiveUpdaterStorageScope archiveUpdaterStorageScope : listOf) {
            arrayList.add(new File(file, ArchiveUpdaterStorageRoots.Companion.downloadRelative(archiveUpdaterStorageScope)));
        }
        return arrayList;
    }

    private final boolean isFallbackAnchor(File file, File file2) {
        ArchiveLivePathSafety archiveLivePathSafety = new ArchiveLivePathSafety(this.nodeInspector);
        File absoluteFile = ArchiveUpdaterStorageRoots.Companion.fallbackCacheAnchor(file).getAbsoluteFile();
        Intrinsics.checkNotNullExpressionValue(absoluteFile, "getAbsoluteFile(...)");
        File normalize = FilesKt.normalize(absoluteFile);
        File absoluteFile2 = file2.getAbsoluteFile();
        Intrinsics.checkNotNullExpressionValue(absoluteFile2, "getAbsoluteFile(...)");
        return archiveLivePathSafety.isSamePathIgnoringCase(normalize, FilesKt.normalize(absoluteFile2));
    }

    private final FallbackPresence classifyFallback(File file, File file2) {
        ArchiveLivePathSafety archiveLivePathSafety = new ArchiveLivePathSafety(this.nodeInspector);
        try {
            File absoluteFile = file.getAbsoluteFile();
            Intrinsics.checkNotNullExpressionValue(absoluteFile, "getAbsoluteFile(...)");
            File normalize = FilesKt.normalize(absoluteFile);
            try {
                File absoluteFile2 = file2.getAbsoluteFile();
                Intrinsics.checkNotNullExpressionValue(absoluteFile2, "getAbsoluteFile(...)");
                File normalize2 = FilesKt.normalize(absoluteFile2);
                if (!archiveLivePathSafety.isStrictChild(normalize2, normalize) || !isFallbackAnchor(normalize, normalize2)) {
                    return new FallbackPresence.Rejected("fallback anchor escapes the game root");
                }
                return walkRealDirectories(normalize, ArchiveUpdaterStorageRoots.FALLBACK_CACHE_ANCHOR_RELATIVE);
            } catch (RuntimeException unused) {
                return new FallbackPresence.Rejected("fallback anchor path is invalid");
            }
        } catch (RuntimeException unused2) {
            return new FallbackPresence.Rejected("game root path is invalid");
        }
    }

    private final FallbackPresence classifyFallbackZip(File file, File file2) {
        Object obj;
        ArchiveLivePathSafety archiveLivePathSafety = new ArchiveLivePathSafety(this.nodeInspector);
        try {
            File absoluteFile = file.getAbsoluteFile();
            Intrinsics.checkNotNullExpressionValue(absoluteFile, "getAbsoluteFile(...)");
            File normalize = FilesKt.normalize(absoluteFile);
            try {
                File absoluteFile2 = file2.getAbsoluteFile();
                Intrinsics.checkNotNullExpressionValue(absoluteFile2, "getAbsoluteFile(...)");
                File normalize2 = FilesKt.normalize(absoluteFile2);
                Iterator it = CollectionsKt.listOf((Object[]) new ArchiveUpdaterStorageScope[]{ArchiveUpdaterStorageScope.BASE, ArchiveUpdaterStorageScope.VICE}).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    File absoluteFile3 = new File(normalize, ".archive-installing/.download-cache/" + ArchiveUpdaterStorageRoots.Companion.downloadRelative((ArchiveUpdaterStorageScope) obj)).getAbsoluteFile();
                    Intrinsics.checkNotNullExpressionValue(absoluteFile3, "getAbsoluteFile(...)");
                    if (archiveLivePathSafety.isSamePathIgnoringCase(FilesKt.normalize(absoluteFile3), normalize2)) {
                        break;
                    }
                }
                ArchiveUpdaterStorageScope archiveUpdaterStorageScope = (ArchiveUpdaterStorageScope) obj;
                if (archiveUpdaterStorageScope == null) {
                    return new FallbackPresence.Rejected("fallback download path escapes the game root");
                }
                if (!archiveLivePathSafety.isStrictChild(normalize2, normalize)) {
                    return new FallbackPresence.Rejected("fallback download path escapes the game root");
                }
                return walkRealDirectories(normalize, ".archive-installing/.download-cache/" + ArchiveUpdaterStorageRoots.Companion.downloadRelative(archiveUpdaterStorageScope));
            } catch (RuntimeException unused) {
                return new FallbackPresence.Rejected("fallback download path is invalid");
            }
        } catch (RuntimeException unused2) {
            return new FallbackPresence.Rejected("game root path is invalid");
        }
    }

    private final FallbackPresence walkRealDirectories(File file, String str) {
        ArchiveFsNodeType inspected = inspected(file);
        if (inspected == null) {
            return new FallbackPresence.Rejected("game root inspect failed");
        }
        if (inspected != ArchiveFsNodeType.DIRECTORY) {
            return new FallbackPresence.Rejected("game root is not a real directory");
        }
        for (String str2 : StringsKt.split$default((CharSequence) str, new char[]{'/'}, false, 0, 6, (Object) null)) {
            File file2 = new File(file, str2);
            ArchiveFsNodeType inspected2 = inspected(file2);
            int i = inspected2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[inspected2.ordinal()];
            if (i == -1) {
                return new FallbackPresence.Rejected("fallback download path inspect failed");
            }
            if (i == 1) {
                return FallbackPresence.Absent.INSTANCE;
            }
            if (i != 2) {
                if (i != 3) {
                    if (i == 4 || i == 5) {
                        return new FallbackPresence.Rejected("not a directory '" + file2.getPath() + "'");
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return new FallbackPresence.Rejected("symbolic link '" + file2.getPath() + "'");
            }
            file = file2;
        }
        return FallbackPresence.Directory.INSTANCE;
    }

    private final ArchiveFsNodeType inspected(File file) {
        try {
            return this.nodeInspector.nodeType(file);
        } catch (IOException | SecurityException unused) {
            return null;
        }
    }

    private final ProbeResult probe(File file) {
        ProbeResult ensureDirectory = ensureDirectory(file);
        return ensureDirectory != null ? ensureDirectory : writeProbe(file);
    }

    private final ProbeResult ensureDirectory(File file) {
        boolean isDirectory = file.isDirectory();
        try {
            if (this.directoryCreator.createDirectories(file) && file.isDirectory()) {
                return null;
            }
            discardEmptyCreatedDirectory(file, isDirectory);
            return new ProbeResult.Unusable("not a directory");
        } catch (IOException e) {
            if (file.isDirectory() && ArchiveStorageFailureClassifier.INSTANCE.isNoSpace(e)) {
                return ProbeResult.NoSpace.INSTANCE;
            }
            discardEmptyCreatedDirectory(file, isDirectory);
            return new ProbeResult.Unusable("create failed (" + failureDetail(e) + ")");
        } catch (SecurityException e2) {
            discardEmptyCreatedDirectory(file, isDirectory);
            return new ProbeResult.Unusable("create failed (" + failureDetail(e2) + ")");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0059, code lost:
        if (java.util.Arrays.equals(r3, r5) == false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ProbeResult writeProbe(File file) {
        ProbeResult.Unusable unusable;
        ProbeResult.Unusable unusable2;
        byte[] bArr;
        byte[] bArr2;
        File file2 = new File(file, ".archive-root-probe-" + System.nanoTime() + "-" + this.probeSequence.incrementAndGet());
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    FileOutputStream fileOutputStream2 = fileOutputStream;
                    bArr = ArchiveDownloadRootResolverKt.ARCHIVE_ROOT_PROBE_BYTES;
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    Unit unit = Unit.INSTANCE;
                    unusable2 = null;
                    CloseableKt.closeFinally(fileOutputStream, null);
                    if (file2.isFile()) {
                        byte[] readBytes = FilesKt.readBytes(file2);
                        bArr2 = ArchiveDownloadRootResolverKt.ARCHIVE_ROOT_PROBE_BYTES;
                    }
                    unusable2 = new ProbeResult.Unusable("write failed (incomplete)");
                    if (file2.exists() && !file2.delete() && file2.exists() && unusable2 == null) {
                        unusable2 = new ProbeResult.Unusable("delete failed");
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(fileOutputStream, th);
                        throw th2;
                    }
                }
            } catch (Exception e) {
                if (file.isDirectory() && ArchiveStorageFailureClassifier.INSTANCE.isNoSpace(e)) {
                    unusable = ProbeResult.NoSpace.INSTANCE;
                } else {
                    unusable = new ProbeResult.Unusable("write failed (" + failureDetail(e) + ")");
                }
                if (file2.exists() && !file2.delete() && file2.exists() && unusable == null) {
                    unusable = new ProbeResult.Unusable("delete failed");
                }
                unusable2 = unusable;
            }
            return unusable2 == null ? ProbeResult.Usable.INSTANCE : unusable2;
        } catch (Throwable th3) {
            if (file2.exists() && !file2.delete() && file2.exists()) {
                new ProbeResult.Unusable("delete failed");
            }
            throw th3;
        }
    }

    private final void discardEmptyCreatedDirectory(File file, boolean z) {
        File[] listFiles;
        if (z || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length != 0) {
            return;
        }
        file.delete();
    }

    private final String failureDetail(Throwable th) {
        String str = null;
        Integer num = null;
        Throwable th2 = th;
        for (int i = 0; th2 != null && i < 8; i++) {
            ErrnoException errnoException = th2 instanceof ErrnoException ? (ErrnoException) th2 : null;
            if (num == null && errnoException != null) {
                num = Integer.valueOf(errnoException.errno);
            }
            th2 = th2.getCause();
        }
        int i2 = OsConstants.ENOSPC;
        if (num != null && num.intValue() == i2) {
            str = "ENOSPC";
        } else {
            int i3 = OsConstants.EDQUOT;
            if (num != null && num.intValue() == i3) {
                str = "EDQUOT";
            } else if (num == null) {
                if (ArchiveStorageFailureClassifier.INSTANCE.isNoSpace(th)) {
                    str = "no-space";
                }
            } else {
                str = "errno=" + num;
            }
        }
        String simpleName = th.getClass().getSimpleName();
        if (str == null) {
            Intrinsics.checkNotNull(simpleName);
            return simpleName;
        }
        return simpleName + " " + str;
    }

    private final String gameStorageFailure(LocatedDirectory locatedDirectory) {
        if (locatedDirectory.getFailure() != null) {
            return locatedDirectory.getFailure();
        }
        File directory = locatedDirectory.getDirectory();
        if (directory == null || !directory.isDirectory()) {
            return "game storage unavailable";
        }
        return null;
    }

    private final LocatedDirectory readExternalCache(Context context) {
        try {
            return locate(context.getExternalCacheDir(), "external cache unavailable");
        } catch (Exception e) {
            return new LocatedDirectory(null, "external cache unavailable (" + e.getClass().getSimpleName() + ")");
        }
    }

    private final LocatedDirectory readExternalFiles(Context context) {
        try {
            return locate(context.getExternalFilesDir(null), "game storage unavailable");
        } catch (Exception e) {
            return new LocatedDirectory(null, "game storage unavailable (" + e.getClass().getSimpleName() + ")");
        }
    }

    private final LocatedDirectory locate(File file, String str) {
        if (file == null) {
            return new LocatedDirectory(null, str);
        }
        return new LocatedDirectory(file, null);
    }

    private final void logChoice(String str) {
        this.lastLoggedFailure = null;
        this.log.invoke(str);
    }

    private final void logFailure(String str) {
        if (Intrinsics.areEqual(str, this.lastLoggedFailure)) {
            return;
        }
        this.lastLoggedFailure = str;
        this.log.invoke(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchiveDownloadRootResolver.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$ProbeResult;", "", "Usable", "NoSpace", "Unusable", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$ProbeResult$NoSpace;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$ProbeResult$Unusable;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$ProbeResult$Usable;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface ProbeResult {

        /* compiled from: ArchiveDownloadRootResolver.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$ProbeResult$Usable;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$ProbeResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Usable implements ProbeResult {
            public static final int $stable = 0;
            public static final Usable INSTANCE = new Usable();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Usable) {
                    Usable usable = (Usable) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -430015083;
            }

            public String toString() {
                return "Usable";
            }

            private Usable() {
            }
        }

        /* compiled from: ArchiveDownloadRootResolver.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$ProbeResult$NoSpace;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$ProbeResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class NoSpace implements ProbeResult {
            public static final int $stable = 0;
            public static final NoSpace INSTANCE = new NoSpace();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof NoSpace) {
                    NoSpace noSpace = (NoSpace) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 1804803784;
            }

            public String toString() {
                return "NoSpace";
            }

            private NoSpace() {
            }
        }

        /* compiled from: ArchiveDownloadRootResolver.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$ProbeResult$Unusable;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$ProbeResult;", "reason", "", "<init>", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Unusable implements ProbeResult {
            public static final int $stable = 0;
            private final String reason;

            public static /* synthetic */ Unusable copy$default(Unusable unusable, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = unusable.reason;
                }
                return unusable.copy(str);
            }

            public final String component1() {
                return this.reason;
            }

            public final Unusable copy(String reason) {
                Intrinsics.checkNotNullParameter(reason, "reason");
                return new Unusable(reason);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Unusable) && Intrinsics.areEqual(this.reason, ((Unusable) obj).reason);
            }

            public int hashCode() {
                return this.reason.hashCode();
            }

            public String toString() {
                return "Unusable(reason=" + this.reason + ")";
            }

            public Unusable(String reason) {
                Intrinsics.checkNotNullParameter(reason, "reason");
                this.reason = reason;
            }

            public final String getReason() {
                return this.reason;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchiveDownloadRootResolver.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$Candidate;", "", "Ready", "Failed", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$Candidate$Failed;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$Candidate$Ready;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface Candidate {

        /* compiled from: ArchiveDownloadRootResolver.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$Candidate$Ready;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$Candidate;", "directory", "Ljava/io/File;", "noSpace", "", "<init>", "(Ljava/io/File;Z)V", "getDirectory", "()Ljava/io/File;", "getNoSpace", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Ready implements Candidate {
            public static final int $stable = 8;
            private final File directory;
            private final boolean noSpace;

            public static /* synthetic */ Ready copy$default(Ready ready, File file, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    file = ready.directory;
                }
                if ((i & 2) != 0) {
                    z = ready.noSpace;
                }
                return ready.copy(file, z);
            }

            public final File component1() {
                return this.directory;
            }

            public final boolean component2() {
                return this.noSpace;
            }

            public final Ready copy(File directory, boolean z) {
                Intrinsics.checkNotNullParameter(directory, "directory");
                return new Ready(directory, z);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Ready) {
                    Ready ready = (Ready) obj;
                    return Intrinsics.areEqual(this.directory, ready.directory) && this.noSpace == ready.noSpace;
                }
                return false;
            }

            public int hashCode() {
                return (this.directory.hashCode() * 31) + Boolean.hashCode(this.noSpace);
            }

            public String toString() {
                File file = this.directory;
                return "Ready(directory=" + file + ", noSpace=" + this.noSpace + ")";
            }

            public Ready(File directory, boolean z) {
                Intrinsics.checkNotNullParameter(directory, "directory");
                this.directory = directory;
                this.noSpace = z;
            }

            public final File getDirectory() {
                return this.directory;
            }

            public final boolean getNoSpace() {
                return this.noSpace;
            }
        }

        /* compiled from: ArchiveDownloadRootResolver.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$Candidate$Failed;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$Candidate;", "reason", "", "<init>", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Failed implements Candidate {
            public static final int $stable = 0;
            private final String reason;

            public static /* synthetic */ Failed copy$default(Failed failed, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = failed.reason;
                }
                return failed.copy(str);
            }

            public final String component1() {
                return this.reason;
            }

            public final Failed copy(String reason) {
                Intrinsics.checkNotNullParameter(reason, "reason");
                return new Failed(reason);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Failed) && Intrinsics.areEqual(this.reason, ((Failed) obj).reason);
            }

            public int hashCode() {
                return this.reason.hashCode();
            }

            public String toString() {
                return "Failed(reason=" + this.reason + ")";
            }

            public Failed(String reason) {
                Intrinsics.checkNotNullParameter(reason, "reason");
                this.reason = reason;
            }

            public final String getReason() {
                return this.reason;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchiveDownloadRootResolver.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$FallbackPresence;", "", "Directory", "Absent", "Rejected", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$FallbackPresence$Absent;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$FallbackPresence$Directory;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$FallbackPresence$Rejected;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface FallbackPresence {

        /* compiled from: ArchiveDownloadRootResolver.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$FallbackPresence$Directory;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$FallbackPresence;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Directory implements FallbackPresence {
            public static final int $stable = 0;
            public static final Directory INSTANCE = new Directory();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Directory) {
                    Directory directory = (Directory) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -1215129864;
            }

            public String toString() {
                return "Directory";
            }

            private Directory() {
            }
        }

        /* compiled from: ArchiveDownloadRootResolver.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$FallbackPresence$Absent;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$FallbackPresence;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Absent implements FallbackPresence {
            public static final int $stable = 0;
            public static final Absent INSTANCE = new Absent();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Absent) {
                    Absent absent = (Absent) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 2028809870;
            }

            public String toString() {
                return "Absent";
            }

            private Absent() {
            }
        }

        /* compiled from: ArchiveDownloadRootResolver.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$FallbackPresence$Rejected;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$FallbackPresence;", "reason", "", "<init>", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Rejected implements FallbackPresence {
            public static final int $stable = 0;
            private final String reason;

            public static /* synthetic */ Rejected copy$default(Rejected rejected, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = rejected.reason;
                }
                return rejected.copy(str);
            }

            public final String component1() {
                return this.reason;
            }

            public final Rejected copy(String reason) {
                Intrinsics.checkNotNullParameter(reason, "reason");
                return new Rejected(reason);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Rejected) && Intrinsics.areEqual(this.reason, ((Rejected) obj).reason);
            }

            public int hashCode() {
                return this.reason.hashCode();
            }

            public String toString() {
                return "Rejected(reason=" + this.reason + ")";
            }

            public Rejected(String reason) {
                Intrinsics.checkNotNullParameter(reason, "reason");
                this.reason = reason;
            }

            public final String getReason() {
                return this.reason;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArchiveDownloadRootResolver.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0005HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$LocatedDirectory;", "", "directory", "Ljava/io/File;", "failure", "", "<init>", "(Ljava/io/File;Ljava/lang/String;)V", "getDirectory", "()Ljava/io/File;", "getFailure", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class LocatedDirectory {
        private final File directory;
        private final String failure;

        public static /* synthetic */ LocatedDirectory copy$default(LocatedDirectory locatedDirectory, File file, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                file = locatedDirectory.directory;
            }
            if ((i & 2) != 0) {
                str = locatedDirectory.failure;
            }
            return locatedDirectory.copy(file, str);
        }

        public final File component1() {
            return this.directory;
        }

        public final String component2() {
            return this.failure;
        }

        public final LocatedDirectory copy(File file, String str) {
            return new LocatedDirectory(file, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LocatedDirectory) {
                LocatedDirectory locatedDirectory = (LocatedDirectory) obj;
                return Intrinsics.areEqual(this.directory, locatedDirectory.directory) && Intrinsics.areEqual(this.failure, locatedDirectory.failure);
            }
            return false;
        }

        public int hashCode() {
            File file = this.directory;
            int hashCode = (file == null ? 0 : file.hashCode()) * 31;
            String str = this.failure;
            return hashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            File file = this.directory;
            return "LocatedDirectory(directory=" + file + ", failure=" + this.failure + ")";
        }

        public LocatedDirectory(File file, String str) {
            this.directory = file;
            this.failure = str;
        }

        public final File getDirectory() {
            return this.directory;
        }

        public final String getFailure() {
            return this.failure;
        }
    }

    /* compiled from: ArchiveDownloadRootResolver.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$Companion;", "", "<init>", "()V", "TAG", "", "process", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver;", "getProcess", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArchiveDownloadRootResolver getProcess() {
            return ArchiveDownloadRootResolver.process;
        }
    }
}
