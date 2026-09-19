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
public final class C0669vl {

    /* renamed from: a  reason: collision with root package name */
    public final C0446n5 f1253a;
    public final C0420m5 b;
    public final InterfaceC0581sb c;
    public final InterfaceC0581sb d;
    public final InterfaceC0581sb e;
    public C0255fl f;
    public int g = 0;
    public Long h = null;

    public C0669vl(C0446n5 c0446n5, C0420m5 c0420m5, Ea ea, M2 m2, C0617tl c0617tl) {
        this.f1253a = c0446n5;
        this.b = c0420m5;
        this.c = ea;
        this.d = m2;
        this.e = c0617tl;
    }

    public final synchronized long a() {
        Long l;
        l = this.h;
        return l != null ? l.longValue() : RealConnection.IDLE_CONNECTION_HEALTHY_NS;
    }

    public final synchronized C0255fl b(C0240f6 c0240f6) {
        d(c0240f6);
        if (this.g != 1 && !a(this.f, c0240f6)) {
            this.g = 1;
            this.f = null;
        }
        int a2 = AbstractC0165c8.a(this.g);
        if (a2 == 1) {
            C0255fl c0255fl = this.f;
            long j = c0240f6.i;
            c0255fl.i = j;
            C0773zl c0773zl = c0255fl.b;
            c0773zl.a(C0773zl.d, Long.valueOf(j));
            c0773zl.a();
            return this.f;
        } else if (a2 != 2) {
            this.f1253a.m.info("Start background session", new Object[0]);
            this.g = 2;
            long j2 = c0240f6.i;
            C0255fl a3 = this.d.a(new C0281gl(j2, c0240f6.j, null));
            a(a3.d);
            if (this.f1253a.t.c()) {
                C0420m5 c0420m5 = this.b;
                c0420m5.f1094a.n.a(C0240f6.a(c0240f6, Na.I.i()), a(a3, c0240f6.i));
            } else {
                int i = c0240f6.d;
                Db db = Db.EVENT_TYPE_UNDEFINED;
                if (i == 6145) {
                    C0420m5 c0420m52 = this.b;
                    c0420m52.f1094a.n.a(c0240f6, a(a3, j2));
                    C0420m5 c0420m53 = this.b;
                    c0420m53.f1094a.n.a(C0240f6.a(c0240f6, Na.I.i()), a(a3, j2));
                }
            }
            this.f = a3;
            return a3;
        } else {
            return this.f;
        }
    }

    public final synchronized void c(C0240f6 c0240f6) {
        d(c0240f6);
        int a2 = AbstractC0165c8.a(this.g);
        if (a2 == 0) {
            this.f = a(c0240f6);
        } else if (a2 == 1) {
            b(this.f, c0240f6);
            this.f = a(c0240f6);
        } else if (a2 == 2) {
            if (a(this.f, c0240f6)) {
                C0255fl c0255fl = this.f;
                long j = c0240f6.i;
                c0255fl.i = j;
                C0773zl c0773zl = c0255fl.b;
                c0773zl.a(C0773zl.d, Long.valueOf(j));
                c0773zl.a();
            } else {
                this.f = a(c0240f6);
            }
        }
    }

