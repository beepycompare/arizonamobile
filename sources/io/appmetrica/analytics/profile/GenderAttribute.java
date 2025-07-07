package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0534q8;
import io.appmetrica.analytics.impl.C0558r8;
import io.appmetrica.analytics.impl.C0671vl;
import io.appmetrica.analytics.impl.L6;
import io.appmetrica.analytics.impl.Li;
import io.appmetrica.analytics.impl.N4;
import io.appmetrica.analytics.impl.Um;
import io.appmetrica.analytics.impl.Vk;
import io.appmetrica.analytics.impl.Yn;
/* loaded from: classes4.dex */
public class GenderAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final L6 f1254a = new L6("appmetrica_gender", new C0558r8(), new C0671vl());

    /* loaded from: classes4.dex */
    public enum Gender {
        MALE("M"),
        FEMALE("F"),
        OTHER("O");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f1255a;

        Gender(String str) {
            this.f1255a = str;
        }

        public String getStringValue() {
            return this.f1255a;
        }
    }

    public UserProfileUpdate<? extends Yn> withValue(Gender gender) {
        String str = this.f1254a.c;
        String stringValue = gender.getStringValue();
        C0534q8 c0534q8 = new C0534q8();
        L6 l6 = this.f1254a;
        return new UserProfileUpdate<>(new Um(str, stringValue, c0534q8, l6.f513a, new N4(l6.b)));
    }

    public UserProfileUpdate<? extends Yn> withValueIfUndefined(Gender gender) {
        String str = this.f1254a.c;
        String stringValue = gender.getStringValue();
        C0534q8 c0534q8 = new C0534q8();
        L6 l6 = this.f1254a;
        return new UserProfileUpdate<>(new Um(str, stringValue, c0534q8, l6.f513a, new Vk(l6.b)));
    }

    public UserProfileUpdate<? extends Yn> withValueReset() {
        L6 l6 = this.f1254a;
        return new UserProfileUpdate<>(new Li(0, l6.c, l6.f513a, l6.b));
    }
}
