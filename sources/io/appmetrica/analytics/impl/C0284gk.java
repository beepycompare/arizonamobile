package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.gk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0284gk implements InterfaceC0454nb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f875a;
    public final /* synthetic */ Map b;

    public C0284gk(String str, Map map) {
        this.f875a = str;
        this.b = map;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0454nb
    public final void a(InterfaceC0479ob interfaceC0479ob) {
        interfaceC0479ob.reportEvent(this.f875a, this.b);
    }
}
