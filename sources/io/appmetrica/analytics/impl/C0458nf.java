package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.nf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0458nf implements Vn {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f957a;

    public C0458nf(C0508pf c0508pf) {
        boolean z;
        List<C0483of> list = c0508pf.b;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0483of c0483of : list) {
                if (c0483of.c == EnumC0327i8.c) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        this.f957a = z;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final List<C0483of> invoke(List<? extends C0483of> list, Cf cf) {
        C0483of c0483of = new C0483of(cf.f375a, cf.b, cf.e);
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (C0483of c0483of2 : list) {
                if (c0483of2.c == cf.e) {
                    if (c0483of.c == EnumC0327i8.c && this.f957a) {
                        return CollectionsKt.plus((Collection<? extends C0483of>) list, c0483of);
                    }
                    return null;
                }
            }
        }
        return CollectionsKt.plus((Collection<? extends C0483of>) list, c0483of);
    }
}
