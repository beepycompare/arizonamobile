package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes4.dex */
public final class Mg implements Gg {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f574a;
    public boolean b;
    public Jg c;

    public Mg() {
        this(Na.j().t());
    }

    @Override // io.appmetrica.analytics.impl.Gg
    public final synchronized void a(Jg jg) {
        if (jg != null) {
            LoggerStorage.getMainPublicOrAnonymousLogger().info("Received referrer from source %s: %s", jg.d.f495a, jg.f515a);
        }
        this.c = jg;
        this.b = true;
        Iterator it = this.f574a.iterator();
        while (it.hasNext()) {
            ((Bg) it.next()).a(this.c);
        }
        this.f574a.clear();
    }

    public Mg(Hg hg) {
        this.f574a = new HashSet();
        hg.a(new Gl(this));
        hg.a();
    }

    public final synchronized void a(Bg bg) {
        this.f574a.add(bg);
        if (this.b) {
            bg.a(this.c);
            this.f574a.remove(bg);
        }
    }
}
