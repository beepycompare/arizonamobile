package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class Sd {
    public static ArrayList a() {
        Bd bd;
        List<String> a2 = C0576s4.l().m.a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(a2, 10));
        for (String str : a2) {
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            Object loadAndInstantiateClassWithDefaultConstructor = ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor(str, ModuleClientEntryPoint.class);
            if (loadAndInstantiateClassWithDefaultConstructor == null) {
                bd = new Bd(str, false);
            } else {
                C0576s4.l().m().b.add((ModuleClientEntryPoint) loadAndInstantiateClassWithDefaultConstructor);
                bd = new Bd(str, true);
            }
            arrayList.add(bd);
        }
        return arrayList;
    }
}
