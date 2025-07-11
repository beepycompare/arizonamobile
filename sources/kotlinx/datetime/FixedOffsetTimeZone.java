package kotlinx.datetime;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.time.ZoneId;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.serializers.FixedOffsetTimeZoneSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
/* compiled from: TimeZoneJvm.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lkotlinx/datetime/FixedOffsetTimeZone;", "Lkotlinx/datetime/TimeZone;", TypedValues.CycleType.S_WAVE_OFFSET, "Lkotlinx/datetime/UtcOffset;", "zoneId", "Ljava/time/ZoneId;", "<init>", "(Lkotlinx/datetime/UtcOffset;Ljava/time/ZoneId;)V", "(Lkotlinx/datetime/UtcOffset;)V", "getOffset", "()Lkotlinx/datetime/UtcOffset;", "totalSeconds", "", "getTotalSeconds$annotations", "()V", "getTotalSeconds", "()I", "Companion", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = FixedOffsetTimeZoneSerializer.class)
/* loaded from: classes5.dex */
public final class FixedOffsetTimeZone extends TimeZone {
    public static final Companion Companion = new Companion(null);
    private final UtcOffset offset;

    @Deprecated(message = "Use offset.totalSeconds", replaceWith = @ReplaceWith(expression = "offset.totalSeconds", imports = {}))
    public static /* synthetic */ void getTotalSeconds$annotations() {
    }

    /* compiled from: TimeZoneJvm.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkotlinx/datetime/FixedOffsetTimeZone$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/datetime/FixedOffsetTimeZone;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<FixedOffsetTimeZone> serializer() {
            return FixedOffsetTimeZoneSerializer.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedOffsetTimeZone(UtcOffset offset, ZoneId zoneId) {
        super(zoneId);
        Intrinsics.checkNotNullParameter(offset, "offset");
        Intrinsics.checkNotNullParameter(zoneId, "zoneId");
        this.offset = offset;
    }

    public final UtcOffset getOffset() {
        return this.offset;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FixedOffsetTimeZone(UtcOffset offset) {
        this(offset, offset.getZoneOffset$kotlinx_datetime());
        Intrinsics.checkNotNullParameter(offset, "offset");
    }

    public final int getTotalSeconds() {
        return this.offset.getTotalSeconds();
    }
}
