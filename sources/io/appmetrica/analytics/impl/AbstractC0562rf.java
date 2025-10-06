package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.Set;
import org.json.JSONArray;
/* renamed from: io.appmetrica.analytics.impl.rf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0562rf {
    public static final String c = "rf";

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0302hb f1067a;
    public final String b;

    public AbstractC0562rf(InterfaceC0302hb interfaceC0302hb, String str) {
        this.f1067a = interfaceC0302hb;
        this.b = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0562rf> T a(String str, float f) {
        synchronized (this) {
            this.f1067a.a(str, f);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0562rf> T b(String str, String str2) {
        synchronized (this) {
            this.f1067a.a(str, str2);
        }
        return this;
    }

    public final C0587sf c(String str) {
        return new C0587sf(str, this.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0562rf> T d(String str) {
        synchronized (this) {
            this.f1067a.remove(str);
        }
        return this;
    }

    public Set<String> c() {
        return this.f1067a.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0562rf> T a(String str, String[] strArr) {
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
        this.f1067a.a(str, str2);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0562rf> T b(String str, long j) {
        synchronized (this) {
            this.f1067a.a(str, j);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0562rf> T b(String str, int i) {
        synchronized (this) {
            this.f1067a.a(i, str);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0562rf> T b(String str, boolean z) {
        synchronized (this) {
            this.f1067a.a(str, z);
        }
        return this;
    }

    public final <T extends AbstractC0562rf> T a(String str, List<String> list) {
        return (T) a(str, (String[]) list.toArray(new String[list.size()]));
    }

    public final long a(String str, long j) {
        return this.f1067a.getLong(str, j);
    }

    public final int a(String str, int i) {
        return this.f1067a.getInt(str, i);
    }

    public final String a(String str, String str2) {
        return this.f1067a.getString(str, str2);
    }

    public final void b() {
        synchronized (this) {
            this.f1067a.b();
        }
    }

    public final boolean a(String str, boolean z) {
        return this.f1067a.getBoolean(str, z);
    }

    public final boolean b(String str) {
        return this.f1067a.a(str);
    }
}
