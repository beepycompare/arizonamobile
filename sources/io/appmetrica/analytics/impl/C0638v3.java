package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.v3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0638v3 implements Cdo {
    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final List<C0738z3> invoke(List<C0738z3> list, C0738z3 c0738z3) {
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0738z3 c0738z32 : list) {
                Y7 y7 = c0738z32.b;
                Y7 y72 = c0738z3.b;
                if (y7 == y72) {
                    if (y72 == Y7.c) {
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : list) {
                            if (((C0738z3) obj).b != Y7.c) {
                                arrayList.add(obj);
                            }
                        }
                        return CollectionsKt.plus((Collection<? extends C0738z3>) arrayList, c0738z3);
                    }
                    return null;
                }
            }
        }
        return CollectionsKt.plus((Collection<? extends C0738z3>) list, c0738z3);
    }
}
