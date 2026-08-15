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
    public final C0690wf f527a;
    public final ap b;
    public final C0670vl c;
    public final C0165c7 d;
    public final C0141b9 e;
    public final C0437ml f;
    public final C0390l0 g;
    public final C0499p5 h;
    public final TimeProvider i;
    public final int j;
    public long k;
    public int l;

    public E9(C0690wf c0690wf, ap apVar, C0670vl c0670vl, C0165c7 c0165c7, C0390l0 c0390l0, C0141b9 c0141b9, C0437ml c0437ml, int i, C0499p5 c0499p5, SystemTimeProvider systemTimeProvider) {
        this.f527a = c0690wf;
        this.b = apVar;
        this.c = c0670vl;
        this.d = c0165c7;
        this.g = c0390l0;
        this.e = c0141b9;
        this.f = c0437ml;
        this.j = i;
        this.i = systemTimeProvider;
        this.h = c0499p5;
        this.k = c0690wf.i();
        this.l = c0690wf.h();
    }

    public final void a(C0241f6 c0241f6, C0748yl c0748yl) {
        long optLong;
        Map map = c0241f6.p;
        C0437ml c0437ml = this.f;
        c0437ml.getClass();
        map.putAll(new HashMap(c0437ml.b));
        c0241f6.c(this.f527a.j());
        c0241f6.o = Integer.valueOf(this.b.b());
        C0364k0 a2 = this.g.a();
        C0141b9 c0141b9 = this.e;
        c0141b9.getClass();
        Db a3 = Db.a(c0241f6.d);
        C0165c7 c0165c7 = this.d;
        S8 a4 = ((InterfaceC0115a9) c0141b9.b.a(a3)).a(c0241f6);
        int i = c0241f6.d;
        ap apVar = this.b;
        C0734y7 c0734y7 = new C0734y7(c0165c7.d, c0748yl, i, apVar, a4, (Eh) c0165c7.e.k.a(), a2);
        Long valueOf = Long.valueOf(c0748yl.f1302a);
        Al al = c0748yl.d;
        Long valueOf2 = Long.valueOf(c0748yl.b);
        Db a5 = Db.a(c0734y7.h.d);
        long j = 0;
        if (!Q9.g.contains(Db.a(i))) {
            synchronized (apVar) {
                JSONObject a6 = apVar.f896a.a();
                optLong = a6.optLong("global_number", 0L);
                apVar.f896a.a(a6.put("global_number", optLong + 1));
            }
            j = optLong;
        }
        ContentValues fromModel = c0165c7.i.fromModel(new C0656v7(valueOf, al, valueOf2, a5, Long.valueOf(j), Long.valueOf(c0748yl.c), c0734y7.a()));
        c0165c7.j.b.submit(fromModel, Eo.f536a.contains(Integer.valueOf(fromModel.getAsInteger("type").intValue())));
        this.h.f1144a.h();
    }
}
