package kotlinx.datetime;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Ser.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/datetime/Ser;", "Ljava/io/Externalizable;", "typeTag", "", "value", "", "<init>", "(ILjava/lang/Object;)V", "()V", "writeExternal", "", "out", "Ljava/io/ObjectOutput;", "readExternal", "in", "Ljava/io/ObjectInput;", "readResolve", "Companion", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Ser implements Externalizable {
    public static final Companion Companion = new Companion(null);
    public static final int DATE_TAG = 2;
    public static final int DATE_TIME_TAG = 4;
    public static final int TIME_TAG = 3;
    public static final int UTC_OFFSET_TAG = 10;
    public static final int YEAR_MONTH_TAG = 11;
    private static final long serialVersionUID = 0;
    private int typeTag;
    private Object value;

    public Ser(int i, Object obj) {
        this.typeTag = i;
        this.value = obj;
    }

    public Ser() {
        this(0, null);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput out) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeByte(this.typeTag);
        Object obj = this.value;
        int i = this.typeTag;
        if (i == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.datetime.LocalDate");
            out.writeLong(((LocalDate) obj).getValue$kotlinx_datetime().toEpochDay());
        } else if (i == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.datetime.LocalTime");
            out.writeLong(((LocalTime) obj).toNanosecondOfDay());
        } else if (i == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.datetime.LocalDateTime");
            LocalDateTime localDateTime = (LocalDateTime) obj;
            out.writeLong(localDateTime.getDate().getValue$kotlinx_datetime().toEpochDay());
            out.writeLong(localDateTime.getTime().toNanosecondOfDay());
        } else if (i == 10) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.datetime.UtcOffset");
            out.writeInt(((UtcOffset) obj).getTotalSeconds());
        } else if (i == 11) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.datetime.YearMonth");
            out.writeLong(YearMonthJvmKt.toEpochMonths((YearMonth) obj));
        } else {
            throw new IllegalStateException("Unknown type tag: " + this.typeTag + " for value: " + obj);
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput in) {
        LocalDate localDate;
        Intrinsics.checkNotNullParameter(in, "in");
        byte readByte = in.readByte();
        this.typeTag = readByte;
        if (readByte == 2) {
            java.time.LocalDate ofEpochDay = java.time.LocalDate.ofEpochDay(in.readLong());
            Intrinsics.checkNotNullExpressionValue(ofEpochDay, "ofEpochDay(...)");
            localDate = new LocalDate(ofEpochDay);
        } else if (readByte == 3) {
            localDate = LocalTime.Companion.fromNanosecondOfDay(in.readLong());
        } else if (readByte == 4) {
            java.time.LocalDate ofEpochDay2 = java.time.LocalDate.ofEpochDay(in.readLong());
            Intrinsics.checkNotNullExpressionValue(ofEpochDay2, "ofEpochDay(...)");
            localDate = new LocalDateTime(new LocalDate(ofEpochDay2), LocalTime.Companion.fromNanosecondOfDay(in.readLong()));
        } else if (readByte == 10) {
            localDate = UtcOffsetJvmKt.UtcOffset$default(null, null, Integer.valueOf(in.readInt()), 3, null);
        } else if (readByte == 11) {
            localDate = YearMonthJvmKt.fromEpochMonths(YearMonth.Companion, in.readLong());
        } else {
            throw new IOException("Unknown type tag: " + this.typeTag);
        }
        this.value = localDate;
    }

    private final Object readResolve() {
        Object obj = this.value;
        Intrinsics.checkNotNull(obj);
        return obj;
    }

    /* compiled from: Ser.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/datetime/Ser$Companion;", "", "<init>", "()V", "serialVersionUID", "", "DATE_TAG", "", "TIME_TAG", "DATE_TIME_TAG", "UTC_OFFSET_TAG", "YEAR_MONTH_TAG", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
