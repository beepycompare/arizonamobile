package androidx.media3.container;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class ObuParser {
    public static final int OBU_FRAME = 6;
    public static final int OBU_FRAME_HEADER = 3;
    public static final int OBU_PADDING = 15;
    public static final int OBU_SEQUENCE_HEADER = 1;
    public static final int OBU_TEMPORAL_DELIMITER = 2;

    /* loaded from: classes2.dex */
    public static final class Obu {
        public final ByteBuffer payload;
        public final int type;

        private Obu(int i, ByteBuffer byteBuffer) {
            this.type = i;
            this.payload = byteBuffer;
        }
    }

    public static List<Obu> split(ByteBuffer byteBuffer) {
        int remaining;
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        ArrayList arrayList = new ArrayList();
        while (asReadOnlyBuffer.hasRemaining()) {
            byte b = asReadOnlyBuffer.get();
            int i = (b >> 3) & 15;
            if (((b >> 2) & 1) != 0) {
                asReadOnlyBuffer.get();
            }
            if (((b >> 1) & 1) != 0) {
                remaining = leb128(asReadOnlyBuffer);
            } else {
                remaining = asReadOnlyBuffer.remaining();
            }
            ByteBuffer duplicate = asReadOnlyBuffer.duplicate();
            duplicate.limit(asReadOnlyBuffer.position() + remaining);
            arrayList.add(new Obu(i, duplicate));
            asReadOnlyBuffer.position(asReadOnlyBuffer.position() + remaining);
        }
        return arrayList;
    }

    private static int leb128(ByteBuffer byteBuffer) {
        int i = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            byte b = byteBuffer.get();
            i |= (b & Byte.MAX_VALUE) << (i2 * 7);
            if ((b & 128) == 0) {
                return i;
            }
        }
        return i;
    }

    /* loaded from: classes2.dex */
    public static final class SequenceHeader {
        public final boolean decoderModelInfoPresentFlag;
        public final boolean frameIdNumbersPresentFlag;
        public final int orderHintBits;
        public final boolean reducedStillPictureHeader;
        public final boolean seqForceIntegerMv;
        public final boolean seqForceScreenContentTools;

        public static SequenceHeader parse(Obu obu) {
            try {
                return new SequenceHeader(obu);
            } catch (NotYetImplementedException unused) {
                return null;
            }
        }

        private SequenceHeader(Obu obu) throws NotYetImplementedException {
            Assertions.checkArgument(obu.type == 1);
            byte[] bArr = new byte[obu.payload.remaining()];
            obu.payload.asReadOnlyBuffer().get(bArr);
            ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
            parsableBitArray.skipBits(4);
            boolean readBit = parsableBitArray.readBit();
            this.reducedStillPictureHeader = readBit;
            ObuParser.throwWhenFeatureRequired(readBit);
            if (parsableBitArray.readBit()) {
                skipTimingInfo(parsableBitArray);
                boolean readBit2 = parsableBitArray.readBit();
                this.decoderModelInfoPresentFlag = readBit2;
                if (readBit2) {
                    parsableBitArray.skipBits(47);
                }
            } else {
                this.decoderModelInfoPresentFlag = false;
            }
            boolean readBit3 = parsableBitArray.readBit();
            int readBits = parsableBitArray.readBits(5);
            for (int i = 0; i <= readBits; i++) {
                parsableBitArray.skipBits(12);
                if (parsableBitArray.readBits(5) > 7) {
                    parsableBitArray.skipBit();
                }
                ObuParser.throwWhenFeatureRequired(this.decoderModelInfoPresentFlag);
                if (readBit3 && parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(4);
                }
            }
            int readBits2 = parsableBitArray.readBits(4);
            int readBits3 = parsableBitArray.readBits(4);
            parsableBitArray.skipBits(readBits2 + 1);
            parsableBitArray.skipBits(readBits3 + 1);
            boolean readBit4 = parsableBitArray.readBit();
            this.frameIdNumbersPresentFlag = readBit4;
            ObuParser.throwWhenFeatureRequired(readBit4);
            parsableBitArray.skipBits(3);
            parsableBitArray.skipBits(4);
            boolean readBit5 = parsableBitArray.readBit();
            if (readBit5) {
                parsableBitArray.skipBits(2);
            }
            if (parsableBitArray.readBit()) {
                this.seqForceScreenContentTools = true;
            } else {
                this.seqForceScreenContentTools = parsableBitArray.readBit();
            }
            if (this.seqForceScreenContentTools) {
                if (parsableBitArray.readBit()) {
                    this.seqForceIntegerMv = true;
                } else {
                    this.seqForceIntegerMv = parsableBitArray.readBit();
                }
            } else {
                this.seqForceIntegerMv = true;
            }
            if (readBit5) {
                this.orderHintBits = parsableBitArray.readBits(3) + 1;
            } else {
                this.orderHintBits = 0;
            }
        }

        private static void skipTimingInfo(ParsableBitArray parsableBitArray) {
            parsableBitArray.skipBits(64);
            if (parsableBitArray.readBit()) {
                ObuParser.skipUvlc(parsableBitArray);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void skipUvlc(ParsableBitArray parsableBitArray) {
        int i = 0;
        while (!parsableBitArray.readBit()) {
            i++;
        }
        if (i < 32) {
            parsableBitArray.skipBits(i);
        }
    }

    /* loaded from: classes2.dex */
    public static final class FrameHeader {
        private static final int FRAME_TYPE_INTRA_ONLY_FRAME = 2;
        private static final int FRAME_TYPE_KEY_FRAME = 0;
        private static final int FRAME_TYPE_SWITCH_FRAME = 3;
        private static final int PROBE_BYTES = 4;
        private final boolean isDependedOn;

        public boolean isDependedOn() {
            return this.isDependedOn;
        }

        public static FrameHeader parse(SequenceHeader sequenceHeader, Obu obu) {
            try {
                return new FrameHeader(sequenceHeader, obu);
            } catch (NotYetImplementedException unused) {
                return null;
            }
        }

        private FrameHeader(SequenceHeader sequenceHeader, Obu obu) throws NotYetImplementedException {
            Assertions.checkArgument(obu.type == 6 || obu.type == 3);
            byte[] bArr = new byte[Math.min(4, obu.payload.remaining())];
            obu.payload.asReadOnlyBuffer().get(bArr);
            ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
            ObuParser.throwWhenFeatureRequired(sequenceHeader.reducedStillPictureHeader);
            if (parsableBitArray.readBit()) {
                this.isDependedOn = false;
                return;
            }
            int readBits = parsableBitArray.readBits(2);
            boolean readBit = parsableBitArray.readBit();
            ObuParser.throwWhenFeatureRequired(sequenceHeader.decoderModelInfoPresentFlag);
            if (!readBit) {
                this.isDependedOn = true;
                return;
            }
            boolean readBit2 = (readBits == 3 || readBits == 0) ? true : parsableBitArray.readBit();
            parsableBitArray.skipBit();
            ObuParser.throwWhenFeatureRequired(!sequenceHeader.seqForceScreenContentTools);
            if (parsableBitArray.readBit()) {
                ObuParser.throwWhenFeatureRequired(!sequenceHeader.seqForceIntegerMv);
                parsableBitArray.skipBit();
            }
            ObuParser.throwWhenFeatureRequired(sequenceHeader.frameIdNumbersPresentFlag);
            if (readBits != 3) {
                parsableBitArray.skipBit();
            }
            parsableBitArray.skipBits(sequenceHeader.orderHintBits);
            if (readBits != 2 && readBits != 0 && !readBit2) {
                parsableBitArray.skipBits(3);
            }
            this.isDependedOn = ((readBits == 3 || readBits == 0) ? 255 : parsableBitArray.readBits(8)) != 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void throwWhenFeatureRequired(boolean z) throws NotYetImplementedException {
        if (z) {
            throw new NotYetImplementedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class NotYetImplementedException extends Exception {
        private NotYetImplementedException() {
        }
    }

    private ObuParser() {
    }
}
