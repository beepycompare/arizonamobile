package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0154bc;
import io.appmetrica.analytics.impl.H4;
import io.appmetrica.analytics.impl.Lb;
import io.appmetrica.analytics.impl.Wm;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public final class Attribute {
    public static BirthDateAttribute birthDate() {
        return new BirthDateAttribute();
    }

    public static BooleanAttribute customBoolean(String str) {
        return new BooleanAttribute(str, new Lb(), new C0154bc(new H4(100)));
    }

    public static CounterAttribute customCounter(String str) {
        return new CounterAttribute(str, new Lb(), new C0154bc(new H4(100)));
    }

    public static NumberAttribute customNumber(String str) {
        return new NumberAttribute(str, new Lb(), new C0154bc(new H4(100)));
    }

    public static StringAttribute customString(String str) {
        return new StringAttribute(str, new Wm(200, "String attribute \"" + str + "\"", PublicLogger.getAnonymousInstance()), new Lb(), new C0154bc(new H4(100)));
    }

    public static GenderAttribute gender() {
        return new GenderAttribute();
    }

    public static NameAttribute name() {
        return new NameAttribute();
    }

    public static NotificationsEnabledAttribute notificationsEnabled() {
        return new NotificationsEnabledAttribute();
    }
}
