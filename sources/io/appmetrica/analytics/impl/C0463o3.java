package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.o3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0463o3 implements InterfaceC0177co {
    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final List<C0562s3> invoke(List<C0562s3> list, C0562s3 c0562s3) {
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0562s3 c0562s32 : list) {
                T7 t7 = c0562s32.b;
                T7 t72 = c0562s3.b;
                if (t7 == t72) {
                    if (t72 == T7.c) {
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : list) {
                            if (((C0562s3) obj).b != T7.c) {
                                arrayList.add(obj);
                            }
                        }
                        return CollectionsKt.plus((Collection<? extends C0562s3>) arrayList, c0562s3);
                    }
                    return null;
                }
            }
        }
        return CollectionsKt.plus((Collection<? extends C0562s3>) list, c0562s3);
    }
}
