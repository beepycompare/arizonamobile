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
public final class Rk {

    /* renamed from: a  reason: collision with root package name */
    public final X4 f770a;
    public final Qk b;
    public final W4 c;
    public final AbstractC0260g d;
    public final AbstractC0260g e;
    public Dk f;
    public int g = 0;

    public Rk(X4 x4, Qk qk, W4 w4, C0297ha c0297ha, C0740z2 c0740z2) {
        this.f770a = x4;
        this.c = w4;
        this.d = c0297ha;
        this.e = c0740z2;
        this.b = qk;
    }

    public final synchronized long a() {
        Dk dk;
        dk = this.f;
        return dk == null ? RealConnection.IDLE_CONNECTION_HEALTHY_NS : dk.d - 1;
    }

    public final void b(Dk dk, P5 p5) {
        if (dk.g && dk.d > 0) {
            W4 w4 = this.c;
            P5 a2 = P5.a(p5, EnumC0143bb.EVENT_TYPE_ALIVE);
            Tk tk = new Tk();
            tk.f803a = dk.d;
            tk.d = dk.c.f601a;
            long andIncrement = dk.f.getAndIncrement();
            Uk uk = dk.b;
            uk.a(Uk.g, Long.valueOf(dk.f.get()));
            uk.b();
            tk.b = andIncrement;
            tk.c = TimeUnit.MILLISECONDS.toSeconds(Math.max(dk.i - dk.e, dk.j));
            w4.f836a.n.a(a2, tk);
            if (dk.g) {
                dk.g = false;
                Uk uk2 = dk.b;
                uk2.a(Uk.i, Boolean.FALSE);
                uk2.b();
            }
        }
        PublicLogger publicLogger = this.f770a.m;
        int ordinal = dk.c.f601a.ordinal();
        if (ordinal == 0) {
            publicLogger.info("Finish foreground session", new Object[0]);
        } else if (ordinal == 1) {
            publicLogger.info("Finish background session", new Object[0]);
        }
        synchronized (dk) {
            Uk uk3 = dk.b;
            uk3.getClass();
            uk3.c = new C0246fb();
            uk3.b();
            dk.h = null;
        }
    }

    public final synchronized void c(P5 p5) {
        if (this.g == 0) {
            Dk b = this.d.b();
            if (a(b, p5)) {
                this.f = b;
                this.g = 3;
            } else {
                Dk b2 = this.e.b();
                if (a(b2, p5)) {
                    this.f = b2;
                    this.g = 2;
                } else {
                    this.f = null;
                    this.g = 1;
                }
            }
        }
        int a2 = K7.a(this.g);
        if (a2 == 0) {
            this.f = a(p5);
        } else if (a2 == 1) {
            b(this.f, p5);
            this.f = a(p5);
        } else if (a2 == 2) {
            if (a(this.f, p5)) {
                Dk dk = this.f;
                long j = p5.i;
                dk.i = j;
                Uk uk = dk.b;
                uk.a(Uk.d, Long.valueOf(j));
                uk.b();
            } else {
                this.f = a(p5);
            }
        }
    }

    public final Dk a(P5 p5) {
        this.f770a.m.info("Start foreground session", new Object[0]);
        long j = p5.i;
        AbstractC0260g abstractC0260g = this.d;
        Ek ek = new Ek(j, p5.j);
        abstractC0260g.getClass();
        Dk a2 = abstractC0260g.a(ek);
        this.g = 3;
        ((C0369k5) this.f770a.p).e();
        W4 w4 = this.c;
        w4.f836a.n.a(P5.a(p5, C0449na.I.i()), a(a2, j));
        return a2;
    }

    public static Tk a(Dk dk, long j) {
        Tk tk = new Tk();
        tk.f803a = dk.d;
        long andIncrement = dk.f.getAndIncrement();
        Uk uk = dk.b;
        uk.a(Uk.g, Long.valueOf(dk.f.get()));
        uk.b();
        tk.b = andIncrement;
        Uk uk2 = dk.b;
        long j2 = j - dk.e;
        dk.j = j2;
        uk2.a(Uk.e, Long.valueOf(j2));
        tk.c = TimeUnit.MILLISECONDS.toSeconds(dk.j);
        tk.d = dk.c.f601a;
        return tk;
    }

