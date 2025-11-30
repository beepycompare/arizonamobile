package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.HashSet;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.rg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0551rg implements InterfaceC0402lg {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f1103a;
    public boolean b;
    public C0477og c;

    public C0551rg() {
        this(C0471oa.k().u());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0402lg
    public final synchronized void a(C0477og c0477og) {
        if (c0477og != null) {
            LoggerStorage.getMainPublicOrAnonymousLogger().info("Received referrer from source %s: %s", c0477og.d.f1031a, c0477og.f1050a);
        }
        this.c = c0477og;
        this.b = true;
        Iterator it = this.f1103a.iterator();
        while (it.hasNext()) {
            ((InterfaceC0273gg) it.next()).a(this.c);
        }
        this.f1103a.clear();
    }

    public C0551rg(C0427mg c0427mg) {
        this.f1103a = new HashSet();
        c0427mg.a(new C0731yl(this));
        c0427mg.a();
    }

    public final synchronized void a(InterfaceC0273gg interfaceC0273gg) {
        this.f1103a.add(interfaceC0273gg);
        if (this.b) {
            interfaceC0273gg.a(this.c);
            this.f1103a.remove(interfaceC0273gg);
        }
    }
}
