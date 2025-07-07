package coil3.disk;

import androidx.media3.extractor.text.ttml.TtmlNode;
import coil3.util.FileSystems_androidKt;
import coil3.util.FileSystems_nonJsCommonKt;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import okio.FileSystem;
import okio.Path;
/* compiled from: DiskCache.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0003\u001b\u001c\u001dJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u0019H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001eÀ\u0006\u0001"}, d2 = {"Lcoil3/disk/DiskCache;", "", "size", "", "getSize", "()J", "maxSize", "getMaxSize", "directory", "Lokio/Path;", "getDirectory", "()Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "openSnapshot", "Lcoil3/disk/DiskCache$Snapshot;", "key", "", "openEditor", "Lcoil3/disk/DiskCache$Editor;", "remove", "", "clear", "", "shutdown", "Snapshot", "Editor", "Builder", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface DiskCache {

    /* compiled from: DiskCache.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\f\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lcoil3/disk/DiskCache$Editor;", "", TtmlNode.TAG_METADATA, "Lokio/Path;", "getMetadata", "()Lokio/Path;", "data", "getData", "commit", "", "commitAndOpenSnapshot", "Lcoil3/disk/DiskCache$Snapshot;", "abort", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface Editor {
        void abort();

        void commit();

        Snapshot commitAndOpenSnapshot();

        Path getData();

        Path getMetadata();
    }

    /* compiled from: DiskCache.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J\b\u0010\t\u001a\u00020\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lcoil3/disk/DiskCache$Snapshot;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", TtmlNode.TAG_METADATA, "Lokio/Path;", "getMetadata", "()Lokio/Path;", "data", "getData", "close", "", "closeAndOpenEditor", "Lcoil3/disk/DiskCache$Editor;", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface Snapshot extends AutoCloseable {
        @Override // java.lang.AutoCloseable
        void close();

        Editor closeAndOpenEditor();

        Path getData();

        Path getMetadata();
    }

    void clear();

    Path getDirectory();

    FileSystem getFileSystem();

    long getMaxSize();

    long getSize();

    Editor openEditor(String str);

    Snapshot openSnapshot(String str);

    boolean remove(String str);

    void shutdown();

    /* compiled from: DiskCache.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0006\u0010\u0016\u001a\u00020\u0017R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcoil3/disk/DiskCache$Builder;", "", "<init>", "()V", "directory", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "maxSizePercent", "", "minimumMaxSizeBytes", "", "maximumMaxSizeBytes", "maxSizeBytes", "cleanupCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "percent", "size", "context", "cleanupDispatcher", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "build", "Lcoil3/disk/DiskCache;", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Builder {
        private Path directory;
        private long maxSizeBytes;
        private FileSystem fileSystem = FileSystems_nonJsCommonKt.defaultFileSystem();
        private double maxSizePercent = 0.02d;
        private long minimumMaxSizeBytes = 10485760;
        private long maximumMaxSizeBytes = 262144000;
        private CoroutineContext cleanupCoroutineContext = EmptyCoroutineContext.INSTANCE;

        public final Builder directory(Path path) {
            this.directory = path;
            return this;
        }

        public final Builder fileSystem(FileSystem fileSystem) {
            this.fileSystem = fileSystem;
            return this;
        }

        public final Builder maxSizePercent(double d) {
            if (FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE > d || d > 1.0d) {
                throw new IllegalArgumentException("percent must be in the range [0.0, 1.0].".toString());
            }
            this.maxSizeBytes = 0L;
            this.maxSizePercent = d;
            return this;
        }

        public final Builder minimumMaxSizeBytes(long j) {
            if (j <= 0) {
                throw new IllegalArgumentException("size must be > 0.".toString());
            }
            this.minimumMaxSizeBytes = j;
            return this;
        }

        public final Builder maximumMaxSizeBytes(long j) {
            if (j <= 0) {
                throw new IllegalArgumentException("size must be > 0.".toString());
            }
            this.maximumMaxSizeBytes = j;
            return this;
        }

        public final Builder maxSizeBytes(long j) {
            if (j <= 0) {
                throw new IllegalArgumentException("size must be > 0.".toString());
            }
            this.maxSizePercent = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            this.maxSizeBytes = j;
            return this;
        }

        public final Builder cleanupCoroutineContext(CoroutineContext coroutineContext) {
            this.cleanupCoroutineContext = coroutineContext;
            return this;
        }

        @Deprecated(message = "Replaced by cleanupCoroutineContext.", replaceWith = @ReplaceWith(expression = "cleanupCoroutineContext(dispatcher)", imports = {}))
        public final Builder cleanupDispatcher(CoroutineDispatcher coroutineDispatcher) {
            return cleanupCoroutineContext(coroutineDispatcher);
        }

        public final DiskCache build() {
            long j;
            Path path = this.directory;
            if (path == null) {
                throw new IllegalStateException("directory == null".toString());
            }
            double d = this.maxSizePercent;
            if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                try {
                    j = RangesKt.coerceIn((long) (d * FileSystems_androidKt.remainingFreeSpaceBytes(this.fileSystem, path)), this.minimumMaxSizeBytes, this.maximumMaxSizeBytes);
                } catch (Exception unused) {
                    j = this.minimumMaxSizeBytes;
                }
            } else {
                j = this.maxSizeBytes;
            }
            return new RealDiskCache(j, path, this.fileSystem, this.cleanupCoroutineContext);
        }
    }
}
