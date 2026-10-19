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
public final class C0664vl {

    /* renamed from: a  reason: collision with root package name */
    public final C0441n5 f1256a;
    public final C0415m5 b;
    public final InterfaceC0576sb c;
    public final InterfaceC0576sb d;
    public final InterfaceC0576sb e;
    public C0250fl f;
    public int g = 0;
    public Long h = null;

    public C0664vl(C0441n5 c0441n5, C0415m5 c0415m5, Ea ea, M2 m2, C0612tl c0612tl) {
        this.f1256a = c0441n5;
        this.b = c0415m5;
        this.c = ea;
        this.d = m2;
        this.e = c0612tl;
    }

    public final synchronized long a() {
        Long l;
        l = this.h;
        return l != null ? l.longValue() : RealConnection.IDLE_CONNECTION_HEALTHY_NS;
    }

    public final synchronized C0250fl b(C0235f6 c0235f6) {
        d(c0235f6);
        if (this.g != 1 && !a(this.f, c0235f6)) {
            this.g = 1;
            this.f = null;
        }
        int a2 = AbstractC0160c8.a(this.g);
        if (a2 == 1) {
            C0250fl c0250fl = this.f;
            long j = c0235f6.i;
            c0250fl.i = j;
            C0768zl c0768zl = c0250fl.b;
            c0768zl.a(C0768zl.d, Long.valueOf(j));
            c0768zl.a();
            return this.f;
        } else if (a2 != 2) {
            this.f1256a.m.info("Start background session", new Object[0]);
            this.g = 2;
            long j2 = c0235f6.i;
            C0250fl a3 = this.d.a(new C0276gl(j2, c0235f6.j, null));
            a(a3.d);
            if (this.f1256a.t.c()) {
                C0415m5 c0415m5 = this.b;
                c0415m5.f1097a.n.a(C0235f6.a(c0235f6, Na.I.i()), a(a3, c0235f6.i));
            } else {
                int i = c0235f6.d;
                Db db = Db.EVENT_TYPE_UNDEFINED;
                if (i == 6145) {
                    C0415m5 c0415m52 = this.b;
                    c0415m52.f1097a.n.a(c0235f6, a(a3, j2));
                    C0415m5 c0415m53 = this.b;
                    c0415m53.f1097a.n.a(C0235f6.a(c0235f6, Na.I.i()), a(a3, j2));
                }
            }
            this.f = a3;
            return a3;
        } else {
            return this.f;
        }
    }

    public final synchronized void c(C0235f6 c0235f6) {
        d(c0235f6);
        int a2 = AbstractC0160c8.a(this.g);
        if (a2 == 0) {
            this.f = a(c0235f6);
        } else if (a2 == 1) {
            b(this.f, c0235f6);
            this.f = a(c0235f6);
        } else if (a2 == 2) {
            if (a(this.f, c0235f6)) {
                C0250fl c0250fl = this.f;
                long j = c0235f6.i;
                c0250fl.i = j;
                C0768zl c0768zl = c0250fl.b;
                c0768zl.a(C0768zl.d, Long.valueOf(j));
                c0768zl.a();
            } else {
                this.f = a(c0235f6);
            }
        }
    }

