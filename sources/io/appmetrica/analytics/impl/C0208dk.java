package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.dk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0208dk implements InterfaceC0534qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f849a;

    public C0208dk(Map map) {
        this.f849a = map;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0534qb
    public final void a(InterfaceC0558rb interfaceC0558rb) {
        interfaceC0558rb.reportAnr(this.f849a);
    }
}
