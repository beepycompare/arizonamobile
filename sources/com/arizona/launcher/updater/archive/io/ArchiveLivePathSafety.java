package com.arizona.launcher.updater.archive.io;

import coil3.util.UtilsKt;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveLivePathSafety.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0010H\u0002Ê\u0001\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0014"}, d2 = {"Lcom/arizona/launcher/updater/archive/io/ArchiveLivePathSafety;", "", "<init>", "()V", "hasUnsafeCanonicalAlias", "", "canonicalRoot", "Ljava/io/File;", "lexicalPath", "canonicalPath", "hasSymbolicLinkComponent", "lexicalTarget", "isSamePathIgnoringCase", "isSymbolicLink", UtilsKt.SCHEME_FILE, "normalizedAbsolutePath", "Ljava/nio/file/Path;", "first", "second", "path", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveLivePathSafety {
    public static final int $stable = 0;
    public static final ArchiveLivePathSafety INSTANCE = new ArchiveLivePathSafety();

    private ArchiveLivePathSafety() {
    }

    public final boolean hasUnsafeCanonicalAlias(File canonicalRoot, File lexicalPath, File canonicalPath) {
        Path normalizedAbsolutePath;
        Intrinsics.checkNotNullParameter(canonicalRoot, "canonicalRoot");
        Intrinsics.checkNotNullParameter(lexicalPath, "lexicalPath");
        Intrinsics.checkNotNullParameter(canonicalPath, "canonicalPath");
        Path normalizedAbsolutePath2 = normalizedAbsolutePath(lexicalPath);
        if (normalizedAbsolutePath2 == null || (normalizedAbsolutePath = normalizedAbsolutePath(canonicalPath)) == null) {
            return true;
        }
        if (Intrinsics.areEqual(normalizedAbsolutePath2, normalizedAbsolutePath)) {
            return false;
        }
        if (isSamePathIgnoringCase(normalizedAbsolutePath2, normalizedAbsolutePath)) {
            return hasSymbolicLinkComponent(canonicalRoot, lexicalPath);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean hasSymbolicLinkComponent(File canonicalRoot, File lexicalTarget) {
        Path normalizedAbsolutePath;
        Intrinsics.checkNotNullParameter(canonicalRoot, "canonicalRoot");
        Intrinsics.checkNotNullParameter(lexicalTarget, "lexicalTarget");
        Path normalizedAbsolutePath2 = normalizedAbsolutePath(canonicalRoot);
        if (normalizedAbsolutePath2 == null || (normalizedAbsolutePath = normalizedAbsolutePath(lexicalTarget)) == null || Intrinsics.areEqual(normalizedAbsolutePath, normalizedAbsolutePath2) || !normalizedAbsolutePath.startsWith(normalizedAbsolutePath2)) {
            return true;
        }
        while (!Intrinsics.areEqual(normalizedAbsolutePath, normalizedAbsolutePath2)) {
            if (isSymbolicLink(normalizedAbsolutePath) || (normalizedAbsolutePath = normalizedAbsolutePath.getParent()) == null) {
                return true;
            }
            while (!Intrinsics.areEqual(normalizedAbsolutePath, normalizedAbsolutePath2)) {
            }
        }
        return false;
    }

    public final boolean isSamePathIgnoringCase(File lexicalPath, File canonicalPath) {
        Path normalizedAbsolutePath;
        Intrinsics.checkNotNullParameter(lexicalPath, "lexicalPath");
        Intrinsics.checkNotNullParameter(canonicalPath, "canonicalPath");
        Path normalizedAbsolutePath2 = normalizedAbsolutePath(lexicalPath);
        if (normalizedAbsolutePath2 == null || (normalizedAbsolutePath = normalizedAbsolutePath(canonicalPath)) == null) {
            return false;
        }
        return isSamePathIgnoringCase(normalizedAbsolutePath2, normalizedAbsolutePath);
    }

    public final boolean isSymbolicLink(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        Path normalizedAbsolutePath = normalizedAbsolutePath(file);
        if (normalizedAbsolutePath == null) {
            return true;
        }
        return isSymbolicLink(normalizedAbsolutePath);
    }

    private final Path normalizedAbsolutePath(File file) {
        try {
            return file.toPath().toAbsolutePath().normalize();
        } catch (RuntimeException unused) {
            return null;
        }
    }

    private final boolean isSamePathIgnoringCase(Path path, Path path2) {
        String obj = path.toString();
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = obj.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String obj2 = path2.toString();
        Locale ROOT2 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
        String lowerCase2 = obj2.toLowerCase(ROOT2);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        return Intrinsics.areEqual(lowerCase, lowerCase2);
    }

    private final boolean isSymbolicLink(Path path) {
        try {
            return Files.isSymbolicLink(path);
        } catch (SecurityException unused) {
            return true;
        }
    }
}
