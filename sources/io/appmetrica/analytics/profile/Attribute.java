package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.H4;
import io.appmetrica.analytics.impl.Jb;
import io.appmetrica.analytics.impl.Tm;
import io.appmetrica.analytics.impl.Zb;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public final class Attribute {
    public static BirthDateAttribute birthDate() {
        return new BirthDateAttribute();
    }

    public static BooleanAttribute customBoolean(String str) {
        return new BooleanAttribute(str, new Jb(), new Zb(new H4(100)));
    }

    public static CounterAttribute customCounter(String str) {
        return new CounterAttribute(str, new Jb(), new Zb(new H4(100)));
    }

    public static NumberAttribute customNumber(String str) {
        return new NumberAttribute(str, new Jb(), new Zb(new H4(100)));
    }

    public static StringAttribute customString(String str) {
        return new StringAttribute(str, new Tm(200, "String attribute \"" + str + "\"", PublicLogger.getAnonymousInstance()), new Jb(), new Zb(new H4(100)));
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
