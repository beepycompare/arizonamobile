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
import io.appmetrica.analytics.impl.W2;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
/* loaded from: classes4.dex */
public class BirthDateAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final P6 f1265a = new P6("appmetrica_birth_date", new C0675w8(), new Dl());

    final UserProfileUpdate a(Calendar calendar, String str, W2 w2) {
        return new UserProfileUpdate(new C0184cn(this.f1265a.c, new SimpleDateFormat(str).format(calendar.getTime()), new C0650v8(), new C0675w8(), w2));
    }

    public UserProfileUpdate<? extends InterfaceC0288go> withAge(int i) {
        int i2 = Calendar.getInstance(Locale.US).get(1) - i;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i2);
        return a(gregorianCalendar, "yyyy", new N4(this.f1265a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0288go> withAgeIfUndefined(int i) {
        int i2 = Calendar.getInstance(Locale.US).get(1) - i;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i2);
        return a(gregorianCalendar, "yyyy", new C0208dl(this.f1265a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0288go> withBirthDate(Calendar calendar) {
        return a(calendar, "yyyy-MM-dd", new N4(this.f1265a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0288go> withBirthDateIfUndefined(Calendar calendar) {
        return a(calendar, "yyyy-MM-dd", new C0208dl(this.f1265a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0288go> withValueReset() {
        return new UserProfileUpdate<>(new Ti(0, this.f1265a.c, new C0675w8(), new Dl()));
    }

    public UserProfileUpdate<? extends InterfaceC0288go> withBirthDate(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        return a(gregorianCalendar, "yyyy", new N4(this.f1265a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0288go> withBirthDateIfUndefined(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        return a(gregorianCalendar, "yyyy", new C0208dl(this.f1265a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0288go> withBirthDate(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, 1);
        return a(gregorianCalendar, "yyyy-MM", new N4(this.f1265a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0288go> withBirthDateIfUndefined(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, 1);
        return a(gregorianCalendar, "yyyy-MM", new C0208dl(this.f1265a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0288go> withBirthDate(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, i3);
        return a(gregorianCalendar, "yyyy-MM-dd", new N4(this.f1265a.b));
    }

    public UserProfileUpdate<? extends InterfaceC0288go> withBirthDateIfUndefined(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, i3);
        return a(gregorianCalendar, "yyyy-MM-dd", new C0208dl(this.f1265a.b));
    }
}
