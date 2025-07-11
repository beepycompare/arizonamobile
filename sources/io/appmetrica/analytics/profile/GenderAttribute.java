package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0526q8;
import io.appmetrica.analytics.impl.C0550r8;
import io.appmetrica.analytics.impl.C0663vl;
import io.appmetrica.analytics.impl.L6;
import io.appmetrica.analytics.impl.Li;
import io.appmetrica.analytics.impl.N4;
import io.appmetrica.analytics.impl.Um;
import io.appmetrica.analytics.impl.Vk;
import io.appmetrica.analytics.impl.Yn;
/* loaded from: classes4.dex */
public class GenderAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final L6 f1255a = new L6("appmetrica_gender", new C0550r8(), new C0663vl());

    /* loaded from: classes4.dex */
    public enum Gender {
        MALE("M"),
        FEMALE("F"),
        OTHER("O");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f1256a;

        Gender(String str) {
            this.f1256a = str;
        }

        public String getStringValue() {
            return this.f1256a;
        }
    }

    public UserProfileUpdate<? extends Yn> withValue(Gender gender) {
        String str = this.f1255a.c;
        String stringValue = gender.getStringValue();
        C0526q8 c0526q8 = new C0526q8();
        L6 l6 = this.f1255a;
        return new UserProfileUpdate<>(new Um(str, stringValue, c0526q8, l6.f514a, new N4(l6.b)));
    }

    public UserProfileUpdate<? extends Yn> withValueIfUndefined(Gender gender) {
        String str = this.f1255a.c;
        String stringValue = gender.getStringValue();
        C0526q8 c0526q8 = new C0526q8();
        L6 l6 = this.f1255a;
        return new UserProfileUpdate<>(new Um(str, stringValue, c0526q8, l6.f514a, new Vk(l6.b)));
    }

    public UserProfileUpdate<? extends Yn> withValueReset() {
        L6 l6 = this.f1255a;
        return new UserProfileUpdate<>(new Li(0, l6.c, l6.f514a, l6.b));
    }
}
