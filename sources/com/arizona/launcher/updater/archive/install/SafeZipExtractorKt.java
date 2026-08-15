package com.arizona.launcher.updater.archive.install;

import com.arizona.launcher.updater.archive.install.SafeZipExtractionResult;
import kotlin.Metadata;
/* compiled from: SafeZipExtractor.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002¨\u0006\u0006"}, d2 = {"failure", "Lcom/arizona/launcher/updater/archive/install/SafeZipExtractionResult$Failure;", "code", "Lcom/arizona/launcher/updater/archive/install/SafeZipExtractionErrorCode;", "entryName", "", "app"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SafeZipExtractorKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ SafeZipExtractionResult.Failure failure$default(SafeZipExtractionErrorCode safeZipExtractionErrorCode, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return failure(safeZipExtractionErrorCode, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SafeZipExtractionResult.Failure failure(SafeZipExtractionErrorCode safeZipExtractionErrorCode, String str) {
        return new SafeZipExtractionResult.Failure(safeZipExtractionErrorCode, str);
    }
}
