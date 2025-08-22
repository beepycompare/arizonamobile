package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0184cn;
import io.appmetrica.analytics.impl.C0208dl;
import io.appmetrica.analytics.impl.C0650v8;
import io.appmetrica.analytics.impl.C0675w8;
import io.appmetrica.analytics.impl.Dl;
import io.appmetrica.analytics.impl.InterfaceC0288go;
import io.appmetrica.analytics.impl.N4;
import io.appmetrica.analytics.impl.P6;
import io.appmetrica.analytics.impl.Ti;
/* loaded from: classes4.dex */
public class GenderAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final P6 f1268a = new P6("appmetrica_gender", new C0675w8(), new Dl());

    /* loaded from: classes4.dex */
    public enum Gender {
        MALE("M"),
        FEMALE("F"),
        OTHER("O");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f1269a;

        Gender(String str) {
            this.f1269a = str;
        }

        public String getStringValue() {
            return this.f1269a;
        }
    }

    public UserProfileUpdate<? extends InterfaceC0288go> withValue(Gender gender) {
        String str = this.f1268a.c;
        String stringValue = gender.getStringValue();
        C0650v8 c0650v8 = new C0650v8();
        P6 p6 = this.f1268a;
        return new UserProfileUpdate<>(new C0184cn(str, stringValue, c0650v8, p6.f600a, new N4(p6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0288go> withValueIfUndefined(Gender gender) {
        String str = this.f1268a.c;
        String stringValue = gender.getStringValue();
        C0650v8 c0650v8 = new C0650v8();
        P6 p6 = this.f1268a;
        return new UserProfileUpdate<>(new C0184cn(str, stringValue, c0650v8, p6.f600a, new C0208dl(p6.b)));
    }

    public UserProfileUpdate<? extends InterfaceC0288go> withValueReset() {
        P6 p6 = this.f1268a;
        return new UserProfileUpdate<>(new Ti(0, p6.c, p6.f600a, p6.b));
    }
}
