package com.arizona.launcher.updater.archive.range;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RemoteZipIndexParser.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/RemoteZipParseFailure;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "code", "Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexErrorCode;", "entryPath", "", "<init>", "(Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexErrorCode;Ljava/lang/String;)V", "getCode", "()Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexErrorCode;", "getEntryPath", "()Ljava/lang/String;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final class RemoteZipParseFailure extends Exception {
    private final RemoteZipIndexErrorCode code;
    private final String entryPath;

    public RemoteZipParseFailure(RemoteZipIndexErrorCode code, String str) {
        Intrinsics.checkNotNullParameter(code, "code");
        this.code = code;
        this.entryPath = str;
    }

    public /* synthetic */ RemoteZipParseFailure(RemoteZipIndexErrorCode remoteZipIndexErrorCode, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(remoteZipIndexErrorCode, (i & 2) != 0 ? null : str);
    }

    public final RemoteZipIndexErrorCode getCode() {
        return this.code;
    }

    public final String getEntryPath() {
        return this.entryPath;
    }
}
