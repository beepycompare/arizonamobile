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
    public final C0691wf f525a;
    public final ap b;
    public final C0671vl c;
    public final C0166c7 d;
    public final C0142b9 e;
    public final C0438ml f;
    public final C0391l0 g;
    public final C0500p5 h;
    public final TimeProvider i;
    public final int j;
    public long k;
    public int l;

    public E9(C0691wf c0691wf, ap apVar, C0671vl c0671vl, C0166c7 c0166c7, C0391l0 c0391l0, C0142b9 c0142b9, C0438ml c0438ml, int i, C0500p5 c0500p5, SystemTimeProvider systemTimeProvider) {
        this.f525a = c0691wf;
        this.b = apVar;
        this.c = c0671vl;
        this.d = c0166c7;
        this.g = c0391l0;
        this.e = c0142b9;
        this.f = c0438ml;
        this.j = i;
        this.i = systemTimeProvider;
        this.h = c0500p5;
        this.k = c0691wf.i();
        this.l = c0691wf.h();
    }

    public final void a(C0242f6 c0242f6, C0749yl c0749yl) {
        long optLong;
        Map map = c0242f6.p;
        C0438ml c0438ml = this.f;
        c0438ml.getClass();
        map.putAll(new HashMap(c0438ml.b));
        c0242f6.c(this.f525a.j());
        c0242f6.o = Integer.valueOf(this.b.b());
        C0365k0 a2 = this.g.a();
        C0142b9 c0142b9 = this.e;
        c0142b9.getClass();
        Db a3 = Db.a(c0242f6.d);
        C0166c7 c0166c7 = this.d;
        S8 a4 = ((InterfaceC0116a9) c0142b9.b.a(a3)).a(c0242f6);
        int i = c0242f6.d;
        ap apVar = this.b;
        C0735y7 c0735y7 = new C0735y7(c0166c7.d, c0749yl, i, apVar, a4, (Eh) c0166c7.e.k.a(), a2);
        Long valueOf = Long.valueOf(c0749yl.f1300a);
        Al al = c0749yl.d;
        Long valueOf2 = Long.valueOf(c0749yl.b);
        Db a5 = Db.a(c0735y7.h.d);
        long j = 0;
        if (!Q9.g.contains(Db.a(i))) {
            synchronized (apVar) {
                JSONObject a6 = apVar.f894a.a();
                optLong = a6.optLong("global_number", 0L);
                apVar.f894a.a(a6.put("global_number", optLong + 1));
            }
            j = optLong;
        }
        ContentValues fromModel = c0166c7.i.fromModel(new C0657v7(valueOf, al, valueOf2, a5, Long.valueOf(j), Long.valueOf(c0749yl.c), c0735y7.a()));
        c0166c7.j.b.submit(fromModel, Eo.f534a.contains(Integer.valueOf(fromModel.getAsInteger("type").intValue())));
        this.h.f1142a.h();
    }
}
