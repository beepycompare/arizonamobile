package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.RealConnection;
/* renamed from: io.appmetrica.analytics.impl.vl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0671vl {

    /* renamed from: a  reason: collision with root package name */
    public final C0448n5 f1250a;
    public final C0422m5 b;
    public final InterfaceC0583sb c;
    public final InterfaceC0583sb d;
    public final InterfaceC0583sb e;
    public C0257fl f;
    public int g = 0;
    public Long h = null;

    public C0671vl(C0448n5 c0448n5, C0422m5 c0422m5, Ea ea, M2 m2, C0619tl c0619tl) {
        this.f1250a = c0448n5;
        this.b = c0422m5;
        this.c = ea;
        this.d = m2;
        this.e = c0619tl;
    }

    public final synchronized long a() {
        Long l;
        l = this.h;
        return l != null ? l.longValue() : RealConnection.IDLE_CONNECTION_HEALTHY_NS;
    }

    public final synchronized C0257fl b(C0242f6 c0242f6) {
        d(c0242f6);
        if (this.g != 1 && !a(this.f, c0242f6)) {
            this.g = 1;
            this.f = null;
        }
        int a2 = AbstractC0167c8.a(this.g);
        if (a2 == 1) {
            C0257fl c0257fl = this.f;
            long j = c0242f6.i;
            c0257fl.i = j;
            C0775zl c0775zl = c0257fl.b;
            c0775zl.a(C0775zl.d, Long.valueOf(j));
            c0775zl.a();
            return this.f;
        } else if (a2 != 2) {
            this.f1250a.m.info("Start background session", new Object[0]);
            this.g = 2;
            long j2 = c0242f6.i;
            C0257fl a3 = this.d.a(new C0283gl(j2, c0242f6.j, null));
            a(a3.d);
            if (this.f1250a.t.c()) {
                C0422m5 c0422m5 = this.b;
                c0422m5.f1091a.n.a(C0242f6.a(c0242f6, Na.I.i()), a(a3, c0242f6.i));
            } else {
                int i = c0242f6.d;
                Db db = Db.EVENT_TYPE_UNDEFINED;
                if (i == 6145) {
                    C0422m5 c0422m52 = this.b;
                    c0422m52.f1091a.n.a(c0242f6, a(a3, j2));
                    C0422m5 c0422m53 = this.b;
                    c0422m53.f1091a.n.a(C0242f6.a(c0242f6, Na.I.i()), a(a3, j2));
                }
            }
            this.f = a3;
            return a3;
        } else {
            return this.f;
        }
    }

    public final synchronized void c(C0242f6 c0242f6) {
        d(c0242f6);
        int a2 = AbstractC0167c8.a(this.g);
        if (a2 == 0) {
            this.f = a(c0242f6);
        } else if (a2 == 1) {
            b(this.f, c0242f6);
            this.f = a(c0242f6);
        } else if (a2 == 2) {
            if (a(this.f, c0242f6)) {
                C0257fl c0257fl = this.f;
                long j = c0242f6.i;
                c0257fl.i = j;
                C0775zl c0775zl = c0257fl.b;
                c0775zl.a(C0775zl.d, Long.valueOf(j));
                c0775zl.a();
            } else {
                this.f = a(c0242f6);
            }
        }
    }

    public final void d(C0242f6 c0242f6) {
        if (this.g == 0) {
            C0257fl a2 = this.c.a();
            if (a2 != null) {
                a(a2.d);
            }
            if (a(a2, c0242f6)) {
                this.f = a2;
                this.g = 3;
                return;
            }
            C0257fl a3 = this.d.a();
            if (a3 != null) {
                a(a3.d);
            }
            if (a(a3, c0242f6)) {
                this.f = a3;
                this.g = 2;
                return;
            }
            this.f = null;
            this.g = 1;
        }
    }

    public final void a(long j) {
        Long l = this.h;
        if (l == null || j < l.longValue()) {
            this.h = Long.valueOf(j);
        }
    }

    public final C0257fl a(C0242f6 c0242f6) {
        this.f1250a.m.info("Start foreground session", new Object[0]);
        long j = c0242f6.i;
        C0257fl a2 = this.c.a(new C0283gl(j, c0242f6.j, null));
        a(a2.d);
        this.g = 3;
        ((A5) this.f1250a.p).e();
        C0422m5 c0422m5 = this.b;
        c0422m5.f1091a.n.a(C0242f6.a(c0242f6, Na.I.i()), a(a2, j));
        return a2;
    }

    public final boolean a(C0257fl c0257fl, C0242f6 c0242f6) {
        boolean z;
        boolean z2;
        if (c0257fl == null) {
            return false;
        }
        long j = c0242f6.i;
        long j2 = c0257fl.d;
        boolean z3 = j2 >= 0;
        C0697wl a2 = c0257fl.f983a.e.a(j2, c0257fl.c.f1037a);
        if (a2 == null) {
            z = false;
            break;
        }
        Eh eh = (Eh) c0257fl.f983a.k.a();
        Boolean[] boolArr = new Boolean[7];
        boolArr[0] = Boolean.valueOf(Intrinsics.areEqual(eh.getAnalyticsSdkVersionName(), a2.n));
        boolArr[1] = Boolean.valueOf(Intrinsics.areEqual(eh.getAnalyticsSdkBuildNumber(), a2.o));
        boolArr[2] = Boolean.valueOf(Intrinsics.areEqual(eh.getAppVersion(), a2.d));
        boolArr[3] = Boolean.valueOf(Intrinsics.areEqual(eh.getAppBuildNumber(), a2.e));
        boolArr[4] = Boolean.valueOf(Intrinsics.areEqual(eh.getOsVersion(), a2.g));
        boolArr[5] = Boolean.valueOf(a2.h == eh.getOsApiLevel());
        boolArr[6] = Boolean.valueOf(a2.m == eh.r);
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
        long elapsedRealtime = c0257fl.l.elapsedRealtime();
        long j3 = c0257fl.i;
        boolean z4 = elapsedRealtime < j3;
        long j4 = j - j3;
        long j5 = j - c0257fl.e;
        if (!z4) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            C0334il c0334il = c0257fl.c;
            int i = ((Eh) c0257fl.f983a.k.a()).f;
            Integer num = c0334il.e;
            if (num != null) {
                i = num.intValue();
            }
            if (j4 < timeUnit.toMillis(i) && j5 < timeUnit.toMillis(AbstractC0360jl.f1053a)) {
                z2 = false;
                if (z3 || !z || z2 || c0257fl.k) {
                    b(c0257fl, c0242f6);
                    return false;
                }
                return true;
            }
        }
        z2 = true;
        if (z3) {
        }
        b(c0257fl, c0242f6);
        return false;
    }

    public final void b(C0257fl c0257fl, C0242f6 c0242f6) {
        if (c0257fl.h && c0257fl.d > 0) {
            C0422m5 c0422m5 = this.b;
            C0242f6 a2 = C0242f6.a(c0242f6, Db.EVENT_TYPE_ALIVE);
            C0749yl c0749yl = new C0749yl();
            c0749yl.f1299a = c0257fl.d;
            c0749yl.d = c0257fl.c.f1037a;
            long andIncrement = c0257fl.g.getAndIncrement();
            C0775zl c0775zl = c0257fl.b;
            c0775zl.a(C0775zl.g, Long.valueOf(c0257fl.g.get()));
            c0775zl.a();
            c0749yl.b = andIncrement;
            c0749yl.c = TimeUnit.MILLISECONDS.toSeconds(Math.max(c0257fl.i - c0257fl.e, c0257fl.j));
            c0422m5.f1091a.n.a(a2, c0749yl);
            if (c0257fl.h) {
                c0257fl.h = false;
                C0775zl c0775zl2 = c0257fl.b;
                c0775zl2.a(C0775zl.j, Boolean.FALSE);
                c0775zl2.a();
            }
        }
        PublicLogger publicLogger = this.f1250a.m;
        int ordinal = c0257fl.c.f1037a.ordinal();
        if (ordinal == 0) {
            publicLogger.info("Finish foreground session", new Object[0]);
        } else if (ordinal == 1) {
            publicLogger.info("Finish background session", new Object[0]);
        }
        synchronized (c0257fl) {
            C0775zl c0775zl3 = c0257fl.b;
            c0775zl3.getClass();
            c0775zl3.c = new Hb();
            c0775zl3.a();
        }
    }

    public static C0749yl a(C0257fl c0257fl, long j) {
        C0749yl c0749yl = new C0749yl();
        c0749yl.f1299a = c0257fl.d;
        long andIncrement = c0257fl.g.getAndIncrement();
        C0775zl c0775zl = c0257fl.b;
        c0775zl.a(C0775zl.g, Long.valueOf(c0257fl.g.get()));
        c0775zl.a();
        c0749yl.b = andIncrement;
        C0775zl c0775zl2 = c0257fl.b;
        long j2 = j - c0257fl.e;
        c0257fl.j = j2;
        c0775zl2.a(C0775zl.e, Long.valueOf(j2));
        c0775zl2.a();
        c0749yl.c = TimeUnit.MILLISECONDS.toSeconds(c0257fl.j);
        c0749yl.d = c0257fl.c.f1037a;
        return c0749yl;
    }
}
