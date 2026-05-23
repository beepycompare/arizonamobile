package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Ed implements InterfaceC0618tk {

    /* renamed from: a  reason: collision with root package name */
    public final Zl f527a;
    public final String b;
    public final SystemTimeProvider c;
    public final List d;
    public final String e;
    public final long f;

    public Ed(Zl zl, String str, SystemTimeProvider systemTimeProvider, List<Bd> list) {
        this.f527a = zl;
        this.b = str;
        this.c = systemTimeProvider;
        this.d = list;
        this.e = str.toUpperCase(Locale.ROOT) + "_STATUS";
        this.f = TimeUnit.DAYS.toMillis(1L);
    }

    public final C0592sk a() {
        Td td;
        if (this.d.isEmpty()) {
            return null;
        }
        List sortedWith = CollectionsKt.sortedWith(this.d, new Dd());
        String a2 = ((Yd) this.f527a).a(this.e, (String) null);
        if (a2 != null) {
            try {
                JSONObject jSONObject = new JSONObject(a2);
                JSONArray jSONArray = jSONObject.getJSONArray("modulesStatus");
                IntRange until = RangesKt.until(0, jSONArray.length());
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
                Iterator<Integer> it = until.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(((IntIterator) it).nextInt());
                    arrayList.add(new Bd(jSONObject2.getString("moduleName"), jSONObject2.getBoolean("loaded")));
                }
                td = new Td(arrayList, jSONObject.getLong("lastSendTime"));
            } catch (Throwable unused) {
                td = new Td(CollectionsKt.emptyList(), 0L);
            }
        } else {
            td = null;
        }
        long currentTimeMillis = this.c.currentTimeMillis();
        if (td == null || currentTimeMillis - td.b > this.f || !Intrinsics.areEqual(sortedWith, td.f775a)) {
            Td td2 = new Td(sortedWith, currentTimeMillis);
            Zl zl = this.f527a;
            Yd yd = (Yd) zl;
            yd.d(yd.g(this.e), td2.a());
            return new C0592sk(this.b + "_status", td2.a());
        }
        return null;
    }

    public /* synthetic */ Ed(Zl zl, String str, SystemTimeProvider systemTimeProvider, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(zl, str, (i & 4) != 0 ? new SystemTimeProvider() : systemTimeProvider, list);
    }
}
