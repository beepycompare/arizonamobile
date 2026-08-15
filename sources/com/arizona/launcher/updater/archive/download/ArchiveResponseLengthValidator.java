package com.arizona.launcher.updater.archive.download;

import kotlin.Metadata;
/* compiled from: ArchivePackageDownloader.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007Ê\u0001\f\b\n\u0012\b\b\u000b\u0012\u0004\b\u0003\u0010\u0002¨\u0006\t"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveResponseLengthValidator;", "", "<init>", "()V", "matches", "", "expectedSize", "", "reportedTotalLength", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveResponseLengthValidator {
    public static final int $stable = 0;
    public static final ArchiveResponseLengthValidator INSTANCE = new ArchiveResponseLengthValidator();

    public final boolean matches(long j, long j2) {
        return j > 0 && j2 == j;
    }

    private ArchiveResponseLengthValidator() {
    }
}
