package okhttp3.internal.idn;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
/* compiled from: IdnaMappingTable.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J \u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/idn/IdnaMappingTable;", "", "sections", "", "ranges", "mappings", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSections", "()Ljava/lang/String;", "getRanges", "getMappings", "map", "", "codePoint", "", "sink", "Lokio/BufferedSink;", "findSectionsIndex", "findRangesOffset", "position", "limit", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IdnaMappingTable {
    private final String mappings;
    private final String ranges;
    private final String sections;

    public IdnaMappingTable(String sections, String ranges, String mappings) {
        Intrinsics.checkNotNullParameter(sections, "sections");
        Intrinsics.checkNotNullParameter(ranges, "ranges");
        Intrinsics.checkNotNullParameter(mappings, "mappings");
        this.sections = sections;
        this.ranges = ranges;
        this.mappings = mappings;
    }

    public final String getSections() {
        return this.sections;
    }

    public final String getRanges() {
        return this.ranges;
    }

    public final String getMappings() {
        return this.mappings;
    }

    public final boolean map(int i, BufferedSink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        int findSectionsIndex = findSectionsIndex(i);
        int findRangesOffset = findRangesOffset(i, IdnaMappingTableKt.read14BitInt(this.sections, findSectionsIndex + 2), findSectionsIndex + 4 < this.sections.length() ? IdnaMappingTableKt.read14BitInt(this.sections, findSectionsIndex + 6) : this.ranges.length() / 4);
        char charAt = this.ranges.charAt(findRangesOffset + 1);
        if (charAt >= 0 && charAt < '@') {
            int read14BitInt = IdnaMappingTableKt.read14BitInt(this.ranges, findRangesOffset + 2);
            sink.writeUtf8(this.mappings, read14BitInt, charAt + read14BitInt);
            return true;
        } else if ('@' <= charAt && charAt < 'P') {
            sink.writeUtf8CodePoint(i - (this.ranges.charAt(findRangesOffset + 3) | (((charAt & 15) << 14) | (this.ranges.charAt(findRangesOffset + 2) << 7))));
            return true;
        } else if ('P' <= charAt && charAt < '`') {
            sink.writeUtf8CodePoint(i + (this.ranges.charAt(findRangesOffset + 3) | ((charAt & 15) << 14) | (this.ranges.charAt(findRangesOffset + 2) << 7)));
            return true;
        } else if (charAt == 'w') {
            Unit unit = Unit.INSTANCE;
            return true;
        } else if (charAt == 'x') {
            sink.writeUtf8CodePoint(i);
            return true;
        } else if (charAt == 'y') {
            sink.writeUtf8CodePoint(i);
            return false;
        } else if (charAt == 'z') {
            sink.writeByte(this.ranges.charAt(findRangesOffset + 2));
            return true;
        } else if (charAt == '{') {
            sink.writeByte(this.ranges.charAt(findRangesOffset + 2) | 128);
            return true;
        } else if (charAt == '|') {
            sink.writeByte(this.ranges.charAt(findRangesOffset + 2));
            sink.writeByte(this.ranges.charAt(findRangesOffset + 3));
            return true;
        } else if (charAt == '}') {
            sink.writeByte(this.ranges.charAt(findRangesOffset + 2) | 128);
            sink.writeByte(this.ranges.charAt(findRangesOffset + 3));
            return true;
        } else if (charAt == '~') {
            sink.writeByte(this.ranges.charAt(findRangesOffset + 2));
            sink.writeByte(this.ranges.charAt(findRangesOffset + 3) | 128);
            return true;
        } else if (charAt == 127) {
            sink.writeByte(this.ranges.charAt(findRangesOffset + 2) | 128);
            sink.writeByte(this.ranges.charAt(findRangesOffset + 3) | 128);
            return true;
        } else {
            throw new IllegalStateException(("unexpected rangesIndex for " + i).toString());
        }
    }

    private final int findSectionsIndex(int i) {
        int i2;
        int i3 = (i & 2097024) >> 7;
        int length = (this.sections.length() / 4) - 1;
        int i4 = 0;
        while (true) {
            if (i4 > length) {
                i2 = (-i4) - 1;
                break;
            }
            i2 = (i4 + length) / 2;
            int compare = Intrinsics.compare(i3, IdnaMappingTableKt.read14BitInt(this.sections, i2 * 4));
            if (compare >= 0) {
                if (compare <= 0) {
                    break;
                }
                i4 = i2 + 1;
            } else {
                length = i2 - 1;
            }
        }
        return i2 >= 0 ? i2 * 4 : ((-i2) - 2) * 4;
    }

    private final int findRangesOffset(int i, int i2, int i3) {
        int i4;
        int i5 = i & 127;
        int i6 = i3 - 1;
        while (true) {
            if (i2 > i6) {
                i4 = (-i2) - 1;
                break;
            }
            i4 = (i2 + i6) / 2;
            int compare = Intrinsics.compare(i5, (int) this.ranges.charAt(i4 * 4));
            if (compare >= 0) {
                if (compare <= 0) {
                    break;
                }
                i2 = i4 + 1;
            } else {
                i6 = i4 - 1;
            }
        }
        return i4 >= 0 ? i4 * 4 : ((-i4) - 2) * 4;
    }
}
