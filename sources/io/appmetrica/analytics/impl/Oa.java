package io.appmetrica.analytics.impl;

import java.util.Set;
/* loaded from: classes3.dex */
public interface Oa {
    Oa a(int i, String str);

    Oa a(String str, float f);

    Oa a(String str, long j);

    Oa a(String str, String str2);

    Oa a(String str, boolean z);

    Set a();

    boolean a(String str);

    void b();

    boolean getBoolean(String str, boolean z);

    int getInt(String str, int i);

    long getLong(String str, long j);

    String getString(String str, String str2);

    Oa remove(String str);
}
