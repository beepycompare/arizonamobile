package kotlinx.datetime.format;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.vending.expansion.downloader.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.UtcOffset;
import kotlinx.datetime.UtcOffsetJvmKt;
import kotlinx.datetime.internal.DateCalculationsKt;
import kotlinx.datetime.internal.format.parser.Copyable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: UtcOffsetFormat.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\b\u0010\u0017\u001a\u00020\u0000H\u0016J\u0013\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020!H\u0016J\u0006\u0010\"\u001a\u00020\u001fR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0003\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011¨\u0006#"}, d2 = {"Lkotlinx/datetime/format/IncompleteUtcOffset;", "Lkotlinx/datetime/format/UtcOffsetFieldContainer;", "Lkotlinx/datetime/internal/format/parser/Copyable;", "isNegative", "", "totalHoursAbs", "", "minutesOfHour", "secondsOfMinute", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "()Ljava/lang/Boolean;", "setNegative", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMinutesOfHour", "()Ljava/lang/Integer;", "setMinutesOfHour", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSecondsOfMinute", "setSecondsOfMinute", "getTotalHoursAbs", "setTotalHoursAbs", "copy", "equals", "other", "", "hashCode", "populateFrom", "", TypedValues.CycleType.S_WAVE_OFFSET, "Lkotlinx/datetime/UtcOffset;", "toString", "", "toUtcOffset", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IncompleteUtcOffset implements UtcOffsetFieldContainer, Copyable<IncompleteUtcOffset> {
    private Boolean isNegative;
    private Integer minutesOfHour;
    private Integer secondsOfMinute;
    private Integer totalHoursAbs;

    public IncompleteUtcOffset() {
        this(null, null, null, null, 15, null);
    }

    public IncompleteUtcOffset(Boolean bool, Integer num, Integer num2, Integer num3) {
        this.isNegative = bool;
        this.totalHoursAbs = num;
        this.minutesOfHour = num2;
        this.secondsOfMinute = num3;
    }

    public /* synthetic */ IncompleteUtcOffset(Boolean bool, Integer num, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3);
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public Boolean isNegative() {
        return this.isNegative;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public void setNegative(Boolean bool) {
        this.isNegative = bool;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public Integer getTotalHoursAbs() {
        return this.totalHoursAbs;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public void setTotalHoursAbs(Integer num) {
        this.totalHoursAbs = num;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public Integer getMinutesOfHour() {
        return this.minutesOfHour;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public void setMinutesOfHour(Integer num) {
        this.minutesOfHour = num;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public Integer getSecondsOfMinute() {
        return this.secondsOfMinute;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public void setSecondsOfMinute(Integer num) {
        this.secondsOfMinute = num;
    }

    public final UtcOffset toUtcOffset() {
        int i = Intrinsics.areEqual((Object) isNegative(), (Object) true) ? -1 : 1;
        Integer totalHoursAbs = getTotalHoursAbs();
        Integer valueOf = totalHoursAbs != null ? Integer.valueOf(totalHoursAbs.intValue() * i) : null;
        Integer minutesOfHour = getMinutesOfHour();
        Integer valueOf2 = minutesOfHour != null ? Integer.valueOf(minutesOfHour.intValue() * i) : null;
        Integer secondsOfMinute = getSecondsOfMinute();
        return UtcOffsetJvmKt.UtcOffset(valueOf, valueOf2, secondsOfMinute != null ? Integer.valueOf(secondsOfMinute.intValue() * i) : null);
    }

    public final void populateFrom(UtcOffset offset) {
        Intrinsics.checkNotNullParameter(offset, "offset");
        setNegative(Boolean.valueOf(offset.getTotalSeconds() < 0));
        int abs = Math.abs(offset.getTotalSeconds());
        setTotalHoursAbs(Integer.valueOf(abs / DateCalculationsKt.SECONDS_PER_HOUR));
        setMinutesOfHour(Integer.valueOf((abs / 60) % 60));
        setSecondsOfMinute(Integer.valueOf(abs % 60));
    }

    public boolean equals(Object obj) {
        if (obj instanceof IncompleteUtcOffset) {
            IncompleteUtcOffset incompleteUtcOffset = (IncompleteUtcOffset) obj;
            return Intrinsics.areEqual(isNegative(), incompleteUtcOffset.isNegative()) && Intrinsics.areEqual(getTotalHoursAbs(), incompleteUtcOffset.getTotalHoursAbs()) && Intrinsics.areEqual(getMinutesOfHour(), incompleteUtcOffset.getMinutesOfHour()) && Intrinsics.areEqual(getSecondsOfMinute(), incompleteUtcOffset.getSecondsOfMinute());
        }
        return false;
    }

    public int hashCode() {
        Boolean isNegative = isNegative();
        int hashCode = isNegative != null ? isNegative.hashCode() : 0;
        Integer totalHoursAbs = getTotalHoursAbs();
        int hashCode2 = hashCode + (totalHoursAbs != null ? totalHoursAbs.hashCode() : 0);
        Integer minutesOfHour = getMinutesOfHour();
        int hashCode3 = hashCode2 + (minutesOfHour != null ? minutesOfHour.hashCode() : 0);
        Integer secondsOfMinute = getSecondsOfMinute();
        return hashCode3 + (secondsOfMinute != null ? secondsOfMinute.hashCode() : 0);
    }

    @Override // kotlinx.datetime.internal.format.parser.Copyable
    public IncompleteUtcOffset copy() {
        return new IncompleteUtcOffset(isNegative(), getTotalHoursAbs(), getMinutesOfHour(), getSecondsOfMinute());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Boolean isNegative = isNegative();
        StringBuilder append = sb.append(isNegative != null ? isNegative.booleanValue() ? Constants.FILENAME_SEQUENCE_SEPARATOR : "+" : " ");
        Integer totalHoursAbs = getTotalHoursAbs();
        if (totalHoursAbs == null) {
            totalHoursAbs = "??";
        }
        StringBuilder append2 = append.append(totalHoursAbs).append(AbstractJsonLexerKt.COLON);
        Integer minutesOfHour = getMinutesOfHour();
        if (minutesOfHour == null) {
            minutesOfHour = "??";
        }
        StringBuilder append3 = append2.append(minutesOfHour).append(AbstractJsonLexerKt.COLON);
        Integer secondsOfMinute = getSecondsOfMinute();
        return append3.append(secondsOfMinute != null ? secondsOfMinute : "??").toString();
    }
}
