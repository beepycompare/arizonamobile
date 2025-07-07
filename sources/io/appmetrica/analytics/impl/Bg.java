package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes4.dex */
public final class Bg implements InterfaceC0666vg {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f356a;
    public boolean b;
    public C0741yg c;

    public Bg() {
        this(Ga.j().t());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0666vg
    public final synchronized void a(C0741yg c0741yg) {
        if (c0741yg != null) {
            LoggerStorage.getMainPublicOrAnonymousLogger().info("Received referrer from source %s: %s", c0741yg.d.f1126a, c0741yg.f1146a);
        }
        this.c = c0741yg;
        this.b = true;
        Iterator it = this.f356a.iterator();
        while (it.hasNext()) {
            ((InterfaceC0542qg) it.next()).a(this.c);
        }
        this.f356a.clear();
    }

    public Bg(C0691wg c0691wg) {
        this.f356a = new HashSet();
        c0691wg.a(new C0646ul(this));
        c0691wg.a();
    }

    public final synchronized void a(InterfaceC0542qg interfaceC0542qg) {
        this.f356a.add(interfaceC0542qg);
        if (this.b) {
            interfaceC0542qg.a(this.c);
            this.f356a.remove(interfaceC0542qg);
        }
    }
}
