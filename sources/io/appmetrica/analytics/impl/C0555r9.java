package io.appmetrica.analytics.impl;

import java.util.HashMap;
import java.util.LinkedList;
/* renamed from: io.appmetrica.analytics.impl.r9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0555r9 extends AbstractC0278gg {

    /* renamed from: a  reason: collision with root package name */
    public final Li f1182a;
    public final HashMap b;
    public final H4 c;

    public C0555r9(C0448n5 c0448n5) {
        Li li = new Li(c0448n5);
        this.f1182a = li;
        this.c = new H4(li);
        this.b = a(c0448n5);
    }

    public final HashMap a(C0448n5 c0448n5) {
        HashMap hashMap = new HashMap();
        hashMap.put(Db.EVENT_TYPE_ACTIVATION, new C0287h(this.f1182a, c0448n5.b));
        hashMap.put(Db.EVENT_TYPE_START, new C0284gm(this.f1182a));
        hashMap.put(Db.EVENT_TYPE_REGULAR, new Wg(this.f1182a));
        Kb kb = new Kb(this.f1182a);
        hashMap.put(Db.EVENT_TYPE_EXCEPTION_USER_PROTOBUF, kb);
        hashMap.put(Db.EVENT_TYPE_EXCEPTION_USER_CUSTOM_PROTOBUF, kb);
        hashMap.put(Db.EVENT_TYPE_SEND_REFERRER, kb);
        hashMap.put(Db.EVENT_TYPE_CUSTOM_EVENT, kb);
        Db db = Db.EVENT_TYPE_SET_SESSION_EXTRA;
        Li li = this.f1182a;
        hashMap.put(db, new C0155bm(li, li.t));
        hashMap.put(Db.EVENT_TYPE_APP_OPEN, new C0202dh(this.f1182a));
        hashMap.put(Db.EVENT_TYPE_PURGE_BUFFER, new C0588sg(this.f1182a));
        hashMap.put(Db.EVENT_TYPE_CURRENT_SESSION_NATIVE_CRASH_PROTOBUF, new K6(this.f1182a));
        hashMap.put(Db.EVENT_TYPE_PREV_SESSION_NATIVE_CRASH_PROTOBUF, new Wf(this.f1182a));
        hashMap.put(Db.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE, new C0752yo(this.f1182a));
        hashMap.put(Db.EVENT_TYPE_PREV_SESSION_EXCEPTION_UNHANDLED_FROM_FILE, new Xf(this.f1182a));
        hashMap.put(Db.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF, new C0726xo(this.f1182a));
        hashMap.put(Db.EVENT_TYPE_ANR, kb);
        Db db2 = Db.EVENT_TYPE_APP_ENVIRONMENT_UPDATED;
        Li li2 = this.f1182a;
        hashMap.put(db2, new C0155bm(li2, li2.e));
        Db db3 = Db.EVENT_TYPE_APP_ENVIRONMENT_CLEARED;
        Li li3 = this.f1182a;
        hashMap.put(db3, new C0155bm(li3, li3.f));
        hashMap.put(Db.EVENT_TYPE_SEND_USER_PROFILE, kb);
        Db db4 = Db.EVENT_TYPE_SET_USER_PROFILE_ID;
        Li li4 = this.f1182a;
        hashMap.put(db4, new C0155bm(li4, li4.k));
        hashMap.put(Db.EVENT_TYPE_SEND_REVENUE_EVENT, kb);
        hashMap.put(Db.EVENT_TYPE_SEND_AD_REVENUE_EVENT, kb);
        hashMap.put(Db.EVENT_TYPE_CLEANUP, kb);
        hashMap.put(Db.EVENT_TYPE_SEND_ECOMMERCE_EVENT, kb);
        hashMap.put(Db.EVENT_TYPE_WEBVIEW_SYNC, kb);
        hashMap.put(Db.EVENT_CLIENT_EXTERNAL_ATTRIBUTION, new Z9(this.f1182a));
        return hashMap;
    }

    public final void a(Db db, Ra ra) {
        this.b.put(db, ra);
    }

    public final Li a() {
        return this.f1182a;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0278gg
    public final AbstractC0530q9 a(int i) {
        LinkedList linkedList = new LinkedList();
        Db a2 = Db.a(i);
        H4 h4 = this.c;
        if (h4 != null) {
            h4.a(a2, linkedList);
        }
        Ra ra = (Ra) this.b.get(a2);
        if (ra != null) {
            ra.a(linkedList);
        }
        return new C0504p9(linkedList);
    }

    public final Ra a(Db db) {
        return (Ra) this.b.get(db);
    }
}
