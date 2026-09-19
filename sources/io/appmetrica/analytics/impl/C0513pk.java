package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.pk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0513pk implements InterfaceC0478ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1152a;
    public final /* synthetic */ Map b;

    public C0513pk(String str, Map map) {
        this.f1152a = str;
        this.b = map;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0478ob
    public final void a(InterfaceC0504pb interfaceC0504pb) {
        interfaceC0504pb.reportEvent(this.f1152a, this.b);
    }
}
