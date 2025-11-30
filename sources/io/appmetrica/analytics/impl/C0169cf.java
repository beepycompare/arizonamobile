package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.cf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0169cf implements InterfaceC0178co {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f833a;

    public C0169cf(C0220ef c0220ef) {
        boolean z;
        List<C0195df> list = c0220ef.b;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0195df c0195df : list) {
                if (c0195df.c == T7.c) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        this.f833a = z;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final List<C0195df> invoke(List<? extends C0195df> list, C0550rf c0550rf) {
        C0195df c0195df = new C0195df(c0550rf.f1102a, c0550rf.b, c0550rf.e);
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0195df c0195df2 : list) {
                if (c0195df2.c == c0550rf.e) {
                    if (c0195df.c == T7.c && this.f833a) {
                        return CollectionsKt.plus((Collection<? extends C0195df>) list, c0195df);
                    }
                    return null;
                }
            }
        }
        return CollectionsKt.plus((Collection<? extends C0195df>) list, c0195df);
    }
}
