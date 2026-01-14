package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.Be;
import io.appmetrica.analytics.impl.C0418m4;
import io.appmetrica.analytics.impl.C0462nn;
import io.appmetrica.analytics.impl.C0525qb;
import io.appmetrica.analytics.impl.C0646v8;
import io.appmetrica.analytics.impl.Gb;
import io.appmetrica.analytics.impl.Xm;
import io.appmetrica.analytics.impl.Yk;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class Attribute {
    public static BirthDateAttribute birthDate() {
        return new BirthDateAttribute();
    }

    public static BooleanAttribute customBoolean(String str) {
        return new BooleanAttribute(str, new C0525qb(), new Gb(new C0418m4(100)));
    }

    public static CounterAttribute customCounter(String str) {
        return new CounterAttribute(str, new C0525qb(), new Gb(new C0418m4(100)));
    }

    public static NumberAttribute customNumber(String str) {
        return new NumberAttribute(str, new C0525qb(), new Gb(new C0418m4(100)));
    }

    public static StringAttribute customString(String str) {
        return new StringAttribute(str, new Xm(200, "String attribute \"" + str + "\"", PublicLogger.getAnonymousInstance()), new C0525qb(), new Gb(new C0418m4(100)));
    }

    public static FirstPartyDataEmailSha256Attribute emailHash() {
        return new FirstPartyDataEmailSha256Attribute(new Yk(new C0646v8()));
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
        return new FirstPartyDataPhoneSha256Attribute(new Yk(new Be()));
    }

    public static FirstPartyDataTelegramLoginSha256Attribute telegramLoginHash() {
        return new FirstPartyDataTelegramLoginSha256Attribute(new Yk(new C0462nn()));
    }
}
