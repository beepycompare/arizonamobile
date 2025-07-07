package coil3.disk;

import androidx.media3.extractor.text.ttml.TtmlNode;
import coil3.disk.DiskCache;
import coil3.disk.DiskLruCache;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.ByteString;
import okio.FileSystem;
import okio.Path;
/* compiled from: RealDiskCache.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 $2\u00020\u0001:\u0003\"#$B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\f\u0010!\u001a\u00020\u0019*\u00020\u0019H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\r¨\u0006%"}, d2 = {"Lcoil3/disk/RealDiskCache;", "Lcoil3/disk/DiskCache;", "maxSize", "", "directory", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "cleanupCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(JLokio/Path;Lokio/FileSystem;Lkotlin/coroutines/CoroutineContext;)V", "getMaxSize", "()J", "getDirectory", "()Lokio/Path;", "getFileSystem", "()Lokio/FileSystem;", "cache", "Lcoil3/disk/DiskLruCache;", "size", "getSize", "openSnapshot", "Lcoil3/disk/DiskCache$Snapshot;", "key", "", "openEditor", "Lcoil3/disk/DiskCache$Editor;", "remove", "", "clear", "", "shutdown", "hash", "RealSnapshot", "RealEditor", "Companion", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RealDiskCache implements DiskCache {
    public static final Companion Companion = new Companion(null);
    private static final int ENTRY_DATA = 1;
    private static final int ENTRY_METADATA = 0;
    private final DiskLruCache cache;
    private final Path directory;
    private final FileSystem fileSystem;
    private final long maxSize;

    public RealDiskCache(long j, Path path, FileSystem fileSystem, CoroutineContext coroutineContext) {
        this.maxSize = j;
        this.directory = path;
        this.fileSystem = fileSystem;
        this.cache = new DiskLruCache(getFileSystem(), getDirectory(), coroutineContext, getMaxSize(), 3, 2);
    }

    @Override // coil3.disk.DiskCache
    public long getMaxSize() {
        return this.maxSize;
    }

    @Override // coil3.disk.DiskCache
    public Path getDirectory() {
        return this.directory;
    }

    @Override // coil3.disk.DiskCache
    public FileSystem getFileSystem() {
        return this.fileSystem;
    }

    @Override // coil3.disk.DiskCache
    public long getSize() {
        return this.cache.size();
    }

    @Override // coil3.disk.DiskCache
    public DiskCache.Snapshot openSnapshot(String str) {
        DiskLruCache.Snapshot snapshot = this.cache.get(hash(str));
        return snapshot != null ? new RealSnapshot(snapshot) : null;
    }

    @Override // coil3.disk.DiskCache
    public DiskCache.Editor openEditor(String str) {
        DiskLruCache.Editor edit = this.cache.edit(hash(str));
        return edit != null ? new RealEditor(edit) : null;
    }

    @Override // coil3.disk.DiskCache
    public boolean remove(String str) {
        return this.cache.remove(hash(str));
    }

    @Override // coil3.disk.DiskCache
    public void clear() {
        this.cache.evictAll();
    }

    @Override // coil3.disk.DiskCache
    public void shutdown() {
        coil3.util.UtilsKt.closeQuietly(this.cache);
    }

    private final String hash(String str) {
        return ByteString.Companion.encodeUtf8(str).sha256().hex();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RealDiskCache.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0012\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n¨\u0006\u0011"}, d2 = {"Lcoil3/disk/RealDiskCache$RealSnapshot;", "Lcoil3/disk/DiskCache$Snapshot;", "snapshot", "Lcoil3/disk/DiskLruCache$Snapshot;", "Lcoil3/disk/DiskLruCache;", "<init>", "(Lcoil3/disk/DiskLruCache$Snapshot;)V", TtmlNode.TAG_METADATA, "Lokio/Path;", "getMetadata", "()Lokio/Path;", "data", "getData", "close", "", "closeAndOpenEditor", "Lcoil3/disk/RealDiskCache$RealEditor;", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class RealSnapshot implements DiskCache.Snapshot {
        private final DiskLruCache.Snapshot snapshot;

        public RealSnapshot(DiskLruCache.Snapshot snapshot) {
            this.snapshot = snapshot;
        }

        @Override // coil3.disk.DiskCache.Snapshot
        public Path getMetadata() {
            return this.snapshot.file(0);
        }

        @Override // coil3.disk.DiskCache.Snapshot
        public Path getData() {
            return this.snapshot.file(1);
        }

        @Override // coil3.disk.DiskCache.Snapshot, java.lang.AutoCloseable
        public void close() {
            this.snapshot.close();
        }

        @Override // coil3.disk.DiskCache.Snapshot
        public RealEditor closeAndOpenEditor() {
            DiskLruCache.Editor closeAndEdit = this.snapshot.closeAndEdit();
            if (closeAndEdit != null) {
                return new RealEditor(closeAndEdit);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RealDiskCache.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016R\u0012\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n¨\u0006\u0012"}, d2 = {"Lcoil3/disk/RealDiskCache$RealEditor;", "Lcoil3/disk/DiskCache$Editor;", "editor", "Lcoil3/disk/DiskLruCache$Editor;", "Lcoil3/disk/DiskLruCache;", "<init>", "(Lcoil3/disk/DiskLruCache$Editor;)V", TtmlNode.TAG_METADATA, "Lokio/Path;", "getMetadata", "()Lokio/Path;", "data", "getData", "commit", "", "commitAndOpenSnapshot", "Lcoil3/disk/RealDiskCache$RealSnapshot;", "abort", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class RealEditor implements DiskCache.Editor {
        private final DiskLruCache.Editor editor;

        public RealEditor(DiskLruCache.Editor editor) {
            this.editor = editor;
        }

        @Override // coil3.disk.DiskCache.Editor
        public Path getMetadata() {
            return this.editor.file(0);
        }

        @Override // coil3.disk.DiskCache.Editor
        public Path getData() {
            return this.editor.file(1);
        }

        @Override // coil3.disk.DiskCache.Editor
        public void commit() {
            this.editor.commit();
        }

        @Override // coil3.disk.DiskCache.Editor
        public RealSnapshot commitAndOpenSnapshot() {
            DiskLruCache.Snapshot commitAndGet = this.editor.commitAndGet();
            if (commitAndGet != null) {
                return new RealSnapshot(commitAndGet);
            }
            return null;
        }

        @Override // coil3.disk.DiskCache.Editor
        public void abort() {
            this.editor.abort();
        }
    }

    /* compiled from: RealDiskCache.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcoil3/disk/RealDiskCache$Companion;", "", "<init>", "()V", "ENTRY_METADATA", "", "ENTRY_DATA", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
