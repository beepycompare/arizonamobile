package androidx.datastore.core;

import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: FileDiagnostics.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0002¨\u0006\f"}, d2 = {"Landroidx/datastore/core/FileDiagnostics;", "", "<init>", "()V", "attachFileDebugInfo", "Ljava/io/IOException;", "file", "Ljava/io/File;", "cause", "attachParentStacktrace", "attachFileSystemMessage", "origException", "datastore-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FileDiagnostics {
    public static final FileDiagnostics INSTANCE = new FileDiagnostics();

    private FileDiagnostics() {
    }

    public final IOException attachFileDebugInfo(File file, IOException cause) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(cause, "cause");
        if (file.exists()) {
            if (file.isFile()) {
                if (file.canRead()) {
                    if (file.canWrite()) {
                        return attachParentStacktrace(file, cause);
                    }
                    return attachParentStacktrace(file, cause);
                } else if (file.canWrite()) {
                    return attachParentStacktrace(file, cause);
                } else {
                    return attachParentStacktrace(file, cause);
                }
            } else if (file.canRead()) {
                if (file.canWrite()) {
                    return attachParentStacktrace(file, cause);
                }
                return attachParentStacktrace(file, cause);
            } else if (file.canWrite()) {
                return attachParentStacktrace(file, cause);
            } else {
                return attachParentStacktrace(file, cause);
            }
        }
        return attachParentStacktrace(file, cause);
    }

    private final IOException attachParentStacktrace(File file, IOException iOException) {
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return attachFileSystemMessage(file, iOException);
        }
        if (parentFile.exists()) {
            if (parentFile.isFile()) {
                if (parentFile.canRead()) {
                    if (parentFile.canWrite()) {
                        return attachFileSystemMessage(file, iOException);
                    }
                    return attachFileSystemMessage(file, iOException);
                } else if (parentFile.canWrite()) {
                    return attachFileSystemMessage(file, iOException);
                } else {
                    return attachFileSystemMessage(file, iOException);
                }
            } else if (parentFile.canRead()) {
                if (parentFile.canWrite()) {
                    return attachFileSystemMessage(file, iOException);
                }
                return attachFileSystemMessage(file, iOException);
            } else if (parentFile.canWrite()) {
                return attachFileSystemMessage(file, iOException);
            } else {
                return attachFileSystemMessage(file, iOException);
            }
        }
        return attachFileSystemMessage(file, iOException);
    }

    private final IOException attachFileSystemMessage(File file, IOException iOException) {
        StringBuilder sb = new StringBuilder("Inoperable file:");
        try {
            sb.append(" canonical[" + file.getCanonicalPath() + "] freeSpace[" + file.getFreeSpace() + AbstractJsonLexerKt.END_LIST);
        } catch (IOException unused) {
            sb.append(" failed to attach additional metadata");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return new IOException(sb2, iOException);
    }
}
