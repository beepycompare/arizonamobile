package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public final class M3 implements InterfaceC0315ho {
    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final List<Q3> invoke(List<Q3> list, Q3 q3) {
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (Q3 q32 : list) {
                EnumC0531q8 enumC0531q8 = q32.b;
                EnumC0531q8 enumC0531q82 = q3.b;
                if (enumC0531q8 == enumC0531q82) {
                    if (enumC0531q82 == EnumC0531q8.c) {
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : list) {
                            if (((Q3) obj).b != EnumC0531q8.c) {
                                arrayList.add(obj);
                            }
                        }
                        return CollectionsKt.plus((Collection<? extends Q3>) arrayList, q3);
                    }
                    return null;
                }
            }
        }
        return CollectionsKt.plus((Collection<? extends Q3>) list, q3);
    }
}
