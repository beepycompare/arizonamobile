package okhttp3.internal.publicsuffix;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.FileSystem;
import okio.Path;
import okio.Source;
/* compiled from: ResourcePublicSuffixList.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/publicsuffix/ResourcePublicSuffixList;", "Lokhttp3/internal/publicsuffix/BasePublicSuffixList;", "path", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "<init>", "(Lokio/Path;Lokio/FileSystem;)V", "getPath", "()Lokio/Path;", "getFileSystem", "()Lokio/FileSystem;", "listSource", "Lokio/Source;", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ResourcePublicSuffixList extends BasePublicSuffixList {
    public static final Companion Companion = new Companion(null);
    public static final Path PUBLIC_SUFFIX_RESOURCE = Path.Companion.get$default(Path.Companion, "okhttp3/internal/publicsuffix/PublicSuffixDatabase.list", false, 1, (Object) null);
    private final FileSystem fileSystem;
    private final Path path;

    public ResourcePublicSuffixList() {
        this(null, null, 3, null);
    }

    public /* synthetic */ ResourcePublicSuffixList(Path path, FileSystem fileSystem, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? PUBLIC_SUFFIX_RESOURCE : path, (i & 2) != 0 ? FileSystem.RESOURCES : fileSystem);
    }

    @Override // okhttp3.internal.publicsuffix.BasePublicSuffixList
    public Path getPath() {
        return this.path;
    }

    public final FileSystem getFileSystem() {
        return this.fileSystem;
    }

    public ResourcePublicSuffixList(Path path, FileSystem fileSystem) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        this.path = path;
        this.fileSystem = fileSystem;
    }

    @Override // okhttp3.internal.publicsuffix.BasePublicSuffixList
    public Source listSource() {
        return this.fileSystem.source(getPath());
    }

    /* compiled from: ResourcePublicSuffixList.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lokhttp3/internal/publicsuffix/ResourcePublicSuffixList$Companion;", "", "<init>", "()V", "PUBLIC_SUFFIX_RESOURCE", "Lokio/Path;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
