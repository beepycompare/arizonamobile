package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.adjust.sdk.Constants;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.math.MathKt;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Bg {

    /* renamed from: a  reason: collision with root package name */
    public final Context f413a;
    public final SafePackageManager b;
    public final Ya c;
    public final Kc d;
    public final long e;
    public final String f;
    public final String g;

    public Bg(Context context, SafePackageManager safePackageManager, Ya ya) {
        this.f413a = context;
        this.b = safePackageManager;
        this.c = ya;
        Kc kc = new Kc(0);
        kc.a(EnumC0551rg.d, 1);
        kc.a(EnumC0551rg.c, 2);
        this.d = kc;
        this.e = TimeUnit.DAYS.toSeconds(1L);
        this.f = "com.android.vending";
        this.g = "com.huawei.appmarket";
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x008f, code lost:
        if (((java.lang.Number) r5.component2()).longValue() < r13.e) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0576sg a(List list) {
        C0576sg c0576sg;
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return (C0576sg) list.get(0);
        }
        SafePackageManager safePackageManager = this.b;
        Context context = this.f413a;
        PackageInfo packageInfo = safePackageManager.getPackageInfo(context, context.getPackageName(), 0);
        if (packageInfo != null) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(packageInfo.firstInstallTime);
            Iterator it = list.iterator();
            if (it.hasNext()) {
                C0576sg c0576sg2 = (C0576sg) it.next();
                Pair pair = TuplesKt.to(c0576sg2, Long.valueOf(Math.abs(c0576sg2.c - seconds)));
                while (it.hasNext()) {
                    C0576sg c0576sg3 = (C0576sg) it.next();
                    Pair pair2 = TuplesKt.to(c0576sg3, Long.valueOf(Math.abs(c0576sg3.c - seconds)));
                    if (ComparisonsKt.compareValues((Comparable) pair.getSecond(), (Comparable) pair2.getSecond()) > 0) {
                        pair = pair2;
                    }
                }
                c0576sg = (C0576sg) pair.component1();
            } else {
                throw new NoSuchElementException();
            }
        }
        c0576sg = null;
        if (c0576sg == null) {
            Comparator comparator = new Comparator() { // from class: io.appmetrica.analytics.impl.Bg$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Bg.a(Bg.this, (C0576sg) obj, (C0576sg) obj2);
                }
            };
            Iterator it2 = list.iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            C0576sg c0576sg4 = (C0576sg) it2.next();
            while (it2.hasNext()) {
                C0576sg c0576sg5 = (C0576sg) it2.next();
                if (comparator.compare(c0576sg4, c0576sg5) < 0) {
                    c0576sg4 = c0576sg5;
                }
            }
            c0576sg = c0576sg4;
        }
        Ya ya = this.c;
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            C0576sg c0576sg6 = (C0576sg) it3.next();
            arrayList.add(new JSONObject().put(Constants.REFERRER, c0576sg6.f1114a).put("install_timestamp_seconds", c0576sg6.c).put("click_timestamp_seconds", c0576sg6.b).put("source", c0576sg6.d.f1096a));
        }
        ya.reportEvent("several_filled_referrers", jSONObject.put("candidates", no.a((Collection) arrayList) ? null : new JSONArray((Collection) arrayList)).put("chosen", new JSONObject().put(Constants.REFERRER, c0576sg.f1114a).put("install_timestamp_seconds", c0576sg.c).put("click_timestamp_seconds", c0576sg.b).put("source", c0576sg.d.f1096a)).putOpt("install_time", packageInfo != null ? Long.valueOf(packageInfo.firstInstallTime) : null).toString());
        return c0576sg;
    }

    public /* synthetic */ Bg(Context context) {
        this(context, new SafePackageManager(), AbstractC0661w1.a());
    }

    public static final int a(Bg bg, C0576sg c0576sg, C0576sg c0576sg2) {
        int sign = MathKt.getSign(c0576sg.c - c0576sg2.c);
        return sign == 0 ? ((Number) bg.d.a(c0576sg.d)).intValue() - ((Number) bg.d.a(c0576sg2.d)).intValue() : sign;
    }
}