    public final void d(C0235f6 c0235f6) {
        if (this.g == 0) {
            C0250fl a2 = this.c.a();
            if (a2 != null) {
                a(a2.d);
            }
            if (a(a2, c0235f6)) {
                this.f = a2;
                this.g = 3;
                return;
            }
            C0250fl a3 = this.d.a();
            if (a3 != null) {
                a(a3.d);
            }
            if (a(a3, c0235f6)) {
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

    public final C0250fl a(C0235f6 c0235f6) {
        this.f1256a.m.info("Start foreground session", new Object[0]);
        long j = c0235f6.i;
        C0250fl a2 = this.c.a(new C0276gl(j, c0235f6.j, null));
        a(a2.d);
        this.g = 3;
        ((A5) this.f1256a.p).e();
        C0415m5 c0415m5 = this.b;
        c0415m5.f1097a.n.a(C0235f6.a(c0235f6, Na.I.i()), a(a2, j));
        return a2;
    }

    public final boolean a(C0250fl c0250fl, C0235f6 c0235f6) {
        boolean z;
        boolean z2;
        if (c0250fl == null) {
            return false;
        }
        long j = c0235f6.i;
        long j2 = c0250fl.d;
        boolean z3 = j2 >= 0;
        C0690wl a2 = c0250fl.f989a.e.a(j2, c0250fl.c.f1043a);
        if (a2 == null) {
            z = false;
            break;
        }
        Eh eh = (Eh) c0250fl.f989a.k.a();
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
        long elapsedRealtime = c0250fl.l.elapsedRealtime();
        long j3 = c0250fl.i;
        boolean z4 = elapsedRealtime < j3;
        long j4 = j - j3;
        long j5 = j - c0250fl.e;
        if (!z4) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            C0327il c0327il = c0250fl.c;
            int i = ((Eh) c0250fl.f989a.k.a()).f;
            Integer num = c0327il.e;
            if (num != null) {
                i = num.intValue();
            }
            if (j4 < timeUnit.toMillis(i) && j5 < timeUnit.toMillis(AbstractC0353jl.f1059a)) {
                z2 = false;
                if (z3 || !z || z2 || c0250fl.k) {
                    b(c0250fl, c0235f6);
                    return false;
                }
                return true;
            }
        }
        z2 = true;
        if (z3) {
        }
        b(c0250fl, c0235f6);
        return false;
    }

    public final void b(C0250fl c0250fl, C0235f6 c0235f6) {
        if (c0250fl.h && c0250fl.d > 0) {
            C0415m5 c0415m5 = this.b;
            C0235f6 a2 = C0235f6.a(c0235f6, Db.EVENT_TYPE_ALIVE);
            C0742yl c0742yl = new C0742yl();
            c0742yl.f1305a = c0250fl.d;
            c0742yl.d = c0250fl.c.f1043a;
            long andIncrement = c0250fl.g.getAndIncrement();
            C0768zl c0768zl = c0250fl.b;
            c0768zl.a(C0768zl.g, Long.valueOf(c0250fl.g.get()));
            c0768zl.a();
            c0742yl.b = andIncrement;
            c0742yl.c = TimeUnit.MILLISECONDS.toSeconds(Math.max(c0250fl.i - c0250fl.e, c0250fl.j));
            c0415m5.f1097a.n.a(a2, c0742yl);
            if (c0250fl.h) {
                c0250fl.h = false;
                C0768zl c0768zl2 = c0250fl.b;
                c0768zl2.a(C0768zl.j, Boolean.FALSE);
                c0768zl2.a();
            }
        }
        PublicLogger publicLogger = this.f1256a.m;
        int ordinal = c0250fl.c.f1043a.ordinal();
        if (ordinal == 0) {
            publicLogger.info("Finish foreground session", new Object[0]);
        } else if (ordinal == 1) {
            publicLogger.info("Finish background session", new Object[0]);
        }
        synchronized (c0250fl) {
            C0768zl c0768zl3 = c0250fl.b;
            c0768zl3.getClass();
            c0768zl3.c = new Hb();
            c0768zl3.a();
        }
    }

    public static C0742yl a(C0250fl c0250fl, long j) {
        C0742yl c0742yl = new C0742yl();
        c0742yl.f1305a = c0250fl.d;
        long andIncrement = c0250fl.g.getAndIncrement();
        C0768zl c0768zl = c0250fl.b;
        c0768zl.a(C0768zl.g, Long.valueOf(c0250fl.g.get()));
        c0768zl.a();
        c0742yl.b = andIncrement;
        C0768zl c0768zl2 = c0250fl.b;
        long j2 = j - c0250fl.e;
        c0250fl.j = j2;
        c0768zl2.a(C0768zl.e, Long.valueOf(j2));
        c0768zl2.a();
        c0742yl.c = TimeUnit.MILLISECONDS.toSeconds(c0250fl.j);
        c0742yl.d = c0250fl.c.f1043a;
        return c0742yl;
    }
}
