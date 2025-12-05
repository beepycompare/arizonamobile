package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.modulesapi.internal.common.TableDescription;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServicesDatabase;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
/* renamed from: io.appmetrica.analytics.impl.zk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0754zk {

    /* renamed from: a  reason: collision with root package name */
    public final C0134b7 f1318a;
    public Z6 b;
    public T2 c;
    public U2 d;
    public C0595tb e;
    public C0620ub f;
    public C0607tn g;
    public C0632un h;
    public final LinkedHashMap i = new LinkedHashMap();
    public final LinkedHashMap j = new LinkedHashMap();
    public final LinkedHashMap k = new LinkedHashMap();

    public C0754zk(File file) {
        this.f1318a = new C0134b7(file);
    }

    public final IBinaryDataHelper a(Context context) {
        T2 t2 = this.c;
        if (t2 == null) {
            T2 t22 = new T2(new C0555rl(f(context)), "binary_data");
            this.c = t22;
            return t22;
        }
        return t2;
    }

    public final synchronized IBinaryDataHelper b(Context context) {
        U2 u2;
        u2 = this.d;
        if (u2 == null) {
            u2 = new U2(a(context));
            this.d = u2;
        }
        return u2;
    }

    public final synchronized IBinaryDataHelper c(Context context) {
        return a(context);
    }

    public final synchronized Ia d(Context context) {
        C0620ub c0620ub;
        c0620ub = this.f;
        if (c0620ub == null) {
            C0595tb c0595tb = this.e;
            if (c0595tb == null) {
                c0595tb = new C0595tb(new C0555rl(f(context)));
                this.e = c0595tb;
            }
            c0620ub = new C0620ub(c0595tb);
            this.f = c0620ub;
        }
        return c0620ub;
    }

    public final synchronized Ia e(Context context) {
        C0595tb c0595tb;
        c0595tb = this.e;
        if (c0595tb == null) {
            c0595tb = new C0595tb(new C0555rl(f(context)));
            this.e = c0595tb;
        }
        return c0595tb;
    }

    public final synchronized Z6 f(Context context) {
        Z6 z6;
        z6 = this.b;
        if (z6 == null) {
            C0134b7 c0134b7 = this.f1318a;
            String a2 = new C0108a7(c0134b7.f896a, c0134b7.b, true).a(context, new C0276gk());
            N6 n6 = AbstractC0689x5.c;
            n6.getClass();
            HashMap hashMap = new HashMap();
            hashMap.put("preferences", InterfaceC0614u5.f1226a);
            hashMap.put("binary_data", AbstractC0564s5.f1196a);
            hashMap.put("temp_cache", AbstractC0682wn.f1271a);
            for (ModuleServicesDatabase moduleServicesDatabase : C0470oa.I.p().b()) {
                for (TableDescription tableDescription : moduleServicesDatabase.getTables()) {
                    hashMap.put(tableDescription.getTableName(), tableDescription.getColumnNames());
                }
            }
            C0330in c0330in = n6.c;
            X6 x6 = n6.f682a;
            V6 v6 = x6.e;
            W6 w6 = x6.f;
            C0520qa c0520qa = new C0520qa(false);
            c0520qa.a(114, new C0302hk());
            for (ModuleServicesDatabase moduleServicesDatabase2 : C0470oa.I.p().b()) {
                for (TableDescription tableDescription2 : moduleServicesDatabase2.getTables()) {
                    for (Map.Entry<Integer, DatabaseScript> entry : tableDescription2.getDatabaseProviderUpgradeScript().entrySet()) {
                        c0520qa.a(entry.getKey(), entry.getValue());
                    }
                }
            }
            C0408ln c0408ln = new C0408ln("service database", hashMap);
            c0330in.getClass();
            z6 = new Z6(context, a2, new C0356jn(v6, w6, c0520qa, c0408ln), PublicLogger.getAnonymousInstance());
            this.b = z6;
        }
        return z6;
    }

    public final synchronized Z6 c(Context context, R4 r4) {
        Object obj;
        String str = new I4(r4).f602a;
        LinkedHashMap linkedHashMap = this.i;
        obj = linkedHashMap.get(str);
        if (obj == null) {
            C0134b7 c0134b7 = this.f1318a;
            String a2 = new C0108a7(c0134b7.f896a, c0134b7.b, false).a(context, new I4(r4));
            N6 n6 = AbstractC0689x5.c;
            n6.getClass();
            String str2 = r4.b;
            if (str2 == null) {
                str2 = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
            }
            String format = String.format("component-%s", str2);
            C0330in c0330in = n6.c;
            X6 x6 = n6.f682a;
            P6 p6 = x6.f831a;
            Q6 q6 = x6.b;
            C0520qa c0520qa = new C0520qa(false);
            c0520qa.a(112, new L4());
            C0408ln c0408ln = new C0408ln(format, n6.b.f1247a);
            c0330in.getClass();
            obj = new Z6(context, a2, new C0356jn(p6, q6, c0520qa, c0408ln), PublicLogger.getAnonymousInstance());
            linkedHashMap.put(str, obj);
        }
        return (Z6) obj;
    }

    public final synchronized IBinaryDataHelper a(Context context, R4 r4) {
        Object obj;
        String str = new I4(r4).f602a;
        LinkedHashMap linkedHashMap = this.k;
        obj = linkedHashMap.get(str);
        if (obj == null) {
            obj = new T2(new C0555rl(c(context, r4)), "binary_data");
            linkedHashMap.put(str, obj);
        }
        return (IBinaryDataHelper) obj;
    }

    public final synchronized Ia b(Context context, R4 r4) {
        Object obj;
        String str = new I4(r4).f602a;
        LinkedHashMap linkedHashMap = this.j;
        obj = linkedHashMap.get(str);
        if (obj == null) {
            obj = new C0595tb(new C0555rl(c(context, r4)));
            linkedHashMap.put(str, obj);
        }
        return (Ia) obj;
    }
}
