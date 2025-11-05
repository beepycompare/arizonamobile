package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.HashSet;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.vg  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0651vg implements InterfaceC0502pg {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f1172a;
    public boolean b;
    public C0576sg c;

    public C0651vg() {
        this(C0620ua.k().u());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0502pg
    public final synchronized void a(C0576sg c0576sg) {
        if (c0576sg != null) {
            LoggerStorage.getMainPublicOrAnonymousLogger().info("Received referrer from source %s: %s", c0576sg.d.f1096a, c0576sg.f1114a);
        }
        this.c = c0576sg;
        this.b = true;
        Iterator it = this.f1172a.iterator();
        while (it.hasNext()) {
            ((InterfaceC0376kg) it.next()).a(this.c);
        }
        this.f1172a.clear();
    }

    public C0651vg(C0527qg c0527qg) {
        this.f1172a = new HashSet();
        c0527qg.a(new Bl(this));
        c0527qg.a();
    }

    public final synchronized void a(InterfaceC0376kg interfaceC0376kg) {
        this.f1172a.add(interfaceC0376kg);
        if (this.b) {
            interfaceC0376kg.a(this.c);
            this.f1172a.remove(interfaceC0376kg);
        }
    }
}
