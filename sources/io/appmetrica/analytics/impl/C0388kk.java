package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.kk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0388kk implements InterfaceC0534qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f958a;
    public final /* synthetic */ Map b;

    public C0388kk(String str, Map map) {
        this.f958a = str;
        this.b = map;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0534qb
    public final void a(InterfaceC0558rb interfaceC0558rb) {
        interfaceC0558rb.reportEvent(this.f958a, this.b);
    }
}
