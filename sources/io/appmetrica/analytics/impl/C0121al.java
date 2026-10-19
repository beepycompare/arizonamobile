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
public final class C0121al {

    /* renamed from: a  reason: collision with root package name */
    public final C0546r7 f896a;
    public C0495p7 b;
    public C0232f3 c;
    public C0258g3 d;
    public Ub e;
    public Vb f;
    public Un g;
    public Vn h;
    public final LinkedHashMap i = new LinkedHashMap();
    public final LinkedHashMap j = new LinkedHashMap();
    public final LinkedHashMap k = new LinkedHashMap();

    public C0121al(File file) {
        this.f896a = new C0546r7(file);
    }

    public final IBinaryDataHelper a(Context context) {
        C0232f3 c0232f3 = this.c;
        if (c0232f3 == null) {
            C0232f3 c0232f32 = new C0232f3(new Vl(f(context)), "binary_data");
            this.c = c0232f32;
            return c0232f32;
        }
        return c0232f3;
    }

    public final synchronized IBinaryDataHelper b(Context context) {
        C0258g3 c0258g3;
        c0258g3 = this.d;
        if (c0258g3 == null) {
            c0258g3 = new C0258g3(a(context));
            this.d = c0258g3;
        }
        return c0258g3;
    }

    public final synchronized IBinaryDataHelper c(Context context) {
        return a(context);
    }

    public final synchronized InterfaceC0343jb d(Context context) {
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

    public final synchronized InterfaceC0343jb e(Context context) {
        Ub ub;
        ub = this.e;
        if (ub == null) {
            ub = new Ub("preferences", new Vl(f(context)), Na.I.d.e());
            this.e = ub;
        }
        return ub;
    }

    public final synchronized C0495p7 f(Context context) {
        C0495p7 c0495p7;
        c0495p7 = this.b;
        if (c0495p7 == null) {
            C0546r7 c0546r7 = this.f896a;
            String a2 = new C0521q7(c0546r7.f1184a, c0546r7.b, true).a(context, new Hk());
            C0185d7 c0185d7 = M5.c;
            c0185d7.getClass();
            HashMap hashMap = new HashMap();
            hashMap.put("preferences", J5.f611a);
            hashMap.put("binary_data", H5.f577a);
            hashMap.put("temp_cache", Yn.f868a);
            for (ModuleServicesDatabase moduleServicesDatabase : Na.I.p().a()) {
                for (TableDescription tableDescription : moduleServicesDatabase.getTables()) {
                    hashMap.put(tableDescription.getTableName(), tableDescription.getColumnNames());
                }
            }
            In in = c0185d7.c;
            C0443n7 c0443n7 = c0185d7.f945a;
            C0391l7 c0391l7 = c0443n7.e;
            C0417m7 c0417m7 = c0443n7.f;
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
            c0495p7 = new C0495p7(context, a2, new Jn(c0391l7, c0417m7, sa, ln), PublicLogger.getAnonymousInstance());
            this.b = c0495p7;
        }
        return c0495p7;
    }

    public final synchronized C0495p7 c(Context context, C0260g5 c0260g5) {
        Object obj;
        String str = new X4(c0260g5).f841a;
        LinkedHashMap linkedHashMap = this.i;
        obj = linkedHashMap.get(str);
        if (obj == null) {
            C0546r7 c0546r7 = this.f896a;
            String a2 = new C0521q7(c0546r7.f1184a, c0546r7.b, false).a(context, new X4(c0260g5));
            C0185d7 c0185d7 = M5.c;
            c0185d7.getClass();
            String str2 = c0260g5.b;
            if (str2 == null) {
                str2 = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
            }
            String format = String.format("component-%s", str2);
            In in = c0185d7.c;
            C0443n7 c0443n7 = c0185d7.f945a;
            C0236f7 c0236f7 = c0443n7.f1116a;
            C0262g7 c0262g7 = c0443n7.b;
            Sa sa = new Sa(false);
            sa.a(112, new C0105a5());
            Ln ln = new Ln(format, c0185d7.b.f665a);
            in.getClass();
            obj = new C0495p7(context, a2, new Jn(c0236f7, c0262g7, sa, ln), PublicLogger.getAnonymousInstance());
            linkedHashMap.put(str, obj);
        }
        return (C0495p7) obj;
    }

    public final synchronized IBinaryDataHelper a(Context context, C0260g5 c0260g5) {
        Object obj;
        String str = new X4(c0260g5).f841a;
        LinkedHashMap linkedHashMap = this.k;
        obj = linkedHashMap.get(str);
        if (obj == null) {
            obj = new C0232f3(new Vl(c(context, c0260g5)), "binary_data");
            linkedHashMap.put(str, obj);
        }
        return (IBinaryDataHelper) obj;
    }

    public final synchronized InterfaceC0343jb b(Context context, C0260g5 c0260g5) {
        Object obj;
        String str = new X4(c0260g5).f841a;
        LinkedHashMap linkedHashMap = this.j;
        obj = linkedHashMap.get(str);
        if (obj == null) {
            obj = new Ub("preferences", new Vl(c(context, c0260g5)), Na.I.d.e());
            linkedHashMap.put(str, obj);
        }
        return (InterfaceC0343jb) obj;
    }
}
