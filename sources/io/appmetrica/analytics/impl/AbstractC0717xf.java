package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.Set;
import org.json.JSONArray;
/* renamed from: io.appmetrica.analytics.impl.xf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0717xf implements Zl {
    public static final String c = "xf";

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0350jb f1281a;
    public final String b;

    public AbstractC0717xf(InterfaceC0350jb interfaceC0350jb) {
        this(interfaceC0350jb, null);
    }

    public abstract /* synthetic */ int a(String str, int i);

    public abstract /* synthetic */ long a(String str, long j);

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0717xf> T a(String str, float f) {
        synchronized (this) {
            this.f1281a.a(str, f);
        }
        return this;
    }

    public abstract /* synthetic */ String a(String str, String str2);

    public abstract /* synthetic */ boolean a(String str, boolean z);

    public abstract /* synthetic */ Zl b(String str, int i);

    public abstract /* synthetic */ Zl b(String str, long j);

    public abstract /* synthetic */ Zl b(String str, String str2);

    public abstract /* synthetic */ Zl b(String str, boolean z);

    public abstract /* synthetic */ boolean b(String str);

    public final long c(String str, long j) {
        return this.f1281a.getLong(str, j);
    }

    public final C0743yf d(String str) {
        return new C0743yf(str, this.b);
    }

    public abstract /* synthetic */ Zl e(String str);

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0717xf> T f(String str) {
        synchronized (this) {
            this.f1281a.remove(str);
        }
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Zl, io.appmetrica.analytics.impl.ep
    public void flushAsync() {
        this.f1281a.flushAsync();
    }

    public AbstractC0717xf(InterfaceC0350jb interfaceC0350jb, String str) {
        this.f1281a = interfaceC0350jb;
        this.b = str;
    }

    public final int c(String str, int i) {
        return this.f1281a.getInt(str, i);
    }

    public final String c(String str, String str2) {
        return this.f1281a.getString(str, str2);
    }

    public final boolean c(String str, boolean z) {
        return this.f1281a.getBoolean(str, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0717xf> T d(String str, String str2) {
        synchronized (this) {
            this.f1281a.a(str, str2);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0717xf> T a(String str, String[] strArr) {
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
        this.f1281a.a(str, str2);
        return this;
    }

    public final boolean c(String str) {
        return this.f1281a.a(str);
    }

    public Set<String> c() {
        return this.f1281a.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0717xf> T d(String str, long j) {
        synchronized (this) {
            this.f1281a.a(str, j);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0717xf> T d(String str, int i) {
        synchronized (this) {
            this.f1281a.a(str, i);
        }
        return this;
    }

    public final <T extends AbstractC0717xf> T a(String str, List<String> list) {
        return (T) a(str, (String[]) list.toArray(new String[list.size()]));
    }

    public void a() {
        synchronized (this) {
            this.f1281a.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC0717xf> T d(String str, boolean z) {
        synchronized (this) {
            this.f1281a.a(str, z);
        }
        return this;
    }
}
