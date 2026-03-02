package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.bf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0146bf implements InterfaceC0155bo {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f921a;

    public C0146bf(C0198df c0198df) {
        boolean z;
        List<C0172cf> list = c0198df.b;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0172cf c0172cf : list) {
                if (c0172cf.c == S7.c) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        this.f921a = z;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final List<C0172cf> invoke(List<? extends C0172cf> list, C0528qf c0528qf) {
        C0172cf c0172cf = new C0172cf(c0528qf.f1189a, c0528qf.b, c0528qf.e);
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0172cf c0172cf2 : list) {
                if (c0172cf2.c == c0528qf.e) {
                    if (c0172cf.c == S7.c && this.f921a) {
                        return CollectionsKt.plus((Collection<? extends C0172cf>) list, c0172cf);
                    }
                    return null;
                }
            }
        }
        return CollectionsKt.plus((Collection<? extends C0172cf>) list, c0172cf);
    }
}
