package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
/* renamed from: io.appmetrica.analytics.impl.x5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0692x5 implements F8, S8 {

    /* renamed from: a  reason: collision with root package name */
    public final L6 f1299a;
    public final Set b;
    public final AtomicLong c;

    public C0692x5(L6 l6) {
        this.f1299a = l6;
        Set of = SetsKt.setOf((Object[]) new Integer[]{Integer.valueOf(EnumC0142bb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION.a()), Integer.valueOf(EnumC0142bb.EVENT_TYPE_APP_UPDATE.a()), Integer.valueOf(EnumC0142bb.EVENT_TYPE_FIRST_ACTIVATION.a()), Integer.valueOf(EnumC0142bb.EVENT_TYPE_INIT.a()), Integer.valueOf(EnumC0142bb.EVENT_TYPE_SEND_AD_REVENUE_EVENT.a()), Integer.valueOf(EnumC0142bb.EVENT_TYPE_SEND_ECOMMERCE_EVENT.a()), Integer.valueOf(EnumC0142bb.EVENT_TYPE_SEND_REFERRER.a()), Integer.valueOf(EnumC0142bb.EVENT_TYPE_SEND_REVENUE_EVENT.a())});
        this.b = of;
        this.c = new AtomicLong(l6.a(of));
        l6.a(this);
    }

    @Override // io.appmetrica.analytics.impl.S8
    public final void a() {
        this.c.set(this.f1299a.a(this.b));
    }

    @Override // io.appmetrica.analytics.impl.F8
    public final boolean b() {
        return this.c.get() > 0;
    }

    @Override // io.appmetrica.analytics.impl.S8
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

    @Override // io.appmetrica.analytics.impl.S8
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
