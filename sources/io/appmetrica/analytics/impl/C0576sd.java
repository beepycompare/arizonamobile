package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.sd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0576sd {
    public static ArrayList a() {
        C0145bd c0145bd;
        List<String> a2 = C0136b4.l().m.a();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(a2, 10));
        for (String str : a2) {
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            Object loadAndInstantiateClassWithDefaultConstructor = ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor(str, ModuleClientEntryPoint.class);
            if (loadAndInstantiateClassWithDefaultConstructor == null) {
                c0145bd = new C0145bd(str, false);
            } else {
                C0136b4.l().m().b.add((ModuleClientEntryPoint) loadAndInstantiateClassWithDefaultConstructor);
                c0145bd = new C0145bd(str, true);
            }
            arrayList.add(c0145bd);
        }
        return arrayList;
    }
}
