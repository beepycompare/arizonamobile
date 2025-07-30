package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.C0602t8;
import io.appmetrica.analytics.impl.C0627u8;
import io.appmetrica.analytics.impl.C0740yl;
import io.appmetrica.analytics.impl.InterfaceC0166bo;
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
    private final O6 f1256a = new O6("appmetrica_birth_date", new C0627u8(), new C0740yl());

    final UserProfileUpdate a(Calendar calendar, String str, W2 w2) {
        return new UserProfileUpdate(new Xm(this.f1256a.c, new SimpleDateFormat(str).format(calendar.getTime()), new C0602t8(), new C0627u8(), w2));
    }

    public UserProfileUpdate<? extends InterfaceC0166bo> withAge(int i) {
        int i2 = Calendar.getInstance(Locale.US).get(1) - i;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i2);
        return a(gregorianCalendar, "yyyy", new N4(this.f1256a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0166bo> withAgeIfUndefined(int i) {
        int i2 = Calendar.getInstance(Locale.US).get(1) - i;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i2);
        return a(gregorianCalendar, "yyyy", new Yk(this.f1256a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0166bo> withBirthDate(Calendar calendar) {
        return a(calendar, "yyyy-MM-dd", new N4(this.f1256a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0166bo> withBirthDateIfUndefined(Calendar calendar) {
        return a(calendar, "yyyy-MM-dd", new Yk(this.f1256a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0166bo> withValueReset() {
        return new UserProfileUpdate<>(new Oi(0, this.f1256a.c, new C0627u8(), new C0740yl()));
    }

    public UserProfileUpdate<? extends InterfaceC0166bo> withBirthDate(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        return a(gregorianCalendar, "yyyy", new N4(this.f1256a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0166bo> withBirthDateIfUndefined(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        return a(gregorianCalendar, "yyyy", new Yk(this.f1256a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0166bo> withBirthDate(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, 1);
        return a(gregorianCalendar, "yyyy-MM", new N4(this.f1256a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0166bo> withBirthDateIfUndefined(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, 1);
        return a(gregorianCalendar, "yyyy-MM", new Yk(this.f1256a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0166bo> withBirthDate(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, i3);
        return a(gregorianCalendar, "yyyy-MM-dd", new N4(this.f1256a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0166bo> withBirthDateIfUndefined(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, i3);
        return a(gregorianCalendar, "yyyy-MM-dd", new Yk(this.f1256a.b));
    }
}
