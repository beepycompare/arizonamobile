package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
/* loaded from: classes4.dex */
public final class W5 implements InterfaceC0196d9, InterfaceC0531q9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0374k7 f718a;
    public final Set b;
    public final AtomicLong c;

    public W5(C0374k7 c0374k7) {
        this.f718a = c0374k7;
        Set of = SetsKt.setOf((Object[]) new Integer[]{Integer.valueOf(Bb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION.a()), Integer.valueOf(Bb.EVENT_TYPE_APP_UPDATE.a()), Integer.valueOf(Bb.EVENT_TYPE_FIRST_ACTIVATION.a()), Integer.valueOf(Bb.EVENT_TYPE_INIT.a()), Integer.valueOf(Bb.EVENT_TYPE_SEND_AD_REVENUE_EVENT.a()), Integer.valueOf(Bb.EVENT_TYPE_SEND_ECOMMERCE_EVENT.a()), Integer.valueOf(Bb.EVENT_TYPE_SEND_REFERRER.a()), Integer.valueOf(Bb.EVENT_TYPE_SEND_REVENUE_EVENT.a())});
        this.b = of;
        this.c = new AtomicLong(c0374k7.a(of));
        c0374k7.a(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0531q9
    public final void a() {
        this.c.set(this.f718a.a(this.b));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0196d9
    public final boolean b() {
        return this.c.get() > 0;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0531q9
    public final void b(List<Integer> list) {
        int i = 0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (Number number : list) {
                if (this.b.contains(Integer.valueOf(number.intValue())) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        this.c.addAndGet(-i);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0531q9
    public final void a(List<Integer> list) {
        int i = 0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (Number number : list) {
                if (this.b.contains(Integer.valueOf(number.intValue())) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        this.c.addAndGet(i);
    }
}
