package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerFactory;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
/* renamed from: io.appmetrica.analytics.impl.nd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0456nd {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap f956a = new LinkedHashMap();

    public final LinkedHashMap a(String str) {
        LinkedHashMap linkedHashMap = this.f956a;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry.getKey(), ((ModuleEventServiceHandlerFactory) entry.getValue()).createEventHandler(str));
        }
        return linkedHashMap2;
    }
}
