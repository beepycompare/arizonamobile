package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import okhttp3.internal.connection.RealConnection;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Sk {

    /* renamed from: a  reason: collision with root package name */
    public final Y4 f778a;
    public final Rk b;
    public final X4 c;
    public final AbstractC0255g d;
    public final AbstractC0255g e;
    public Ek f;
    public int g = 0;

    public Sk(Y4 y4, Rk rk, X4 x4, C0318ia c0318ia, A2 a2) {
        this.f778a = y4;
        this.c = x4;
        this.d = c0318ia;
        this.e = a2;
        this.b = rk;
    }

    public final synchronized long a() {
        Ek ek;
        ek = this.f;
        return ek == null ? RealConnection.IDLE_CONNECTION_HEALTHY_NS : ek.d - 1;
    }

    public final void b(Ek ek, Q5 q5) {
        if (ek.g && ek.d > 0) {
            X4 x4 = this.c;
            Q5 a2 = Q5.a(q5, EnumC0164cb.EVENT_TYPE_ALIVE);
            Uk uk = new Uk();
            uk.f811a = ek.d;
            uk.d = ek.c.f608a;
            long andIncrement = ek.f.getAndIncrement();
            Vk vk = ek.b;
            vk.a(Vk.g, Long.valueOf(ek.f.get()));
            vk.b();
            uk.b = andIncrement;
            uk.c = TimeUnit.MILLISECONDS.toSeconds(Math.max(ek.i - ek.e, ek.j));
            x4.f843a.n.a(a2, uk);
            if (ek.g) {
                ek.g = false;
                Vk vk2 = ek.b;
                vk2.a(Vk.i, Boolean.FALSE);
                vk2.b();
            }
        }
        PublicLogger publicLogger = this.f778a.m;
        int ordinal = ek.c.f608a.ordinal();
        if (ordinal == 0) {
            publicLogger.info("Finish foreground session", new Object[0]);
        } else if (ordinal == 1) {
            publicLogger.info("Finish background session", new Object[0]);
        }
        synchronized (ek) {
            Vk vk3 = ek.b;
            vk3.getClass();
            vk3.c = new C0267gb();
            vk3.b();
            ek.h = null;
        }
    }

    public final synchronized void c(Q5 q5) {
        if (this.g == 0) {
            Ek b = this.d.b();
            if (a(b, q5)) {
                this.f = b;
                this.g = 3;
            } else {
                Ek b2 = this.e.b();
                if (a(b2, q5)) {
                    this.f = b2;
                    this.g = 2;
                } else {
                    this.f = null;
                    this.g = 1;
                }
            }
        }
        int a2 = L7.a(this.g);
        if (a2 == 0) {
            this.f = a(q5);
        } else if (a2 == 1) {
            b(this.f, q5);
            this.f = a(q5);
        } else if (a2 == 2) {
            if (a(this.f, q5)) {
                Ek ek = this.f;
                long j = q5.i;
                ek.i = j;
                Vk vk = ek.b;
                vk.a(Vk.d, Long.valueOf(j));
                vk.b();
            } else {
                this.f = a(q5);
            }
        }
    }

    public final Ek a(Q5 q5) {
        this.f778a.m.info("Start foreground session", new Object[0]);
        long j = q5.i;
        AbstractC0255g abstractC0255g = this.d;
        Fk fk = new Fk(j, q5.j);
        abstractC0255g.getClass();
        Ek a2 = abstractC0255g.a(fk);
        this.g = 3;
        ((C0390l5) this.f778a.p).e();
        X4 x4 = this.c;
        x4.f843a.n.a(Q5.a(q5, C0470oa.I.i()), a(a2, j));
        return a2;
    }

    public static Uk a(Ek ek, long j) {
        Uk uk = new Uk();
        uk.f811a = ek.d;
        long andIncrement = ek.f.getAndIncrement();
        Vk vk = ek.b;
        vk.a(Vk.g, Long.valueOf(ek.f.get()));
        vk.b();
        uk.b = andIncrement;
        Vk vk2 = ek.b;
        long j2 = j - ek.e;
        ek.j = j2;
        vk2.a(Vk.e, Long.valueOf(j2));
        uk.c = TimeUnit.MILLISECONDS.toSeconds(ek.j);
        uk.d = ek.c.f608a;
        return uk;
    }

    public final synchronized Ek b(Q5 q5) {
        if (this.g == 0) {
            Ek b = this.d.b();
            if (a(b, q5)) {
                this.f = b;
                this.g = 3;
            } else {
                Ek b2 = this.e.b();
                if (a(b2, q5)) {
                    this.f = b2;
                    this.g = 2;
                } else {
                    this.f = null;
                    this.g = 1;
                }
            }
        }
        if (this.g != 1 && !a(this.f, q5)) {
            this.g = 1;
            this.f = null;
        }
        int a2 = L7.a(this.g);
        if (a2 == 1) {
            Ek ek = this.f;
            long j = q5.i;
            ek.i = j;
            Vk vk = ek.b;
            vk.a(Vk.d, Long.valueOf(j));
            vk.b();
            return this.f;
        } else if (a2 != 2) {
            this.f778a.m.info("Start background session", new Object[0]);
            this.g = 2;
            long j2 = q5.i;
            AbstractC0255g abstractC0255g = this.e;
            Fk fk = new Fk(j2, q5.j);
            abstractC0255g.getClass();
            Ek a3 = abstractC0255g.a(fk);
            if (this.f778a.t.c()) {
                X4 x4 = this.c;
                x4.f843a.n.a(Q5.a(q5, C0470oa.I.i()), a(a3, q5.i));
            } else {
                int i = q5.d;
                EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
                if (i == 6145) {
                    X4 x42 = this.c;
                    x42.f843a.n.a(q5, a(a3, j2));
                    X4 x43 = this.c;
                    x43.f843a.n.a(Q5.a(q5, C0470oa.I.i()), a(a3, j2));
                }
            }
            this.f = a3;
            return a3;
        } else {
            return this.f;
        }
    }

    public final boolean a(Ek ek, Q5 q5) {
        boolean z;
        boolean z2;
        if (ek == null) {
            return false;
        }
        long j = q5.i;
        boolean z3 = ek.d >= 0;
        if (ek.h == null) {
            synchronized (ek) {
                if (ek.h == null) {
                    try {
                        String asString = ek.f562a.e.a(ek.d, ek.c.f608a).getAsString("report_request_parameters");
                        if (!TextUtils.isEmpty(asString)) {
                            ek.h = new Tk(new JSONObject(asString));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        Tk tk = ek.h;
        if (tk == null) {
            z = false;
            break;
        }
        C0402lh c0402lh = (C0402lh) ek.f562a.k.a();
        Boolean[] boolArr = new Boolean[7];
        boolArr[0] = Boolean.valueOf(TextUtils.equals(c0402lh.getAnalyticsSdkVersionName(), tk.f794a));
        boolArr[1] = Boolean.valueOf(TextUtils.equals(c0402lh.getAnalyticsSdkBuildNumber(), tk.b));
        boolArr[2] = Boolean.valueOf(TextUtils.equals(c0402lh.getAppVersion(), tk.c));
        boolArr[3] = Boolean.valueOf(TextUtils.equals(c0402lh.getAppBuildNumber(), tk.d));
        boolArr[4] = Boolean.valueOf(TextUtils.equals(c0402lh.getOsVersion(), tk.e));
        boolArr[5] = Boolean.valueOf(tk.f == c0402lh.getOsApiLevel());
        boolArr[6] = Boolean.valueOf(tk.g == c0402lh.r);
        List<Boolean> listOf = CollectionsKt.listOf((Object[]) boolArr);
        if (!(listOf instanceof Collection) || !listOf.isEmpty()) {
            for (Boolean bool : listOf) {
                if (!bool.booleanValue()) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        long elapsedRealtime = ek.k.elapsedRealtime();
        long j2 = ek.i;
        boolean z4 = elapsedRealtime < j2;
        long j3 = j - j2;
        long j4 = j - ek.e;
        if (!z4) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Hk hk = ek.c;
            int i = ((C0402lh) ek.f562a.k.a()).f;
            Integer num = hk.d;
            if (num != null) {
                i = num.intValue();
            }
            if (j3 < timeUnit.toMillis(i) && j4 < timeUnit.toMillis(Ik.f625a)) {
                z2 = false;
                if (z3 || !z || z2) {
                    b(ek, q5);
                    return false;
                }
                return true;
            }
        }
        z2 = true;
        if (z3) {
        }
        b(ek, q5);
        return false;
    }
}
