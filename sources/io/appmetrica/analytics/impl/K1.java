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
/* loaded from: classes5.dex */
public final class K1 {

    /* renamed from: a  reason: collision with root package name */
    public final C0520qa f644a = new C0520qa();
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
                this.f644a.a(action, Integer.valueOf(a(intent)));
            }
            for (Map.Entry entry : this.b.entrySet()) {
                J1 j1 = (J1) entry.getKey();
                if (((I1) entry.getValue()).a(intent)) {
                    j1.a(intent);
                }
            }
        }
    }

    public final void d(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                C0520qa c0520qa = this.f644a;
                Integer valueOf = Integer.valueOf(a(intent));
                Collection collection = (Collection) c0520qa.f1182a.get(action);
                if (collection != null && collection.remove(valueOf)) {
                    if (collection.isEmpty() && c0520qa.b) {
                        c0520qa.f1182a.remove(action);
                    }
                    new ArrayList(collection);
                }
            }
            for (Map.Entry entry : this.c.entrySet()) {
                J1 j1 = (J1) entry.getKey();
                if (((I1) entry.getValue()).a(intent)) {
                    j1.a(intent);
                }
            }
        }
    }

    public final void b(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                this.f644a.a(action, Integer.valueOf(a(intent)));
            }
            for (Map.Entry entry : this.b.entrySet()) {
                J1 j1 = (J1) entry.getKey();
                if (((I1) entry.getValue()).a(intent)) {
                    j1.a(intent);
                }
            }
        }
    }

    public final void a(J1 j1) {
        this.c.put(j1, new I1() { // from class: io.appmetrica.analytics.impl.K1$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.I1
            public final boolean a(Intent intent) {
                return K1.a(K1.this, intent);
            }
        });
    }

    public static final boolean a(K1 k1, Intent intent) {
        k1.getClass();
        if (Intrinsics.areEqual("io.appmetrica.analytics.IAppMetricaService", intent.getAction())) {
            Collection collection = (Collection) k1.f644a.f1182a.get("io.appmetrica.analytics.IAppMetricaService");
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

    public final void c(J1 j1) {
        this.b.put(j1, new I1() { // from class: io.appmetrica.analytics.impl.K1$$ExternalSyntheticLambda2
            @Override // io.appmetrica.analytics.impl.I1
            public final boolean a(Intent intent) {
                return K1.c(K1.this, intent);
            }
        });
    }

    public static final boolean c(K1 k1, Intent intent) {
        k1.getClass();
        return Intrinsics.areEqual("io.appmetrica.analytics.IAppMetricaService", intent.getAction());
    }

    public final void b(J1 j1) {
        this.b.put(j1, new I1() { // from class: io.appmetrica.analytics.impl.K1$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.I1
            public final boolean a(Intent intent) {
                return K1.b(K1.this, intent);
            }
        });
    }

    public static final boolean b(K1 k1, Intent intent) {
        Collection collection;
        k1.getClass();
        return Intrinsics.areEqual("io.appmetrica.analytics.IAppMetricaService", intent.getAction()) && (collection = (Collection) k1.f644a.f1182a.get("io.appmetrica.analytics.IAppMetricaService")) != null && collection.size() == 1;
    }
}
