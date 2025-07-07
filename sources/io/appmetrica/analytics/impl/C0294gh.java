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
public final class C0294gh extends AbstractC0193ch {
    public final SafePackageManager b;

    public C0294gh(C0580s5 c0580s5) {
        this(c0580s5, new SafePackageManager());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004d A[Catch: all -> 0x00d0, TryCatch #0 {all -> 0x00d0, blocks: (B:15:0x0043, B:17:0x004d, B:18:0x005d, B:19:0x0066, B:21:0x006c, B:23:0x008f, B:24:0x0094, B:25:0x0098), top: B:28:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d A[Catch: all -> 0x00d0, TryCatch #0 {all -> 0x00d0, blocks: (B:15:0x0043, B:17:0x004d, B:18:0x005d, B:19:0x0066, B:21:0x006c, B:23:0x008f, B:24:0x0094, B:25:0x0098), top: B:28:0x0043 }] */
    @Override // io.appmetrica.analytics.impl.AbstractC0193ch
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(C0333i6 c0333i6) {
        HashSet hashSet;
        ArrayList b;
        C0580s5 c0580s5 = this.f785a;
        if (c0580s5.t.c() && c0580s5.x()) {
            Cif cif = c0580s5.c;
            String e = this.f785a.c.e();
            try {
                if (!TextUtils.isEmpty(e)) {
                    try {
                        hashSet = new HashSet();
                        JSONArray jSONArray = new JSONArray(e);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            hashSet.add(new C0386ka(jSONArray.getJSONObject(i)));
                        }
                    } catch (Throwable unused) {
                        hashSet = null;
                    }
                    b = b();
                    if (!CollectionUtils.areCollectionsEqual(hashSet, b)) {
                        C9 c9 = c0580s5.n;
                        int i2 = c9.k;
                        c9.m = i2;
                        c9.f370a.a(i2).b();
                    } else {
                        JSONArray jSONArray2 = new JSONArray();
                        Iterator it = b.iterator();
                        while (it.hasNext()) {
                            C0386ka c0386ka = (C0386ka) it.next();
                            c0386ka.getClass();
                            JSONObject put = new JSONObject().put("name", c0386ka.f903a).put("required", c0386ka.c);
                            int i3 = c0386ka.b;
                            if (i3 != -1) {
                                put.put(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, i3);
                            }
                            jSONArray2.put(put);
                        }
                        C0333i6 a2 = C0333i6.a(c0333i6, new JSONObject().put("features", jSONArray2).toString());
                        C9 c92 = c0580s5.n;
                        c92.a(a2, Pk.a(c92.c.b(a2), a2.i));
                        int i4 = c92.k;
                        c92.m = i4;
                        c92.f370a.a(i4).b();
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
        AbstractC0361ja c0337ia;
        FeatureInfo[] featureInfoArr;
        try {
            C0580s5 c0580s5 = this.f785a;
            SafePackageManager safePackageManager = this.b;
            Context context = c0580s5.f1037a;
            PackageInfo packageInfo = safePackageManager.getPackageInfo(context, context.getPackageName(), 16384);
            ArrayList arrayList = new ArrayList();
            if (AndroidUtils.isApiAchieved(24)) {
                c0337ia = new C0312ha();
            } else {
                c0337ia = new C0337ia();
            }
            if (packageInfo != null && (featureInfoArr = packageInfo.reqFeatures) != null) {
                for (FeatureInfo featureInfo : featureInfoArr) {
                    arrayList.add(c0337ia.a(featureInfo));
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public C0294gh(C0580s5 c0580s5, SafePackageManager safePackageManager) {
        super(c0580s5);
        this.b = safePackageManager;
    }
}
