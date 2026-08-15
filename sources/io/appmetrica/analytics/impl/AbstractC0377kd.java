package io.appmetrica.analytics.impl;

import android.content.Context;
import android.util.SparseArray;
import io.appmetrica.analytics.AppMetrica;
/* renamed from: io.appmetrica.analytics.impl.kd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0377kd {
    public abstract void a(int i);

    public final synchronized void a(Context context) {
        int b = b();
        int libraryApiLevel = AppMetrica.getLibraryApiLevel();
        if (b != libraryApiLevel) {
            if (b < libraryApiLevel) {
                SparseArray c = c();
                while (true) {
                    b++;
                    if (b > libraryApiLevel) {
                        break;
                    }
                    InterfaceC0351jd interfaceC0351jd = (InterfaceC0351jd) c.get(b);
                    if (interfaceC0351jd != null) {
                        interfaceC0351jd.a(context);
                    }
                }
            }
            a(libraryApiLevel);
        }
    }

    public abstract int b();

    public abstract SparseArray c();

    public final int a() {
        return AppMetrica.getLibraryApiLevel();
    }
}
