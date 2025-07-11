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
    public final Context f463a;
    public final SafePackageManager b;
    public final InterfaceC0379kb c;
    public final Wc d;
    public final long e;
    public final String f;
    public final String g;

    public Hg(Context context, SafePackageManager safePackageManager, InterfaceC0379kb interfaceC0379kb) {
        this.f463a = context;
        this.b = safePackageManager;
        this.c = interfaceC0379kb;
        Wc wc = new Wc(0);
        wc.a(EnumC0708xg.d, 1);
        wc.a(EnumC0708xg.c, 2);
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
    public final C0733yg a(List list) {
        C0733yg c0733yg;
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return (C0733yg) list.get(0);
        }
        SafePackageManager safePackageManager = this.b;
        Context context = this.f463a;
        PackageInfo packageInfo = safePackageManager.getPackageInfo(context, context.getPackageName(), 0);
        if (packageInfo != null) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(packageInfo.firstInstallTime);
            Iterator it = list.iterator();
            if (it.hasNext()) {
                C0733yg c0733yg2 = (C0733yg) it.next();
                Pair pair = TuplesKt.to(c0733yg2, Long.valueOf(Math.abs(c0733yg2.c - seconds)));
                while (it.hasNext()) {
                    C0733yg c0733yg3 = (C0733yg) it.next();
                    Pair pair2 = TuplesKt.to(c0733yg3, Long.valueOf(Math.abs(c0733yg3.c - seconds)));
                    if (ComparisonsKt.compareValues((Comparable) pair.getSecond(), (Comparable) pair2.getSecond()) > 0) {
                        pair = pair2;
                    }
                }
                c0733yg = (C0733yg) pair.component1();
            } else {
                throw new NoSuchElementException();
            }
        }
        c0733yg = null;
        if (c0733yg == null) {
            Comparator comparator = new Comparator() { // from class: io.appmetrica.analytics.impl.Hg$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Hg.a(Hg.this, (C0733yg) obj, (C0733yg) obj2);
                }
            };
            Iterator it2 = list.iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            C0733yg c0733yg4 = (C0733yg) it2.next();
            while (it2.hasNext()) {
                C0733yg c0733yg5 = (C0733yg) it2.next();
                if (comparator.compare(c0733yg4, c0733yg5) < 0) {
                    c0733yg4 = c0733yg5;
                }
            }
            c0733yg = c0733yg4;
        }
        InterfaceC0379kb interfaceC0379kb = this.c;
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            C0733yg c0733yg6 = (C0733yg) it3.next();
            arrayList.add(new JSONObject().put(Constants.REFERRER, c0733yg6.f1147a).put("install_timestamp_seconds", c0733yg6.c).put("click_timestamp_seconds", c0733yg6.b).put("source", c0733yg6.d.f1127a));
        }
        interfaceC0379kb.reportEvent("several_filled_referrers", jSONObject.put("candidates", fo.a((Collection) arrayList) ? null : new JSONArray((Collection) arrayList)).put("chosen", new JSONObject().put(Constants.REFERRER, c0733yg.f1147a).put("install_timestamp_seconds", c0733yg.c).put("click_timestamp_seconds", c0733yg.b).put("source", c0733yg.d.f1127a)).putOpt("install_time", packageInfo != null ? Long.valueOf(packageInfo.firstInstallTime) : null).toString());
        return c0733yg;
    }

    public /* synthetic */ Hg(Context context) {
        this(context, new SafePackageManager(), AbstractC0593t1.a());
    }

    public static final int a(Hg hg, C0733yg c0733yg, C0733yg c0733yg2) {
        int sign = MathKt.getSign(c0733yg.c - c0733yg2.c);
        return sign == 0 ? ((Number) hg.d.a(c0733yg.d)).intValue() - ((Number) hg.d.a(c0733yg2.d)).intValue() : sign;
    }
}
