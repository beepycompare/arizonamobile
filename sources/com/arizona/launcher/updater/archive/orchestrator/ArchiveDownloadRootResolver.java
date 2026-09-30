package com.arizona.launcher.updater.archive.orchestrator;

import android.content.Context;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Log;
import com.arizona.launcher.updater.archive.io.AndroidArchiveDirectoryCreator;
import com.arizona.launcher.updater.archive.io.ArchiveDirectoryCreator;
import com.arizona.launcher.updater.archive.io.ArchiveStorageFailureClassifier;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.vending.expansion.downloader.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveDownloadRootResolver.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 *2\u00020\u0001:\u0004'()*B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020!2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0006H\u0002J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000Ê\u0001\f\b,\u0012\b\b-\u0012\u0004\b\u0003\u0010\u0000¨\u0006+"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver;", "", "directoryCreator", "Lcom/arizona/launcher/updater/archive/io/ArchiveDirectoryCreator;", "log", "Lkotlin/Function1;", "", "", "<init>", "(Lcom/arizona/launcher/updater/archive/io/ArchiveDirectoryCreator;Lkotlin/jvm/functions/Function1;)V", "selectionLock", "selectedRoot", "Ljava/io/File;", "lastLoggedFailure", "resolve", "context", "Landroid/content/Context;", "revalidate", "pinned", "choose", "probePrimary", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$Candidate;", "probe", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$ProbeResult;", "directory", "discardEmptyCreatedDirectory", "existed", "", "failureDetail", "error", "", "gameStorageFailure", OriginalTzArchiveManifestParser.FILES_ROOT, "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$LocatedDirectory;", "readExternalCache", "readExternalFiles", "logChoice", "message", "logFailure", "ProbeResult", "Candidate", "LocatedDirectory", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveDownloadRootResolver {
    private static final String PROBE_PREFIX = ".archive-root-probe-";
    private static final String TAG = "ArchiveDownloadRoot";
    private final ArchiveDirectoryCreator directoryCreator;
    private String lastLoggedFailure;
    private final Function1<String, Unit> log;
    private volatile File selectedRoot;
    private final Object selectionLock;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final byte[] PROBE_BYTES = {90};
    private static final ArchiveDownloadRootResolver process = new ArchiveDownloadRootResolver(null, null, 3, null);

    public ArchiveDownloadRootResolver() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArchiveDownloadRootResolver(ArchiveDirectoryCreator directoryCreator, Function1<? super String, Unit> log) {
        Intrinsics.checkNotNullParameter(directoryCreator, "directoryCreator");
        Intrinsics.checkNotNullParameter(log, "log");
        this.directoryCreator = directoryCreator;
        this.log = log;
        this.selectionLock = new Object();
    }

    public /* synthetic */ ArchiveDownloadRootResolver(AndroidArchiveDirectoryCreator androidArchiveDirectoryCreator, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? AndroidArchiveDirectoryCreator.INSTANCE : androidArchiveDirectoryCreator, (i & 2) != 0 ? new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.ArchiveDownloadRootResolver$$ExternalSyntheticLambda0
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

    public final File resolve(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (this.selectionLock) {
            File file = this.selectedRoot;
            if (file != null) {
                return revalidate(context, file);
            }
            File choose = choose(context);
            if (choose == null) {
                return null;
            }
            this.selectedRoot = choose;
            return choose;
        }
    }

    private final File revalidate(Context context, File file) {
        String gameStorageFailure = gameStorageFailure(readExternalFiles(context));
        if (gameStorageFailure != null) {
            logFailure("Archive download root unavailable; " + gameStorageFailure);
            return null;
        }
        ProbeResult probe = probe(file);
        if (Intrinsics.areEqual(probe, ProbeResult.Usable.INSTANCE) || Intrinsics.areEqual(probe, ProbeResult.NoSpace.INSTANCE)) {
            if (this.lastLoggedFailure != null) {
                logChoice("Archive download root pinned directory recovered");
            }
            return file;
        } else if (!(probe instanceof ProbeResult.Unusable)) {
            throw new NoWhenBranchMatchedException();
        } else {
            logFailure("Archive download root unavailable; pinned " + ((ProbeResult.Unusable) probe).getReason());
            return null;
        }
    }

    private final File choose(Context context) {
        LocatedDirectory readExternalFiles = readExternalFiles(context);
        String gameStorageFailure = gameStorageFailure(readExternalFiles);
        if (gameStorageFailure != null) {
            logFailure("Archive download root unavailable; " + gameStorageFailure);
            return null;
        }
        File directory = readExternalFiles.getDirectory();
        if (directory == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        File archiveFallbackDownloadRoot = ArchiveDownloadRootResolverKt.archiveFallbackDownloadRoot(directory);
        if (archiveFallbackDownloadRoot.isDirectory()) {
            ProbeResult probe = probe(archiveFallbackDownloadRoot);
            if (Intrinsics.areEqual(probe, ProbeResult.Usable.INSTANCE)) {
                logChoice("Archive download root keeping existing fallback");
                return archiveFallbackDownloadRoot;
            } else if (Intrinsics.areEqual(probe, ProbeResult.NoSpace.INSTANCE)) {
                logChoice("Archive download root probe has no space; using fallback");
                return archiveFallbackDownloadRoot;
            } else if (!(probe instanceof ProbeResult.Unusable)) {
                throw new NoWhenBranchMatchedException();
            } else {
                Candidate probePrimary = probePrimary(context);
                if (probePrimary instanceof Candidate.Ready) {
                    logChoice("Archive download root existing fallback unusable (" + ((ProbeResult.Unusable) probe).getReason() + "); using primary");
                    return ((Candidate.Ready) probePrimary).getDirectory();
                } else if (!(probePrimary instanceof Candidate.Failed)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    String reason = ((Candidate.Failed) probePrimary).getReason();
                    logFailure("Archive download root unavailable; primary=" + reason + " fallback=" + ((ProbeResult.Unusable) probe).getReason());
                    return null;
                }
            }
        }
        Candidate probePrimary2 = probePrimary(context);
        if (probePrimary2 instanceof Candidate.Ready) {
            Candidate.Ready ready = (Candidate.Ready) probePrimary2;
            if (ready.getNoSpace()) {
                logChoice("Archive download root probe has no space; using primary");
            } else if (this.lastLoggedFailure != null) {
                logChoice("Archive download root primary recovered");
            }
            return ready.getDirectory();
        } else if (!(probePrimary2 instanceof Candidate.Failed)) {
            throw new NoWhenBranchMatchedException();
        } else {
            ProbeResult probe2 = probe(archiveFallbackDownloadRoot);
            if (Intrinsics.areEqual(probe2, ProbeResult.Usable.INSTANCE)) {
                logChoice("Archive download root primary failed (" + ((Candidate.Failed) probePrimary2).getReason() + "); using fallback");
                return archiveFallbackDownloadRoot;
            } else if (Intrinsics.areEqual(probe2, ProbeResult.NoSpace.INSTANCE)) {
                logChoice("Archive download root probe has no space; using fallback");
                return archiveFallbackDownloadRoot;
            } else if (!(probe2 instanceof ProbeResult.Unusable)) {
                throw new NoWhenBranchMatchedException();
            } else {
                String reason2 = ((Candidate.Failed) probePrimary2).getReason();
                logFailure("Archive download root unavailable; primary=" + reason2 + " fallback=" + ((ProbeResult.Unusable) probe2).getReason());
                return null;
            }
        }
    }

    private final Candidate probePrimary(Context context) {
        File archivePrimaryDownloadRoot;
        LocatedDirectory readExternalCache = readExternalCache(context);
        String failure = readExternalCache.getFailure();
        if (failure != null) {
            return new Candidate.Failed(failure);
        }
        File directory = readExternalCache.getDirectory();
        if (directory == null || (archivePrimaryDownloadRoot = ArchiveDownloadRootResolverKt.archivePrimaryDownloadRoot(directory)) == null) {
            return new Candidate.Failed("external cache unavailable");
        }
        ProbeResult probe = probe(archivePrimaryDownloadRoot);
        if (Intrinsics.areEqual(probe, ProbeResult.Usable.INSTANCE)) {
            return new Candidate.Ready(archivePrimaryDownloadRoot, false);
        }
        if (Intrinsics.areEqual(probe, ProbeResult.NoSpace.INSTANCE)) {
            return new Candidate.Ready(archivePrimaryDownloadRoot, true);
        }
        if (probe instanceof ProbeResult.Unusable) {
            return new Candidate.Failed(((ProbeResult.Unusable) probe).getReason());
        }
        throw new NoWhenBranchMatchedException();
    }

    private final ProbeResult probe(File file) {
        ProbeResult.Unusable unusable;
        ProbeResult.Unusable unusable2;
        FileOutputStream fileOutputStream;
        boolean isDirectory = file.isDirectory();
        try {
            if (!this.directoryCreator.createDirectories(file) || !file.isDirectory()) {
                discardEmptyCreatedDirectory(file, isDirectory);
                return new ProbeResult.Unusable("not a directory");
            }
            File file2 = new File(file, PROBE_PREFIX + System.nanoTime() + Constants.FILENAME_SEQUENCE_SEPARATOR + Thread.currentThread().getId());
            try {
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e) {
                    if (file.isDirectory() && ArchiveStorageFailureClassifier.INSTANCE.isNoSpace(e)) {
                        unusable = ProbeResult.NoSpace.INSTANCE;
                    } else {
                        unusable = new ProbeResult.Unusable("write failed (" + failureDetail(e) + ")");
                    }
                    unusable2 = (file2.exists() && !file2.delete() && file2.exists() && unusable == null) ? new ProbeResult.Unusable("delete failed") : unusable;
                }
                try {
                    FileOutputStream fileOutputStream2 = fileOutputStream;
                    byte[] bArr = PROBE_BYTES;
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    Unit unit = Unit.INSTANCE;
                    unusable2 = null;
                    CloseableKt.closeFinally(fileOutputStream, null);
                    if (!file2.isFile() || !Arrays.equals(FilesKt.readBytes(file2), bArr)) {
                        unusable2 = new ProbeResult.Unusable("write failed (incomplete)");
                    }
                    if (file2.exists() && !file2.delete() && file2.exists() && unusable2 == null) {
                        unusable2 = new ProbeResult.Unusable("delete failed");
                    }
                    if (unusable2 instanceof ProbeResult.Unusable) {
                        discardEmptyCreatedDirectory(file, isDirectory);
                    }
                    return unusable2 == null ? ProbeResult.Usable.INSTANCE : unusable2;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(fileOutputStream, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                if (file2.exists() && !file2.delete() && file2.exists()) {
                    new ProbeResult.Unusable("delete failed");
                }
                throw th3;
            }
        } catch (IOException e2) {
            if (file.isDirectory() && ArchiveStorageFailureClassifier.INSTANCE.isNoSpace(e2)) {
                return ProbeResult.NoSpace.INSTANCE;
            }
            discardEmptyCreatedDirectory(file, isDirectory);
            return new ProbeResult.Unusable("create failed (" + failureDetail(e2) + ")");
        } catch (SecurityException e3) {
            discardEmptyCreatedDirectory(file, isDirectory);
            return new ProbeResult.Unusable("create failed (" + failureDetail(e3) + ")");
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
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir == null) {
                return new LocatedDirectory(null, "external cache unavailable");
            }
            return new LocatedDirectory(externalCacheDir, null);
        } catch (Exception e) {
            return new LocatedDirectory(null, "external cache unavailable (" + e.getClass().getSimpleName() + ")");
        }
    }

    private final LocatedDirectory readExternalFiles(Context context) {
        try {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                return new LocatedDirectory(null, "game storage unavailable");
            }
            return new LocatedDirectory(externalFilesDir, null);
        } catch (Exception e) {
            return new LocatedDirectory(null, "game storage unavailable (" + e.getClass().getSimpleName() + ")");
        }
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
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$Candidate;", "", "Ready", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$Candidate$Failed;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$Candidate$Ready;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver$Companion;", "", "<init>", "()V", "TAG", "", "PROBE_PREFIX", "PROBE_BYTES", "", "process", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver;", "getProcess", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadRootResolver;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
