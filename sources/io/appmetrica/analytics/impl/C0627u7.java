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
/* renamed from: io.appmetrica.analytics.impl.u7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0627u7 {
    public static volatile C0627u7 t;
    public final Context e;
    public C0602t7 f;
    public C0602t7 g;
    public C0474o3 h;
    public C0499p3 i;
    public C0474o3 j;
    public C0499p3 k;
    public Nb l;
    public Ob m;
    public C0519pn n;
    public C0544qn o;
    public Nb p;
    public Ob q;
    public C0632uc r;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1079a = new HashMap();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final C0304h7 d = S5.a();
    public final C0677w7 s = new C0677w7();

    public C0627u7(Context context) {
        this.e = context;
    }

    public static C0627u7 a(Context context) {
        if (t == null) {
            synchronized (C0627u7.class) {
                if (t == null) {
                    t = new C0627u7(context.getApplicationContext());
                }
            }
        }
        return t;
    }

    public final synchronized InterfaceC0180cb b(C0401l5 c0401l5) {
        InterfaceC0180cb interfaceC0180cb;
        String str = new C0174c5(c0401l5).f793a;
        interfaceC0180cb = (InterfaceC0180cb) this.b.get(str);
        if (interfaceC0180cb == null) {
            interfaceC0180cb = new Nb(new C0542ql(c(c0401l5)));
            this.b.put(str, interfaceC0180cb);
        }
        return interfaceC0180cb;
    }

    public final synchronized C0602t7 c(C0401l5 c0401l5) {
        C0602t7 c0602t7;
        C0174c5 c0174c5 = new C0174c5(c0401l5);
        c0602t7 = (C0602t7) this.f1079a.get(c0174c5.f793a);
        if (c0602t7 == null) {
            Context context = this.e;
            C0677w7 c0677w7 = this.s;
            String a2 = new C0652v7(c0677w7.f1115a, c0677w7.b, false).a(context, c0174c5);
            C0304h7 c0304h7 = this.d;
            c0304h7.getClass();
            String str = c0401l5.b;
            if (str == null) {
                str = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
            }
            String format = String.format("component-%s", str);
            C0295gn c0295gn = c0304h7.c;
            C0552r7 c0552r7 = c0304h7.f879a;
            C0353j7 c0353j7 = c0552r7.f1033a;
            C0378k7 c0378k7 = c0552r7.b;
            Ka ka = new Ka(false);
            ka.a(112, new C0251f5());
            C0344in c0344in = new C0344in(format, c0304h7.b.f609a);
            c0295gn.getClass();
            c0602t7 = new C0602t7(context, a2, new C0320hn(c0353j7, c0378k7, ka, c0344in), PublicLogger.getAnonymousInstance());
            this.f1079a.put(c0174c5.f793a, c0602t7);
        }
        return c0602t7;
    }

    public final synchronized InterfaceC0180cb d() {
        if (this.l == null) {
            this.l = new Nb(new C0542ql(h()));
        }
        return this.l;
    }

    public final IBinaryDataHelper e() {
        if (this.j == null) {
            if (this.g == null) {
                Context context = this.e;
                C0677w7 c0677w7 = this.s;
                String a2 = new C0652v7(c0677w7.f1115a, c0677w7.b, false).a(context, new B2());
                C0304h7 c0304h7 = this.d;
                c0304h7.getClass();
                HashMap hashMap = new HashMap();
                hashMap.put("binary_data", N5.f559a);
                C0295gn c0295gn = c0304h7.c;
                C0552r7 c0552r7 = c0304h7.f879a;
                C0403l7 c0403l7 = c0552r7.g;
                C0428m7 c0428m7 = c0552r7.h;
                Ka ka = new Ka(false);
                C0344in c0344in = new C0344in("auto_inapp", hashMap);
                c0295gn.getClass();
                this.g = new C0602t7(context, a2, new C0320hn(c0403l7, c0428m7, ka, c0344in), PublicLogger.getAnonymousInstance());
            }
            this.j = new C0474o3(new C0542ql(this.g));
        }
        return this.j;
    }

    public final InterfaceC0180cb f() {
        C0632uc c0632uc;
        if (this.p == null) {
            synchronized (this) {
                if (this.r == null) {
                    C0677w7 c0677w7 = this.s;
                    String a2 = new C0652v7(c0677w7.f1115a, c0677w7.b, true).a(this.e, new C0350j4());
                    Context context = this.e;
                    C0304h7 c0304h7 = this.d;
                    c0304h7.getClass();
                    HashMap hashMap = new HashMap();
                    hashMap.put("preferences", P5.f589a);
                    C0295gn c0295gn = c0304h7.c;
                    C0552r7 c0552r7 = c0304h7.f879a;
                    C0453n7 c0453n7 = c0552r7.c;
                    C0478o7 c0478o7 = c0552r7.d;
                    Ka ka = new Ka(false);
                    ka.a(112, new C0375k4());
                    C0344in c0344in = new C0344in("service database", hashMap);
                    c0295gn.getClass();
                    this.r = new C0632uc(context, a2, new C0605ta(a2), new C0320hn(c0453n7, c0478o7, ka, c0344in));
                }
                c0632uc = this.r;
            }
            this.p = new Nb(c0632uc);
        }
        return this.p;
    }

    public final IBinaryDataHelper g() {
        if (this.h == null) {
            this.h = new C0474o3(new C0542ql(h()));
        }
        return this.h;
    }

    public final synchronized C0602t7 h() {
        if (this.f == null) {
            Context context = this.e;
            C0677w7 c0677w7 = this.s;
            String a2 = new C0652v7(c0677w7.f1115a, c0677w7.b, true).a(context, new C0466nk());
            C0304h7 c0304h7 = this.d;
            c0304h7.getClass();
            HashMap hashMap = new HashMap();
            hashMap.put("preferences", P5.f589a);
            hashMap.put("binary_data", N5.f559a);
            hashMap.put("temp_cache", AbstractC0593sn.f1057a);
            for (ModuleServicesDatabase moduleServicesDatabase : Ia.F.o().b()) {
                for (TableDescription tableDescription : moduleServicesDatabase.getTables()) {
                    hashMap.put(tableDescription.getTableName(), tableDescription.getColumnNames());
                }
            }
            C0295gn c0295gn = c0304h7.c;
            C0552r7 c0552r7 = c0304h7.f879a;
            C0503p7 c0503p7 = c0552r7.e;
            C0528q7 c0528q7 = c0552r7.f;
            Ka ka = new Ka(false);
            ka.a(114, new C0491ok());
            for (ModuleServicesDatabase moduleServicesDatabase2 : Ia.F.o().b()) {
                for (TableDescription tableDescription2 : moduleServicesDatabase2.getTables()) {
                    for (Map.Entry<Integer, DatabaseScript> entry : tableDescription2.getDatabaseProviderUpgradeScript().entrySet()) {
                        ka.a(entry.getKey(), entry.getValue());
                    }
                }
            }
            C0344in c0344in = new C0344in("service database", hashMap);
            c0295gn.getClass();
            this.f = new C0602t7(context, a2, new C0320hn(c0503p7, c0528q7, ka, c0344in), PublicLogger.getAnonymousInstance());
        }
        return this.f;
    }

    public final synchronized InterfaceC0180cb b() {
        return f();
    }

    public final synchronized IBinaryDataHelper a(C0401l5 c0401l5) {
        IBinaryDataHelper iBinaryDataHelper;
        String str = new C0174c5(c0401l5).f793a;
        iBinaryDataHelper = (IBinaryDataHelper) this.c.get(str);
        if (iBinaryDataHelper == null) {
            iBinaryDataHelper = new C0474o3(new C0542ql(c(c0401l5)));
            this.c.put(str, iBinaryDataHelper);
        }
        return iBinaryDataHelper;
    }

    public final synchronized InterfaceC0180cb a() {
        if (this.q == null) {
            this.q = new Ob(f());
        }
        return this.q;
    }

    public final synchronized InterfaceC0180cb c() {
        if (this.m == null) {
            if (this.l == null) {
                this.l = new Nb(new C0542ql(h()));
            }
            this.m = new Ob(this.l);
        }
        return this.m;
    }
}
