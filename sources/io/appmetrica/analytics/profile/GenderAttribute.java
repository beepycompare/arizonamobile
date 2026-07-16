package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.An;
import io.appmetrica.analytics.impl.C0129am;
import io.appmetrica.analytics.impl.C0580s8;
import io.appmetrica.analytics.impl.C0606t8;
import io.appmetrica.analytics.impl.Cl;
import io.appmetrica.analytics.impl.Ho;
import io.appmetrica.analytics.impl.J4;
import io.appmetrica.analytics.impl.L6;
import io.appmetrica.analytics.impl.Vi;
/* loaded from: classes5.dex */
public class GenderAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final L6 f1417a = new L6("appmetrica_gender", new C0606t8(), new C0129am());

    /* loaded from: classes5.dex */
    public enum Gender {
        MALE("M"),
        FEMALE("F"),
        OTHER("O");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f1418a;

        Gender(String str) {
            this.f1418a = str;
        }

        public String getStringValue() {
            return this.f1418a;
        }
    }

    public UserProfileUpdate<? extends Ho> withValue(Gender gender) {
        String str = this.f1417a.c;
        String stringValue = gender.getStringValue();
        C0580s8 c0580s8 = new C0580s8();
        L6 l6 = this.f1417a;
        return new UserProfileUpdate<>(new An(str, stringValue, c0580s8, l6.f644a, new J4(l6.b)));
    }

    public UserProfileUpdate<? extends Ho> withValueIfUndefined(Gender gender) {
        String str = this.f1417a.c;
        String stringValue = gender.getStringValue();
        C0580s8 c0580s8 = new C0580s8();
        L6 l6 = this.f1417a;
        return new UserProfileUpdate<>(new An(str, stringValue, c0580s8, l6.f644a, new Cl(l6.b)));
    }

    public UserProfileUpdate<? extends Ho> withValueReset() {
        L6 l6 = this.f1417a;
        return new UserProfileUpdate<>(new Vi(0, l6.c, l6.f644a, l6.b));
    }
}
