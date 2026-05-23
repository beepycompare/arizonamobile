package androidx.media3.extractor.mkv;

import android.util.Pair;
import android.util.SparseArray;
import androidx.collection.SieveCacheKt;
import androidx.media3.common.C;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DataReader;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.DolbyVisionConfig;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.AvcConfig;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.ChunkIndexProvider;
import androidx.media3.extractor.DtsUtil;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.HevcConfig;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.TrackAwareSeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.TrueHdSampleRechunker;
import androidx.media3.extractor.metadata.ThumbnailMetadata;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
/* loaded from: classes3.dex */
public class MatroskaExtractor implements Extractor {
    private static final int BLOCK_ADDITIONAL_ID_VP9_ITU_T_35 = 4;
    private static final int BLOCK_ADD_ID_TYPE_DVCC = 1685480259;
    private static final int BLOCK_ADD_ID_TYPE_DVVC = 1685485123;
    private static final int BLOCK_STATE_DATA = 2;
    private static final int BLOCK_STATE_HEADER = 1;
    private static final int BLOCK_STATE_START = 0;
    private static final String CODEC_ID_AAC = "A_AAC";
    private static final String CODEC_ID_AC3 = "A_AC3";
    private static final String CODEC_ID_ACM = "A_MS/ACM";
    private static final String CODEC_ID_ASS = "S_TEXT/ASS";
    private static final String CODEC_ID_AV1 = "V_AV1";
    private static final String CODEC_ID_DTS = "A_DTS";
    private static final String CODEC_ID_DTS_EXPRESS = "A_DTS/EXPRESS";
    private static final String CODEC_ID_DTS_LOSSLESS = "A_DTS/LOSSLESS";
    private static final String CODEC_ID_DVBSUB = "S_DVBSUB";
    private static final String CODEC_ID_E_AC3 = "A_EAC3";
    private static final String CODEC_ID_FLAC = "A_FLAC";
    private static final String CODEC_ID_FOURCC = "V_MS/VFW/FOURCC";
    private static final String CODEC_ID_H264 = "V_MPEG4/ISO/AVC";
    private static final String CODEC_ID_H265 = "V_MPEGH/ISO/HEVC";
    private static final String CODEC_ID_MP2 = "A_MPEG/L2";
    private static final String CODEC_ID_MP3 = "A_MPEG/L3";
    private static final String CODEC_ID_MPEG2 = "V_MPEG2";
    private static final String CODEC_ID_MPEG4_AP = "V_MPEG4/ISO/AP";
    private static final String CODEC_ID_MPEG4_ASP = "V_MPEG4/ISO/ASP";
    private static final String CODEC_ID_MPEG4_SP = "V_MPEG4/ISO/SP";
    private static final String CODEC_ID_OPUS = "A_OPUS";
    private static final String CODEC_ID_PCM_FLOAT = "A_PCM/FLOAT/IEEE";
    private static final String CODEC_ID_PCM_INT_BIG = "A_PCM/INT/BIG";
    private static final String CODEC_ID_PCM_INT_LIT = "A_PCM/INT/LIT";
    private static final String CODEC_ID_PGS = "S_HDMV/PGS";
    private static final String CODEC_ID_SSA = "S_TEXT/SSA";
    private static final String CODEC_ID_SUBRIP = "S_TEXT/UTF8";
    private static final String CODEC_ID_THEORA = "V_THEORA";
    private static final String CODEC_ID_TRUEHD = "A_TRUEHD";
    private static final String CODEC_ID_VOBSUB = "S_VOBSUB";
    private static final String CODEC_ID_VORBIS = "A_VORBIS";
    private static final String CODEC_ID_VP8 = "V_VP8";
    private static final String CODEC_ID_VP9 = "V_VP9";
    private static final String CODEC_ID_VTT = "S_TEXT/WEBVTT";
    private static final String DOC_TYPE_MATROSKA = "matroska";
    private static final String DOC_TYPE_WEBM = "webm";
    private static final int ENCRYPTION_IV_SIZE = 8;
    public static final int FLAG_DISABLE_SEEK_FOR_CUES = 1;
    public static final int FLAG_EMIT_RAW_SUBTITLE_DATA = 2;
    private static final int FOURCC_COMPRESSION_DIVX = 1482049860;
    private static final int FOURCC_COMPRESSION_H263 = 859189832;
    private static final int FOURCC_COMPRESSION_VC1 = 826496599;
    private static final int ID_AUDIO = 225;
    private static final int ID_AUDIO_BIT_DEPTH = 25188;
    private static final int ID_BLOCK = 161;
    private static final int ID_BLOCK_ADDITIONAL = 165;
    private static final int ID_BLOCK_ADDITIONS = 30113;
    private static final int ID_BLOCK_ADDITION_MAPPING = 16868;
    private static final int ID_BLOCK_ADD_ID = 238;
    private static final int ID_BLOCK_ADD_ID_EXTRA_DATA = 16877;
    private static final int ID_BLOCK_ADD_ID_TYPE = 16871;
    private static final int ID_BLOCK_DURATION = 155;
    private static final int ID_BLOCK_GROUP = 160;
    private static final int ID_BLOCK_MORE = 166;
    private static final int ID_CHANNELS = 159;
    private static final int ID_CLUSTER = 524531317;
    private static final int ID_CODEC_DELAY = 22186;
    private static final int ID_CODEC_ID = 134;
    private static final int ID_CODEC_PRIVATE = 25506;
    private static final int ID_COLOUR = 21936;
    private static final int ID_COLOUR_BITS_PER_CHANNEL = 21938;
    private static final int ID_COLOUR_PRIMARIES = 21947;
    private static final int ID_COLOUR_RANGE = 21945;
    private static final int ID_COLOUR_TRANSFER = 21946;
    private static final int ID_CONTENT_COMPRESSION = 20532;
    private static final int ID_CONTENT_COMPRESSION_ALGORITHM = 16980;
    private static final int ID_CONTENT_COMPRESSION_SETTINGS = 16981;
    private static final int ID_CONTENT_ENCODING = 25152;
    private static final int ID_CONTENT_ENCODINGS = 28032;
    private static final int ID_CONTENT_ENCODING_ORDER = 20529;
    private static final int ID_CONTENT_ENCODING_SCOPE = 20530;
    private static final int ID_CONTENT_ENCRYPTION = 20533;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS = 18407;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE = 18408;
    private static final int ID_CONTENT_ENCRYPTION_ALGORITHM = 18401;
    private static final int ID_CONTENT_ENCRYPTION_KEY_ID = 18402;
    private static final int ID_CUES = 475249515;
    private static final int ID_CUE_CLUSTER_POSITION = 241;
    private static final int ID_CUE_POINT = 187;
    private static final int ID_CUE_RELATIVE_POSITION = 240;
    private static final int ID_CUE_TIME = 179;
    private static final int ID_CUE_TRACK = 247;
    private static final int ID_CUE_TRACK_POSITIONS = 183;
    private static final int ID_DEFAULT_DURATION = 2352003;
    private static final int ID_DISCARD_PADDING = 30114;
    private static final int ID_DISPLAY_HEIGHT = 21690;
    private static final int ID_DISPLAY_UNIT = 21682;
    private static final int ID_DISPLAY_WIDTH = 21680;
    private static final int ID_DOC_TYPE = 17026;
    private static final int ID_DOC_TYPE_READ_VERSION = 17029;
    private static final int ID_DURATION = 17545;
    private static final int ID_EBML = 440786851;
    private static final int ID_EBML_READ_VERSION = 17143;
    private static final int ID_FLAG_DEFAULT = 136;
    private static final int ID_FLAG_FORCED = 21930;
    private static final int ID_INFO = 357149030;
    private static final int ID_LANGUAGE = 2274716;
    private static final int ID_LUMNINANCE_MAX = 21977;
    private static final int ID_LUMNINANCE_MIN = 21978;
    private static final int ID_MASTERING_METADATA = 21968;
    private static final int ID_MAX_BLOCK_ADDITION_ID = 21998;
    private static final int ID_MAX_CLL = 21948;
    private static final int ID_MAX_FALL = 21949;
    private static final int ID_NAME = 21358;
    private static final int ID_PIXEL_HEIGHT = 186;
    private static final int ID_PIXEL_WIDTH = 176;
    private static final int ID_PRIMARY_B_CHROMATICITY_X = 21973;
    private static final int ID_PRIMARY_B_CHROMATICITY_Y = 21974;
    private static final int ID_PRIMARY_G_CHROMATICITY_X = 21971;
    private static final int ID_PRIMARY_G_CHROMATICITY_Y = 21972;
    private static final int ID_PRIMARY_R_CHROMATICITY_X = 21969;
    private static final int ID_PRIMARY_R_CHROMATICITY_Y = 21970;
    private static final int ID_PROJECTION = 30320;
    private static final int ID_PROJECTION_POSE_PITCH = 30324;
    private static final int ID_PROJECTION_POSE_ROLL = 30325;
    private static final int ID_PROJECTION_POSE_YAW = 30323;
    private static final int ID_PROJECTION_PRIVATE = 30322;
    private static final int ID_PROJECTION_TYPE = 30321;
    private static final int ID_REFERENCE_BLOCK = 251;
    private static final int ID_SAMPLING_FREQUENCY = 181;
    private static final int ID_SEEK = 19899;
    private static final int ID_SEEK_HEAD = 290298740;
    private static final int ID_SEEK_ID = 21419;
    private static final int ID_SEEK_POSITION = 21420;
    private static final int ID_SEEK_PRE_ROLL = 22203;
    private static final int ID_SEGMENT = 408125543;
    private static final int ID_SEGMENT_INFO = 357149030;
    private static final int ID_SIMPLE_BLOCK = 163;
    private static final int ID_STEREO_MODE = 21432;
    private static final int ID_TIMECODE_SCALE = 2807729;
    private static final int ID_TIME_CODE = 231;
    private static final int ID_TRACKS = 374648427;
    private static final int ID_TRACK_ENTRY = 174;
    private static final int ID_TRACK_NUMBER = 215;
    private static final int ID_TRACK_TYPE = 131;
    private static final int ID_VIDEO = 224;
    private static final int ID_WHITE_POINT_CHROMATICITY_X = 21975;
    private static final int ID_WHITE_POINT_CHROMATICITY_Y = 21976;
    private static final int LACING_EBML = 3;
    private static final int LACING_FIXED_SIZE = 2;
    private static final int LACING_NONE = 0;
    private static final int LACING_XIPH = 1;
    private static final int MAX_CHUNKS_TO_SCAN_FOR_THUMBNAIL = 20;
    private static final long MAX_DURATION_US_TO_SCAN_FOR_THUMBNAIL = 10000000;
    private static final int OPUS_MAX_INPUT_SIZE = 5760;
    private static final int SSA_PREFIX_END_TIMECODE_OFFSET = 21;
    private static final String SSA_TIMECODE_FORMAT = "%01d:%02d:%02d:%02d";
    private static final long SSA_TIMECODE_LAST_VALUE_SCALING_FACTOR = 10000;
    private static final int SUBRIP_PREFIX_END_TIMECODE_OFFSET = 19;
    private static final String SUBRIP_TIMECODE_FORMAT = "%02d:%02d:%02d,%03d";
    private static final long SUBRIP_TIMECODE_LAST_VALUE_SCALING_FACTOR = 1000;
    private static final String TAG = "MatroskaExtractor";
    private static final Map<String, Integer> TRACK_NAME_TO_ROTATION_DEGREES;
    private static final int UNSET_ENTRY_ID = -1;
    private static final int VORBIS_MAX_INPUT_SIZE = 8192;
    private static final int VTT_PREFIX_END_TIMECODE_OFFSET = 25;
    private static final String VTT_TIMECODE_FORMAT = "%02d:%02d:%02d.%03d";
    private static final long VTT_TIMECODE_LAST_VALUE_SCALING_FACTOR = 1000;
    private static final int WAVE_FORMAT_EXTENSIBLE = 65534;
    private static final int WAVE_FORMAT_PCM = 1;
    private static final int WAVE_FORMAT_SIZE = 18;
    private int blockAdditionalId;
    private long blockDurationUs;
    private int blockFlags;
    private long blockGroupDiscardPaddingNs;
    private boolean blockHasReferenceBlock;
    private int blockSampleCount;
    private int blockSampleIndex;
    private int[] blockSampleSizes;
    private int blockState;
    private long blockTimeUs;
    private int blockTrackNumber;
    private int blockTrackNumberLength;
    private long clusterTimecodeUs;
    private long cuesContentPosition;
    private long currentCueClusterPosition;
    private long currentCueRelativePosition;
    private long currentCueTimeUs;
    private int currentCueTrackNumber;
    private Track currentTrack;
    private long durationTimecode;
    private long durationUs;
    private final ParsableByteArray encryptionInitializationVector;
    private final ParsableByteArray encryptionSubsampleData;
    private ByteBuffer encryptionSubsampleDataBuffer;
    private ExtractorOutput extractorOutput;
    private boolean haveOutputSample;
    private boolean inCuesElement;
    private boolean isWebm;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private final boolean parseSubtitlesDuringExtraction;
    private boolean pendingEndTracks;
    private final SparseArray<List<MatroskaSeekMap.CuePointData>> perTrackCues;
    private int primarySeekTrackNumber;
    private final EbmlReader reader;
    private int sampleBytesRead;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private boolean sampleEncodingHandled;
    private boolean sampleInitializationVectorRead;
    private int samplePartitionCount;
    private boolean samplePartitionCountRead;
    private byte sampleSignalByte;
    private boolean sampleSignalByteRead;
    private final ParsableByteArray sampleStrippedBytes;
    private final ParsableByteArray scratch;
    private int seekEntryId;
    private final ParsableByteArray seekEntryIdBytes;
    private long seekEntryPosition;
    private boolean seekForCues;
    private final boolean seekForCuesEnabled;
    private long seekPositionAfterBuildingCues;
    private long segmentContentPosition;
    private long segmentContentSize;
    private boolean sentSeekMap;
    private final SubtitleParser.Factory subtitleParserFactory;
    private final ParsableByteArray subtitleSample;
    private final ParsableByteArray supplementalData;
    private long timecodeScale;
    private final SparseArray<Track> tracks;
    private final VarintReader varintReader;
    private final ParsableByteArray vorbisNumPageSamples;
    @Deprecated
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: androidx.media3.extractor.mkv.MatroskaExtractor$$ExternalSyntheticLambda1
        @Override // androidx.media3.extractor.ExtractorsFactory
        public final Extractor[] createExtractors() {
            return MatroskaExtractor.lambda$static$1();
        }
    };
    private static final byte[] SUBRIP_PREFIX = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] SSA_DIALOGUE_FORMAT = Util.getUtf8Bytes("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] SSA_PREFIX = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final byte[] VTT_PREFIX = {87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
    private static final UUID WAVE_SUBFORMAT_PCM = new UUID(72057594037932032L, -9223371306706625679L);

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Flags {
    }

    protected int getElementType(int i) {
        switch (i) {
            case ID_TRACK_TYPE /* 131 */:
            case 136:
            case ID_BLOCK_DURATION /* 155 */:
            case ID_CHANNELS /* 159 */:
            case ID_PIXEL_WIDTH /* 176 */:
            case ID_CUE_TIME /* 179 */:
            case ID_PIXEL_HEIGHT /* 186 */:
            case ID_TRACK_NUMBER /* 215 */:
            case ID_TIME_CODE /* 231 */:
            case ID_BLOCK_ADD_ID /* 238 */:
            case 240:
            case ID_CUE_CLUSTER_POSITION /* 241 */:
            case ID_CUE_TRACK /* 247 */:
            case ID_REFERENCE_BLOCK /* 251 */:
            case ID_BLOCK_ADD_ID_TYPE /* 16871 */:
            case ID_CONTENT_COMPRESSION_ALGORITHM /* 16980 */:
            case ID_DOC_TYPE_READ_VERSION /* 17029 */:
            case ID_EBML_READ_VERSION /* 17143 */:
            case ID_CONTENT_ENCRYPTION_ALGORITHM /* 18401 */:
            case ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE /* 18408 */:
            case ID_CONTENT_ENCODING_ORDER /* 20529 */:
            case ID_CONTENT_ENCODING_SCOPE /* 20530 */:
            case ID_SEEK_POSITION /* 21420 */:
            case ID_STEREO_MODE /* 21432 */:
            case ID_DISPLAY_WIDTH /* 21680 */:
            case ID_DISPLAY_UNIT /* 21682 */:
            case ID_DISPLAY_HEIGHT /* 21690 */:
            case ID_FLAG_FORCED /* 21930 */:
            case ID_COLOUR_BITS_PER_CHANNEL /* 21938 */:
            case ID_COLOUR_RANGE /* 21945 */:
            case ID_COLOUR_TRANSFER /* 21946 */:
            case ID_COLOUR_PRIMARIES /* 21947 */:
            case ID_MAX_CLL /* 21948 */:
            case ID_MAX_FALL /* 21949 */:
            case ID_MAX_BLOCK_ADDITION_ID /* 21998 */:
            case ID_CODEC_DELAY /* 22186 */:
            case ID_SEEK_PRE_ROLL /* 22203 */:
            case ID_AUDIO_BIT_DEPTH /* 25188 */:
            case ID_DISCARD_PADDING /* 30114 */:
            case ID_PROJECTION_TYPE /* 30321 */:
            case ID_DEFAULT_DURATION /* 2352003 */:
            case ID_TIMECODE_SCALE /* 2807729 */:
                return 2;
            case 134:
            case 17026:
            case ID_NAME /* 21358 */:
            case ID_LANGUAGE /* 2274716 */:
                return 3;
            case ID_BLOCK_GROUP /* 160 */:
            case ID_BLOCK_MORE /* 166 */:
            case ID_TRACK_ENTRY /* 174 */:
            case ID_CUE_TRACK_POSITIONS /* 183 */:
            case ID_CUE_POINT /* 187 */:
            case 224:
            case ID_AUDIO /* 225 */:
            case ID_BLOCK_ADDITION_MAPPING /* 16868 */:
            case ID_CONTENT_ENCRYPTION_AES_SETTINGS /* 18407 */:
            case ID_SEEK /* 19899 */:
            case ID_CONTENT_COMPRESSION /* 20532 */:
            case ID_CONTENT_ENCRYPTION /* 20533 */:
            case ID_COLOUR /* 21936 */:
            case ID_MASTERING_METADATA /* 21968 */:
            case ID_CONTENT_ENCODING /* 25152 */:
            case ID_CONTENT_ENCODINGS /* 28032 */:
            case ID_BLOCK_ADDITIONS /* 30113 */:
            case ID_PROJECTION /* 30320 */:
            case ID_SEEK_HEAD /* 290298740 */:
            case 357149030:
            case ID_TRACKS /* 374648427 */:
            case ID_SEGMENT /* 408125543 */:
            case ID_EBML /* 440786851 */:
            case ID_CUES /* 475249515 */:
            case ID_CLUSTER /* 524531317 */:
                return 1;
            case ID_BLOCK /* 161 */:
            case ID_SIMPLE_BLOCK /* 163 */:
            case ID_BLOCK_ADDITIONAL /* 165 */:
            case ID_BLOCK_ADD_ID_EXTRA_DATA /* 16877 */:
            case ID_CONTENT_COMPRESSION_SETTINGS /* 16981 */:
            case ID_CONTENT_ENCRYPTION_KEY_ID /* 18402 */:
            case ID_SEEK_ID /* 21419 */:
            case ID_CODEC_PRIVATE /* 25506 */:
            case ID_PROJECTION_PRIVATE /* 30322 */:
                return 4;
            case ID_SAMPLING_FREQUENCY /* 181 */:
            case ID_DURATION /* 17545 */:
            case ID_PRIMARY_R_CHROMATICITY_X /* 21969 */:
            case ID_PRIMARY_R_CHROMATICITY_Y /* 21970 */:
            case ID_PRIMARY_G_CHROMATICITY_X /* 21971 */:
            case ID_PRIMARY_G_CHROMATICITY_Y /* 21972 */:
            case ID_PRIMARY_B_CHROMATICITY_X /* 21973 */:
            case ID_PRIMARY_B_CHROMATICITY_Y /* 21974 */:
            case ID_WHITE_POINT_CHROMATICITY_X /* 21975 */:
            case ID_WHITE_POINT_CHROMATICITY_Y /* 21976 */:
            case ID_LUMNINANCE_MAX /* 21977 */:
            case ID_LUMNINANCE_MIN /* 21978 */:
            case ID_PROJECTION_POSE_YAW /* 30323 */:
            case ID_PROJECTION_POSE_PITCH /* 30324 */:
            case ID_PROJECTION_POSE_ROLL /* 30325 */:
                return 5;
            default:
                return 0;
        }
    }

    protected boolean isLevel1Element(int i) {
        return i == 357149030 || i == ID_CLUSTER || i == ID_CUES || i == ID_TRACKS;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Extractor[] lambda$newFactory$0(SubtitleParser.Factory factory) {
        return new Extractor[]{new MatroskaExtractor(factory)};
    }

    public static ExtractorsFactory newFactory(final SubtitleParser.Factory factory) {
        return new ExtractorsFactory() { // from class: androidx.media3.extractor.mkv.MatroskaExtractor$$ExternalSyntheticLambda0
            @Override // androidx.media3.extractor.ExtractorsFactory
            public final Extractor[] createExtractors() {
                return MatroskaExtractor.lambda$newFactory$0(SubtitleParser.Factory.this);
            }
        };
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", Integer.valueOf((int) SubsamplingScaleImageView.ORIENTATION_270));
        TRACK_NAME_TO_ROTATION_DEGREES = Collections.unmodifiableMap(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Extractor[] lambda$static$1() {
        return new Extractor[]{new MatroskaExtractor(SubtitleParser.Factory.UNSUPPORTED, 2)};
    }

    @Deprecated
    public MatroskaExtractor() {
        this(new DefaultEbmlReader(), 2, SubtitleParser.Factory.UNSUPPORTED);
    }

    @Deprecated
    public MatroskaExtractor(int i) {
        this(new DefaultEbmlReader(), i | 2, SubtitleParser.Factory.UNSUPPORTED);
    }

    public MatroskaExtractor(SubtitleParser.Factory factory) {
        this(new DefaultEbmlReader(), 0, factory);
    }

    public MatroskaExtractor(SubtitleParser.Factory factory, int i) {
        this(new DefaultEbmlReader(), i, factory);
    }

    MatroskaExtractor(EbmlReader ebmlReader, int i, SubtitleParser.Factory factory) {
        this.segmentContentPosition = -1L;
        this.timecodeScale = C.TIME_UNSET;
        this.durationTimecode = C.TIME_UNSET;
        this.durationUs = C.TIME_UNSET;
        this.currentCueTimeUs = C.TIME_UNSET;
        this.currentCueTrackNumber = -1;
        this.currentCueClusterPosition = -1L;
        this.currentCueRelativePosition = -1L;
        this.primarySeekTrackNumber = -1;
        this.cuesContentPosition = -1L;
        this.seekPositionAfterBuildingCues = -1L;
        this.clusterTimecodeUs = C.TIME_UNSET;
        this.reader = ebmlReader;
        ebmlReader.init(new InnerEbmlProcessor());
        this.subtitleParserFactory = factory;
        this.perTrackCues = new SparseArray<>();
        this.seekForCuesEnabled = (i & 1) == 0;
        this.parseSubtitlesDuringExtraction = (i & 2) == 0;
        this.varintReader = new VarintReader();
        this.tracks = new SparseArray<>();
        this.scratch = new ParsableByteArray(4);
        this.vorbisNumPageSamples = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.seekEntryIdBytes = new ParsableByteArray(4);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
        this.sampleStrippedBytes = new ParsableByteArray();
        this.subtitleSample = new ParsableByteArray();
        this.encryptionInitializationVector = new ParsableByteArray(8);
        this.encryptionSubsampleData = new ParsableByteArray();
        this.supplementalData = new ParsableByteArray();
        this.blockSampleSizes = new int[1];
        this.pendingEndTracks = true;
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput) throws IOException {
        return new Sniffer().sniff(extractorInput);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput) {
        if (this.parseSubtitlesDuringExtraction) {
            extractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.subtitleParserFactory);
        }
        this.extractorOutput = extractorOutput;
    }

    @Override // androidx.media3.extractor.Extractor
    public void seek(long j, long j2) {
        this.clusterTimecodeUs = C.TIME_UNSET;
        this.blockState = 0;
        this.reader.reset();
        this.varintReader.reset();
        resetWriteSampleData();
        this.inCuesElement = false;
        this.currentCueTimeUs = C.TIME_UNSET;
        this.currentCueTrackNumber = -1;
        this.currentCueClusterPosition = -1L;
        this.currentCueRelativePosition = -1L;
        if (!this.sentSeekMap) {
            this.perTrackCues.clear();
        }
        for (int i = 0; i < this.tracks.size(); i++) {
            this.tracks.valueAt(i).reset();
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        this.haveOutputSample = false;
        boolean z = true;
        while (z && !this.haveOutputSample) {
            z = this.reader.read(extractorInput);
            if (z && maybeSeekForCues(positionHolder, extractorInput.getPosition())) {
                return 1;
            }
        }
        if (z) {
            return 0;
        }
        for (int i = 0; i < this.tracks.size(); i++) {
            Track valueAt = this.tracks.valueAt(i);
            valueAt.assertOutputInitialized();
            valueAt.outputPendingSampleMetadata();
        }
        return -1;
    }

    protected void startMasterElement(int i, long j, long j2) throws ParserException {
        assertInitialized();
        if (i == ID_BLOCK_GROUP) {
            this.blockHasReferenceBlock = false;
            this.blockGroupDiscardPaddingNs = 0L;
        } else if (i == ID_TRACK_ENTRY) {
            Track track = new Track();
            this.currentTrack = track;
            track.isWebm = this.isWebm;
        } else if (i == ID_CUE_TRACK_POSITIONS) {
            if (this.sentSeekMap) {
                return;
            }
            assertInCues(i);
            this.currentCueTrackNumber = -1;
            this.currentCueClusterPosition = -1L;
            this.currentCueRelativePosition = -1L;
        } else if (i == ID_CUE_POINT) {
            if (this.sentSeekMap) {
                return;
            }
            assertInCues(i);
            this.currentCueTimeUs = C.TIME_UNSET;
        } else if (i == ID_SEEK) {
            this.seekEntryId = -1;
            this.seekEntryPosition = -1L;
        } else if (i == ID_CONTENT_ENCRYPTION) {
            getCurrentTrack(i).hasContentEncryption = true;
        } else if (i == ID_MASTERING_METADATA) {
            getCurrentTrack(i).hasColorInfo = true;
        } else if (i == ID_SEGMENT) {
            long j3 = this.segmentContentPosition;
            if (j3 != -1 && j3 != j) {
                throw ParserException.createForMalformedContainer("Multiple Segment elements not supported", null);
            }
            this.segmentContentPosition = j;
            this.segmentContentSize = j2;
        } else if (i == ID_CUES) {
            if (this.sentSeekMap) {
                return;
            }
            this.inCuesElement = true;
        } else if (i == ID_CLUSTER && !this.sentSeekMap) {
            if (this.seekForCuesEnabled && this.cuesContentPosition != -1) {
                this.seekForCues = true;
                return;
            }
            this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs));
            this.sentSeekMap = true;
        }
    }

    protected void endMasterElement(int i) throws ParserException {
        int i2;
        assertInitialized();
        if (i == ID_BLOCK_GROUP) {
            if (this.blockState != 2) {
                return;
            }
            Track track = this.tracks.get(this.blockTrackNumber);
            track.assertOutputInitialized();
            if (this.blockGroupDiscardPaddingNs > 0 && CODEC_ID_OPUS.equals(track.codecId)) {
                this.supplementalData.reset(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.blockGroupDiscardPaddingNs).array());
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.blockSampleCount; i4++) {
                i3 += this.blockSampleSizes[i4];
            }
            int i5 = 0;
            while (i5 < this.blockSampleCount) {
                long j = this.blockTimeUs + ((track.defaultSampleDurationNs * i5) / 1000);
                int i6 = this.blockFlags;
                if (i5 == 0 && !this.blockHasReferenceBlock) {
                    i6 |= 1;
                }
                int i7 = this.blockSampleSizes[i5];
                int i8 = i3 - i7;
                commitSampleToOutput(track, j, i6, i7, i8);
                i5++;
                i3 = i8;
            }
            this.blockState = 0;
        } else if (i == ID_TRACK_ENTRY) {
            Track track2 = (Track) Preconditions.checkNotNull(this.currentTrack);
            if (track2.codecId == null) {
                throw ParserException.createForMalformedContainer("CodecId is missing in TrackEntry element", null);
            }
            if (isCodecSupported(track2.codecId)) {
                track2.initializeFormat(track2.number);
                track2.output = this.extractorOutput.track(track2.number, track2.type);
                this.tracks.put(track2.number, track2);
            }
            this.currentTrack = null;
        } else if (i == ID_CUE_TRACK_POSITIONS) {
            if (this.sentSeekMap) {
                return;
            }
            assertInCues(i);
            if (this.currentCueTimeUs == C.TIME_UNSET || (i2 = this.currentCueTrackNumber) == -1 || this.currentCueClusterPosition == -1) {
                return;
            }
            List<MatroskaSeekMap.CuePointData> list = this.perTrackCues.get(i2);
            if (list == null) {
                list = new ArrayList<>();
                this.perTrackCues.put(this.currentCueTrackNumber, list);
            }
            list.add(new MatroskaSeekMap.CuePointData(this.currentCueTimeUs, this.segmentContentPosition + this.currentCueClusterPosition, this.currentCueRelativePosition));
        } else if (i == ID_SEEK) {
            int i9 = this.seekEntryId;
            if (i9 != -1) {
                long j2 = this.seekEntryPosition;
                if (j2 != -1) {
                    if (i9 == ID_CUES) {
                        this.cuesContentPosition = j2;
                        return;
                    }
                    return;
                }
            }
            throw ParserException.createForMalformedContainer("Mandatory element SeekID or SeekPosition not found", null);
        } else if (i == ID_CONTENT_ENCODING) {
            assertInTrackEntry(i);
            if (this.currentTrack.hasContentEncryption) {
                if (this.currentTrack.cryptoData == null) {
                    throw ParserException.createForMalformedContainer("Encrypted Track found but ContentEncKeyID was not found", null);
                }
                this.currentTrack.drmInitData = new DrmInitData(new DrmInitData.SchemeData(C.UUID_NIL, MimeTypes.VIDEO_WEBM, this.currentTrack.cryptoData.encryptionKey));
            }
        } else if (i == ID_CONTENT_ENCODINGS) {
            assertInTrackEntry(i);
            if (this.currentTrack.hasContentEncryption && this.currentTrack.sampleStrippedBytes != null) {
                throw ParserException.createForMalformedContainer("Combining encryption and compression is not supported", null);
            }
        } else if (i == 357149030) {
            if (this.timecodeScale == C.TIME_UNSET) {
                this.timecodeScale = 1000000L;
            }
            long j3 = this.durationTimecode;
            if (j3 != C.TIME_UNSET) {
                this.durationUs = scaleTimecodeToUs(j3);
            }
        } else if (i != ID_TRACKS) {
            if (i == ID_CUES && !this.sentSeekMap) {
                int i10 = 0;
                while (true) {
                    if (i10 >= this.perTrackCues.size()) {
                        break;
                    } else if (this.perTrackCues.valueAt(i10).isEmpty()) {
                        i10++;
                    } else if (this.durationUs != C.TIME_UNSET) {
                        for (int i11 = 0; i11 < this.perTrackCues.size(); i11++) {
                            Collections.sort(this.perTrackCues.valueAt(i11));
                        }
                        this.extractorOutput.seekMap(new MatroskaSeekMap(this.perTrackCues, this.durationUs, this.primarySeekTrackNumber, this.segmentContentPosition, this.segmentContentSize));
                    }
                }
                this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs));
                this.sentSeekMap = true;
                this.inCuesElement = false;
                for (int i12 = 0; i12 < this.tracks.size(); i12++) {
                    Track valueAt = this.tracks.valueAt(i12);
                    valueAt.maybeAddThumbnailMetadata(this.perTrackCues, this.durationUs, this.segmentContentPosition, this.segmentContentSize);
                    if (!valueAt.waitingForDtsAnalysis) {
                        valueAt.assertOutputInitialized();
                        valueAt.output.format((Format) Preconditions.checkNotNull(valueAt.format));
                    }
                }
                maybeEndTracks();
            }
        } else if (this.tracks.size() == 0) {
            throw ParserException.createForMalformedContainer("No valid tracks were found", null);
        } else {
            boolean z = !this.seekForCuesEnabled || this.cuesContentPosition == -1;
            int i13 = -1;
            int i14 = -1;
            int i15 = -1;
            int i16 = -1;
            for (int i17 = 0; i17 < this.tracks.size(); i17++) {
                Track valueAt2 = this.tracks.valueAt(i17);
                int i18 = valueAt2.type;
                if (i18 == 2) {
                    if (valueAt2.flagDefault) {
                        i13 = valueAt2.number;
                    }
                    if (i14 == -1) {
                        i14 = valueAt2.number;
                    }
                } else if (i18 == 1) {
                    if (valueAt2.flagDefault) {
                        i15 = valueAt2.number;
                    }
                    if (i16 == -1) {
                        i16 = valueAt2.number;
                    }
                }
                if (z) {
                    valueAt2.assertOutputInitialized();
                    if (!valueAt2.waitingForDtsAnalysis) {
                        valueAt2.output.format((Format) Preconditions.checkNotNull(valueAt2.format));
                    }
                }
            }
            if (i13 != -1) {
                this.primarySeekTrackNumber = i13;
            } else if (i14 != -1) {
                this.primarySeekTrackNumber = i14;
            } else if (i15 != -1) {
                this.primarySeekTrackNumber = i15;
            } else if (i16 != -1) {
                this.primarySeekTrackNumber = i16;
            } else {
                this.primarySeekTrackNumber = this.tracks.size() > 0 ? this.tracks.valueAt(0).number : -1;
            }
            if (z) {
                maybeEndTracks();
            }
        }
    }

    protected void integerElement(int i, long j) throws ParserException {
        if (i == 240) {
            if (this.sentSeekMap) {
                return;
            }
            assertInCues(i);
            if (this.currentCueRelativePosition == -1) {
                this.currentCueRelativePosition = j;
            }
        } else if (i == ID_CUE_CLUSTER_POSITION) {
            if (this.sentSeekMap) {
                return;
            }
            assertInCues(i);
            if (this.currentCueClusterPosition == -1) {
                this.currentCueClusterPosition = j;
            }
        } else if (i == ID_CONTENT_ENCODING_ORDER) {
            if (j != 0) {
                throw ParserException.createForMalformedContainer("ContentEncodingOrder " + j + " not supported", null);
            }
        } else if (i == ID_CONTENT_ENCODING_SCOPE) {
            if (j != 1) {
                throw ParserException.createForMalformedContainer("ContentEncodingScope " + j + " not supported", null);
            }
        } else {
            switch (i) {
                case ID_TRACK_TYPE /* 131 */:
                    int i2 = (int) j;
                    if (i2 == 1) {
                        getCurrentTrack(i).type = 2;
                        return;
                    } else if (i2 == 2) {
                        getCurrentTrack(i).type = 1;
                        return;
                    } else if (i2 == 17) {
                        getCurrentTrack(i).type = 3;
                        return;
                    } else if (i2 == 33) {
                        getCurrentTrack(i).type = 5;
                        return;
                    } else {
                        getCurrentTrack(i).type = -1;
                        return;
                    }
                case 136:
                    getCurrentTrack(i).flagDefault = j == 1;
                    return;
                case ID_BLOCK_DURATION /* 155 */:
                    this.blockDurationUs = scaleTimecodeToUs(j);
                    return;
                case ID_CHANNELS /* 159 */:
                    getCurrentTrack(i).channelCount = (int) j;
                    return;
                case ID_PIXEL_WIDTH /* 176 */:
                    getCurrentTrack(i).width = (int) j;
                    return;
                case ID_CUE_TIME /* 179 */:
                    if (this.sentSeekMap) {
                        return;
                    }
                    assertInCues(i);
                    this.currentCueTimeUs = scaleTimecodeToUs(j);
                    return;
                case ID_PIXEL_HEIGHT /* 186 */:
                    getCurrentTrack(i).height = (int) j;
                    return;
                case ID_TRACK_NUMBER /* 215 */:
                    getCurrentTrack(i).number = (int) j;
                    return;
                case ID_TIME_CODE /* 231 */:
                    this.clusterTimecodeUs = scaleTimecodeToUs(j);
                    return;
                case ID_BLOCK_ADD_ID /* 238 */:
                    this.blockAdditionalId = (int) j;
                    return;
                case ID_CUE_TRACK /* 247 */:
                    if (this.sentSeekMap) {
                        return;
                    }
                    assertInCues(i);
                    this.currentCueTrackNumber = (int) j;
                    return;
                case ID_REFERENCE_BLOCK /* 251 */:
                    this.blockHasReferenceBlock = true;
                    return;
                case ID_BLOCK_ADD_ID_TYPE /* 16871 */:
                    getCurrentTrack(i).blockAddIdType = (int) j;
                    return;
                case ID_CONTENT_COMPRESSION_ALGORITHM /* 16980 */:
                    if (j != 3) {
                        throw ParserException.createForMalformedContainer("ContentCompAlgo " + j + " not supported", null);
                    }
                    return;
                case ID_DOC_TYPE_READ_VERSION /* 17029 */:
                    if (j < 1 || j > 2) {
                        throw ParserException.createForMalformedContainer("DocTypeReadVersion " + j + " not supported", null);
                    }
                    return;
                case ID_EBML_READ_VERSION /* 17143 */:
                    if (j != 1) {
                        throw ParserException.createForMalformedContainer("EBMLReadVersion " + j + " not supported", null);
                    }
                    return;
                case ID_CONTENT_ENCRYPTION_ALGORITHM /* 18401 */:
                    if (j != 5) {
                        throw ParserException.createForMalformedContainer("ContentEncAlgo " + j + " not supported", null);
                    }
                    return;
                case ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE /* 18408 */:
                    if (j != 1) {
                        throw ParserException.createForMalformedContainer("AESSettingsCipherMode " + j + " not supported", null);
                    }
                    return;
                case ID_SEEK_POSITION /* 21420 */:
                    this.seekEntryPosition = j + this.segmentContentPosition;
                    return;
                case ID_STEREO_MODE /* 21432 */:
                    int i3 = (int) j;
                    assertInTrackEntry(i);
                    if (i3 == 0) {
                        this.currentTrack.stereoMode = 0;
                        return;
                    } else if (i3 == 1) {
                        this.currentTrack.stereoMode = 2;
                        return;
                    } else if (i3 == 3) {
                        this.currentTrack.stereoMode = 1;
                        return;
                    } else if (i3 != 15) {
                        return;
                    } else {
                        this.currentTrack.stereoMode = 3;
                        return;
                    }
                case ID_DISPLAY_WIDTH /* 21680 */:
                    getCurrentTrack(i).displayWidth = (int) j;
                    return;
                case ID_DISPLAY_UNIT /* 21682 */:
                    getCurrentTrack(i).displayUnit = (int) j;
                    return;
                case ID_DISPLAY_HEIGHT /* 21690 */:
                    getCurrentTrack(i).displayHeight = (int) j;
                    return;
                case ID_FLAG_FORCED /* 21930 */:
                    getCurrentTrack(i).flagForced = j == 1;
                    return;
                case ID_COLOUR_BITS_PER_CHANNEL /* 21938 */:
                    assertInTrackEntry(i);
                    this.currentTrack.hasColorInfo = true;
                    this.currentTrack.bitsPerChannel = (int) j;
                    return;
                case ID_MAX_BLOCK_ADDITION_ID /* 21998 */:
                    getCurrentTrack(i).maxBlockAdditionId = (int) j;
                    return;
                case ID_CODEC_DELAY /* 22186 */:
                    getCurrentTrack(i).codecDelayNs = j;
                    return;
                case ID_SEEK_PRE_ROLL /* 22203 */:
                    getCurrentTrack(i).seekPreRollNs = j;
                    return;
                case ID_AUDIO_BIT_DEPTH /* 25188 */:
                    getCurrentTrack(i).audioBitDepth = (int) j;
                    return;
                case ID_DISCARD_PADDING /* 30114 */:
                    this.blockGroupDiscardPaddingNs = j;
                    return;
                case ID_PROJECTION_TYPE /* 30321 */:
                    assertInTrackEntry(i);
                    int i4 = (int) j;
                    if (i4 == 0) {
                        this.currentTrack.projectionType = 0;
                        return;
                    } else if (i4 == 1) {
                        this.currentTrack.projectionType = 1;
                        return;
                    } else if (i4 == 2) {
                        this.currentTrack.projectionType = 2;
                        return;
                    } else if (i4 != 3) {
                        return;
                    } else {
                        this.currentTrack.projectionType = 3;
                        return;
                    }
                case ID_DEFAULT_DURATION /* 2352003 */:
                    getCurrentTrack(i).defaultSampleDurationNs = (int) j;
                    return;
                case ID_TIMECODE_SCALE /* 2807729 */:
                    this.timecodeScale = j;
                    return;
                default:
                    switch (i) {
                        case ID_COLOUR_RANGE /* 21945 */:
                            assertInTrackEntry(i);
                            int i5 = (int) j;
                            if (i5 == 1) {
                                this.currentTrack.colorRange = 2;
                                return;
                            } else if (i5 != 2) {
                                return;
                            } else {
                                this.currentTrack.colorRange = 1;
                                return;
                            }
                        case ID_COLOUR_TRANSFER /* 21946 */:
                            assertInTrackEntry(i);
                            int isoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer((int) j);
                            if (isoTransferCharacteristicsToColorTransfer != -1) {
                                this.currentTrack.colorTransfer = isoTransferCharacteristicsToColorTransfer;
                                return;
                            }
                            return;
                        case ID_COLOUR_PRIMARIES /* 21947 */:
                            assertInTrackEntry(i);
                            this.currentTrack.hasColorInfo = true;
                            int isoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace((int) j);
                            if (isoColorPrimariesToColorSpace != -1) {
                                this.currentTrack.colorSpace = isoColorPrimariesToColorSpace;
                                return;
                            }
                            return;
                        case ID_MAX_CLL /* 21948 */:
                            getCurrentTrack(i).maxContentLuminance = (int) j;
                            return;
                        case ID_MAX_FALL /* 21949 */:
                            getCurrentTrack(i).maxFrameAverageLuminance = (int) j;
                            return;
                        default:
                            return;
                    }
            }
        }
    }

    protected void floatElement(int i, double d) throws ParserException {
        if (i == ID_SAMPLING_FREQUENCY) {
            getCurrentTrack(i).sampleRate = (int) d;
        } else if (i == ID_DURATION) {
            this.durationTimecode = (long) d;
        } else {
            switch (i) {
                case ID_PRIMARY_R_CHROMATICITY_X /* 21969 */:
                    getCurrentTrack(i).primaryRChromaticityX = (float) d;
                    return;
                case ID_PRIMARY_R_CHROMATICITY_Y /* 21970 */:
                    getCurrentTrack(i).primaryRChromaticityY = (float) d;
                    return;
                case ID_PRIMARY_G_CHROMATICITY_X /* 21971 */:
                    getCurrentTrack(i).primaryGChromaticityX = (float) d;
                    return;
                case ID_PRIMARY_G_CHROMATICITY_Y /* 21972 */:
                    getCurrentTrack(i).primaryGChromaticityY = (float) d;
                    return;
                case ID_PRIMARY_B_CHROMATICITY_X /* 21973 */:
                    getCurrentTrack(i).primaryBChromaticityX = (float) d;
                    return;
                case ID_PRIMARY_B_CHROMATICITY_Y /* 21974 */:
                    getCurrentTrack(i).primaryBChromaticityY = (float) d;
                    return;
                case ID_WHITE_POINT_CHROMATICITY_X /* 21975 */:
                    getCurrentTrack(i).whitePointChromaticityX = (float) d;
                    return;
                case ID_WHITE_POINT_CHROMATICITY_Y /* 21976 */:
                    getCurrentTrack(i).whitePointChromaticityY = (float) d;
                    return;
                case ID_LUMNINANCE_MAX /* 21977 */:
                    getCurrentTrack(i).maxMasteringLuminance = (float) d;
                    return;
                case ID_LUMNINANCE_MIN /* 21978 */:
                    getCurrentTrack(i).minMasteringLuminance = (float) d;
                    return;
                default:
                    switch (i) {
                        case ID_PROJECTION_POSE_YAW /* 30323 */:
                            getCurrentTrack(i).projectionPoseYaw = (float) d;
                            return;
                        case ID_PROJECTION_POSE_PITCH /* 30324 */:
                            getCurrentTrack(i).projectionPosePitch = (float) d;
                            return;
                        case ID_PROJECTION_POSE_ROLL /* 30325 */:
                            getCurrentTrack(i).projectionPoseRoll = (float) d;
                            return;
                        default:
                            return;
                    }
            }
        }
    }

    protected void stringElement(int i, String str) throws ParserException {
        if (i == 134) {
            getCurrentTrack(i).codecId = str;
        } else if (i == 17026) {
            if (!DOC_TYPE_WEBM.equals(str) && !DOC_TYPE_MATROSKA.equals(str)) {
                throw ParserException.createForMalformedContainer("DocType " + str + " not supported", null);
            }
            this.isWebm = Objects.equals(str, DOC_TYPE_WEBM);
        } else if (i == ID_NAME) {
            getCurrentTrack(i).name = str;
        } else if (i != ID_LANGUAGE) {
        } else {
            getCurrentTrack(i).language = str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x0253, code lost:
        throw androidx.media3.common.ParserException.createForMalformedContainer("EBML lacing sample size out of range.", null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void binaryElement(int i, int i2, ExtractorInput extractorInput) throws IOException {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        long j;
        int i9;
        int[] iArr;
        int i10;
        int i11;
        int i12 = 2;
        int i13 = 0;
        int i14 = 1;
        if (i != ID_BLOCK && i != ID_SIMPLE_BLOCK) {
            if (i == ID_BLOCK_ADDITIONAL) {
                if (this.blockState != 2) {
                    return;
                }
                handleBlockAdditionalData(this.tracks.get(this.blockTrackNumber), this.blockAdditionalId, extractorInput, i2);
                return;
            } else if (i == ID_BLOCK_ADD_ID_EXTRA_DATA) {
                handleBlockAddIDExtraData(getCurrentTrack(i), extractorInput, i2);
                return;
            } else if (i == ID_CONTENT_COMPRESSION_SETTINGS) {
                assertInTrackEntry(i);
                this.currentTrack.sampleStrippedBytes = new byte[i2];
                extractorInput.readFully(this.currentTrack.sampleStrippedBytes, 0, i2);
                return;
            } else if (i == ID_CONTENT_ENCRYPTION_KEY_ID) {
                byte[] bArr = new byte[i2];
                extractorInput.readFully(bArr, 0, i2);
                getCurrentTrack(i).cryptoData = new TrackOutput.CryptoData(1, bArr, 0, 0);
                return;
            } else if (i == ID_SEEK_ID) {
                Arrays.fill(this.seekEntryIdBytes.getData(), (byte) 0);
                extractorInput.readFully(this.seekEntryIdBytes.getData(), 4 - i2, i2);
                this.seekEntryIdBytes.setPosition(0);
                this.seekEntryId = (int) this.seekEntryIdBytes.readUnsignedInt();
                return;
            } else if (i == ID_CODEC_PRIVATE) {
                assertInTrackEntry(i);
                this.currentTrack.codecPrivate = new byte[i2];
                extractorInput.readFully(this.currentTrack.codecPrivate, 0, i2);
                return;
            } else if (i == ID_PROJECTION_PRIVATE) {
                assertInTrackEntry(i);
                this.currentTrack.projectionData = new byte[i2];
                extractorInput.readFully(this.currentTrack.projectionData, 0, i2);
                return;
            } else {
                throw ParserException.createForMalformedContainer("Unexpected id: " + i, null);
            }
        }
        int i15 = 8;
        if (this.blockState == 0) {
            this.blockTrackNumber = (int) this.varintReader.readUnsignedVarint(extractorInput, false, true, 8);
            this.blockTrackNumberLength = this.varintReader.getLastLength();
            this.blockDurationUs = C.TIME_UNSET;
            this.blockState = 1;
            this.scratch.reset(0);
        }
        Track track = this.tracks.get(this.blockTrackNumber);
        if (track == null) {
            extractorInput.skipFully(i2 - this.blockTrackNumberLength);
            this.blockState = 0;
            return;
        }
        track.assertOutputInitialized();
        if (this.blockState == 1) {
            readScratch(extractorInput, 3);
            int i16 = (this.scratch.getData()[2] & 6) >> 1;
            if (i16 == 0) {
                this.blockSampleCount = 1;
                int[] ensureArrayCapacity = ensureArrayCapacity(this.blockSampleSizes, 1);
                this.blockSampleSizes = ensureArrayCapacity;
                ensureArrayCapacity[0] = (i2 - this.blockTrackNumberLength) - 3;
            } else {
                readScratch(extractorInput, 4);
                int i17 = (this.scratch.getData()[3] & 255) + 1;
                this.blockSampleCount = i17;
                int[] ensureArrayCapacity2 = ensureArrayCapacity(this.blockSampleSizes, i17);
                this.blockSampleSizes = ensureArrayCapacity2;
                if (i16 == 2) {
                    int i18 = this.blockSampleCount;
                    Arrays.fill(ensureArrayCapacity2, 0, i18, ((i2 - this.blockTrackNumberLength) - 4) / i18);
                } else if (i16 == 1) {
                    int i19 = 0;
                    int i20 = 0;
                    int i21 = 4;
                    while (true) {
                        i9 = this.blockSampleCount;
                        int i22 = i9 - 1;
                        i4 = i13;
                        iArr = this.blockSampleSizes;
                        if (i19 >= i22) {
                            break;
                        }
                        iArr[i19] = i4;
                        while (true) {
                            i10 = i21 + 1;
                            readScratch(extractorInput, i10);
                            int i23 = this.scratch.getData()[i21] & 255;
                            int[] iArr2 = this.blockSampleSizes;
                            i11 = iArr2[i19] + i23;
                            iArr2[i19] = i11;
                            if (i23 != 255) {
                                break;
                            }
                            i21 = i10;
                        }
                        i20 += i11;
                        i19++;
                        i21 = i10;
                        i13 = i4;
                    }
                    iArr[i9 - 1] = ((i2 - this.blockTrackNumberLength) - i21) - i20;
                    i5 = 2;
                    i6 = 1;
                    this.blockTimeUs = this.clusterTimecodeUs + scaleTimecodeToUs((this.scratch.getData()[i4] << 8) | (this.scratch.getData()[i6] & 255));
                    this.blockFlags = (track.type != i6 || (i == ID_SIMPLE_BLOCK && (this.scratch.getData()[i5] & 128) == 128)) ? 1 : i4;
                    this.blockState = i5;
                    this.blockSampleIndex = i4;
                    i3 = ID_SIMPLE_BLOCK;
                } else {
                    i4 = 0;
                    if (i16 != 3) {
                        throw ParserException.createForMalformedContainer("Unexpected lacing value: " + i16, null);
                    }
                    int i24 = 4;
                    int i25 = 0;
                    int i26 = 0;
                    while (true) {
                        int i27 = this.blockSampleCount;
                        int i28 = i27 - 1;
                        i5 = i12;
                        int[] iArr3 = this.blockSampleSizes;
                        if (i25 < i28) {
                            iArr3[i25] = 0;
                            int i29 = i24 + 1;
                            readScratch(extractorInput, i29);
                            if (this.scratch.getData()[i24] == 0) {
                                throw ParserException.createForMalformedContainer("No valid varint length mask found", null);
                            }
                            int i30 = 0;
                            while (true) {
                                if (i30 >= i15) {
                                    i7 = i14;
                                    i8 = i15;
                                    j = 0;
                                    break;
                                }
                                int i31 = i14 << (7 - i30);
                                i8 = i15;
                                if ((this.scratch.getData()[i24] & i31) != 0) {
                                    i29 += i30;
                                    readScratch(extractorInput, i29);
                                    int i32 = i24 + 1;
                                    j = this.scratch.getData()[i24] & 255 & (~i31);
                                    int i33 = i32;
                                    while (i33 < i29) {
                                        j = (j << i8) | (this.scratch.getData()[i33] & 255);
                                        i33++;
                                        i14 = i14;
                                    }
                                    i7 = i14;
                                    if (i25 > 0) {
                                        j -= (1 << ((i30 * 7) + 6)) - 1;
                                    }
                                } else {
                                    i30++;
                                    i15 = i8;
                                }
                            }
                            if (j < SieveCacheKt.NodeMetaAndPreviousMask || j > SieveCacheKt.NodeLinkMask) {
                                break;
                            }
                            int i34 = (int) j;
                            int[] iArr4 = this.blockSampleSizes;
                            if (i25 != 0) {
                                i34 += iArr4[i25 - 1];
                            }
                            iArr4[i25] = i34;
                            i26 += i34;
                            i25++;
                            i24 = i29;
                            i12 = i5;
                            i15 = i8;
                            i14 = i7;
                        } else {
                            i6 = i14;
                            iArr3[i27 - 1] = ((i2 - this.blockTrackNumberLength) - i24) - i26;
                            break;
                        }
                    }
                }
            }
            i5 = 2;
            i4 = 0;
            i6 = 1;
            this.blockTimeUs = this.clusterTimecodeUs + scaleTimecodeToUs((this.scratch.getData()[i4] << 8) | (this.scratch.getData()[i6] & 255));
            this.blockFlags = (track.type != i6 || (i == ID_SIMPLE_BLOCK && (this.scratch.getData()[i5] & 128) == 128)) ? 1 : i4;
            this.blockState = i5;
            this.blockSampleIndex = i4;
            i3 = ID_SIMPLE_BLOCK;
        } else {
            i3 = ID_SIMPLE_BLOCK;
        }
        if (i == i3) {
            while (true) {
                int i35 = this.blockSampleIndex;
                if (i35 < this.blockSampleCount) {
                    int writeSampleData = writeSampleData(extractorInput, track, this.blockSampleSizes[i35], false);
                    Track track2 = track;
                    commitSampleToOutput(track2, this.blockTimeUs + ((this.blockSampleIndex * track.defaultSampleDurationNs) / 1000), this.blockFlags, writeSampleData, 0);
                    this.blockSampleIndex++;
                    track = track2;
                } else {
                    this.blockState = 0;
                    return;
                }
            }
        } else {
            while (true) {
                int i36 = this.blockSampleIndex;
                if (i36 >= this.blockSampleCount) {
                    return;
                }
                int[] iArr5 = this.blockSampleSizes;
                iArr5[i36] = writeSampleData(extractorInput, track, iArr5[i36], true);
                this.blockSampleIndex++;
            }
        }
    }

    protected void handleBlockAddIDExtraData(Track track, ExtractorInput extractorInput, int i) throws IOException {
        if (track.blockAddIdType == 1685485123 || track.blockAddIdType == 1685480259) {
            track.dolbyVisionConfigBytes = new byte[i];
            extractorInput.readFully(track.dolbyVisionConfigBytes, 0, i);
            return;
        }
        extractorInput.skipFully(i);
    }

    protected void handleBlockAdditionalData(Track track, int i, ExtractorInput extractorInput, int i2) throws IOException {
        if (i == 4 && CODEC_ID_VP9.equals(track.codecId)) {
            this.supplementalData.reset(i2);
            extractorInput.readFully(this.supplementalData.getData(), 0, i2);
            return;
        }
        extractorInput.skipFully(i2);
    }

    @EnsuresNonNull({"currentTrack"})
    private void assertInTrackEntry(int i) throws ParserException {
        if (this.currentTrack == null) {
            throw ParserException.createForMalformedContainer("Element " + i + " must be in a TrackEntry", null);
        }
    }

    private void assertInCues(int i) throws ParserException {
        if (!this.inCuesElement) {
            throw ParserException.createForMalformedContainer("Element " + i + " must be in a Cues", null);
        }
    }

    protected Track getCurrentTrack(int i) throws ParserException {
        assertInTrackEntry(i);
        return this.currentTrack;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00aa  */
    @RequiresNonNull({"#1.output"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void commitSampleToOutput(Track track, long j, int i, int i2, int i3) {
        int limit;
        if (track.trueHdSampleRechunker != null) {
            track.trueHdSampleRechunker.sampleMetadata(track.output, j, i, i2, i3, track.cryptoData);
        } else {
            if (CODEC_ID_SUBRIP.equals(track.codecId) || CODEC_ID_ASS.equals(track.codecId) || CODEC_ID_SSA.equals(track.codecId) || CODEC_ID_VTT.equals(track.codecId)) {
                if (this.blockSampleCount > 1) {
                    Log.w(TAG, "Skipping subtitle sample in laced block.");
                } else if (this.blockDurationUs == C.TIME_UNSET) {
                    Log.w(TAG, "Skipping subtitle sample with no duration.");
                } else {
                    setSubtitleEndTime(track.codecId, this.blockDurationUs, this.subtitleSample.getData());
                    int position = this.subtitleSample.getPosition();
                    while (true) {
                        if (position >= this.subtitleSample.limit()) {
                            break;
                        } else if (this.subtitleSample.getData()[position] == 0) {
                            this.subtitleSample.setLimit(position);
                            break;
                        } else {
                            position++;
                        }
                    }
                    TrackOutput trackOutput = track.output;
                    ParsableByteArray parsableByteArray = this.subtitleSample;
                    trackOutput.sampleData(parsableByteArray, parsableByteArray.limit());
                    limit = i2 + this.subtitleSample.limit();
                    if ((i & 268435456) != 0) {
                        int i4 = this.blockSampleCount;
                        ParsableByteArray parsableByteArray2 = this.supplementalData;
                        if (i4 > 1) {
                            parsableByteArray2.reset(0);
                        } else {
                            int limit2 = parsableByteArray2.limit();
                            track.output.sampleData(this.supplementalData, limit2, 2);
                            limit += limit2;
                        }
                    }
                    track.output.sampleMetadata(j, i, limit, i3, track.cryptoData);
                }
            }
            limit = i2;
            if ((i & 268435456) != 0) {
            }
            track.output.sampleMetadata(j, i, limit, i3, track.cryptoData);
        }
        this.haveOutputSample = true;
    }

    private void readScratch(ExtractorInput extractorInput, int i) throws IOException {
        if (this.scratch.limit() >= i) {
            return;
        }
        if (this.scratch.capacity() < i) {
            ParsableByteArray parsableByteArray = this.scratch;
            parsableByteArray.ensureCapacity(Math.max(parsableByteArray.capacity() * 2, i));
        }
        extractorInput.readFully(this.scratch.getData(), this.scratch.limit(), i - this.scratch.limit());
        this.scratch.setLimit(i);
    }

    @RequiresNonNull({"#2.output"})
    private int writeSampleData(ExtractorInput extractorInput, Track track, int i, boolean z) throws IOException {
        int i2;
        if (CODEC_ID_SUBRIP.equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SUBRIP_PREFIX, i);
            return finishWriteSampleData();
        } else if (CODEC_ID_ASS.equals(track.codecId) || CODEC_ID_SSA.equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SSA_PREFIX, i);
            return finishWriteSampleData();
        } else if (CODEC_ID_VTT.equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, VTT_PREFIX, i);
            return finishWriteSampleData();
        } else {
            if (track.waitingForDtsAnalysis) {
                Preconditions.checkNotNull(track.format);
                if (DtsUtil.isSampleDtsHd(extractorInput, i)) {
                    track.format = track.format.buildUpon().setSampleMimeType(MimeTypes.AUDIO_DTS_HD).build();
                }
                track.output.format(track.format);
                track.waitingForDtsAnalysis = false;
                maybeEndTracks();
            }
            TrackOutput trackOutput = track.output;
            if (!this.sampleEncodingHandled) {
                if (track.hasContentEncryption) {
                    this.blockFlags &= -1073741825;
                    if (!this.sampleSignalByteRead) {
                        extractorInput.readFully(this.scratch.getData(), 0, 1);
                        this.sampleBytesRead++;
                        if ((this.scratch.getData()[0] & 128) == 128) {
                            throw ParserException.createForMalformedContainer("Extension bit is set in signal byte", null);
                        }
                        this.sampleSignalByte = this.scratch.getData()[0];
                        this.sampleSignalByteRead = true;
                    }
                    byte b = this.sampleSignalByte;
                    if ((b & 1) == 1) {
                        boolean z2 = (b & 2) == 2;
                        this.blockFlags |= 1073741824;
                        if (!this.sampleInitializationVectorRead) {
                            extractorInput.readFully(this.encryptionInitializationVector.getData(), 0, 8);
                            this.sampleBytesRead += 8;
                            this.sampleInitializationVectorRead = true;
                            this.scratch.getData()[0] = (byte) ((z2 ? 128 : 0) | 8);
                            this.scratch.setPosition(0);
                            trackOutput.sampleData(this.scratch, 1, 1);
                            this.sampleBytesWritten++;
                            this.encryptionInitializationVector.setPosition(0);
                            trackOutput.sampleData(this.encryptionInitializationVector, 8, 1);
                            this.sampleBytesWritten += 8;
                        }
                        if (z2) {
                            if (!this.samplePartitionCountRead) {
                                extractorInput.readFully(this.scratch.getData(), 0, 1);
                                this.sampleBytesRead++;
                                this.scratch.setPosition(0);
                                this.samplePartitionCount = this.scratch.readUnsignedByte();
                                this.samplePartitionCountRead = true;
                            }
                            int i3 = this.samplePartitionCount * 4;
                            this.scratch.reset(i3);
                            extractorInput.readFully(this.scratch.getData(), 0, i3);
                            this.sampleBytesRead += i3;
                            short s = (short) ((this.samplePartitionCount / 2) + 1);
                            int i4 = (s * 6) + 2;
                            ByteBuffer byteBuffer = this.encryptionSubsampleDataBuffer;
                            if (byteBuffer == null || byteBuffer.capacity() < i4) {
                                this.encryptionSubsampleDataBuffer = ByteBuffer.allocate(i4);
                            }
                            this.encryptionSubsampleDataBuffer.position(0);
                            this.encryptionSubsampleDataBuffer.putShort(s);
                            int i5 = 0;
                            int i6 = 0;
                            while (true) {
                                i2 = this.samplePartitionCount;
                                if (i5 >= i2) {
                                    break;
                                }
                                int readUnsignedIntToInt = this.scratch.readUnsignedIntToInt();
                                int i7 = i5 % 2;
                                ByteBuffer byteBuffer2 = this.encryptionSubsampleDataBuffer;
                                if (i7 == 0) {
                                    byteBuffer2.putShort((short) (readUnsignedIntToInt - i6));
                                } else {
                                    byteBuffer2.putInt(readUnsignedIntToInt - i6);
                                }
                                i5++;
                                i6 = readUnsignedIntToInt;
                            }
                            int i8 = (i - this.sampleBytesRead) - i6;
                            int i9 = i2 % 2;
                            ByteBuffer byteBuffer3 = this.encryptionSubsampleDataBuffer;
                            if (i9 == 1) {
                                byteBuffer3.putInt(i8);
                            } else {
                                byteBuffer3.putShort((short) i8);
                                this.encryptionSubsampleDataBuffer.putInt(0);
                            }
                            this.encryptionSubsampleData.reset(this.encryptionSubsampleDataBuffer.array(), i4);
                            trackOutput.sampleData(this.encryptionSubsampleData, i4, 1);
                            this.sampleBytesWritten += i4;
                        }
                    }
                } else if (track.sampleStrippedBytes != null) {
                    this.sampleStrippedBytes.reset(track.sampleStrippedBytes, track.sampleStrippedBytes.length);
                }
                if (track.samplesHaveSupplementalData(z)) {
                    this.blockFlags |= 268435456;
                    this.supplementalData.reset(0);
                    int limit = (this.sampleStrippedBytes.limit() + i) - this.sampleBytesRead;
                    this.scratch.reset(4);
                    this.scratch.getData()[0] = (byte) ((limit >> 24) & 255);
                    this.scratch.getData()[1] = (byte) ((limit >> 16) & 255);
                    this.scratch.getData()[2] = (byte) ((limit >> 8) & 255);
                    this.scratch.getData()[3] = (byte) (limit & 255);
                    trackOutput.sampleData(this.scratch, 4, 2);
                    this.sampleBytesWritten += 4;
                }
                this.sampleEncodingHandled = true;
            }
            int limit2 = i + this.sampleStrippedBytes.limit();
            if (CODEC_ID_H264.equals(track.codecId) || CODEC_ID_H265.equals(track.codecId)) {
                byte[] data = this.nalLength.getData();
                data[0] = 0;
                data[1] = 0;
                data[2] = 0;
                int i10 = track.nalUnitLengthFieldLength;
                int i11 = 4 - track.nalUnitLengthFieldLength;
                while (this.sampleBytesRead < limit2) {
                    int i12 = this.sampleCurrentNalBytesRemaining;
                    if (i12 == 0) {
                        writeToTarget(extractorInput, data, i11, i10);
                        this.sampleBytesRead += i10;
                        this.nalLength.setPosition(0);
                        this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
                        this.nalStartCode.setPosition(0);
                        trackOutput.sampleData(this.nalStartCode, 4);
                        this.sampleBytesWritten += 4;
                    } else {
                        int writeToOutput = writeToOutput(extractorInput, trackOutput, i12);
                        this.sampleBytesRead += writeToOutput;
                        this.sampleBytesWritten += writeToOutput;
                        this.sampleCurrentNalBytesRemaining -= writeToOutput;
                    }
                }
            } else {
                if (track.trueHdSampleRechunker != null) {
                    Preconditions.checkState(this.sampleStrippedBytes.limit() == 0);
                    track.trueHdSampleRechunker.startSample(extractorInput);
                }
                while (true) {
                    int i13 = this.sampleBytesRead;
                    if (i13 >= limit2) {
                        break;
                    }
                    int writeToOutput2 = writeToOutput(extractorInput, trackOutput, limit2 - i13);
                    this.sampleBytesRead += writeToOutput2;
                    this.sampleBytesWritten += writeToOutput2;
                }
            }
            if (CODEC_ID_VORBIS.equals(track.codecId)) {
                this.vorbisNumPageSamples.setPosition(0);
                trackOutput.sampleData(this.vorbisNumPageSamples, 4);
                this.sampleBytesWritten += 4;
            }
            return finishWriteSampleData();
        }
    }

    private int finishWriteSampleData() {
        int i = this.sampleBytesWritten;
        resetWriteSampleData();
        return i;
    }

    private void resetWriteSampleData() {
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        this.sampleEncodingHandled = false;
        this.sampleSignalByteRead = false;
        this.samplePartitionCountRead = false;
        this.samplePartitionCount = 0;
        this.sampleSignalByte = (byte) 0;
        this.sampleInitializationVectorRead = false;
        this.sampleStrippedBytes.reset(0);
    }

    private void writeSubtitleSampleData(ExtractorInput extractorInput, byte[] bArr, int i) throws IOException {
        int length = bArr.length + i;
        int capacity = this.subtitleSample.capacity();
        ParsableByteArray parsableByteArray = this.subtitleSample;
        if (capacity < length) {
            parsableByteArray.reset(Arrays.copyOf(bArr, length + i));
        } else {
            System.arraycopy(bArr, 0, parsableByteArray.getData(), 0, bArr.length);
        }
        extractorInput.readFully(this.subtitleSample.getData(), bArr.length, i);
        this.subtitleSample.setPosition(0);
        this.subtitleSample.setLimit(length);
    }

    private static void setSubtitleEndTime(String str, long j, byte[] bArr) {
        byte[] formatSubtitleTimecode;
        int i;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 738597099:
                if (str.equals(CODEC_ID_ASS)) {
                    c = 0;
                    break;
                }
                break;
            case 738614379:
                if (str.equals(CODEC_ID_SSA)) {
                    c = 1;
                    break;
                }
                break;
            case 1045209816:
                if (str.equals(CODEC_ID_VTT)) {
                    c = 2;
                    break;
                }
                break;
            case 1422270023:
                if (str.equals(CODEC_ID_SUBRIP)) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                formatSubtitleTimecode = formatSubtitleTimecode(j, SSA_TIMECODE_FORMAT, 10000L);
                i = 21;
                break;
            case 2:
                formatSubtitleTimecode = formatSubtitleTimecode(j, VTT_TIMECODE_FORMAT, 1000L);
                i = 25;
                break;
            case 3:
                formatSubtitleTimecode = formatSubtitleTimecode(j, SUBRIP_TIMECODE_FORMAT, 1000L);
                i = 19;
                break;
            default:
                throw new IllegalArgumentException();
        }
        System.arraycopy(formatSubtitleTimecode, 0, bArr, i, formatSubtitleTimecode.length);
    }

    private static byte[] formatSubtitleTimecode(long j, String str, long j2) {
        Preconditions.checkArgument(j != C.TIME_UNSET);
        int i = (int) (j / 3600000000L);
        long j3 = j - (i * 3600000000L);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - (i2 * 60000000);
        int i3 = (int) (j4 / 1000000);
        return Util.getUtf8Bytes(String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (i3 * 1000000)) / j2))));
    }

    private void writeToTarget(ExtractorInput extractorInput, byte[] bArr, int i, int i2) throws IOException {
        int min = Math.min(i2, this.sampleStrippedBytes.bytesLeft());
        extractorInput.readFully(bArr, i + min, i2 - min);
        if (min > 0) {
            this.sampleStrippedBytes.readBytes(bArr, i, min);
        }
    }

    private int writeToOutput(ExtractorInput extractorInput, TrackOutput trackOutput, int i) throws IOException {
        int bytesLeft = this.sampleStrippedBytes.bytesLeft();
        if (bytesLeft > 0) {
            int min = Math.min(i, bytesLeft);
            trackOutput.sampleData(this.sampleStrippedBytes, min);
            return min;
        }
        return trackOutput.sampleData((DataReader) extractorInput, i, false);
    }

    private boolean maybeSeekForCues(PositionHolder positionHolder, long j) {
        if (this.seekForCues) {
            this.seekPositionAfterBuildingCues = j;
            positionHolder.position = this.cuesContentPosition;
            this.seekForCues = false;
            return true;
        }
        if (this.sentSeekMap) {
            long j2 = this.seekPositionAfterBuildingCues;
            if (j2 != -1) {
                positionHolder.position = j2;
                this.seekPositionAfterBuildingCues = -1L;
                return true;
            }
        }
        return false;
    }

    private long scaleTimecodeToUs(long j) throws ParserException {
        long j2 = this.timecodeScale;
        if (j2 == C.TIME_UNSET) {
            throw ParserException.createForMalformedContainer("Can't scale timecode prior to timecodeScale being set.", null);
        }
        return Util.scaleLargeTimestamp(j, j2, 1000L);
    }

    private static boolean isCodecSupported(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2095576542:
                if (str.equals(CODEC_ID_MPEG4_AP)) {
                    c = 0;
                    break;
                }
                break;
            case -2095575984:
                if (str.equals(CODEC_ID_MPEG4_SP)) {
                    c = 1;
                    break;
                }
                break;
            case -1985379776:
                if (str.equals(CODEC_ID_ACM)) {
                    c = 2;
                    break;
                }
                break;
            case -1784763192:
                if (str.equals(CODEC_ID_TRUEHD)) {
                    c = 3;
                    break;
                }
                break;
            case -1730367663:
                if (str.equals(CODEC_ID_VORBIS)) {
                    c = 4;
                    break;
                }
                break;
            case -1482641358:
                if (str.equals(CODEC_ID_MP2)) {
                    c = 5;
                    break;
                }
                break;
            case -1482641357:
                if (str.equals(CODEC_ID_MP3)) {
                    c = 6;
                    break;
                }
                break;
            case -1373388978:
                if (str.equals(CODEC_ID_FOURCC)) {
                    c = 7;
                    break;
                }
                break;
            case -933872740:
                if (str.equals(CODEC_ID_DVBSUB)) {
                    c = '\b';
                    break;
                }
                break;
            case -538363189:
                if (str.equals(CODEC_ID_MPEG4_ASP)) {
                    c = '\t';
                    break;
                }
                break;
            case -538363109:
                if (str.equals(CODEC_ID_H264)) {
                    c = '\n';
                    break;
                }
                break;
            case -425012669:
                if (str.equals(CODEC_ID_VOBSUB)) {
                    c = 11;
                    break;
                }
                break;
            case -356037306:
                if (str.equals(CODEC_ID_DTS_LOSSLESS)) {
                    c = '\f';
                    break;
                }
                break;
            case 62923557:
                if (str.equals(CODEC_ID_AAC)) {
                    c = '\r';
                    break;
                }
                break;
            case 62923603:
                if (str.equals(CODEC_ID_AC3)) {
                    c = 14;
                    break;
                }
                break;
            case 62927045:
                if (str.equals(CODEC_ID_DTS)) {
                    c = 15;
                    break;
                }
                break;
            case 82318131:
                if (str.equals(CODEC_ID_AV1)) {
                    c = 16;
                    break;
                }
                break;
            case 82338133:
                if (str.equals(CODEC_ID_VP8)) {
                    c = 17;
                    break;
                }
                break;
            case 82338134:
                if (str.equals(CODEC_ID_VP9)) {
                    c = 18;
                    break;
                }
                break;
            case 99146302:
                if (str.equals(CODEC_ID_PGS)) {
                    c = 19;
                    break;
                }
                break;
            case 444813526:
                if (str.equals(CODEC_ID_THEORA)) {
                    c = 20;
                    break;
                }
                break;
            case 542569478:
                if (str.equals(CODEC_ID_DTS_EXPRESS)) {
                    c = 21;
                    break;
                }
                break;
            case 635596514:
                if (str.equals(CODEC_ID_PCM_FLOAT)) {
                    c = 22;
                    break;
                }
                break;
            case 725948237:
                if (str.equals(CODEC_ID_PCM_INT_BIG)) {
                    c = 23;
                    break;
                }
                break;
            case 725957860:
                if (str.equals(CODEC_ID_PCM_INT_LIT)) {
                    c = 24;
                    break;
                }
                break;
            case 738597099:
                if (str.equals(CODEC_ID_ASS)) {
                    c = 25;
                    break;
                }
                break;
            case 738614379:
                if (str.equals(CODEC_ID_SSA)) {
                    c = 26;
                    break;
                }
                break;
            case 855502857:
                if (str.equals(CODEC_ID_H265)) {
                    c = 27;
                    break;
                }
                break;
            case 1045209816:
                if (str.equals(CODEC_ID_VTT)) {
                    c = 28;
                    break;
                }
                break;
            case 1422270023:
                if (str.equals(CODEC_ID_SUBRIP)) {
                    c = 29;
                    break;
                }
                break;
            case 1809237540:
                if (str.equals(CODEC_ID_MPEG2)) {
                    c = 30;
                    break;
                }
                break;
            case 1950749482:
                if (str.equals(CODEC_ID_E_AC3)) {
                    c = 31;
                    break;
                }
                break;
            case 1950789798:
                if (str.equals(CODEC_ID_FLAC)) {
                    c = ' ';
                    break;
                }
                break;
            case 1951062397:
                if (str.equals(CODEC_ID_OPUS)) {
                    c = '!';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\b':
            case '\t':
            case '\n':
            case 11:
            case '\f':
            case '\r':
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case ' ':
            case '!':
                return true;
            default:
                return false;
        }
    }

    private static int[] ensureArrayCapacity(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        return iArr.length >= i ? iArr : new int[Math.max(iArr.length * 2, i)];
    }

    @EnsuresNonNull({"extractorOutput"})
    private void assertInitialized() {
        Preconditions.checkNotNull(this.extractorOutput);
    }

    private void maybeEndTracks() {
        if (this.pendingEndTracks) {
            for (int i = 0; i < this.tracks.size(); i++) {
                if (this.tracks.valueAt(i).waitingForDtsAnalysis) {
                    return;
                }
            }
            ((ExtractorOutput) Preconditions.checkNotNull(this.extractorOutput)).endTracks();
            this.pendingEndTracks = false;
        }
    }

    /* loaded from: classes3.dex */
    private final class InnerEbmlProcessor implements EbmlProcessor {
        private InnerEbmlProcessor() {
        }

        @Override // androidx.media3.extractor.mkv.EbmlProcessor
        public int getElementType(int i) {
            return MatroskaExtractor.this.getElementType(i);
        }

        @Override // androidx.media3.extractor.mkv.EbmlProcessor
        public boolean isLevel1Element(int i) {
            return MatroskaExtractor.this.isLevel1Element(i);
        }

        @Override // androidx.media3.extractor.mkv.EbmlProcessor
        public void startMasterElement(int i, long j, long j2) throws ParserException {
            MatroskaExtractor.this.startMasterElement(i, j, j2);
        }

        @Override // androidx.media3.extractor.mkv.EbmlProcessor
        public void endMasterElement(int i) throws ParserException {
            MatroskaExtractor.this.endMasterElement(i);
        }

        @Override // androidx.media3.extractor.mkv.EbmlProcessor
        public void integerElement(int i, long j) throws ParserException {
            MatroskaExtractor.this.integerElement(i, j);
        }

        @Override // androidx.media3.extractor.mkv.EbmlProcessor
        public void floatElement(int i, double d) throws ParserException {
            MatroskaExtractor.this.floatElement(i, d);
        }

        @Override // androidx.media3.extractor.mkv.EbmlProcessor
        public void stringElement(int i, String str) throws ParserException {
            MatroskaExtractor.this.stringElement(i, str);
        }

        @Override // androidx.media3.extractor.mkv.EbmlProcessor
        public void binaryElement(int i, int i2, ExtractorInput extractorInput) throws IOException {
            MatroskaExtractor.this.binaryElement(i, i2, extractorInput);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public static final class Track {
        private static final int DEFAULT_MAX_CLL = 1000;
        private static final int DEFAULT_MAX_FALL = 200;
        private static final int DISPLAY_UNIT_PIXELS = 0;
        private static final int MAX_CHROMATICITY = 50000;
        private int blockAddIdType;
        public String codecId;
        public byte[] codecPrivate;
        public TrackOutput.CryptoData cryptoData;
        public int defaultSampleDurationNs;
        public byte[] dolbyVisionConfigBytes;
        public DrmInitData drmInitData;
        public boolean flagForced;
        public Format format;
        public boolean hasContentEncryption;
        public boolean isWebm;
        public int maxBlockAdditionId;
        public int nalUnitLengthFieldLength;
        public String name;
        public int number;
        public TrackOutput output;
        public byte[] sampleStrippedBytes;
        public TrueHdSampleRechunker trueHdSampleRechunker;
        public int type;
        public int width = -1;
        public int height = -1;
        public int bitsPerChannel = -1;
        public int displayWidth = -1;
        public int displayHeight = -1;
        public int displayUnit = 0;
        public int projectionType = -1;
        public float projectionPoseYaw = 0.0f;
        public float projectionPosePitch = 0.0f;
        public float projectionPoseRoll = 0.0f;
        public byte[] projectionData = null;
        public int stereoMode = -1;
        public boolean hasColorInfo = false;
        public int colorSpace = -1;
        public int colorTransfer = -1;
        public int colorRange = -1;
        public int maxContentLuminance = 1000;
        public int maxFrameAverageLuminance = 200;
        public float primaryRChromaticityX = -1.0f;
        public float primaryRChromaticityY = -1.0f;
        public float primaryGChromaticityX = -1.0f;
        public float primaryGChromaticityY = -1.0f;
        public float primaryBChromaticityX = -1.0f;
        public float primaryBChromaticityY = -1.0f;
        public float whitePointChromaticityX = -1.0f;
        public float whitePointChromaticityY = -1.0f;
        public float maxMasteringLuminance = -1.0f;
        public float minMasteringLuminance = -1.0f;
        public int channelCount = 1;
        public int audioBitDepth = -1;
        public int sampleRate = 8000;
        public long codecDelayNs = 0;
        public long seekPreRollNs = 0;
        public boolean waitingForDtsAnalysis = false;
        public boolean flagDefault = true;
        private String language = "eng";

        protected Track() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @RequiresNonNull({"codecId"})
        public void initializeFormat(int i) throws ParserException {
            char c;
            int i2;
            List<byte[]> singletonList;
            String str;
            int i3;
            List<byte[]> list;
            String str2;
            int i4;
            int i5;
            int i6;
            int i7;
            DolbyVisionConfig parse;
            String str3 = this.codecId;
            str3.hashCode();
            int i8 = 3;
            switch (str3.hashCode()) {
                case -2095576542:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_MPEG4_AP)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -2095575984:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_MPEG4_SP)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1985379776:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_ACM)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1784763192:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_TRUEHD)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1730367663:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_VORBIS)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -1482641358:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_MP2)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -1482641357:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_MP3)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -1373388978:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_FOURCC)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -933872740:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_DVBSUB)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -538363189:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_MPEG4_ASP)) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case -538363109:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_H264)) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case -425012669:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_VOBSUB)) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -356037306:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_DTS_LOSSLESS)) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case 62923557:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_AAC)) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case 62923603:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_AC3)) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case 62927045:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_DTS)) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case 82318131:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_AV1)) {
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                case 82338133:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_VP8)) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case 82338134:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_VP9)) {
                        c = 18;
                        break;
                    }
                    c = 65535;
                    break;
                case 99146302:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_PGS)) {
                        c = 19;
                        break;
                    }
                    c = 65535;
                    break;
                case 444813526:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_THEORA)) {
                        c = 20;
                        break;
                    }
                    c = 65535;
                    break;
                case 542569478:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_DTS_EXPRESS)) {
                        c = 21;
                        break;
                    }
                    c = 65535;
                    break;
                case 635596514:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_PCM_FLOAT)) {
                        c = 22;
                        break;
                    }
                    c = 65535;
                    break;
                case 725948237:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_PCM_INT_BIG)) {
                        c = 23;
                        break;
                    }
                    c = 65535;
                    break;
                case 725957860:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_PCM_INT_LIT)) {
                        c = 24;
                        break;
                    }
                    c = 65535;
                    break;
                case 738597099:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_ASS)) {
                        c = 25;
                        break;
                    }
                    c = 65535;
                    break;
                case 738614379:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_SSA)) {
                        c = 26;
                        break;
                    }
                    c = 65535;
                    break;
                case 855502857:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_H265)) {
                        c = 27;
                        break;
                    }
                    c = 65535;
                    break;
                case 1045209816:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_VTT)) {
                        c = 28;
                        break;
                    }
                    c = 65535;
                    break;
                case 1422270023:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_SUBRIP)) {
                        c = 29;
                        break;
                    }
                    c = 65535;
                    break;
                case 1809237540:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_MPEG2)) {
                        c = 30;
                        break;
                    }
                    c = 65535;
                    break;
                case 1950749482:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_E_AC3)) {
                        c = 31;
                        break;
                    }
                    c = 65535;
                    break;
                case 1950789798:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_FLAC)) {
                        c = ' ';
                        break;
                    }
                    c = 65535;
                    break;
                case 1951062397:
                    if (str3.equals(MatroskaExtractor.CODEC_ID_OPUS)) {
                        c = '!';
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            int i9 = 4096;
            String str4 = MimeTypes.AUDIO_RAW;
            switch (c) {
                case 0:
                case 1:
                case '\t':
                    i2 = 0;
                    byte[] bArr = this.codecPrivate;
                    singletonList = bArr == null ? null : Collections.singletonList(bArr);
                    str4 = MimeTypes.VIDEO_MP4V;
                    str = null;
                    i3 = -1;
                    i8 = -1;
                    break;
                case 2:
                    i2 = 0;
                    if (parseMsAcmCodecPrivate(new ParsableByteArray(getCodecPrivate(this.codecId)))) {
                        i8 = Util.getPcmEncoding(this.audioBitDepth);
                        if (i8 != 0) {
                            singletonList = null;
                            str = null;
                            i3 = -1;
                            break;
                        } else {
                            Log.w(MatroskaExtractor.TAG, "Unsupported PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                        }
                    } else {
                        Log.w(MatroskaExtractor.TAG, "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                    }
                    singletonList = null;
                    str = null;
                    str4 = MimeTypes.AUDIO_UNKNOWN;
                    i3 = -1;
                    i8 = -1;
                    break;
                case 3:
                    i2 = 0;
                    this.trueHdSampleRechunker = new TrueHdSampleRechunker();
                    str4 = MimeTypes.AUDIO_TRUEHD;
                    singletonList = null;
                    str = null;
                    i3 = -1;
                    i8 = -1;
                    break;
                case 4:
                    i2 = 0;
                    singletonList = parseVorbisCodecPrivate(getCodecPrivate(this.codecId));
                    str4 = MimeTypes.AUDIO_VORBIS;
                    i9 = 8192;
                    str = null;
                    i3 = i9;
                    i8 = -1;
                    break;
                case 5:
                    i2 = 0;
                    str4 = MimeTypes.AUDIO_MPEG_L2;
                    singletonList = null;
                    str = null;
                    i3 = i9;
                    i8 = -1;
                    break;
                case 6:
                    i2 = 0;
                    str4 = MimeTypes.AUDIO_MPEG;
                    singletonList = null;
                    str = null;
                    i3 = i9;
                    i8 = -1;
                    break;
                case 7:
                    i2 = 0;
                    Pair<String, List<byte[]>> parseFourCcPrivate = parseFourCcPrivate(new ParsableByteArray(getCodecPrivate(this.codecId)));
                    str4 = (String) parseFourCcPrivate.first;
                    singletonList = (List) parseFourCcPrivate.second;
                    str = null;
                    i3 = -1;
                    i8 = -1;
                    break;
                case '\b':
                    byte[] bArr2 = new byte[4];
                    i2 = 0;
                    System.arraycopy(getCodecPrivate(this.codecId), 0, bArr2, 0, 4);
                    singletonList = ImmutableList.of(bArr2);
                    str4 = MimeTypes.APPLICATION_DVBSUBS;
                    str = null;
                    i3 = -1;
                    i8 = -1;
                    break;
                case '\n':
                    AvcConfig parse2 = AvcConfig.parse(new ParsableByteArray(getCodecPrivate(this.codecId)));
                    list = parse2.initializationData;
                    this.nalUnitLengthFieldLength = parse2.nalUnitLengthFieldLength;
                    str2 = parse2.codecs;
                    str4 = MimeTypes.VIDEO_H264;
                    List<byte[]> list2 = list;
                    str = str2;
                    singletonList = list2;
                    i3 = -1;
                    i2 = 0;
                    i8 = -1;
                    break;
                case 11:
                    singletonList = ImmutableList.of(getCodecPrivate(this.codecId));
                    str = null;
                    str4 = MimeTypes.APPLICATION_VOBSUB;
                    i3 = -1;
                    i2 = 0;
                    i8 = -1;
                    break;
                case '\f':
                    str4 = MimeTypes.AUDIO_DTS_HD;
                    singletonList = null;
                    str = null;
                    i3 = -1;
                    i2 = 0;
                    i8 = -1;
                    break;
                case '\r':
                    singletonList = Collections.singletonList(getCodecPrivate(this.codecId));
                    AacUtil.Config parseAudioSpecificConfig = AacUtil.parseAudioSpecificConfig(this.codecPrivate);
                    this.sampleRate = parseAudioSpecificConfig.sampleRateHz;
                    this.channelCount = parseAudioSpecificConfig.channelCount;
                    str = parseAudioSpecificConfig.codecs;
                    str4 = MimeTypes.AUDIO_AAC;
                    i3 = -1;
                    i2 = 0;
                    i8 = -1;
                    break;
                case 14:
                    str4 = MimeTypes.AUDIO_AC3;
                    singletonList = null;
                    str = null;
                    i3 = -1;
                    i2 = 0;
                    i8 = -1;
                    break;
                case 15:
                case 21:
                    this.waitingForDtsAnalysis = true;
                    str4 = MimeTypes.AUDIO_DTS;
                    singletonList = null;
                    str = null;
                    i3 = -1;
                    i2 = 0;
                    i8 = -1;
                    break;
                case 16:
                    byte[] bArr3 = this.codecPrivate;
                    singletonList = bArr3 == null ? null : ImmutableList.of(bArr3);
                    str4 = MimeTypes.VIDEO_AV1;
                    str = null;
                    i3 = -1;
                    i2 = 0;
                    i8 = -1;
                    break;
                case 17:
                    str4 = MimeTypes.VIDEO_VP8;
                    singletonList = null;
                    str = null;
                    i3 = -1;
                    i2 = 0;
                    i8 = -1;
                    break;
                case 18:
                    byte[] bArr4 = this.codecPrivate;
                    singletonList = bArr4 == null ? null : ImmutableList.of(bArr4);
                    str4 = MimeTypes.VIDEO_VP9;
                    str = null;
                    i3 = -1;
                    i2 = 0;
                    i8 = -1;
                    break;
                case 19:
                    str4 = MimeTypes.APPLICATION_PGS;
                    singletonList = null;
                    str = null;
                    i3 = -1;
                    i2 = 0;
                    i8 = -1;
                    break;
                case 20:
                    str4 = MimeTypes.VIDEO_UNKNOWN;
                    singletonList = null;
                    str = null;
                    i3 = -1;
                    i2 = 0;
                    i8 = -1;
                    break;
                case 22:
                    if (this.audioBitDepth != 32) {
                        Log.w(MatroskaExtractor.TAG, "Unsupported floating point PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                        singletonList = null;
                        str = null;
                        str4 = MimeTypes.AUDIO_UNKNOWN;
                        i3 = -1;
                        i2 = 0;
                        i8 = -1;
                        break;
                    } else {
                        singletonList = null;
                        str = null;
                        i3 = -1;
                        i2 = 0;
                        i8 = 4;
                        break;
                    }
                case 23:
                    int i10 = this.audioBitDepth;
                    if (i10 != 8) {
                        if (i10 != 16) {
                            if (i10 != 24) {
                                if (i10 != 32) {
                                    Log.w(MatroskaExtractor.TAG, "Unsupported big endian PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                                    singletonList = null;
                                    str = null;
                                    str4 = MimeTypes.AUDIO_UNKNOWN;
                                    i3 = -1;
                                    i2 = 0;
                                    i8 = -1;
                                    break;
                                } else {
                                    i8 = C.ENCODING_PCM_32BIT_BIG_ENDIAN;
                                }
                            } else {
                                i8 = C.ENCODING_PCM_24BIT_BIG_ENDIAN;
                            }
                        } else {
                            i8 = 268435456;
                        }
                    }
                    singletonList = null;
                    str = null;
                    i3 = -1;
                    i2 = 0;
                    break;
                case 24:
                    i8 = Util.getPcmEncoding(this.audioBitDepth);
                    if (i8 == 0) {
                        Log.w(MatroskaExtractor.TAG, "Unsupported little endian PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                        singletonList = null;
                        str = null;
                        str4 = MimeTypes.AUDIO_UNKNOWN;
                        i3 = -1;
                        i2 = 0;
                        i8 = -1;
                        break;
                    }
                    singletonList = null;
                    str = null;
                    i3 = -1;
                    i2 = 0;
                    break;
                case 25:
                case 26:
                    singletonList = ImmutableList.of(MatroskaExtractor.SSA_DIALOGUE_FORMAT, getCodecPrivate(this.codecId));
                    str = null;
                    str4 = MimeTypes.TEXT_SSA;
                    i3 = -1;
                    i2 = 0;
                    i8 = -1;
                    break;
                case 27:
                    HevcConfig parse3 = HevcConfig.parse(new ParsableByteArray(getCodecPrivate(this.codecId)));
                    list = parse3.initializationData;
                    this.nalUnitLengthFieldLength = parse3.nalUnitLengthFieldLength;
                    str2 = parse3.codecs;
                    str4 = MimeTypes.VIDEO_H265;
                    List<byte[]> list22 = list;
                    str = str2;
                    singletonList = list22;
                    i3 = -1;
                    i2 = 0;
                    i8 = -1;
                    break;
                case 28:
                    singletonList = null;
                    str = null;
                    str4 = MimeTypes.TEXT_VTT;
                    i3 = -1;
                    i2 = 0;
                    i8 = -1;
                    break;
                case 29:
                    str4 = MimeTypes.APPLICATION_SUBRIP;
                    singletonList = null;
                    str = null;
                    i3 = -1;
                    i2 = 0;
                    i8 = -1;
                    break;
                case 30:
                    str4 = MimeTypes.VIDEO_MPEG2;
                    singletonList = null;
                    str = null;
                    i3 = -1;
                    i2 = 0;
                    i8 = -1;
                    break;
                case 31:
                    str4 = MimeTypes.AUDIO_E_AC3;
                    singletonList = null;
                    str = null;
                    i3 = -1;
                    i2 = 0;
                    i8 = -1;
                    break;
                case ' ':
                    singletonList = Collections.singletonList(getCodecPrivate(this.codecId));
                    str4 = MimeTypes.AUDIO_FLAC;
                    str = null;
                    i3 = -1;
                    i2 = 0;
                    i8 = -1;
                    break;
                case '!':
                    singletonList = new ArrayList<>(3);
                    singletonList.add(getCodecPrivate(this.codecId));
                    singletonList.add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.codecDelayNs).array());
                    singletonList.add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.seekPreRollNs).array());
                    str4 = MimeTypes.AUDIO_OPUS;
                    str = null;
                    i3 = MatroskaExtractor.OPUS_MAX_INPUT_SIZE;
                    i2 = 0;
                    i8 = -1;
                    break;
                default:
                    throw ParserException.createForMalformedContainer("Unrecognized codec identifier.", null);
            }
            if (this.dolbyVisionConfigBytes != null && (parse = DolbyVisionConfig.parse(new ParsableByteArray(this.dolbyVisionConfigBytes))) != null) {
                str = parse.codecs;
                str4 = MimeTypes.VIDEO_DOLBY_VISION;
            }
            String str5 = str4;
            int i11 = (this.flagDefault ? 1 : 0) | (this.flagForced ? 2 : i2);
            Format.Builder builder = new Format.Builder();
            if (MimeTypes.isAudio(str5)) {
                builder.setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setPcmEncoding(i8);
            } else if (MimeTypes.isVideo(str5)) {
                if (this.displayUnit == 0) {
                    int i12 = this.displayWidth;
                    i4 = -1;
                    if (i12 == -1) {
                        i12 = this.width;
                    }
                    this.displayWidth = i12;
                    int i13 = this.displayHeight;
                    if (i13 == -1) {
                        i13 = this.height;
                    }
                    this.displayHeight = i13;
                } else {
                    i4 = -1;
                }
                float f = (this.displayWidth == i4 || (i7 = this.displayHeight) == i4) ? -1.0f : (this.height * i5) / (this.width * i7);
                ColorInfo build = this.hasColorInfo ? new ColorInfo.Builder().setColorSpace(this.colorSpace).setColorRange(this.colorRange).setColorTransfer(this.colorTransfer).setHdrStaticInfo(getHdrStaticInfo()).setLumaBitdepth(this.bitsPerChannel).setChromaBitdepth(this.bitsPerChannel).build() : null;
                int intValue = (this.name == null || !MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.containsKey(this.name)) ? i4 : ((Integer) MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.get(this.name)).intValue();
                if (this.projectionType == 0 && Float.compare(this.projectionPoseYaw, 0.0f) == 0 && Float.compare(this.projectionPosePitch, 0.0f) == 0) {
                    if (Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                        i6 = i2;
                    } else if (Float.compare(this.projectionPoseRoll, 90.0f) == 0) {
                        i6 = 90;
                    } else if (Float.compare(this.projectionPoseRoll, -180.0f) == 0 || Float.compare(this.projectionPoseRoll, 180.0f) == 0) {
                        i6 = 180;
                    } else if (Float.compare(this.projectionPoseRoll, -90.0f) == 0) {
                        i6 = SubsamplingScaleImageView.ORIENTATION_270;
                    }
                    builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i6).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(build);
                }
                i6 = intValue;
                builder.setWidth(this.width).setHeight(this.height).setPixelWidthHeightRatio(f).setRotationDegrees(i6).setProjectionData(this.projectionData).setStereoMode(this.stereoMode).setColorInfo(build);
            } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str5) && !MimeTypes.TEXT_SSA.equals(str5) && !MimeTypes.TEXT_VTT.equals(str5) && !MimeTypes.APPLICATION_VOBSUB.equals(str5) && !MimeTypes.APPLICATION_PGS.equals(str5) && !MimeTypes.APPLICATION_DVBSUBS.equals(str5)) {
                throw ParserException.createForMalformedContainer("Unexpected MIME type.", null);
            }
            if (this.name != null && !MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES.containsKey(this.name)) {
                builder.setLabel(this.name);
            }
            this.format = builder.setId(i).setContainerMimeType(this.isWebm ? MimeTypes.VIDEO_WEBM : MimeTypes.VIDEO_MATROSKA).setSampleMimeType(str5).setMaxInputSize(i3).setLanguage(this.language).setSelectionFlags(i11).setInitializationData(singletonList).setCodecs(str).setDrmInitData(this.drmInitData).build();
        }

        @RequiresNonNull({"output"})
        public void outputPendingSampleMetadata() {
            TrueHdSampleRechunker trueHdSampleRechunker = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.outputPendingSampleMetadata(this.output, this.cryptoData);
            }
        }

        public void reset() {
            TrueHdSampleRechunker trueHdSampleRechunker = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.reset();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean samplesHaveSupplementalData(boolean z) {
            return MatroskaExtractor.CODEC_ID_OPUS.equals(this.codecId) ? z : this.maxBlockAdditionId > 0;
        }

        private byte[] getHdrStaticInfo() {
            if (this.primaryRChromaticityX == -1.0f || this.primaryRChromaticityY == -1.0f || this.primaryGChromaticityX == -1.0f || this.primaryGChromaticityY == -1.0f || this.primaryBChromaticityX == -1.0f || this.primaryBChromaticityY == -1.0f || this.whitePointChromaticityX == -1.0f || this.whitePointChromaticityY == -1.0f || this.maxMasteringLuminance == -1.0f || this.minMasteringLuminance == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            order.put((byte) 0);
            order.putShort((short) ((this.primaryRChromaticityX * 50000.0f) + 0.5f));
            order.putShort((short) ((this.primaryRChromaticityY * 50000.0f) + 0.5f));
            order.putShort((short) ((this.primaryGChromaticityX * 50000.0f) + 0.5f));
            order.putShort((short) ((this.primaryGChromaticityY * 50000.0f) + 0.5f));
            order.putShort((short) ((this.primaryBChromaticityX * 50000.0f) + 0.5f));
            order.putShort((short) ((this.primaryBChromaticityY * 50000.0f) + 0.5f));
            order.putShort((short) ((this.whitePointChromaticityX * 50000.0f) + 0.5f));
            order.putShort((short) ((this.whitePointChromaticityY * 50000.0f) + 0.5f));
            order.putShort((short) (this.maxMasteringLuminance + 0.5f));
            order.putShort((short) (this.minMasteringLuminance + 0.5f));
            order.putShort((short) this.maxContentLuminance);
            order.putShort((short) this.maxFrameAverageLuminance);
            return bArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void maybeAddThumbnailMetadata(SparseArray<List<MatroskaSeekMap.CuePointData>> sparseArray, long j, long j2, long j3) {
            List<MatroskaSeekMap.CuePointData> list;
            if (this.type != 2 || (list = sparseArray.get(this.number)) == null || list.isEmpty()) {
                return;
            }
            long findBestThumbnailPresentationTimeUs = findBestThumbnailPresentationTimeUs(list, j, j2, j3);
            if (findBestThumbnailPresentationTimeUs != C.TIME_UNSET) {
                Metadata metadata = ((Format) Preconditions.checkNotNull(this.format)).metadata;
                ThumbnailMetadata thumbnailMetadata = new ThumbnailMetadata(findBestThumbnailPresentationTimeUs);
                this.format = this.format.buildUpon().setMetadata(metadata == null ? new Metadata(thumbnailMetadata) : metadata.copyWithAppendedEntries(thumbnailMetadata)).build();
            }
        }

        private static long findBestThumbnailPresentationTimeUs(List<MatroskaSeekMap.CuePointData> list, long j, long j2, long j3) {
            long j4;
            long j5;
            if (list.isEmpty()) {
                return C.TIME_UNSET;
            }
            int min = Math.min(list.size(), 20);
            double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            int i = -1;
            for (int i2 = 0; i2 < min; i2++) {
                MatroskaSeekMap.CuePointData cuePointData = list.get(i2);
                if (cuePointData.timeUs > MatroskaExtractor.MAX_DURATION_US_TO_SCAN_FOR_THUMBNAIL) {
                    break;
                }
                if (i2 < list.size() - 1) {
                    MatroskaSeekMap.CuePointData cuePointData2 = list.get(i2 + 1);
                    j4 = (cuePointData2.clusterPosition + cuePointData2.relativePosition) - (cuePointData.clusterPosition + cuePointData.relativePosition);
                    j5 = cuePointData2.timeUs - cuePointData.timeUs;
                } else {
                    j4 = (j2 + j3) - (cuePointData.clusterPosition + cuePointData.relativePosition);
                    j5 = j - cuePointData.timeUs;
                }
                if (j5 > 0) {
                    double d2 = j4 / j5;
                    if (d2 > d) {
                        i = i2;
                        d = d2;
                    }
                }
            }
            return i == -1 ? C.TIME_UNSET : list.get(i).timeUs;
        }

        private static Pair<String, List<byte[]>> parseFourCcPrivate(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                parsableByteArray.skipBytes(16);
                long readLittleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
                if (readLittleEndianUnsignedInt == 1482049860) {
                    return new Pair<>(MimeTypes.VIDEO_DIVX, null);
                }
                if (readLittleEndianUnsignedInt == 859189832) {
                    return new Pair<>(MimeTypes.VIDEO_H263, null);
                }
                if (readLittleEndianUnsignedInt == 826496599) {
                    byte[] data = parsableByteArray.getData();
                    for (int position = parsableByteArray.getPosition() + 20; position < data.length - 4; position++) {
                        if (data[position] == 0 && data[position + 1] == 0 && data[position + 2] == 1 && data[position + 3] == 15) {
                            return new Pair<>(MimeTypes.VIDEO_VC1, Collections.singletonList(Arrays.copyOfRange(data, position, data.length)));
                        }
                    }
                    throw ParserException.createForMalformedContainer("Failed to find FourCC VC1 initialization data", null);
                }
                Log.w(MatroskaExtractor.TAG, "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair<>(MimeTypes.VIDEO_UNKNOWN, null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing FourCC private data", null);
            }
        }

        private static List<byte[]> parseVorbisCodecPrivate(byte[] bArr) throws ParserException {
            int i;
            int i2;
            try {
                if (bArr[0] != 2) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                int i3 = 0;
                int i4 = 1;
                while (true) {
                    i = bArr[i4];
                    if ((i & 255) != 255) {
                        break;
                    }
                    i3 += 255;
                    i4++;
                }
                int i5 = i4 + 1;
                int i6 = i3 + (i & 255);
                int i7 = 0;
                while (true) {
                    i2 = bArr[i5];
                    if ((i2 & 255) != 255) {
                        break;
                    }
                    i7 += 255;
                    i5++;
                }
                int i8 = i5 + 1;
                int i9 = i7 + (i2 & 255);
                if (bArr[i8] != 1) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                byte[] bArr2 = new byte[i6];
                System.arraycopy(bArr, i8, bArr2, 0, i6);
                int i10 = i8 + i6;
                if (bArr[i10] != 3) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                int i11 = i10 + i9;
                if (bArr[i11] != 5) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                byte[] bArr3 = new byte[bArr.length - i11];
                System.arraycopy(bArr, i11, bArr3, 0, bArr.length - i11);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
            }
        }

        private static boolean parseMsAcmCodecPrivate(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
                if (readLittleEndianUnsignedShort == 1) {
                    return true;
                }
                if (readLittleEndianUnsignedShort == 65534) {
                    parsableByteArray.setPosition(24);
                    if (parsableByteArray.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getMostSignificantBits()) {
                        if (parsableByteArray.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getLeastSignificantBits()) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing MS/ACM codec private", null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @EnsuresNonNull({"output"})
        public void assertOutputInitialized() {
            Preconditions.checkNotNull(this.output);
        }

        @EnsuresNonNull({"codecPrivate"})
        private byte[] getCodecPrivate(String str) throws ParserException {
            byte[] bArr = this.codecPrivate;
            if (bArr != null) {
                return bArr;
            }
            throw ParserException.createForMalformedContainer("Missing CodecPrivate for codec " + str, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class MatroskaSeekMap implements TrackAwareSeekMap, ChunkIndexProvider {
        private final ChunkIndex chunkIndex;
        private final long durationUs;
        private final SparseArray<List<CuePointData>> perTrackCues;
        private final int primarySeekTrackNumber;

        public MatroskaSeekMap(SparseArray<List<CuePointData>> sparseArray, long j, int i, long j2, long j3) {
            this.perTrackCues = sparseArray;
            this.durationUs = j;
            this.primarySeekTrackNumber = i;
            this.chunkIndex = buildChunkIndex(sparseArray, j, i, j2, j3);
        }

        @Override // androidx.media3.extractor.SeekMap
        public boolean isSeekable() {
            return isSeekable(this.primarySeekTrackNumber);
        }

        @Override // androidx.media3.extractor.TrackAwareSeekMap
        public boolean isSeekable(int i) {
            List<CuePointData> list = this.perTrackCues.get(i);
            return (list == null || list.isEmpty()) ? false : true;
        }

        @Override // androidx.media3.extractor.SeekMap
        public long getDurationUs() {
            return this.durationUs;
        }

        @Override // androidx.media3.extractor.SeekMap
        public SeekMap.SeekPoints getSeekPoints(long j) {
            ChunkIndex chunkIndex = this.chunkIndex;
            if (chunkIndex != null) {
                return chunkIndex.getSeekPoints(j);
            }
            return new SeekMap.SeekPoints(SeekPoint.START);
        }

        @Override // androidx.media3.extractor.TrackAwareSeekMap
        public SeekMap.SeekPoints getSeekPoints(long j, int i) {
            int i2;
            int i3;
            List<CuePointData> list = this.perTrackCues.get(i);
            if ((list == null || list.isEmpty()) && i != (i2 = this.primarySeekTrackNumber)) {
                list = this.perTrackCues.get(i2);
            }
            if (list == null || list.isEmpty()) {
                return new SeekMap.SeekPoints(SeekPoint.START);
            }
            int binarySearchFloor = Util.binarySearchFloor((List<? extends Comparable<? super CuePointData>>) list, new CuePointData(j, -1L, -1L), true, false);
            if (binarySearchFloor != -1) {
                CuePointData cuePointData = list.get(binarySearchFloor);
                SeekPoint seekPoint = new SeekPoint(cuePointData.timeUs, cuePointData.clusterPosition);
                if (cuePointData.timeUs < j && (i3 = binarySearchFloor + 1) < list.size()) {
                    CuePointData cuePointData2 = list.get(i3);
                    return new SeekMap.SeekPoints(seekPoint, new SeekPoint(cuePointData2.timeUs, cuePointData2.clusterPosition));
                }
                return new SeekMap.SeekPoints(seekPoint);
            }
            CuePointData cuePointData3 = list.get(0);
            return new SeekMap.SeekPoints(new SeekPoint(cuePointData3.timeUs, cuePointData3.clusterPosition));
        }

        @Override // androidx.media3.extractor.ChunkIndexProvider
        public ChunkIndex getChunkIndex() {
            return this.chunkIndex;
        }

        private static ChunkIndex buildChunkIndex(SparseArray<List<CuePointData>> sparseArray, long j, int i, long j2, long j3) {
            int i2;
            List<CuePointData> list = sparseArray.get(i);
            if (list == null || list.isEmpty()) {
                return null;
            }
            int size = list.size();
            int[] iArr = new int[size];
            long[] jArr = new long[size];
            long[] jArr2 = new long[size];
            long[] jArr3 = new long[size];
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                CuePointData cuePointData = list.get(i4);
                jArr3[i4] = cuePointData.timeUs;
                jArr[i4] = cuePointData.clusterPosition;
            }
            while (true) {
                i2 = size - 1;
                if (i3 >= i2) {
                    break;
                }
                int i5 = i3 + 1;
                iArr[i3] = (int) (jArr[i5] - jArr[i3]);
                jArr2[i3] = jArr3[i5] - jArr3[i3];
                i3 = i5;
            }
            int i6 = i2;
            while (i6 > 0 && jArr3[i6] >= j) {
                i6--;
            }
            iArr[i6] = (int) ((j2 + j3) - jArr[i6]);
            jArr2[i6] = j - jArr3[i6];
            if (i6 < i2) {
                Log.w(MatroskaExtractor.TAG, "Discarding trailing cue points with timestamps greater than total duration.");
                int i7 = i6 + 1;
                iArr = Arrays.copyOf(iArr, i7);
                jArr = Arrays.copyOf(jArr, i7);
                jArr2 = Arrays.copyOf(jArr2, i7);
                jArr3 = Arrays.copyOf(jArr3, i7);
            }
            return new ChunkIndex(iArr, jArr, jArr2, jArr3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class CuePointData implements Comparable<CuePointData> {
            private final long clusterPosition;
            private final long relativePosition;
            private final long timeUs;

            private CuePointData(long j, long j2, long j3) {
                this.timeUs = j;
                this.clusterPosition = j2;
                this.relativePosition = j3;
            }

            @Override // java.lang.Comparable
            public int compareTo(CuePointData cuePointData) {
                return Long.compare(this.timeUs, cuePointData.timeUs);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof CuePointData) {
                    CuePointData cuePointData = (CuePointData) obj;
                    return this.timeUs == cuePointData.timeUs && this.clusterPosition == cuePointData.clusterPosition && this.relativePosition == cuePointData.relativePosition;
                }
                return false;
            }

            public int hashCode() {
                return Objects.hash(Long.valueOf(this.timeUs), Long.valueOf(this.clusterPosition), Long.valueOf(this.relativePosition));
            }
        }
    }
}
