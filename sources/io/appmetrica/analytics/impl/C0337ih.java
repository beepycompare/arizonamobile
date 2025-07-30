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
/* renamed from: io.appmetrica.analytics.impl.ih  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0337ih extends AbstractC0236eh {
    public final SafePackageManager b;

    public C0337ih(C0574s5 c0574s5) {
        this(c0574s5, new SafePackageManager());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004d A[Catch: all -> 0x00d0, TryCatch #0 {all -> 0x00d0, blocks: (B:15:0x0043, B:17:0x004d, B:18:0x005d, B:19:0x0066, B:21:0x006c, B:23:0x008f, B:24:0x0094, B:25:0x0098), top: B:28:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d A[Catch: all -> 0x00d0, TryCatch #0 {all -> 0x00d0, blocks: (B:15:0x0043, B:17:0x004d, B:18:0x005d, B:19:0x0066, B:21:0x006c, B:23:0x008f, B:24:0x0094, B:25:0x0098), top: B:28:0x0043 }] */
    @Override // io.appmetrica.analytics.impl.AbstractC0236eh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(C0401l6 c0401l6) {
        HashSet hashSet;
        ArrayList b;
        C0574s5 c0574s5 = this.f832a;
        if (c0574s5.t.c() && c0574s5.x()) {
            C0385kf c0385kf = c0574s5.c;
            String e = this.f832a.c.e();
            try {
                if (!TextUtils.isEmpty(e)) {
                    try {
                        hashSet = new HashSet();
                        JSONArray jSONArray = new JSONArray(e);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            hashSet.add(new C0430ma(jSONArray.getJSONObject(i)));
                        }
                    } catch (Throwable unused) {
                        hashSet = null;
                    }
                    b = b();
                    if (!CollectionUtils.areCollectionsEqual(hashSet, b)) {
                        F9 f9 = c0574s5.n;
                        int i2 = f9.k;
                        f9.m = i2;
                        f9.f435a.a(i2).b();
                    } else {
                        JSONArray jSONArray2 = new JSONArray();
                        Iterator it = b.iterator();
                        while (it.hasNext()) {
                            C0430ma c0430ma = (C0430ma) it.next();
                            c0430ma.getClass();
                            JSONObject put = new JSONObject().put("name", c0430ma.f952a).put("required", c0430ma.c);
                            int i3 = c0430ma.b;
                            if (i3 != -1) {
                                put.put(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, i3);
                            }
                            jSONArray2.put(put);
                        }
                        C0401l6 a2 = C0401l6.a(c0401l6, new JSONObject().put("features", jSONArray2).toString());
                        F9 f92 = c0574s5.n;
                        f92.a(a2, Sk.a(f92.c.b(a2), a2.i));
                        int i4 = f92.k;
                        f92.m = i4;
                        f92.f435a.a(i4).b();
                        c0385kf.i(jSONArray2.toString());
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
        AbstractC0405la c0380ka;
        FeatureInfo[] featureInfoArr;
        try {
            C0574s5 c0574s5 = this.f832a;
            SafePackageManager safePackageManager = this.b;
            Context context = c0574s5.f1049a;
            PackageInfo packageInfo = safePackageManager.getPackageInfo(context, context.getPackageName(), 16384);
            ArrayList arrayList = new ArrayList();
            if (AndroidUtils.isApiAchieved(24)) {
                c0380ka = new C0355ja();
            } else {
                c0380ka = new C0380ka();
            }
            if (packageInfo != null && (featureInfoArr = packageInfo.reqFeatures) != null) {
                for (FeatureInfo featureInfo : featureInfoArr) {
                    arrayList.add(c0380ka.a(featureInfo));
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public C0337ih(C0574s5 c0574s5, SafePackageManager safePackageManager) {
        super(c0574s5);
        this.b = safePackageManager;
    }
}
