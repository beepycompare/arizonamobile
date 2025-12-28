package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.Set;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public abstract class Ye {
    public static final String c = "Ye";

    /* renamed from: a  reason: collision with root package name */
    public final Ia f863a;
    public final String b;

    public Ye(Ia ia, String str) {
        this.f863a = ia;
        this.b = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Ye> T a(String str, float f) {
        synchronized (this) {
            this.f863a.a(str, f);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Ye> T b(String str, String str2) {
        synchronized (this) {
            this.f863a.a(str, str2);
        }
        return this;
    }

    public final Ze c(String str) {
        return new Ze(str, this.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Ye> T d(String str) {
        synchronized (this) {
            this.f863a.remove(str);
        }
        return this;
    }

    public Set<String> c() {
        return this.f863a.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Ye> T a(String str, String[] strArr) {
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
        this.f863a.a(str, str2);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Ye> T b(String str, long j) {
        synchronized (this) {
            this.f863a.a(str, j);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Ye> T b(String str, int i) {
        synchronized (this) {
            this.f863a.a(i, str);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends Ye> T b(String str, boolean z) {
        synchronized (this) {
            this.f863a.a(str, z);
        }
        return this;
    }

    public final <T extends Ye> T a(String str, List<String> list) {
        return (T) a(str, (String[]) list.toArray(new String[list.size()]));
    }

    public final long a(String str, long j) {
        return this.f863a.getLong(str, j);
    }

    public final int a(String str, int i) {
        return this.f863a.getInt(str, i);
    }

    public final String a(String str, String str2) {
        return this.f863a.getString(str, str2);
    }

    public final void b() {
        synchronized (this) {
            this.f863a.b();
        }
    }

    public final boolean a(String str, boolean z) {
        return this.f863a.getBoolean(str, z);
    }

    public final boolean b(String str) {
        return this.f863a.a(str);
    }
}
