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
public final class C0670vl {

    /* renamed from: a  reason: collision with root package name */
    public final C0447n5 f1253a;
    public final C0421m5 b;
    public final InterfaceC0582sb c;
    public final InterfaceC0582sb d;
    public final InterfaceC0582sb e;
    public C0256fl f;
    public int g = 0;
    public Long h = null;

    public C0670vl(C0447n5 c0447n5, C0421m5 c0421m5, Ea ea, M2 m2, C0618tl c0618tl) {
        this.f1253a = c0447n5;
        this.b = c0421m5;
        this.c = ea;
        this.d = m2;
        this.e = c0618tl;
    }

    public final synchronized long a() {
        Long l;
        l = this.h;
        return l != null ? l.longValue() : RealConnection.IDLE_CONNECTION_HEALTHY_NS;
    }

    public final synchronized C0256fl b(C0241f6 c0241f6) {
        d(c0241f6);
        if (this.g != 1 && !a(this.f, c0241f6)) {
            this.g = 1;
            this.f = null;
        }
        int a2 = AbstractC0166c8.a(this.g);
        if (a2 == 1) {
            C0256fl c0256fl = this.f;
            long j = c0241f6.i;
            c0256fl.i = j;
            C0774zl c0774zl = c0256fl.b;
            c0774zl.a(C0774zl.d, Long.valueOf(j));
            c0774zl.a();
            return this.f;
        } else if (a2 != 2) {
            this.f1253a.m.info("Start background session", new Object[0]);
            this.g = 2;
            long j2 = c0241f6.i;
            C0256fl a3 = this.d.a(new C0282gl(j2, c0241f6.j, null));
            a(a3.d);
            if (this.f1253a.t.c()) {
                C0421m5 c0421m5 = this.b;
                c0421m5.f1094a.n.a(C0241f6.a(c0241f6, Na.I.i()), a(a3, c0241f6.i));
            } else {
                int i = c0241f6.d;
                Db db = Db.EVENT_TYPE_UNDEFINED;
                if (i == 6145) {
                    C0421m5 c0421m52 = this.b;
                    c0421m52.f1094a.n.a(c0241f6, a(a3, j2));
                    C0421m5 c0421m53 = this.b;
                    c0421m53.f1094a.n.a(C0241f6.a(c0241f6, Na.I.i()), a(a3, j2));
                }
            }
            this.f = a3;
            return a3;
        } else {
            return this.f;
        }
    }

    public final synchronized void c(C0241f6 c0241f6) {
        d(c0241f6);
        int a2 = AbstractC0166c8.a(this.g);
        if (a2 == 0) {
            this.f = a(c0241f6);
        } else if (a2 == 1) {
            b(this.f, c0241f6);
            this.f = a(c0241f6);
        } else if (a2 == 2) {
            if (a(this.f, c0241f6)) {
                C0256fl c0256fl = this.f;
                long j = c0241f6.i;
                c0256fl.i = j;
                C0774zl c0774zl = c0256fl.b;
                c0774zl.a(C0774zl.d, Long.valueOf(j));
                c0774zl.a();
            } else {
                this.f = a(c0241f6);
            }
        }
    }

