package io.appmetrica.analytics.impl;

import java.util.Map;
/* loaded from: classes4.dex */
public final class Uj implements InterfaceC0407lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f674a;

    public Uj(Map map) {
        this.f674a = map;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0407lb
    public final void a(InterfaceC0432mb interfaceC0432mb) {
        interfaceC0432mb.reportAnr(this.f674a);
    }
}
