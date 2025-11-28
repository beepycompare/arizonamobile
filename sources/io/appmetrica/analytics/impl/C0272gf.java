package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.gf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0272gf implements Cdo {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f896a;

    public C0272gf(Cif cif) {
        boolean z;
        List<C0298hf> list = cif.b;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0298hf c0298hf : list) {
                if (c0298hf.c == Y7.c) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        this.f896a = z;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final List<C0298hf> invoke(List<? extends C0298hf> list, C0650vf c0650vf) {
        C0298hf c0298hf = new C0298hf(c0650vf.f1171a, c0650vf.b, c0650vf.e);
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0298hf c0298hf2 : list) {
                if (c0298hf2.c == c0650vf.e) {
                    if (c0298hf.c == Y7.c && this.f896a) {
                        return CollectionsKt.plus((Collection<? extends C0298hf>) list, c0298hf);
                    }
                    return null;
                }
            }
        }
        return CollectionsKt.plus((Collection<? extends C0298hf>) list, c0298hf);
    }
}
