package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.pf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0511pf implements Yn {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1001a;

    public C0511pf(C0560rf c0560rf) {
        boolean z;
        List<C0536qf> list = c0560rf.b;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0536qf c0536qf : list) {
                if (c0536qf.c == EnumC0404l8.c) {
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
    public final List<C0536qf> invoke(List<? extends C0536qf> list, Ef ef) {
        C0536qf c0536qf = new C0536qf(ef.f418a, ef.b, ef.e);
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0536qf c0536qf2 : list) {
                if (c0536qf2.c == ef.e) {
                    if (c0536qf.c == EnumC0404l8.c && this.f1001a) {
                        return CollectionsKt.plus((Collection<? extends C0536qf>) list, c0536qf);
                    }
                    return null;
                }
            }
        }
        return CollectionsKt.plus((Collection<? extends C0536qf>) list, c0536qf);
    }
}
