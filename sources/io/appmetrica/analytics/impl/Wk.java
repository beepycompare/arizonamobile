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
public final class Wk {

    /* renamed from: a  reason: collision with root package name */
    public final C0210e5 f746a;
    public final Vk b;
    public final C0185d5 c;
    public final AbstractC0256g d;
    public final AbstractC0256g e;
    public Ik f;
    public int g = 0;

    public Wk(C0210e5 c0210e5, Vk vk, C0185d5 c0185d5, C0471oa c0471oa, H2 h2) {
        this.f746a = c0210e5;
        this.c = c0185d5;
        this.d = c0471oa;
        this.e = h2;
        this.b = vk;
    }

    public final synchronized long a() {
        Ik ik;
        ik = this.f;
        return ik == null ? RealConnection.IDLE_CONNECTION_HEALTHY_NS : ik.d - 1;
    }

    public final void b(Ik ik, W5 w5) {
        if (ik.g && ik.d > 0) {
            C0185d5 c0185d5 = this.c;
            W5 a2 = W5.a(w5, EnumC0320ib.EVENT_TYPE_ALIVE);
            Yk yk = new Yk();
            yk.f774a = ik.d;
            yk.d = ik.c.f579a;
            long andIncrement = ik.f.getAndIncrement();
            Zk zk = ik.b;
            zk.a(Zk.g, Long.valueOf(ik.f.get()));
            zk.b();
            yk.b = andIncrement;
            yk.c = TimeUnit.MILLISECONDS.toSeconds(Math.max(ik.i - ik.e, ik.j));
            c0185d5.f841a.n.a(a2, yk);
            if (ik.g) {
                ik.g = false;
                Zk zk2 = ik.b;
                zk2.a(Zk.i, Boolean.FALSE);
                zk2.b();
            }
        }
        PublicLogger publicLogger = this.f746a.m;
        int ordinal = ik.c.f579a.ordinal();
        if (ordinal == 0) {
            publicLogger.info("Finish foreground session", new Object[0]);
        } else if (ordinal == 1) {
            publicLogger.info("Finish background session", new Object[0]);
        }
        synchronized (ik) {
            Zk zk3 = ik.b;
            zk3.getClass();
            zk3.c = new C0422mb();
            zk3.b();
            ik.h = null;
        }
    }

    public final synchronized void c(W5 w5) {
        if (this.g == 0) {
            Ik b = this.d.b();
            if (a(b, w5)) {
                this.f = b;
                this.g = 3;
            } else {
                Ik b2 = this.e.b();
                if (a(b2, w5)) {
                    this.f = b2;
                    this.g = 2;
                } else {
                    this.f = null;
                    this.g = 1;
                }
            }
        }
        int a2 = Q7.a(this.g);
        if (a2 == 0) {
            this.f = a(w5);
        } else if (a2 == 1) {
            b(this.f, w5);
            this.f = a(w5);
        } else if (a2 == 2) {
            if (a(this.f, w5)) {
                Ik ik = this.f;
                long j = w5.i;
                ik.i = j;
                Zk zk = ik.b;
                zk.a(Zk.d, Long.valueOf(j));
                zk.b();
            } else {
                this.f = a(w5);
            }
        }
    }

    public final Ik a(W5 w5) {
        this.f746a.m.info("Start foreground session", new Object[0]);
        long j = w5.i;
        AbstractC0256g abstractC0256g = this.d;
        Jk jk = new Jk(j, w5.j);
        abstractC0256g.getClass();
        Ik a2 = abstractC0256g.a(jk);
        this.g = 3;
        ((C0540r5) this.f746a.p).e();
        C0185d5 c0185d5 = this.c;
        c0185d5.f841a.n.a(W5.a(w5, C0620ua.H.i()), a(a2, j));
        return a2;
    }

    public static Yk a(Ik ik, long j) {
        Yk yk = new Yk();
        yk.f774a = ik.d;
        long andIncrement = ik.f.getAndIncrement();
        Zk zk = ik.b;
        zk.a(Zk.g, Long.valueOf(ik.f.get()));
        zk.b();
        yk.b = andIncrement;
        Zk zk2 = ik.b;
        long j2 = j - ik.e;
        ik.j = j2;
        zk2.a(Zk.e, Long.valueOf(j2));
        yk.c = TimeUnit.MILLISECONDS.toSeconds(ik.j);
        yk.d = ik.c.f579a;
        return yk;
    }

