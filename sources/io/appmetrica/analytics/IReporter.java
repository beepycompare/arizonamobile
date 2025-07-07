package io.appmetrica.analytics;

import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.plugins.IPluginReporter;
import io.appmetrica.analytics.profile.UserProfile;
import java.util.Map;
/* loaded from: classes4.dex */
public interface IReporter {
    void clearAppEnvironment();

    IPluginReporter getPluginExtension();

    void pauseSession();

    void putAppEnvironmentValue(String str, String str2);

    void reportAdRevenue(AdRevenue adRevenue);

    void reportAnr(Map<Thread, StackTraceElement[]> map);

    void reportECommerce(ECommerceEvent eCommerceEvent);

    void reportError(String str, String str2);

    void reportError(String str, String str2, Throwable th);

    void reportError(String str, Throwable th);

    void reportEvent(String str);

    void reportEvent(String str, String str2);

    void reportEvent(String str, Map<String, Object> map);

    void reportRevenue(Revenue revenue);

    void reportUnhandledException(Throwable th);

    void reportUserProfile(UserProfile userProfile);

    void resumeSession();

    void sendEventsBuffer();

    void setDataSendingEnabled(boolean z);

    void setUserProfileID(String str);
}
