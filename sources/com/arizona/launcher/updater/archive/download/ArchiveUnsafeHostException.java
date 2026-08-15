package com.arizona.launcher.updater.archive.download;

import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveNetworkSecurity.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005Ê\u0001\f\b\u0007\u0012\b\b\b\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveUnsafeHostException;", "Ljava/net/UnknownHostException;", "message", "", "<init>", "(Ljava/lang/String;)V", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveUnsafeHostException extends UnknownHostException {
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveUnsafeHostException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
