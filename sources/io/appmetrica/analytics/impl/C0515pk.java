package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.pk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0515pk implements InterfaceC0480ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1152a;
    public final /* synthetic */ Map b;

    public C0515pk(String str, Map map) {
        this.f1152a = str;
        this.b = map;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0480ob
    public final void a(InterfaceC0506pb interfaceC0506pb) {
        interfaceC0506pb.reportEvent(this.f1152a, this.b);
    }
}
