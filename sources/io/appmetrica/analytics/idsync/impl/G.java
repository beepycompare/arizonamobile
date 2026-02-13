package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;
/* loaded from: classes5.dex */
public final class G {

    /* renamed from: a  reason: collision with root package name */
    public final ModulePreferences f462a;
    public final F b = new F();
    public final String c = "request_state";
    public final Map d = MapsKt.toMutableMap(a());

    public G(ModulePreferences modulePreferences) {
        this.f462a = modulePreferences;
    }

    public final LinkedHashMap a() {
        List<E> model = this.b.toModel(this.f462a.getString(this.c, null));
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(model, 10)), 16));
        for (Object obj : model) {
            linkedHashMap.put(((E) obj).f460a, obj);
        }
        return linkedHashMap;
    }
}
