package io.appmetrica.analytics.profile;

import io.appmetrica.analytics.impl.An;
import io.appmetrica.analytics.impl.C0128am;
import io.appmetrica.analytics.impl.C0579s8;
import io.appmetrica.analytics.impl.C0605t8;
import io.appmetrica.analytics.impl.Cl;
import io.appmetrica.analytics.impl.Ho;
import io.appmetrica.analytics.impl.J4;
import io.appmetrica.analytics.impl.L6;
import io.appmetrica.analytics.impl.Vi;
import io.appmetrica.analytics.impl.W2;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
/* loaded from: classes5.dex */
public class BirthDateAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final L6 f1411a = new L6("appmetrica_birth_date", new C0605t8(), new C0128am());

    final UserProfileUpdate a(Calendar calendar, String str, W2 w2) {
        return new UserProfileUpdate(new An(this.f1411a.c, new SimpleDateFormat(str).format(calendar.getTime()), new C0579s8(), new C0605t8(), w2));
    }

    public UserProfileUpdate<? extends Ho> withAge(int i) {
        int i2 = Calendar.getInstance(Locale.US).get(1) - i;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i2);
        return a(gregorianCalendar, "yyyy", new J4(this.f1411a.b));
    }

    public UserProfileUpdate<? extends Ho> withAgeIfUndefined(int i) {
        int i2 = Calendar.getInstance(Locale.US).get(1) - i;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i2);
        return a(gregorianCalendar, "yyyy", new Cl(this.f1411a.b));
    }

    public UserProfileUpdate<? extends Ho> withBirthDate(Calendar calendar) {
        return a(calendar, "yyyy-MM-dd", new J4(this.f1411a.b));
    }

    public UserProfileUpdate<? extends Ho> withBirthDateIfUndefined(Calendar calendar) {
        return a(calendar, "yyyy-MM-dd", new Cl(this.f1411a.b));
    }

    public UserProfileUpdate<? extends Ho> withValueReset() {
        return new UserProfileUpdate<>(new Vi(0, this.f1411a.c, new C0605t8(), new C0128am()));
    }

    public UserProfileUpdate<? extends Ho> withBirthDate(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        return a(gregorianCalendar, "yyyy", new J4(this.f1411a.b));
    }

    public UserProfileUpdate<? extends Ho> withBirthDateIfUndefined(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        return a(gregorianCalendar, "yyyy", new Cl(this.f1411a.b));
    }

    public UserProfileUpdate<? extends Ho> withBirthDate(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, 1);
        return a(gregorianCalendar, "yyyy-MM", new J4(this.f1411a.b));
    }

    public UserProfileUpdate<? extends Ho> withBirthDateIfUndefined(int i, int i2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, 1);
        return a(gregorianCalendar, "yyyy-MM", new Cl(this.f1411a.b));
    }

    public UserProfileUpdate<? extends Ho> withBirthDate(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, i3);
        return a(gregorianCalendar, "yyyy-MM-dd", new J4(this.f1411a.b));
    }

    public UserProfileUpdate<? extends Ho> withBirthDateIfUndefined(int i, int i2, int i3) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, i);
        gregorianCalendar.set(2, i2 - 1);
        gregorianCalendar.set(5, i3);
        return a(gregorianCalendar, "yyyy-MM-dd", new Cl(this.f1411a.b));
    }
}
