package kotlin.sequences;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: _USequences.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0000\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\b0\u0002H\u0007¢\u0006\u0004\b\t\u0010\u0004\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\u0004¨\u0006\f"}, d2 = {"sum", "Lkotlin/UInt;", "Lkotlin/sequences/Sequence;", "sumOfUInt", "(Lkotlin/sequences/Sequence;)I", "Lkotlin/ULong;", "sumOfULong", "(Lkotlin/sequences/Sequence;)J", "Lkotlin/UByte;", "sumOfUByte", "Lkotlin/UShort;", "sumOfUShort", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX, xs = "kotlin/sequences/USequencesKt")
/* loaded from: classes5.dex */
class USequencesKt___USequencesKt {
    public static final int sumOfUInt(Sequence<UInt> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        int i = 0;
        for (UInt uInt : sequence) {
            i = UInt.m8571constructorimpl(i + uInt.m8623unboximpl());
        }
        return i;
    }

    public static final long sumOfULong(Sequence<ULong> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        long j = 0;
        for (ULong uLong : sequence) {
            j = ULong.m8650constructorimpl(j + uLong.m8702unboximpl());
        }
        return j;
    }

    public static final int sumOfUByte(Sequence<UByte> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        int i = 0;
        for (UByte uByte : sequence) {
            i = UInt.m8571constructorimpl(i + UInt.m8571constructorimpl(uByte.m8539unboximpl() & 255));
        }
        return i;
    }

    public static final int sumOfUShort(Sequence<UShort> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        int i = 0;
        for (UShort uShort : sequence) {
            i = UInt.m8571constructorimpl(i + UInt.m8571constructorimpl(uShort.m8807unboximpl() & UShort.MAX_VALUE));
        }
        return i;
    }
}
