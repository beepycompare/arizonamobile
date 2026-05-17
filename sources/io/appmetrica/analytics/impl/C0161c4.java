package io.appmetrica.analytics.impl;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.c4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0161c4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0112a7 f934a;
    public C0573sb b;
    public C0598tb c;
    public Zb d;

    public C0161c4(File file) {
        this.f934a = new C0112a7(file);
    }

    public final synchronized Ha a(Context context) {
        C0598tb c0598tb;
        c0598tb = this.c;
        if (c0598tb == null) {
            c0598tb = new C0598tb(c(context));
            this.c = c0598tb;
        }
        return c0598tb;
    }

    public final synchronized Ha b(Context context) {
        return c(context);
    }

    public final Ha c(Context context) {
        Zb zb;
        C0573sb c0573sb = this.b;
        if (c0573sb == null) {
            synchronized (this) {
                zb = this.d;
                if (zb == null) {
                    C0112a7 c0112a7 = this.f934a;
                    String a2 = new Z6(c0112a7.f905a, c0112a7.b, true).a(context, new N3());
                    M6 m6 = AbstractC0667w5.c;
                    m6.getClass();
                    HashMap hashMap = new HashMap();
                    hashMap.put("preferences", InterfaceC0592t5.f1235a);
                    C0309hn c0309hn = m6.c;
                    W6 w6 = m6.f692a;
                    S6 s6 = w6.c;
                    T6 t6 = w6.d;
                    C0498pa c0498pa = new C0498pa(false);
                    c0498pa.a(112, new O3());
                    C0386kn c0386kn = new C0386kn("service database", hashMap);
                    c0309hn.getClass();
                    zb = new Zb(context, a2, new Y9(a2), new C0334in(s6, t6, c0498pa, c0386kn));
                    this.d = zb;
                }
            }
            C0573sb c0573sb2 = new C0573sb(zb);
            this.b = c0573sb2;
            return c0573sb2;
        }
        return c0573sb;
    }
}
