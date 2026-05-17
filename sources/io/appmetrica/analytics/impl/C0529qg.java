package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.HashSet;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.qg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0529qg implements InterfaceC0379kg {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f1195a;
    public boolean b;
    public C0454ng c;

    public C0529qg() {
        this(C0448na.k().u());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0379kg
    public final synchronized void a(C0454ng c0454ng) {
        if (c0454ng != null) {
            LoggerStorage.getMainPublicOrAnonymousLogger().info("Received referrer from source %s: %s", c0454ng.d.f1123a, c0454ng.f1142a);
        }
        this.c = c0454ng;
        this.b = true;
        Iterator it = this.f1195a.iterator();
        while (it.hasNext()) {
            ((InterfaceC0250fg) it.next()).a(this.c);
        }
        this.f1195a.clear();
    }

    public C0529qg(C0404lg c0404lg) {
        this.f1195a = new HashSet();
        c0404lg.a(new C0708xl(this));
        c0404lg.a();
    }

    public final synchronized void a(InterfaceC0250fg interfaceC0250fg) {
        this.f1195a.add(interfaceC0250fg);
        if (this.b) {
            interfaceC0250fg.a(this.c);
            this.f1195a.remove(interfaceC0250fg);
        }
    }
}
