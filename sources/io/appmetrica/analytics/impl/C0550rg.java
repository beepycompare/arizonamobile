package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.HashSet;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.rg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0550rg implements InterfaceC0401lg {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f1201a;
    public boolean b;
    public C0476og c;

    public C0550rg() {
        this(C0470oa.k().u());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0401lg
    public final synchronized void a(C0476og c0476og) {
        if (c0476og != null) {
            LoggerStorage.getMainPublicOrAnonymousLogger().info("Received referrer from source %s: %s", c0476og.d.f1129a, c0476og.f1148a);
        }
        this.c = c0476og;
        this.b = true;
        Iterator it = this.f1201a.iterator();
        while (it.hasNext()) {
            ((InterfaceC0272gg) it.next()).a(this.c);
        }
        this.f1201a.clear();
    }

    public C0550rg(C0426mg c0426mg) {
        this.f1201a = new HashSet();
        c0426mg.a(new C0730yl(this));
        c0426mg.a();
    }

    public final synchronized void a(InterfaceC0272gg interfaceC0272gg) {
        this.f1201a.add(interfaceC0272gg);
        if (this.b) {
            interfaceC0272gg.a(this.c);
            this.f1201a.remove(interfaceC0272gg);
        }
    }
}
