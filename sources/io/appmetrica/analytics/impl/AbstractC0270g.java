package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.g  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0270g {

    /* renamed from: a  reason: collision with root package name */
    public final C0574s5 f855a;
    public final Rk b;
    public final Vk c;
    public final Qk d;
    public final InterfaceC0431mb e;
    public final SystemTimeProvider f;

    public AbstractC0270g(C0574s5 c0574s5, Rk rk, Vk vk, Qk qk, InterfaceC0431mb interfaceC0431mb, SystemTimeProvider systemTimeProvider) {
        this.f855a = c0574s5;
        this.b = rk;
        this.c = vk;
        this.d = qk;
        this.e = interfaceC0431mb;
        this.f = systemTimeProvider;
    }

    public final /* bridge */ Ek a(Object obj) {
        return a((Fk) obj);
    }

    public final Ek b() {
        if (this.c.h()) {
            return new Ek(this.f855a, this.c, a(), this.f);
        }
        return null;
    }

    public final Ek a(Fk fk) {
        if (this.c.h()) {
            this.e.reportEvent("create session with non-empty storage");
        }
        C0574s5 c0574s5 = this.f855a;
        Vk vk = this.c;
        long a2 = this.b.a();
        Vk vk2 = this.c;
        vk2.a(Vk.f, Long.valueOf(a2));
        vk2.a(Vk.d, Long.valueOf(fk.f440a));
        vk2.a(Vk.h, Long.valueOf(fk.f440a));
        vk2.a(Vk.g, 0L);
        vk2.a(Vk.i, Boolean.TRUE);
        vk2.b();
        this.f855a.e.a(a2, this.d.f615a, TimeUnit.MILLISECONDS.toSeconds(fk.b));
        return new Ek(c0574s5, vk, a(), new SystemTimeProvider());
    }

    public final Hk a() {
        Gk gk = new Gk(this.d);
        gk.g = this.c.i();
        gk.f = this.c.c.a(Vk.g);
        gk.d = this.c.c.a(Vk.h);
        gk.c = this.c.c.a(Vk.f);
        gk.h = this.c.c.a(Vk.d);
        gk.f458a = this.c.c.a(Vk.e);
        return new Hk(gk);
    }
}
