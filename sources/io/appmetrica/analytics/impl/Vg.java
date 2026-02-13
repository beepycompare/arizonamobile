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
/* loaded from: classes5.dex */
public final class Vg extends Rg {
    public final SafePackageManager b;

    public Vg(X4 x4) {
        this(x4, new SafePackageManager());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004d A[Catch: all -> 0x00d1, TryCatch #0 {all -> 0x00d1, blocks: (B:15:0x0043, B:17:0x004d, B:18:0x005d, B:19:0x0066, B:21:0x006c, B:23:0x008f, B:24:0x0095, B:25:0x0099), top: B:28:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d A[Catch: all -> 0x00d1, TryCatch #0 {all -> 0x00d1, blocks: (B:15:0x0043, B:17:0x004d, B:18:0x005d, B:19:0x0066, B:21:0x006c, B:23:0x008f, B:24:0x0095, B:25:0x0099), top: B:28:0x0043 }] */
    @Override // io.appmetrica.analytics.impl.Rg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(P5 p5) {
        HashSet hashSet;
        ArrayList b;
        X4 x4 = this.f767a;
        if (x4.t.c() && x4.y()) {
            We we = x4.c;
            String e = this.f767a.c.e();
            try {
                if (!TextUtils.isEmpty(e)) {
                    try {
                        hashSet = new HashSet();
                        JSONArray jSONArray = new JSONArray(e);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            hashSet.add(new R9(jSONArray.getJSONObject(i)));
                        }
                    } catch (Throwable unused) {
                        hashSet = null;
                    }
                    b = b();
                    if (!CollectionUtils.areCollectionsEqual(hashSet, b)) {
                        C0373k9 c0373k9 = x4.n;
                        int i2 = c0373k9.j;
                        c0373k9.l = i2;
                        c0373k9.f1079a.a(i2).b();
                    } else {
                        JSONArray jSONArray2 = new JSONArray();
                        Iterator it = b.iterator();
                        while (it.hasNext()) {
                            R9 r9 = (R9) it.next();
                            r9.getClass();
                            JSONObject put = new JSONObject().put("name", r9.f764a).put("required", r9.c);
                            int i3 = r9.b;
                            if (i3 != -1) {
                                put.put(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, i3);
                            }
                            jSONArray2.put(put);
                        }
                        P5 a2 = P5.a(p5, new JSONObject().put("features", jSONArray2).toString());
                        C0373k9 c0373k92 = x4.n;
                        c0373k92.a(a2, Rk.a(c0373k92.c.b(a2), a2.i));
                        int i4 = c0373k92.j;
                        c0373k92.l = i4;
                        c0373k92.f1079a.a(i4).b();
                        we.i(jSONArray2.toString());
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
        Q9 p9;
        FeatureInfo[] featureInfoArr;
        try {
            X4 x4 = this.f767a;
            SafePackageManager safePackageManager = this.b;
            Context context = x4.f848a;
            PackageInfo packageInfo = safePackageManager.getPackageInfo(context, context.getPackageName(), 16384);
            ArrayList arrayList = new ArrayList();
            if (AndroidUtils.isApiAchieved(24)) {
                p9 = new O9();
            } else {
                p9 = new P9();
            }
            if (packageInfo != null && (featureInfoArr = packageInfo.reqFeatures) != null) {
                for (FeatureInfo featureInfo : featureInfoArr) {
                    arrayList.add(p9.a(featureInfo));
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Vg(X4 x4, SafePackageManager safePackageManager) {
        super(x4);
        this.b = safePackageManager;
    }
}
