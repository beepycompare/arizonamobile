package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.Set;
import org.json.JSONArray;
/* renamed from: io.appmetrica.analytics.impl.nf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0458nf {
    public static final String c = "nf";

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0223eb f983a;
    public final String b;

    public AbstractC0458nf(InterfaceC0223eb interfaceC0223eb, String str) {
        this.f983a = interfaceC0223eb;
        this.b = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0458nf> T a(String str, float f) {
        synchronized (this) {
            this.f983a.a(str, f);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0458nf> T b(String str, String str2) {
        synchronized (this) {
            this.f983a.a(str, str2);
        }
        return this;
    }

    public final C0483of c(String str) {
        return new C0483of(str, this.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0458nf> T d(String str) {
        synchronized (this) {
            this.f983a.remove(str);
        }
        return this;
    }

    public Set<String> c() {
        return this.f983a.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0458nf> T a(String str, String[] strArr) {
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
        this.f983a.a(str, str2);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0458nf> T b(String str, long j) {
        synchronized (this) {
            this.f983a.a(str, j);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0458nf> T b(String str, int i) {
        synchronized (this) {
            this.f983a.a(i, str);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0458nf> T b(String str, boolean z) {
        synchronized (this) {
            this.f983a.a(str, z);
        }
        return this;
    }

    public final <T extends AbstractC0458nf> T a(String str, List<String> list) {
        return (T) a(str, (String[]) list.toArray(new String[list.size()]));
    }

    public final long a(String str, long j) {
        return this.f983a.getLong(str, j);
    }

    public final int a(String str, int i) {
        return this.f983a.getInt(str, i);
    }

    public final String a(String str, String str2) {
        return this.f983a.getString(str, str2);
    }

    public final void b() {
        synchronized (this) {
            this.f983a.b();
        }
    }

    public final boolean a(String str, boolean z) {
        return this.f983a.getBoolean(str, z);
    }

    public final boolean b(String str) {
        return this.f983a.a(str);
    }
}
