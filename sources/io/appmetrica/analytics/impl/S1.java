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
public final class S1 {

    /* renamed from: a  reason: collision with root package name */
    public final Pa f663a = new Pa();
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
                this.f663a.a(action, Integer.valueOf(a(intent)));
            }
            for (Map.Entry entry : this.b.entrySet()) {
                R1 r1 = (R1) entry.getKey();
                if (((Q1) entry.getValue()).a(intent)) {
                    r1.a(intent);
                }
            }
        }
    }

    public final void d(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                Pa pa = this.f663a;
                Integer valueOf = Integer.valueOf(a(intent));
                Collection collection = (Collection) pa.f624a.get(action);
                if (collection != null && collection.remove(valueOf)) {
                    if (collection.isEmpty() && pa.b) {
                        pa.f624a.remove(action);
                    }
                    new ArrayList(collection);
                }
            }
            for (Map.Entry entry : this.c.entrySet()) {
                R1 r1 = (R1) entry.getKey();
                if (((Q1) entry.getValue()).a(intent)) {
                    r1.a(intent);
                }
            }
        }
    }

    public final void b(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                this.f663a.a(action, Integer.valueOf(a(intent)));
            }
            for (Map.Entry entry : this.b.entrySet()) {
                R1 r1 = (R1) entry.getKey();
                if (((Q1) entry.getValue()).a(intent)) {
                    r1.a(intent);
                }
            }
        }
    }

    public final void a(R1 r1) {
        this.c.put(r1, new Q1() { // from class: io.appmetrica.analytics.impl.S1$$ExternalSyntheticLambda2
            @Override // io.appmetrica.analytics.impl.Q1
            public final boolean a(Intent intent) {
                return S1.a(S1.this, intent);
            }
        });
    }

    public static final boolean a(S1 s1, Intent intent) {
        s1.getClass();
        if (Intrinsics.areEqual("io.appmetrica.analytics.IAppMetricaService", intent.getAction())) {
            Collection collection = (Collection) s1.f663a.f624a.get("io.appmetrica.analytics.IAppMetricaService");
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

    public final void c(R1 r1) {
        this.b.put(r1, new Q1() { // from class: io.appmetrica.analytics.impl.S1$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.Q1
            public final boolean a(Intent intent) {
                return S1.c(S1.this, intent);
            }
        });
    }

    public static final boolean c(S1 s1, Intent intent) {
        s1.getClass();
        return Intrinsics.areEqual("io.appmetrica.analytics.IAppMetricaService", intent.getAction());
    }

    public final void b(R1 r1) {
        this.b.put(r1, new Q1() { // from class: io.appmetrica.analytics.impl.S1$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.Q1
            public final boolean a(Intent intent) {
                return S1.b(S1.this, intent);
            }
        });
    }

    public static final boolean b(S1 s1, Intent intent) {
        Collection collection;
        s1.getClass();
        return Intrinsics.areEqual("io.appmetrica.analytics.IAppMetricaService", intent.getAction()) && (collection = (Collection) s1.f663a.f624a.get("io.appmetrica.analytics.IAppMetricaService")) != null && collection.size() == 1;
    }
}
