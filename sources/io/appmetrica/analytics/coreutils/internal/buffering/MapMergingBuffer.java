package io.appmetrica.analytics.coreutils.internal.buffering;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0003B\u0007¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\u001a\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/buffering/MapMergingBuffer;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lio/appmetrica/analytics/coreutils/internal/buffering/TaskBuffer;", "", "task", "", "add", "", "getAndClear", "", "isEmpty", "<init>", "()V", "core-utils_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class MapMergingBuffer<K, V> implements TaskBuffer<Map<K, ? extends V>> {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap f352a = new LinkedHashMap();

    @Override // io.appmetrica.analytics.coreutils.internal.buffering.TaskBuffer
    public /* bridge */ /* synthetic */ void add(Object obj) {
        add((Map) ((Map) obj));
    }

    @Override // io.appmetrica.analytics.coreutils.internal.buffering.TaskBuffer
    public List<Map<K, V>> getAndClear() {
        if (this.f352a.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        Map map = MapsKt.toMap(this.f352a);
        this.f352a.clear();
        return CollectionsKt.listOf(map);
    }

    @Override // io.appmetrica.analytics.coreutils.internal.buffering.TaskBuffer
    public boolean isEmpty() {
        return this.f352a.isEmpty();
    }

    public void add(Map<K, ? extends V> map) {
        this.f352a.putAll(map);
    }
}
