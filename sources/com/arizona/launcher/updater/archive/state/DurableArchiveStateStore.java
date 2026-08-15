package com.arizona.launcher.updater.archive.state;

import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import coil3.util.UtilsKt;
import com.arizona.launcher.updater.archive.io.AndroidArchiveDirectoryCreator;
import com.arizona.launcher.updater.archive.state.ArchiveStateLoadResult;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
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
/* compiled from: DurableArchiveStateStore.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000 (2\u00020\u0001:\u0002'(B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\fJ\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0015J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001aJ\b\u0010\u001b\u001a\u00020\u0015H\u0002J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\u0018\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003H\u0002J\b\u0010!\u001a\u00020\u0015H\u0002J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0003H\u0002J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b*\u0012\b\b+\u0012\u0004\b\u0003\u0010\u0000¨\u0006)"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;", "", "rootDir", "Ljava/io/File;", "json", "Lkotlinx/serialization/json/Json;", "fileName", "", "useAndroidAtomicRename", "", "<init>", "(Ljava/io/File;Lkotlinx/serialization/json/Json;Ljava/lang/String;Z)V", "(Ljava/io/File;Lkotlinx/serialization/json/Json;Ljava/lang/String;)V", "primaryFile", "tempFile", "backupFile", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "load", "Lcom/arizona/launcher/updater/archive/state/ArchiveStateLoadResult;", "save", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "clear", "managedFiles", "", "ensureRootDir", "writeAtomically", "payload", "replaceFile", "source", TypedValues.AttributesType.S_TARGET, "syncRootDirectory", "copyReplace", "readAndValidate", "Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore$ParseOutcome;", UtilsKt.SCHEME_FILE, "deleteIfExists", "ParseOutcome", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DurableArchiveStateStore {
    public static final String BACKUP_SUFFIX = ".bak";
    public static final String DEFAULT_FILE_NAME = "archive_updater_state.json";
    public static final String TEMP_SUFFIX = ".tmp";
    private final File backupFile;
    private final Json json;
    private final ReentrantReadWriteLock lock;
    private final File primaryFile;
    private final File rootDir;
    private final File tempFile;
    private final boolean useAndroidAtomicRename;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Json DEFAULT_JSON = JsonKt.Json$default(null, new Function1() { // from class: com.arizona.launcher.updater.archive.state.DurableArchiveStateStore$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return DurableArchiveStateStore.DEFAULT_JSON$lambda$0((JsonBuilder) obj);
        }
    }, 1, null);

    public /* synthetic */ DurableArchiveStateStore(File file, Json json, String str, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, json, str, z);
    }

    private DurableArchiveStateStore(File file, Json json, String str, boolean z) {
        this.json = json;
        this.useAndroidAtomicRename = z;
        File absoluteFile = file.getAbsoluteFile();
        Intrinsics.checkNotNullExpressionValue(absoluteFile, "getAbsoluteFile(...)");
        this.rootDir = absoluteFile;
        this.primaryFile = new File(absoluteFile, str);
        this.tempFile = new File(absoluteFile, str + ".tmp");
        this.backupFile = new File(absoluteFile, str + BACKUP_SUFFIX);
        this.lock = new ReentrantReadWriteLock();
    }

    /* synthetic */ DurableArchiveStateStore(File file, Json json, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i & 2) != 0 ? DEFAULT_JSON : json, (i & 4) != 0 ? DEFAULT_FILE_NAME : str, z);
    }

    public /* synthetic */ DurableArchiveStateStore(File file, Json json, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i & 2) != 0 ? DEFAULT_JSON : json, (i & 4) != 0 ? DEFAULT_FILE_NAME : str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DurableArchiveStateStore(File rootDir, Json json, String fileName) {
        this(rootDir, json, fileName, false);
        Intrinsics.checkNotNullParameter(rootDir, "rootDir");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
    }

    public final ArchiveStateLoadResult load() {
        ArchiveStateLoadResult.Corrupt corrupt;
        ArchiveStateLoadResult.Corrupt corrupt2;
        ReentrantReadWriteLock.ReadLock readLock = this.lock.readLock();
        readLock.lock();
        try {
            boolean isFile = this.primaryFile.isFile();
            boolean isFile2 = this.backupFile.isFile();
            if (!isFile && !isFile2) {
                corrupt2 = ArchiveStateLoadResult.Missing.INSTANCE;
            } else if (isFile) {
                ParseOutcome readAndValidate = readAndValidate(this.primaryFile);
                if (readAndValidate instanceof ParseOutcome.Ok) {
                    corrupt2 = new ArchiveStateLoadResult.Loaded(((ParseOutcome.Ok) readAndValidate).getState(), false);
                } else if (!(readAndValidate instanceof ParseOutcome.Failed)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    if (isFile2) {
                        ParseOutcome readAndValidate2 = readAndValidate(this.backupFile);
                        if (readAndValidate2 instanceof ParseOutcome.Ok) {
                            corrupt2 = new ArchiveStateLoadResult.Loaded(((ParseOutcome.Ok) readAndValidate2).getState(), true);
                        } else if (!(readAndValidate2 instanceof ParseOutcome.Failed)) {
                            throw new NoWhenBranchMatchedException();
                        } else {
                            String reason = ((ParseOutcome.Failed) readAndValidate).getReason();
                            corrupt2 = new ArchiveStateLoadResult.Corrupt("Primary and backup state unusable. Primary: " + reason + ". Backup: " + ((ParseOutcome.Failed) readAndValidate2).getReason(), ((ParseOutcome.Failed) readAndValidate).getCause());
                        }
                    } else {
                        corrupt2 = new ArchiveStateLoadResult.Corrupt(((ParseOutcome.Failed) readAndValidate).getReason(), ((ParseOutcome.Failed) readAndValidate).getCause());
                    }
                }
            } else {
                ParseOutcome readAndValidate3 = readAndValidate(this.backupFile);
                if (readAndValidate3 instanceof ParseOutcome.Ok) {
                    corrupt = new ArchiveStateLoadResult.Loaded(((ParseOutcome.Ok) readAndValidate3).getState(), true);
                } else if (!(readAndValidate3 instanceof ParseOutcome.Failed)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    corrupt = new ArchiveStateLoadResult.Corrupt("Primary missing; backup unusable: " + ((ParseOutcome.Failed) readAndValidate3).getReason(), ((ParseOutcome.Failed) readAndValidate3).getCause());
                }
                corrupt2 = corrupt;
            }
            return corrupt2;
        } finally {
            readLock.unlock();
        }
    }

    public final void save(ArchiveUpdaterState state) {
        Intrinsics.checkNotNullParameter(state, "state");
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
            ArchiveStateValidation.INSTANCE.requireValidState(state);
            ensureRootDir();
            Json json = this.json;
            json.getSerializersModule();
            writeAtomically(json.encodeToString(ArchiveUpdaterState.Companion.serializer(), state));
            Unit unit = Unit.INSTANCE;
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    public final void clear() {
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
            deleteIfExists(this.tempFile);
            deleteIfExists(this.primaryFile);
            deleteIfExists(this.backupFile);
            Unit unit = Unit.INSTANCE;
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    public final List<File> managedFiles() {
        return CollectionsKt.listOf((Object[]) new File[]{this.primaryFile, this.tempFile, this.backupFile});
    }

    private final void ensureRootDir() {
        boolean mkdirs;
        if (this.rootDir.exists()) {
            if (this.rootDir.isDirectory()) {
                return;
            }
            throw new IOException("Archive state root is not a directory: " + this.rootDir.getPath());
        }
        if (this.useAndroidAtomicRename) {
            mkdirs = AndroidArchiveDirectoryCreator.INSTANCE.createDirectories(this.rootDir);
        } else {
            mkdirs = this.rootDir.mkdirs();
        }
        if (mkdirs || this.rootDir.isDirectory()) {
            return;
        }
        throw new IOException("Unable to create archive state root: " + this.rootDir.getPath());
    }

    private final void writeAtomically(String str) {
        deleteIfExists(this.tempFile);
        FileOutputStream fileOutputStream = new FileOutputStream(this.tempFile);
        try {
            FileOutputStream fileOutputStream2 = fileOutputStream;
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            fileOutputStream2.write(bytes);
            fileOutputStream2.flush();
            fileOutputStream2.getFD().sync();
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
            if (this.primaryFile.isFile()) {
                ParseOutcome readAndValidate = readAndValidate(this.primaryFile);
                if (readAndValidate instanceof ParseOutcome.Ok) {
                    replaceFile(this.primaryFile, this.backupFile);
                } else if (!(readAndValidate instanceof ParseOutcome.Failed)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    deleteIfExists(this.primaryFile);
                    if (this.useAndroidAtomicRename) {
                        syncRootDirectory();
                    }
                }
            }
            replaceFile(this.tempFile, this.primaryFile);
        } finally {
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
            throw new IOException("Failed to replace managed state file: " + file2.getPath());
        } else if (file.renameTo(file2)) {
        } else {
            copyReplace(file, file2);
            if (file.delete() || !file.exists()) {
                return;
            }
            String path2 = file2.getPath();
            throw new IOException("Failed to replace '" + path2 + "' from '" + file.getPath() + "'");
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
                throw new IOException("Unable to fsync archive state directory", e);
            }
        } catch (ErrnoException e2) {
            throw new IOException("Unable to open archive state directory for fsync", e2);
        }
    }

    private final void copyReplace(File file, File file2) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileInputStream fileInputStream2 = fileInputStream;
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            FileOutputStream fileOutputStream2 = fileOutputStream;
            ByteStreamsKt.copyTo$default(fileInputStream2, fileOutputStream2, 0, 2, null);
            fileOutputStream2.flush();
            fileOutputStream2.getFD().sync();
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
            Unit unit2 = Unit.INSTANCE;
            CloseableKt.closeFinally(fileInputStream, null);
        } finally {
        }
    }

    private final ParseOutcome readAndValidate(File file) {
        if (!file.isFile()) {
            return new ParseOutcome.Failed("Not a file: " + file.getPath(), null, 2, null);
        } else if (file.length() == 0) {
            return new ParseOutcome.Failed("Empty state file: " + file.getPath(), null, 2, null);
        } else {
            try {
                String readText = FilesKt.readText(file, Charsets.UTF_8);
                String str = readText;
                if (StringsKt.isBlank(str)) {
                    return new ParseOutcome.Failed("Blank state file: " + file.getPath(), null, 2, null);
                }
                String obj = StringsKt.trim((CharSequence) str).toString();
                if (!StringsKt.startsWith$default(obj, "{", false, 2, (Object) null) || !StringsKt.endsWith$default(obj, "}", false, 2, (Object) null)) {
                    return new ParseOutcome.Failed("Truncated or malformed JSON envelope in " + file.getPath(), null, 2, null);
                }
                try {
                    ArchiveUpdaterState archiveUpdaterState = (ArchiveUpdaterState) this.json.decodeFromString(ArchiveUpdaterState.Companion.serializer(), readText);
                    try {
                        ArchiveStateValidation.INSTANCE.requireValidState(archiveUpdaterState);
                        return new ParseOutcome.Ok(archiveUpdaterState);
                    } catch (ArchiveStateInvariantException e) {
                        String path = file.getPath();
                        return new ParseOutcome.Failed("Invariant failure in " + path + ": " + e.getMessage(), e);
                    }
                } catch (SerializationException e2) {
                    String path2 = file.getPath();
                    return new ParseOutcome.Failed("JSON parse failed for " + path2 + ": " + e2.getMessage(), e2);
                } catch (Exception e3) {
                    String path3 = file.getPath();
                    return new ParseOutcome.Failed("Decode failed for " + path3 + ": " + e3.getMessage(), e3);
                }
            } catch (Exception e4) {
                String path4 = file.getPath();
                return new ParseOutcome.Failed("Failed to read " + path4 + ": " + e4.getMessage(), e4);
            }
        }
    }

    private final void deleteIfExists(File file) {
        if (file.exists() && !file.delete() && file.exists()) {
            throw new IOException("Failed to delete managed state file: " + file.getPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DurableArchiveStateStore.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore$ParseOutcome;", "", "<init>", "()V", "Ok", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore$ParseOutcome$Failed;", "Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore$ParseOutcome$Ok;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class ParseOutcome {
        public /* synthetic */ ParseOutcome(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: DurableArchiveStateStore.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore$ParseOutcome$Ok;", "Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore$ParseOutcome;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "<init>", "(Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;)V", "getState", "()Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Ok extends ParseOutcome {
            public static final int $stable = ArchiveUpdaterState.$stable;
            private final ArchiveUpdaterState state;

            public static /* synthetic */ Ok copy$default(Ok ok, ArchiveUpdaterState archiveUpdaterState, int i, Object obj) {
                if ((i & 1) != 0) {
                    archiveUpdaterState = ok.state;
                }
                return ok.copy(archiveUpdaterState);
            }

            public final ArchiveUpdaterState component1() {
                return this.state;
            }

            public final Ok copy(ArchiveUpdaterState state) {
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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Ok(ArchiveUpdaterState state) {
                super(null);
                Intrinsics.checkNotNullParameter(state, "state");
                this.state = state;
            }

            public final ArchiveUpdaterState getState() {
                return this.state;
            }
        }

        private ParseOutcome() {
        }

        /* compiled from: DurableArchiveStateStore.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore$ParseOutcome$Failed;", "Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore$ParseOutcome;", "reason", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getReason", "()Ljava/lang/String;", "getCause", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Failed extends ParseOutcome {
            public static final int $stable = 8;
            private final Throwable cause;
            private final String reason;

            public static /* synthetic */ Failed copy$default(Failed failed, String str, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = failed.reason;
                }
                if ((i & 2) != 0) {
                    th = failed.cause;
                }
                return failed.copy(str, th);
            }

            public final String component1() {
                return this.reason;
            }

            public final Throwable component2() {
                return this.cause;
            }

            public final Failed copy(String reason, Throwable th) {
                Intrinsics.checkNotNullParameter(reason, "reason");
                return new Failed(reason, th);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Failed) {
                    Failed failed = (Failed) obj;
                    return Intrinsics.areEqual(this.reason, failed.reason) && Intrinsics.areEqual(this.cause, failed.cause);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = this.reason.hashCode() * 31;
                Throwable th = this.cause;
                return hashCode + (th == null ? 0 : th.hashCode());
            }

            public String toString() {
                String str = this.reason;
                return "Failed(reason=" + str + ", cause=" + this.cause + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failed(String reason, Throwable th) {
                super(null);
                Intrinsics.checkNotNullParameter(reason, "reason");
                this.reason = reason;
                this.cause = th;
            }

            public /* synthetic */ Failed(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? null : th);
            }

            public final Throwable getCause() {
                return this.cause;
            }

            public final String getReason() {
                return this.reason;
            }
        }
    }

    /* compiled from: DurableArchiveStateStore.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore$Companion;", "", "<init>", "()V", "DEFAULT_FILE_NAME", "", "TEMP_SUFFIX", "BACKUP_SUFFIX", "DEFAULT_JSON", "Lkotlinx/serialization/json/Json;", "getDEFAULT_JSON", "()Lkotlinx/serialization/json/Json;", "forAndroid", "Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;", "rootDir", "Ljava/io/File;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Json getDEFAULT_JSON() {
            return DurableArchiveStateStore.DEFAULT_JSON;
        }

        public final DurableArchiveStateStore forAndroid(File rootDir) {
            Intrinsics.checkNotNullParameter(rootDir, "rootDir");
            return new DurableArchiveStateStore(rootDir, getDEFAULT_JSON(), DurableArchiveStateStore.DEFAULT_FILE_NAME, true, (DefaultConstructorMarker) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DEFAULT_JSON$lambda$0(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.setPrettyPrint(true);
        Json.setEncodeDefaults(true);
        Json.setIgnoreUnknownKeys(false);
        Json.setExplicitNulls(false);
        return Unit.INSTANCE;
    }
}
