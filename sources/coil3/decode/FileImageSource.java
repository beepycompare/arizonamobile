package coil3.decode;

import androidx.media3.extractor.text.ttml.TtmlNode;
import coil3.decode.ImageSource;
import coil3.util.UtilsKt;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Unit;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
/* compiled from: ImageSource.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcoil3/decode/FileImageSource;", "Lcoil3/decode/ImageSource;", "file", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "diskCacheKey", "", "closeable", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", TtmlNode.TAG_METADATA, "Lcoil3/decode/ImageSource$Metadata;", "<init>", "(Lokio/Path;Lokio/FileSystem;Ljava/lang/String;Ljava/lang/AutoCloseable;Lcoil3/decode/ImageSource$Metadata;)V", "getFile$coil_core_release", "()Lokio/Path;", "getFileSystem", "()Lokio/FileSystem;", "getDiskCacheKey$coil_core_release", "()Ljava/lang/String;", "getMetadata", "()Lcoil3/decode/ImageSource$Metadata;", "lock", "", "Lkotlinx/atomicfu/locks/SynchronizedObject;", "isClosed", "", "source", "Lokio/BufferedSource;", "sourceOrNull", "fileOrNull", "close", "", "assertNotClosed", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileImageSource implements ImageSource {
    private final AutoCloseable closeable;
    private final String diskCacheKey;
    private final Path file;
    private final FileSystem fileSystem;
    private boolean isClosed;
    private final Object lock = new Object();
    private final ImageSource.Metadata metadata;
    private BufferedSource source;

    public FileImageSource(Path path, FileSystem fileSystem, String str, AutoCloseable autoCloseable, ImageSource.Metadata metadata) {
        this.file = path;
        this.fileSystem = fileSystem;
        this.diskCacheKey = str;
        this.closeable = autoCloseable;
        this.metadata = metadata;
    }

    public final Path getFile$coil_core_release() {
        return this.file;
    }

    @Override // coil3.decode.ImageSource
    public FileSystem getFileSystem() {
        return this.fileSystem;
    }

    public final String getDiskCacheKey$coil_core_release() {
        return this.diskCacheKey;
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
            BufferedSource buffer = Okio.buffer(getFileSystem().source(this.file));
            this.source = buffer;
            return buffer;
        }
    }

    @Override // coil3.decode.ImageSource
    public BufferedSource sourceOrNull() {
        BufferedSource bufferedSource;
        synchronized (this.lock) {
            assertNotClosed();
            bufferedSource = this.source;
        }
        return bufferedSource;
    }

    @Override // coil3.decode.ImageSource
    public Path file() {
        Path path;
        synchronized (this.lock) {
            assertNotClosed();
            path = this.file;
        }
        return path;
    }

    @Override // coil3.decode.ImageSource
    public Path fileOrNull() {
        return file();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            this.isClosed = true;
            BufferedSource bufferedSource = this.source;
            if (bufferedSource != null) {
                UtilsKt.closeQuietly((Closeable) bufferedSource);
            }
            AutoCloseable autoCloseable = this.closeable;
            if (autoCloseable != null) {
                UtilsKt.closeQuietly(autoCloseable);
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
