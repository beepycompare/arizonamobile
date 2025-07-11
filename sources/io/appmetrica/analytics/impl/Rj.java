package io.appmetrica.analytics.impl;

import java.util.Map;
/* loaded from: classes4.dex */
public final class Rj implements InterfaceC0354jb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f614a;

    public Rj(Map map) {
        this.f614a = map;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0354jb
    public final void a(InterfaceC0379kb interfaceC0379kb) {
        interfaceC0379kb.reportAnr(this.f614a);
    }
}
