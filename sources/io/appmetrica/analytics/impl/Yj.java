package io.appmetrica.analytics.impl;

import java.util.Map;
/* loaded from: classes4.dex */
public final class Yj implements InterfaceC0354jb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f726a;
    public final /* synthetic */ Map b;

    public Yj(String str, Map map) {
        this.f726a = str;
        this.b = map;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0354jb
    public final void a(InterfaceC0379kb interfaceC0379kb) {
        interfaceC0379kb.reportEvent(this.f726a, this.b);
    }
}
