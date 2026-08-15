package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.ik  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0332ik implements InterfaceC0479ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f1039a;

    public C0332ik(Map map) {
        this.f1039a = map;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0479ob
    public final void a(InterfaceC0505pb interfaceC0505pb) {
        interfaceC0505pb.reportAnr(this.f1039a);
    }
}
