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
/* renamed from: io.appmetrica.analytics.impl.al  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0127al {

    /* renamed from: a  reason: collision with root package name */
    public final C0552r7 f893a;
    public C0501p7 b;
    public C0238f3 c;
    public C0264g3 d;
    public Ub e;
    public Vb f;
    public Un g;
    public Vn h;
    public final LinkedHashMap i = new LinkedHashMap();
    public final LinkedHashMap j = new LinkedHashMap();
    public final LinkedHashMap k = new LinkedHashMap();

    public C0127al(File file) {
        this.f893a = new C0552r7(file);
    }

    public final IBinaryDataHelper a(Context context) {
        C0238f3 c0238f3 = this.c;
        if (c0238f3 == null) {
            C0238f3 c0238f32 = new C0238f3(new Vl(f(context)), "binary_data");
            this.c = c0238f32;
            return c0238f32;
        }
        return c0238f3;
    }

    public final synchronized IBinaryDataHelper b(Context context) {
        C0264g3 c0264g3;
        c0264g3 = this.d;
        if (c0264g3 == null) {
            c0264g3 = new C0264g3(a(context));
            this.d = c0264g3;
        }
        return c0264g3;
    }

    public final synchronized IBinaryDataHelper c(Context context) {
        return a(context);
    }

    public final synchronized InterfaceC0349jb d(Context context) {
        Vb vb;
        vb = this.f;
        if (vb == null) {
            Ub ub = this.e;
            if (ub == null) {
                ub = new Ub("preferences", new Vl(f(context)), Na.I.d.e());
                this.e = ub;
            }
            vb = new Vb(ub);
            this.f = vb;
        }
        return vb;
    }

    public final synchronized InterfaceC0349jb e(Context context) {
        Ub ub;
        ub = this.e;
        if (ub == null) {
            ub = new Ub("preferences", new Vl(f(context)), Na.I.d.e());
            this.e = ub;
        }
        return ub;
    }

    public final synchronized C0501p7 f(Context context) {
        C0501p7 c0501p7;
        c0501p7 = this.b;
        if (c0501p7 == null) {
            C0552r7 c0552r7 = this.f893a;
            String a2 = new C0527q7(c0552r7.f1181a, c0552r7.b, true).a(context, new Hk());
            C0191d7 c0191d7 = M5.c;
            c0191d7.getClass();
            HashMap hashMap = new HashMap();
            hashMap.put("preferences", J5.f608a);
            hashMap.put("binary_data", H5.f574a);
            hashMap.put("temp_cache", Yn.f865a);
            for (ModuleServicesDatabase moduleServicesDatabase : Na.I.p().a()) {
                for (TableDescription tableDescription : moduleServicesDatabase.getTables()) {
                    hashMap.put(tableDescription.getTableName(), tableDescription.getColumnNames());
                }
            }
            In in = c0191d7.c;
            C0449n7 c0449n7 = c0191d7.f942a;
            C0397l7 c0397l7 = c0449n7.e;
            C0423m7 c0423m7 = c0449n7.f;
            Sa sa = new Sa(false);
            sa.a(114, new Ik());
            for (ModuleServicesDatabase moduleServicesDatabase2 : Na.I.p().a()) {
                for (TableDescription tableDescription2 : moduleServicesDatabase2.getTables()) {
                    for (Map.Entry<Integer, DatabaseScript> entry : tableDescription2.getDatabaseProviderUpgradeScript().entrySet()) {
                        sa.a(entry.getKey(), entry.getValue());
                    }
                }
            }
            Ln ln = new Ln("service database", hashMap);
            in.getClass();
            c0501p7 = new C0501p7(context, a2, new Jn(c0397l7, c0423m7, sa, ln), PublicLogger.getAnonymousInstance());
            this.b = c0501p7;
        }
        return c0501p7;
    }

    public final synchronized C0501p7 c(Context context, C0266g5 c0266g5) {
        Object obj;
        String str = new X4(c0266g5).f838a;
        LinkedHashMap linkedHashMap = this.i;
        obj = linkedHashMap.get(str);
        if (obj == null) {
            C0552r7 c0552r7 = this.f893a;
            String a2 = new C0527q7(c0552r7.f1181a, c0552r7.b, false).a(context, new X4(c0266g5));
            C0191d7 c0191d7 = M5.c;
            c0191d7.getClass();
            String str2 = c0266g5.b;
            if (str2 == null) {
                str2 = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
            }
            String format = String.format("component-%s", str2);
            In in = c0191d7.c;
            C0449n7 c0449n7 = c0191d7.f942a;
            C0242f7 c0242f7 = c0449n7.f1113a;
            C0268g7 c0268g7 = c0449n7.b;
            Sa sa = new Sa(false);
            sa.a(112, new C0111a5());
            Ln ln = new Ln(format, c0191d7.b.f662a);
            in.getClass();
            obj = new C0501p7(context, a2, new Jn(c0242f7, c0268g7, sa, ln), PublicLogger.getAnonymousInstance());
            linkedHashMap.put(str, obj);
        }
        return (C0501p7) obj;
    }

    public final synchronized IBinaryDataHelper a(Context context, C0266g5 c0266g5) {
        Object obj;
        String str = new X4(c0266g5).f838a;
        LinkedHashMap linkedHashMap = this.k;
        obj = linkedHashMap.get(str);
        if (obj == null) {
            obj = new C0238f3(new Vl(c(context, c0266g5)), "binary_data");
            linkedHashMap.put(str, obj);
        }
        return (IBinaryDataHelper) obj;
    }

    public final synchronized InterfaceC0349jb b(Context context, C0266g5 c0266g5) {
        Object obj;
        String str = new X4(c0266g5).f838a;
        LinkedHashMap linkedHashMap = this.j;
        obj = linkedHashMap.get(str);
        if (obj == null) {
            obj = new Ub("preferences", new Vl(c(context, c0266g5)), Na.I.d.e());
            linkedHashMap.put(str, obj);
        }
        return (InterfaceC0349jb) obj;
    }
}
