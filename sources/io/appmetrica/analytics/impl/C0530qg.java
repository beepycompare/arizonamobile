package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.HashSet;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.qg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0530qg implements InterfaceC0380kg {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f1191a;
    public boolean b;
    public C0455ng c;

    public C0530qg() {
        this(C0449na.k().u());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0380kg
    public final synchronized void a(C0455ng c0455ng) {
        if (c0455ng != null) {
            LoggerStorage.getMainPublicOrAnonymousLogger().info("Received referrer from source %s: %s", c0455ng.d.f1119a, c0455ng.f1138a);
        }
        this.c = c0455ng;
        this.b = true;
        Iterator it = this.f1191a.iterator();
        while (it.hasNext()) {
            ((InterfaceC0251fg) it.next()).a(this.c);
        }
        this.f1191a.clear();
    }

    public C0530qg(C0405lg c0405lg) {
        this.f1191a = new HashSet();
        c0405lg.a(new C0709xl(this));
        c0405lg.a();
    }

    public final synchronized void a(InterfaceC0251fg interfaceC0251fg) {
        this.f1191a.add(interfaceC0251fg);
        if (this.b) {
            interfaceC0251fg.a(this.c);
            this.f1191a.remove(interfaceC0251fg);
        }
    }
}
