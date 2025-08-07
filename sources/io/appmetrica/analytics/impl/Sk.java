package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import okhttp3.internal.connection.RealConnection;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Sk {

    /* renamed from: a  reason: collision with root package name */
    public final C0575s5 f642a;
    public final Rk b;
    public final C0550r5 c;
    public final AbstractC0271g d;
    public final AbstractC0271g e;
    public Ek f;
    public int g = 0;

    public Sk(C0575s5 c0575s5, Rk rk, C0550r5 c0550r5, Ca ca, L2 l2) {
        this.f642a = c0575s5;
        this.c = c0550r5;
        this.d = ca;
        this.e = l2;
        this.b = rk;
    }

    public final synchronized long a() {
        Ek ek;
        ek = this.f;
        return ek == null ? RealConnection.IDLE_CONNECTION_HEALTHY_NS : ek.d - 1;
    }

    public final void b(Ek ek, C0402l6 c0402l6) {
        if (ek.g && ek.d > 0) {
            C0550r5 c0550r5 = this.c;
            C0402l6 a2 = C0402l6.a(c0402l6, EnumC0681wb.EVENT_TYPE_ALIVE);
            Uk uk = new Uk();
            uk.f675a = ek.d;
            uk.d = ek.c.f475a;
            long andIncrement = ek.f.getAndIncrement();
            Vk vk = ek.b;
            vk.a(Vk.g, Long.valueOf(ek.f.get()));
            vk.b();
            uk.b = andIncrement;
            uk.c = TimeUnit.MILLISECONDS.toSeconds(Math.max(ek.i - ek.e, ek.j));
            c0550r5.f1031a.n.a(a2, uk);
            if (ek.g) {
                ek.g = false;
                Vk vk2 = ek.b;
                vk2.a(Vk.i, Boolean.FALSE);
                vk2.b();
            }
        }
        PublicLogger publicLogger = this.f642a.m;
        int ordinal = ek.c.f475a.ordinal();
        if (ordinal == 0) {
            publicLogger.info("Finish foreground session", new Object[0]);
        } else if (ordinal == 1) {
            publicLogger.info("Finish background session", new Object[0]);
        }
        synchronized (ek) {
            Vk vk3 = ek.b;
            vk3.getClass();
            vk3.c = new Ab();
            vk3.b();
            ek.h = null;
        }
    }

    public final synchronized void c(C0402l6 c0402l6) {
        if (this.g == 0) {
            Ek b = this.d.b();
            if (a(b, c0402l6)) {
                this.f = b;
                this.g = 3;
            } else {
                Ek b2 = this.e.b();
                if (a(b2, c0402l6)) {
                    this.f = b2;
                    this.g = 2;
                } else {
                    this.f = null;
                    this.g = 1;
                }
            }
        }
        int a2 = AbstractC0228e8.a(this.g);
        if (a2 == 0) {
            this.f = a(c0402l6);
        } else if (a2 == 1) {
            b(this.f, c0402l6);
            this.f = a(c0402l6);
        } else if (a2 == 2) {
            if (a(this.f, c0402l6)) {
                Ek ek = this.f;
                long j = c0402l6.i;
                ek.i = j;
                Vk vk = ek.b;
                vk.a(Vk.d, Long.valueOf(j));
                vk.b();
            } else {
                this.f = a(c0402l6);
            }
        }
    }

    public final Ek a(C0402l6 c0402l6) {
        this.f642a.m.info("Start foreground session", new Object[0]);
        long j = c0402l6.i;
        AbstractC0271g abstractC0271g = this.d;
        Fk fk = new Fk(j, c0402l6.j);
        abstractC0271g.getClass();
        Ek a2 = abstractC0271g.a(fk);
        this.g = 3;
        ((F5) this.f642a.p).e();
        C0550r5 c0550r5 = this.c;
        c0550r5.f1031a.n.a(C0402l6.a(c0402l6, Ia.F.h()), a(a2, j));
        return a2;
    }

    public static Uk a(Ek ek, long j) {
        Uk uk = new Uk();
        uk.f675a = ek.d;
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
        uk.d = ek.c.f475a;
        return uk;
    }

    public final synchronized Ek b(C0402l6 c0402l6) {
        if (this.g == 0) {
            Ek b = this.d.b();
            if (a(b, c0402l6)) {
                this.f = b;
                this.g = 3;
            } else {
                Ek b2 = this.e.b();
                if (a(b2, c0402l6)) {
                    this.f = b2;
                    this.g = 2;
                } else {
                    this.f = null;
                    this.g = 1;
                }
            }
        }
        if (this.g != 1 && !a(this.f, c0402l6)) {
            this.g = 1;
            this.f = null;
        }
        int a2 = AbstractC0228e8.a(this.g);
        if (a2 == 1) {
            Ek ek = this.f;
            long j = c0402l6.i;
            ek.i = j;
            Vk vk = ek.b;
            vk.a(Vk.d, Long.valueOf(j));
            vk.b();
            return this.f;
        } else if (a2 != 2) {
            this.f642a.m.info("Start background session", new Object[0]);
            this.g = 2;
            long j2 = c0402l6.i;
            AbstractC0271g abstractC0271g = this.e;
            Fk fk = new Fk(j2, c0402l6.j);
            abstractC0271g.getClass();
            Ek a3 = abstractC0271g.a(fk);
            if (this.f642a.t.c()) {
                C0550r5 c0550r5 = this.c;
                c0550r5.f1031a.n.a(C0402l6.a(c0402l6, Ia.F.h()), a(a3, c0402l6.i));
            } else {
                int i = c0402l6.d;
                EnumC0681wb enumC0681wb = EnumC0681wb.EVENT_TYPE_UNDEFINED;
                if (i == 6145) {
                    C0550r5 c0550r52 = this.c;
                    c0550r52.f1031a.n.a(c0402l6, a(a3, j2));
                    C0550r5 c0550r53 = this.c;
                    c0550r53.f1031a.n.a(C0402l6.a(c0402l6, Ia.F.h()), a(a3, j2));
                }
            }
            this.f = a3;
            return a3;
        } else {
            return this.f;
        }
    }

    public final boolean a(Ek ek, C0402l6 c0402l6) {
        boolean z;
        boolean z2;
        if (ek == null) {
            return false;
        }
        long j = c0402l6.i;
        boolean z3 = ek.d >= 0;
        if (ek.h == null) {
            synchronized (ek) {
                if (ek.h == null) {
                    try {
                        String asString = ek.f422a.e.a(ek.d, ek.c.f475a).getAsString("report_request_parameters");
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
        C0712xh c0712xh = (C0712xh) ek.f422a.k.a();
        Boolean[] boolArr = new Boolean[7];
        boolArr[0] = Boolean.valueOf(TextUtils.equals(c0712xh.getAnalyticsSdkVersionName(), tk.f657a));
        boolArr[1] = Boolean.valueOf(TextUtils.equals(c0712xh.getAnalyticsSdkBuildNumber(), tk.b));
        boolArr[2] = Boolean.valueOf(TextUtils.equals(c0712xh.getAppVersion(), tk.c));
        boolArr[3] = Boolean.valueOf(TextUtils.equals(c0712xh.getAppBuildNumber(), tk.d));
        boolArr[4] = Boolean.valueOf(TextUtils.equals(c0712xh.getOsVersion(), tk.e));
        boolArr[5] = Boolean.valueOf(tk.f == c0712xh.getOsApiLevel());
        boolArr[6] = Boolean.valueOf(tk.g == c0712xh.r);
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
            int i = ((C0712xh) ek.f422a.k.a()).f;
            Integer num = hk.d;
            if (num != null) {
                i = num.intValue();
            }
            if (j3 < timeUnit.toMillis(i) && j4 < timeUnit.toMillis(Ik.f493a)) {
                z2 = false;
                if (z3 || !z || z2) {
                    b(ek, c0402l6);
                    return false;
                }
                return true;
            }
        }
        z2 = true;
        if (z3) {
        }
        b(ek, c0402l6);
        return false;
    }
}
