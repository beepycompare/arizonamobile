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
public final class J1 {

    /* renamed from: a  reason: collision with root package name */
    public final C0499pa f637a = new C0499pa();
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
                this.f637a.a(action, Integer.valueOf(a(intent)));
            }
            for (Map.Entry entry : this.b.entrySet()) {
                I1 i1 = (I1) entry.getKey();
                if (((H1) entry.getValue()).a(intent)) {
                    i1.a(intent);
                }
            }
        }
    }

    public final void d(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                C0499pa c0499pa = this.f637a;
                Integer valueOf = Integer.valueOf(a(intent));
                Collection collection = (Collection) c0499pa.f1173a.get(action);
                if (collection != null && collection.remove(valueOf)) {
                    if (collection.isEmpty() && c0499pa.b) {
                        c0499pa.f1173a.remove(action);
                    }
                    new ArrayList(collection);
                }
            }
            for (Map.Entry entry : this.c.entrySet()) {
                I1 i1 = (I1) entry.getKey();
                if (((H1) entry.getValue()).a(intent)) {
                    i1.a(intent);
                }
            }
        }
    }

    public final void b(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                this.f637a.a(action, Integer.valueOf(a(intent)));
            }
            for (Map.Entry entry : this.b.entrySet()) {
                I1 i1 = (I1) entry.getKey();
                if (((H1) entry.getValue()).a(intent)) {
                    i1.a(intent);
                }
            }
        }
    }

    public final void a(I1 i1) {
        this.c.put(i1, new H1() { // from class: io.appmetrica.analytics.impl.J1$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.H1
            public final boolean a(Intent intent) {
                return J1.a(J1.this, intent);
            }
        });
    }

    public static final boolean a(J1 j1, Intent intent) {
        j1.getClass();
        if (Intrinsics.areEqual("io.appmetrica.analytics.IAppMetricaService", intent.getAction())) {
            Collection collection = (Collection) j1.f637a.f1173a.get("io.appmetrica.analytics.IAppMetricaService");
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

    public final void c(I1 i1) {
        this.b.put(i1, new H1() { // from class: io.appmetrica.analytics.impl.J1$$ExternalSyntheticLambda2
            @Override // io.appmetrica.analytics.impl.H1
            public final boolean a(Intent intent) {
                return J1.c(J1.this, intent);
            }
        });
    }

    public static final boolean c(J1 j1, Intent intent) {
        j1.getClass();
        return Intrinsics.areEqual("io.appmetrica.analytics.IAppMetricaService", intent.getAction());
    }

    public final void b(I1 i1) {
        this.b.put(i1, new H1() { // from class: io.appmetrica.analytics.impl.J1$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.H1
            public final boolean a(Intent intent) {
                return J1.b(J1.this, intent);
            }
        });
    }

    public static final boolean b(J1 j1, Intent intent) {
        Collection collection;
        j1.getClass();
        return Intrinsics.areEqual("io.appmetrica.analytics.IAppMetricaService", intent.getAction()) && (collection = (Collection) j1.f637a.f1173a.get("io.appmetrica.analytics.IAppMetricaService")) != null && collection.size() == 1;
    }
}
