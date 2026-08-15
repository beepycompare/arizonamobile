package com.arizona.launcher.updater.archive.download;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveResumableHttpEngine.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tÊ\u0001\f\b\u000b\u0012\b\b\f\u0012\u0004\b\u0003\u0010\u0000¨\u0006\n"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveHttpResponseException;", "Ljava/io/IOException;", "code", "", "detail", "", "<init>", "(ILjava/lang/String;)V", "getCode", "()I", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveHttpResponseException extends IOException {
    public static final int $stable = 8;
    private final int code;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArchiveHttpResponseException(int i, String detail) {
        super(detail);
        Intrinsics.checkNotNullParameter(detail, "detail");
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    public /* synthetic */ ArchiveHttpResponseException(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? "HTTP " + i : str);
    }
}
