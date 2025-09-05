package ru.rustore.sdk.core.tasks;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* compiled from: Task.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00030\u0007H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"INFINITE_TIMEOUT", "", "forEachWithDeletion", "", ExifInterface.GPS_DIRECTION_TRUE, "", "block", "Lkotlin/Function1;", "sdk-public-core_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TaskKt {
    private static final long INFINITE_TIMEOUT = Long.MIN_VALUE;

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> void forEachWithDeletion(List<T> list, Function1<? super T, Unit> function1) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            function1.invoke(it.next());
            it.remove();
        }
    }
}
