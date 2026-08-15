package com.arizona.launcher.updater.archive.transaction;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveOwnershipDiff.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00060\u0001j\u0002`\u0002B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eÊ\u0001\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0010"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnershipException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "code", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnershipErrorCode;", "relativePath", "", "conflictingPath", "message", "<init>", "(Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnershipErrorCode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnershipErrorCode;", "getRelativePath", "()Ljava/lang/String;", "getConflictingPath", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveOwnershipException extends IllegalArgumentException {
    public static final int $stable = 8;
    private final ArchiveOwnershipErrorCode code;
    private final String conflictingPath;
    private final String relativePath;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveOwnershipException(ArchiveOwnershipErrorCode code, String str, String str2, String message) {
        super(message);
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(message, "message");
        this.code = code;
        this.relativePath = str;
        this.conflictingPath = str2;
    }

    public /* synthetic */ ArchiveOwnershipException(ArchiveOwnershipErrorCode archiveOwnershipErrorCode, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(archiveOwnershipErrorCode, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, str3);
    }

    public final ArchiveOwnershipErrorCode getCode() {
        return this.code;
    }

    public final String getRelativePath() {
        return this.relativePath;
    }

    public final String getConflictingPath() {
        return this.conflictingPath;
    }
}
