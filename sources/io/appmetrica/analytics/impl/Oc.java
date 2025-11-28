package io.appmetrica.analytics.impl;

import android.location.Location;
/* loaded from: classes5.dex */
public interface Oc {
    void a(Location location);

    void a(String str);

    void a(String str, String str2);

    void a(boolean z);

    void a(boolean z, boolean z2);

    void clearAppEnvironment();

    void putAppEnvironmentValue(String str, String str2);

    void setDataSendingEnabled(boolean z);

    void setUserProfileID(String str);
}
