package androidx.media3.extractor.metadata.scte35;

import androidx.media3.common.C;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public final boolean autoReturn;
    public final int availNum;
    public final int availsExpected;
    public final long breakDurationUs;
    public final List<ComponentSplice> componentSpliceList;
    public final boolean outOfNetworkIndicator;
    public final boolean programSpliceFlag;
    public final long programSplicePlaybackPositionUs;
    public final long programSplicePts;
    public final boolean spliceEventCancelIndicator;
    public final long spliceEventId;
    public final boolean spliceImmediateFlag;
    public final int uniqueProgramId;

    private SpliceInsertCommand(long j, boolean z, boolean z2, boolean z3, boolean z4, long j2, long j3, List<ComponentSplice> list, boolean z5, long j4, int i, int i2, int i3) {
        this.spliceEventId = j;
        this.spliceEventCancelIndicator = z;
        this.outOfNetworkIndicator = z2;
        this.programSpliceFlag = z3;
        this.spliceImmediateFlag = z4;
        this.programSplicePts = j2;
        this.programSplicePlaybackPositionUs = j3;
        this.componentSpliceList = Collections.unmodifiableList(list);
        this.autoReturn = z5;
        this.breakDurationUs = j4;
        this.uniqueProgramId = i;
        this.availNum = i2;
        this.availsExpected = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpliceInsertCommand parseFromSection(ParsableByteArray parsableByteArray, long j, TimestampAdjuster timestampAdjuster) {
        List list;
        long j2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        int i2;
        int i3;
        boolean z5;
        int i4;
        long j3;
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        boolean z6 = (parsableByteArray.readUnsignedByte() & 128) != 0;
        List emptyList = Collections.emptyList();
        long j4 = C.TIME_UNSET;
        if (z6) {
            list = emptyList;
            j2 = -9223372036854775807L;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            i = 0;
            i2 = 0;
            i3 = 0;
        } else {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            boolean z7 = (readUnsignedByte & 128) != 0;
            boolean z8 = (readUnsignedByte & 64) != 0;
            boolean z9 = (readUnsignedByte & 32) != 0;
            boolean z10 = (readUnsignedByte & 16) != 0;
            long parseSpliceTime = (!z8 || z10) ? -9223372036854775807L : TimeSignalCommand.parseSpliceTime(parsableByteArray, j);
            if (!z8) {
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                ArrayList arrayList = new ArrayList(readUnsignedByte2);
                int i5 = 0;
                while (i5 < readUnsignedByte2) {
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    if (z10) {
                        i4 = readUnsignedByte2;
                        j3 = -9223372036854775807L;
                    } else {
                        i4 = readUnsignedByte2;
                        j3 = TimeSignalCommand.parseSpliceTime(parsableByteArray, j);
                    }
                    arrayList.add(new ComponentSplice(readUnsignedByte3, j3, timestampAdjuster.adjustTsTimestamp(j3)));
                    i5++;
                    readUnsignedByte2 = i4;
                }
                emptyList = arrayList;
            }
            if (z9) {
                long readUnsignedByte4 = parsableByteArray.readUnsignedByte();
                boolean z11 = (128 & readUnsignedByte4) != 0;
                j4 = ((((readUnsignedByte4 & 1) << 32) | parsableByteArray.readUnsignedInt()) * 1000) / 90;
                z5 = z11;
            } else {
                z5 = false;
            }
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            long j5 = parseSpliceTime;
            j2 = j4;
            j4 = j5;
            i2 = parsableByteArray.readUnsignedByte();
            i3 = parsableByteArray.readUnsignedByte();
            i = readUnsignedShort;
            z4 = z5;
            z = z7;
            z2 = z8;
            list = emptyList;
            z3 = z10;
        }
        return new SpliceInsertCommand(readUnsignedInt, z6, z, z2, z3, j4, timestampAdjuster.adjustTsTimestamp(j4), list, z4, j2, i, i2, i3);
    }

    /* loaded from: classes2.dex */
    public static final class ComponentSplice {
        public final long componentSplicePlaybackPositionUs;
        public final long componentSplicePts;
        public final int componentTag;

        private ComponentSplice(int i, long j, long j2) {
            this.componentTag = i;
            this.componentSplicePts = j;
            this.componentSplicePlaybackPositionUs = j2;
        }
    }

    @Override // androidx.media3.extractor.metadata.scte35.SpliceCommand
    public String toString() {
        return "SCTE-35 SpliceInsertCommand { programSplicePts=" + this.programSplicePts + ", programSplicePlaybackPositionUs= " + this.programSplicePlaybackPositionUs + " }";
    }
}
