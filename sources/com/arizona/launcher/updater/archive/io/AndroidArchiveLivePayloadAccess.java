package com.arizona.launcher.updater.archive.io;

import android.system.Os;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ArchiveLivePayloadAccess.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/io/AndroidArchiveLivePayloadAccess;", "", "<init>", "()V", "apply", "", "gameRoot", "Ljava/io/File;", "liveFile", "isStrictChild", "", "candidate", "root", "LIVE_FILE_MODE", "", "LIVE_DIRECTORY_MODE", "TAG", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidArchiveLivePayloadAccess {
    public static final int $stable = 0;
    public static final AndroidArchiveLivePayloadAccess INSTANCE = new AndroidArchiveLivePayloadAccess();
    private static final int LIVE_DIRECTORY_MODE = 1535;
    private static final int LIVE_FILE_MODE = 438;
    private static final String TAG = "ArchiveLivePayloadAccess";

    private AndroidArchiveLivePayloadAccess() {
    }

    public final void apply(File gameRoot, File liveFile) {
        Intrinsics.checkNotNullParameter(gameRoot, "gameRoot");
        Intrinsics.checkNotNullParameter(liveFile, "liveFile");
        try {
            File canonicalFile = gameRoot.getCanonicalFile();
            File canonicalFile2 = liveFile.getCanonicalFile();
            if (canonicalFile.isDirectory() && canonicalFile2.isFile()) {
                Intrinsics.checkNotNull(canonicalFile2);
                Intrinsics.checkNotNull(canonicalFile);
                if (isStrictChild(canonicalFile2, canonicalFile)) {
                    ArrayList arrayList = new ArrayList();
                    File parentFile = canonicalFile2.getParentFile();
                    while (parentFile != null && !Intrinsics.areEqual(parentFile, canonicalFile)) {
                        File canonicalFile3 = parentFile.getCanonicalFile();
                        if (!canonicalFile3.isDirectory()) {
                            return;
                        }
                        Intrinsics.checkNotNull(canonicalFile3);
                        if (!isStrictChild(canonicalFile3, canonicalFile)) {
                            return;
                        }
                        arrayList.add(canonicalFile3);
                        parentFile = canonicalFile3.getParentFile();
                    }
                    if (Intrinsics.areEqual(parentFile, canonicalFile)) {
                        Os.chmod(canonicalFile.getAbsolutePath(), LIVE_DIRECTORY_MODE);
                        for (File file : CollectionsKt.asReversedMutable(arrayList)) {
                            Os.chmod(file.getAbsolutePath(), LIVE_DIRECTORY_MODE);
                        }
                        Os.chmod(canonicalFile2.getAbsolutePath(), LIVE_FILE_MODE);
                    }
                }
            }
        } catch (Exception e) {
            Log.w(TAG, "Unable to expose debug live payload " + liveFile.getPath(), e);
        }
    }

    private final boolean isStrictChild(File file, File file2) {
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        String path2 = file2.getPath();
        return StringsKt.startsWith$default(path, path2 + File.separator, false, 2, (Object) null);
    }
}
