package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.gh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0286gh extends AbstractC0185ch {
    public final SafePackageManager b;

    public C0286gh(C0572s5 c0572s5) {
        this(c0572s5, new SafePackageManager());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004d A[Catch: all -> 0x00d0, TryCatch #0 {all -> 0x00d0, blocks: (B:15:0x0043, B:17:0x004d, B:18:0x005d, B:19:0x0066, B:21:0x006c, B:23:0x008f, B:24:0x0094, B:25:0x0098), top: B:28:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d A[Catch: all -> 0x00d0, TryCatch #0 {all -> 0x00d0, blocks: (B:15:0x0043, B:17:0x004d, B:18:0x005d, B:19:0x0066, B:21:0x006c, B:23:0x008f, B:24:0x0094, B:25:0x0098), top: B:28:0x0043 }] */
    @Override // io.appmetrica.analytics.impl.AbstractC0185ch
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(C0325i6 c0325i6) {
        HashSet hashSet;
        ArrayList b;
        C0572s5 c0572s5 = this.f786a;
        if (c0572s5.t.c() && c0572s5.x()) {
            Cif cif = c0572s5.c;
            String e = this.f786a.c.e();
            try {
                if (!TextUtils.isEmpty(e)) {
                    try {
                        hashSet = new HashSet();
                        JSONArray jSONArray = new JSONArray(e);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            hashSet.add(new C0378ka(jSONArray.getJSONObject(i)));
                        }
                    } catch (Throwable unused) {
                        hashSet = null;
                    }
                    b = b();
                    if (!CollectionUtils.areCollectionsEqual(hashSet, b)) {
                        C9 c9 = c0572s5.n;
                        int i2 = c9.k;
                        c9.m = i2;
                        c9.f371a.a(i2).b();
                    } else {
                        JSONArray jSONArray2 = new JSONArray();
                        Iterator it = b.iterator();
                        while (it.hasNext()) {
                            C0378ka c0378ka = (C0378ka) it.next();
                            c0378ka.getClass();
                            JSONObject put = new JSONObject().put("name", c0378ka.f904a).put("required", c0378ka.c);
                            int i3 = c0378ka.b;
                            if (i3 != -1) {
                                put.put(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, i3);
                            }
                            jSONArray2.put(put);
                        }
                        C0325i6 a2 = C0325i6.a(c0325i6, new JSONObject().put("features", jSONArray2).toString());
                        C9 c92 = c0572s5.n;
                        c92.a(a2, Pk.a(c92.c.b(a2), a2.i));
                        int i4 = c92.k;
                        c92.m = i4;
                        c92.f371a.a(i4).b();
                        cif.i(jSONArray2.toString());
                    }
                }
                b = b();
                if (!CollectionUtils.areCollectionsEqual(hashSet, b)) {
                }
            } catch (Throwable unused2) {
            }
            hashSet = null;
        }
        return false;
    }

    public final ArrayList b() {
        AbstractC0353ja c0329ia;
        FeatureInfo[] featureInfoArr;
        try {
            C0572s5 c0572s5 = this.f786a;
            SafePackageManager safePackageManager = this.b;
            Context context = c0572s5.f1038a;
            PackageInfo packageInfo = safePackageManager.getPackageInfo(context, context.getPackageName(), 16384);
            ArrayList arrayList = new ArrayList();
            if (AndroidUtils.isApiAchieved(24)) {
                c0329ia = new C0304ha();
            } else {
                c0329ia = new C0329ia();
            }
            if (packageInfo != null && (featureInfoArr = packageInfo.reqFeatures) != null) {
                for (FeatureInfo featureInfo : featureInfoArr) {
                    arrayList.add(c0329ia.a(featureInfo));
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public C0286gh(C0572s5 c0572s5, SafePackageManager safePackageManager) {
        super(c0572s5);
        this.b = safePackageManager;
    }
}
