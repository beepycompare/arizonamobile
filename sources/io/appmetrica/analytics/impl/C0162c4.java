package io.appmetrica.analytics.impl;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.c4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0162c4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0113a7 f930a;
    public C0574sb b;
    public C0599tb c;
    public Zb d;

    public C0162c4(File file) {
        this.f930a = new C0113a7(file);
    }

    public final synchronized Ha a(Context context) {
        C0599tb c0599tb;
        c0599tb = this.c;
        if (c0599tb == null) {
            c0599tb = new C0599tb(c(context));
            this.c = c0599tb;
        }
        return c0599tb;
    }

    public final synchronized Ha b(Context context) {
        return c(context);
    }

    public final Ha c(Context context) {
        Zb zb;
        C0574sb c0574sb = this.b;
        if (c0574sb == null) {
            synchronized (this) {
                zb = this.d;
                if (zb == null) {
                    C0113a7 c0113a7 = this.f930a;
                    String a2 = new Z6(c0113a7.f901a, c0113a7.b, true).a(context, new N3());
                    M6 m6 = AbstractC0668w5.c;
                    m6.getClass();
                    HashMap hashMap = new HashMap();
                    hashMap.put("preferences", InterfaceC0593t5.f1231a);
                    C0310hn c0310hn = m6.c;
                    W6 w6 = m6.f688a;
                    S6 s6 = w6.c;
                    T6 t6 = w6.d;
                    C0499pa c0499pa = new C0499pa(false);
                    c0499pa.a(112, new O3());
                    C0387kn c0387kn = new C0387kn("service database", hashMap);
                    c0310hn.getClass();
                    zb = new Zb(context, a2, new Y9(a2), new C0335in(s6, t6, c0499pa, c0387kn));
                    this.d = zb;
                }
            }
            C0574sb c0574sb2 = new C0574sb(zb);
            this.b = c0574sb2;
            return c0574sb2;
        }
        return c0574sb;
    }
}
