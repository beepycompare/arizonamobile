package com.arizona.launcher.updater.archive.orchestrator;

import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import coil3.util.UtilsKt;
import com.arizona.launcher.updater.archive.io.AndroidArchiveDirectoryCreator;
import com.arizona.launcher.updater.archive.io.AndroidArchiveNodeInspector;
import com.arizona.launcher.updater.archive.io.ArchiveDirectoryCreator;
import com.arizona.launcher.updater.archive.io.ArchiveFsNodeType;
import com.arizona.launcher.updater.archive.io.ArchiveNodeInspector;
import com.arizona.launcher.updater.archive.io.JvmArchiveDirectoryCreator;
import com.arizona.launcher.updater.archive.io.JvmArchiveNodeInspector;
import com.arizona.launcher.updater.archive.orchestrator.EngineResourceGenerationLoadResult;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
/* compiled from: EngineResourceGenerationStore.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 .2\u00020\u0001:\u0002-.B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\u000eJ\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u001dH\u0002J\u0018\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003H\u0002J\b\u0010(\u001a\u00020\u001dH\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\u0012\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010\"\u001a\u00020#H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b0\u0012\b\b1\u0012\u0004\b\u0003\u0010\u0000¨\u0006/"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationStore;", "", "rootDir", "Ljava/io/File;", "json", "Lkotlinx/serialization/json/Json;", "useAndroidAtomicRename", "", "directoryCreator", "Lcom/arizona/launcher/updater/archive/io/ArchiveDirectoryCreator;", "nodeInspector", "Lcom/arizona/launcher/updater/archive/io/ArchiveNodeInspector;", "<init>", "(Ljava/io/File;Lkotlinx/serialization/json/Json;ZLcom/arizona/launcher/updater/archive/io/ArchiveDirectoryCreator;Lcom/arizona/launcher/updater/archive/io/ArchiveNodeInspector;)V", "(Ljava/io/File;)V", "primaryFile", "tempFile", "backupFile", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "load", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationLoadResult;", "readLocked", "inspectManagedNodes", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationLoadResult$Corrupt;", "nodeOf", "Lcom/arizona/launcher/updater/archive/io/ArchiveFsNodeType;", UtilsKt.SCHEME_FILE, "savePrepared", "", "generation", "", "saveCompleted", "write", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationState;", "ensureRootDir", "replaceFile", "source", TypedValues.AttributesType.S_TARGET, "syncRootDirectory", "readState", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationStore$ParseOutcome;", "validate", "", "ParseOutcome", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EngineResourceGenerationStore {
    private static final String BACKUP_SUFFIX = ".bak";
    public static final String DIRECTORY_NAME = "engine-resource-generation";
    public static final String FILE_NAME = "engine_resource_generation.json";
    private static final String TEMP_SUFFIX = ".tmp";
    private final File backupFile;
    private final ArchiveDirectoryCreator directoryCreator;
    private final Json json;
    private final ReentrantReadWriteLock lock;
    private final ArchiveNodeInspector nodeInspector;
    private final File primaryFile;
    private final File rootDir;
    private final File tempFile;
    private final boolean useAndroidAtomicRename;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Json DEFAULT_JSON = JsonKt.Json$default(null, new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.EngineResourceGenerationStore$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return EngineResourceGenerationStore.DEFAULT_JSON$lambda$0((JsonBuilder) obj);
        }
    }, 1, null);

    /* compiled from: EngineResourceGenerationStore.kt */
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
                iArr[ArchiveFsNodeType.REGULAR_FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ EngineResourceGenerationStore(File file, Json json, boolean z, ArchiveDirectoryCreator archiveDirectoryCreator, ArchiveNodeInspector archiveNodeInspector, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, json, z, archiveDirectoryCreator, archiveNodeInspector);
    }

    private EngineResourceGenerationStore(File file, Json json, boolean z, ArchiveDirectoryCreator archiveDirectoryCreator, ArchiveNodeInspector archiveNodeInspector) {
        this.json = json;
        this.useAndroidAtomicRename = z;
        this.directoryCreator = archiveDirectoryCreator;
        this.nodeInspector = archiveNodeInspector;
        File absoluteFile = file.getAbsoluteFile();
        Intrinsics.checkNotNullExpressionValue(absoluteFile, "getAbsoluteFile(...)");
        this.rootDir = absoluteFile;
        this.primaryFile = new File(absoluteFile, FILE_NAME);
        this.tempFile = new File(absoluteFile, "engine_resource_generation.json.tmp");
        this.backupFile = new File(absoluteFile, "engine_resource_generation.json.bak");
        this.lock = new ReentrantReadWriteLock();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EngineResourceGenerationStore(File rootDir) {
        this(rootDir, DEFAULT_JSON, false, JvmArchiveDirectoryCreator.INSTANCE, JvmArchiveNodeInspector.INSTANCE);
        Intrinsics.checkNotNullParameter(rootDir, "rootDir");
    }

    public final EngineResourceGenerationLoadResult load() {
        ReentrantReadWriteLock.ReadLock readLock = this.lock.readLock();
        readLock.lock();
        try {
            return readLocked();
        } finally {
            readLock.unlock();
        }
    }

    private final EngineResourceGenerationLoadResult readLocked() {
        EngineResourceGenerationLoadResult.Corrupt inspectManagedNodes = inspectManagedNodes();
        if (inspectManagedNodes != null) {
            return inspectManagedNodes;
        }
        boolean z = nodeOf(this.primaryFile) == ArchiveFsNodeType.REGULAR_FILE;
        boolean z2 = nodeOf(this.backupFile) == ArchiveFsNodeType.REGULAR_FILE;
        if (z || z2) {
            if (z) {
                ParseOutcome readState = readState(this.primaryFile);
                if (readState instanceof ParseOutcome.Ok) {
                    return new EngineResourceGenerationLoadResult.Loaded(((ParseOutcome.Ok) readState).getState());
                }
                if (readState instanceof ParseOutcome.Failed) {
                    if (!z2) {
                        return new EngineResourceGenerationLoadResult.Corrupt(((ParseOutcome.Failed) readState).getReason());
                    }
                    ParseOutcome readState2 = readState(this.backupFile);
                    if (readState2 instanceof ParseOutcome.Ok) {
                        return new EngineResourceGenerationLoadResult.Loaded(((ParseOutcome.Ok) readState2).getState());
                    }
                    if (!(readState2 instanceof ParseOutcome.Failed)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return new EngineResourceGenerationLoadResult.Corrupt("Primary and backup resource generations are unusable. Primary: " + ((ParseOutcome.Failed) readState).getReason() + ". Backup: " + ((ParseOutcome.Failed) readState2).getReason());
                }
                throw new NoWhenBranchMatchedException();
            }
            ParseOutcome readState3 = readState(this.backupFile);
            if (readState3 instanceof ParseOutcome.Ok) {
                return new EngineResourceGenerationLoadResult.Loaded(((ParseOutcome.Ok) readState3).getState());
            }
            if (!(readState3 instanceof ParseOutcome.Failed)) {
                throw new NoWhenBranchMatchedException();
            }
            return new EngineResourceGenerationLoadResult.Corrupt("Primary resource generation is missing; backup is unusable: " + ((ParseOutcome.Failed) readState3).getReason());
        }
        return EngineResourceGenerationLoadResult.Missing.INSTANCE;
    }

    private final EngineResourceGenerationLoadResult.Corrupt inspectManagedNodes() {
        int i = WhenMappings.$EnumSwitchMapping$0[nodeOf(this.rootDir).ordinal()];
        if (i != 1 && i != 2) {
            return new EngineResourceGenerationLoadResult.Corrupt("Resource generation root is not a real directory: " + this.rootDir.getPath());
        }
        for (File file : CollectionsKt.listOf((Object[]) new File[]{this.primaryFile, this.backupFile, this.tempFile})) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[nodeOf(file).ordinal()];
            if (i2 != 1 && i2 != 3) {
                return new EngineResourceGenerationLoadResult.Corrupt("Resource generation artifact is not a regular file: " + file.getPath());
            }
        }
        return null;
    }

    private final ArchiveFsNodeType nodeOf(File file) {
        try {
            return this.nodeInspector.nodeType(file);
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            throw new IOException("Unable to inspect '" + file.getPath() + "'", e2);
        }
    }

    public final void savePrepared(long j) throws IOException {
        long completedGeneration;
        ReentrantReadWriteLock reentrantReadWriteLock = this.lock;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            if (j < 2) {
                throw new IOException("Refusing to prepare resource generation " + j);
            }
            EngineResourceGenerationLoadResult readLocked = readLocked();
            if (Intrinsics.areEqual(readLocked, EngineResourceGenerationLoadResult.Missing.INSTANCE)) {
                completedGeneration = 0;
            } else if (!(readLocked instanceof EngineResourceGenerationLoadResult.Loaded)) {
                if (!(readLocked instanceof EngineResourceGenerationLoadResult.Corrupt)) {
                    throw new NoWhenBranchMatchedException();
                }
                throw new IOException("Resource generation state is corrupt: " + ((EngineResourceGenerationLoadResult.Corrupt) readLocked).getReason());
            } else {
                completedGeneration = ((EngineResourceGenerationLoadResult.Loaded) readLocked).getState().getCompletedGeneration();
            }
            if (j < completedGeneration) {
                throw new IOException("Refusing to prepare generation " + j + " below completed " + completedGeneration);
            }
            write(new EngineResourceGenerationState(j, completedGeneration));
            Unit unit = Unit.INSTANCE;
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        } catch (Throwable th) {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
            throw th;
        }
    }

    public final void saveCompleted(long j) throws IOException {
        ReentrantReadWriteLock reentrantReadWriteLock = this.lock;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            EngineResourceGenerationLoadResult readLocked = readLocked();
            if (Intrinsics.areEqual(readLocked, EngineResourceGenerationLoadResult.Missing.INSTANCE)) {
                throw new IOException("Resource generation success requires a prepared marker");
            }
            if (readLocked instanceof EngineResourceGenerationLoadResult.Corrupt) {
                throw new IOException("Resource generation state is corrupt: " + ((EngineResourceGenerationLoadResult.Corrupt) readLocked).getReason());
            } else if (!(readLocked instanceof EngineResourceGenerationLoadResult.Loaded)) {
                throw new NoWhenBranchMatchedException();
            } else {
                EngineResourceGenerationState state = ((EngineResourceGenerationLoadResult.Loaded) readLocked).getState();
                if (j != state.getPreparedGeneration()) {
                    throw new IOException("Refusing to complete generation " + j + "; prepared is " + state.getPreparedGeneration());
                } else if (state.getCompletedGeneration() > j) {
                    throw new IOException("Resource generation completed value would move backwards");
                } else {
                    write(EngineResourceGenerationState.copy$default(state, 0L, j, 1, null));
                    Unit unit = Unit.INSTANCE;
                    while (i < readHoldCount) {
                        readLock.lock();
                        i++;
                    }
                    writeLock.unlock();
                }
            }
        } catch (Throwable th) {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
            throw th;
        }
    }

    private final void write(EngineResourceGenerationState engineResourceGenerationState) throws IOException {
        String validate = validate(engineResourceGenerationState);
        if (validate != null) {
            throw new IOException(validate);
        }
        EngineResourceGenerationLoadResult.Corrupt inspectManagedNodes = inspectManagedNodes();
        if (inspectManagedNodes != null) {
            throw new IOException(inspectManagedNodes.getReason());
        }
        ensureRootDir();
        if (nodeOf(this.tempFile) == ArchiveFsNodeType.REGULAR_FILE && !this.tempFile.delete()) {
            throw new IOException("Unable to clear resource generation temp file");
        }
        Json json = this.json;
        json.getSerializersModule();
        String encodeToString = json.encodeToString(EngineResourceGenerationState.Companion.serializer(), engineResourceGenerationState);
        FileOutputStream fileOutputStream = new FileOutputStream(this.tempFile);
        try {
            FileOutputStream fileOutputStream2 = fileOutputStream;
            byte[] bytes = encodeToString.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            fileOutputStream2.write(bytes);
            fileOutputStream2.flush();
            fileOutputStream2.getFD().sync();
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
            if (nodeOf(this.primaryFile) == ArchiveFsNodeType.REGULAR_FILE && (readState(this.primaryFile) instanceof ParseOutcome.Ok)) {
                replaceFile(this.primaryFile, this.backupFile);
            } else if (nodeOf(this.primaryFile) == ArchiveFsNodeType.REGULAR_FILE && !this.primaryFile.delete() && nodeOf(this.primaryFile) != ArchiveFsNodeType.ABSENT) {
                throw new IOException("Unable to remove corrupt resource generation primary");
            }
            replaceFile(this.tempFile, this.primaryFile);
        } finally {
        }
    }

    private final void ensureRootDir() {
        int i = WhenMappings.$EnumSwitchMapping$0[nodeOf(this.rootDir).ordinal()];
        if (i != 1) {
            if (i == 2) {
                return;
            }
            throw new IOException("Resource generation root is not a real directory: " + this.rootDir.getPath());
        }
        boolean createDirectories = this.directoryCreator.createDirectories(this.rootDir);
        if (nodeOf(this.rootDir) != ArchiveFsNodeType.DIRECTORY) {
            throw new IOException("Unable to create resource generation root: " + this.rootDir.getPath() + (createDirectories ? "" : " (creator returned false)"));
        }
    }

    private final void replaceFile(File file, File file2) {
        if (this.useAndroidAtomicRename) {
            try {
                Os.rename(file.getAbsolutePath(), file2.getAbsolutePath());
                syncRootDirectory();
            } catch (ErrnoException e) {
                String path = file2.getPath();
                throw new IOException("Failed to atomically replace '" + path + "' from '" + file.getPath() + "'", e);
            }
        } else if (file2.exists() && !file2.delete()) {
            throw new IOException("Failed to replace resource generation file: " + file2.getPath());
        } else if (file.renameTo(file2)) {
        } else {
            String path2 = file.getPath();
            throw new IOException("Failed to rename '" + path2 + "' to '" + file2.getPath() + "'");
        }
    }

    private final void syncRootDirectory() {
        try {
            FileDescriptor open = Os.open(this.rootDir.getAbsolutePath(), OsConstants.O_RDONLY, 0);
            try {
                try {
                    Os.fsync(open);
                    try {
                        Os.close(open);
                    } catch (ErrnoException unused) {
                    }
                } catch (Throwable th) {
                    try {
                        Os.close(open);
                    } catch (ErrnoException unused2) {
                    }
                    throw th;
                }
            } catch (ErrnoException e) {
                throw new IOException("Unable to fsync resource generation directory", e);
            }
        } catch (ErrnoException e2) {
            throw new IOException("Unable to open resource generation directory for fsync", e2);
        }
    }

    private final ParseOutcome readState(File file) {
        if (!file.isFile()) {
            return new ParseOutcome.Failed("Not a file: " + file.getPath());
        }
        try {
            String readText = FilesKt.readText(file, Charsets.UTF_8);
            String obj = StringsKt.trim((CharSequence) readText).toString();
            if (!StringsKt.startsWith$default(obj, "{", false, 2, (Object) null) || !StringsKt.endsWith$default(obj, "}", false, 2, (Object) null)) {
                return new ParseOutcome.Failed("Malformed resource generation JSON in " + file.getPath());
            }
            try {
                EngineResourceGenerationState engineResourceGenerationState = (EngineResourceGenerationState) this.json.decodeFromString(EngineResourceGenerationState.Companion.serializer(), readText);
                String validate = validate(engineResourceGenerationState);
                return validate != null ? new ParseOutcome.Failed(validate) : new ParseOutcome.Ok(engineResourceGenerationState);
            } catch (SerializationException e) {
                return new ParseOutcome.Failed("Resource generation JSON is corrupt: " + e.getMessage());
            } catch (Exception e2) {
                return new ParseOutcome.Failed("Resource generation decode failed: " + e2.getMessage());
            }
        } catch (Exception e3) {
            return new ParseOutcome.Failed("Failed to read " + file.getPath() + ": " + e3.getMessage());
        }
    }

    private final String validate(EngineResourceGenerationState engineResourceGenerationState) {
        if (engineResourceGenerationState.getPreparedGeneration() < 0 || engineResourceGenerationState.getCompletedGeneration() < 0) {
            return "Resource generations must be non-negative";
        }
        if (engineResourceGenerationState.getCompletedGeneration() > engineResourceGenerationState.getPreparedGeneration()) {
            return "Completed resource generation cannot exceed the prepared generation";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EngineResourceGenerationStore.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationStore$ParseOutcome;", "", "Ok", "Failed", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationStore$ParseOutcome$Failed;", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationStore$ParseOutcome$Ok;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface ParseOutcome {

        /* compiled from: EngineResourceGenerationStore.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationStore$ParseOutcome$Ok;", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationStore$ParseOutcome;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationState;", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationState;)V", "getState", "()Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Ok implements ParseOutcome {
            public static final int $stable = 0;
            private final EngineResourceGenerationState state;

            public static /* synthetic */ Ok copy$default(Ok ok, EngineResourceGenerationState engineResourceGenerationState, int i, Object obj) {
                if ((i & 1) != 0) {
                    engineResourceGenerationState = ok.state;
                }
                return ok.copy(engineResourceGenerationState);
            }

            public final EngineResourceGenerationState component1() {
                return this.state;
            }

            public final Ok copy(EngineResourceGenerationState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return new Ok(state);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Ok) && Intrinsics.areEqual(this.state, ((Ok) obj).state);
            }

            public int hashCode() {
                return this.state.hashCode();
            }

            public String toString() {
                return "Ok(state=" + this.state + ")";
            }

            public Ok(EngineResourceGenerationState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                this.state = state;
            }

            public final EngineResourceGenerationState getState() {
                return this.state;
            }
        }

        /* compiled from: EngineResourceGenerationStore.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationStore$ParseOutcome$Failed;", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationStore$ParseOutcome;", "reason", "", "<init>", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Failed implements ParseOutcome {
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

    /* compiled from: EngineResourceGenerationStore.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationStore$Companion;", "", "<init>", "()V", "DIRECTORY_NAME", "", "FILE_NAME", "TEMP_SUFFIX", "BACKUP_SUFFIX", "DEFAULT_JSON", "Lkotlinx/serialization/json/Json;", "forAndroid", "Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceGenerationStore;", "rootDir", "Ljava/io/File;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EngineResourceGenerationStore forAndroid(File rootDir) {
            Intrinsics.checkNotNullParameter(rootDir, "rootDir");
            return new EngineResourceGenerationStore(rootDir, EngineResourceGenerationStore.DEFAULT_JSON, true, AndroidArchiveDirectoryCreator.INSTANCE, AndroidArchiveNodeInspector.INSTANCE, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DEFAULT_JSON$lambda$0(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.setEncodeDefaults(true);
        Json.setIgnoreUnknownKeys(false);
        Json.setExplicitNulls(false);
        return Unit.INSTANCE;
    }
}
