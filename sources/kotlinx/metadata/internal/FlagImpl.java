package kotlinx.metadata.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.metadata.deserialization.Flags;
/* compiled from: FlagImpl.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001d\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0086\u0002J\u0016\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0080\u0002¢\u0006\u0002\b\u0014R\u0014\u0010\n\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\t\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0015"}, d2 = {"Lkotlinx/metadata/internal/FlagImpl;", "", "field", "Lkotlinx/metadata/internal/metadata/deserialization/Flags$FlagField;", "value", "", "(Lorg/jetbrains/kotlin/metadata/deserialization/Flags$FlagField;I)V", "Lkotlinx/metadata/internal/metadata/deserialization/Flags$BooleanFlagField;", "(Lorg/jetbrains/kotlin/metadata/deserialization/Flags$BooleanFlagField;)V", TypedValues.CycleType.S_WAVE_OFFSET, "bitWidth", "(III)V", "getBitWidth$kotlinx_metadata", "()I", "getOffset$kotlinx_metadata", "getValue$kotlinx_metadata", "invoke", "", DownloaderServiceMarshaller.PARAMS_FLAGS, "plus", "plus$kotlinx_metadata", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlagImpl {
    private final int bitWidth;
    private final int offset;
    private final int value;

    public FlagImpl(int i, int i2, int i3) {
        this.offset = i;
        this.bitWidth = i2;
        this.value = i3;
    }

    public final int getBitWidth$kotlinx_metadata() {
        return this.bitWidth;
    }

    public final int getOffset$kotlinx_metadata() {
        return this.offset;
    }

    public final int getValue$kotlinx_metadata() {
        return this.value;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlagImpl(Flags.FlagField<?> field, int i) {
        this(field.offset, field.bitWidth, i);
        Intrinsics.checkNotNullParameter(field, "field");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlagImpl(Flags.BooleanFlagField field) {
        this(field, 1);
        Intrinsics.checkNotNullParameter(field, "field");
    }

    public final int plus$kotlinx_metadata(int i) {
        int i2 = this.offset;
        return (i & (~(((1 << this.bitWidth) - 1) << i2))) + (this.value << i2);
    }

    public final boolean invoke(int i) {
        return ((i >>> this.offset) & ((1 << this.bitWidth) - 1)) == this.value;
    }
}
