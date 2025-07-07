package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.nf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0466nf implements Vn {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f956a;

    public C0466nf(C0516pf c0516pf) {
        boolean z;
        List<C0491of> list = c0516pf.b;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0491of c0491of : list) {
                if (c0491of.c == EnumC0335i8.c) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        this.f956a = z;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final List<C0491of> invoke(List<? extends C0491of> list, Cf cf) {
        C0491of c0491of = new C0491of(cf.f374a, cf.b, cf.e);
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0491of c0491of2 : list) {
                if (c0491of2.c == cf.e) {
                    if (c0491of.c == EnumC0335i8.c && this.f956a) {
                        return CollectionsKt.plus((Collection<? extends C0491of>) list, c0491of);
                    }
                    return null;
                }
            }
        }
        return CollectionsKt.plus((Collection<? extends C0491of>) list, c0491of);
    }
}
