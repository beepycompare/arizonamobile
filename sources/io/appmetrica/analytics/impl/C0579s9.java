package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.LinkedList;
/* renamed from: io.appmetrica.analytics.impl.s9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0579s9 extends Qf {

    /* renamed from: a  reason: collision with root package name */
    public final Ei f1050a;
    public final HashMap b;
    public final L4 c;

    public C0579s9(C0575s5 c0575s5) {
        Ei ei = new Ei(c0575s5);
        this.f1050a = ei;
        this.c = new L4(ei);
        this.b = a();
    }

    public final HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put(EnumC0681wb.EVENT_TYPE_ACTIVATION, new C0296h(this.f1050a));
        hashMap.put(EnumC0681wb.EVENT_TYPE_START, new El(this.f1050a));
        hashMap.put(EnumC0681wb.EVENT_TYPE_REGULAR, new Tg(this.f1050a));
        Db db = new Db(this.f1050a);
        hashMap.put(EnumC0681wb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF, db);
        hashMap.put(EnumC0681wb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF, db);
        hashMap.put(EnumC0681wb.EVENT_TYPE_SEND_REFERRER, db);
        hashMap.put(EnumC0681wb.EVENT_TYPE_CUSTOM_EVENT, db);
        EnumC0681wb enumC0681wb = EnumC0681wb.EVENT_TYPE_SET_SESSION_EXTRA;
        Ei ei = this.f1050a;
        hashMap.put(enumC0681wb, new C0766zl(ei, ei.t));
        hashMap.put(EnumC0681wb.EVENT_TYPE_APP_OPEN, new C0134ah(this.f1050a));
        hashMap.put(EnumC0681wb.EVENT_TYPE_PURGE_BUFFER, new C0236eg(this.f1050a));
        hashMap.put(EnumC0681wb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, new N6(this.f1050a));
        hashMap.put(EnumC0681wb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, new Jf(this.f1050a));
        hashMap.put(EnumC0681wb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, new Sn(this.f1050a));
        hashMap.put(EnumC0681wb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE, new Kf(this.f1050a));
        hashMap.put(EnumC0681wb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF, new Rn(this.f1050a));
        hashMap.put(EnumC0681wb.EVENT_TYPE_ANR, db);
        EnumC0681wb enumC0681wb2 = EnumC0681wb.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        Ei ei2 = this.f1050a;
        hashMap.put(enumC0681wb2, new C0766zl(ei2, ei2.e));
        EnumC0681wb enumC0681wb3 = EnumC0681wb.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        Ei ei3 = this.f1050a;
        hashMap.put(enumC0681wb3, new C0766zl(ei3, ei3.f));
        hashMap.put(EnumC0681wb.EVENT_TYPE_SEND_USER_PROFILE, db);
        EnumC0681wb enumC0681wb4 = EnumC0681wb.EVENT_TYPE_SET_USER_PROFILE_ID;
        Ei ei4 = this.f1050a;
        hashMap.put(enumC0681wb4, new C0766zl(ei4, ei4.k));
        hashMap.put(EnumC0681wb.EVENT_TYPE_SEND_REVENUE_EVENT, db);
        hashMap.put(EnumC0681wb.EVENT_TYPE_SEND_AD_REVENUE_EVENT, db);
        hashMap.put(EnumC0681wb.EVENT_TYPE_CLEANUP, db);
        hashMap.put(EnumC0681wb.EVENT_TYPE_SEND_ECOMMERCE_EVENT, db);
        hashMap.put(EnumC0681wb.EVENT_TYPE_WEBVIEW_SYNC, db);
        hashMap.put(EnumC0681wb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION, new Z9(this.f1050a));
        return hashMap;
    }

    public final Ei b() {
        return this.f1050a;
    }

    public final void a(EnumC0681wb enumC0681wb, Ja ja) {
        this.b.put(enumC0681wb, ja);
    }

    @Override // io.appmetrica.analytics.impl.Qf
    public final AbstractC0554r9 a(int i) {
        LinkedList linkedList = new LinkedList();
        EnumC0681wb a2 = EnumC0681wb.a(i);
        L4 l4 = this.c;
        if (l4 != null) {
            l4.a(a2, linkedList);
        }
        Ja ja = (Ja) this.b.get(a2);
        if (ja != null) {
            ja.a(linkedList);
        }
        return new C0530q9(linkedList);
    }

    public final Ja a(EnumC0681wb enumC0681wb) {
        return (Ja) this.b.get(enumC0681wb);
    }
}
