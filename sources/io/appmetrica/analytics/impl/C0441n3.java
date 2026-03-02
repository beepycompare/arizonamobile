package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.n3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0441n3 implements InterfaceC0155bo {
    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final List<C0540r3> invoke(List<C0540r3> list, C0540r3 c0540r3) {
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0540r3 c0540r32 : list) {
                S7 s7 = c0540r32.b;
                S7 s72 = c0540r3.b;
                if (s7 == s72) {
                    if (s72 == S7.c) {
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : list) {
                            if (((C0540r3) obj).b != S7.c) {
                                arrayList.add(obj);
                            }
                        }
                        return CollectionsKt.plus((Collection<? extends C0540r3>) arrayList, c0540r3);
                    }
                    return null;
                }
            }
        }
        return CollectionsKt.plus((Collection<? extends C0540r3>) list, c0540r3);
    }
}
