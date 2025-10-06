package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public abstract class V2 {

    /* renamed from: a  reason: collision with root package name */
    public final Zf f708a;
    public final InterfaceC0224eb b;

    public V2(Zf zf, InterfaceC0224eb interfaceC0224eb) {
        this.f708a = zf;
        this.b = interfaceC0224eb;
    }

    public final boolean a(C0478o6 c0478o6, U2 u2) {
        for (Object obj : ((C0656v9) this.f708a.a(c0478o6.d)).f1123a) {
            if (u2.a(obj, c0478o6)) {
                return true;
            }
        }
        return false;
    }

    public final Zf b() {
        return this.f708a;
    }

    public final InterfaceC0224eb a() {
        return this.b;
    }
}