    public final void d(C0240f6 c0240f6) {
        if (this.g == 0) {
            C0255fl a2 = this.c.a();
            if (a2 != null) {
                a(a2.d);
            }
            if (a(a2, c0240f6)) {
                this.f = a2;
                this.g = 3;
                return;
            }
            C0255fl a3 = this.d.a();
            if (a3 != null) {
                a(a3.d);
            }
            if (a(a3, c0240f6)) {
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

    public final C0255fl a(C0240f6 c0240f6) {
        this.f1253a.m.info("Start foreground session", new Object[0]);
        long j = c0240f6.i;
        C0255fl a2 = this.c.a(new C0281gl(j, c0240f6.j, null));
        a(a2.d);
        this.g = 3;
        ((A5) this.f1253a.p).e();
        C0420m5 c0420m5 = this.b;
        c0420m5.f1094a.n.a(C0240f6.a(c0240f6, Na.I.i()), a(a2, j));
        return a2;
    }

    public final boolean a(C0255fl c0255fl, C0240f6 c0240f6) {
        boolean z;
        boolean z2;
        if (c0255fl == null) {
            return false;
        }
        long j = c0240f6.i;
        long j2 = c0255fl.d;
        boolean z3 = j2 >= 0;
        C0695wl a2 = c0255fl.f986a.e.a(j2, c0255fl.c.f1040a);
        if (a2 == null) {
            z = false;
            break;
        }
        Eh eh = (Eh) c0255fl.f986a.k.a();
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
        long elapsedRealtime = c0255fl.l.elapsedRealtime();
        long j3 = c0255fl.i;
        boolean z4 = elapsedRealtime < j3;
        long j4 = j - j3;
        long j5 = j - c0255fl.e;
        if (!z4) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            C0332il c0332il = c0255fl.c;
            int i = ((Eh) c0255fl.f986a.k.a()).f;
            Integer num = c0332il.e;
            if (num != null) {
                i = num.intValue();
            }
            if (j4 < timeUnit.toMillis(i) && j5 < timeUnit.toMillis(AbstractC0358jl.f1056a)) {
                z2 = false;
                if (z3 || !z || z2 || c0255fl.k) {
                    b(c0255fl, c0240f6);
                    return false;
                }
                return true;
            }
        }
        z2 = true;
        if (z3) {
        }
        b(c0255fl, c0240f6);
        return false;
    }

    public final void b(C0255fl c0255fl, C0240f6 c0240f6) {
        if (c0255fl.h && c0255fl.d > 0) {
            C0420m5 c0420m5 = this.b;
            C0240f6 a2 = C0240f6.a(c0240f6, Db.EVENT_TYPE_ALIVE);
            C0747yl c0747yl = new C0747yl();
            c0747yl.f1302a = c0255fl.d;
            c0747yl.d = c0255fl.c.f1040a;
            long andIncrement = c0255fl.g.getAndIncrement();
            C0773zl c0773zl = c0255fl.b;
            c0773zl.a(C0773zl.g, Long.valueOf(c0255fl.g.get()));
            c0773zl.a();
            c0747yl.b = andIncrement;
            c0747yl.c = TimeUnit.MILLISECONDS.toSeconds(Math.max(c0255fl.i - c0255fl.e, c0255fl.j));
            c0420m5.f1094a.n.a(a2, c0747yl);
            if (c0255fl.h) {
                c0255fl.h = false;
                C0773zl c0773zl2 = c0255fl.b;
                c0773zl2.a(C0773zl.j, Boolean.FALSE);
                c0773zl2.a();
            }
        }
        PublicLogger publicLogger = this.f1253a.m;
        int ordinal = c0255fl.c.f1040a.ordinal();
        if (ordinal == 0) {
            publicLogger.info("Finish foreground session", new Object[0]);
        } else if (ordinal == 1) {
            publicLogger.info("Finish background session", new Object[0]);
        }
        synchronized (c0255fl) {
            C0773zl c0773zl3 = c0255fl.b;
            c0773zl3.getClass();
            c0773zl3.c = new Hb();
            c0773zl3.a();
        }
    }

    public static C0747yl a(C0255fl c0255fl, long j) {
        C0747yl c0747yl = new C0747yl();
        c0747yl.f1302a = c0255fl.d;
        long andIncrement = c0255fl.g.getAndIncrement();
        C0773zl c0773zl = c0255fl.b;
        c0773zl.a(C0773zl.g, Long.valueOf(c0255fl.g.get()));
        c0773zl.a();
        c0747yl.b = andIncrement;
        C0773zl c0773zl2 = c0255fl.b;
        long j2 = j - c0255fl.e;
        c0255fl.j = j2;
        c0773zl2.a(C0773zl.e, Long.valueOf(j2));
        c0773zl2.a();
        c0747yl.c = TimeUnit.MILLISECONDS.toSeconds(c0255fl.j);
        c0747yl.d = c0255fl.c.f1040a;
        return c0747yl;
    }
}
