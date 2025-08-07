package io.appmetrica.analytics.impl;

import android.content.Context;
import android.util.SparseArray;
import io.appmetrica.analytics.AppMetrica;
/* renamed from: io.appmetrica.analytics.impl.ed  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0233ed {
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
                    InterfaceC0208dd interfaceC0208dd = (InterfaceC0208dd) c.get(b);
                    if (interfaceC0208dd != null) {
                        interfaceC0208dd.a(context);
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
