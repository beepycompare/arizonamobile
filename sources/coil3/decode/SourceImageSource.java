package coil3.decode;

import androidx.media3.extractor.text.ttml.TtmlNode;
import coil3.decode.ImageSource;
import coil3.util.FileSystemsKt;
import coil3.util.UtilsKt;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
/* compiled from: ImageSource.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcoil3/decode/SourceImageSource;", "Lcoil3/decode/ImageSource;", "source", "Lokio/BufferedSource;", "fileSystem", "Lokio/FileSystem;", TtmlNode.TAG_METADATA, "Lcoil3/decode/ImageSource$Metadata;", "<init>", "(Lokio/BufferedSource;Lokio/FileSystem;Lcoil3/decode/ImageSource$Metadata;)V", "getFileSystem", "()Lokio/FileSystem;", "getMetadata", "()Lcoil3/decode/ImageSource$Metadata;", "lock", "", "Lkotlinx/atomicfu/locks/SynchronizedObject;", "isClosed", "", "file", "Lokio/Path;", "sourceOrNull", "fileOrNull", "close", "", "assertNotClosed", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SourceImageSource implements ImageSource {
    private Path file;
    private final FileSystem fileSystem;
    private boolean isClosed;
    private final Object lock = new Object();
    private final ImageSource.Metadata metadata;
    private BufferedSource source;

    public SourceImageSource(BufferedSource bufferedSource, FileSystem fileSystem, ImageSource.Metadata metadata) {
        this.fileSystem = fileSystem;
        this.metadata = metadata;
        this.source = bufferedSource;
    }

    @Override // coil3.decode.ImageSource
    public FileSystem getFileSystem() {
        return this.fileSystem;
    }

    @Override // coil3.decode.ImageSource
    public ImageSource.Metadata getMetadata() {
        return this.metadata;
    }

    @Override // coil3.decode.ImageSource
    public BufferedSource source() {
        synchronized (this.lock) {
            assertNotClosed();
            BufferedSource bufferedSource = this.source;
            if (bufferedSource != null) {
                return bufferedSource;
            }
            FileSystem fileSystem = getFileSystem();
            Path path = this.file;
            Intrinsics.checkNotNull(path);
            BufferedSource buffer = Okio.buffer(fileSystem.source(path));
            this.source = buffer;
            return buffer;
        }
    }

    @Override // coil3.decode.ImageSource
    public BufferedSource sourceOrNull() {
        return source();
    }

    @Override // coil3.decode.ImageSource
    public Path file() {
        synchronized (this.lock) {
            assertNotClosed();
            Path path = this.file;
            if (path != null) {
                return path;
            }
            Path createTempFile = FileSystemsKt.createTempFile(getFileSystem());
            BufferedSink buffer = Okio.buffer(getFileSystem().sink(createTempFile, false));
            BufferedSource bufferedSource = this.source;
            Intrinsics.checkNotNull(bufferedSource);
            Long.valueOf(buffer.writeAll(bufferedSource));
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (Throwable th) {
                    th = th;
                }
            }
            th = null;
            if (th == null) {
                this.source = null;
                this.file = createTempFile;
                return createTempFile;
            }
            throw th;
        }
    }

    @Override // coil3.decode.ImageSource
    public Path fileOrNull() {
        Path path;
        synchronized (this.lock) {
            assertNotClosed();
            path = this.file;
        }
        return path;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            this.isClosed = true;
            BufferedSource bufferedSource = this.source;
            if (bufferedSource != null) {
                UtilsKt.closeQuietly((Closeable) bufferedSource);
            }
            Path path = this.file;
            if (path != null) {
                getFileSystem().delete(path);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void assertNotClosed() {
        if (this.isClosed) {
            throw new IllegalStateException("closed".toString());
        }
    }
}
