package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.LinkedList;
/* renamed from: io.appmetrica.analytics.impl.e9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0214e9 extends Kf {

    /* renamed from: a  reason: collision with root package name */
    public final C0678wi f859a;
    public final HashMap b;
    public final C0689x4 c;

    public C0214e9(C0210e5 c0210e5) {
        C0678wi c0678wi = new C0678wi(c0210e5);
        this.f859a = c0678wi;
        this.c = new C0689x4(c0678wi);
        this.b = a();
    }

    public final HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put(EnumC0320ib.EVENT_TYPE_ACTIVATION, new C0282h(this.f859a));
        hashMap.put(EnumC0320ib.EVENT_TYPE_START, new Il(this.f859a));
        hashMap.put(EnumC0320ib.EVENT_TYPE_REGULAR, new Lg(this.f859a));
        C0497pb c0497pb = new C0497pb(this.f859a);
        hashMap.put(EnumC0320ib.EVENT_TYPE_EXCEPTION_USER_PROTOBUF, c0497pb);
        hashMap.put(EnumC0320ib.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF, c0497pb);
        hashMap.put(EnumC0320ib.EVENT_TYPE_SEND_REFERRER, c0497pb);
        hashMap.put(EnumC0320ib.EVENT_TYPE_CUSTOM_EVENT, c0497pb);
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_SET_SESSION_EXTRA;
        C0678wi c0678wi = this.f859a;
        hashMap.put(enumC0320ib, new Dl(c0678wi, c0678wi.t));
        hashMap.put(EnumC0320ib.EVENT_TYPE_APP_OPEN, new Sg(this.f859a));
        hashMap.put(EnumC0320ib.EVENT_TYPE_PURGE_BUFFER, new Wf(this.f859a));
        hashMap.put(EnumC0320ib.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, new C0741z6(this.f859a));
        hashMap.put(EnumC0320ib.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, new Af(this.f859a));
        hashMap.put(EnumC0320ib.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, new Xn(this.f859a));
        hashMap.put(EnumC0320ib.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE, new Bf(this.f859a));
        hashMap.put(EnumC0320ib.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF, new Wn(this.f859a));
        hashMap.put(EnumC0320ib.EVENT_TYPE_ANR, c0497pb);
        EnumC0320ib enumC0320ib2 = EnumC0320ib.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        C0678wi c0678wi2 = this.f859a;
        hashMap.put(enumC0320ib2, new Dl(c0678wi2, c0678wi2.e));
        EnumC0320ib enumC0320ib3 = EnumC0320ib.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        C0678wi c0678wi3 = this.f859a;
        hashMap.put(enumC0320ib3, new Dl(c0678wi3, c0678wi3.f));
        hashMap.put(EnumC0320ib.EVENT_TYPE_SEND_USER_PROFILE, c0497pb);
        EnumC0320ib enumC0320ib4 = EnumC0320ib.EVENT_TYPE_SET_USER_PROFILE_ID;
        C0678wi c0678wi4 = this.f859a;
        hashMap.put(enumC0320ib4, new Dl(c0678wi4, c0678wi4.k));
        hashMap.put(EnumC0320ib.EVENT_TYPE_SEND_REVENUE_EVENT, c0497pb);
        hashMap.put(EnumC0320ib.EVENT_TYPE_SEND_AD_REVENUE_EVENT, c0497pb);
        hashMap.put(EnumC0320ib.EVENT_TYPE_CLEANUP, c0497pb);
        hashMap.put(EnumC0320ib.EVENT_TYPE_SEND_ECOMMERCE_EVENT, c0497pb);
        hashMap.put(EnumC0320ib.EVENT_TYPE_WEBVIEW_SYNC, c0497pb);
        hashMap.put(EnumC0320ib.EVENT_CLIENT_EXTERNAL_ATTRIBUTION, new L9(this.f859a));
        return hashMap;
    }

    public final C0678wi b() {
        return this.f859a;
    }

    public final void a(EnumC0320ib enumC0320ib, AbstractC0645va abstractC0645va) {
        this.b.put(enumC0320ib, abstractC0645va);
    }

    @Override // io.appmetrica.analytics.impl.Kf
    public final AbstractC0189d9 a(int i) {
        LinkedList linkedList = new LinkedList();
        EnumC0320ib a2 = EnumC0320ib.a(i);
        C0689x4 c0689x4 = this.c;
        if (c0689x4 != null) {
            c0689x4.a(a2, linkedList);
        }
        AbstractC0645va abstractC0645va = (AbstractC0645va) this.b.get(a2);
        if (abstractC0645va != null) {
            abstractC0645va.a(linkedList);
        }
        return new C0163c9(linkedList);
    }

    public final AbstractC0645va a(EnumC0320ib enumC0320ib) {
        return (AbstractC0645va) this.b.get(enumC0320ib);
    }
}
