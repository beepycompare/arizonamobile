package io.appmetrica.analytics.impl;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class Q1 {

    /* renamed from: a  reason: collision with root package name */
    public final Ia f589a = new Ia();
    public final LinkedHashMap b = new LinkedHashMap();
    public final LinkedHashMap c = new LinkedHashMap();

    public final void a() {
    }

    public final void a(Intent intent, int i) {
    }

    public final void a(Intent intent, int i, int i2) {
    }

    public final void a(Configuration configuration) {
    }

    public final void b() {
    }

    public final void c(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                this.f589a.a(action, Integer.valueOf(a(intent)));
            }
            for (Map.Entry entry : this.b.entrySet()) {
                P1 p1 = (P1) entry.getKey();
                if (((O1) entry.getValue()).a(intent)) {
                    p1.a(intent);
                }
            }
        }
    }

    public final void d(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                Ia ia = this.f589a;
                Integer valueOf = Integer.valueOf(a(intent));
                Collection collection = (Collection) ia.f474a.get(action);
                if (collection != null && collection.remove(valueOf)) {
                    if (collection.isEmpty() && ia.b) {
                        ia.f474a.remove(action);
                    }
                    new ArrayList(collection);
                }
            }
            for (Map.Entry entry : this.c.entrySet()) {
                P1 p1 = (P1) entry.getKey();
                if (((O1) entry.getValue()).a(intent)) {
                    p1.a(intent);
                }
            }
        }
    }

    public final void b(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                this.f589a.a(action, Integer.valueOf(a(intent)));
            }
            for (Map.Entry entry : this.b.entrySet()) {
                P1 p1 = (P1) entry.getKey();
                if (((O1) entry.getValue()).a(intent)) {
                    p1.a(intent);
                }
            }
        }
    }

    public final void a(P1 p1) {
        this.c.put(p1, new O1() { // from class: io.appmetrica.analytics.impl.Q1$$ExternalSyntheticLambda2
            @Override // io.appmetrica.analytics.impl.O1
            public final boolean a(Intent intent) {
                return Q1.a(Q1.this, intent);
            }
        });
    }

    public static final boolean a(Q1 q1, Intent intent) {
        q1.getClass();
        if (Intrinsics.areEqual("io.appmetrica.analytics.IAppMetricaService", intent.getAction())) {
            Collection collection = (Collection) q1.f589a.f474a.get("io.appmetrica.analytics.IAppMetricaService");
            return collection == null || collection.size() == 0;
        }
        return false;
    }

    public static int a(Intent intent) {
        Uri data = intent.getData();
        if (data == null || !Intrinsics.areEqual(data.getPath(), "/client")) {
            return -1;
        }
        try {
            String queryParameter = data.getQueryParameter("pid");
            Intrinsics.checkNotNull(queryParameter);
            return Integer.parseInt(queryParameter);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final void c(P1 p1) {
        this.b.put(p1, new O1() { // from class: io.appmetrica.analytics.impl.Q1$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.O1
            public final boolean a(Intent intent) {
                return Q1.c(Q1.this, intent);
            }
        });
    }

    public static final boolean c(Q1 q1, Intent intent) {
        q1.getClass();
        return Intrinsics.areEqual("io.appmetrica.analytics.IAppMetricaService", intent.getAction());
    }

    public final void b(P1 p1) {
        this.b.put(p1, new O1() { // from class: io.appmetrica.analytics.impl.Q1$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.O1
            public final boolean a(Intent intent) {
                return Q1.b(Q1.this, intent);
            }
        });
    }

    public static final boolean b(Q1 q1, Intent intent) {
        Collection collection;
        q1.getClass();
        return Intrinsics.areEqual("io.appmetrica.analytics.IAppMetricaService", intent.getAction()) && (collection = (Collection) q1.f589a.f474a.get("io.appmetrica.analytics.IAppMetricaService")) != null && collection.size() == 1;
    }
}
