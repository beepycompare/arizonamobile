package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.Set;
import org.json.JSONArray;
/* renamed from: io.appmetrica.analytics.impl.cf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0169cf {
    public static final String c = "cf";

    /* renamed from: a  reason: collision with root package name */
    public final Oa f830a;
    public final String b;

    public AbstractC0169cf(Oa oa, String str) {
        this.f830a = oa;
        this.b = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0169cf> T a(String str, float f) {
        synchronized (this) {
            this.f830a.a(str, f);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0169cf> T b(String str, String str2) {
        synchronized (this) {
            this.f830a.a(str, str2);
        }
        return this;
    }

    public final C0195df c(String str) {
        return new C0195df(str, this.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0169cf> T d(String str) {
        synchronized (this) {
            this.f830a.remove(str);
        }
        return this;
    }

    public Set<String> c() {
        return this.f830a.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0169cf> T a(String str, String[] strArr) {
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
        this.f830a.a(str, str2);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0169cf> T b(String str, long j) {
        synchronized (this) {
            this.f830a.a(str, j);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0169cf> T b(String str, int i) {
        synchronized (this) {
            this.f830a.a(i, str);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0169cf> T b(String str, boolean z) {
        synchronized (this) {
            this.f830a.a(str, z);
        }
        return this;
    }

    public final <T extends AbstractC0169cf> T a(String str, List<String> list) {
        return (T) a(str, (String[]) list.toArray(new String[list.size()]));
    }

    public final long a(String str, long j) {
        return this.f830a.getLong(str, j);
    }

    public final int a(String str, int i) {
        return this.f830a.getInt(str, i);
    }

    public final String a(String str, String str2) {
        return this.f830a.getString(str, str2);
    }

    public final void b() {
        synchronized (this) {
            this.f830a.b();
        }
    }

    public final boolean a(String str, boolean z) {
        return this.f830a.getBoolean(str, z);
    }

    public final boolean b(String str) {
        return this.f830a.a(str);
    }
}
