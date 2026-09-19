package io.appmetrica.analytics.impl;

import android.content.Context;
import android.util.SparseArray;
import io.appmetrica.analytics.AppMetrica;
/* renamed from: io.appmetrica.analytics.impl.kd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0376kd {
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
                    InterfaceC0350jd interfaceC0350jd = (InterfaceC0350jd) c.get(b);
                    if (interfaceC0350jd != null) {
                        interfaceC0350jd.a(context);
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
