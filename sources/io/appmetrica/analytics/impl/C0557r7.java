package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.modulesapi.internal.common.TableDescription;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServicesDatabase;
import java.util.HashMap;
import java.util.Map;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
/* renamed from: io.appmetrica.analytics.impl.r7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0557r7 {
    public static volatile C0557r7 t;
    public final Context e;
    public C0533q7 f;
    public C0533q7 g;
    public C0479o3 h;
    public C0504p3 i;
    public C0479o3 j;
    public C0504p3 k;
    public Lb l;
    public Mb m;
    public C0449mn n;
    public C0474nn o;
    public Lb p;
    public Mb q;
    public C0587sc r;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1021a = new HashMap();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final C0234e7 d = P5.a();
    public final C0607t7 s = new C0607t7();

    public C0557r7(Context context) {
        this.e = context;
    }

    public static C0557r7 a(Context context) {
        if (t == null) {
            synchronized (C0557r7.class) {
                if (t == null) {
                    t = new C0557r7(context.getApplicationContext());
                }
            }
        }
        return t;
    }

    public final synchronized InterfaceC0135ab b(C0406l5 c0406l5) {
        InterfaceC0135ab interfaceC0135ab;
        String str = new C0181c5(c0406l5).f779a;
        interfaceC0135ab = (InterfaceC0135ab) this.b.get(str);
        if (interfaceC0135ab == null) {
            interfaceC0135ab = new Lb(new C0472nl(c(c0406l5)));
            this.b.put(str, interfaceC0135ab);
        }
        return interfaceC0135ab;
    }

    public final synchronized C0533q7 c(C0406l5 c0406l5) {
        C0533q7 c0533q7;
        C0181c5 c0181c5 = new C0181c5(c0406l5);
        c0533q7 = (C0533q7) this.f1021a.get(c0181c5.f779a);
        if (c0533q7 == null) {
            Context context = this.e;
            C0607t7 c0607t7 = this.s;
            String a2 = new C0582s7(c0607t7.f1054a, c0607t7.b, false).a(context, c0181c5);
            C0234e7 c0234e7 = this.d;
            c0234e7.getClass();
            String str = c0406l5.b;
            if (str == null) {
                str = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
            }
            String format = String.format("component-%s", str);
            C0225dn c0225dn = c0234e7.c;
            C0483o7 c0483o7 = c0234e7.f817a;
            C0284g7 c0284g7 = c0483o7.f969a;
            C0309h7 c0309h7 = c0483o7.b;
            Ia ia = new Ia(false);
            ia.a(112, new C0257f5());
            C0275fn c0275fn = new C0275fn(format, c0234e7.b.f550a);
            c0225dn.getClass();
            c0533q7 = new C0533q7(context, a2, new C0250en(c0284g7, c0309h7, ia, c0275fn), PublicLogger.getAnonymousInstance());
            this.f1021a.put(c0181c5.f779a, c0533q7);
        }
        return c0533q7;
    }

    public final synchronized InterfaceC0135ab d() {
        if (this.l == null) {
            this.l = new Lb(new C0472nl(h()));
        }
        return this.l;
    }

    public final IBinaryDataHelper e() {
        if (this.j == null) {
            if (this.g == null) {
                Context context = this.e;
                C0607t7 c0607t7 = this.s;
                String a2 = new C0582s7(c0607t7.f1054a, c0607t7.b, false).a(context, new B2());
                C0234e7 c0234e7 = this.d;
                c0234e7.getClass();
                HashMap hashMap = new HashMap();
                hashMap.put("binary_data", K5.f501a);
                C0225dn c0225dn = c0234e7.c;
                C0483o7 c0483o7 = c0234e7.f817a;
                C0334i7 c0334i7 = c0483o7.g;
                C0358j7 c0358j7 = c0483o7.h;
                Ia ia = new Ia(false);
                C0275fn c0275fn = new C0275fn("auto_inapp", hashMap);
                c0225dn.getClass();
                this.g = new C0533q7(context, a2, new C0250en(c0334i7, c0358j7, ia, c0275fn), PublicLogger.getAnonymousInstance());
            }
            this.j = new C0479o3(new C0472nl(this.g));
        }
        return this.j;
    }

    public final InterfaceC0135ab f() {
        C0587sc c0587sc;
        if (this.p == null) {
            synchronized (this) {
                if (this.r == null) {
                    C0607t7 c0607t7 = this.s;
                    String a2 = new C0582s7(c0607t7.f1054a, c0607t7.b, true).a(this.e, new C0355j4());
                    Context context = this.e;
                    C0234e7 c0234e7 = this.d;
                    c0234e7.getClass();
                    HashMap hashMap = new HashMap();
                    hashMap.put("preferences", M5.f529a);
                    C0225dn c0225dn = c0234e7.c;
                    C0483o7 c0483o7 = c0234e7.f817a;
                    C0383k7 c0383k7 = c0483o7.c;
                    C0408l7 c0408l7 = c0483o7.d;
                    Ia ia = new Ia(false);
                    ia.a(112, new C0380k4());
                    C0275fn c0275fn = new C0275fn("service database", hashMap);
                    c0225dn.getClass();
                    this.r = new C0587sc(context, a2, new C0560ra(a2), new C0250en(c0383k7, c0408l7, ia, c0275fn));
                }
                c0587sc = this.r;
            }
            this.p = new Lb(c0587sc);
        }
        return this.p;
    }

    public final IBinaryDataHelper g() {
        if (this.h == null) {
            this.h = new C0479o3(new C0472nl(h()));
        }
        return this.h;
    }

    public final synchronized C0533q7 h() {
        if (this.f == null) {
            Context context = this.e;
            C0607t7 c0607t7 = this.s;
            String a2 = new C0582s7(c0607t7.f1054a, c0607t7.b, true).a(context, new C0396kk());
            C0234e7 c0234e7 = this.d;
            c0234e7.getClass();
            HashMap hashMap = new HashMap();
            hashMap.put("preferences", M5.f529a);
            hashMap.put("binary_data", K5.f501a);
            hashMap.put("temp_cache", AbstractC0524pn.f995a);
            for (ModuleServicesDatabase moduleServicesDatabase : Ga.F.o().b()) {
                for (TableDescription tableDescription : moduleServicesDatabase.getTables()) {
                    hashMap.put(tableDescription.getTableName(), tableDescription.getColumnNames());
                }
            }
            C0225dn c0225dn = c0234e7.c;
            C0483o7 c0483o7 = c0234e7.f817a;
            C0433m7 c0433m7 = c0483o7.e;
            C0458n7 c0458n7 = c0483o7.f;
            Ia ia = new Ia(false);
            ia.a(114, new C0421lk());
            for (ModuleServicesDatabase moduleServicesDatabase2 : Ga.F.o().b()) {
                for (TableDescription tableDescription2 : moduleServicesDatabase2.getTables()) {
                    for (Map.Entry<Integer, DatabaseScript> entry : tableDescription2.getDatabaseProviderUpgradeScript().entrySet()) {
                        ia.a(entry.getKey(), entry.getValue());
                    }
                }
            }
            C0275fn c0275fn = new C0275fn("service database", hashMap);
            c0225dn.getClass();
            this.f = new C0533q7(context, a2, new C0250en(c0433m7, c0458n7, ia, c0275fn), PublicLogger.getAnonymousInstance());
        }
        return this.f;
    }

    public final synchronized InterfaceC0135ab b() {
        return f();
    }

    public final synchronized IBinaryDataHelper a(C0406l5 c0406l5) {
        IBinaryDataHelper iBinaryDataHelper;
        String str = new C0181c5(c0406l5).f779a;
        iBinaryDataHelper = (IBinaryDataHelper) this.c.get(str);
        if (iBinaryDataHelper == null) {
            iBinaryDataHelper = new C0479o3(new C0472nl(c(c0406l5)));
            this.c.put(str, iBinaryDataHelper);
        }
        return iBinaryDataHelper;
    }

    public final synchronized InterfaceC0135ab a() {
        if (this.q == null) {
            this.q = new Mb(f());
        }
        return this.q;
    }

    public final synchronized InterfaceC0135ab c() {
        if (this.m == null) {
            if (this.l == null) {
                this.l = new Lb(new C0472nl(h()));
            }
            this.m = new Mb(this.l);
        }
        return this.m;
    }
}
