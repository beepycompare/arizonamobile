package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0174cf;
import io.appmetrica.analytics.impl.C0326ic;
import io.appmetrica.analytics.impl.C0777zn;
import io.appmetrica.analytics.impl.D4;
import io.appmetrica.analytics.impl.Dl;
import io.appmetrica.analytics.impl.O8;
import io.appmetrica.analytics.impl.On;
import io.appmetrica.analytics.impl.Sb;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class Attribute {
    public static BirthDateAttribute birthDate() {
        return new BirthDateAttribute();
    }

    public static BooleanAttribute customBoolean(String str) {
        return new BooleanAttribute(str, new Sb(), new C0326ic(new D4(100)));
    }

    public static CounterAttribute customCounter(String str) {
        return new CounterAttribute(str, new Sb(), new C0326ic(new D4(100)));
    }

    public static NumberAttribute customNumber(String str) {
        return new NumberAttribute(str, new Sb(), new C0326ic(new D4(100)));
    }

    public static StringAttribute customString(String str) {
        return new StringAttribute(str, new C0777zn(200, "String attribute \"" + str + "\"", PublicLogger.getAnonymousInstance()), new Sb(), new C0326ic(new D4(100)));
    }

    public static FirstPartyDataEmailSha256Attribute emailHash() {
        return new FirstPartyDataEmailSha256Attribute(new Dl(new O8()));
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

    public static FirstPartyDataPhoneSha256Attribute phoneHash() {
        return new FirstPartyDataPhoneSha256Attribute(new Dl(new C0174cf()));
    }

    public static FirstPartyDataTelegramLoginSha256Attribute telegramLoginHash() {
        return new FirstPartyDataTelegramLoginSha256Attribute(new Dl(new On()));
    }
}
