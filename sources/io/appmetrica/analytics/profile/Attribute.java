package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0261fn;
import io.appmetrica.analytics.impl.C0276gc;
import io.appmetrica.analytics.impl.K4;
import io.appmetrica.analytics.impl.Qb;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public final class Attribute {
    public static BirthDateAttribute birthDate() {
        return new BirthDateAttribute();
    }

    public static BooleanAttribute customBoolean(String str) {
        return new BooleanAttribute(str, new Qb(), new C0276gc(new K4(100)));
    }

    public static CounterAttribute customCounter(String str) {
        return new CounterAttribute(str, new Qb(), new C0276gc(new K4(100)));
    }

    public static NumberAttribute customNumber(String str) {
        return new NumberAttribute(str, new Qb(), new C0276gc(new K4(100)));
    }

    public static StringAttribute customString(String str) {
        return new StringAttribute(str, new C0261fn(200, "String attribute \"" + str + "\"", PublicLogger.getAnonymousInstance()), new Qb(), new C0276gc(new K4(100)));
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
