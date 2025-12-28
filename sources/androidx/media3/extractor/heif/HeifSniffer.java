package androidx.media3.extractor.heif;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorInput;
import java.io.IOException;
/* loaded from: classes3.dex */
final class HeifSniffer {
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean sniff(ExtractorInput extractorInput, boolean z) throws IOException {
        int i;
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        boolean z2 = true;
        while (true) {
            parsableByteArray.reset(8);
            if (!extractorInput.peekFully(parsableByteArray.getData(), 0, 8, true)) {
                return false;
            }
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            int readInt = parsableByteArray.readInt();
            if (readUnsignedInt != 1) {
                i = 8;
            } else if (!extractorInput.peekFully(parsableByteArray.getData(), 8, 8, true)) {
                return false;
            } else {
                readUnsignedInt = parsableByteArray.readUnsignedLongToLong();
                i = 16;
            }
            long j = i;
            if (readUnsignedInt < j) {
                return false;
            }
            int i2 = (int) (readUnsignedInt - j);
            if (z2) {
                if (readInt != 1718909296 || i2 < 8) {
                    break;
                }
                parsableByteArray.reset(4);
                extractorInput.peekFully(parsableByteArray.getData(), 0, 4);
                if (parsableByteArray.readInt() != 1751476579) {
                    return false;
                }
                if (!z) {
                    return true;
                }
                extractorInput.advancePeekPosition(i2 - 4);
                z2 = false;
            } else if (readInt == 1836086884) {
                return true;
            } else {
                if (i2 != 0) {
                    extractorInput.advancePeekPosition(i2);
                }
            }
        }
    }

    private HeifSniffer() {
    }
}
