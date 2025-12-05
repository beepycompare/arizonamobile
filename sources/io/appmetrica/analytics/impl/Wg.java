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
public final class Wg extends Sg {
    public final SafePackageManager b;

    public Wg(Y4 y4) {
        this(y4, new SafePackageManager());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004d A[Catch: all -> 0x00d1, TryCatch #0 {all -> 0x00d1, blocks: (B:15:0x0043, B:17:0x004d, B:18:0x005d, B:19:0x0066, B:21:0x006c, B:23:0x008f, B:24:0x0095, B:25:0x0099), top: B:28:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d A[Catch: all -> 0x00d1, TryCatch #0 {all -> 0x00d1, blocks: (B:15:0x0043, B:17:0x004d, B:18:0x005d, B:19:0x0066, B:21:0x006c, B:23:0x008f, B:24:0x0095, B:25:0x0099), top: B:28:0x0043 }] */
    @Override // io.appmetrica.analytics.impl.Sg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(Q5 q5) {
        HashSet hashSet;
        ArrayList b;
        Y4 y4 = this.f762a;
        if (y4.t.c() && y4.y()) {
            Xe xe = y4.c;
            String e = this.f762a.c.e();
            try {
                if (!TextUtils.isEmpty(e)) {
                    try {
                        hashSet = new HashSet();
                        JSONArray jSONArray = new JSONArray(e);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            hashSet.add(new S9(jSONArray.getJSONObject(i)));
                        }
                    } catch (Throwable unused) {
                        hashSet = null;
                    }
                    b = b();
                    if (!CollectionUtils.areCollectionsEqual(hashSet, b)) {
                        C0394l9 c0394l9 = y4.n;
                        int i2 = c0394l9.j;
                        c0394l9.l = i2;
                        c0394l9.f1074a.a(i2).b();
                    } else {
                        JSONArray jSONArray2 = new JSONArray();
                        Iterator it = b.iterator();
                        while (it.hasNext()) {
                            S9 s9 = (S9) it.next();
                            s9.getClass();
                            JSONObject put = new JSONObject().put("name", s9.f759a).put("required", s9.c);
                            int i3 = s9.b;
                            if (i3 != -1) {
                                put.put(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, i3);
                            }
                            jSONArray2.put(put);
                        }
                        Q5 a2 = Q5.a(q5, new JSONObject().put("features", jSONArray2).toString());
                        C0394l9 c0394l92 = y4.n;
                        c0394l92.a(a2, Sk.a(c0394l92.c.b(a2), a2.i));
                        int i4 = c0394l92.j;
                        c0394l92.l = i4;
                        c0394l92.f1074a.a(i4).b();
                        xe.i(jSONArray2.toString());
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
        R9 q9;
        FeatureInfo[] featureInfoArr;
        try {
            Y4 y4 = this.f762a;
            SafePackageManager safePackageManager = this.b;
            Context context = y4.f843a;
            PackageInfo packageInfo = safePackageManager.getPackageInfo(context, context.getPackageName(), 16384);
            ArrayList arrayList = new ArrayList();
            if (AndroidUtils.isApiAchieved(24)) {
                q9 = new P9();
            } else {
                q9 = new Q9();
            }
            if (packageInfo != null && (featureInfoArr = packageInfo.reqFeatures) != null) {
                for (FeatureInfo featureInfo : featureInfoArr) {
                    arrayList.add(q9.a(featureInfo));
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Wg(Y4 y4, SafePackageManager safePackageManager) {
        super(y4);
        this.b = safePackageManager;
    }
}
