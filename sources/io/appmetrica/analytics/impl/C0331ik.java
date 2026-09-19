package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.ik  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0331ik implements InterfaceC0478ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f1039a;

    public C0331ik(Map map) {
        this.f1039a = map;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0478ob
    public final void a(InterfaceC0504pb interfaceC0504pb) {
        interfaceC0504pb.reportAnr(this.f1039a);
    }
}
