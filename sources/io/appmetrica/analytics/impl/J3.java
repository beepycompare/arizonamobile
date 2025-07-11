package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public final class J3 implements Vn {
    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final List<N3> invoke(List<N3> list, N3 n3) {
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (N3 n32 : list) {
                EnumC0327i8 enumC0327i8 = n32.b;
                EnumC0327i8 enumC0327i82 = n3.b;
                if (enumC0327i8 == enumC0327i82) {
                    if (enumC0327i82 == EnumC0327i8.c) {
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : list) {
                            if (((N3) obj).b != EnumC0327i8.c) {
                                arrayList.add(obj);
                            }
                        }
                        return CollectionsKt.plus((Collection<? extends N3>) arrayList, n3);
                    }
                    return null;
                }
            }
        }
        return CollectionsKt.plus((Collection<? extends N3>) list, n3);
    }
}
