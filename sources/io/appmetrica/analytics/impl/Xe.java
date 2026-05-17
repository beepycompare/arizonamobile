package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.Set;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public abstract class Xe {
    public static final String c = "Xe";

    /* renamed from: a  reason: collision with root package name */
    public final Ha f858a;
    public final String b;

    public Xe(Ha ha, String str) {
        this.f858a = ha;
        this.b = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Xe> T a(String str, float f) {
        synchronized (this) {
            this.f858a.a(str, f);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Xe> T b(String str, String str2) {
        synchronized (this) {
            this.f858a.a(str, str2);
        }
        return this;
    }

    public final Ye c(String str) {
        return new Ye(str, this.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Xe> T d(String str) {
        synchronized (this) {
            this.f858a.remove(str);
        }
        return this;
    }

    public Set<String> c() {
        return this.f858a.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Xe> T a(String str, String[] strArr) {
        String str2;
        try {
            JSONArray jSONArray = new JSONArray();
            for (String str3 : strArr) {
                jSONArray.put(str3);
            }
            str2 = jSONArray.toString();
        } catch (Throwable unused) {
            str2 = null;
        }
        this.f858a.a(str, str2);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Xe> T b(String str, long j) {
        synchronized (this) {
            this.f858a.a(str, j);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Xe> T b(String str, int i) {
        synchronized (this) {
            this.f858a.a(i, str);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Xe> T b(String str, boolean z) {
        synchronized (this) {
            this.f858a.a(str, z);
        }
        return this;
    }

    public final <T extends Xe> T a(String str, List<String> list) {
        return (T) a(str, (String[]) list.toArray(new String[list.size()]));
    }

    public final long a(String str, long j) {
        return this.f858a.getLong(str, j);
    }

    public final int a(String str, int i) {
        return this.f858a.getInt(str, i);
    }

    public final String a(String str, String str2) {
        return this.f858a.getString(str, str2);
    }

    public final void b() {
        synchronized (this) {
            this.f858a.b();
        }
    }

    public final boolean a(String str, boolean z) {
        return this.f858a.getBoolean(str, z);
    }

    public final boolean b(String str) {
        return this.f858a.a(str);
    }
}
