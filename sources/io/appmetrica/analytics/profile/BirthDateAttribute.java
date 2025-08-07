package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0603t8;
import io.appmetrica.analytics.impl.C0628u8;
import io.appmetrica.analytics.impl.C0741yl;
import io.appmetrica.analytics.impl.InterfaceC0167bo;
import io.appmetrica.analytics.impl.N4;
import io.appmetrica.analytics.impl.O6;
import io.appmetrica.analytics.impl.Oi;
import io.appmetrica.analytics.impl.W2;
import io.appmetrica.analytics.impl.Xm;
import io.appmetrica.analytics.impl.Yk;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
/* loaded from: classes4.dex */
public class BirthDateAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final O6 f1255a = new O6("appmetrica_birth_date", new C0628u8(), new C0741yl());

    final UserProfileUpdate a(Calendar calendar, String str, W2 w2) {
        return new UserProfileUpdate(new Xm(this.f1255a.c, new SimpleDateFormat(str).format(calendar.getTime()), new C0603t8(), new C0628u8(), w2));
    }

    public UserProfileUpdate<? extends InterfaceC0167bo> withAge(int i) {
        int i2 = Calendar.getInstance(Locale.US).get(1) - i;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i2);
        return a(gregorianCalendar, "yyyy", new N4(this.f1255a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0167bo> withAgeIfUndefined(int i) {
        int i2 = Calendar.getInstance(Locale.US).get(1) - i;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i2);
        return a(gregorianCalendar, "yyyy", new Yk(this.f1255a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0167bo> withBirthDate(Calendar calendar) {
        return a(calendar, "yyyy-MM-dd", new N4(this.f1255a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0167bo> withBirthDateIfUndefined(Calendar calendar) {
        return a(calendar, "yyyy-MM-dd", new Yk(this.f1255a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0167bo> withValueReset() {
        return new UserProfileUpdate<>(new Oi(0, this.f1255a.c, new C0628u8(), new C0741yl()));
    }

    public UserProfileUpdate<? extends InterfaceC0167bo> withBirthDate(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        return a(gregorianCalendar, "yyyy", new N4(this.f1255a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0167bo> withBirthDateIfUndefined(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        return a(gregorianCalendar, "yyyy", new Yk(this.f1255a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0167bo> withBirthDate(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, 1);
        return a(gregorianCalendar, "yyyy-MM", new N4(this.f1255a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0167bo> withBirthDateIfUndefined(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, 1);
        return a(gregorianCalendar, "yyyy-MM", new Yk(this.f1255a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0167bo> withBirthDate(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, i3);
        return a(gregorianCalendar, "yyyy-MM-dd", new N4(this.f1255a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0167bo> withBirthDateIfUndefined(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, i3);
        return a(gregorianCalendar, "yyyy-MM-dd", new Yk(this.f1255a.b));
    }
}
