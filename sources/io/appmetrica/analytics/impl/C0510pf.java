package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.pf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0510pf implements Yn {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1001a;

    public C0510pf(C0559rf c0559rf) {
        boolean z;
        List<C0535qf> list = c0559rf.b;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0535qf c0535qf : list) {
                if (c0535qf.c == EnumC0403l8.c) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        this.f1001a = z;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final List<C0535qf> invoke(List<? extends C0535qf> list, Ef ef) {
        C0535qf c0535qf = new C0535qf(ef.f418a, ef.b, ef.e);
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0535qf c0535qf2 : list) {
                if (c0535qf2.c == ef.e) {
                    if (c0535qf.c == EnumC0403l8.c && this.f1001a) {
                        return CollectionsKt.plus((Collection<? extends C0535qf>) list, c0535qf);
                    }
                    return null;
                }
            }
        }
        return CollectionsKt.plus((Collection<? extends C0535qf>) list, c0535qf);
    }
}
