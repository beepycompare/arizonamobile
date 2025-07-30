package io.appmetrica.analytics.impl;

import java.util.Map;
/* loaded from: classes4.dex */
public final class Uj implements InterfaceC0406lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f675a;

    public Uj(Map map) {
        this.f675a = map;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0406lb
    public final void a(InterfaceC0431mb interfaceC0431mb) {
        interfaceC0431mb.reportAnr(this.f675a);
    }
}
