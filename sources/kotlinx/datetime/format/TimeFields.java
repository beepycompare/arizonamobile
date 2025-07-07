package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlinx.datetime.internal.DecimalFraction;
import kotlinx.datetime.internal.format.GenericFieldSpec;
import kotlinx.datetime.internal.format.PropertyAccessor;
import kotlinx.datetime.internal.format.UnsignedFieldSpec;
/* compiled from: LocalTimeFormat.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u0016"}, d2 = {"Lkotlinx/datetime/format/TimeFields;", "", "()V", "amPm", "Lkotlinx/datetime/internal/format/GenericFieldSpec;", "Lkotlinx/datetime/format/TimeFieldContainer;", "Lkotlinx/datetime/format/AmPmMarker;", "getAmPm", "()Lkotlinx/datetime/internal/format/GenericFieldSpec;", "fractionOfSecond", "Lkotlinx/datetime/internal/DecimalFraction;", "getFractionOfSecond", "hour", "Lkotlinx/datetime/internal/format/UnsignedFieldSpec;", "getHour", "()Lkotlinx/datetime/internal/format/UnsignedFieldSpec;", "hourOfAmPm", "getHourOfAmPm", "minute", "getMinute", "second", "getSecond", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
final class TimeFields {
    public static final TimeFields INSTANCE = new TimeFields();
    private static final UnsignedFieldSpec<TimeFieldContainer> hour = new UnsignedFieldSpec<>(new PropertyAccessor(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.TimeFields$hour$1
        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object obj) {
            return ((TimeFieldContainer) obj).getHour();
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object obj, Object obj2) {
            ((TimeFieldContainer) obj).setHour((Integer) obj2);
        }
    }), 0, 23, null, null, null, 56, null);
    private static final UnsignedFieldSpec<TimeFieldContainer> minute = new UnsignedFieldSpec<>(new PropertyAccessor(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.TimeFields$minute$1
        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object obj) {
            return ((TimeFieldContainer) obj).getMinute();
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object obj, Object obj2) {
            ((TimeFieldContainer) obj).setMinute((Integer) obj2);
        }
    }), 0, 59, null, null, null, 56, null);
    private static final UnsignedFieldSpec<TimeFieldContainer> second = new UnsignedFieldSpec<>(new PropertyAccessor(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.TimeFields$second$1
        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object obj) {
            return ((TimeFieldContainer) obj).getSecond();
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object obj, Object obj2) {
            ((TimeFieldContainer) obj).setSecond((Integer) obj2);
        }
    }), 0, 59, null, 0, null, 40, null);
    private static final GenericFieldSpec<TimeFieldContainer, DecimalFraction> fractionOfSecond = new GenericFieldSpec<>(new PropertyAccessor(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.TimeFields$fractionOfSecond$1
        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object obj) {
            return ((TimeFieldContainer) obj).getFractionOfSecond();
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object obj, Object obj2) {
            ((TimeFieldContainer) obj).setFractionOfSecond((DecimalFraction) obj2);
        }
    }), null, new DecimalFraction(0, 9), null, 10, null);
    private static final GenericFieldSpec<TimeFieldContainer, AmPmMarker> amPm = new GenericFieldSpec<>(new PropertyAccessor(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.TimeFields$amPm$1
        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object obj) {
            return ((TimeFieldContainer) obj).getAmPm();
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object obj, Object obj2) {
            ((TimeFieldContainer) obj).setAmPm((AmPmMarker) obj2);
        }
    }), null, null, null, 14, null);
    private static final UnsignedFieldSpec<TimeFieldContainer> hourOfAmPm = new UnsignedFieldSpec<>(new PropertyAccessor(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.TimeFields$hourOfAmPm$1
        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object obj) {
            return ((TimeFieldContainer) obj).getHourOfAmPm();
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
        public void set(Object obj, Object obj2) {
            ((TimeFieldContainer) obj).setHourOfAmPm((Integer) obj2);
        }
    }), 1, 12, null, null, null, 56, null);

    private TimeFields() {
    }

    public final UnsignedFieldSpec<TimeFieldContainer> getHour() {
        return hour;
    }

    public final UnsignedFieldSpec<TimeFieldContainer> getMinute() {
        return minute;
    }

    public final UnsignedFieldSpec<TimeFieldContainer> getSecond() {
        return second;
    }

    public final GenericFieldSpec<TimeFieldContainer, DecimalFraction> getFractionOfSecond() {
        return fractionOfSecond;
    }

    public final GenericFieldSpec<TimeFieldContainer, AmPmMarker> getAmPm() {
        return amPm;
    }

    public final UnsignedFieldSpec<TimeFieldContainer> getHourOfAmPm() {
        return hourOfAmPm;
    }
}
