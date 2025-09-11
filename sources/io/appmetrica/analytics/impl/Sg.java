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
public final class Sg {

    /* renamed from: a  reason: collision with root package name */
    public final Context f671a;
    public final SafePackageManager b;
    public final InterfaceC0557rb c;
    public final C0200dd d;
    public final long e;
    public final String f;
    public final String g;

    public Sg(Context context, SafePackageManager safePackageManager, InterfaceC0557rb interfaceC0557rb) {
        this.f671a = context;
        this.b = safePackageManager;
        this.c = interfaceC0557rb;
        C0200dd c0200dd = new C0200dd(0);
        c0200dd.a(Ig.d, 1);
        c0200dd.a(Ig.c, 2);
        this.d = c0200dd;
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
    public final Jg a(List list) {
        Jg jg;
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return (Jg) list.get(0);
        }
        SafePackageManager safePackageManager = this.b;
        Context context = this.f671a;
        PackageInfo packageInfo = safePackageManager.getPackageInfo(context, context.getPackageName(), 0);
        if (packageInfo != null) {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(packageInfo.firstInstallTime);
            Iterator it = list.iterator();
            if (it.hasNext()) {
                Jg jg2 = (Jg) it.next();
                Pair pair = TuplesKt.to(jg2, Long.valueOf(Math.abs(jg2.c - seconds)));
                while (it.hasNext()) {
                    Jg jg3 = (Jg) it.next();
                    Pair pair2 = TuplesKt.to(jg3, Long.valueOf(Math.abs(jg3.c - seconds)));
                    if (ComparisonsKt.compareValues((Comparable) pair.getSecond(), (Comparable) pair2.getSecond()) > 0) {
                        pair = pair2;
                    }
                }
                jg = (Jg) pair.component1();
            } else {
                throw new NoSuchElementException();
            }
        }
        jg = null;
        if (jg == null) {
            Comparator comparator = new Comparator() { // from class: io.appmetrica.analytics.impl.Sg$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Sg.a(Sg.this, (Jg) obj, (Jg) obj2);
                }
            };
            Iterator it2 = list.iterator();
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            Jg jg4 = (Jg) it2.next();
            while (it2.hasNext()) {
                Jg jg5 = (Jg) it2.next();
                if (comparator.compare(jg4, jg5) < 0) {
                    jg4 = jg5;
                }
            }
            jg = jg4;
        }
        InterfaceC0557rb interfaceC0557rb = this.c;
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            Jg jg6 = (Jg) it3.next();
            arrayList.add(new JSONObject().put(Constants.REFERRER, jg6.f519a).put("install_timestamp_seconds", jg6.c).put("click_timestamp_seconds", jg6.b).put("source", jg6.d.f499a));
        }
        interfaceC0557rb.reportEvent("several_filled_referrers", jSONObject.put("candidates", ro.a((Collection) arrayList) ? null : new JSONArray((Collection) arrayList)).put("chosen", new JSONObject().put(Constants.REFERRER, jg.f519a).put("install_timestamp_seconds", jg.c).put("click_timestamp_seconds", jg.b).put("source", jg.d.f499a)).putOpt("install_time", packageInfo != null ? Long.valueOf(packageInfo.firstInstallTime) : null).toString());
        return jg;
    }

    public /* synthetic */ Sg(Context context) {
        this(context, new SafePackageManager(), AbstractC0647v1.a());
    }

    public static final int a(Sg sg, Jg jg, Jg jg2) {
        int sign = MathKt.getSign(jg.c - jg2.c);
        return sign == 0 ? ((Number) sg.d.a(jg.d)).intValue() - ((Number) sg.d.a(jg2.d)).intValue() : sign;
    }
}
