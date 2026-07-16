package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.x3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0705x3 implements Hg {

    /* renamed from: a  reason: collision with root package name */
    public final Hg f1276a;
    public final InterfaceC0718xg b;
    public boolean c;
    public final ArrayList d = new ArrayList();
    public final Object e = new Object();

    public C0705x3(Hg hg, InterfaceC0718xg interfaceC0718xg) {
        this.f1276a = hg;
        this.b = interfaceC0718xg;
    }

    @Override // io.appmetrica.analytics.impl.Hg
    public final String a() {
        return this.f1276a.a();
    }

    public final void b() {
        synchronized (this.e) {
            if (this.c) {
                return;
            }
            this.c = true;
            if (((fp) this.b).c()) {
                return;
            }
            Unit unit = Unit.INSTANCE;
            try {
                this.f1276a.a(new Dg() { // from class: io.appmetrica.analytics.impl.x3$$ExternalSyntheticLambda0
                    @Override // io.appmetrica.analytics.impl.Dg
                    public final void a(Lg lg) {
                        C0705x3.a(C0705x3.this, lg);
                    }
                });
            } catch (Throwable th) {
                a(new Jg("Failed to request referrer", th));
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Hg
    public final void a(Dg dg) {
        Lg lg;
        synchronized (this.e) {
            lg = null;
            if (((fp) this.b).c()) {
                Lg b = ((fp) this.b).b();
                if (b == null) {
                    b = new Jg("Referrer is null", null, 2, null);
                }
                lg = b;
            } else {
                this.d.add(dg);
            }
        }
        if (lg != null) {
            dg.a(lg);
        }
        b();
    }

    public static final void a(C0705x3 c0705x3, Lg lg) {
        synchronized (c0705x3.e) {
            ((fp) c0705x3.b).a(lg);
            Unit unit = Unit.INSTANCE;
        }
        c0705x3.a(lg);
    }

    public final void a(Lg lg) {
        List<Dg> list;
        synchronized (this.e) {
            list = CollectionsKt.toList(this.d);
            this.d.clear();
        }
        for (Dg dg : list) {
            dg.a(lg);
        }
    }
}
