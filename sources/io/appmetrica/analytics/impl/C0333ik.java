package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.ik  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0333ik implements InterfaceC0480ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f1039a;

    public C0333ik(Map map) {
        this.f1039a = map;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0480ob
    public final void a(InterfaceC0506pb interfaceC0506pb) {
        interfaceC0506pb.reportAnr(this.f1039a);
    }
}
