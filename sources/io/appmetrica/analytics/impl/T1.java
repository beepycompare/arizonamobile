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
/* loaded from: classes3.dex */
public final class T1 {

    /* renamed from: a  reason: collision with root package name */
    public final C0670wa f694a = new C0670wa();
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
                this.f694a.a(action, Integer.valueOf(a(intent)));
            }
            for (Map.Entry entry : this.b.entrySet()) {
                S1 s1 = (S1) entry.getKey();
                if (((R1) entry.getValue()).a(intent)) {
                    s1.a(intent);
                }
            }
        }
    }

    public final void d(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                C0670wa c0670wa = this.f694a;
                Integer valueOf = Integer.valueOf(a(intent));
                Collection collection = (Collection) c0670wa.f1183a.get(action);
                if (collection != null && collection.remove(valueOf)) {
                    if (collection.isEmpty() && c0670wa.b) {
                        c0670wa.f1183a.remove(action);
                    }
                    new ArrayList(collection);
                }
            }
            for (Map.Entry entry : this.c.entrySet()) {
                S1 s1 = (S1) entry.getKey();
                if (((R1) entry.getValue()).a(intent)) {
                    s1.a(intent);
                }
            }
        }
    }

    public final void b(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                this.f694a.a(action, Integer.valueOf(a(intent)));
            }
            for (Map.Entry entry : this.b.entrySet()) {
                S1 s1 = (S1) entry.getKey();
                if (((R1) entry.getValue()).a(intent)) {
                    s1.a(intent);
                }
            }
        }
    }

    public final void a(S1 s1) {
        this.c.put(s1, new R1() { // from class: io.appmetrica.analytics.impl.T1$$ExternalSyntheticLambda2
            @Override // io.appmetrica.analytics.impl.R1
            public final boolean a(Intent intent) {
                return T1.a(T1.this, intent);
            }
        });
    }

    public static final boolean a(T1 t1, Intent intent) {
        t1.getClass();
        if (Intrinsics.areEqual("io.appmetrica.analytics.IAppMetricaService", intent.getAction())) {
            Collection collection = (Collection) t1.f694a.f1183a.get("io.appmetrica.analytics.IAppMetricaService");
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

    public final void c(S1 s1) {
        this.b.put(s1, new R1() { // from class: io.appmetrica.analytics.impl.T1$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.R1
            public final boolean a(Intent intent) {
                return T1.c(T1.this, intent);
            }
        });
    }

    public static final boolean c(T1 t1, Intent intent) {
        t1.getClass();
        return Intrinsics.areEqual("io.appmetrica.analytics.IAppMetricaService", intent.getAction());
    }

    public final void b(S1 s1) {
        this.b.put(s1, new R1() { // from class: io.appmetrica.analytics.impl.T1$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.R1
            public final boolean a(Intent intent) {
                return T1.b(T1.this, intent);
            }
        });
    }

    public static final boolean b(T1 t1, Intent intent) {
        Collection collection;
        t1.getClass();
        return Intrinsics.areEqual("io.appmetrica.analytics.IAppMetricaService", intent.getAction()) && (collection = (Collection) t1.f694a.f1183a.get("io.appmetrica.analytics.IAppMetricaService")) != null && collection.size() == 1;
    }
}
