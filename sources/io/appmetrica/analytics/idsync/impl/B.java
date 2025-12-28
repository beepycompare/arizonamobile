package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;
/* loaded from: classes3.dex */
public final class B {

    /* renamed from: a  reason: collision with root package name */
    public final ModulePreferences f459a;
    public final A b = new A();
    public final String c = "request_state";
    public final Map d = MapsKt.toMutableMap(a());

    public B(ModulePreferences modulePreferences) {
        this.f459a = modulePreferences;
    }

    public final LinkedHashMap a() {
        List<z> model = this.b.toModel(this.f459a.getString(this.c, null));
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(model, 10)), 16));
        for (Object obj : model) {
            linkedHashMap.put(((z) obj).f480a, obj);
        }
        return linkedHashMap;
    }
}
