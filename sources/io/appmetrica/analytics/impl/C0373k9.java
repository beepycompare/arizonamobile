package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.k9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0373k9 {

    /* renamed from: a  reason: collision with root package name */
    public final We f1079a;
    public final xo b;
    public final Rk c;
    public final L6 d;
    public final H8 e;
    public final Jk f;
    public final C0338j0 g;
    public final Z4 h;
    public final TimeProvider i;
    public final int j;
    public long k;
    public int l;

    public C0373k9(We we, xo xoVar, Rk rk, L6 l6, C0338j0 c0338j0, H8 h8, Jk jk, int i, Z4 z4, SystemTimeProvider systemTimeProvider) {
        this.f1079a = we;
        this.b = xoVar;
        this.c = rk;
        this.d = l6;
        this.g = c0338j0;
        this.e = h8;
        this.f = jk;
        this.j = i;
        this.i = systemTimeProvider;
        this.h = z4;
        this.k = we.i();
        this.l = we.h();
    }

    public final void a(P5 p5, Tk tk) {
        long optLong;
        Map map = p5.p;
        Jk jk = this.f;
        jk.getClass();
        map.putAll(new HashMap(jk.b));
        p5.c(this.f1079a.j());
        p5.o = Integer.valueOf(this.b.b());
        C0313i0 a2 = this.g.a();
        H8 h8 = this.e;
        h8.getClass();
        EnumC0143bb a3 = EnumC0143bb.a(p5.d);
        L6 l6 = this.d;
        C0746z8 a4 = ((G8) h8.b.a(a3)).a(p5);
        int i = p5.d;
        xo xoVar = this.b;
        C0294h7 c0294h7 = new C0294h7(l6.g, tk, i, xoVar, a4, (C0381kh) l6.h.k.a(), a2);
        Long valueOf = Long.valueOf(tk.f802a);
        Vk vk = tk.d;
        Long valueOf2 = Long.valueOf(tk.b);
        EnumC0143bb a5 = EnumC0143bb.a(c0294h7.h.d);
        long j = 0;
        if (!AbstractC0672w9.g.contains(EnumC0143bb.a(i))) {
            synchronized (xoVar) {
                JSONObject a6 = xoVar.f1312a.a();
                optLong = a6.optLong("global_number", 0L);
                xoVar.f1312a.a(a6.put("global_number", optLong + 1));
            }
            j = optLong;
        }
        l6.a(l6.l.fromModel(new C0216e7(valueOf, vk, valueOf2, a5, Long.valueOf(j), Long.valueOf(tk.c), c0294h7.a())));
        this.h.f878a.h();
    }
}
