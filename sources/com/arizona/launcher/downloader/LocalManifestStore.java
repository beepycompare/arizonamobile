package com.arizona.launcher.downloader;

import android.util.Log;
import java.io.File;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: LocalManifestRepository.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012J \u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0016J5\u0010\u0018\u001a\u00020\r2#\u0010\u0019\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u001b\u0012\u0004\u0012\u00020\r0\u001a¢\u0006\u0002\b\u001c2\b\b\u0002\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u0016J\u001e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0012H\u0002J\b\u0010$\u001a\u00020\u0016H\u0002J\u0014\u0010%\u001a\u00020\r2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/arizona/launcher/downloader/LocalManifestStore;", "", "manifestFile", "Ljava/io/File;", "json", "Lkotlinx/serialization/json/Json;", "<init>", "(Ljava/io/File;Lkotlinx/serialization/json/Json;)V", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "manifest", "Lcom/arizona/launcher/downloader/LocalManifest;", "load", "", "save", "get", "Lcom/arizona/launcher/downloader/FileHashEntry;", "relativePath", "", "put", "entry", "autoSave", "", "remove", "update", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "clear", "isSameByMeta", "fileSize", "", "lastModified", "normalize", "path", "ensureManifestFile", "resetManifestFile", "reason", "", "app"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LocalManifestStore {
    public static final int $stable = 8;
    private final Json json;
    private final ReentrantReadWriteLock lock;
    private LocalManifest manifest;
    private final File manifestFile;

    public LocalManifestStore(File manifestFile, Json json) {
        Intrinsics.checkNotNullParameter(manifestFile, "manifestFile");
        Intrinsics.checkNotNullParameter(json, "json");
        this.manifestFile = manifestFile;
        this.json = json;
        this.lock = new ReentrantReadWriteLock();
        this.manifest = new LocalManifest((Map) null, 1, (DefaultConstructorMarker) null);
        load();
    }

    public /* synthetic */ LocalManifestStore(File file, Json json, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i & 2) != 0 ? JsonKt.Json$default(null, new Function1() { // from class: com.arizona.launcher.downloader.LocalManifestStore$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocalManifestStore._init_$lambda$0((JsonBuilder) obj);
            }
        }, 1, null) : json);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$0(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.setPrettyPrint(true);
        Json.setEncodeDefaults(false);
        Json.setIgnoreUnknownKeys(true);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004c A[Catch: all -> 0x00f5, TryCatch #1 {all -> 0x00f5, blocks: (B:10:0x0023, B:12:0x002c, B:17:0x0039, B:22:0x0045, B:24:0x004c, B:45:0x00e7, B:28:0x005b, B:29:0x008a, B:31:0x0092, B:38:0x00ce, B:42:0x00dd, B:44:0x00e5, B:41:0x00d5, B:43:0x00e0, B:34:0x009e), top: B:55:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00eb A[DONT_GENERATE, LOOP:1: B:46:0x00e9->B:47:0x00eb, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void load() {
        boolean z;
        LocalManifest localManifest;
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
            boolean exists = this.manifestFile.exists();
            boolean z2 = exists && this.manifestFile.canRead();
            if (exists && !this.manifestFile.canWrite()) {
                z = false;
                if (ensureManifestFile()) {
                    this.manifest = new LocalManifest((Map) null, 1, (DefaultConstructorMarker) null);
                } else if (exists && (!z2 || !z)) {
                    resetManifestFile(new IllegalStateException("No access r=" + z2 + " w=" + z));
                    this.manifest = new LocalManifest((Map) null, 1, (DefaultConstructorMarker) null);
                } else {
                    if (this.manifestFile.exists() && this.manifestFile.length() > 0) {
                        Result.Companion companion = Result.Companion;
                        LocalManifestStore localManifestStore = this;
                        String readText = FilesKt.readText(this.manifestFile, Charsets.UTF_8);
                        Json json = this.json;
                        json.getSerializersModule();
                        Object m9842constructorimpl = Result.m9842constructorimpl((LocalManifest) json.decodeFromString(LocalManifest.Companion.serializer(), readText));
                        Throwable m9845exceptionOrNullimpl = Result.m9845exceptionOrNullimpl(m9842constructorimpl);
                        if (m9845exceptionOrNullimpl != null) {
                            resetManifestFile(m9845exceptionOrNullimpl);
                            m9842constructorimpl = new LocalManifest((Map) null, 1, (DefaultConstructorMarker) null);
                        }
                        localManifest = (LocalManifest) m9842constructorimpl;
                    } else {
                        localManifest = new LocalManifest((Map) null, 1, (DefaultConstructorMarker) null);
                    }
                    this.manifest = localManifest;
                }
                Unit unit = Unit.INSTANCE;
            }
            z = true;
            if (ensureManifestFile()) {
            }
            Unit unit2 = Unit.INSTANCE;
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    public final void save() {
        ReentrantReadWriteLock.ReadLock readLock = this.lock.readLock();
        readLock.lock();
        try {
            if (!this.manifestFile.getParentFile().exists()) {
                this.manifestFile.getParentFile().mkdirs();
            }
            Json json = this.json;
            LocalManifest localManifest = this.manifest;
            json.getSerializersModule();
            try {
                FilesKt.writeText(this.manifestFile, json.encodeToString(LocalManifest.Companion.serializer(), localManifest), Charsets.UTF_8);
            } catch (Exception e) {
                Log.d("LocalManifestStore", "LocalManifestStore corrupted");
                e.printStackTrace();
                this.manifestFile.deleteOnExit();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            readLock.unlock();
        }
    }

    public final FileHashEntry get(String relativePath) {
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        ReentrantReadWriteLock.ReadLock readLock = this.lock.readLock();
        readLock.lock();
        try {
            return this.manifest.getFiles().get(normalize(relativePath));
        } finally {
            readLock.unlock();
        }
    }

    public static /* synthetic */ void put$default(LocalManifestStore localManifestStore, String str, FileHashEntry fileHashEntry, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        localManifestStore.put(str, fileHashEntry, z);
    }

    public final void put(String relativePath, FileHashEntry entry, boolean z) {
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        Intrinsics.checkNotNullParameter(entry, "entry");
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
            this.manifest.getFiles().put(normalize(relativePath), entry);
            if (z) {
                save();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    public static /* synthetic */ void remove$default(LocalManifestStore localManifestStore, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        localManifestStore.remove(str, z);
    }

    public final void remove(String relativePath, boolean z) {
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
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
            this.manifest.getFiles().remove(normalize(relativePath));
            if (z) {
                save();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    public static /* synthetic */ void update$default(LocalManifestStore localManifestStore, Function1 function1, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        localManifestStore.update(function1, z);
    }

    public final void update(Function1<? super Map<String, FileHashEntry>, Unit> block, boolean z) {
        Intrinsics.checkNotNullParameter(block, "block");
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
            block.invoke(this.manifest.getFiles());
            if (z) {
                save();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    public static /* synthetic */ void clear$default(LocalManifestStore localManifestStore, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        localManifestStore.clear(z);
    }

    public final void clear(boolean z) {
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
            this.manifest.getFiles().clear();
            if (z) {
                save();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003e A[Catch: all -> 0x0055, TRY_LEAVE, TryCatch #0 {all -> 0x0055, blocks: (B:3:0x000f, B:6:0x0023, B:8:0x002a, B:13:0x0038, B:15:0x003e), top: B:29:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004e A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isSameByMeta(String relativePath, long j, long j2) {
        boolean z;
        Long lastModified;
        boolean z2;
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        ReentrantReadWriteLock.ReadLock readLock = this.lock.readLock();
        readLock.lock();
        try {
            FileHashEntry fileHashEntry = this.manifest.getFiles().get(normalize(relativePath));
            boolean z3 = false;
            if (fileHashEntry != null) {
                Long size = fileHashEntry.getSize();
                if (size != null && size.longValue() != j) {
                    z = false;
                    lastModified = fileHashEntry.getLastModified();
                    if (lastModified != null) {
                        if (lastModified.longValue() != j2) {
                            z2 = false;
                            if (z && z2) {
                                z3 = true;
                            }
                        }
                    }
                    z2 = true;
                    if (z) {
                        z3 = true;
                    }
                }
                z = true;
                lastModified = fileHashEntry.getLastModified();
                if (lastModified != null) {
                }
                z2 = true;
                if (z) {
                }
            }
            return z3;
        } finally {
            readLock.unlock();
        }
    }

    private final String normalize(String str) {
        return StringsKt.trimStart(StringsKt.replace$default(str, (char) AbstractJsonLexerKt.STRING_ESC, '/', false, 4, (Object) null), '/');
    }

    private final boolean ensureManifestFile() {
        try {
            if (this.manifestFile.exists() && !this.manifestFile.isFile()) {
                FilesKt.deleteRecursively(this.manifestFile);
            }
            File parentFile = this.manifestFile.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            if (!this.manifestFile.exists()) {
                this.manifestFile.createNewFile();
            }
            this.manifestFile.setReadable(true, true);
            this.manifestFile.setWritable(true, true);
            return true;
        } catch (Throwable th) {
            Log.e("LocalManifestStore", "ensureManifestFile failed: " + this.manifestFile.getAbsolutePath(), th);
            return false;
        }
    }

    static /* synthetic */ void resetManifestFile$default(LocalManifestStore localManifestStore, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        localManifestStore.resetManifestFile(th);
    }

    private final void resetManifestFile(Throwable th) {
        try {
            File parentFile = this.manifestFile.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            if (this.manifestFile.exists()) {
                File file = new File(this.manifestFile.getParentFile(), "local_manifest.bak_" + System.currentTimeMillis() + ".json");
                Result.Companion companion = Result.Companion;
                LocalManifestStore localManifestStore = this;
                Result.m9842constructorimpl(FilesKt.copyTo$default(this.manifestFile, file, true, 0, 4, null));
            }
            Result.Companion companion2 = Result.Companion;
            LocalManifestStore localManifestStore2 = this;
            Result.m9842constructorimpl(Boolean.valueOf(this.manifestFile.delete()));
            Result.Companion companion3 = Result.Companion;
            LocalManifestStore localManifestStore3 = this;
            this.manifestFile.createNewFile();
            File file2 = this.manifestFile;
            Json json = this.json;
            LocalManifest localManifest = new LocalManifest((Map) null, 1, (DefaultConstructorMarker) null);
            json.getSerializersModule();
            FilesKt.writeText(file2, json.encodeToString(LocalManifest.Companion.serializer(), localManifest), Charsets.UTF_8);
            Result.m9841boximpl(Result.m9842constructorimpl(Unit.INSTANCE));
        } catch (Throwable th2) {
            Integer.valueOf(Log.e("LocalManifestStore", "resetManifestFile failed: " + this.manifestFile.getAbsolutePath(), th2));
        }
        if (th != null) {
            Log.e("LocalManifestStore", "Manifest reset due to error", th);
        }
    }
}
