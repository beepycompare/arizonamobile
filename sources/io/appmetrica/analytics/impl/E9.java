package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class E9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0689wf f527a;
    public final ap b;
    public final C0669vl c;
    public final C0164c7 d;
    public final C0140b9 e;
    public final C0436ml f;
    public final C0389l0 g;
    public final C0498p5 h;
    public final TimeProvider i;
    public final int j;
    public long k;
    public int l;

    public E9(C0689wf c0689wf, ap apVar, C0669vl c0669vl, C0164c7 c0164c7, C0389l0 c0389l0, C0140b9 c0140b9, C0436ml c0436ml, int i, C0498p5 c0498p5, SystemTimeProvider systemTimeProvider) {
        this.f527a = c0689wf;
        this.b = apVar;
        this.c = c0669vl;
        this.d = c0164c7;
        this.g = c0389l0;
        this.e = c0140b9;
        this.f = c0436ml;
        this.j = i;
        this.i = systemTimeProvider;
        this.h = c0498p5;
        this.k = c0689wf.i();
        this.l = c0689wf.h();
    }

    public final void a(C0240f6 c0240f6, C0747yl c0747yl) {
        long optLong;
        Map map = c0240f6.p;
        C0436ml c0436ml = this.f;
        c0436ml.getClass();
        map.putAll(new HashMap(c0436ml.b));
        c0240f6.c(this.f527a.j());
        c0240f6.o = Integer.valueOf(this.b.b());
        C0363k0 a2 = this.g.a();
        C0140b9 c0140b9 = this.e;
        c0140b9.getClass();
        Db a3 = Db.a(c0240f6.d);
        C0164c7 c0164c7 = this.d;
        S8 a4 = ((InterfaceC0114a9) c0140b9.b.a(a3)).a(c0240f6);
        int i = c0240f6.d;
        ap apVar = this.b;
        C0733y7 c0733y7 = new C0733y7(c0164c7.d, c0747yl, i, apVar, a4, (Eh) c0164c7.e.k.a(), a2);
        Long valueOf = Long.valueOf(c0747yl.f1302a);
        Al al = c0747yl.d;
        Long valueOf2 = Long.valueOf(c0747yl.b);
        Db a5 = Db.a(c0733y7.h.d);
        long j = 0;
        if (!Q9.g.contains(Db.a(i))) {
            synchronized (apVar) {
                JSONObject a6 = apVar.f896a.a();
                optLong = a6.optLong("global_number", 0L);
                apVar.f896a.a(a6.put("global_number", optLong + 1));
            }
            j = optLong;
        }
        ContentValues fromModel = c0164c7.i.fromModel(new C0655v7(valueOf, al, valueOf2, a5, Long.valueOf(j), Long.valueOf(c0747yl.c), c0733y7.a()));
        c0164c7.j.b.submit(fromModel, Eo.f536a.contains(Integer.valueOf(fromModel.getAsInteger("type").intValue())));
        this.h.f1144a.h();
    }
}