    public final synchronized Ik b(W5 w5) {
        if (this.g == 0) {
            Ik b = this.d.b();
            if (a(b, w5)) {
                this.f = b;
                this.g = 3;
            } else {
                Ik b2 = this.e.b();
                if (a(b2, w5)) {
                    this.f = b2;
                    this.g = 2;
                } else {
                    this.f = null;
                    this.g = 1;
                }
            }
        }
        if (this.g != 1 && !a(this.f, w5)) {
            this.g = 1;
            this.f = null;
        }
        int a2 = Q7.a(this.g);
        if (a2 == 1) {
            Ik ik = this.f;
            long j = w5.i;
            ik.i = j;
            Zk zk = ik.b;
            zk.a(Zk.d, Long.valueOf(j));
            zk.b();
            return this.f;
        } else if (a2 != 2) {
            this.f746a.m.info("Start background session", new Object[0]);
            this.g = 2;
            long j2 = w5.i;
            AbstractC0256g abstractC0256g = this.e;
            Jk jk = new Jk(j2, w5.j);
            abstractC0256g.getClass();
            Ik a3 = abstractC0256g.a(jk);
            if (this.f746a.t.c()) {
                C0185d5 c0185d5 = this.c;
                c0185d5.f841a.n.a(W5.a(w5, C0620ua.H.i()), a(a3, w5.i));
            } else {
                int i = w5.d;
                EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
                if (i == 6145) {
                    C0185d5 c0185d52 = this.c;
                    c0185d52.f841a.n.a(w5, a(a3, j2));
                    C0185d5 c0185d53 = this.c;
                    c0185d53.f841a.n.a(W5.a(w5, C0620ua.H.i()), a(a3, j2));
                }
            }
            this.f = a3;
            return a3;
        } else {
            return this.f;
        }
    }

    public final boolean a(Ik ik, W5 w5) {
        boolean z;
        boolean z2;
        if (ik == null) {
            return false;
        }
        long j = w5.i;
        boolean z3 = ik.d >= 0;
        if (ik.h == null) {
            synchronized (ik) {
                if (ik.h == null) {
                    try {
                        String asString = ik.f532a.e.a(ik.d, ik.c.f579a).getAsString("report_request_parameters");
                        if (!TextUtils.isEmpty(asString)) {
                            ik.h = new Xk(new JSONObject(asString));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        Xk xk = ik.h;
        if (xk == null) {
            z = false;
            break;
        }
        C0503ph c0503ph = (C0503ph) ik.f532a.k.a();
        Boolean[] boolArr = new Boolean[7];
        boolArr[0] = Boolean.valueOf(TextUtils.equals(c0503ph.getAnalyticsSdkVersionName(), xk.f759a));
        boolArr[1] = Boolean.valueOf(TextUtils.equals(c0503ph.getAnalyticsSdkBuildNumber(), xk.b));
        boolArr[2] = Boolean.valueOf(TextUtils.equals(c0503ph.getAppVersion(), xk.c));
        boolArr[3] = Boolean.valueOf(TextUtils.equals(c0503ph.getAppBuildNumber(), xk.d));
        boolArr[4] = Boolean.valueOf(TextUtils.equals(c0503ph.getOsVersion(), xk.e));
        boolArr[5] = Boolean.valueOf(xk.f == c0503ph.getOsApiLevel());
        boolArr[6] = Boolean.valueOf(xk.g == c0503ph.r);
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
        long elapsedRealtime = ik.k.elapsedRealtime();
        long j2 = ik.i;
        boolean z4 = elapsedRealtime < j2;
        long j3 = j - j2;
        long j4 = j - ik.e;
        if (!z4) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Lk lk = ik.c;
            int i = ((C0503ph) ik.f532a.k.a()).f;
            Integer num = lk.d;
            if (num != null) {
                i = num.intValue();
            }
            if (j3 < timeUnit.toMillis(i) && j4 < timeUnit.toMillis(Mk.f596a)) {
                z2 = false;
                if (z3 || !z || z2) {
                    b(ik, w5);
                    return false;
                }
                return true;
            }
        }
        z2 = true;
        if (z3) {
        }
        b(ik, w5);
        return false;
    }
}
