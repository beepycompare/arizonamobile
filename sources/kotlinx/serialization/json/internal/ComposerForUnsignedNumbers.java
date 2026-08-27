package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Composers.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004J\u0012\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\fH\u0096\u0080\u0004J\u0012\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0096\u0080\u0004J\u0012\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000eH\u0096\u0080\u0004R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/serialization/json/internal/ComposerForUnsignedNumbers;", "Lkotlinx/serialization/json/internal/Composer;", "writer", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "forceQuoting", "", "<init>", "(Lkotlinx/serialization/json/internal/InternalJsonWriter;Z)V", "print", "", "v", "", "", "", "", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
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
        String m9989m;
        String m9989m2;
        boolean z = this.forceQuoting;
        int m10020constructorimpl = UInt.m10020constructorimpl(i);
        if (z) {
            m9989m2 = UByte$$ExternalSyntheticBackport0.m9989m(m10020constructorimpl, 10);
            printQuoted(m9989m2);
            return;
        }
        m9989m = UByte$$ExternalSyntheticBackport0.m9989m(m10020constructorimpl, 10);
        print(m9989m);
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(long j) {
        String m;
        String m2;
        boolean z = this.forceQuoting;
        long m10099constructorimpl = ULong.m10099constructorimpl(j);
        if (z) {
            m2 = UByte$$ExternalSyntheticBackport0.m(m10099constructorimpl, 10);
            printQuoted(m2);
            return;
        }
        m = UByte$$ExternalSyntheticBackport0.m(m10099constructorimpl, 10);
        print(m);
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(byte b) {
        boolean z = this.forceQuoting;
        String m9981toStringimpl = UByte.m9981toStringimpl(UByte.m9937constructorimpl(b));
        if (z) {
            printQuoted(m9981toStringimpl);
        } else {
            print(m9981toStringimpl);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(short s) {
        boolean z = this.forceQuoting;
        String m10250toStringimpl = UShort.m10250toStringimpl(UShort.m10206constructorimpl(s));
        if (z) {
            printQuoted(m10250toStringimpl);
        } else {
            print(m10250toStringimpl);
        }
    }
}
