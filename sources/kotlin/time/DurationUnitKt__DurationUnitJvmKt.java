package kotlin.time;

import com.facebook.internal.NativeProtocol;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DurationUnitJvm.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a\u001c\u0010\u0006\u001a\u00020\u0002*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a0\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0081\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\f\u001a0\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0081\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f\u001a0\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0081\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u000f¨\u0006\u0010"}, d2 = {"toTimeUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.8", "toDurationUnit", "convertDurationUnit", "", "value", "sourceUnit", "targetUnit", "1.3", "convertDurationUnitOverflow", "", "1.5", "kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "kotlin/time/DurationUnitKt")
/* loaded from: classes5.dex */
public class DurationUnitKt__DurationUnitJvmKt {

    /* compiled from: DurationUnitJvm.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final TimeUnit toTimeUnit(DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(durationUnit, "<this>");
        return durationUnit.getTimeUnit$kotlin_stdlib();
    }

    public static final DurationUnit toDurationUnit(TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[timeUnit.ordinal()]) {
            case 1:
                return DurationUnit.NANOSECONDS;
            case 2:
                return DurationUnit.MICROSECONDS;
            case 3:
                return DurationUnit.MILLISECONDS;
            case 4:
                return DurationUnit.SECONDS;
            case 5:
                return DurationUnit.MINUTES;
            case 6:
                return DurationUnit.HOURS;
            case 7:
                return DurationUnit.DAYS;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final double convertDurationUnit(double d, DurationUnit sourceUnit, DurationUnit targetUnit) {
        Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
        Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
        long convert = targetUnit.getTimeUnit$kotlin_stdlib().convert(1L, sourceUnit.getTimeUnit$kotlin_stdlib());
        return convert > 0 ? d * convert : d / sourceUnit.getTimeUnit$kotlin_stdlib().convert(1L, targetUnit.getTimeUnit$kotlin_stdlib());
    }

    public static final long convertDurationUnitOverflow(long j, DurationUnit sourceUnit, DurationUnit targetUnit) {
        Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
        Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit$kotlin_stdlib().convert(j, sourceUnit.getTimeUnit$kotlin_stdlib());
    }

    public static final long convertDurationUnit(long j, DurationUnit sourceUnit, DurationUnit targetUnit) {
        Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
        Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit$kotlin_stdlib().convert(j, sourceUnit.getTimeUnit$kotlin_stdlib());
    }
}
