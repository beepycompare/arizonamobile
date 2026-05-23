package androidx.media3.extractor.mp4;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.Mp4Box;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.SniffFailure;
import java.io.IOException;
/* loaded from: classes3.dex */
public final class Sniffer {
    public static final int BRAND_HEIC = 1751476579;
    public static final int BRAND_QUICKTIME = 1903435808;
    private static final int[] COMPATIBLE_BRANDS = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, Mp4Box.TYPE_avc1, Mp4Box.TYPE_hvc1, Mp4Box.TYPE_hev1, Mp4Box.TYPE_av01, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, BRAND_QUICKTIME, 1297305174, 1684175153, 1769172332, 1885955686};
    private static final int SEARCH_LENGTH = 4096;

    public static SniffFailure sniffFragmented(ExtractorInput extractorInput) throws IOException {
        return sniffInternal(extractorInput, true, false);
    }

    public static SniffFailure sniffUnfragmented(ExtractorInput extractorInput, boolean z) throws IOException {
        return sniffInternal(extractorInput, false, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static SniffFailure sniffInternal(ExtractorInput extractorInput, boolean z, boolean z2) throws IOException {
        SniffFailure sniffFailure;
        int i;
        long j;
        int i2;
        long j2;
        int i3;
        int i4;
        long j3;
        int i5;
        boolean z3;
        int[] iArr;
        long length = extractorInput.getLength();
        long j4 = -1;
        int i6 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        long j5 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        if (i6 != 0 && length <= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            j5 = length;
        }
        int i7 = (int) j5;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        int i8 = 0;
        int i9 = 0;
        boolean z4 = false;
        while (i9 < i7) {
            parsableByteArray.reset(8);
            if (!extractorInput.peekFully(parsableByteArray.getData(), i8, 8, true)) {
                break;
            }
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            int readInt = parsableByteArray.readInt();
            if (readUnsignedInt == 1) {
                j = j4;
                extractorInput.peekFully(parsableByteArray.getData(), 8, 8);
                i4 = 16;
                parsableByteArray.setLimit(16);
                i2 = i9;
                j2 = parsableByteArray.readLong();
                i3 = i6;
            } else {
                j = j4;
                if (readUnsignedInt == 0) {
                    long length2 = extractorInput.getLength();
                    if (length2 != j) {
                        readUnsignedInt = (length2 - extractorInput.getPeekPosition()) + 8;
                    }
                }
                long j6 = readUnsignedInt;
                i2 = i9;
                j2 = j6;
                i3 = i6;
                i4 = 8;
            }
            long j7 = i4;
            if (j2 < j7) {
                sniffFailure = null;
                if (readInt != 1718773093 || i4 != 8) {
                    return new AtomSizeTooSmallSniffFailure(readInt, j2, i4);
                }
                j2 = j7;
            } else {
                sniffFailure = null;
            }
            int i10 = i2 + i4;
            if (readInt == 1836019574 || readInt == 1970628964) {
                i7 += (int) j2;
                if (i3 != 0 && i7 > length) {
                    i7 = (int) length;
                }
                if (readInt == 1836019574) {
                    i9 = i10;
                    i6 = i3;
                    j4 = j;
                    i8 = 0;
                }
            }
            if (readInt != 1953653099 && readInt != 1835297121 && readInt != 1835626086) {
                if (readInt != 1836019558 && readInt != 1836475768) {
                    if (readInt == 1835295092) {
                        z4 = true;
                    }
                    if (readInt != 1937007212 || j2 <= 1000000) {
                        j3 = length;
                        if ((i10 + j2) - j7 < i7) {
                            int i11 = (int) (j2 - j7);
                            i9 = i10 + i11;
                            if (readInt != 1718909296) {
                                i5 = 0;
                                if (i11 != 0) {
                                    extractorInput.advancePeekPosition(i11);
                                }
                            } else if (i11 < 8) {
                                return new AtomSizeTooSmallSniffFailure(readInt, i11, 8);
                            } else {
                                parsableByteArray.reset(i11);
                                i5 = 0;
                                extractorInput.peekFully(parsableByteArray.getData(), 0, i11);
                                int readInt2 = parsableByteArray.readInt();
                                if (isCompatibleBrand(readInt2, z2)) {
                                    z4 = true;
                                }
                                parsableByteArray.skipBytes(4);
                                int bytesLeft = parsableByteArray.bytesLeft() / 4;
                                if (!z4 && bytesLeft > 0) {
                                    int[] iArr2 = new int[bytesLeft];
                                    int i12 = 0;
                                    while (true) {
                                        if (i12 >= bytesLeft) {
                                            z3 = z4;
                                            iArr = iArr2;
                                            break;
                                        }
                                        int readInt3 = parsableByteArray.readInt();
                                        iArr2[i12] = readInt3;
                                        if (isCompatibleBrand(readInt3, z2)) {
                                            z3 = true;
                                            iArr = iArr2;
                                            break;
                                        }
                                        i12++;
                                    }
                                } else {
                                    z3 = z4;
                                    iArr = sniffFailure;
                                }
                                if (!z3) {
                                    return new UnsupportedBrandsSniffFailure(readInt2, iArr);
                                }
                                z4 = z3;
                            }
                        }
                    }
                    i = 0;
                    break;
                }
                i = 1;
                break;
            }
            j3 = length;
            i5 = 0;
            i9 = i10;
            i8 = i5;
            i6 = i3;
            j4 = j;
            length = j3;
        }
        sniffFailure = null;
        i = i8;
        if (z4) {
            if (z != i) {
                if (i != 0) {
                    return IncorrectFragmentationSniffFailure.FILE_FRAGMENTED;
                }
                return IncorrectFragmentationSniffFailure.FILE_NOT_FRAGMENTED;
            }
            return sniffFailure;
        }
        return NoDeclaredBrandSniffFailure.INSTANCE;
    }

    private static boolean isCompatibleBrand(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579 && z) {
            return true;
        }
        for (int i2 : COMPATIBLE_BRANDS) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private Sniffer() {
    }
}
