package androidx.media3.extractor.text.cea;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.ComposerKt;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleDecoderException;
import androidx.media3.extractor.text.SubtitleInputBuffer;
import androidx.media3.extractor.text.SubtitleOutputBuffer;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import com.google.common.base.Ascii;
import com.tbuonomo.viewpagerdotsindicator.BaseDotsIndicator;
import io.appmetrica.analytics.BuildConfig;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;
/* loaded from: classes2.dex */
public final class Cea608Decoder extends CeaDecoder {
    private static final int CC_FIELD_FLAG = 1;
    private static final byte CC_IMPLICIT_DATA_HEADER = -4;
    private static final int CC_MODE_PAINT_ON = 3;
    private static final int CC_MODE_POP_ON = 2;
    private static final int CC_MODE_ROLL_UP = 1;
    private static final int CC_MODE_UNKNOWN = 0;
    private static final int CC_TYPE_FLAG = 2;
    private static final int CC_VALID_FLAG = 4;
    private static final byte CTRL_BACKSPACE = 33;
    private static final byte CTRL_CARRIAGE_RETURN = 45;
    private static final byte CTRL_DELETE_TO_END_OF_ROW = 36;
    private static final byte CTRL_END_OF_CAPTION = 47;
    private static final byte CTRL_ERASE_DISPLAYED_MEMORY = 44;
    private static final byte CTRL_ERASE_NON_DISPLAYED_MEMORY = 46;
    private static final byte CTRL_RESUME_CAPTION_LOADING = 32;
    private static final byte CTRL_RESUME_DIRECT_CAPTIONING = 41;
    private static final byte CTRL_RESUME_TEXT_DISPLAY = 43;
    private static final byte CTRL_ROLL_UP_CAPTIONS_2_ROWS = 37;
    private static final byte CTRL_ROLL_UP_CAPTIONS_3_ROWS = 38;
    private static final byte CTRL_ROLL_UP_CAPTIONS_4_ROWS = 39;
    private static final byte CTRL_TEXT_RESTART = 42;
    private static final int DEFAULT_CAPTIONS_ROW_COUNT = 4;
    public static final long MIN_DATA_CHANNEL_TIMEOUT_MS = 16000;
    private static final int NTSC_CC_CHANNEL_1 = 0;
    private static final int NTSC_CC_CHANNEL_2 = 1;
    private static final int NTSC_CC_FIELD_1 = 0;
    private static final int NTSC_CC_FIELD_2 = 1;
    private static final int STYLE_ITALICS = 7;
    private static final int STYLE_UNCHANGED = 8;
    private static final String TAG = "Cea608Decoder";
    private int captionMode;
    private int captionRowCount;
    private List<Cue> cues;
    private boolean isCaptionValid;
    private boolean isInCaptionService;
    private long lastCueUpdateUs;
    private List<Cue> lastCues;
    private final int packetLength;
    private byte repeatableControlCc1;
    private byte repeatableControlCc2;
    private boolean repeatableControlSet;
    private final int selectedChannel;
    private final int selectedField;
    private final long validDataChannelTimeoutUs;
    private static final int[] ROW_INDICES = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] COLUMN_INDICES = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] STYLE_COLORS = {-1, -16711936, -16776961, BaseDotsIndicator.DEFAULT_POINT_COLOR, SupportMenu.CATEGORY_MASK, InputDeviceCompat.SOURCE_ANY, -65281};
    private static final int[] BASIC_CHARACTER_SET = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, BuildConfig.API_LEVEL, AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID, 117, 118, 119, MenuKt.InTransitionDuration, 121, 122, 231, 247, 209, 241, 9632};
    private static final int[] SPECIAL_CHARACTER_SET = {174, 176, PsExtractor.PRIVATE_STREAM_1, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    private static final int[] SPECIAL_ES_FR_CHARACTER_SET = {DownloaderService.STATUS_PAUSED_BY_APP, ComposerKt.providerKey, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, DownloaderService.STATUS_WAITING_TO_RETRY, 199, 200, ComposerKt.compositionLocalMapKey, ComposerKt.providerValuesKey, 235, ComposerKt.referenceKey, ComposerKt.reuseKey, 239, 212, 217, 249, 219, 171, 187};
    private static final int[] SPECIAL_PT_DE_CHARACTER_SET = {DownloaderService.STATUS_WAITING_FOR_NETWORK, 227, 205, ComposerKt.providerMapsKey, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, WebSocketProtocol.PAYLOAD_SHORT, DownloaderService.STATUS_QUEUED_FOR_WIFI_OR_CELLULAR_PERMISSION, 228, 214, 246, 223, 165, 164, 9474, DownloaderService.STATUS_QUEUED_FOR_WIFI, 229, 216, 248, 9484, 9488, 9492, 9496};
    private static final boolean[] ODD_PARITY_BYTE_TABLE = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};
    private final ParsableByteArray ccData = new ParsableByteArray();
    private final ArrayList<CueBuilder> cueBuilders = new ArrayList<>();
    private CueBuilder currentCueBuilder = new CueBuilder(0, 4);
    private int currentChannel = 0;

    private static int getChannel(byte b) {
        return (b >> 3) & 1;
    }

    private static boolean isCtrlCode(byte b) {
        return (b & 224) == 0;
    }

    private static boolean isExtendedWestEuropeanChar(byte b, byte b2) {
        return (b & 246) == 18 && (b2 & 224) == 32;
    }

    private static boolean isMidrowCtrlCode(byte b, byte b2) {
        return (b & 247) == 17 && (b2 & 240) == 32;
    }

    private static boolean isMiscCode(byte b, byte b2) {
        return (b & 246) == 20 && (b2 & 240) == 32;
    }

    private static boolean isPreambleAddressCode(byte b, byte b2) {
        return (b & 240) == 16 && (b2 & 192) == 64;
    }

    private static boolean isRepeatable(byte b) {
        return (b & 240) == 16;
    }

    private static boolean isServiceSwitchCommand(byte b) {
        return (b & 246) == 20;
    }

    private static boolean isSpecialNorthAmericanChar(byte b, byte b2) {
        return (b & 247) == 17 && (b2 & 240) == 48;
    }

    private static boolean isTabCtrlCode(byte b, byte b2) {
        return (b & 247) == 23 && b2 >= 33 && b2 <= 35;
    }

    private static boolean isXdsControlCode(byte b) {
        return 1 <= b && b <= 15;
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder, androidx.media3.decoder.Decoder
    public void release() {
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder, androidx.media3.decoder.Decoder
    public /* bridge */ /* synthetic */ SubtitleInputBuffer dequeueInputBuffer() throws SubtitleDecoderException {
        return super.dequeueInputBuffer();
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    public /* bridge */ /* synthetic */ void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        super.queueInputBuffer(subtitleInputBuffer);
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder, androidx.media3.extractor.text.SubtitleDecoder
    public /* bridge */ /* synthetic */ void setPositionUs(long j) {
        super.setPositionUs(j);
    }

    public Cea608Decoder(String str, int i, long j) {
        if (j != C.TIME_UNSET) {
            Assertions.checkArgument(j >= MIN_DATA_CHANNEL_TIMEOUT_MS);
            this.validDataChannelTimeoutUs = j * 1000;
        } else {
            this.validDataChannelTimeoutUs = C.TIME_UNSET;
        }
        this.packetLength = MimeTypes.APPLICATION_MP4CEA608.equals(str) ? 2 : 3;
        if (i == 1) {
            this.selectedChannel = 0;
            this.selectedField = 0;
        } else if (i == 2) {
            this.selectedChannel = 1;
            this.selectedField = 0;
        } else if (i == 3) {
            this.selectedChannel = 0;
            this.selectedField = 1;
        } else if (i == 4) {
            this.selectedChannel = 1;
            this.selectedField = 1;
        } else {
            Log.w(TAG, "Invalid channel. Defaulting to CC1.");
            this.selectedChannel = 0;
            this.selectedField = 0;
        }
        setCaptionMode(0);
        resetCueBuilders();
        this.isInCaptionService = true;
        this.lastCueUpdateUs = C.TIME_UNSET;
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder, androidx.media3.decoder.Decoder
    public String getName() {
        return TAG;
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder, androidx.media3.decoder.Decoder
    public void flush() {
        super.flush();
        this.cues = null;
        this.lastCues = null;
        setCaptionMode(0);
        setCaptionRowCount(4);
        resetCueBuilders();
        this.isCaptionValid = false;
        this.repeatableControlSet = false;
        this.repeatableControlCc1 = (byte) 0;
        this.repeatableControlCc2 = (byte) 0;
        this.currentChannel = 0;
        this.isInCaptionService = true;
        this.lastCueUpdateUs = C.TIME_UNSET;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.media3.extractor.text.cea.CeaDecoder, androidx.media3.decoder.Decoder
    public SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        SubtitleOutputBuffer availableOutputBuffer;
        SubtitleOutputBuffer dequeueOutputBuffer = super.dequeueOutputBuffer();
        if (dequeueOutputBuffer != null) {
            return dequeueOutputBuffer;
        }
        if (!shouldClearStuckCaptions() || (availableOutputBuffer = getAvailableOutputBuffer()) == null) {
            return null;
        }
        this.cues = Collections.emptyList();
        this.lastCueUpdateUs = C.TIME_UNSET;
        availableOutputBuffer.setContent(getPositionUs(), createSubtitle(), Long.MAX_VALUE);
        return availableOutputBuffer;
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    protected boolean isNewSubtitleDataAvailable() {
        return this.cues != this.lastCues;
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    protected Subtitle createSubtitle() {
        this.lastCues = this.cues;
        return new CeaSubtitle((List) Assertions.checkNotNull(this.cues));
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x006d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0017 A[SYNTHETIC] */
    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void decode(SubtitleInputBuffer subtitleInputBuffer) {
        boolean z;
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(subtitleInputBuffer.data);
        this.ccData.reset(byteBuffer.array(), byteBuffer.limit());
        boolean z2 = false;
        while (true) {
            int bytesLeft = this.ccData.bytesLeft();
            int i = this.packetLength;
            if (bytesLeft < i) {
                break;
            }
            int readUnsignedByte = i == 2 ? -4 : this.ccData.readUnsignedByte();
            int readUnsignedByte2 = this.ccData.readUnsignedByte();
            int readUnsignedByte3 = this.ccData.readUnsignedByte();
            if ((readUnsignedByte & 2) == 0 && (readUnsignedByte & 1) == this.selectedField) {
                byte b = (byte) (readUnsignedByte2 & 127);
                byte b2 = (byte) (readUnsignedByte3 & 127);
                if (b != 0 || b2 != 0) {
                    boolean z3 = this.isCaptionValid;
                    if ((readUnsignedByte & 4) == 4) {
                        boolean[] zArr = ODD_PARITY_BYTE_TABLE;
                        if (zArr[readUnsignedByte2] && zArr[readUnsignedByte3]) {
                            z = true;
                            this.isCaptionValid = z;
                            if (!isRepeatedCommand(z, b, b2)) {
                                if (this.isCaptionValid) {
                                    maybeUpdateIsInCaptionService(b, b2);
                                    if (this.isInCaptionService && updateAndVerifyCurrentChannel(b)) {
                                        if (isCtrlCode(b)) {
                                            if (isSpecialNorthAmericanChar(b, b2)) {
                                                this.currentCueBuilder.append(getSpecialNorthAmericanChar(b2));
                                            } else if (isExtendedWestEuropeanChar(b, b2)) {
                                                this.currentCueBuilder.backspace();
                                                this.currentCueBuilder.append(getExtendedWestEuropeanChar(b, b2));
                                            } else if (isMidrowCtrlCode(b, b2)) {
                                                handleMidrowCtrl(b2);
                                            } else if (isPreambleAddressCode(b, b2)) {
                                                handlePreambleAddressCode(b, b2);
                                            } else if (!isTabCtrlCode(b, b2)) {
                                                if (isMiscCode(b, b2)) {
                                                    handleMiscCode(b2);
                                                }
                                            } else {
                                                this.currentCueBuilder.tabOffset = b2 - 32;
                                            }
                                        } else {
                                            this.currentCueBuilder.append(getBasicChar(b));
                                            if ((b2 & 224) != 0) {
                                                this.currentCueBuilder.append(getBasicChar(b2));
                                            }
                                        }
                                        z2 = true;
                                    }
                                } else if (z3) {
                                    resetCueBuilders();
                                    z2 = true;
                                }
                            }
                        }
                    }
                    z = false;
                    this.isCaptionValid = z;
                    if (!isRepeatedCommand(z, b, b2)) {
                    }
                }
            }
        }
        if (z2) {
            int i2 = this.captionMode;
            if (i2 == 1 || i2 == 3) {
                this.cues = getDisplayCues();
                this.lastCueUpdateUs = getPositionUs();
            }
        }
    }

    private boolean updateAndVerifyCurrentChannel(byte b) {
        if (isCtrlCode(b)) {
            this.currentChannel = getChannel(b);
        }
        return this.currentChannel == this.selectedChannel;
    }

    private boolean isRepeatedCommand(boolean z, byte b, byte b2) {
        if (z && isRepeatable(b)) {
            if (this.repeatableControlSet && this.repeatableControlCc1 == b && this.repeatableControlCc2 == b2) {
                this.repeatableControlSet = false;
                return true;
            }
            this.repeatableControlSet = true;
            this.repeatableControlCc1 = b;
            this.repeatableControlCc2 = b2;
        } else {
            this.repeatableControlSet = false;
        }
        return false;
    }

    private void handleMidrowCtrl(byte b) {
        this.currentCueBuilder.append(' ');
        this.currentCueBuilder.setStyle((b >> 1) & 7, (b & 1) == 1);
    }

    private void handlePreambleAddressCode(byte b, byte b2) {
        int i = ROW_INDICES[b & 7];
        if ((b2 & 32) != 0) {
            i++;
        }
        if (i != this.currentCueBuilder.row) {
            if (this.captionMode != 1 && !this.currentCueBuilder.isEmpty()) {
                CueBuilder cueBuilder = new CueBuilder(this.captionMode, this.captionRowCount);
                this.currentCueBuilder = cueBuilder;
                this.cueBuilders.add(cueBuilder);
            }
            this.currentCueBuilder.row = i;
        }
        boolean z = (b2 & Ascii.DLE) == 16;
        boolean z2 = (b2 & 1) == 1;
        int i2 = (b2 >> 1) & 7;
        this.currentCueBuilder.setStyle(z ? 8 : i2, z2);
        if (z) {
            this.currentCueBuilder.indent = COLUMN_INDICES[i2];
        }
    }

    private void handleMiscCode(byte b) {
        if (b == 32) {
            setCaptionMode(2);
        } else if (b != 41) {
            switch (b) {
                case 37:
                    setCaptionMode(1);
                    setCaptionRowCount(2);
                    return;
                case 38:
                    setCaptionMode(1);
                    setCaptionRowCount(3);
                    return;
                case 39:
                    setCaptionMode(1);
                    setCaptionRowCount(4);
                    return;
                default:
                    int i = this.captionMode;
                    if (i == 0) {
                        return;
                    }
                    if (b != 33) {
                        switch (b) {
                            case 44:
                                this.cues = Collections.emptyList();
                                int i2 = this.captionMode;
                                if (i2 == 1 || i2 == 3) {
                                    resetCueBuilders();
                                    return;
                                }
                                return;
                            case 45:
                                if (i != 1 || this.currentCueBuilder.isEmpty()) {
                                    return;
                                }
                                this.currentCueBuilder.rollUp();
                                return;
                            case 46:
                                resetCueBuilders();
                                return;
                            case 47:
                                this.cues = getDisplayCues();
                                resetCueBuilders();
                                return;
                            default:
                                return;
                        }
                    }
                    this.currentCueBuilder.backspace();
                    return;
            }
        } else {
            setCaptionMode(3);
        }
    }

    private List<Cue> getDisplayCues() {
        int size = this.cueBuilders.size();
        ArrayList arrayList = new ArrayList(size);
        int i = 2;
        for (int i2 = 0; i2 < size; i2++) {
            Cue build = this.cueBuilders.get(i2).build(Integer.MIN_VALUE);
            arrayList.add(build);
            if (build != null) {
                i = Math.min(i, build.positionAnchor);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            Cue cue = (Cue) arrayList.get(i3);
            if (cue != null) {
                if (cue.positionAnchor != i) {
                    cue = (Cue) Assertions.checkNotNull(this.cueBuilders.get(i3).build(i));
                }
                arrayList2.add(cue);
            }
        }
        return arrayList2;
    }

    private void setCaptionMode(int i) {
        int i2 = this.captionMode;
        if (i2 == i) {
            return;
        }
        this.captionMode = i;
        if (i == 3) {
            for (int i3 = 0; i3 < this.cueBuilders.size(); i3++) {
                this.cueBuilders.get(i3).setCaptionMode(i);
            }
            return;
        }
        resetCueBuilders();
        if (i2 == 3 || i == 1 || i == 0) {
            this.cues = Collections.emptyList();
        }
    }

    private void setCaptionRowCount(int i) {
        this.captionRowCount = i;
        this.currentCueBuilder.setCaptionRowCount(i);
    }

    private void resetCueBuilders() {
        this.currentCueBuilder.reset(this.captionMode);
        this.cueBuilders.clear();
        this.cueBuilders.add(this.currentCueBuilder);
    }

    private void maybeUpdateIsInCaptionService(byte b, byte b2) {
        if (isXdsControlCode(b)) {
            this.isInCaptionService = false;
        } else if (isServiceSwitchCommand(b)) {
            if (b2 != 32 && b2 != 47) {
                switch (b2) {
                    case 37:
                    case 38:
                    case 39:
                        break;
                    default:
                        switch (b2) {
                            case 41:
                                break;
                            case 42:
                            case 43:
                                this.isInCaptionService = false;
                                return;
                            default:
                                return;
                        }
                }
            }
            this.isInCaptionService = true;
        }
    }

    private static char getBasicChar(byte b) {
        return (char) BASIC_CHARACTER_SET[(b & Byte.MAX_VALUE) - 32];
    }

    private static char getSpecialNorthAmericanChar(byte b) {
        return (char) SPECIAL_CHARACTER_SET[b & Ascii.SI];
    }

    private static char getExtendedWestEuropeanChar(byte b, byte b2) {
        if ((b & 1) == 0) {
            return getExtendedEsFrChar(b2);
        }
        return getExtendedPtDeChar(b2);
    }

    private static char getExtendedEsFrChar(byte b) {
        return (char) SPECIAL_ES_FR_CHARACTER_SET[b & Ascii.US];
    }

    private static char getExtendedPtDeChar(byte b) {
        return (char) SPECIAL_PT_DE_CHARACTER_SET[b & Ascii.US];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class CueBuilder {
        private static final int BASE_ROW = 15;
        private static final int SCREEN_CHARWIDTH = 32;
        private int captionMode;
        private int captionRowCount;
        private int indent;
        private int row;
        private int tabOffset;
        private final List<CueStyle> cueStyles = new ArrayList();
        private final List<SpannableString> rolledUpCaptions = new ArrayList();
        private final StringBuilder captionStringBuilder = new StringBuilder();

        public CueBuilder(int i, int i2) {
            reset(i);
            this.captionRowCount = i2;
        }

        public void reset(int i) {
            this.captionMode = i;
            this.cueStyles.clear();
            this.rolledUpCaptions.clear();
            this.captionStringBuilder.setLength(0);
            this.row = 15;
            this.indent = 0;
            this.tabOffset = 0;
        }

        public boolean isEmpty() {
            return this.cueStyles.isEmpty() && this.rolledUpCaptions.isEmpty() && this.captionStringBuilder.length() == 0;
        }

        public void setCaptionMode(int i) {
            this.captionMode = i;
        }

        public void setCaptionRowCount(int i) {
            this.captionRowCount = i;
        }

        public void setStyle(int i, boolean z) {
            this.cueStyles.add(new CueStyle(i, z, this.captionStringBuilder.length()));
        }

        public void backspace() {
            CueStyle cueStyle;
            int length = this.captionStringBuilder.length();
            if (length > 0) {
                this.captionStringBuilder.delete(length - 1, length);
                for (int size = this.cueStyles.size() - 1; size >= 0; size--) {
                    if (this.cueStyles.get(size).start != length) {
                        return;
                    }
                    cueStyle.start--;
                }
            }
        }

        public void append(char c) {
            if (this.captionStringBuilder.length() < 32) {
                this.captionStringBuilder.append(c);
            }
        }

        public void rollUp() {
            this.rolledUpCaptions.add(buildCurrentLine());
            this.captionStringBuilder.setLength(0);
            this.cueStyles.clear();
            int min = Math.min(this.captionRowCount, this.row);
            while (this.rolledUpCaptions.size() >= min) {
                this.rolledUpCaptions.remove(0);
            }
        }

        public Cue build(int i) {
            float f;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i2 = 0; i2 < this.rolledUpCaptions.size(); i2++) {
                spannableStringBuilder.append((CharSequence) this.rolledUpCaptions.get(i2));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) buildCurrentLine());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i3 = this.indent + this.tabOffset;
            int length = (32 - i3) - spannableStringBuilder.length();
            int i4 = i3 - length;
            if (i == Integer.MIN_VALUE) {
                if (this.captionMode != 2 || (Math.abs(i4) >= 3 && length >= 0)) {
                    i = (this.captionMode != 2 || i4 <= 0) ? 0 : 2;
                } else {
                    i = 1;
                }
            }
            if (i != 1) {
                if (i == 2) {
                    i3 = 32 - length;
                }
                f = ((i3 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f = 0.5f;
            }
            int i5 = this.row;
            if (i5 > 7) {
                i5 -= 17;
            } else if (this.captionMode == 1) {
                i5 -= this.captionRowCount - 1;
            }
            return new Cue.Builder().setText(spannableStringBuilder).setTextAlignment(Layout.Alignment.ALIGN_NORMAL).setLine(i5, 1).setPosition(f).setPositionAnchor(i).build();
        }

        private SpannableString buildCurrentLine() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.captionStringBuilder);
            int length = spannableStringBuilder.length();
            int i = -1;
            int i2 = -1;
            int i3 = -1;
            int i4 = -1;
            int i5 = 0;
            int i6 = 0;
            boolean z = false;
            while (i5 < this.cueStyles.size()) {
                CueStyle cueStyle = this.cueStyles.get(i5);
                boolean z2 = cueStyle.underline;
                int i7 = cueStyle.style;
                if (i7 != 8) {
                    boolean z3 = i7 == 7;
                    if (i7 != 7) {
                        i4 = Cea608Decoder.STYLE_COLORS[i7];
                    }
                    z = z3;
                }
                int i8 = cueStyle.start;
                i5++;
                if (i8 != (i5 < this.cueStyles.size() ? this.cueStyles.get(i5).start : length)) {
                    if (i != -1 && !z2) {
                        setUnderlineSpan(spannableStringBuilder, i, i8);
                        i = -1;
                    } else if (i == -1 && z2) {
                        i = i8;
                    }
                    if (i2 != -1 && !z) {
                        setItalicSpan(spannableStringBuilder, i2, i8);
                        i2 = -1;
                    } else if (i2 == -1 && z) {
                        i2 = i8;
                    }
                    if (i4 != i3) {
                        setColorSpan(spannableStringBuilder, i6, i8, i3);
                        i3 = i4;
                        i6 = i8;
                    }
                }
            }
            if (i != -1 && i != length) {
                setUnderlineSpan(spannableStringBuilder, i, length);
            }
            if (i2 != -1 && i2 != length) {
                setItalicSpan(spannableStringBuilder, i2, length);
            }
            if (i6 != length) {
                setColorSpan(spannableStringBuilder, i6, length, i3);
            }
            return new SpannableString(spannableStringBuilder);
        }

        private static void setUnderlineSpan(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }

        private static void setItalicSpan(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i, i2, 33);
        }

        private static void setColorSpan(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3) {
            if (i3 == -1) {
                return;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class CueStyle {
            public int start;
            public final int style;
            public final boolean underline;

            public CueStyle(int i, boolean z, int i2) {
                this.style = i;
                this.underline = z;
                this.start = i2;
            }
        }
    }

    private boolean shouldClearStuckCaptions() {
        return (this.validDataChannelTimeoutUs == C.TIME_UNSET || this.lastCueUpdateUs == C.TIME_UNSET || getPositionUs() - this.lastCueUpdateUs < this.validDataChannelTimeoutUs) ? false : true;
    }
}
