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
/* loaded from: classes4.dex */
public final class Hg {

    /* renamed from: a  reason: collision with root package name */
    public final Context f462a;
    public final SafePackageManager b;
    public final InterfaceC0387kb c;
    public final Wc d;
    public final long e;
    public final String f;
    public final String g;

    public Hg(Context context, SafePackageManager safePackageManager, InterfaceC0387kb interfaceC0387kb) {
        this.f462a = context;
        this.b = safePackageManager;
        this.c = interfaceC0387kb;
        Wc wc = new Wc(0);
        wc.a(EnumC0716xg.d, 1);
        wc.a(EnumC0716xg.c, 2);
        this.d = wc;
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
    public final C0741yg a(List list) {
        C0741yg c0741yg;
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return (C0741yg) list.get(0);
        }
        SafePackageManager safePackageManager = this.b;
        Context context = this.f462a;
        PackageInfo packageInfo = safePackageManager.getPackageInfo(context, context.getPackageName(), 0);
        if (packageInfo != null) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(packageInfo.firstInstallTime);
            Iterator it = list.iterator();
            if (it.hasNext()) {
                C0741yg c0741yg2 = (C0741yg) it.next();
                Pair pair = TuplesKt.to(c0741yg2, Long.valueOf(Math.abs(c0741yg2.c - seconds)));
                while (it.hasNext()) {
                    C0741yg c0741yg3 = (C0741yg) it.next();
                    Pair pair2 = TuplesKt.to(c0741yg3, Long.valueOf(Math.abs(c0741yg3.c - seconds)));
                    if (ComparisonsKt.compareValues((Comparable) pair.getSecond(), (Comparable) pair2.getSecond()) > 0) {
                        pair = pair2;
                    }
                }
                c0741yg = (C0741yg) pair.component1();
            } else {
                throw new NoSuchElementException();
            }
        }
        c0741yg = null;
        if (c0741yg == null) {
            Comparator comparator = new Comparator() { // from class: io.appmetrica.analytics.impl.Hg$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Hg.a(Hg.this, (C0741yg) obj, (C0741yg) obj2);
                }
            };
            Iterator it2 = list.iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            C0741yg c0741yg4 = (C0741yg) it2.next();
            while (it2.hasNext()) {
                C0741yg c0741yg5 = (C0741yg) it2.next();
                if (comparator.compare(c0741yg4, c0741yg5) < 0) {
                    c0741yg4 = c0741yg5;
                }
            }
            c0741yg = c0741yg4;
        }
        InterfaceC0387kb interfaceC0387kb = this.c;
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            C0741yg c0741yg6 = (C0741yg) it3.next();
            arrayList.add(new JSONObject().put(Constants.REFERRER, c0741yg6.f1146a).put("install_timestamp_seconds", c0741yg6.c).put("click_timestamp_seconds", c0741yg6.b).put("source", c0741yg6.d.f1126a));
        }
        interfaceC0387kb.reportEvent("several_filled_referrers", jSONObject.put("candidates", fo.a((Collection) arrayList) ? null : new JSONArray((Collection) arrayList)).put("chosen", new JSONObject().put(Constants.REFERRER, c0741yg.f1146a).put("install_timestamp_seconds", c0741yg.c).put("click_timestamp_seconds", c0741yg.b).put("source", c0741yg.d.f1126a)).putOpt("install_time", packageInfo != null ? Long.valueOf(packageInfo.firstInstallTime) : null).toString());
        return c0741yg;
    }

    public /* synthetic */ Hg(Context context) {
        this(context, new SafePackageManager(), AbstractC0601t1.a());
    }

    public static final int a(Hg hg, C0741yg c0741yg, C0741yg c0741yg2) {
        int sign = MathKt.getSign(c0741yg.c - c0741yg2.c);
        return sign == 0 ? ((Number) hg.d.a(c0741yg.d)).intValue() - ((Number) hg.d.a(c0741yg2.d)).intValue() : sign;
    }
}
