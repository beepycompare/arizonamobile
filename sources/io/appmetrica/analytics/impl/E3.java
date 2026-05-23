package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class E3 implements Do {
    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final List<I3> invoke(List<I3> list, I3 i3) {
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (I3 i32 : list) {
                EnumC0399l8 enumC0399l8 = i32.b;
                EnumC0399l8 enumC0399l82 = i3.b;
                if (enumC0399l8 == enumC0399l82) {
                    if (enumC0399l82 == EnumC0399l8.d) {
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : list) {
                            if (((I3) obj).b != EnumC0399l8.d) {
                                arrayList.add(obj);
                            }
                        }
                        return CollectionsKt.plus((Collection<? extends I3>) arrayList, i3);
                    }
                    return null;
                }
            }
        }
        return CollectionsKt.plus((Collection<? extends I3>) list, i3);
    }
}
