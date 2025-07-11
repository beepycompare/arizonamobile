package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes4.dex */
public final class Bg implements InterfaceC0658vg {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f357a;
    public boolean b;
    public C0733yg c;

    public Bg() {
        this(Ga.j().t());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0658vg
    public final synchronized void a(C0733yg c0733yg) {
        if (c0733yg != null) {
            LoggerStorage.getMainPublicOrAnonymousLogger().info("Received referrer from source %s: %s", c0733yg.d.f1127a, c0733yg.f1147a);
        }
        this.c = c0733yg;
        this.b = true;
        Iterator it = this.f357a.iterator();
        while (it.hasNext()) {
            ((InterfaceC0534qg) it.next()).a(this.c);
        }
        this.f357a.clear();
    }

    public Bg(C0683wg c0683wg) {
        this.f357a = new HashSet();
        c0683wg.a(new C0638ul(this));
        c0683wg.a();
    }

    public final synchronized void a(InterfaceC0534qg interfaceC0534qg) {
        this.f357a.add(interfaceC0534qg);
        if (this.b) {
            interfaceC0534qg.a(this.c);
            this.f357a.remove(interfaceC0534qg);
        }
    }
}
