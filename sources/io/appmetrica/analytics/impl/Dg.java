package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes4.dex */
public final class Dg implements InterfaceC0710xg {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f398a;
    public boolean b;
    public Ag c;

    public Dg() {
        this(Ia.j().t());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0710xg
    public final synchronized void a(Ag ag) {
        if (ag != null) {
            LoggerStorage.getMainPublicOrAnonymousLogger().info("Received referrer from source %s: %s", ag.d.f1172a, ag.f339a);
        }
        this.c = ag;
        this.b = true;
        Iterator it = this.f398a.iterator();
        while (it.hasNext()) {
            ((InterfaceC0585sg) it.next()).a(this.c);
        }
        this.f398a.clear();
    }

    public Dg(C0735yg c0735yg) {
        this.f398a = new HashSet();
        c0735yg.a(new C0715xl(this));
        c0735yg.a();
    }

    public final synchronized void a(InterfaceC0585sg interfaceC0585sg) {
        this.f398a.add(interfaceC0585sg);
        if (this.b) {
            interfaceC0585sg.a(this.c);
            this.f398a.remove(interfaceC0585sg);
        }
    }
}
