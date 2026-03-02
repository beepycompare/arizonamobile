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
/* renamed from: io.appmetrica.analytics.impl.yk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0732yk {

    /* renamed from: a  reason: collision with root package name */
    public final C0112a7 f1323a;
    public Y6 b;
    public S2 c;
    public T2 d;
    public C0573sb e;
    public C0598tb f;
    public C0585sn g;
    public C0610tn h;
    public final LinkedHashMap i = new LinkedHashMap();
    public final LinkedHashMap j = new LinkedHashMap();
    public final LinkedHashMap k = new LinkedHashMap();

    public C0732yk(File file) {
        this.f1323a = new C0112a7(file);
    }

    public final IBinaryDataHelper a(Context context) {
        S2 s2 = this.c;
        if (s2 == null) {
            S2 s22 = new S2(new C0534ql(f(context)), "binary_data");
            this.c = s22;
            return s22;
        }
        return s2;
    }

    public final synchronized IBinaryDataHelper b(Context context) {
        T2 t2;
        t2 = this.d;
        if (t2 == null) {
            t2 = new T2(a(context));
            this.d = t2;
        }
        return t2;
    }

    public final synchronized IBinaryDataHelper c(Context context) {
        return a(context);
    }

    public final synchronized Ha d(Context context) {
        C0598tb c0598tb;
        c0598tb = this.f;
        if (c0598tb == null) {
            C0573sb c0573sb = this.e;
            if (c0573sb == null) {
                c0573sb = new C0573sb(new C0534ql(f(context)));
                this.e = c0573sb;
            }
            c0598tb = new C0598tb(c0573sb);
            this.f = c0598tb;
        }
        return c0598tb;
    }

    public final synchronized Ha e(Context context) {
        C0573sb c0573sb;
        c0573sb = this.e;
        if (c0573sb == null) {
            c0573sb = new C0573sb(new C0534ql(f(context)));
            this.e = c0573sb;
        }
        return c0573sb;
    }

    public final synchronized Y6 f(Context context) {
        Y6 y6;
        y6 = this.b;
        if (y6 == null) {
            C0112a7 c0112a7 = this.f1323a;
            String a2 = new Z6(c0112a7.f900a, c0112a7.b, true).a(context, new C0254fk());
            M6 m6 = AbstractC0667w5.c;
            m6.getClass();
            HashMap hashMap = new HashMap();
            hashMap.put("preferences", InterfaceC0592t5.f1230a);
            hashMap.put("binary_data", AbstractC0542r5.f1201a);
            hashMap.put("temp_cache", AbstractC0660vn.f1276a);
            for (ModuleServicesDatabase moduleServicesDatabase : C0448na.I.p().b()) {
                for (TableDescription tableDescription : moduleServicesDatabase.getTables()) {
                    hashMap.put(tableDescription.getTableName(), tableDescription.getColumnNames());
                }
            }
            C0309hn c0309hn = m6.c;
            W6 w6 = m6.f687a;
            U6 u6 = w6.e;
            V6 v6 = w6.f;
            C0498pa c0498pa = new C0498pa(false);
            c0498pa.a(114, new C0280gk());
            for (ModuleServicesDatabase moduleServicesDatabase2 : C0448na.I.p().b()) {
                for (TableDescription tableDescription2 : moduleServicesDatabase2.getTables()) {
                    for (Map.Entry<Integer, DatabaseScript> entry : tableDescription2.getDatabaseProviderUpgradeScript().entrySet()) {
                        c0498pa.a(entry.getKey(), entry.getValue());
                    }
                }
            }
            C0386kn c0386kn = new C0386kn("service database", hashMap);
            c0309hn.getClass();
            y6 = new Y6(context, a2, new C0334in(u6, v6, c0498pa, c0386kn), PublicLogger.getAnonymousInstance());
            this.b = y6;
        }
        return y6;
    }

    public final synchronized Y6 c(Context context, Q4 q4) {
        Object obj;
        String str = new H4(q4).f608a;
        LinkedHashMap linkedHashMap = this.i;
        obj = linkedHashMap.get(str);
        if (obj == null) {
            C0112a7 c0112a7 = this.f1323a;
            String a2 = new Z6(c0112a7.f900a, c0112a7.b, false).a(context, new H4(q4));
            M6 m6 = AbstractC0667w5.c;
            m6.getClass();
            String str2 = q4.b;
            if (str2 == null) {
                str2 = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
            }
            String format = String.format("component-%s", str2);
            C0309hn c0309hn = m6.c;
            W6 w6 = m6.f687a;
            O6 o6 = w6.f837a;
            P6 p6 = w6.b;
            C0498pa c0498pa = new C0498pa(false);
            c0498pa.a(112, new K4());
            C0386kn c0386kn = new C0386kn(format, m6.b.f1251a);
            c0309hn.getClass();
            obj = new Y6(context, a2, new C0334in(o6, p6, c0498pa, c0386kn), PublicLogger.getAnonymousInstance());
            linkedHashMap.put(str, obj);
        }
        return (Y6) obj;
    }

    public final synchronized IBinaryDataHelper a(Context context, Q4 q4) {
        Object obj;
        String str = new H4(q4).f608a;
        LinkedHashMap linkedHashMap = this.k;
        obj = linkedHashMap.get(str);
        if (obj == null) {
            obj = new S2(new C0534ql(c(context, q4)), "binary_data");
            linkedHashMap.put(str, obj);
        }
        return (IBinaryDataHelper) obj;
    }

    public final synchronized Ha b(Context context, Q4 q4) {
        Object obj;
        String str = new H4(q4).f608a;
        LinkedHashMap linkedHashMap = this.j;
        obj = linkedHashMap.get(str);
        if (obj == null) {
            obj = new C0573sb(new C0534ql(c(context, q4)));
            linkedHashMap.put(str, obj);
        }
        return (Ha) obj;
    }
}
