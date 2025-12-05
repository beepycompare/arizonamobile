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
/* renamed from: io.appmetrica.analytics.impl.fd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0243fd implements Uj {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0655vl f973a;
    public final String b;
    public final SystemTimeProvider c;
    public final List d;
    public final String e;
    public final long f;

    public C0243fd(InterfaceC0655vl interfaceC0655vl, String str, SystemTimeProvider systemTimeProvider, List<C0166cd> list) {
        this.f973a = interfaceC0655vl;
        this.b = str;
        this.c = systemTimeProvider;
        this.d = list;
        this.e = str.toUpperCase(Locale.ROOT) + "_STATUS";
        this.f = TimeUnit.DAYS.toMillis(1L);
    }

    public final Tj a() {
        C0622ud c0622ud;
        if (this.d.isEmpty()) {
            return null;
        }
        List sortedWith = CollectionsKt.sortedWith(this.d, new C0217ed());
        String c = ((AbstractC0747zd) this.f973a).c(this.e, (String) null);
        if (c != null) {
            try {
                JSONObject jSONObject = new JSONObject(c);
                JSONArray jSONArray = jSONObject.getJSONArray("modulesStatus");
                IntRange until = RangesKt.until(0, jSONArray.length());
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
                Iterator<Integer> it = until.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(((IntIterator) it).nextInt());
                    arrayList.add(new C0166cd(jSONObject2.getString("moduleName"), jSONObject2.getBoolean("loaded")));
                }
                c0622ud = new C0622ud(arrayList, jSONObject.getLong("lastSendTime"));
            } catch (Throwable unused) {
                c0622ud = new C0622ud(CollectionsKt.emptyList(), 0L);
            }
        } else {
            c0622ud = null;
        }
        long currentTimeMillis = this.c.currentTimeMillis();
        if (c0622ud == null || currentTimeMillis - c0622ud.b > this.f || !Intrinsics.areEqual(sortedWith, c0622ud.f1232a)) {
            C0622ud c0622ud2 = new C0622ud(sortedWith, currentTimeMillis);
            InterfaceC0655vl interfaceC0655vl = this.f973a;
            AbstractC0747zd abstractC0747zd = (AbstractC0747zd) interfaceC0655vl;
            InterfaceC0655vl interfaceC0655vl2 = (InterfaceC0655vl) abstractC0747zd.b(abstractC0747zd.f(this.e), c0622ud2.a());
            return new Tj(this.b + "_status", c0622ud2.a());
        }
        return null;
    }

    public /* synthetic */ C0243fd(InterfaceC0655vl interfaceC0655vl, String str, SystemTimeProvider systemTimeProvider, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC0655vl, str, (i & 4) != 0 ? new SystemTimeProvider() : systemTimeProvider, list);
    }
}
