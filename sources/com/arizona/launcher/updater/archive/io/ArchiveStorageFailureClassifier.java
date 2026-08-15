package com.arizona.launcher.updater.archive.io;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ArchiveStorageFailureClassifier.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\u0003\u0010\u0002¨\u0006\r"}, d2 = {"Lcom/arizona/launcher/updater/archive/io/ArchiveStorageFailureClassifier;", "", "<init>", "()V", "MAX_CAUSE_DEPTH", "", "NO_SPACE_MARKERS", "", "", "isNoSpace", "", "error", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveStorageFailureClassifier {
    public static final int $stable = 0;
    private static final int MAX_CAUSE_DEPTH = 16;
    public static final ArchiveStorageFailureClassifier INSTANCE = new ArchiveStorageFailureClassifier();
    private static final List<String> NO_SPACE_MARKERS = CollectionsKt.listOf((Object[]) new String[]{"enospc", "errno 28", "errno: 28", "errno=28", "no space left on device", "not enough space on the disk", "insufficient storage space", "disk is full", "edquot", "errno 122", "errno: 122", "errno=122", "disk quota exceeded"});

    private ArchiveStorageFailureClassifier() {
    }

    public final boolean isNoSpace(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 16 && error != null; i++) {
            ArrayList<Throwable> arrayList2 = arrayList;
            if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                for (Throwable th : arrayList2) {
                    if (th == error) {
                        return false;
                    }
                }
            }
            arrayList.add(error);
            String message = error.getMessage();
            if (message == null) {
                message = "";
            }
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = message.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            List<String> list = NO_SPACE_MARKERS;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (CharSequence charSequence : list) {
                    if (StringsKt.contains$default((CharSequence) lowerCase, charSequence, false, 2, (Object) null)) {
                        return true;
                    }
                }
                continue;
            }
            error = error.getCause();
        }
        return false;
    }
}
