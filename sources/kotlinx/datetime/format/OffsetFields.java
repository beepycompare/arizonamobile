package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlinx.datetime.internal.format.Accessor;
import kotlinx.datetime.internal.format.FieldSign;
import kotlinx.datetime.internal.format.PropertyAccessor;
import kotlinx.datetime.internal.format.UnsignedFieldSpec;
/* compiled from: UtcOffsetFormat.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005*\u0001\u000b\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/OffsetFields;", "", "()V", "minutesOfHour", "Lkotlinx/datetime/internal/format/UnsignedFieldSpec;", "Lkotlinx/datetime/format/UtcOffsetFieldContainer;", "getMinutesOfHour", "()Lkotlinx/datetime/internal/format/UnsignedFieldSpec;", "secondsOfMinute", "getSecondsOfMinute", "sign", "kotlinx/datetime/format/OffsetFields$sign$1", "Lkotlinx/datetime/format/OffsetFields$sign$1;", "totalHoursAbs", "getTotalHoursAbs", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
final class OffsetFields {
    public static final OffsetFields INSTANCE = new OffsetFields();
    private static final UnsignedFieldSpec<UtcOffsetFieldContainer> minutesOfHour;
    private static final UnsignedFieldSpec<UtcOffsetFieldContainer> secondsOfMinute;
    private static final OffsetFields$sign$1 sign;
    private static final UnsignedFieldSpec<UtcOffsetFieldContainer> totalHoursAbs;

    private OffsetFields() {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.datetime.format.OffsetFields$sign$1] */
    static {
        ?? r0 = new FieldSign<UtcOffsetFieldContainer>() { // from class: kotlinx.datetime.format.OffsetFields$sign$1
            private final PropertyAccessor<UtcOffsetFieldContainer, Boolean> isNegative = new PropertyAccessor<>(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.OffsetFields$sign$1$isNegative$1
                @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((UtcOffsetFieldContainer) obj).isNegative();
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
                public void set(Object obj, Object obj2) {
                    ((UtcOffsetFieldContainer) obj).setNegative((Boolean) obj2);
                }
            });

            @Override // kotlinx.datetime.internal.format.FieldSign
            public Accessor<UtcOffsetFieldContainer, Boolean> isNegative() {
                return this.isNegative;
            }

            @Override // kotlinx.datetime.internal.format.FieldSign
            public boolean isZero(UtcOffsetFieldContainer obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                Integer totalHoursAbs2 = obj.getTotalHoursAbs();
                if ((totalHoursAbs2 != null ? totalHoursAbs2.intValue() : 0) == 0) {
                    Integer minutesOfHour2 = obj.getMinutesOfHour();
                    if ((minutesOfHour2 != null ? minutesOfHour2.intValue() : 0) == 0) {
                        Integer secondsOfMinute2 = obj.getSecondsOfMinute();
                        if ((secondsOfMinute2 != null ? secondsOfMinute2.intValue() : 0) == 0) {
                            return true;
                        }
                    }
                }
                return false;
            }
        };
        sign = r0;
        totalHoursAbs = new UnsignedFieldSpec<>(new PropertyAccessor(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.OffsetFields$totalHoursAbs$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((UtcOffsetFieldContainer) obj).getTotalHoursAbs();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((UtcOffsetFieldContainer) obj).setTotalHoursAbs((Integer) obj2);
            }
        }), 0, 18, null, 0, (FieldSign) r0, 8, null);
        minutesOfHour = new UnsignedFieldSpec<>(new PropertyAccessor(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.OffsetFields$minutesOfHour$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((UtcOffsetFieldContainer) obj).getMinutesOfHour();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((UtcOffsetFieldContainer) obj).setMinutesOfHour((Integer) obj2);
            }
        }), 0, 59, null, 0, (FieldSign) r0, 8, null);
        secondsOfMinute = new UnsignedFieldSpec<>(new PropertyAccessor(new MutablePropertyReference1Impl() { // from class: kotlinx.datetime.format.OffsetFields$secondsOfMinute$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((UtcOffsetFieldContainer) obj).getSecondsOfMinute();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
            public void set(Object obj, Object obj2) {
                ((UtcOffsetFieldContainer) obj).setSecondsOfMinute((Integer) obj2);
            }
        }), 0, 59, null, 0, (FieldSign) r0, 8, null);
    }

    public final UnsignedFieldSpec<UtcOffsetFieldContainer> getTotalHoursAbs() {
        return totalHoursAbs;
    }

    public final UnsignedFieldSpec<UtcOffsetFieldContainer> getMinutesOfHour() {
        return minutesOfHour;
    }

    public final UnsignedFieldSpec<UtcOffsetFieldContainer> getSecondsOfMinute() {
        return secondsOfMinute;
    }
}
