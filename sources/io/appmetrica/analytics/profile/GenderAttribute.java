package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0603t8;
import io.appmetrica.analytics.impl.C0628u8;
import io.appmetrica.analytics.impl.C0741yl;
import io.appmetrica.analytics.impl.InterfaceC0167bo;
import io.appmetrica.analytics.impl.N4;
import io.appmetrica.analytics.impl.O6;
import io.appmetrica.analytics.impl.Oi;
import io.appmetrica.analytics.impl.Xm;
import io.appmetrica.analytics.impl.Yk;
/* loaded from: classes4.dex */
public class GenderAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final O6 f1258a = new O6("appmetrica_gender", new C0628u8(), new C0741yl());

    /* loaded from: classes4.dex */
    public enum Gender {
        MALE("M"),
        FEMALE("F"),
        OTHER("O");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f1259a;

        Gender(String str) {
            this.f1259a = str;
        }

        public String getStringValue() {
            return this.f1259a;
        }
    }

    public UserProfileUpdate<? extends InterfaceC0167bo> withValue(Gender gender) {
        String str = this.f1258a.c;
        String stringValue = gender.getStringValue();
        C0603t8 c0603t8 = new C0603t8();
        O6 o6 = this.f1258a;
        return new UserProfileUpdate<>(new Xm(str, stringValue, c0603t8, o6.f573a, new N4(o6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0167bo> withValueIfUndefined(Gender gender) {
        String str = this.f1258a.c;
        String stringValue = gender.getStringValue();
        C0603t8 c0603t8 = new C0603t8();
        O6 o6 = this.f1258a;
        return new UserProfileUpdate<>(new Xm(str, stringValue, c0603t8, o6.f573a, new Yk(o6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0167bo> withValueReset() {
        O6 o6 = this.f1258a;
        return new UserProfileUpdate<>(new Oi(0, o6.c, o6.f573a, o6.b));
    }
}
