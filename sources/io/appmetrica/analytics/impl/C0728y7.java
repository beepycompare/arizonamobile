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
public final class C0728y7 {
    public static volatile C0728y7 t;
    public final Context e;
    public C0703x7 f;
    public C0703x7 g;
    public C0549r3 h;
    public C0574s3 i;
    public C0549r3 j;
    public C0574s3 k;
    public Sb l;
    public Tb m;
    public C0744yn n;
    public C0769zn o;
    public Sb p;
    public Tb q;
    public C0758zc r;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1163a = new HashMap();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final C0400l7 d = V5.a();
    public final A7 s = new A7();

    public C0728y7(Context context) {
        this.e = context;
    }

    public static C0728y7 a(Context context) {
        if (t == null) {
            synchronized (C0728y7.class) {
                if (t == null) {
                    t = new C0728y7(context.getApplicationContext());
                }
            }
        }
        return t;
    }

    public final synchronized InterfaceC0301hb b(C0476o5 c0476o5) {
        InterfaceC0301hb interfaceC0301hb;
        String str = new C0243f5(c0476o5).f868a;
        interfaceC0301hb = (InterfaceC0301hb) this.b.get(str);
        if (interfaceC0301hb == null) {
            interfaceC0301hb = new Sb(new C0767zl(c(c0476o5)));
            this.b.put(str, interfaceC0301hb);
        }
        return interfaceC0301hb;
    }

    public final synchronized C0703x7 c(C0476o5 c0476o5) {
        C0703x7 c0703x7;
        C0243f5 c0243f5 = new C0243f5(c0476o5);
        c0703x7 = (C0703x7) this.f1163a.get(c0243f5.f868a);
        if (c0703x7 == null) {
            Context context = this.e;
            A7 a7 = this.s;
            String a2 = new C0753z7(a7.f342a, a7.b, false).a(context, c0243f5);
            C0400l7 c0400l7 = this.d;
            c0400l7.getClass();
            String str = c0476o5.b;
            if (str == null) {
                str = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
            }
            String format = String.format("component-%s", str);
            C0520pn c0520pn = c0400l7.c;
            C0653v7 c0653v7 = c0400l7.f962a;
            C0452n7 c0452n7 = c0653v7.f1117a;
            C0478o7 c0478o7 = c0653v7.b;
            Pa pa = new Pa(false);
            pa.a(112, new C0321i5());
            C0569rn c0569rn = new C0569rn(format, c0400l7.b.f692a);
            c0520pn.getClass();
            c0703x7 = new C0703x7(context, a2, new C0545qn(c0452n7, c0478o7, pa, c0569rn), PublicLogger.getAnonymousInstance());
            this.f1163a.put(c0243f5.f868a, c0703x7);
        }
        return c0703x7;
    }

    public final synchronized InterfaceC0301hb d() {
        if (this.l == null) {
            this.l = new Sb(new C0767zl(h()));
        }
        return this.l;
    }

    public final IBinaryDataHelper e() {
        if (this.j == null) {
            if (this.g == null) {
                Context context = this.e;
                A7 a7 = this.s;
                String a2 = new C0753z7(a7.f342a, a7.b, false).a(context, new E2());
                C0400l7 c0400l7 = this.d;
                c0400l7.getClass();
                HashMap hashMap = new HashMap();
                hashMap.put("binary_data", Q5.f631a);
                C0520pn c0520pn = c0400l7.c;
                C0653v7 c0653v7 = c0400l7.f962a;
                C0504p7 c0504p7 = c0653v7.g;
                C0529q7 c0529q7 = c0653v7.h;
                Pa pa = new Pa(false);
                C0569rn c0569rn = new C0569rn("auto_inapp", hashMap);
                c0520pn.getClass();
                this.g = new C0703x7(context, a2, new C0545qn(c0504p7, c0529q7, pa, c0569rn), PublicLogger.getAnonymousInstance());
            }
            this.j = new C0549r3(new C0767zl(this.g));
        }
        return this.j;
    }