    public final synchronized Dk b(P5 p5) {
        if (this.g == 0) {
            Dk b = this.d.b();
            if (a(b, p5)) {
                this.f = b;
                this.g = 3;
            } else {
                Dk b2 = this.e.b();
                if (a(b2, p5)) {
                    this.f = b2;
                    this.g = 2;
                } else {
                    this.f = null;
                    this.g = 1;
                }
            }
        }
        if (this.g != 1 && !a(this.f, p5)) {
            this.g = 1;
            this.f = null;
        }
        int a2 = K7.a(this.g);
        if (a2 == 1) {
            Dk dk = this.f;
            long j = p5.i;
            dk.i = j;
            Uk uk = dk.b;
            uk.a(Uk.d, Long.valueOf(j));
            uk.b();
            return this.f;
        } else if (a2 != 2) {
            this.f770a.m.info("Start background session", new Object[0]);
            this.g = 2;
            long j2 = p5.i;
            AbstractC0260g abstractC0260g = this.e;
            Ek ek = new Ek(j2, p5.j);
            abstractC0260g.getClass();
            Dk a3 = abstractC0260g.a(ek);
            if (this.f770a.t.c()) {
                W4 w4 = this.c;
                w4.f836a.n.a(P5.a(p5, C0449na.I.i()), a(a3, p5.i));
            } else {
                int i = p5.d;
                EnumC0143bb enumC0143bb = EnumC0143bb.EVENT_TYPE_UNDEFINED;
                if (i == 6145) {
                    W4 w42 = this.c;
                    w42.f836a.n.a(p5, a(a3, j2));
                    W4 w43 = this.c;
                    w43.f836a.n.a(P5.a(p5, C0449na.I.i()), a(a3, j2));
                }
            }
            this.f = a3;
            return a3;
        } else {
            return this.f;
        }
    }

    public final boolean a(Dk dk, P5 p5) {
        boolean z;
        boolean z2;
        if (dk == null) {
            return false;
        }
        long j = p5.i;
        boolean z3 = dk.d >= 0;
        if (dk.h == null) {
            synchronized (dk) {
                if (dk.h == null) {
                    try {
                        String asString = dk.f555a.e.a(dk.d, dk.c.f601a).getAsString("report_request_parameters");
                        if (!TextUtils.isEmpty(asString)) {
                            dk.h = new Sk(new JSONObject(asString));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        Sk sk = dk.h;
        if (sk == null) {
            z = false;
            break;
        }
        C0381kh c0381kh = (C0381kh) dk.f555a.k.a();
        Boolean[] boolArr = new Boolean[7];
        boolArr[0] = Boolean.valueOf(TextUtils.equals(c0381kh.getAnalyticsSdkVersionName(), sk.f786a));
        boolArr[1] = Boolean.valueOf(TextUtils.equals(c0381kh.getAnalyticsSdkBuildNumber(), sk.b));
        boolArr[2] = Boolean.valueOf(TextUtils.equals(c0381kh.getAppVersion(), sk.c));
        boolArr[3] = Boolean.valueOf(TextUtils.equals(c0381kh.getAppBuildNumber(), sk.d));
        boolArr[4] = Boolean.valueOf(TextUtils.equals(c0381kh.getOsVersion(), sk.e));
        boolArr[5] = Boolean.valueOf(sk.f == c0381kh.getOsApiLevel());
        boolArr[6] = Boolean.valueOf(sk.g == c0381kh.r);
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
        long elapsedRealtime = dk.k.elapsedRealtime();
        long j2 = dk.i;
        boolean z4 = elapsedRealtime < j2;
        long j3 = j - j2;
        long j4 = j - dk.e;
        if (!z4) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Gk gk = dk.c;
            int i = ((C0381kh) dk.f555a.k.a()).f;
            Integer num = gk.d;
            if (num != null) {
                i = num.intValue();
            }
            if (j3 < timeUnit.toMillis(i) && j4 < timeUnit.toMillis(Hk.f618a)) {
                z2 = false;
                if (z3 || !z || z2) {
                    b(dk, p5);
                    return false;
                }
                return true;
            }
        }
        z2 = true;
        if (z3) {
        }
        b(dk, p5);
        return false;
    }
}
