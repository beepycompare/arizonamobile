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
public final class Xk {

    /* renamed from: a  reason: collision with root package name */
    public final C0572s5 f729a;
    public final Wk b;
    public final C0547r5 c;
    public final AbstractC0263g d;
    public final AbstractC0263g e;
    public Jk f;
    public int g = 0;

    public Xk(C0572s5 c0572s5, Wk wk, C0547r5 c0547r5, Ea ea, L2 l2) {
        this.f729a = c0572s5;
        this.c = c0547r5;
        this.d = ea;
        this.e = l2;
        this.b = wk;
    }

    public final synchronized long a() {
        Jk jk;
        jk = this.f;
        return jk == null ? RealConnection.IDLE_CONNECTION_HEALTHY_NS : jk.d - 1;
    }

    public final void b(Jk jk, C0399l6 c0399l6) {
        if (jk.g && jk.d > 0) {
            C0547r5 c0547r5 = this.c;
            C0399l6 a2 = C0399l6.a(c0399l6, EnumC0728yb.EVENT_TYPE_ALIVE);
            Zk zk = new Zk();
            zk.f763a = jk.d;
            zk.d = jk.c.f564a;
            long andIncrement = jk.f.getAndIncrement();
            C0130al c0130al = jk.b;
            c0130al.a(C0130al.g, Long.valueOf(jk.f.get()));
            c0130al.b();
            zk.b = andIncrement;
            zk.c = TimeUnit.MILLISECONDS.toSeconds(Math.max(jk.i - jk.e, jk.j));
            c0547r5.f1039a.n.a(a2, zk);
            if (jk.g) {
                jk.g = false;
                C0130al c0130al2 = jk.b;
                c0130al2.a(C0130al.i, Boolean.FALSE);
                c0130al2.b();
            }
        }
        PublicLogger publicLogger = this.f729a.m;
        int ordinal = jk.c.f564a.ordinal();
        if (ordinal == 0) {
            publicLogger.info("Finish foreground session", new Object[0]);
        } else if (ordinal == 1) {
            publicLogger.info("Finish background session", new Object[0]);
        }
        synchronized (jk) {
            C0130al c0130al3 = jk.b;
            c0130al3.getClass();
            c0130al3.c = new Cb();
            c0130al3.b();
            jk.h = null;
        }
    }

    public final synchronized void c(C0399l6 c0399l6) {
        if (this.g == 0) {
            Jk b = this.d.b();
            if (a(b, c0399l6)) {
                this.f = b;
                this.g = 3;
            } else {
                Jk b2 = this.e.b();
                if (a(b2, c0399l6)) {
                    this.f = b2;
                    this.g = 2;
                } else {
                    this.f = null;
                    this.g = 1;
                }
            }
        }
        int a2 = AbstractC0246f8.a(this.g);
        if (a2 == 0) {
            this.f = a(c0399l6);
        } else if (a2 == 1) {
            b(this.f, c0399l6);
            this.f = a(c0399l6);
        } else if (a2 == 2) {
            if (a(this.f, c0399l6)) {
                Jk jk = this.f;
                long j = c0399l6.i;
                jk.i = j;
                C0130al c0130al = jk.b;
                c0130al.a(C0130al.d, Long.valueOf(j));
                c0130al.b();
            } else {
                this.f = a(c0399l6);
            }
        }
    }

    public final Jk a(C0399l6 c0399l6) {
        this.f729a.m.info("Start foreground session", new Object[0]);
        long j = c0399l6.i;
        AbstractC0263g abstractC0263g = this.d;
        Kk kk = new Kk(j, c0399l6.j);
        abstractC0263g.getClass();
        Jk a2 = abstractC0263g.a(kk);
        this.g = 3;
        ((F5) this.f729a.p).e();
        C0547r5 c0547r5 = this.c;
        c0547r5.f1039a.n.a(C0399l6.a(c0399l6, Ka.F.h()), a(a2, j));
        return a2;
    }

    public static Zk a(Jk jk, long j) {
        Zk zk = new Zk();
        zk.f763a = jk.d;
        long andIncrement = jk.f.getAndIncrement();
        C0130al c0130al = jk.b;
        c0130al.a(C0130al.g, Long.valueOf(jk.f.get()));
        c0130al.b();
        zk.b = andIncrement;
        C0130al c0130al2 = jk.b;
        long j2 = j - jk.e;
        jk.j = j2;
        c0130al2.a(C0130al.e, Long.valueOf(j2));
        zk.c = TimeUnit.MILLISECONDS.toSeconds(jk.j);
        zk.d = jk.c.f564a;
        return zk;
    }

