package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.td  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0597td {
    public static ArrayList a() {
        C0166cd c0166cd;
        List<String> a2 = C0157c4.l().m.a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(a2, 10));
        for (String str : a2) {
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            Object loadAndInstantiateClassWithDefaultConstructor = ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor(str, ModuleClientEntryPoint.class);
            if (loadAndInstantiateClassWithDefaultConstructor == null) {
                c0166cd = new C0166cd(str, false);
            } else {
                C0157c4.l().m().b.add((ModuleClientEntryPoint) loadAndInstantiateClassWithDefaultConstructor);
                c0166cd = new C0166cd(str, true);
            }
            arrayList.add(c0166cd);
        }
        return arrayList;
    }
}
