package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0602t8;
import io.appmetrica.analytics.impl.C0627u8;
import io.appmetrica.analytics.impl.C0740yl;
import io.appmetrica.analytics.impl.InterfaceC0166bo;
import io.appmetrica.analytics.impl.N4;
import io.appmetrica.analytics.impl.O6;
import io.appmetrica.analytics.impl.Oi;
import io.appmetrica.analytics.impl.Xm;
import io.appmetrica.analytics.impl.Yk;
/* loaded from: classes4.dex */
public class GenderAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final O6 f1258a = new O6("appmetrica_gender", new C0627u8(), new C0740yl());

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

    public UserProfileUpdate<? extends InterfaceC0166bo> withValue(Gender gender) {
        String str = this.f1258a.c;
        String stringValue = gender.getStringValue();
        C0602t8 c0602t8 = new C0602t8();
        O6 o6 = this.f1258a;
        return new UserProfileUpdate<>(new Xm(str, stringValue, c0602t8, o6.f573a, new N4(o6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0166bo> withValueIfUndefined(Gender gender) {
        String str = this.f1258a.c;
        String stringValue = gender.getStringValue();
        C0602t8 c0602t8 = new C0602t8();
        O6 o6 = this.f1258a;
        return new UserProfileUpdate<>(new Xm(str, stringValue, c0602t8, o6.f573a, new Yk(o6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0166bo> withValueReset() {
        O6 o6 = this.f1258a;
        return new UserProfileUpdate<>(new Oi(0, o6.c, o6.f573a, o6.b));
    }
}