    public final void d(C0241f6 c0241f6) {
        if (this.g == 0) {
            C0256fl a2 = this.c.a();
            if (a2 != null) {
                a(a2.d);
            }
            if (a(a2, c0241f6)) {
                this.f = a2;
                this.g = 3;
                return;
            }
            C0256fl a3 = this.d.a();
            if (a3 != null) {
                a(a3.d);
            }
            if (a(a3, c0241f6)) {
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

    public final C0256fl a(C0241f6 c0241f6) {
        this.f1253a.m.info("Start foreground session", new Object[0]);
        long j = c0241f6.i;
        C0256fl a2 = this.c.a(new C0282gl(j, c0241f6.j, null));
        a(a2.d);
        this.g = 3;
        ((A5) this.f1253a.p).e();
        C0421m5 c0421m5 = this.b;
        c0421m5.f1094a.n.a(C0241f6.a(c0241f6, Na.I.i()), a(a2, j));
        return a2;
    }

    public final boolean a(C0256fl c0256fl, C0241f6 c0241f6) {
        boolean z;
        boolean z2;
        if (c0256fl == null) {
            return false;
        }
        long j = c0241f6.i;
        long j2 = c0256fl.d;
        boolean z3 = j2 >= 0;
        C0696wl a2 = c0256fl.f986a.e.a(j2, c0256fl.c.f1040a);
        if (a2 == null) {
            z = false;
            break;
        }
        Eh eh = (Eh) c0256fl.f986a.k.a();
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
        long elapsedRealtime = c0256fl.l.elapsedRealtime();
        long j3 = c0256fl.i;
        boolean z4 = elapsedRealtime < j3;
        long j4 = j - j3;
        long j5 = j - c0256fl.e;
        if (!z4) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            C0333il c0333il = c0256fl.c;
            int i = ((Eh) c0256fl.f986a.k.a()).f;
            Integer num = c0333il.e;
            if (num != null) {
                i = num.intValue();
            }
            if (j4 < timeUnit.toMillis(i) && j5 < timeUnit.toMillis(AbstractC0359jl.f1056a)) {
                z2 = false;
                if (z3 || !z || z2 || c0256fl.k) {
                    b(c0256fl, c0241f6);
                    return false;
                }
                return true;
            }
        }
        z2 = true;
        if (z3) {
        }
        b(c0256fl, c0241f6);
        return false;
    }

    public final void b(C0256fl c0256fl, C0241f6 c0241f6) {
        if (c0256fl.h && c0256fl.d > 0) {
            C0421m5 c0421m5 = this.b;
            C0241f6 a2 = C0241f6.a(c0241f6, Db.EVENT_TYPE_ALIVE);
            C0748yl c0748yl = new C0748yl();
            c0748yl.f1302a = c0256fl.d;
            c0748yl.d = c0256fl.c.f1040a;
            long andIncrement = c0256fl.g.getAndIncrement();
            C0774zl c0774zl = c0256fl.b;
            c0774zl.a(C0774zl.g, Long.valueOf(c0256fl.g.get()));
            c0774zl.a();
            c0748yl.b = andIncrement;
            c0748yl.c = TimeUnit.MILLISECONDS.toSeconds(Math.max(c0256fl.i - c0256fl.e, c0256fl.j));
            c0421m5.f1094a.n.a(a2, c0748yl);
            if (c0256fl.h) {
                c0256fl.h = false;
                C0774zl c0774zl2 = c0256fl.b;
                c0774zl2.a(C0774zl.j, Boolean.FALSE);
                c0774zl2.a();
            }
        }
        PublicLogger publicLogger = this.f1253a.m;
        int ordinal = c0256fl.c.f1040a.ordinal();
        if (ordinal == 0) {
            publicLogger.info("Finish foreground session", new Object[0]);
        } else if (ordinal == 1) {
            publicLogger.info("Finish background session", new Object[0]);
        }
        synchronized (c0256fl) {
            C0774zl c0774zl3 = c0256fl.b;
            c0774zl3.getClass();
            c0774zl3.c = new Hb();
            c0774zl3.a();
        }
    }

    public static C0748yl a(C0256fl c0256fl, long j) {
        C0748yl c0748yl = new C0748yl();
        c0748yl.f1302a = c0256fl.d;
        long andIncrement = c0256fl.g.getAndIncrement();
        C0774zl c0774zl = c0256fl.b;
        c0774zl.a(C0774zl.g, Long.valueOf(c0256fl.g.get()));
        c0774zl.a();
        c0748yl.b = andIncrement;
        C0774zl c0774zl2 = c0256fl.b;
        long j2 = j - c0256fl.e;
        c0256fl.j = j2;
        c0774zl2.a(C0774zl.e, Long.valueOf(j2));
        c0774zl2.a();
        c0748yl.c = TimeUnit.MILLISECONDS.toSeconds(c0256fl.j);
        c0748yl.d = c0256fl.c.f1040a;
        return c0748yl;
    }
}
