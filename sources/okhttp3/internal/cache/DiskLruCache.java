package okhttp3.internal.cache;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.ForwardingFileSystem;
import okio.ForwardingSource;
import okio.Okio;
import okio.Path;
import okio.Sink;
import okio.Source;
/* compiled from: DiskLruCache.kt */
@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010)\n\u0002\b\u0005*\u00019\u0018\u0000 a2\u00020\u00012\u00020\u00022\u00020\u0003:\u0004^_`aB7\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010;\u001a\u00020<J\b\u0010=\u001a\u00020<H\u0002J\b\u0010>\u001a\u00020!H\u0002J\u0010\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020$H\u0002J\b\u0010A\u001a\u00020<H\u0002J\r\u0010B\u001a\u00020<H\u0000¢\u0006\u0002\bCJ\u0017\u0010D\u001a\b\u0018\u00010ER\u00020\u00002\u0006\u0010F\u001a\u00020$H\u0086\u0002J \u0010G\u001a\b\u0018\u00010HR\u00020\u00002\u0006\u0010F\u001a\u00020$2\b\b\u0002\u0010I\u001a\u00020\fH\u0007J\u0006\u0010\u001f\u001a\u00020\fJ!\u0010J\u001a\u00020<2\n\u0010K\u001a\u00060HR\u00020\u00002\u0006\u0010L\u001a\u00020+H\u0000¢\u0006\u0002\bMJ\b\u0010N\u001a\u00020+H\u0002J\u000e\u0010O\u001a\u00020+2\u0006\u0010F\u001a\u00020$J\u0019\u0010P\u001a\u00020+2\n\u0010Q\u001a\u00060%R\u00020\u0000H\u0000¢\u0006\u0002\bRJ\b\u0010S\u001a\u00020<H\u0002J\b\u0010T\u001a\u00020<H\u0016J\u0006\u0010U\u001a\u00020+J\b\u0010V\u001a\u00020<H\u0016J\u0006\u0010W\u001a\u00020<J\b\u0010X\u001a\u00020+H\u0002J\u0006\u0010Y\u001a\u00020<J\u0006\u0010Z\u001a\u00020<J\u0010\u0010[\u001a\u00020<2\u0006\u0010F\u001a\u00020$H\u0002J\u0010\u0010\\\u001a\f\u0012\b\u0012\u00060ER\u00020\u00000]R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R8\u0010\"\u001a&\u0012\u0004\u0012\u00020$\u0012\b\u0012\u00060%R\u00020\u00000#j\u0012\u0012\u0004\u0012\u00020$\u0012\b\u0012\u00060%R\u00020\u0000`&X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020+X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u000e\u00103\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0004\n\u0002\u0010:¨\u0006b"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "Lokhttp3/internal/concurrent/Lockable;", "fileSystem", "Lokio/FileSystem;", "directory", "Lokio/Path;", RemoteConfigConstants.RequestFieldKey.APP_VERSION, "", "valueCount", "maxSize", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "<init>", "(Lokio/FileSystem;Lokio/Path;IIJLokhttp3/internal/concurrent/TaskRunner;)V", "getDirectory", "()Lokio/Path;", "getValueCount$okhttp", "()I", "getFileSystem$okhttp", "()Lokio/FileSystem;", "value", "getMaxSize", "()J", "setMaxSize", "(J)V", "journalFile", "journalFileTmp", "journalFileBackup", "size", "journalWriter", "Lokio/BufferedSink;", "lruEntries", "Ljava/util/LinkedHashMap;", "", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "Lkotlin/collections/LinkedHashMap;", "getLruEntries$okhttp", "()Ljava/util/LinkedHashMap;", "redundantOpCount", "hasJournalErrors", "", "civilizedFileSystem", "initialized", "closed", "getClosed$okhttp", "()Z", "setClosed$okhttp", "(Z)V", "mostRecentTrimFailed", "mostRecentRebuildFailed", "nextSequenceNumber", "cleanupQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "cleanupTask", "okhttp3/internal/cache/DiskLruCache$cleanupTask$1", "Lokhttp3/internal/cache/DiskLruCache$cleanupTask$1;", "initialize", "", "readJournal", "newJournalWriter", "readJournalLine", "line", "processJournal", "rebuildJournal", "rebuildJournal$okhttp", "get", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "key", "edit", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "expectedSequenceNumber", "completeEdit", "editor", FirebaseAnalytics.Param.SUCCESS, "completeEdit$okhttp", "journalRebuildRequired", "remove", "removeEntry", "entry", "removeEntry$okhttp", "checkNotClosed", "flush", "isClosed", "close", "trimToSize", "removeOldestEntry", "delete", "evictAll", "validateKey", "snapshots", "", "Snapshot", "Editor", "Entry", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DiskLruCache implements Closeable, Flushable, Lockable {
    private final int appVersion;
    private boolean civilizedFileSystem;
    private final TaskQueue cleanupQueue;
    private final DiskLruCache$cleanupTask$1 cleanupTask;
    private boolean closed;
    private final Path directory;
    private final FileSystem fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final Path journalFile;
    private final Path journalFileBackup;
    private final Path journalFileTmp;
    private BufferedSink journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries;
    private long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;
    public static final Companion Companion = new Companion(null);
    public static final String JOURNAL_FILE = coil3.disk.DiskLruCache.JOURNAL_FILE;
    public static final String JOURNAL_FILE_TEMP = coil3.disk.DiskLruCache.JOURNAL_FILE_TMP;
    public static final String JOURNAL_FILE_BACKUP = coil3.disk.DiskLruCache.JOURNAL_FILE_BACKUP;
    public static final String MAGIC = coil3.disk.DiskLruCache.MAGIC;
    public static final String VERSION_1 = "1";
    public static final long ANY_SEQUENCE_NUMBER = -1;
    public static final Regex LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");
    public static final String CLEAN = "CLEAN";
    public static final String DIRTY = "DIRTY";
    public static final String REMOVE = "REMOVE";
    public static final String READ = "READ";

    public final Editor edit(String key) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        return edit$default(this, key, 0L, 2, null);
    }

    /* JADX WARN: Type inference failed for: r5v6, types: [okhttp3.internal.cache.DiskLruCache$cleanupTask$1] */
    public DiskLruCache(FileSystem fileSystem, Path directory, int i, int i2, long j, TaskRunner taskRunner) {
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        this.directory = directory;
        this.appVersion = i;
        this.valueCount = i2;
        this.fileSystem = new ForwardingFileSystem(fileSystem) { // from class: okhttp3.internal.cache.DiskLruCache$fileSystem$1
            @Override // okio.ForwardingFileSystem, okio.FileSystem
            public Sink sink(Path file, boolean z) {
                Intrinsics.checkNotNullParameter(file, "file");
                Path parent = file.parent();
                if (parent != null) {
                    createDirectories(parent);
                }
                return super.sink(file, z);
            }
        };
        this.maxSize = j;
        this.lruEntries = new LinkedHashMap<>(0, 0.75f, true);
        this.cleanupQueue = taskRunner.newQueue();
        this.cleanupTask = new Task(_UtilJvmKt.okHttpName + " Cache") { // from class: okhttp3.internal.cache.DiskLruCache$cleanupTask$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                boolean z;
                BufferedSink bufferedSink;
                boolean journalRebuildRequired;
                DiskLruCache diskLruCache = DiskLruCache.this;
                synchronized (diskLruCache) {
                    z = diskLruCache.initialized;
                    if (!z || diskLruCache.getClosed$okhttp()) {
                        return -1L;
                    }
                    try {
                        diskLruCache.trimToSize();
                    } catch (IOException unused) {
                        diskLruCache.mostRecentTrimFailed = true;
                    }
                    try {
                        journalRebuildRequired = diskLruCache.journalRebuildRequired();
                        if (journalRebuildRequired) {
                            diskLruCache.rebuildJournal$okhttp();
                            diskLruCache.redundantOpCount = 0;
                        }
                    } catch (IOException unused2) {
                        diskLruCache.mostRecentRebuildFailed = true;
                        bufferedSink = diskLruCache.journalWriter;
                        if (bufferedSink != null) {
                            _UtilCommonKt.closeQuietly(bufferedSink);
                        }
                        diskLruCache.journalWriter = Okio.buffer(Okio.blackhole());
                    }
                    return -1L;
                }
            }
        };
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
        this.journalFile = directory.resolve(JOURNAL_FILE);
        this.journalFileTmp = directory.resolve(JOURNAL_FILE_TEMP);
        this.journalFileBackup = directory.resolve(JOURNAL_FILE_BACKUP);
    }

    public final Path getDirectory() {
        return this.directory;
    }

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    public final FileSystem getFileSystem$okhttp() {
        return this.fileSystem;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final synchronized void setMaxSize(long j) {
        this.maxSize = j;
        if (this.initialized) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
    }

    public final LinkedHashMap<String, Entry> getLruEntries$okhttp() {
        return this.lruEntries;
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    public final void setClosed$okhttp(boolean z) {
        this.closed = z;
    }

    public final synchronized void initialize() throws IOException {
        DiskLruCache diskLruCache = this;
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(diskLruCache)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + diskLruCache);
        }
        if (this.initialized) {
            return;
        }
        if (this.fileSystem.exists(this.journalFileBackup)) {
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.delete(this.journalFileBackup);
            } else {
                this.fileSystem.atomicMove(this.journalFileBackup, this.journalFile);
            }
        }
        this.civilizedFileSystem = _UtilCommonKt.isCivilized(this.fileSystem, this.journalFileBackup);
        if (this.fileSystem.exists(this.journalFile)) {
            try {
                readJournal();
                processJournal();
                this.initialized = true;
                return;
            } catch (IOException e) {
                Platform.Companion.get().log("DiskLruCache " + this.directory + " is corrupt: " + e.getMessage() + ", removing", 5, e);
                delete();
                this.closed = false;
            }
        }
        rebuildJournal$okhttp();
        this.initialized = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x00d2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void readJournal() throws IOException {
        BufferedSource buffer = Okio.buffer(this.fileSystem.source(this.journalFile));
        try {
            BufferedSource bufferedSource = buffer;
            String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
            String readUtf8LineStrict2 = bufferedSource.readUtf8LineStrict();
            String readUtf8LineStrict3 = bufferedSource.readUtf8LineStrict();
            String readUtf8LineStrict4 = bufferedSource.readUtf8LineStrict();
            String readUtf8LineStrict5 = bufferedSource.readUtf8LineStrict();
            if (!Intrinsics.areEqual(MAGIC, readUtf8LineStrict) || !Intrinsics.areEqual(VERSION_1, readUtf8LineStrict2) || !Intrinsics.areEqual(String.valueOf(this.appVersion), readUtf8LineStrict3) || !Intrinsics.areEqual(String.valueOf(this.valueCount), readUtf8LineStrict4) || readUtf8LineStrict5.length() > 0) {
                throw new IOException("unexpected journal header: [" + readUtf8LineStrict + ", " + readUtf8LineStrict2 + ", " + readUtf8LineStrict4 + ", " + readUtf8LineStrict5 + AbstractJsonLexerKt.END_LIST);
            }
            int i = 0;
            while (true) {
                try {
                    readJournalLine(bufferedSource.readUtf8LineStrict());
                    i++;
                } catch (EOFException unused) {
                    this.redundantOpCount = i - this.lruEntries.size();
                    if (!bufferedSource.exhausted()) {
                        rebuildJournal$okhttp();
                    } else {
                        BufferedSink bufferedSink = this.journalWriter;
                        if (bufferedSink != null) {
                            _UtilCommonKt.closeQuietly(bufferedSink);
                        }
                        this.journalWriter = newJournalWriter();
                    }
                    Unit unit = Unit.INSTANCE;
                    if (buffer != null) {
                        try {
                            buffer.close();
                        } catch (Throwable th) {
                            th = th;
                            if (th == null) {
                                throw th;
                            }
                            return;
                        }
                    }
                    th = null;
                    if (th == null) {
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (Throwable th3) {
                    ExceptionsKt.addSuppressed(th, th3);
                }
            }
        }
    }

    private final BufferedSink newJournalWriter() throws FileNotFoundException {
        return Okio.buffer(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new Function1() { // from class: okhttp3.internal.cache.DiskLruCache$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit newJournalWriter$lambda$3;
                newJournalWriter$lambda$3 = DiskLruCache.newJournalWriter$lambda$3(DiskLruCache.this, (IOException) obj);
                return newJournalWriter$lambda$3;
            }
        }));
    }

    public static final Unit newJournalWriter$lambda$3(DiskLruCache diskLruCache, IOException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        DiskLruCache diskLruCache2 = diskLruCache;
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock(diskLruCache2)) {
            diskLruCache.hasJournalErrors = true;
            return Unit.INSTANCE;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + diskLruCache2);
    }

    private final void readJournalLine(String str) throws IOException {
        String substring;
        String str2 = str;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str2, ' ', 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = indexOf$default + 1;
        int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str2, ' ', i, false, 4, (Object) null);
        if (indexOf$default2 == -1) {
            substring = str.substring(i);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            String str3 = REMOVE;
            if (indexOf$default == str3.length() && StringsKt.startsWith$default(str, str3, false, 2, (Object) null)) {
                this.lruEntries.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf$default2);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        }
        Entry entry = this.lruEntries.get(substring);
        if (entry == null) {
            entry = new Entry(this, substring);
            this.lruEntries.put(substring, entry);
        }
        if (indexOf$default2 != -1) {
            String str4 = CLEAN;
            if (indexOf$default == str4.length() && StringsKt.startsWith$default(str, str4, false, 2, (Object) null)) {
                String substring2 = str.substring(indexOf$default2 + 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                List<String> split$default = StringsKt.split$default((CharSequence) substring2, new char[]{' '}, false, 0, 6, (Object) null);
                entry.setReadable$okhttp(true);
                entry.setCurrentEditor$okhttp(null);
                entry.setLengths$okhttp(split$default);
                return;
            }
        }
        if (indexOf$default2 == -1) {
            String str5 = DIRTY;
            if (indexOf$default == str5.length() && StringsKt.startsWith$default(str, str5, false, 2, (Object) null)) {
                entry.setCurrentEditor$okhttp(new Editor(this, entry));
                return;
            }
        }
        if (indexOf$default2 == -1) {
            String str6 = READ;
            if (indexOf$default == str6.length() && StringsKt.startsWith$default(str, str6, false, 2, (Object) null)) {
                return;
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private final void processJournal() throws IOException {
        _UtilCommonKt.deleteIfExists(this.fileSystem, this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            Entry entry = next;
            int i = 0;
            if (entry.getCurrentEditor$okhttp() == null) {
                int i2 = this.valueCount;
                while (i < i2) {
                    this.size += entry.getLengths$okhttp()[i];
                    i++;
                }
            } else {
                entry.setCurrentEditor$okhttp(null);
                int i3 = this.valueCount;
                while (i < i3) {
                    _UtilCommonKt.deleteIfExists(this.fileSystem, entry.getCleanFiles$okhttp().get(i));
                    _UtilCommonKt.deleteIfExists(this.fileSystem, entry.getDirtyFiles$okhttp().get(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    public final synchronized void rebuildJournal$okhttp() throws IOException {
        BufferedSink bufferedSink = this.journalWriter;
        if (bufferedSink != null) {
            bufferedSink.close();
        }
        BufferedSink buffer = Okio.buffer(this.fileSystem.sink(this.journalFileTmp, false));
        BufferedSink bufferedSink2 = buffer;
        bufferedSink2.writeUtf8(MAGIC).writeByte(10);
        bufferedSink2.writeUtf8(VERSION_1).writeByte(10);
        bufferedSink2.writeDecimalLong(this.appVersion).writeByte(10);
        bufferedSink2.writeDecimalLong(this.valueCount).writeByte(10);
        bufferedSink2.writeByte(10);
        for (Entry entry : this.lruEntries.values()) {
            Intrinsics.checkNotNullExpressionValue(entry, "next(...)");
            Entry entry2 = entry;
            if (entry2.getCurrentEditor$okhttp() != null) {
                bufferedSink2.writeUtf8(DIRTY).writeByte(32);
                bufferedSink2.writeUtf8(entry2.getKey$okhttp());
                bufferedSink2.writeByte(10);
            } else {
                bufferedSink2.writeUtf8(CLEAN).writeByte(32);
                bufferedSink2.writeUtf8(entry2.getKey$okhttp());
                entry2.writeLengths$okhttp(bufferedSink2);
                bufferedSink2.writeByte(10);
            }
        }
        Unit unit = Unit.INSTANCE;
        if (buffer != null) {
            try {
                buffer.close();
            } catch (Throwable th) {
                th = th;
            }
        }
        th = null;
        if (th == null) {
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.atomicMove(this.journalFile, this.journalFileBackup);
                this.fileSystem.atomicMove(this.journalFileTmp, this.journalFile);
                _UtilCommonKt.deleteIfExists(this.fileSystem, this.journalFileBackup);
            } else {
                this.fileSystem.atomicMove(this.journalFileTmp, this.journalFile);
            }
            BufferedSink bufferedSink3 = this.journalWriter;
            if (bufferedSink3 != null) {
                _UtilCommonKt.closeQuietly(bufferedSink3);
            }
            this.journalWriter = newJournalWriter();
            this.hasJournalErrors = false;
            this.mostRecentRebuildFailed = false;
        } else {
            throw th;
        }
    }

    public final synchronized Snapshot get(String key) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (entry == null) {
            return null;
        }
        Snapshot snapshot$okhttp = entry.snapshot$okhttp();
        if (snapshot$okhttp == null) {
            return null;
        }
        this.redundantOpCount++;
        BufferedSink bufferedSink = this.journalWriter;
        Intrinsics.checkNotNull(bufferedSink);
        bufferedSink.writeUtf8(READ).writeByte(32).writeUtf8(key).writeByte(10);
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
        return snapshot$okhttp;
    }

    public static /* synthetic */ Editor edit$default(DiskLruCache diskLruCache, String str, long j, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = ANY_SEQUENCE_NUMBER;
        }
        return diskLruCache.edit(str, j);
    }

    public final synchronized Editor edit(String key, long j) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (j == ANY_SEQUENCE_NUMBER || (entry != null && entry.getSequenceNumber$okhttp() == j)) {
            if ((entry != null ? entry.getCurrentEditor$okhttp() : null) != null) {
                return null;
            }
            if (entry == null || entry.getLockingSourceCount$okhttp() == 0) {
                if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
                    BufferedSink bufferedSink = this.journalWriter;
                    Intrinsics.checkNotNull(bufferedSink);
                    bufferedSink.writeUtf8(DIRTY).writeByte(32).writeUtf8(key).writeByte(10);
                    bufferedSink.flush();
                    if (this.hasJournalErrors) {
                        return null;
                    }
                    if (entry == null) {
                        entry = new Entry(this, key);
                        this.lruEntries.put(key, entry);
                    }
                    Editor editor = new Editor(this, entry);
                    entry.setCurrentEditor$okhttp(editor);
                    return editor;
                }
                TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
                return null;
            }
            return null;
        }
        return null;
    }

    public final synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    public final synchronized void completeEdit$okhttp(Editor editor, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(editor, "editor");
        Entry entry$okhttp = editor.getEntry$okhttp();
        if (!Intrinsics.areEqual(entry$okhttp.getCurrentEditor$okhttp(), editor)) {
            throw new IllegalStateException("Check failed.");
        }
        if (z && !entry$okhttp.getReadable$okhttp()) {
            int i = this.valueCount;
            for (int i2 = 0; i2 < i; i2++) {
                boolean[] written$okhttp = editor.getWritten$okhttp();
                Intrinsics.checkNotNull(written$okhttp);
                if (!written$okhttp[i2]) {
                    editor.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                } else if (!this.fileSystem.exists(entry$okhttp.getDirtyFiles$okhttp().get(i2))) {
                    editor.abort();
                    return;
                }
            }
        }
        int i3 = this.valueCount;
        for (int i4 = 0; i4 < i3; i4++) {
            Path path = entry$okhttp.getDirtyFiles$okhttp().get(i4);
            if (z && !entry$okhttp.getZombie$okhttp()) {
                if (this.fileSystem.exists(path)) {
                    Path path2 = entry$okhttp.getCleanFiles$okhttp().get(i4);
                    this.fileSystem.atomicMove(path, path2);
                    long j = entry$okhttp.getLengths$okhttp()[i4];
                    Long size = this.fileSystem.metadata(path2).getSize();
                    long longValue = size != null ? size.longValue() : 0L;
                    entry$okhttp.getLengths$okhttp()[i4] = longValue;
                    this.size = (this.size - j) + longValue;
                }
            } else {
                _UtilCommonKt.deleteIfExists(this.fileSystem, path);
            }
        }
        entry$okhttp.setCurrentEditor$okhttp(null);
        if (entry$okhttp.getZombie$okhttp()) {
            removeEntry$okhttp(entry$okhttp);
            return;
        }
        this.redundantOpCount++;
        BufferedSink bufferedSink = this.journalWriter;
        Intrinsics.checkNotNull(bufferedSink);
        if (!entry$okhttp.getReadable$okhttp() && !z) {
            this.lruEntries.remove(entry$okhttp.getKey$okhttp());
            bufferedSink.writeUtf8(REMOVE).writeByte(32);
            bufferedSink.writeUtf8(entry$okhttp.getKey$okhttp());
            bufferedSink.writeByte(10);
            bufferedSink.flush();
            if (this.size <= this.maxSize || journalRebuildRequired()) {
                TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            }
        }
        entry$okhttp.setReadable$okhttp(true);
        bufferedSink.writeUtf8(CLEAN).writeByte(32);
        bufferedSink.writeUtf8(entry$okhttp.getKey$okhttp());
        entry$okhttp.writeLengths$okhttp(bufferedSink);
        bufferedSink.writeByte(10);
        if (z) {
            long j2 = this.nextSequenceNumber;
            this.nextSequenceNumber = 1 + j2;
            entry$okhttp.setSequenceNumber$okhttp(j2);
        }
        bufferedSink.flush();
        if (this.size <= this.maxSize) {
        }
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
    }

    public final boolean journalRebuildRequired() {
        int i = this.redundantOpCount;
        return i >= 2000 && i >= this.lruEntries.size();
    }

    public final synchronized boolean remove(String key) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (entry == null) {
            return false;
        }
        boolean removeEntry$okhttp = removeEntry$okhttp(entry);
        if (removeEntry$okhttp && this.size <= this.maxSize) {
            this.mostRecentTrimFailed = false;
        }
        return removeEntry$okhttp;
    }

    public final boolean removeEntry$okhttp(Entry entry) throws IOException {
        BufferedSink bufferedSink;
        Intrinsics.checkNotNullParameter(entry, "entry");
        if (!this.civilizedFileSystem) {
            if (entry.getLockingSourceCount$okhttp() > 0 && (bufferedSink = this.journalWriter) != null) {
                bufferedSink.writeUtf8(DIRTY);
                bufferedSink.writeByte(32);
                bufferedSink.writeUtf8(entry.getKey$okhttp());
                bufferedSink.writeByte(10);
                bufferedSink.flush();
            }
            if (entry.getLockingSourceCount$okhttp() > 0 || entry.getCurrentEditor$okhttp() != null) {
                entry.setZombie$okhttp(true);
                return true;
            }
        }
        Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
        if (currentEditor$okhttp != null) {
            currentEditor$okhttp.detach$okhttp();
        }
        int i = this.valueCount;
        for (int i2 = 0; i2 < i; i2++) {
            _UtilCommonKt.deleteIfExists(this.fileSystem, entry.getCleanFiles$okhttp().get(i2));
            this.size -= entry.getLengths$okhttp()[i2];
            entry.getLengths$okhttp()[i2] = 0;
        }
        this.redundantOpCount++;
        BufferedSink bufferedSink2 = this.journalWriter;
        if (bufferedSink2 != null) {
            bufferedSink2.writeUtf8(REMOVE);
            bufferedSink2.writeByte(32);
            bufferedSink2.writeUtf8(entry.getKey$okhttp());
            bufferedSink2.writeByte(10);
        }
        this.lruEntries.remove(entry.getKey$okhttp());
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
        return true;
    }

    private final synchronized void checkNotClosed() {
        if (this.closed) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            BufferedSink bufferedSink = this.journalWriter;
            Intrinsics.checkNotNull(bufferedSink);
            bufferedSink.flush();
        }
    }

    public final synchronized boolean isClosed() {
        return this.closed;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Entry[] entryArr;
        Editor currentEditor$okhttp;
        if (this.initialized && !this.closed) {
            Collection<Entry> values = this.lruEntries.values();
            Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
            for (Entry entry : (Entry[]) values.toArray(new Entry[0])) {
                Intrinsics.checkNotNull(entry);
                if (entry.getCurrentEditor$okhttp() != null && (currentEditor$okhttp = entry.getCurrentEditor$okhttp()) != null) {
                    currentEditor$okhttp.detach$okhttp();
                }
            }
            trimToSize();
            BufferedSink bufferedSink = this.journalWriter;
            if (bufferedSink != null) {
                _UtilCommonKt.closeQuietly(bufferedSink);
            }
            this.journalWriter = null;
            this.closed = true;
            return;
        }
        this.closed = true;
    }

    public final void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            if (!removeOldestEntry()) {
                return;
            }
        }
        this.mostRecentTrimFailed = false;
    }

    private final boolean removeOldestEntry() {
        for (Entry entry : this.lruEntries.values()) {
            Intrinsics.checkNotNullExpressionValue(entry, "next(...)");
            Entry entry2 = entry;
            if (!entry2.getZombie$okhttp()) {
                removeEntry$okhttp(entry2);
                return true;
            }
        }
        return false;
    }

    public final void delete() throws IOException {
        close();
        _UtilCommonKt.deleteContents(this.fileSystem, this.directory);
    }

    public final synchronized void evictAll() throws IOException {
        Entry[] entryArr;
        initialize();
        Collection<Entry> values = this.lruEntries.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        for (Entry entry : (Entry[]) values.toArray(new Entry[0])) {
            Intrinsics.checkNotNull(entry);
            removeEntry$okhttp(entry);
        }
        this.mostRecentTrimFailed = false;
    }

    private final void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.matches(str)) {
            throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
        }
    }

    public final synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new DiskLruCache$snapshots$1(this);
    }

    /* compiled from: DiskLruCache.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B/\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0002\u001a\u00020\u0003J\f\u0010\r\u001a\b\u0018\u00010\u000eR\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Ljava/io/Closeable;", "key", "", "sequenceNumber", "", "sources", "", "Lokio/Source;", "lengths", "", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;JLjava/util/List;[J)V", "edit", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "getSource", FirebaseAnalytics.Param.INDEX, "", "getLength", "close", "", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final List<Source> sources;
        final /* synthetic */ DiskLruCache this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public Snapshot(DiskLruCache diskLruCache, String key, long j, List<? extends Source> sources, long[] lengths) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(sources, "sources");
            Intrinsics.checkNotNullParameter(lengths, "lengths");
            this.this$0 = diskLruCache;
            this.key = key;
            this.sequenceNumber = j;
            this.sources = sources;
            this.lengths = lengths;
        }

        public final String key() {
            return this.key;
        }

        public final Editor edit() throws IOException {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        public final Source getSource(int i) {
            return this.sources.get(i);
        }

        public final long getLength(int i) {
            return this.lengths[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (Source source : this.sources) {
                _UtilCommonKt.closeQuietly(source);
            }
        }
    }

    /* compiled from: DiskLruCache.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0011J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0010J\u0006\u0010\u0019\u001a\u00020\u0010R\u0018\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Editor;", "", "entry", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "Lokhttp3/internal/cache/DiskLruCache;", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Lokhttp3/internal/cache/DiskLruCache$Entry;)V", "getEntry$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Entry;", "written", "", "getWritten$okhttp", "()[Z", "done", "", "detach", "", "detach$okhttp", "newSource", "Lokio/Source;", FirebaseAnalytics.Param.INDEX, "", "newSink", "Lokio/Sink;", "commit", "abort", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class Editor {
        private boolean done;
        private final Entry entry;
        final /* synthetic */ DiskLruCache this$0;
        private final boolean[] written;

        public Editor(DiskLruCache diskLruCache, Entry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            this.this$0 = diskLruCache;
            this.entry = entry;
            this.written = entry.getReadable$okhttp() ? null : new boolean[diskLruCache.getValueCount$okhttp()];
        }

        public final Entry getEntry$okhttp() {
            return this.entry;
        }

        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        public final void detach$okhttp() {
            if (Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this)) {
                if (this.this$0.civilizedFileSystem) {
                    this.this$0.completeEdit$okhttp(this, false);
                } else {
                    this.entry.setZombie$okhttp(true);
                }
            }
        }

        public final Source newSource(int i) {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                if (this.done) {
                    throw new IllegalStateException("Check failed.");
                }
                Source source = null;
                if (this.entry.getReadable$okhttp() && Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this) && !this.entry.getZombie$okhttp()) {
                    try {
                        source = diskLruCache.getFileSystem$okhttp().source(this.entry.getCleanFiles$okhttp().get(i));
                    } catch (FileNotFoundException unused) {
                    }
                    return source;
                }
                return null;
            }
        }

        public final Sink newSink(int i) {
            final DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                if (this.done) {
                    throw new IllegalStateException("Check failed.");
                }
                if (!Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this)) {
                    return Okio.blackhole();
                }
                if (!this.entry.getReadable$okhttp()) {
                    boolean[] zArr = this.written;
                    Intrinsics.checkNotNull(zArr);
                    zArr[i] = true;
                }
                try {
                    return new FaultHidingSink(diskLruCache.getFileSystem$okhttp().sink(this.entry.getDirtyFiles$okhttp().get(i)), new Function1() { // from class: okhttp3.internal.cache.DiskLruCache$Editor$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit newSink$lambda$3$lambda$2;
                            newSink$lambda$3$lambda$2 = DiskLruCache.Editor.newSink$lambda$3$lambda$2(DiskLruCache.this, this, (IOException) obj);
                            return newSink$lambda$3$lambda$2;
                        }
                    });
                } catch (FileNotFoundException unused) {
                    return Okio.blackhole();
                }
            }
        }

        public static final Unit newSink$lambda$3$lambda$2(DiskLruCache diskLruCache, Editor editor, IOException it) {
            Intrinsics.checkNotNullParameter(it, "it");
            synchronized (diskLruCache) {
                editor.detach$okhttp();
                Unit unit = Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }

        public final void commit() throws IOException {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                if (this.done) {
                    throw new IllegalStateException("Check failed.");
                }
                if (Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this)) {
                    diskLruCache.completeEdit$okhttp(this, true);
                }
                this.done = true;
                Unit unit = Unit.INSTANCE;
            }
        }

        public final void abort() throws IOException {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                if (this.done) {
                    throw new IllegalStateException("Check failed.");
                }
                if (Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this)) {
                    diskLruCache.completeEdit$okhttp(this, false);
                }
                this.done = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* compiled from: DiskLruCache.kt */
    @Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010/\u001a\u0002002\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000302H\u0000¢\u0006\u0002\b3J\u0015\u00104\u001a\u0002002\u0006\u00105\u001a\u000206H\u0000¢\u0006\u0002\b7J\u0016\u00108\u001a\u0002092\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000302H\u0002J\u0013\u0010:\u001a\b\u0018\u00010;R\u00020\u001eH\u0000¢\u0006\u0002\b<J\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020$H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R \u0010\u001c\u001a\b\u0018\u00010\u001dR\u00020\u001eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006@"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Entry;", "", "key", "", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;)V", "getKey$okhttp", "()Ljava/lang/String;", "lengths", "", "getLengths$okhttp", "()[J", "cleanFiles", "", "Lokio/Path;", "getCleanFiles$okhttp", "()Ljava/util/List;", "dirtyFiles", "getDirtyFiles$okhttp", "readable", "", "getReadable$okhttp", "()Z", "setReadable$okhttp", "(Z)V", "zombie", "getZombie$okhttp", "setZombie$okhttp", "currentEditor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "getCurrentEditor$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Editor;", "setCurrentEditor$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "lockingSourceCount", "", "getLockingSourceCount$okhttp", "()I", "setLockingSourceCount$okhttp", "(I)V", "sequenceNumber", "", "getSequenceNumber$okhttp", "()J", "setSequenceNumber$okhttp", "(J)V", "setLengths", "", "strings", "", "setLengths$okhttp", "writeLengths", "writer", "Lokio/BufferedSink;", "writeLengths$okhttp", "invalidLengths", "", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "snapshot$okhttp", "newSource", "Lokio/Source;", FirebaseAnalytics.Param.INDEX, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class Entry {
        private final List<Path> cleanFiles;
        private Editor currentEditor;
        private final List<Path> dirtyFiles;
        private final String key;
        private final long[] lengths;
        private int lockingSourceCount;
        private boolean readable;
        private long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;
        private boolean zombie;

        public Entry(DiskLruCache diskLruCache, String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.this$0 = diskLruCache;
            this.key = key;
            this.lengths = new long[diskLruCache.getValueCount$okhttp()];
            this.cleanFiles = new ArrayList();
            this.dirtyFiles = new ArrayList();
            StringBuilder append = new StringBuilder(key).append('.');
            int length = append.length();
            int valueCount$okhttp = diskLruCache.getValueCount$okhttp();
            for (int i = 0; i < valueCount$okhttp; i++) {
                append.append(i);
                Path directory = this.this$0.getDirectory();
                String sb = append.toString();
                Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
                this.cleanFiles.add(directory.resolve(sb));
                append.append(".tmp");
                Path directory2 = this.this$0.getDirectory();
                String sb2 = append.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                this.dirtyFiles.add(directory2.resolve(sb2));
                append.setLength(length);
            }
        }

        public final String getKey$okhttp() {
            return this.key;
        }

        public final long[] getLengths$okhttp() {
            return this.lengths;
        }

        public final List<Path> getCleanFiles$okhttp() {
            return this.cleanFiles;
        }

        public final List<Path> getDirtyFiles$okhttp() {
            return this.dirtyFiles;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final void setReadable$okhttp(boolean z) {
            this.readable = z;
        }

        public final boolean getZombie$okhttp() {
            return this.zombie;
        }

        public final void setZombie$okhttp(boolean z) {
            this.zombie = z;
        }

        public final Editor getCurrentEditor$okhttp() {
            return this.currentEditor;
        }

        public final void setCurrentEditor$okhttp(Editor editor) {
            this.currentEditor = editor;
        }

        public final int getLockingSourceCount$okhttp() {
            return this.lockingSourceCount;
        }

        public final void setLockingSourceCount$okhttp(int i) {
            this.lockingSourceCount = i;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final void setSequenceNumber$okhttp(long j) {
            this.sequenceNumber = j;
        }

        public final void setLengths$okhttp(List<String> strings) throws IOException {
            Intrinsics.checkNotNullParameter(strings, "strings");
            if (strings.size() != this.this$0.getValueCount$okhttp()) {
                invalidLengths(strings);
                throw new KotlinNothingValueException();
            }
            try {
                int size = strings.size();
                for (int i = 0; i < size; i++) {
                    this.lengths[i] = Long.parseLong(strings.get(i));
                }
            } catch (NumberFormatException unused) {
                invalidLengths(strings);
                throw new KotlinNothingValueException();
            }
        }

        public final void writeLengths$okhttp(BufferedSink writer) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            for (long j : this.lengths) {
                writer.writeByte(32).writeDecimalLong(j);
            }
        }

        private final Void invalidLengths(List<String> list) throws IOException {
            throw new IOException("unexpected journal line: " + list);
        }

        public final Snapshot snapshot$okhttp() {
            DiskLruCache diskLruCache = this.this$0;
            if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock(diskLruCache)) {
                if (this.readable) {
                    if (this.this$0.civilizedFileSystem || (this.currentEditor == null && !this.zombie)) {
                        ArrayList<Source> arrayList = new ArrayList();
                        long[] jArr = (long[]) this.lengths.clone();
                        try {
                            int valueCount$okhttp = this.this$0.getValueCount$okhttp();
                            for (int i = 0; i < valueCount$okhttp; i++) {
                                arrayList.add(newSource(i));
                            }
                            return new Snapshot(this.this$0, this.key, this.sequenceNumber, arrayList, jArr);
                        } catch (FileNotFoundException unused) {
                            for (Source source : arrayList) {
                                _UtilCommonKt.closeQuietly(source);
                            }
                            try {
                                this.this$0.removeEntry$okhttp(this);
                            } catch (IOException unused2) {
                            }
                            return null;
                        }
                    }
                    return null;
                }
                return null;
            }
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + diskLruCache);
        }

        private final Source newSource(int i) {
            Source source = this.this$0.getFileSystem$okhttp().source(this.cleanFiles.get(i));
            if (this.this$0.civilizedFileSystem) {
                return source;
            }
            this.lockingSourceCount++;
            final DiskLruCache diskLruCache = this.this$0;
            return new ForwardingSource(source) { // from class: okhttp3.internal.cache.DiskLruCache$Entry$newSource$1
                private boolean closed;

                @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    super.close();
                    if (this.closed) {
                        return;
                    }
                    this.closed = true;
                    DiskLruCache diskLruCache2 = diskLruCache;
                    DiskLruCache.Entry entry = this;
                    synchronized (diskLruCache2) {
                        entry.setLockingSourceCount$okhttp(entry.getLockingSourceCount$okhttp() - 1);
                        if (entry.getLockingSourceCount$okhttp() == 0 && entry.getZombie$okhttp()) {
                            diskLruCache2.removeEntry$okhttp(entry);
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
            };
        }
    }

    /* compiled from: DiskLruCache.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/cache/DiskLruCache$Companion;", "", "<init>", "()V", "JOURNAL_FILE", "", "JOURNAL_FILE_TEMP", "JOURNAL_FILE_BACKUP", "MAGIC", "VERSION_1", "ANY_SEQUENCE_NUMBER", "", "LEGAL_KEY_PATTERN", "Lkotlin/text/Regex;", "CLEAN", "DIRTY", "REMOVE", "READ", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
