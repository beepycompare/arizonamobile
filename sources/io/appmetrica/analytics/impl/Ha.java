package io.appmetrica.analytics.impl;

import java.util.Set;
/* loaded from: classes5.dex */
public interface Ha {
    Ha a(int i, String str);

    Ha a(String str, float f);

    Ha a(String str, long j);

    Ha a(String str, String str2);

    Ha a(String str, boolean z);

    Set a();

    boolean a(String str);

    void b();

    boolean getBoolean(String str, boolean z);

    int getInt(String str, int i);

    long getLong(String str, long j);

    String getString(String str, String str2);

    Ha remove(String str);
}