    public final InterfaceC0301hb f() {
        C0758zc c0758zc;
        if (this.p == null) {
            synchronized (this) {
                if (this.r == null) {
                    A7 a7 = this.s;
                    String a2 = new C0753z7(a7.f342a, a7.b, true).a(this.e, new C0423m4());
                    Context context = this.e;
                    C0400l7 c0400l7 = this.d;
                    c0400l7.getClass();
                    HashMap hashMap = new HashMap();
                    hashMap.put("preferences", S5.f661a);
                    C0520pn c0520pn = c0400l7.c;
                    C0653v7 c0653v7 = c0400l7.f962a;
                    C0553r7 c0553r7 = c0653v7.c;
                    C0578s7 c0578s7 = c0653v7.d;
                    Pa pa = new Pa(false);
                    pa.a(112, new C0449n4());
                    C0569rn c0569rn = new C0569rn("service database", hashMap);
                    c0520pn.getClass();
                    this.r = new C0758zc(context, a2, new C0731ya(a2), new C0545qn(c0553r7, c0578s7, pa, c0569rn));
                }
                c0758zc = this.r;
            }
            this.p = new Sb(c0758zc);
        }
        return this.p;
    }

    public final IBinaryDataHelper g() {
        if (this.h == null) {
            this.h = new C0549r3(new C0767zl(h()));
        }
        return this.h;
    }

    public final synchronized C0703x7 h() {
        if (this.f == null) {
            Context context = this.e;
            A7 a7 = this.s;
            String a2 = new C0753z7(a7.f342a, a7.b, true).a(context, new C0691wk());
            C0400l7 c0400l7 = this.d;
            c0400l7.getClass();
            HashMap hashMap = new HashMap();
            hashMap.put("preferences", S5.f661a);
            hashMap.put("binary_data", Q5.f631a);
            hashMap.put("temp_cache", Bn.f372a);
            for (ModuleServicesDatabase moduleServicesDatabase : Na.F.o().b()) {
                for (TableDescription tableDescription : moduleServicesDatabase.getTables()) {
                    hashMap.put(tableDescription.getTableName(), tableDescription.getColumnNames());
                }
            }
            C0520pn c0520pn = c0400l7.c;
            C0653v7 c0653v7 = c0400l7.f962a;
            C0603t7 c0603t7 = c0653v7.e;
            C0628u7 c0628u7 = c0653v7.f;
            Pa pa = new Pa(false);
            pa.a(114, new C0716xk());
            for (ModuleServicesDatabase moduleServicesDatabase2 : Na.F.o().b()) {
                for (TableDescription tableDescription2 : moduleServicesDatabase2.getTables()) {
                    for (Map.Entry<Integer, DatabaseScript> entry : tableDescription2.getDatabaseProviderUpgradeScript().entrySet()) {
                        pa.a(entry.getKey(), entry.getValue());
                    }
                }
            }
            C0569rn c0569rn = new C0569rn("service database", hashMap);
            c0520pn.getClass();
            this.f = new C0703x7(context, a2, new C0545qn(c0603t7, c0628u7, pa, c0569rn), PublicLogger.getAnonymousInstance());
        }
        return this.f;
    }

    public final synchronized InterfaceC0301hb b() {
        return f();
    }

    public final synchronized IBinaryDataHelper a(C0476o5 c0476o5) {
        IBinaryDataHelper iBinaryDataHelper;
        String str = new C0243f5(c0476o5).f868a;
        iBinaryDataHelper = (IBinaryDataHelper) this.c.get(str);
        if (iBinaryDataHelper == null) {
            iBinaryDataHelper = new C0549r3(new C0767zl(c(c0476o5)));
            this.c.put(str, iBinaryDataHelper);
        }
        return iBinaryDataHelper;
    }

    public final synchronized InterfaceC0301hb a() {
        if (this.q == null) {
            this.q = new Tb(f());
        }
        return this.q;
    }

    public final synchronized InterfaceC0301hb c() {
        if (this.m == null) {
            if (this.l == null) {
                this.l = new Sb(new C0767zl(h()));
            }
            this.m = new Tb(this.l);
        }
        return this.m;
    }
}
