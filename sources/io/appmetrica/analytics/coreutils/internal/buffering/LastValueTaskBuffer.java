package io.appmetrica.analytics.coreutils.internal.buffering;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016¨\u0006\r"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/buffering/LastValueTaskBuffer;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/appmetrica/analytics/coreutils/internal/buffering/TaskBuffer;", "task", "", "add", "(Ljava/lang/Object;)V", "", "getAndClear", "", "isEmpty", "<init>", "()V", "core-utils_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class LastValueTaskBuffer<T> implements TaskBuffer<T> {

    /* renamed from: a  reason: collision with root package name */
    private Object f353a;

    @Override // io.appmetrica.analytics.coreutils.internal.buffering.TaskBuffer
    public void add(T t) {
        this.f353a = t;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.buffering.TaskBuffer
    public List<T> getAndClear() {
        Object obj = this.f353a;
        this.f353a = null;
        return obj != null ? CollectionsKt.listOf(obj) : CollectionsKt.emptyList();
    }

    @Override // io.appmetrica.analytics.coreutils.internal.buffering.TaskBuffer
    public boolean isEmpty() {
        return this.f353a == null;
    }
}
