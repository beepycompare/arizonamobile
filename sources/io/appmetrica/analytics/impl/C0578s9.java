package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.LinkedList;
/* renamed from: io.appmetrica.analytics.impl.s9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0578s9 extends Qf {

    /* renamed from: a  reason: collision with root package name */
    public final Ei f1050a;
    public final HashMap b;
    public final L4 c;

    public C0578s9(C0574s5 c0574s5) {
        Ei ei = new Ei(c0574s5);
        this.f1050a = ei;
        this.c = new L4(ei);
        this.b = a();
    }

    public final HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put(EnumC0680wb.EVENT_TYPE_ACTIVATION, new C0295h(this.f1050a));
        hashMap.put(EnumC0680wb.EVENT_TYPE_START, new El(this.f1050a));
        hashMap.put(EnumC0680wb.EVENT_TYPE_REGULAR, new Tg(this.f1050a));
        Db db = new Db(this.f1050a);
        hashMap.put(EnumC0680wb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF, db);
        hashMap.put(EnumC0680wb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF, db);
        hashMap.put(EnumC0680wb.EVENT_TYPE_SEND_REFERRER, db);
        hashMap.put(EnumC0680wb.EVENT_TYPE_CUSTOM_EVENT, db);
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_SET_SESSION_EXTRA;
        Ei ei = this.f1050a;
        hashMap.put(enumC0680wb, new C0765zl(ei, ei.t));
        hashMap.put(EnumC0680wb.EVENT_TYPE_APP_OPEN, new C0133ah(this.f1050a));
        hashMap.put(EnumC0680wb.EVENT_TYPE_PURGE_BUFFER, new C0235eg(this.f1050a));
        hashMap.put(EnumC0680wb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, new N6(this.f1050a));
        hashMap.put(EnumC0680wb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, new Jf(this.f1050a));
        hashMap.put(EnumC0680wb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, new Sn(this.f1050a));
        hashMap.put(EnumC0680wb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE, new Kf(this.f1050a));
        hashMap.put(EnumC0680wb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF, new Rn(this.f1050a));
        hashMap.put(EnumC0680wb.EVENT_TYPE_ANR, db);
        EnumC0680wb enumC0680wb2 = EnumC0680wb.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        Ei ei2 = this.f1050a;
        hashMap.put(enumC0680wb2, new C0765zl(ei2, ei2.e));
        EnumC0680wb enumC0680wb3 = EnumC0680wb.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        Ei ei3 = this.f1050a;
        hashMap.put(enumC0680wb3, new C0765zl(ei3, ei3.f));
        hashMap.put(EnumC0680wb.EVENT_TYPE_SEND_USER_PROFILE, db);
        EnumC0680wb enumC0680wb4 = EnumC0680wb.EVENT_TYPE_SET_USER_PROFILE_ID;
        Ei ei4 = this.f1050a;
        hashMap.put(enumC0680wb4, new C0765zl(ei4, ei4.k));
        hashMap.put(EnumC0680wb.EVENT_TYPE_SEND_REVENUE_EVENT, db);
        hashMap.put(EnumC0680wb.EVENT_TYPE_SEND_AD_REVENUE_EVENT, db);
        hashMap.put(EnumC0680wb.EVENT_TYPE_CLEANUP, db);
        hashMap.put(EnumC0680wb.EVENT_TYPE_SEND_ECOMMERCE_EVENT, db);
        hashMap.put(EnumC0680wb.EVENT_TYPE_WEBVIEW_SYNC, db);
        hashMap.put(EnumC0680wb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION, new Z9(this.f1050a));
        return hashMap;
    }

    public final Ei b() {
        return this.f1050a;
    }

    public final void a(EnumC0680wb enumC0680wb, Ja ja) {
        this.b.put(enumC0680wb, ja);
    }

    @Override // io.appmetrica.analytics.impl.Qf
    public final AbstractC0553r9 a(int i) {
        LinkedList linkedList = new LinkedList();
        EnumC0680wb a2 = EnumC0680wb.a(i);
        L4 l4 = this.c;
        if (l4 != null) {
            l4.a(a2, linkedList);
        }
        Ja ja = (Ja) this.b.get(a2);
        if (ja != null) {
            ja.a(linkedList);
        }
        return new C0529q9(linkedList);
    }

    public final Ja a(EnumC0680wb enumC0680wb) {
        return (Ja) this.b.get(enumC0680wb);
    }
}
