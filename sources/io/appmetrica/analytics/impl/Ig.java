package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes4.dex */
public final class Ig implements Cg {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f498a;
    public boolean b;
    public Fg c;

    public Ig() {
        this(Ka.j().t());
    }

    @Override // io.appmetrica.analytics.impl.Cg
    public final synchronized void a(Fg fg) {
        if (fg != null) {
            LoggerStorage.getMainPublicOrAnonymousLogger().info("Received referrer from source %s: %s", fg.d.f415a, fg.f436a);
        }
        this.c = fg;
        this.b = true;
        Iterator it = this.f498a.iterator();
        while (it.hasNext()) {
            ((InterfaceC0708xg) it.next()).a(this.c);
        }
        this.f498a.clear();
    }

    public Ig(Dg dg) {
        this.f498a = new HashSet();
        dg.a(new Cl(this));
        dg.a();
    }

    public final synchronized void a(InterfaceC0708xg interfaceC0708xg) {
        this.f498a.add(interfaceC0708xg);
        if (this.b) {
            interfaceC0708xg.a(this.c);
            this.f498a.remove(interfaceC0708xg);
        }
    }
}
