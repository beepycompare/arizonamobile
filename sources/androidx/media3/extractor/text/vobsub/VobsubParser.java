package androidx.media3.extractor.text.vobsub;

import android.graphics.Bitmap;
import android.graphics.Rect;
import androidx.core.view.ViewCompat;
import androidx.media3.common.C;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.collect.ImmutableList;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
/* loaded from: classes3.dex */
public final class VobsubParser implements SubtitleParser {
    public static final int CUE_REPLACEMENT_BEHAVIOR = 2;
    private static final int DEFAULT_DURATION_US = 5000000;
    private static final String TAG = "VobsubParser";
    private final CueBuilder cueBuilder;
    private Inflater inflater;
    private final ParsableByteArray scratch = new ParsableByteArray();
    private final ParsableByteArray inflatedScratch = new ParsableByteArray();

    @Override // androidx.media3.extractor.text.SubtitleParser
    public int getCueReplacementBehavior() {
        return 2;
    }

    public VobsubParser(List<byte[]> list) {
        CueBuilder cueBuilder = new CueBuilder();
        this.cueBuilder = cueBuilder;
        cueBuilder.parseIdx(new String(list.get(0), StandardCharsets.UTF_8));
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public void parse(byte[] bArr, int i, int i2, SubtitleParser.OutputOptions outputOptions, Consumer<CuesWithTiming> consumer) {
        this.scratch.reset(bArr, i2 + i);
        this.scratch.setPosition(i);
        Cue parse = parse();
        consumer.accept(new CuesWithTiming(parse != null ? ImmutableList.of(parse) : ImmutableList.of(), C.TIME_UNSET, 5000000L));
    }

    private Cue parse() {
        if (this.inflater == null) {
            this.inflater = new Inflater();
        }
        if (Util.maybeInflate(this.scratch, this.inflatedScratch, this.inflater)) {
            this.scratch.reset(this.inflatedScratch.getData(), this.inflatedScratch.limit());
        }
        this.cueBuilder.reset();
        int bytesLeft = this.scratch.bytesLeft();
        if (bytesLeft < 2 || this.scratch.readUnsignedShort() != bytesLeft) {
            return null;
        }
        this.cueBuilder.parseSpuControlSequenceTable(this.scratch);
        return this.cueBuilder.build(this.scratch);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class CueBuilder {
        private static final int CMD_ALPHA = 4;
        private static final int CMD_AREA = 5;
        private static final int CMD_COLORS = 3;
        private static final int CMD_END = 255;
        private static final int CMD_FORCE_START = 0;
        private static final int CMD_OFFSETS = 6;
        private static final int CMD_START = 1;
        private static final int CMD_STOP = 2;
        private Rect boundingBox;
        private final int[] colors = new int[4];
        private int dataOffset0 = -1;
        private int dataOffset1 = -1;
        private boolean hasColors;
        private boolean hasPlane;
        private int[] palette;
        private int planeHeight;
        private int planeWidth;

        private static int setAlpha(int i, int i2) {
            return (i & ViewCompat.MEASURED_SIZE_MASK) | ((i2 * 17) << 24);
        }

        public void parseIdx(String str) {
            String[] split;
            for (String str2 : Util.split(str.trim(), "\\r?\\n")) {
                if (str2.startsWith("palette: ")) {
                    String[] split2 = Util.split(str2.substring("palette: ".length()), StringUtils.COMMA);
                    this.palette = new int[split2.length];
                    for (int i = 0; i < split2.length; i++) {
                        this.palette[i] = parseColor(split2[i].trim());
                    }
                } else if (str2.startsWith("size: ")) {
                    String[] split3 = Util.split(str2.substring("size: ".length()).trim(), "x");
                    if (split3.length != 2) {
                        Log.w(VobsubParser.TAG, "Ignoring malformed IDX size line: '" + str2 + "'");
                    } else {
                        try {
                            this.planeWidth = Integer.parseInt(split3[0]);
                            this.planeHeight = Integer.parseInt(split3[1]);
                            this.hasPlane = true;
                        } catch (RuntimeException e) {
                            Log.w(VobsubParser.TAG, "Parsing IDX failed", e);
                        }
                    }
                }
            }
        }

        private static int parseColor(String str) {
            try {
                return Integer.parseInt(str, 16);
            } catch (RuntimeException e) {
                Log.w(VobsubParser.TAG, "Parsing color failed", e);
                return 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void parseSpuControlSequenceTable(ParsableByteArray parsableByteArray) {
            if (this.palette == null) {
                Log.w(VobsubParser.TAG, "Skipping SPU (no palette)");
            } else if (!this.hasPlane) {
                Log.w(VobsubParser.TAG, "Skipping SPU (no plane)");
            } else {
                int position = parsableByteArray.getPosition() - 2;
                parsableByteArray.setPosition(parsableByteArray.readUnsignedShort() + position);
                do {
                } while (parseControlSequence(parsableByteArray, position));
            }
        }

        @RequiresNonNull({"this.palette"})
        private boolean parseControlSequence(ParsableByteArray parsableByteArray, int i) {
            boolean z = false;
            if (parsableByteArray.bytesLeft() < 4) {
                return false;
            }
            int position = parsableByteArray.getPosition();
            parsableByteArray.skipBytes(2);
            int readUnsignedShort = i + parsableByteArray.readUnsignedShort();
            boolean z2 = true;
            if (readUnsignedShort != position && readUnsignedShort < parsableByteArray.limit()) {
                z = true;
            }
            int limit = z ? readUnsignedShort : parsableByteArray.limit();
            while (parsableByteArray.getPosition() < limit && z2) {
                z2 = parseCommand(parsableByteArray);
            }
            if (z) {
                parsableByteArray.setPosition(readUnsignedShort);
            }
            return z;
        }

        @RequiresNonNull({"this.palette"})
        private boolean parseCommand(ParsableByteArray parsableByteArray) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            if (readUnsignedByte != 255) {
                switch (readUnsignedByte) {
                    case 0:
                    case 1:
                    case 2:
                        return true;
                    case 3:
                        return parseControlColors(parsableByteArray);
                    case 4:
                        return parseControlAlpha(parsableByteArray);
                    case 5:
                        return parseControlArea(parsableByteArray);
                    case 6:
                        return parseControlOffsets(parsableByteArray);
                    default:
                        Log.w(VobsubParser.TAG, "Unrecognized command: " + readUnsignedByte);
                        return false;
                }
            }
            return false;
        }

        @RequiresNonNull({"this.palette"})
        private boolean parseControlColors(ParsableByteArray parsableByteArray) {
            if (parsableByteArray.bytesLeft() < 2) {
                Log.w(VobsubParser.TAG, "Incomplete color command");
                return false;
            }
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
            this.colors[3] = getColor(this.palette, readUnsignedByte >> 4);
            this.colors[2] = getColor(this.palette, readUnsignedByte & 15);
            this.colors[1] = getColor(this.palette, readUnsignedByte2 >> 4);
            this.colors[0] = getColor(this.palette, readUnsignedByte2 & 15);
            this.hasColors = true;
            return true;
        }

        private static int getColor(int[] iArr, int i) {
            return (i < 0 || i >= iArr.length) ? iArr[0] : iArr[i];
        }

        private boolean parseControlAlpha(ParsableByteArray parsableByteArray) {
            if (parsableByteArray.bytesLeft() < 2) {
                Log.w(VobsubParser.TAG, "Incomplete alpha command");
                return false;
            } else if (!this.hasColors) {
                Log.w(VobsubParser.TAG, "Ignoring alpha command before color command");
                return false;
            } else {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                int[] iArr = this.colors;
                iArr[3] = setAlpha(iArr[3], readUnsignedByte >> 4);
                int[] iArr2 = this.colors;
                iArr2[2] = setAlpha(iArr2[2], readUnsignedByte & 15);
                int[] iArr3 = this.colors;
                iArr3[1] = setAlpha(iArr3[1], readUnsignedByte2 >> 4);
                int[] iArr4 = this.colors;
                iArr4[0] = setAlpha(iArr4[0], readUnsignedByte2 & 15);
                return true;
            }
        }

        private boolean parseControlArea(ParsableByteArray parsableByteArray) {
            if (parsableByteArray.bytesLeft() < 6) {
                Log.w(VobsubParser.TAG, "Incomplete area command");
                return false;
            }
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
            int i = (readUnsignedByte << 4) | (readUnsignedByte2 >> 4);
            int readUnsignedByte3 = ((readUnsignedByte2 & 15) << 8) | parsableByteArray.readUnsignedByte();
            int readUnsignedByte4 = parsableByteArray.readUnsignedByte();
            int readUnsignedByte5 = parsableByteArray.readUnsignedByte();
            this.boundingBox = new Rect(i, (readUnsignedByte4 << 4) | (readUnsignedByte5 >> 4), readUnsignedByte3 + 1, (parsableByteArray.readUnsignedByte() | ((readUnsignedByte5 & 15) << 8)) + 1);
            return true;
        }

        private boolean parseControlOffsets(ParsableByteArray parsableByteArray) {
            if (parsableByteArray.bytesLeft() < 4) {
                Log.w(VobsubParser.TAG, "Incomplete offsets command");
                return false;
            }
            this.dataOffset0 = parsableByteArray.readUnsignedShort();
            this.dataOffset1 = parsableByteArray.readUnsignedShort();
            return true;
        }

        public Cue build(ParsableByteArray parsableByteArray) {
            Rect rect;
            if (this.palette == null || !this.hasPlane || !this.hasColors || (rect = this.boundingBox) == null || this.dataOffset0 == -1 || this.dataOffset1 == -1 || rect.width() < 2 || this.boundingBox.height() < 2) {
                return null;
            }
            Rect rect2 = this.boundingBox;
            int[] iArr = new int[rect2.width() * rect2.height()];
            ParsableBitArray parsableBitArray = new ParsableBitArray();
            parsableByteArray.setPosition(this.dataOffset0);
            parsableBitArray.reset(parsableByteArray);
            parseRleData(parsableBitArray, true, rect2, iArr);
            parsableByteArray.setPosition(this.dataOffset1);
            parsableBitArray.reset(parsableByteArray);
            parseRleData(parsableBitArray, false, rect2, iArr);
            return new Cue.Builder().setBitmap(Bitmap.createBitmap(iArr, rect2.width(), rect2.height(), Bitmap.Config.ARGB_8888)).setPosition(rect2.left / this.planeWidth).setPositionAnchor(0).setLine(rect2.top / this.planeHeight, 0).setLineAnchor(0).setSize(rect2.width() / this.planeWidth).setBitmapHeight(rect2.height() / this.planeHeight).build();
        }

        private void parseRleData(ParsableBitArray parsableBitArray, boolean z, Rect rect, int[] iArr) {
            int width = rect.width();
            int height = rect.height();
            int i = !z ? 1 : 0;
            int i2 = i * width;
            Run run = new Run();
            while (true) {
                int i3 = 0;
                do {
                    parseRun(parsableBitArray, width, run);
                    int min = Math.min(run.length, width - i3);
                    if (min > 0) {
                        int i4 = i2 + min;
                        Arrays.fill(iArr, i2, i4, this.colors[run.colorIndex]);
                        i3 += min;
                        i2 = i4;
                        continue;
                    }
                } while (i3 < width);
                i += 2;
                if (i >= height) {
                    return;
                }
                i2 = i * width;
                parsableBitArray.byteAlign();
            }
        }

        private static void parseRun(ParsableBitArray parsableBitArray, int i, Run run) {
            int i2 = 0;
            for (int i3 = 1; i2 < i3 && i3 <= 64; i3 <<= 2) {
                if (parsableBitArray.bitsLeft() < 4) {
                    run.colorIndex = -1;
                    run.length = 0;
                    return;
                }
                i2 = (i2 << 4) | parsableBitArray.readBits(4);
            }
            run.colorIndex = i2 & 3;
            if (i2 >= 4) {
                i = i2 >> 2;
            }
            run.length = i;
        }

        public void reset() {
            this.hasColors = false;
            this.boundingBox = null;
            this.dataOffset0 = -1;
            this.dataOffset1 = -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class Run {
            public int colorIndex;
            public int length;

            private Run() {
            }
        }
    }
}
