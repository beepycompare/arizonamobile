package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlinx.datetime.internal.DecimalFraction;
/* compiled from: LocalDateTimeFormat.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003À\u0006\u0003"}, d2 = {"Lkotlinx/datetime/format/DateTimeFieldContainer;", "Lkotlinx/datetime/format/DateFieldContainer;", "Lkotlinx/datetime/format/TimeFieldContainer;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface DateTimeFieldContainer extends DateFieldContainer, TimeFieldContainer {

    /* compiled from: LocalDateTimeFormat.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static DecimalFraction getFractionOfSecond(DateTimeFieldContainer dateTimeFieldContainer) {
            return DateTimeFieldContainer.super.getFractionOfSecond();
        }

        @Deprecated
        public static void setFractionOfSecond(DateTimeFieldContainer dateTimeFieldContainer, DecimalFraction decimalFraction) {
            DateTimeFieldContainer.super.setFractionOfSecond(decimalFraction);
        }
    }
}
