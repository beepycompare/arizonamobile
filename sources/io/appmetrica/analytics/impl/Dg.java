package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes4.dex */
public final class Dg implements InterfaceC0711xg {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f398a;
    public boolean b;
    public Ag c;

    public Dg() {
        this(Ia.j().t());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0711xg
    public final synchronized void a(Ag ag) {
        if (ag != null) {
            LoggerStorage.getMainPublicOrAnonymousLogger().info("Received referrer from source %s: %s", ag.d.f1172a, ag.f339a);
        }
        this.c = ag;
        this.b = true;
        Iterator it = this.f398a.iterator();
        while (it.hasNext()) {
            ((InterfaceC0586sg) it.next()).a(this.c);
        }
        this.f398a.clear();
    }

    public Dg(C0736yg c0736yg) {
        this.f398a = new HashSet();
        c0736yg.a(new C0716xl(this));
        c0736yg.a();
    }

    public final synchronized void a(InterfaceC0586sg interfaceC0586sg) {
        this.f398a.add(interfaceC0586sg);
        if (this.b) {
            interfaceC0586sg.a(this.c);
            this.f398a.remove(interfaceC0586sg);
        }
    }
}
