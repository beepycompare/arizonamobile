package kotlin.internal;

import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.UInt;
import kotlin.ULong;
/* compiled from: UProgressionUtil.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u000f\u0010\u0006\u001a'\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"differenceModulo", "Lkotlin/UInt;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", TtmlNode.START, TtmlNode.END, "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UProgressionUtilKt {
    /* renamed from: differenceModulo-WZ9TVnA  reason: not valid java name */
    private static final int m9657differenceModuloWZ9TVnA(int i, int i2, int i3) {
        int compare;
        int m$1 = UByte$$ExternalSyntheticBackport0.m$1(i, i3);
        int m$12 = UByte$$ExternalSyntheticBackport0.m$1(i2, i3);
        compare = Integer.compare(m$1 ^ Integer.MIN_VALUE, m$12 ^ Integer.MIN_VALUE);
        int m8540constructorimpl = UInt.m8540constructorimpl(m$1 - m$12);
        return compare >= 0 ? m8540constructorimpl : UInt.m8540constructorimpl(m8540constructorimpl + i3);
    }

    /* renamed from: differenceModulo-sambcqE  reason: not valid java name */
    private static final long m9658differenceModulosambcqE(long j, long j2, long j3) {
        int compare;
        long m8512m = UByte$$ExternalSyntheticBackport0.m8512m(j, j3);
        long m8512m2 = UByte$$ExternalSyntheticBackport0.m8512m(j2, j3);
        compare = Long.compare(m8512m ^ Long.MIN_VALUE, m8512m2 ^ Long.MIN_VALUE);
        long m8619constructorimpl = ULong.m8619constructorimpl(m8512m - m8512m2);
        return compare >= 0 ? m8619constructorimpl : ULong.m8619constructorimpl(m8619constructorimpl + j3);
    }

    /* renamed from: getProgressionLastElement-Nkh28Cs  reason: not valid java name */
    public static final int m9660getProgressionLastElementNkh28Cs(int i, int i2, int i3) {
        int compare;
        int compare2;
        if (i3 > 0) {
            compare2 = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
            if (compare2 < 0) {
                return UInt.m8540constructorimpl(i2 - m9657differenceModuloWZ9TVnA(i2, i, UInt.m8540constructorimpl(i3)));
            }
        } else if (i3 < 0) {
            compare = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
            if (compare > 0) {
                return UInt.m8540constructorimpl(i2 + m9657differenceModuloWZ9TVnA(i, i2, UInt.m8540constructorimpl(-i3)));
            }
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
        return i2;
    }

    /* renamed from: getProgressionLastElement-7ftBX0g  reason: not valid java name */
    public static final long m9659getProgressionLastElement7ftBX0g(long j, long j2, long j3) {
        int compare;
        int compare2;
        int i = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
        if (i > 0) {
            compare2 = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
            return compare2 >= 0 ? j2 : ULong.m8619constructorimpl(j2 - m9658differenceModulosambcqE(j2, j, ULong.m8619constructorimpl(j3)));
        } else if (i < 0) {
            compare = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
            return compare <= 0 ? j2 : ULong.m8619constructorimpl(j2 + m9658differenceModulosambcqE(j, j2, ULong.m8619constructorimpl(-j3)));
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }
}
