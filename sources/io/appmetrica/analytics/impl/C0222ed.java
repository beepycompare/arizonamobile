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
/* renamed from: io.appmetrica.analytics.impl.ed  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0222ed implements Tj {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0634ul f978a;
    public final String b;
    public final SystemTimeProvider c;
    public final List d;
    public final String e;
    public final long f;

    public C0222ed(InterfaceC0634ul interfaceC0634ul, String str, SystemTimeProvider systemTimeProvider, List<C0145bd> list) {
        this.f978a = interfaceC0634ul;
        this.b = str;
        this.c = systemTimeProvider;
        this.d = list;
        this.e = str.toUpperCase(Locale.ROOT) + "_STATUS";
        this.f = TimeUnit.DAYS.toMillis(1L);
    }

    public final Sj a() {
        C0601td c0601td;
        if (this.d.isEmpty()) {
            return null;
        }
        List sortedWith = CollectionsKt.sortedWith(this.d, new C0197dd());
        String c = ((AbstractC0726yd) this.f978a).c(this.e, (String) null);
        if (c != null) {
            try {
                JSONObject jSONObject = new JSONObject(c);
                JSONArray jSONArray = jSONObject.getJSONArray("modulesStatus");
                IntRange until = RangesKt.until(0, jSONArray.length());
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
                Iterator<Integer> it = until.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(((IntIterator) it).nextInt());
                    arrayList.add(new C0145bd(jSONObject2.getString("moduleName"), jSONObject2.getBoolean("loaded")));
                }
                c0601td = new C0601td(arrayList, jSONObject.getLong("lastSendTime"));
            } catch (Throwable unused) {
                c0601td = new C0601td(CollectionsKt.emptyList(), 0L);
            }
        } else {
            c0601td = null;
        }
        long currentTimeMillis = this.c.currentTimeMillis();
        if (c0601td == null || currentTimeMillis - c0601td.b > this.f || !Intrinsics.areEqual(sortedWith, c0601td.f1237a)) {
            C0601td c0601td2 = new C0601td(sortedWith, currentTimeMillis);
            InterfaceC0634ul interfaceC0634ul = this.f978a;
            AbstractC0726yd abstractC0726yd = (AbstractC0726yd) interfaceC0634ul;
            InterfaceC0634ul interfaceC0634ul2 = (InterfaceC0634ul) abstractC0726yd.b(abstractC0726yd.f(this.e), c0601td2.a());
            return new Sj(this.b + "_status", c0601td2.a());
        }
        return null;
    }

    public /* synthetic */ C0222ed(InterfaceC0634ul interfaceC0634ul, String str, SystemTimeProvider systemTimeProvider, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC0634ul, str, (i & 4) != 0 ? new SystemTimeProvider() : systemTimeProvider, list);
    }
}
