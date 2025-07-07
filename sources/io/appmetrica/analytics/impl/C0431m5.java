package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* renamed from: io.appmetrica.analytics.impl.m5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0431m5 {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f933a = new CopyOnWriteArrayList();

    public final void a(A4 a4) {
        this.f933a.add(a4);
    }

    public final void b(A4 a4) {
        this.f933a.remove(a4);
    }

    public final List<A4> a() {
        return this.f933a;
    }
}
