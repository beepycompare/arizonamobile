package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.LinkedList;
/* renamed from: io.appmetrica.analytics.impl.p9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0510p9 extends Of {

    /* renamed from: a  reason: collision with root package name */
    public final Bi f987a;
    public final HashMap b;
    public final L4 c;

    public C0510p9(C0580s5 c0580s5) {
        Bi bi = new Bi(c0580s5);
        this.f987a = bi;
        this.c = new L4(bi);
        this.b = a();
    }

    public final HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put(EnumC0636ub.EVENT_TYPE_ACTIVATION, new C0301h(this.f987a));
        hashMap.put(EnumC0636ub.EVENT_TYPE_START, new Bl(this.f987a));
        hashMap.put(EnumC0636ub.EVENT_TYPE_REGULAR, new Rg(this.f987a));
        Bb bb = new Bb(this.f987a);
        hashMap.put(EnumC0636ub.EVENT_TYPE_EXCEPTION_USER_PROTOBUF, bb);
        hashMap.put(EnumC0636ub.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF, bb);
        hashMap.put(EnumC0636ub.EVENT_TYPE_SEND_REFERRER, bb);
        hashMap.put(EnumC0636ub.EVENT_TYPE_CUSTOM_EVENT, bb);
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_SET_SESSION_EXTRA;
        Bi bi = this.f987a;
        hashMap.put(enumC0636ub, new C0696wl(bi, bi.t));
        hashMap.put(EnumC0636ub.EVENT_TYPE_APP_OPEN, new Yg(this.f987a));
        hashMap.put(EnumC0636ub.EVENT_TYPE_PURGE_BUFFER, new C0192cg(this.f987a));
        hashMap.put(EnumC0636ub.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, new K6(this.f987a));
        hashMap.put(EnumC0636ub.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, new Hf(this.f987a));
        hashMap.put(EnumC0636ub.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, new Pn(this.f987a));
        hashMap.put(EnumC0636ub.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE, new If(this.f987a));
        hashMap.put(EnumC0636ub.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF, new On(this.f987a));
        hashMap.put(EnumC0636ub.EVENT_TYPE_ANR, bb);
        EnumC0636ub enumC0636ub2 = EnumC0636ub.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        Bi bi2 = this.f987a;
        hashMap.put(enumC0636ub2, new C0696wl(bi2, bi2.e));
        EnumC0636ub enumC0636ub3 = EnumC0636ub.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        Bi bi3 = this.f987a;
        hashMap.put(enumC0636ub3, new C0696wl(bi3, bi3.f));
        hashMap.put(EnumC0636ub.EVENT_TYPE_SEND_USER_PROFILE, bb);
        EnumC0636ub enumC0636ub4 = EnumC0636ub.EVENT_TYPE_SET_USER_PROFILE_ID;
        Bi bi4 = this.f987a;
        hashMap.put(enumC0636ub4, new C0696wl(bi4, bi4.k));
        hashMap.put(EnumC0636ub.EVENT_TYPE_SEND_REVENUE_EVENT, bb);
        hashMap.put(EnumC0636ub.EVENT_TYPE_SEND_AD_REVENUE_EVENT, bb);
        hashMap.put(EnumC0636ub.EVENT_TYPE_CLEANUP, bb);
        hashMap.put(EnumC0636ub.EVENT_TYPE_SEND_ECOMMERCE_EVENT, bb);
        hashMap.put(EnumC0636ub.EVENT_TYPE_WEBVIEW_SYNC, bb);
        hashMap.put(EnumC0636ub.EVENT_CLIENT_EXTERNAL_ATTRIBUTION, new X9(this.f987a));
        return hashMap;
    }

    public final Bi b() {
        return this.f987a;
    }

    public final void a(EnumC0636ub enumC0636ub, Ha ha) {
        this.b.put(enumC0636ub, ha);
    }

    @Override // io.appmetrica.analytics.impl.Of
    public final AbstractC0485o9 a(int i) {
        LinkedList linkedList = new LinkedList();
        EnumC0636ub a2 = EnumC0636ub.a(i);
        L4 l4 = this.c;
        if (l4 != null) {
            l4.a(a2, linkedList);
        }
        Ha ha = (Ha) this.b.get(a2);
        if (ha != null) {
            ha.a(linkedList);
        }
        return new C0460n9(linkedList);
    }

    public final Ha a(EnumC0636ub enumC0636ub) {
        return (Ha) this.b.get(enumC0636ub);
    }
}
