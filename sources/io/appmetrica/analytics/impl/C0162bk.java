package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.bk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0162bk implements InterfaceC0406lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f788a;
    public final /* synthetic */ Map b;

    public C0162bk(String str, Map map) {
        this.f788a = str;
        this.b = map;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0406lb
    public final void a(InterfaceC0431mb interfaceC0431mb) {
        interfaceC0431mb.reportEvent(this.f788a, this.b);
    }
}
