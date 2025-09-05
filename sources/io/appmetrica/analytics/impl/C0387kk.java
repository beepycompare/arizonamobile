package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.kk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0387kk implements InterfaceC0533qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f953a;
    public final /* synthetic */ Map b;

    public C0387kk(String str, Map map) {
        this.f953a = str;
        this.b = map;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0533qb
    public final void a(InterfaceC0557rb interfaceC0557rb) {
        interfaceC0557rb.reportEvent(this.f953a, this.b);
    }
}
