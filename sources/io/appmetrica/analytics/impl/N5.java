package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class N5 implements Z8, InterfaceC0425m9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0165c7 f680a;
    public final AtomicLong b;

    public N5(C0165c7 c0165c7) {
        this.f680a = c0165c7;
        this.b = new AtomicLong(c0165c7.a(Eo.a()));
        c0165c7.a(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0425m9
    public final void a() {
        this.b.set(this.f680a.a(Eo.f536a));
    }

    @Override // io.appmetrica.analytics.impl.Z8
    public final boolean b() {
        return this.b.get() > 0;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0425m9
    public final void b(List<Integer> list) {
        int i = 0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (Number number : list) {
                if (Eo.f536a.contains(Integer.valueOf(number.intValue())) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        this.b.addAndGet(-i);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0425m9
    public final void a(List<Integer> list) {
        int i = 0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (Number number : list) {
                if (Eo.f536a.contains(Integer.valueOf(number.intValue())) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        this.b.addAndGet(i);
    }
}
