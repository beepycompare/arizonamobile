package okio;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Path.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001/B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0087\u0002¢\u0006\u0002\b J\u0016\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0003H\u0087\u0002¢\u0006\u0002\b J\u0016\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0002\b J\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\u0013J\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0013J\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\u0013J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0000J\u0006\u0010$\u001a\u00020\u0000J\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020(J\u0011\u0010)\u001a\u00020*2\u0006\u0010#\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010+\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010,H\u0096\u0002J\b\u0010-\u001a\u00020*H\u0016J\b\u0010.\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\f8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00178G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00008G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\nR\u0011\u0010\u001d\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014¨\u00060"}, d2 = {"Lokio/Path;", "", "bytes", "Lokio/ByteString;", "<init>", "(Lokio/ByteString;)V", "getBytes$okio", "()Lokio/ByteString;", "root", "getRoot", "()Lokio/Path;", "segments", "", "", "getSegments", "()Ljava/util/List;", "segmentsBytes", "getSegmentsBytes", "isAbsolute", "", "()Z", "isRelative", "volumeLetter", "", "()Ljava/lang/Character;", "nameBytes", "name", "()Ljava/lang/String;", "parent", "isRoot", TtmlNode.TAG_DIV, "child", "resolve", "normalize", "relativeTo", "other", "normalized", "toFile", "Ljava/io/File;", "toNioPath", "Ljava/nio/file/Path;", "compareTo", "", "equals", "", "hashCode", "toString", "Companion", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Path implements Comparable<Path> {
    public static final Companion Companion = new Companion(null);
    public static final String DIRECTORY_SEPARATOR;
    private final ByteString bytes;

    @JvmStatic
    public static final Path get(File file) {
        return Companion.get(file);
    }

    @JvmStatic
    public static final Path get(File file, boolean z) {
        return Companion.get(file, z);
    }

    @JvmStatic
    public static final Path get(String str) {
        return Companion.get(str);
    }

    @JvmStatic
    public static final Path get(String str, boolean z) {
        return Companion.get(str, z);
    }

    @JvmStatic
    public static final Path get(java.nio.file.Path path) {
        return Companion.get(path);
    }

    @JvmStatic
    public static final Path get(java.nio.file.Path path, boolean z) {
        return Companion.get(path, z);
    }

    public Path(ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.bytes = bytes;
    }

    public final ByteString getBytes$okio() {
        return this.bytes;
    }

    public final Path resolve(Path child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return okio.internal.Path.commonResolve(this, child, false);
    }

    public static /* synthetic */ Path resolve$default(Path path, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return path.resolve(str, z);
    }

    public static /* synthetic */ Path resolve$default(Path path, ByteString byteString, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return path.resolve(byteString, z);
    }

    public static /* synthetic */ Path resolve$default(Path path, Path path2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return path.resolve(path2, z);
    }

    public final Path resolve(Path child, boolean z) {
        Intrinsics.checkNotNullParameter(child, "child");
        return okio.internal.Path.commonResolve(this, child, z);
    }

    public final File toFile() {
        return new File(toString());
    }

    public final java.nio.file.Path toNioPath() {
        java.nio.file.Path path = Paths.get(toString(), new String[0]);
        Intrinsics.checkNotNullExpressionValue(path, "get(...)");
        return path;
    }

    /* compiled from: Path.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0006\u001a\u00020\u0007*\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u001b\u0010\u000b\u001a\u00020\u0007*\u00020\f2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u001b\u0010\u000b\u001a\u00020\u0007*\u00020\r2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lokio/Path$Companion;", "", "<init>", "()V", "DIRECTORY_SEPARATOR", "", "toPath", "Lokio/Path;", "normalize", "", "get", "toOkioPath", "Ljava/io/File;", "Ljava/nio/file/Path;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Path get(File file) {
            Intrinsics.checkNotNullParameter(file, "<this>");
            return get$default(this, file, false, 1, (Object) null);
        }

        @JvmStatic
        public final Path get(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return get$default(this, str, false, 1, (Object) null);
        }

        @JvmStatic
        public final Path get(java.nio.file.Path path) {
            Intrinsics.checkNotNullParameter(path, "<this>");
            return get$default(this, path, false, 1, (Object) null);
        }

        private Companion() {
        }

        public static /* synthetic */ Path get$default(Companion companion, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.get(str, z);
        }

        @JvmStatic
        public final Path get(String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return okio.internal.Path.commonToPath(str, z);
        }

        public static /* synthetic */ Path get$default(Companion companion, File file, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.get(file, z);
        }

        @JvmStatic
        public final Path get(File file, boolean z) {
            Intrinsics.checkNotNullParameter(file, "<this>");
            String file2 = file.toString();
            Intrinsics.checkNotNullExpressionValue(file2, "toString(...)");
            return get(file2, z);
        }

        public static /* synthetic */ Path get$default(Companion companion, java.nio.file.Path path, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.get(path, z);
        }

        @JvmStatic
        public final Path get(java.nio.file.Path path, boolean z) {
            Intrinsics.checkNotNullParameter(path, "<this>");
            return get(path.toString(), z);
        }
    }

    static {
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        DIRECTORY_SEPARATOR = separator;
    }

    public final Path getRoot() {
        int rootLength = okio.internal.Path.rootLength(this);
        if (rootLength == -1) {
            return null;
        }
        return new Path(getBytes$okio().substring(0, rootLength));
    }

    public final List<String> getSegments() {
        ArrayList arrayList = new ArrayList();
        int rootLength = okio.internal.Path.rootLength(this);
        if (rootLength == -1) {
            rootLength = 0;
        } else if (rootLength < getBytes$okio().size() && getBytes$okio().getByte(rootLength) == 92) {
            rootLength++;
        }
        int size = getBytes$okio().size();
        int i = rootLength;
        while (rootLength < size) {
            if (getBytes$okio().getByte(rootLength) == 47 || getBytes$okio().getByte(rootLength) == 92) {
                arrayList.add(getBytes$okio().substring(i, rootLength));
                i = rootLength + 1;
            }
            rootLength++;
        }
        if (i < getBytes$okio().size()) {
            arrayList.add(getBytes$okio().substring(i, getBytes$okio().size()));
        }
        ArrayList<ByteString> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (ByteString byteString : arrayList2) {
            arrayList3.add(byteString.utf8());
        }
        return arrayList3;
    }

    public final List<ByteString> getSegmentsBytes() {
        ArrayList arrayList = new ArrayList();
        int rootLength = okio.internal.Path.rootLength(this);
        if (rootLength == -1) {
            rootLength = 0;
        } else if (rootLength < getBytes$okio().size() && getBytes$okio().getByte(rootLength) == 92) {
            rootLength++;
        }
        int size = getBytes$okio().size();
        int i = rootLength;
        while (rootLength < size) {
            if (getBytes$okio().getByte(rootLength) == 47 || getBytes$okio().getByte(rootLength) == 92) {
                arrayList.add(getBytes$okio().substring(i, rootLength));
                i = rootLength + 1;
            }
            rootLength++;
        }
        if (i < getBytes$okio().size()) {
            arrayList.add(getBytes$okio().substring(i, getBytes$okio().size()));
        }
        return arrayList;
    }

    public final boolean isAbsolute() {
        return okio.internal.Path.rootLength(this) != -1;
    }

    public final boolean isRelative() {
        return okio.internal.Path.rootLength(this) == -1;
    }

    public final Character volumeLetter() {
        if (ByteString.indexOf$default(getBytes$okio(), okio.internal.Path.SLASH, 0, 2, (Object) null) == -1 && getBytes$okio().size() >= 2 && getBytes$okio().getByte(1) == 58) {
            char c = (char) getBytes$okio().getByte(0);
            if (('a' > c || c >= '{') && ('A' > c || c >= '[')) {
                return null;
            }
            return Character.valueOf(c);
        }
        return null;
    }

    public final ByteString nameBytes() {
        int indexOfLastSlash = okio.internal.Path.getIndexOfLastSlash(this);
        if (indexOfLastSlash != -1) {
            return ByteString.substring$default(getBytes$okio(), indexOfLastSlash + 1, 0, 2, null);
        }
        return (volumeLetter() == null || getBytes$okio().size() != 2) ? getBytes$okio() : ByteString.EMPTY;
    }

    public final String name() {
        return nameBytes().utf8();
    }

    public final Path parent() {
        if (Intrinsics.areEqual(getBytes$okio(), okio.internal.Path.DOT) || Intrinsics.areEqual(getBytes$okio(), okio.internal.Path.SLASH) || Intrinsics.areEqual(getBytes$okio(), okio.internal.Path.BACKSLASH) || okio.internal.Path.lastSegmentIsDotDot(this)) {
            return null;
        }
        int indexOfLastSlash = okio.internal.Path.getIndexOfLastSlash(this);
        if (indexOfLastSlash != 2 || volumeLetter() == null) {
            if (indexOfLastSlash == 1 && getBytes$okio().startsWith(okio.internal.Path.BACKSLASH)) {
                return null;
            }
            if (indexOfLastSlash == -1 && volumeLetter() != null) {
                if (getBytes$okio().size() == 2) {
                    return null;
                }
                return new Path(ByteString.substring$default(getBytes$okio(), 0, 2, 1, null));
            } else if (indexOfLastSlash == -1) {
                return new Path(okio.internal.Path.DOT);
            } else {
                if (indexOfLastSlash == 0) {
                    return new Path(ByteString.substring$default(getBytes$okio(), 0, 1, 1, null));
                }
                return new Path(ByteString.substring$default(getBytes$okio(), 0, indexOfLastSlash, 1, null));
            }
        } else if (getBytes$okio().size() == 3) {
            return null;
        } else {
            return new Path(ByteString.substring$default(getBytes$okio(), 0, 3, 1, null));
        }
    }

    public final boolean isRoot() {
        return okio.internal.Path.rootLength(this) == getBytes$okio().size();
    }

    public final Path resolve(String child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return okio.internal.Path.commonResolve(this, okio.internal.Path.toPath(new Buffer().writeUtf8(child), false), false);
    }

    public final Path resolve(ByteString child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return okio.internal.Path.commonResolve(this, okio.internal.Path.toPath(new Buffer().write(child), false), false);
    }

    public final Path resolve(String child, boolean z) {
        Intrinsics.checkNotNullParameter(child, "child");
        return okio.internal.Path.commonResolve(this, okio.internal.Path.toPath(new Buffer().writeUtf8(child), false), z);
    }

    public final Path resolve(ByteString child, boolean z) {
        Intrinsics.checkNotNullParameter(child, "child");
        return okio.internal.Path.commonResolve(this, okio.internal.Path.toPath(new Buffer().write(child), false), z);
    }

    public final Path relativeTo(Path other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (!Intrinsics.areEqual(getRoot(), other.getRoot())) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + other).toString());
        }
        List<ByteString> segmentsBytes = getSegmentsBytes();
        List<ByteString> segmentsBytes2 = other.getSegmentsBytes();
        int min = Math.min(segmentsBytes.size(), segmentsBytes2.size());
        int i = 0;
        while (i < min && Intrinsics.areEqual(segmentsBytes.get(i), segmentsBytes2.get(i))) {
            i++;
        }
        if (i != min || getBytes$okio().size() != other.getBytes$okio().size()) {
            if (segmentsBytes2.subList(i, segmentsBytes2.size()).indexOf(okio.internal.Path.DOT_DOT) == -1) {
                if (Intrinsics.areEqual(other.getBytes$okio(), okio.internal.Path.DOT)) {
                    return this;
                }
                Buffer buffer = new Buffer();
                ByteString slash = okio.internal.Path.getSlash(other);
                if (slash == null && (slash = okio.internal.Path.getSlash(this)) == null) {
                    slash = okio.internal.Path.toSlash(DIRECTORY_SEPARATOR);
                }
                int size = segmentsBytes2.size();
                for (int i2 = i; i2 < size; i2++) {
                    buffer.write(okio.internal.Path.DOT_DOT);
                    buffer.write(slash);
                }
                int size2 = segmentsBytes.size();
                while (i < size2) {
                    buffer.write(segmentsBytes.get(i));
                    buffer.write(slash);
                    i++;
                }
                return okio.internal.Path.toPath(buffer, false);
            }
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + other).toString());
        }
        return Companion.get$default(Companion, ".", false, 1, (Object) null);
    }

    public final Path normalized() {
        return Companion.get(toString(), true);
    }

    @Override // java.lang.Comparable
    public int compareTo(Path other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return getBytes$okio().compareTo(other.getBytes$okio());
    }

    public boolean equals(Object obj) {
        return (obj instanceof Path) && Intrinsics.areEqual(((Path) obj).getBytes$okio(), getBytes$okio());
    }

    public int hashCode() {
        return getBytes$okio().hashCode();
    }

    public String toString() {
        return getBytes$okio().utf8();
    }
}
