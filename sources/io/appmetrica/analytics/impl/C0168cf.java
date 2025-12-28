package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.cf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0168cf implements InterfaceC0177co {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f931a;

    public C0168cf(C0219ef c0219ef) {
        boolean z;
        List<C0194df> list = c0219ef.b;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0194df c0194df : list) {
                if (c0194df.c == T7.c) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        this.f931a = z;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final List<C0194df> invoke(List<? extends C0194df> list, C0549rf c0549rf) {
        C0194df c0194df = new C0194df(c0549rf.f1200a, c0549rf.b, c0549rf.e);
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0194df c0194df2 : list) {
                if (c0194df2.c == c0549rf.e) {
                    if (c0194df.c == T7.c && this.f931a) {
                        return CollectionsKt.plus((Collection<? extends C0194df>) list, c0194df);
                    }
                    return null;
                }
            }
        }
        return CollectionsKt.plus((Collection<? extends C0194df>) list, c0194df);
    }
}
