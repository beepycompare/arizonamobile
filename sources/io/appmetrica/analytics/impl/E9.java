package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class E9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0684wf f530a;
    public final ap b;
    public final C0664vl c;
    public final C0159c7 d;
    public final C0135b9 e;
    public final C0431ml f;
    public final C0384l0 g;
    public final C0493p5 h;
    public final TimeProvider i;
    public final int j;
    public long k;
    public int l;

    public E9(C0684wf c0684wf, ap apVar, C0664vl c0664vl, C0159c7 c0159c7, C0384l0 c0384l0, C0135b9 c0135b9, C0431ml c0431ml, int i, C0493p5 c0493p5, SystemTimeProvider systemTimeProvider) {
        this.f530a = c0684wf;
        this.b = apVar;
        this.c = c0664vl;
        this.d = c0159c7;
        this.g = c0384l0;
        this.e = c0135b9;
        this.f = c0431ml;
        this.j = i;
        this.i = systemTimeProvider;
        this.h = c0493p5;
        this.k = c0684wf.i();
        this.l = c0684wf.h();
    }

    public final void a(C0235f6 c0235f6, C0742yl c0742yl) {
        long optLong;
        Map map = c0235f6.p;
        C0431ml c0431ml = this.f;
        c0431ml.getClass();
        map.putAll(new HashMap(c0431ml.b));
        c0235f6.c(this.f530a.j());
        c0235f6.o = Integer.valueOf(this.b.b());
        C0358k0 a2 = this.g.a();
        C0135b9 c0135b9 = this.e;
        c0135b9.getClass();
        Db a3 = Db.a(c0235f6.d);
        C0159c7 c0159c7 = this.d;
        S8 a4 = ((InterfaceC0109a9) c0135b9.b.a(a3)).a(c0235f6);
        int i = c0235f6.d;
        ap apVar = this.b;
        C0728y7 c0728y7 = new C0728y7(c0159c7.d, c0742yl, i, apVar, a4, (Eh) c0159c7.e.k.a(), a2);
        Long valueOf = Long.valueOf(c0742yl.f1305a);
        Al al = c0742yl.d;
        Long valueOf2 = Long.valueOf(c0742yl.b);
        Db a5 = Db.a(c0728y7.h.d);
        long j = 0;
        if (!Q9.g.contains(Db.a(i))) {
            synchronized (apVar) {
                JSONObject a6 = apVar.f899a.a();
                optLong = a6.optLong("global_number", 0L);
                apVar.f899a.a(a6.put("global_number", optLong + 1));
            }
            j = optLong;
        }
        ContentValues fromModel = c0159c7.i.fromModel(new C0650v7(valueOf, al, valueOf2, a5, Long.valueOf(j), Long.valueOf(c0742yl.c), c0728y7.a()));
        c0159c7.j.b.submit(fromModel, Eo.f539a.contains(Integer.valueOf(fromModel.getAsInteger(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY).intValue())));
        this.h.f1147a.h();
    }
}
