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
/* renamed from: io.appmetrica.analytics.impl.y7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0729y7 {
    public static volatile C0729y7 t;
    public final Context e;
    public C0704x7 f;
    public C0704x7 g;
    public C0550r3 h;
    public C0575s3 i;
    public C0550r3 j;
    public C0575s3 k;
    public Sb l;
    public Tb m;
    public C0745yn n;
    public C0770zn o;
    public Sb p;
    public Tb q;
    public C0759zc r;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1168a = new HashMap();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final C0401l7 d = V5.a();
    public final A7 s = new A7();

    public C0729y7(Context context) {
        this.e = context;
    }

    public static C0729y7 a(Context context) {
        if (t == null) {
            synchronized (C0729y7.class) {
                if (t == null) {
                    t = new C0729y7(context.getApplicationContext());
                }
            }
        }
        return t;
    }

    public final synchronized InterfaceC0302hb b(C0477o5 c0477o5) {
        InterfaceC0302hb interfaceC0302hb;
        String str = new C0244f5(c0477o5).f873a;
        interfaceC0302hb = (InterfaceC0302hb) this.b.get(str);
        if (interfaceC0302hb == null) {
            interfaceC0302hb = new Sb(new C0768zl(c(c0477o5)));
            this.b.put(str, interfaceC0302hb);
        }
        return interfaceC0302hb;
    }

    public final synchronized C0704x7 c(C0477o5 c0477o5) {
        C0704x7 c0704x7;
        C0244f5 c0244f5 = new C0244f5(c0477o5);
        c0704x7 = (C0704x7) this.f1168a.get(c0244f5.f873a);
        if (c0704x7 == null) {
            Context context = this.e;
            A7 a7 = this.s;
            String a2 = new C0754z7(a7.f347a, a7.b, false).a(context, c0244f5);
            C0401l7 c0401l7 = this.d;
            c0401l7.getClass();
            String str = c0477o5.b;
            if (str == null) {
                str = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
            }
            String format = String.format("component-%s", str);
            C0521pn c0521pn = c0401l7.c;
            C0654v7 c0654v7 = c0401l7.f967a;
            C0453n7 c0453n7 = c0654v7.f1122a;
            C0479o7 c0479o7 = c0654v7.b;
            Pa pa = new Pa(false);
            pa.a(112, new C0322i5());
            C0570rn c0570rn = new C0570rn(format, c0401l7.b.f697a);
            c0521pn.getClass();
            c0704x7 = new C0704x7(context, a2, new C0546qn(c0453n7, c0479o7, pa, c0570rn), PublicLogger.getAnonymousInstance());
            this.f1168a.put(c0244f5.f873a, c0704x7);
        }
        return c0704x7;
    }

    public final synchronized InterfaceC0302hb d() {
        if (this.l == null) {
            this.l = new Sb(new C0768zl(h()));
        }
        return this.l;
    }

    public final IBinaryDataHelper e() {
        if (this.j == null) {
            if (this.g == null) {
                Context context = this.e;
                A7 a7 = this.s;
                String a2 = new C0754z7(a7.f347a, a7.b, false).a(context, new E2());
                C0401l7 c0401l7 = this.d;
                c0401l7.getClass();
                HashMap hashMap = new HashMap();
                hashMap.put("binary_data", Q5.f636a);
                C0521pn c0521pn = c0401l7.c;
                C0654v7 c0654v7 = c0401l7.f967a;
                C0505p7 c0505p7 = c0654v7.g;
                C0530q7 c0530q7 = c0654v7.h;
                Pa pa = new Pa(false);
                C0570rn c0570rn = new C0570rn("auto_inapp", hashMap);
                c0521pn.getClass();
                this.g = new C0704x7(context, a2, new C0546qn(c0505p7, c0530q7, pa, c0570rn), PublicLogger.getAnonymousInstance());
            }
            this.j = new C0550r3(new C0768zl(this.g));
        }
        return this.j;
    }

    public final InterfaceC0302hb f() {
        C0759zc c0759zc;
        if (this.p == null) {
            synchronized (this) {
                if (this.r == null) {
                    A7 a7 = this.s;
                    String a2 = new C0754z7(a7.f347a, a7.b, true).a(this.e, new C0424m4());
                    Context context = this.e;
                    C0401l7 c0401l7 = this.d;
                    c0401l7.getClass();
                    HashMap hashMap = new HashMap();
                    hashMap.put("preferences", S5.f666a);
                    C0521pn c0521pn = c0401l7.c;
                    C0654v7 c0654v7 = c0401l7.f967a;
                    C0554r7 c0554r7 = c0654v7.c;
                    C0579s7 c0579s7 = c0654v7.d;
                    Pa pa = new Pa(false);
                    pa.a(112, new C0450n4());
                    C0570rn c0570rn = new C0570rn("service database", hashMap);
                    c0521pn.getClass();
                    this.r = new C0759zc(context, a2, new C0732ya(a2), new C0546qn(c0554r7, c0579s7, pa, c0570rn));
                }
                c0759zc = this.r;
            }
            this.p = new Sb(c0759zc);
        }
        return this.p;
    }

    public final IBinaryDataHelper g() {
        if (this.h == null) {
            this.h = new C0550r3(new C0768zl(h()));
        }
        return this.h;
    }

    public final synchronized C0704x7 h() {
        if (this.f == null) {
            Context context = this.e;
            A7 a7 = this.s;
            String a2 = new C0754z7(a7.f347a, a7.b, true).a(context, new C0692wk());
            C0401l7 c0401l7 = this.d;
            c0401l7.getClass();
            HashMap hashMap = new HashMap();
            hashMap.put("preferences", S5.f666a);
            hashMap.put("binary_data", Q5.f636a);
            hashMap.put("temp_cache", Bn.f377a);
            for (ModuleServicesDatabase moduleServicesDatabase : Na.F.o().b()) {
                for (TableDescription tableDescription : moduleServicesDatabase.getTables()) {
                    hashMap.put(tableDescription.getTableName(), tableDescription.getColumnNames());
                }
            }
            C0521pn c0521pn = c0401l7.c;
            C0654v7 c0654v7 = c0401l7.f967a;
            C0604t7 c0604t7 = c0654v7.e;
            C0629u7 c0629u7 = c0654v7.f;
            Pa pa = new Pa(false);
            pa.a(114, new C0717xk());
            for (ModuleServicesDatabase moduleServicesDatabase2 : Na.F.o().b()) {
                for (TableDescription tableDescription2 : moduleServicesDatabase2.getTables()) {
                    for (Map.Entry<Integer, DatabaseScript> entry : tableDescription2.getDatabaseProviderUpgradeScript().entrySet()) {
                        pa.a(entry.getKey(), entry.getValue());
                    }
                }
            }
            C0570rn c0570rn = new C0570rn("service database", hashMap);
            c0521pn.getClass();
            this.f = new C0704x7(context, a2, new C0546qn(c0604t7, c0629u7, pa, c0570rn), PublicLogger.getAnonymousInstance());
        }
        return this.f;
    }

    public final synchronized InterfaceC0302hb b() {
        return f();
    }

    public final synchronized IBinaryDataHelper a(C0477o5 c0477o5) {
        IBinaryDataHelper iBinaryDataHelper;
        String str = new C0244f5(c0477o5).f873a;
        iBinaryDataHelper = (IBinaryDataHelper) this.c.get(str);
        if (iBinaryDataHelper == null) {
            iBinaryDataHelper = new C0550r3(new C0768zl(c(c0477o5)));
            this.c.put(str, iBinaryDataHelper);
        }
        return iBinaryDataHelper;
    }

    public final synchronized InterfaceC0302hb a() {
        if (this.q == null) {
            this.q = new Tb(f());
        }
        return this.q;
    }

    public final synchronized InterfaceC0302hb c() {
        if (this.m == null) {
            if (this.l == null) {
                this.l = new Sb(new C0768zl(h()));
            }
            this.m = new Tb(this.l);
        }
        return this.m;
    }
}
