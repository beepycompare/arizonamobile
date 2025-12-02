package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Composers.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\fH\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/serialization/json/internal/ComposerForUnsignedNumbers;", "Lkotlinx/serialization/json/internal/Composer;", "writer", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "forceQuoting", "", "<init>", "(Lkotlinx/serialization/json/internal/InternalJsonWriter;Z)V", "print", "", "v", "", "", "", "", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposerForUnsignedNumbers extends Composer {
    private final boolean forceQuoting;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerForUnsignedNumbers(InternalJsonWriter writer, boolean z) {
        super(writer);
        Intrinsics.checkNotNullParameter(writer, "writer");
        this.forceQuoting = z;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(int i) {
        String m9974m;
        String m9974m2;
        boolean z = this.forceQuoting;
        int m10004constructorimpl = UInt.m10004constructorimpl(i);
        if (z) {
            m9974m2 = UByte$$ExternalSyntheticBackport0.m9974m(m10004constructorimpl, 10);
            printQuoted(m9974m2);
            return;
        }
        m9974m = UByte$$ExternalSyntheticBackport0.m9974m(m10004constructorimpl, 10);
        print(m9974m);
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(long j) {
        String m;
        String m2;
        boolean z = this.forceQuoting;
        long m10083constructorimpl = ULong.m10083constructorimpl(j);
        if (z) {
            m2 = UByte$$ExternalSyntheticBackport0.m(m10083constructorimpl, 10);
            printQuoted(m2);
            return;
        }
        m = UByte$$ExternalSyntheticBackport0.m(m10083constructorimpl, 10);
        print(m);
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(byte b) {
        boolean z = this.forceQuoting;
        String m9966toStringimpl = UByte.m9966toStringimpl(UByte.m9922constructorimpl(b));
        if (z) {
            printQuoted(m9966toStringimpl);
        } else {
            print(m9966toStringimpl);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(short s) {
        boolean z = this.forceQuoting;
        String m10234toStringimpl = UShort.m10234toStringimpl(UShort.m10190constructorimpl(s));
        if (z) {
            printQuoted(m10234toStringimpl);
        } else {
            print(m10234toStringimpl);
        }
    }
}
