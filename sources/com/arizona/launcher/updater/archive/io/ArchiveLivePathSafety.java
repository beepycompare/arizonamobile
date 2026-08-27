package com.arizona.launcher.updater.archive.io;

import coil3.util.UtilsKt;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ArchiveLivePathSafety.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tJ\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\tJ\u0016\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tJ\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0019"}, d2 = {"Lcom/arizona/launcher/updater/archive/io/ArchiveLivePathSafety;", "", "nodeInspector", "Lcom/arizona/launcher/updater/archive/io/ArchiveNodeInspector;", "<init>", "(Lcom/arizona/launcher/updater/archive/io/ArchiveNodeInspector;)V", "hasUnsafeCanonicalAlias", "", "canonicalRoot", "Ljava/io/File;", "lexicalPath", "canonicalPath", "hasSymbolicLinkComponent", "lexicalTarget", "isSamePathIgnoringCase", "isSymbolicLink", UtilsKt.SCHEME_FILE, "normalizedAbsoluteFile", "isStrictChild", "candidate", "root", "pathsEqualIgnoringCase", "first", "second", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveLivePathSafety {
    private final ArchiveNodeInspector nodeInspector;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ArchiveLivePathSafety(ArchiveNodeInspector nodeInspector) {
        Intrinsics.checkNotNullParameter(nodeInspector, "nodeInspector");
        this.nodeInspector = nodeInspector;
    }

    public final boolean hasUnsafeCanonicalAlias(File canonicalRoot, File lexicalPath, File canonicalPath) {
        File normalizedAbsoluteFile;
        Intrinsics.checkNotNullParameter(canonicalRoot, "canonicalRoot");
        Intrinsics.checkNotNullParameter(lexicalPath, "lexicalPath");
        Intrinsics.checkNotNullParameter(canonicalPath, "canonicalPath");
        File normalizedAbsoluteFile2 = normalizedAbsoluteFile(lexicalPath);
        if (normalizedAbsoluteFile2 == null || (normalizedAbsoluteFile = normalizedAbsoluteFile(canonicalPath)) == null) {
            return true;
        }
        if (Intrinsics.areEqual(normalizedAbsoluteFile2, normalizedAbsoluteFile)) {
            return false;
        }
        if (pathsEqualIgnoringCase(normalizedAbsoluteFile2, normalizedAbsoluteFile)) {
            return hasSymbolicLinkComponent(canonicalRoot, lexicalPath);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean hasSymbolicLinkComponent(File canonicalRoot, File lexicalTarget) {
        File normalizedAbsoluteFile;
        Intrinsics.checkNotNullParameter(canonicalRoot, "canonicalRoot");
        Intrinsics.checkNotNullParameter(lexicalTarget, "lexicalTarget");
        File normalizedAbsoluteFile2 = normalizedAbsoluteFile(canonicalRoot);
        if (normalizedAbsoluteFile2 == null || (normalizedAbsoluteFile = normalizedAbsoluteFile(lexicalTarget)) == null || Intrinsics.areEqual(normalizedAbsoluteFile, normalizedAbsoluteFile2) || !isStrictChild(normalizedAbsoluteFile, normalizedAbsoluteFile2)) {
            return true;
        }
        while (!Intrinsics.areEqual(normalizedAbsoluteFile, normalizedAbsoluteFile2)) {
            if (isSymbolicLink(normalizedAbsoluteFile) || (normalizedAbsoluteFile = normalizedAbsoluteFile.getParentFile()) == null) {
                return true;
            }
            while (!Intrinsics.areEqual(normalizedAbsoluteFile, normalizedAbsoluteFile2)) {
            }
        }
        return false;
    }

    public final boolean isSamePathIgnoringCase(File lexicalPath, File canonicalPath) {
        File normalizedAbsoluteFile;
        Intrinsics.checkNotNullParameter(lexicalPath, "lexicalPath");
        Intrinsics.checkNotNullParameter(canonicalPath, "canonicalPath");
        File normalizedAbsoluteFile2 = normalizedAbsoluteFile(lexicalPath);
        if (normalizedAbsoluteFile2 == null || (normalizedAbsoluteFile = normalizedAbsoluteFile(canonicalPath)) == null) {
            return false;
        }
        return pathsEqualIgnoringCase(normalizedAbsoluteFile2, normalizedAbsoluteFile);
    }

    public final boolean isSymbolicLink(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            return this.nodeInspector.nodeType(file) == ArchiveFsNodeType.SYMBOLIC_LINK;
        } catch (IOException | SecurityException unused) {
            return true;
        }
    }

    public final File normalizedAbsoluteFile(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            File absoluteFile = file.getAbsoluteFile();
            Intrinsics.checkNotNullExpressionValue(absoluteFile, "getAbsoluteFile(...)");
            return FilesKt.normalize(absoluteFile);
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public final boolean isStrictChild(File candidate, File root) {
        File normalizedAbsoluteFile;
        String path;
        Intrinsics.checkNotNullParameter(candidate, "candidate");
        Intrinsics.checkNotNullParameter(root, "root");
        File normalizedAbsoluteFile2 = normalizedAbsoluteFile(candidate);
        if (normalizedAbsoluteFile2 == null || (normalizedAbsoluteFile = normalizedAbsoluteFile(root)) == null || Intrinsics.areEqual(normalizedAbsoluteFile2, normalizedAbsoluteFile)) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(normalizedAbsoluteFile.getPath(), "getPath(...)");
        String str = StringsKt.trimEnd(path, File.separatorChar) + File.separatorChar;
        String path2 = normalizedAbsoluteFile2.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
        return StringsKt.startsWith$default(path2, str, false, 2, (Object) null);
    }

    private final boolean pathsEqualIgnoringCase(File file, File file2) {
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = path.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String path2 = file2.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
        Locale ROOT2 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
        String lowerCase2 = path2.toLowerCase(ROOT2);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        return Intrinsics.areEqual(lowerCase, lowerCase2);
    }

    /* compiled from: ArchiveLivePathSafety.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/updater/archive/io/ArchiveLivePathSafety$Companion;", "", "<init>", "()V", "forAndroid", "Lcom/arizona/launcher/updater/archive/io/ArchiveLivePathSafety;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArchiveLivePathSafety forAndroid() {
            return new ArchiveLivePathSafety(AndroidArchiveNodeInspector.INSTANCE);
        }
    }
}
