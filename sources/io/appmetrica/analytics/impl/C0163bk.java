package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.bk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0163bk implements InterfaceC0407lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f787a;
    public final /* synthetic */ Map b;

    public C0163bk(String str, Map map) {
        this.f787a = str;
        this.b = map;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0407lb
    public final void a(InterfaceC0432mb interfaceC0432mb) {
        interfaceC0432mb.reportEvent(this.f787a, this.b);
    }
}
