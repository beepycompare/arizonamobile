package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
/* compiled from: ForwardingFileSystem.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00152\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J \u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\u0018\u0010\"\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\u0018\u0010#\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\u0018\u0010%\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0016J\u0018\u0010'\u001a\u00020$2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\u0018\u0010(\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0016J\b\u0010)\u001a\u00020$H\u0016J\b\u0010*\u001a\u00020\nH\u0016R\u0013\u0010\u0002\u001a\u00020\u00018G¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006+"}, d2 = {"Lokio/ForwardingFileSystem;", "Lokio/FileSystem;", "delegate", "<init>", "(Lokio/FileSystem;)V", "()Lokio/FileSystem;", "onPathParameter", "Lokio/Path;", "path", "functionName", "", "parameterName", "onPathResult", "canonicalize", "metadataOrNull", "Lokio/FileMetadata;", "list", "", "dir", "listOrNull", "listRecursively", "Lkotlin/sequences/Sequence;", "followSymlinks", "", "openReadOnly", "Lokio/FileHandle;", "file", "openReadWrite", "mustCreate", "mustExist", "source", "Lokio/Source;", "sink", "Lokio/Sink;", "appendingSink", "createDirectory", "", "atomicMove", TypedValues.AttributesType.S_TARGET, "delete", "createSymlink", "close", "toString", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ForwardingFileSystem extends FileSystem {
    private final FileSystem delegate;

    public Path onPathParameter(Path path, String functionName, String parameterName) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        Intrinsics.checkNotNullParameter(parameterName, "parameterName");
        return path;
    }

    public Path onPathResult(Path path, String functionName) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        return path;
    }

    public final FileSystem delegate() {
        return this.delegate;
    }

    public ForwardingFileSystem(FileSystem delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // okio.FileSystem
    public Path canonicalize(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        return onPathResult(this.delegate.canonicalize(onPathParameter(path, "canonicalize", "path")), "canonicalize");
    }

    @Override // okio.FileSystem
    public FileMetadata metadataOrNull(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata metadataOrNull = this.delegate.metadataOrNull(onPathParameter(path, "metadataOrNull", "path"));
        if (metadataOrNull == null) {
            return null;
        }
        return metadataOrNull.getSymlinkTarget() == null ? metadataOrNull : FileMetadata.copy$default(metadataOrNull, false, false, onPathResult(metadataOrNull.getSymlinkTarget(), "metadataOrNull"), null, null, null, null, null, 251, null);
    }

    @Override // okio.FileSystem
    public List<Path> list(Path dir) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        Path onPathParameter = onPathParameter(dir, "list", "dir");
        ArrayList arrayList = new ArrayList();
        for (Path path : this.delegate.list(onPathParameter)) {
            arrayList.add(onPathResult(path, "list"));
        }
        ArrayList arrayList2 = arrayList;
        CollectionsKt.sort(arrayList2);
        return arrayList2;
    }

    @Override // okio.FileSystem
    public List<Path> listOrNull(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        List<Path> listOrNull = this.delegate.listOrNull(onPathParameter(dir, "listOrNull", "dir"));
        if (listOrNull == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Path path : listOrNull) {
            arrayList.add(onPathResult(path, "listOrNull"));
        }
        ArrayList arrayList2 = arrayList;
        CollectionsKt.sort(arrayList2);
        return arrayList2;
    }

    @Override // okio.FileSystem
    public Sequence<Path> listRecursively(Path dir, boolean z) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        return SequencesKt.map(this.delegate.listRecursively(onPathParameter(dir, "listRecursively", "dir"), z), new Function1() { // from class: okio.ForwardingFileSystem$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Path listRecursively$lambda$2;
                listRecursively$lambda$2 = ForwardingFileSystem.listRecursively$lambda$2(ForwardingFileSystem.this, (Path) obj);
                return listRecursively$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Path listRecursively$lambda$2(ForwardingFileSystem forwardingFileSystem, Path it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return forwardingFileSystem.onPathResult(it, "listRecursively");
    }

    @Override // okio.FileSystem
    public FileHandle openReadOnly(Path file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        return this.delegate.openReadOnly(onPathParameter(file, "openReadOnly", "file"));
    }

    @Override // okio.FileSystem
    public FileHandle openReadWrite(Path file, boolean z, boolean z2) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        return this.delegate.openReadWrite(onPathParameter(file, "openReadWrite", "file"), z, z2);
    }

    @Override // okio.FileSystem
    public Source source(Path file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        return this.delegate.source(onPathParameter(file, "source", "file"));
    }

    @Override // okio.FileSystem
    public Sink sink(Path file, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        return this.delegate.sink(onPathParameter(file, "sink", "file"), z);
    }

    @Override // okio.FileSystem
    public Sink appendingSink(Path file, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        return this.delegate.appendingSink(onPathParameter(file, "appendingSink", "file"), z);
    }

    @Override // okio.FileSystem
    public void createDirectory(Path dir, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        this.delegate.createDirectory(onPathParameter(dir, "createDirectory", "dir"), z);
    }

    @Override // okio.FileSystem
    public void atomicMove(Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        this.delegate.atomicMove(onPathParameter(source, "atomicMove", "source"), onPathParameter(target, "atomicMove", TypedValues.AttributesType.S_TARGET));
    }

    @Override // okio.FileSystem
    public void delete(Path path, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        this.delegate.delete(onPathParameter(path, "delete", "path"), z);
    }

    @Override // okio.FileSystem
    public void createSymlink(Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        this.delegate.createSymlink(onPathParameter(source, "createSymlink", "source"), onPathParameter(target, "createSymlink", TypedValues.AttributesType.S_TARGET));
    }

    @Override // okio.FileSystem, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public String toString() {
        return Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + '(' + this.delegate + ')';
    }
}