    public final synchronized Jk b(C0399l6 c0399l6) {
        if (this.g == 0) {
            Jk b = this.d.b();
            if (a(b, c0399l6)) {
                this.f = b;
                this.g = 3;
            } else {
                Jk b2 = this.e.b();
                if (a(b2, c0399l6)) {
                    this.f = b2;
                    this.g = 2;
                } else {
                    this.f = null;
                    this.g = 1;
                }
            }
        }
        if (this.g != 1 && !a(this.f, c0399l6)) {
            this.g = 1;
            this.f = null;
        }
        int a2 = AbstractC0246f8.a(this.g);
        if (a2 == 1) {
            Jk jk = this.f;
            long j = c0399l6.i;
            jk.i = j;
            C0130al c0130al = jk.b;
            c0130al.a(C0130al.d, Long.valueOf(j));
            c0130al.b();
            return this.f;
        } else if (a2 != 2) {
            this.f729a.m.info("Start background session", new Object[0]);
            this.g = 2;
            long j2 = c0399l6.i;
            AbstractC0263g abstractC0263g = this.e;
            Kk kk = new Kk(j2, c0399l6.j);
            abstractC0263g.getClass();
            Jk a3 = abstractC0263g.a(kk);
            if (this.f729a.t.c()) {
                C0547r5 c0547r5 = this.c;
                c0547r5.f1039a.n.a(C0399l6.a(c0399l6, Ka.F.h()), a(a3, c0399l6.i));
            } else {
                int i = c0399l6.d;
                EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
                if (i == 6145) {
                    C0547r5 c0547r52 = this.c;
                    c0547r52.f1039a.n.a(c0399l6, a(a3, j2));
                    C0547r5 c0547r53 = this.c;
                    c0547r53.f1039a.n.a(C0399l6.a(c0399l6, Ka.F.h()), a(a3, j2));
                }
            }
            this.f = a3;
            return a3;
        } else {
            return this.f;
        }
    }

    public final boolean a(Jk jk, C0399l6 c0399l6) {
        boolean z;
        boolean z2;
        if (jk == null) {
            return false;
        }
        long j = c0399l6.i;
        boolean z3 = jk.d >= 0;
        if (jk.h == null) {
            synchronized (jk) {
                if (jk.h == null) {
                    try {
                        String asString = jk.f519a.e.a(jk.d, jk.c.f564a).getAsString("report_request_parameters");
                        if (!TextUtils.isEmpty(asString)) {
                            jk.h = new Yk(new JSONObject(asString));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        Yk yk = jk.h;
        if (yk == null) {
            z = false;
            break;
        }
        Ch ch = (Ch) jk.f519a.k.a();
        Boolean[] boolArr = new Boolean[7];
        boolArr[0] = Boolean.valueOf(TextUtils.equals(ch.getAnalyticsSdkVersionName(), yk.f746a));
        boolArr[1] = Boolean.valueOf(TextUtils.equals(ch.getAnalyticsSdkBuildNumber(), yk.b));
        boolArr[2] = Boolean.valueOf(TextUtils.equals(ch.getAppVersion(), yk.c));
        boolArr[3] = Boolean.valueOf(TextUtils.equals(ch.getAppBuildNumber(), yk.d));
        boolArr[4] = Boolean.valueOf(TextUtils.equals(ch.getOsVersion(), yk.e));
        boolArr[5] = Boolean.valueOf(yk.f == ch.getOsApiLevel());
        boolArr[6] = Boolean.valueOf(yk.g == ch.r);
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
        long elapsedRealtime = jk.k.elapsedRealtime();
        long j2 = jk.i;
        boolean z4 = elapsedRealtime < j2;
        long j3 = j - j2;
        long j4 = j - jk.e;
        if (!z4) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Mk mk = jk.c;
            int i = ((Ch) jk.f519a.k.a()).f;
            Integer num = mk.d;
            if (num != null) {
                i = num.intValue();
            }
            if (j3 < timeUnit.toMillis(i) && j4 < timeUnit.toMillis(Nk.f582a)) {
                z2 = false;
                if (z3 || !z || z2) {
                    b(jk, c0399l6);
                    return false;
                }
                return true;
            }
        }
        z2 = true;
        if (z3) {
        }
        b(jk, c0399l6);
        return false;
    }
}
