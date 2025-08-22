package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.LinkedList;
/* renamed from: io.appmetrica.analytics.impl.u9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0626u9 extends Vf {

    /* renamed from: a  reason: collision with root package name */
    public final Ji f1085a;
    public final HashMap b;
    public final L4 c;

    public C0626u9(C0572s5 c0572s5) {
        Ji ji = new Ji(c0572s5);
        this.f1085a = ji;
        this.c = new L4(ji);
        this.b = a();
    }

    public final HashMap a() {
        HashMap hashMap = new HashMap();
        hashMap.put(EnumC0728yb.EVENT_TYPE_ACTIVATION, new C0289h(this.f1085a));
        hashMap.put(EnumC0728yb.EVENT_TYPE_START, new Jl(this.f1085a));
        hashMap.put(EnumC0728yb.EVENT_TYPE_REGULAR, new Yg(this.f1085a));
        Fb fb = new Fb(this.f1085a);
        hashMap.put(EnumC0728yb.EVENT_TYPE_EXCEPTION_USER_PROTOBUF, fb);
        hashMap.put(EnumC0728yb.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF, fb);
        hashMap.put(EnumC0728yb.EVENT_TYPE_SEND_REFERRER, fb);
        hashMap.put(EnumC0728yb.EVENT_TYPE_CUSTOM_EVENT, fb);
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_SET_SESSION_EXTRA;
        Ji ji = this.f1085a;
        hashMap.put(enumC0728yb, new El(ji, ji.t));
        hashMap.put(EnumC0728yb.EVENT_TYPE_APP_OPEN, new C0255fh(this.f1085a));
        hashMap.put(EnumC0728yb.EVENT_TYPE_PURGE_BUFFER, new C0357jg(this.f1085a));
        hashMap.put(EnumC0728yb.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, new O6(this.f1085a));
        hashMap.put(EnumC0728yb.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, new Lf(this.f1085a));
        hashMap.put(EnumC0728yb.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, new Xn(this.f1085a));
        hashMap.put(EnumC0728yb.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE, new Mf(this.f1085a));
        hashMap.put(EnumC0728yb.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF, new Wn(this.f1085a));
        hashMap.put(EnumC0728yb.EVENT_TYPE_ANR, fb);
        EnumC0728yb enumC0728yb2 = EnumC0728yb.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        Ji ji2 = this.f1085a;
        hashMap.put(enumC0728yb2, new El(ji2, ji2.e));
        EnumC0728yb enumC0728yb3 = EnumC0728yb.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        Ji ji3 = this.f1085a;
        hashMap.put(enumC0728yb3, new El(ji3, ji3.f));
        hashMap.put(EnumC0728yb.EVENT_TYPE_SEND_USER_PROFILE, fb);
        EnumC0728yb enumC0728yb4 = EnumC0728yb.EVENT_TYPE_SET_USER_PROFILE_ID;
        Ji ji4 = this.f1085a;
        hashMap.put(enumC0728yb4, new El(ji4, ji4.k));
        hashMap.put(EnumC0728yb.EVENT_TYPE_SEND_REVENUE_EVENT, fb);
        hashMap.put(EnumC0728yb.EVENT_TYPE_SEND_AD_REVENUE_EVENT, fb);
        hashMap.put(EnumC0728yb.EVENT_TYPE_CLEANUP, fb);
        hashMap.put(EnumC0728yb.EVENT_TYPE_SEND_ECOMMERCE_EVENT, fb);
        hashMap.put(EnumC0728yb.EVENT_TYPE_WEBVIEW_SYNC, fb);
        hashMap.put(EnumC0728yb.EVENT_CLIENT_EXTERNAL_ATTRIBUTION, new C0145ba(this.f1085a));
        return hashMap;
    }

    public final Ji b() {
        return this.f1085a;
    }

    public final void a(EnumC0728yb enumC0728yb, La la) {
        this.b.put(enumC0728yb, la);
    }

    @Override // io.appmetrica.analytics.impl.Vf
    public final AbstractC0601t9 a(int i) {
        LinkedList linkedList = new LinkedList();
        EnumC0728yb a2 = EnumC0728yb.a(i);
        L4 l4 = this.c;
        if (l4 != null) {
            l4.a(a2, linkedList);
        }
        La la = (La) this.b.get(a2);
        if (la != null) {
            la.a(linkedList);
        }
        return new C0576s9(linkedList);
    }

    public final La a(EnumC0728yb enumC0728yb) {
        return (La) this.b.get(enumC0728yb);
    }
}
