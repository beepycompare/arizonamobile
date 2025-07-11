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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aJ\u0013\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\u0000H\u0016J\b\u0010#\u001a\u00020$H\u0016R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013¨\u0006%"}, d2 = {"Lkotlinx/datetime/format/IncompleteUtcOffset;", "Lkotlinx/datetime/format/UtcOffsetFieldContainer;", "Lkotlinx/datetime/internal/format/parser/Copyable;", "offsetIsNegative", "", "offsetHours", "", "offsetMinutesOfHour", "offsetSecondsOfMinute", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getOffsetIsNegative", "()Ljava/lang/Boolean;", "setOffsetIsNegative", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getOffsetHours", "()Ljava/lang/Integer;", "setOffsetHours", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getOffsetMinutesOfHour", "setOffsetMinutesOfHour", "getOffsetSecondsOfMinute", "setOffsetSecondsOfMinute", "toUtcOffset", "Lkotlinx/datetime/UtcOffset;", "populateFrom", "", TypedValues.CycleType.S_WAVE_OFFSET, "equals", "other", "", "hashCode", "copy", "toString", "", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IncompleteUtcOffset implements UtcOffsetFieldContainer, Copyable<IncompleteUtcOffset> {
    private Integer offsetHours;
    private Boolean offsetIsNegative;
    private Integer offsetMinutesOfHour;
    private Integer offsetSecondsOfMinute;

    public IncompleteUtcOffset() {
        this(null, null, null, null, 15, null);
    }

    public IncompleteUtcOffset(Boolean bool, Integer num, Integer num2, Integer num3) {
        this.offsetIsNegative = bool;
        this.offsetHours = num;
        this.offsetMinutesOfHour = num2;
        this.offsetSecondsOfMinute = num3;
    }

    public /* synthetic */ IncompleteUtcOffset(Boolean bool, Integer num, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3);
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public Boolean getOffsetIsNegative() {
        return this.offsetIsNegative;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public void setOffsetIsNegative(Boolean bool) {
        this.offsetIsNegative = bool;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public Integer getOffsetHours() {
        return this.offsetHours;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public void setOffsetHours(Integer num) {
        this.offsetHours = num;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public Integer getOffsetMinutesOfHour() {
        return this.offsetMinutesOfHour;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public void setOffsetMinutesOfHour(Integer num) {
        this.offsetMinutesOfHour = num;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public Integer getOffsetSecondsOfMinute() {
        return this.offsetSecondsOfMinute;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public void setOffsetSecondsOfMinute(Integer num) {
        this.offsetSecondsOfMinute = num;
    }

    public final UtcOffset toUtcOffset() {
        int i = Intrinsics.areEqual((Object) getOffsetIsNegative(), (Object) true) ? -1 : 1;
        Integer offsetHours = getOffsetHours();
        Integer valueOf = offsetHours != null ? Integer.valueOf(offsetHours.intValue() * i) : null;
        Integer offsetMinutesOfHour = getOffsetMinutesOfHour();
        Integer valueOf2 = offsetMinutesOfHour != null ? Integer.valueOf(offsetMinutesOfHour.intValue() * i) : null;
        Integer offsetSecondsOfMinute = getOffsetSecondsOfMinute();
        return UtcOffsetJvmKt.UtcOffset(valueOf, valueOf2, offsetSecondsOfMinute != null ? Integer.valueOf(offsetSecondsOfMinute.intValue() * i) : null);
    }

    public final void populateFrom(UtcOffset offset) {
        Intrinsics.checkNotNullParameter(offset, "offset");
        setOffsetIsNegative(Boolean.valueOf(offset.getTotalSeconds() < 0));
        int abs = Math.abs(offset.getTotalSeconds());
        setOffsetHours(Integer.valueOf(abs / DateCalculationsKt.SECONDS_PER_HOUR));
        setOffsetMinutesOfHour(Integer.valueOf((abs / 60) % 60));
        setOffsetSecondsOfMinute(Integer.valueOf(abs % 60));
    }

    public boolean equals(Object obj) {
        if (obj instanceof IncompleteUtcOffset) {
            IncompleteUtcOffset incompleteUtcOffset = (IncompleteUtcOffset) obj;
            return Intrinsics.areEqual(getOffsetIsNegative(), incompleteUtcOffset.getOffsetIsNegative()) && Intrinsics.areEqual(getOffsetHours(), incompleteUtcOffset.getOffsetHours()) && Intrinsics.areEqual(getOffsetMinutesOfHour(), incompleteUtcOffset.getOffsetMinutesOfHour()) && Intrinsics.areEqual(getOffsetSecondsOfMinute(), incompleteUtcOffset.getOffsetSecondsOfMinute());
        }
        return false;
    }

    public int hashCode() {
        Boolean offsetIsNegative = getOffsetIsNegative();
        int hashCode = offsetIsNegative != null ? offsetIsNegative.hashCode() : 0;
        Integer offsetHours = getOffsetHours();
        int hashCode2 = hashCode + (offsetHours != null ? offsetHours.hashCode() : 0);
        Integer offsetMinutesOfHour = getOffsetMinutesOfHour();
        int hashCode3 = hashCode2 + (offsetMinutesOfHour != null ? offsetMinutesOfHour.hashCode() : 0);
        Integer offsetSecondsOfMinute = getOffsetSecondsOfMinute();
        return hashCode3 + (offsetSecondsOfMinute != null ? offsetSecondsOfMinute.hashCode() : 0);
    }

    @Override // kotlinx.datetime.internal.format.parser.Copyable
    public IncompleteUtcOffset copy() {
        return new IncompleteUtcOffset(getOffsetIsNegative(), getOffsetHours(), getOffsetMinutesOfHour(), getOffsetSecondsOfMinute());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Boolean offsetIsNegative = getOffsetIsNegative();
        StringBuilder append = sb.append(offsetIsNegative != null ? offsetIsNegative.booleanValue() ? Constants.FILENAME_SEQUENCE_SEPARATOR : "+" : " ");
        Integer offsetHours = getOffsetHours();
        if (offsetHours == null) {
            offsetHours = "??";
        }
        StringBuilder append2 = append.append(offsetHours).append(AbstractJsonLexerKt.COLON);
        Integer offsetMinutesOfHour = getOffsetMinutesOfHour();
        if (offsetMinutesOfHour == null) {
            offsetMinutesOfHour = "??";
        }
        StringBuilder append3 = append2.append(offsetMinutesOfHour).append(AbstractJsonLexerKt.COLON);
        Integer offsetSecondsOfMinute = getOffsetSecondsOfMinute();
        return append3.append(offsetSecondsOfMinute != null ? offsetSecondsOfMinute : "??").toString();
    }
}
