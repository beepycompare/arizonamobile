package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.k9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0372k9 {

    /* renamed from: a  reason: collision with root package name */
    public final We f1084a;
    public final xo b;
    public final Rk c;
    public final L6 d;
    public final H8 e;
    public final Jk f;
    public final C0337j0 g;
    public final Z4 h;
    public final TimeProvider i;
    public final int j;
    public long k;
    public int l;

    public C0372k9(We we, xo xoVar, Rk rk, L6 l6, C0337j0 c0337j0, H8 h8, Jk jk, int i, Z4 z4, SystemTimeProvider systemTimeProvider) {
        this.f1084a = we;
        this.b = xoVar;
        this.c = rk;
        this.d = l6;
        this.g = c0337j0;
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
        p5.c(this.f1084a.j());
        p5.o = Integer.valueOf(this.b.b());
        C0312i0 a2 = this.g.a();
        H8 h8 = this.e;
        h8.getClass();
        EnumC0142bb a3 = EnumC0142bb.a(p5.d);
        L6 l6 = this.d;
        C0745z8 a4 = ((G8) h8.b.a(a3)).a(p5);
        int i = p5.d;
        xo xoVar = this.b;
        C0293h7 c0293h7 = new C0293h7(l6.g, tk, i, xoVar, a4, (C0380kh) l6.h.k.a(), a2);
        Long valueOf = Long.valueOf(tk.f807a);
        Vk vk = tk.d;
        Long valueOf2 = Long.valueOf(tk.b);
        EnumC0142bb a5 = EnumC0142bb.a(c0293h7.h.d);
        long j = 0;
        if (!AbstractC0671w9.g.contains(EnumC0142bb.a(i))) {
            synchronized (xoVar) {
                JSONObject a6 = xoVar.f1317a.a();
                optLong = a6.optLong("global_number", 0L);
                xoVar.f1317a.a(a6.put("global_number", optLong + 1));
            }
            j = optLong;
        }
        l6.a(l6.l.fromModel(new C0215e7(valueOf, vk, valueOf2, a5, Long.valueOf(j), Long.valueOf(tk.c), c0293h7.a())));
        this.h.f883a.h();
    }
}
