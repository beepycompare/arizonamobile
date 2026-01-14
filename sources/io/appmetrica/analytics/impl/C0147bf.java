package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.bf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0147bf implements InterfaceC0156bo {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f922a;

    public C0147bf(C0199df c0199df) {
        boolean z;
        List<C0173cf> list = c0199df.b;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0173cf c0173cf : list) {
                if (c0173cf.c == S7.c) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        this.f922a = z;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final List<C0173cf> invoke(List<? extends C0173cf> list, C0529qf c0529qf) {
        C0173cf c0173cf = new C0173cf(c0529qf.f1190a, c0529qf.b, c0529qf.e);
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0173cf c0173cf2 : list) {
                if (c0173cf2.c == c0529qf.e) {
                    if (c0173cf.c == S7.c && this.f922a) {
                        return CollectionsKt.plus((Collection<? extends C0173cf>) list, c0173cf);
                    }
                    return null;
                }
            }
        }
        return CollectionsKt.plus((Collection<? extends C0173cf>) list, c0173cf);
    }
}
