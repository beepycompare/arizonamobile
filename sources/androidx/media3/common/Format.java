package androidx.media3.common;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.Util;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.math.DoubleMath;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes2.dex */
public final class Format {
    public static final int CUE_REPLACEMENT_BEHAVIOR_MERGE = 1;
    public static final int CUE_REPLACEMENT_BEHAVIOR_REPLACE = 2;
    public static final int NO_VALUE = -1;
    public static final long OFFSET_SAMPLE_RELATIVE = Long.MAX_VALUE;
    public final int accessibilityChannel;
    public final int auxiliaryTrackType;
    public final int averageBitrate;
    public final int bitrate;
    public final int channelCount;
    public final String codecs;
    public final ColorInfo colorInfo;
    public final String containerMimeType;
    public final int cryptoType;
    public final int cueReplacementBehavior;
    public final Object customData;
    public final DrmInitData drmInitData;
    public final int encoderDelay;
    public final int encoderPadding;
    public final float frameRate;
    public final boolean hasPrerollSamples;
    private int hashCode;
    public final int height;
    public final String id;
    public final List<byte[]> initializationData;
    public final String label;
    public final List<Label> labels;
    public final String language;
    public final int maxInputSize;
    public final int maxNumReorderSamples;
    public final int maxSubLayers;
    public final Metadata metadata;
    public final int pcmEncoding;
    public final int peakBitrate;
    public final float pixelWidthHeightRatio;
    public final byte[] projectionData;
    public final int roleFlags;
    public final int rotationDegrees;
    public final String sampleMimeType;
    public final int sampleRate;
    public final int selectionFlags;
    public final int stereoMode;
    public final long subsampleOffsetUs;
    public final int tileCountHorizontal;
    public final int tileCountVertical;
    public final int width;
    private static final Format DEFAULT = new Builder().build();
    private static final String FIELD_ID = Util.intToStringMaxRadix(0);
    private static final String FIELD_LABEL = Util.intToStringMaxRadix(1);
    private static final String FIELD_LANGUAGE = Util.intToStringMaxRadix(2);
    private static final String FIELD_SELECTION_FLAGS = Util.intToStringMaxRadix(3);
    private static final String FIELD_ROLE_FLAGS = Util.intToStringMaxRadix(4);
    private static final String FIELD_AVERAGE_BITRATE = Util.intToStringMaxRadix(5);
    private static final String FIELD_PEAK_BITRATE = Util.intToStringMaxRadix(6);
    private static final String FIELD_CODECS = Util.intToStringMaxRadix(7);
    private static final String UNUSED_FIELD_METADATA = Util.intToStringMaxRadix(8);
    private static final String FIELD_CONTAINER_MIME_TYPE = Util.intToStringMaxRadix(9);
    private static final String FIELD_SAMPLE_MIME_TYPE = Util.intToStringMaxRadix(10);
    private static final String FIELD_MAX_INPUT_SIZE = Util.intToStringMaxRadix(11);
    private static final String FIELD_INITIALIZATION_DATA = Util.intToStringMaxRadix(12);
    private static final String FIELD_DRM_INIT_DATA = Util.intToStringMaxRadix(13);
    private static final String FIELD_SUBSAMPLE_OFFSET_US = Util.intToStringMaxRadix(14);
    private static final String FIELD_WIDTH = Util.intToStringMaxRadix(15);
    private static final String FIELD_HEIGHT = Util.intToStringMaxRadix(16);
    private static final String FIELD_FRAME_RATE = Util.intToStringMaxRadix(17);
    private static final String FIELD_ROTATION_DEGREES = Util.intToStringMaxRadix(18);
    private static final String FIELD_PIXEL_WIDTH_HEIGHT_RATIO = Util.intToStringMaxRadix(19);
    private static final String FIELD_PROJECTION_DATA = Util.intToStringMaxRadix(20);
    private static final String FIELD_STEREO_MODE = Util.intToStringMaxRadix(21);
    private static final String FIELD_COLOR_INFO = Util.intToStringMaxRadix(22);
    private static final String FIELD_CHANNEL_COUNT = Util.intToStringMaxRadix(23);
    private static final String FIELD_SAMPLE_RATE = Util.intToStringMaxRadix(24);
    private static final String FIELD_PCM_ENCODING = Util.intToStringMaxRadix(25);
    private static final String FIELD_ENCODER_DELAY = Util.intToStringMaxRadix(26);
    private static final String FIELD_ENCODER_PADDING = Util.intToStringMaxRadix(27);
    private static final String FIELD_ACCESSIBILITY_CHANNEL = Util.intToStringMaxRadix(28);
    private static final String FIELD_CRYPTO_TYPE = Util.intToStringMaxRadix(29);
    private static final String FIELD_TILE_COUNT_HORIZONTAL = Util.intToStringMaxRadix(30);
    private static final String FIELD_TILE_COUNT_VERTICAL = Util.intToStringMaxRadix(31);
    private static final String FIELD_LABELS = Util.intToStringMaxRadix(32);
    private static final String FIELD_AUXILIARY_TRACK_TYPE = Util.intToStringMaxRadix(33);
    private static final String FIELD_MAX_SUB_LAYERS = Util.intToStringMaxRadix(34);

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface CueReplacementBehavior {
    }

    private static <T> T defaultIfNull(T t, T t2) {
        return t != null ? t : t2;
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private int accessibilityChannel;
        private int auxiliaryTrackType;
        private int averageBitrate;
        private int channelCount;
        private String codecs;
        private ColorInfo colorInfo;
        private String containerMimeType;
        private int cryptoType;
        private int cueReplacementBehavior;
        private Object customData;
        private DrmInitData drmInitData;
        private int encoderDelay;
        private int encoderPadding;
        private float frameRate;
        private boolean hasPrerollSamples;
        private int height;
        private String id;
        private List<byte[]> initializationData;
        private String label;
        private List<Label> labels;
        private String language;
        private int maxInputSize;
        private int maxNumReorderSamples;
        private int maxSubLayers;
        private Metadata metadata;
        private int pcmEncoding;
        private int peakBitrate;
        private float pixelWidthHeightRatio;
        private byte[] projectionData;
        private int roleFlags;
        private int rotationDegrees;
        private String sampleMimeType;
        private int sampleRate;
        private int selectionFlags;
        private int stereoMode;
        private long subsampleOffsetUs;
        private int tileCountHorizontal;
        private int tileCountVertical;
        private int width;

        public Builder() {
            this.labels = ImmutableList.of();
            this.averageBitrate = -1;
            this.peakBitrate = -1;
            this.maxInputSize = -1;
            this.maxNumReorderSamples = -1;
            this.subsampleOffsetUs = Long.MAX_VALUE;
            this.width = -1;
            this.height = -1;
            this.frameRate = -1.0f;
            this.pixelWidthHeightRatio = 1.0f;
            this.stereoMode = -1;
            this.maxSubLayers = -1;
            this.channelCount = -1;
            this.sampleRate = -1;
            this.pcmEncoding = -1;
            this.accessibilityChannel = -1;
            this.cueReplacementBehavior = 1;
            this.tileCountHorizontal = -1;
            this.tileCountVertical = -1;
            this.cryptoType = 0;
            this.auxiliaryTrackType = 0;
        }

        private Builder(Format format) {
            this.id = format.id;
            this.label = format.label;
            this.labels = format.labels;
            this.language = format.language;
            this.selectionFlags = format.selectionFlags;
            this.roleFlags = format.roleFlags;
            this.averageBitrate = format.averageBitrate;
            this.peakBitrate = format.peakBitrate;
            this.codecs = format.codecs;
            this.metadata = format.metadata;
            this.customData = format.customData;
            this.containerMimeType = format.containerMimeType;
            this.sampleMimeType = format.sampleMimeType;
            this.maxInputSize = format.maxInputSize;
            this.maxNumReorderSamples = format.maxNumReorderSamples;
            this.initializationData = format.initializationData;
            this.drmInitData = format.drmInitData;
            this.subsampleOffsetUs = format.subsampleOffsetUs;
            this.hasPrerollSamples = format.hasPrerollSamples;
            this.width = format.width;
            this.height = format.height;
            this.frameRate = format.frameRate;
            this.rotationDegrees = format.rotationDegrees;
            this.pixelWidthHeightRatio = format.pixelWidthHeightRatio;
            this.projectionData = format.projectionData;
            this.stereoMode = format.stereoMode;
            this.colorInfo = format.colorInfo;
            this.maxSubLayers = format.maxSubLayers;
            this.channelCount = format.channelCount;
            this.sampleRate = format.sampleRate;
            this.pcmEncoding = format.pcmEncoding;
            this.encoderDelay = format.encoderDelay;
            this.encoderPadding = format.encoderPadding;
            this.accessibilityChannel = format.accessibilityChannel;
            this.cueReplacementBehavior = format.cueReplacementBehavior;
            this.tileCountHorizontal = format.tileCountHorizontal;
            this.tileCountVertical = format.tileCountVertical;
            this.cryptoType = format.cryptoType;
        }

        public Builder setId(String str) {
            this.id = str;
            return this;
        }

        public Builder setId(int i) {
            this.id = Integer.toString(i);
            return this;
        }

        public Builder setLabel(String str) {
            this.label = str;
            return this;
        }

        public Builder setLabels(List<Label> list) {
            this.labels = ImmutableList.copyOf((Collection) list);
            return this;
        }

        public Builder setLanguage(String str) {
            this.language = str;
            return this;
        }

        public Builder setSelectionFlags(int i) {
            this.selectionFlags = i;
            return this;
        }

        public Builder setRoleFlags(int i) {
            this.roleFlags = i;
            return this;
        }

        public Builder setAuxiliaryTrackType(int i) {
            this.auxiliaryTrackType = i;
            return this;
        }

        public Builder setAverageBitrate(int i) {
            this.averageBitrate = i;
            return this;
        }

        public Builder setPeakBitrate(int i) {
            this.peakBitrate = i;
            return this;
        }

        public Builder setCodecs(String str) {
            this.codecs = str;
            return this;
        }

        public Builder setMetadata(Metadata metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder setCustomData(Object obj) {
            this.customData = obj;
            return this;
        }

        public Builder setContainerMimeType(String str) {
            this.containerMimeType = MimeTypes.normalizeMimeType(str);
            return this;
        }

        public Builder setSampleMimeType(String str) {
            this.sampleMimeType = MimeTypes.normalizeMimeType(str);
            return this;
        }

        public Builder setMaxInputSize(int i) {
            this.maxInputSize = i;
            return this;
        }

        public Builder setMaxNumReorderSamples(int i) {
            this.maxNumReorderSamples = i;
            return this;
        }

        public Builder setInitializationData(List<byte[]> list) {
            this.initializationData = list;
            return this;
        }

        public Builder setDrmInitData(DrmInitData drmInitData) {
            this.drmInitData = drmInitData;
            return this;
        }

        public Builder setSubsampleOffsetUs(long j) {
            this.subsampleOffsetUs = j;
            return this;
        }

        public Builder setHasPrerollSamples(boolean z) {
            this.hasPrerollSamples = z;
            return this;
        }

        public Builder setWidth(int i) {
            this.width = i;
            return this;
        }

        public Builder setHeight(int i) {
            this.height = i;
            return this;
        }

        public Builder setFrameRate(float f) {
            this.frameRate = f;
            return this;
        }

        public Builder setRotationDegrees(int i) {
            this.rotationDegrees = i;
            return this;
        }

        public Builder setPixelWidthHeightRatio(float f) {
            this.pixelWidthHeightRatio = f;
            return this;
        }

        public Builder setProjectionData(byte[] bArr) {
            this.projectionData = bArr;
            return this;
        }

        public Builder setStereoMode(int i) {
            this.stereoMode = i;
            return this;
        }

        public Builder setColorInfo(ColorInfo colorInfo) {
            this.colorInfo = colorInfo;
            return this;
        }

        public Builder setMaxSubLayers(int i) {
            this.maxSubLayers = i;
            return this;
        }

        public Builder setChannelCount(int i) {
            this.channelCount = i;
            return this;
        }

        public Builder setSampleRate(int i) {
            this.sampleRate = i;
            return this;
        }

        public Builder setPcmEncoding(int i) {
            this.pcmEncoding = i;
            return this;
        }

        public Builder setEncoderDelay(int i) {
            this.encoderDelay = i;
            return this;
        }

        public Builder setEncoderPadding(int i) {
            this.encoderPadding = i;
            return this;
        }

        public Builder setAccessibilityChannel(int i) {
            this.accessibilityChannel = i;
            return this;
        }

        public Builder setCueReplacementBehavior(int i) {
            this.cueReplacementBehavior = i;
            return this;
        }

        public Builder setTileCountHorizontal(int i) {
            this.tileCountHorizontal = i;
            return this;
        }

        public Builder setTileCountVertical(int i) {
            this.tileCountVertical = i;
            return this;
        }

        public Builder setCryptoType(int i) {
            this.cryptoType = i;
            return this;
        }

        public Format build() {
            return new Format(this);
        }
    }

    private static boolean isLabelPartOfLabels(Builder builder) {
        if (builder.labels.isEmpty() && builder.label == null) {
            return true;
        }
        for (int i = 0; i < builder.labels.size(); i++) {
            if (((Label) builder.labels.get(i)).value.equals(builder.label)) {
                return true;
            }
        }
        return false;
    }

    private Format(Builder builder) {
        this.id = builder.id;
        String normalizeLanguageCode = Util.normalizeLanguageCode(builder.language);
        this.language = normalizeLanguageCode;
        if (!builder.labels.isEmpty() || builder.label == null) {
            if (!builder.labels.isEmpty() && builder.label == null) {
                this.labels = builder.labels;
                this.label = getDefaultLabel(builder.labels, normalizeLanguageCode);
            } else {
                Assertions.checkState(isLabelPartOfLabels(builder));
                this.labels = builder.labels;
                this.label = builder.label;
            }
        } else {
            this.labels = ImmutableList.of(new Label(normalizeLanguageCode, builder.label));
            this.label = builder.label;
        }
        this.selectionFlags = builder.selectionFlags;
        Assertions.checkState(builder.auxiliaryTrackType == 0 || (builder.roleFlags & 32768) != 0, "Auxiliary track type must only be set to a value other than AUXILIARY_TRACK_TYPE_UNDEFINED only when ROLE_FLAG_AUXILIARY is set");
        this.roleFlags = builder.roleFlags;
        this.auxiliaryTrackType = builder.auxiliaryTrackType;
        int i = builder.averageBitrate;
        this.averageBitrate = i;
        int i2 = builder.peakBitrate;
        this.peakBitrate = i2;
        this.bitrate = i2 != -1 ? i2 : i;
        this.codecs = builder.codecs;
        this.metadata = builder.metadata;
        this.customData = builder.customData;
        this.containerMimeType = builder.containerMimeType;
        this.sampleMimeType = builder.sampleMimeType;
        this.maxInputSize = builder.maxInputSize;
        this.maxNumReorderSamples = builder.maxNumReorderSamples;
        this.initializationData = builder.initializationData == null ? Collections.emptyList() : builder.initializationData;
        DrmInitData drmInitData = builder.drmInitData;
        this.drmInitData = drmInitData;
        this.subsampleOffsetUs = builder.subsampleOffsetUs;
        this.hasPrerollSamples = builder.hasPrerollSamples;
        this.width = builder.width;
        this.height = builder.height;
        this.frameRate = builder.frameRate;
        this.rotationDegrees = builder.rotationDegrees == -1 ? 0 : builder.rotationDegrees;
        this.pixelWidthHeightRatio = builder.pixelWidthHeightRatio == -1.0f ? 1.0f : builder.pixelWidthHeightRatio;
        this.projectionData = builder.projectionData;
        this.stereoMode = builder.stereoMode;
        this.colorInfo = builder.colorInfo;
        this.maxSubLayers = builder.maxSubLayers;
        this.channelCount = builder.channelCount;
        this.sampleRate = builder.sampleRate;
        this.pcmEncoding = builder.pcmEncoding;
        this.encoderDelay = builder.encoderDelay == -1 ? 0 : builder.encoderDelay;
        this.encoderPadding = builder.encoderPadding != -1 ? builder.encoderPadding : 0;
        this.accessibilityChannel = builder.accessibilityChannel;
        this.cueReplacementBehavior = builder.cueReplacementBehavior;
        this.tileCountHorizontal = builder.tileCountHorizontal;
        this.tileCountVertical = builder.tileCountVertical;
        if (builder.cryptoType != 0 || drmInitData == null) {
            this.cryptoType = builder.cryptoType;
        } else {
            this.cryptoType = 1;
        }
    }

    public Builder buildUpon() {
        return new Builder();
    }

    public Format withManifestFormatInfo(Format format) {
        String str;
        Metadata copyWithAppendedEntriesFrom;
        if (this == format) {
            return this;
        }
        int trackType = MimeTypes.getTrackType(this.sampleMimeType);
        String str2 = format.id;
        int i = format.tileCountHorizontal;
        int i2 = format.tileCountVertical;
        String str3 = format.label;
        if (str3 == null) {
            str3 = this.label;
        }
        List<Label> list = !format.labels.isEmpty() ? format.labels : this.labels;
        String str4 = this.language;
        if ((trackType == 3 || trackType == 1) && (str = format.language) != null) {
            str4 = str;
        }
        int i3 = this.averageBitrate;
        if (i3 == -1) {
            i3 = format.averageBitrate;
        }
        int i4 = this.peakBitrate;
        if (i4 == -1) {
            i4 = format.peakBitrate;
        }
        String str5 = this.codecs;
        if (str5 == null) {
            String codecsOfType = Util.getCodecsOfType(format.codecs, trackType);
            if (Util.splitCodecs(codecsOfType).length == 1) {
                str5 = codecsOfType;
            }
        }
        Metadata metadata = this.metadata;
        if (metadata == null) {
            copyWithAppendedEntriesFrom = format.metadata;
        } else {
            copyWithAppendedEntriesFrom = metadata.copyWithAppendedEntriesFrom(format.metadata);
        }
        float f = this.frameRate;
        if (f == -1.0f && trackType == 2) {
            f = format.frameRate;
        }
        return buildUpon().setId(str2).setLabel(str3).setLabels(list).setLanguage(str4).setSelectionFlags(this.selectionFlags | format.selectionFlags).setRoleFlags(this.roleFlags | format.roleFlags).setAverageBitrate(i3).setPeakBitrate(i4).setCodecs(str5).setMetadata(copyWithAppendedEntriesFrom).setDrmInitData(DrmInitData.createSessionCreationData(format.drmInitData, this.drmInitData)).setFrameRate(f).setTileCountHorizontal(i).setTileCountVertical(i2).build();
    }

    public Format copyWithCryptoType(int i) {
        return buildUpon().setCryptoType(i).build();
    }

    public int getPixelCount() {
        int i;
        int i2 = this.width;
        if (i2 == -1 || (i = this.height) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public String toString() {
        return "Format(" + this.id + ", " + this.label + ", " + this.containerMimeType + ", " + this.sampleMimeType + ", " + this.codecs + ", " + this.bitrate + ", " + this.language + ", [" + this.width + ", " + this.height + ", " + this.frameRate + ", " + this.colorInfo + "], [" + this.channelCount + ", " + this.sampleRate + "])";
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            String str = this.id;
            int hashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.label;
            int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.labels.hashCode()) * 31;
            String str3 = this.language;
            int hashCode3 = (((((((((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.selectionFlags) * 31) + this.roleFlags) * 31) + this.auxiliaryTrackType) * 31) + this.averageBitrate) * 31) + this.peakBitrate) * 31;
            String str4 = this.codecs;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Metadata metadata = this.metadata;
            int hashCode5 = (hashCode4 + (metadata == null ? 0 : metadata.hashCode())) * 31;
            Object obj = this.customData;
            int hashCode6 = (hashCode5 + (obj == null ? 0 : obj.hashCode())) * 31;
            String str5 = this.containerMimeType;
            int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.sampleMimeType;
            this.hashCode = ((((((((((((((((((((((((((((((((((((hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.maxInputSize) * 31) + ((int) this.subsampleOffsetUs)) * 31) + this.width) * 31) + this.height) * 31) + Float.floatToIntBits(this.frameRate)) * 31) + this.rotationDegrees) * 31) + Float.floatToIntBits(this.pixelWidthHeightRatio)) * 31) + this.stereoMode) * 31) + this.maxSubLayers) * 31) + this.channelCount) * 31) + this.sampleRate) * 31) + this.pcmEncoding) * 31) + this.encoderDelay) * 31) + this.encoderPadding) * 31) + this.accessibilityChannel) * 31) + this.tileCountHorizontal) * 31) + this.tileCountVertical) * 31) + this.cryptoType;
        }
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Format format = (Format) obj;
            int i2 = this.hashCode;
            if ((i2 == 0 || (i = format.hashCode) == 0 || i2 == i) && this.selectionFlags == format.selectionFlags && this.roleFlags == format.roleFlags && this.auxiliaryTrackType == format.auxiliaryTrackType && this.averageBitrate == format.averageBitrate && this.peakBitrate == format.peakBitrate && this.maxInputSize == format.maxInputSize && this.subsampleOffsetUs == format.subsampleOffsetUs && this.width == format.width && this.height == format.height && this.rotationDegrees == format.rotationDegrees && this.stereoMode == format.stereoMode && this.maxSubLayers == format.maxSubLayers && this.channelCount == format.channelCount && this.sampleRate == format.sampleRate && this.pcmEncoding == format.pcmEncoding && this.encoderDelay == format.encoderDelay && this.encoderPadding == format.encoderPadding && this.accessibilityChannel == format.accessibilityChannel && this.tileCountHorizontal == format.tileCountHorizontal && this.tileCountVertical == format.tileCountVertical && this.cryptoType == format.cryptoType && Float.compare(this.frameRate, format.frameRate) == 0 && Float.compare(this.pixelWidthHeightRatio, format.pixelWidthHeightRatio) == 0 && Objects.equals(this.id, format.id) && Objects.equals(this.label, format.label) && this.labels.equals(format.labels) && Objects.equals(this.codecs, format.codecs) && Objects.equals(this.containerMimeType, format.containerMimeType) && Objects.equals(this.sampleMimeType, format.sampleMimeType) && Objects.equals(this.language, format.language) && Arrays.equals(this.projectionData, format.projectionData) && Objects.equals(this.metadata, format.metadata) && Objects.equals(this.colorInfo, format.colorInfo) && Objects.equals(this.drmInitData, format.drmInitData) && initializationDataEquals(format) && Objects.equals(this.customData, format.customData)) {
                return true;
            }
        }
        return false;
    }

    public boolean initializationDataEquals(Format format) {
        if (this.initializationData.size() != format.initializationData.size()) {
            return false;
        }
        for (int i = 0; i < this.initializationData.size(); i++) {
            if (!Arrays.equals(this.initializationData.get(i), format.initializationData.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static String toLogString(Format format) {
        if (format == null) {
            return AbstractJsonLexerKt.NULL;
        }
        Joiner on = Joiner.on((char) AbstractJsonLexerKt.COMMA);
        StringBuilder sb = new StringBuilder();
        sb.append("id=").append(format.id).append(", mimeType=").append(format.sampleMimeType);
        if (format.containerMimeType != null) {
            sb.append(", container=").append(format.containerMimeType);
        }
        if (format.bitrate != -1) {
            sb.append(", bitrate=").append(format.bitrate);
        }
        if (format.codecs != null) {
            sb.append(", codecs=").append(format.codecs);
        }
        if (format.drmInitData != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (int i = 0; i < format.drmInitData.schemeDataCount; i++) {
                UUID uuid = format.drmInitData.get(i).uuid;
                if (uuid.equals(C.COMMON_PSSH_UUID)) {
                    linkedHashSet.add(C.CENC_TYPE_cenc);
                } else if (uuid.equals(C.CLEARKEY_UUID)) {
                    linkedHashSet.add("clearkey");
                } else if (uuid.equals(C.PLAYREADY_UUID)) {
                    linkedHashSet.add("playready");
                } else if (uuid.equals(C.WIDEVINE_UUID)) {
                    linkedHashSet.add("widevine");
                } else if (uuid.equals(C.UUID_NIL)) {
                    linkedHashSet.add("universal");
                } else {
                    linkedHashSet.add("unknown (" + uuid + ")");
                }
            }
            sb.append(", drm=[");
            on.appendTo(sb, (Iterable<? extends Object>) linkedHashSet);
            sb.append(AbstractJsonLexerKt.END_LIST);
        }
        if (format.width != -1 && format.height != -1) {
            sb.append(", res=").append(format.width).append("x").append(format.height);
        }
        if (!DoubleMath.fuzzyEquals(format.pixelWidthHeightRatio, 1.0d, 0.001d)) {
            sb.append(", par=").append(Util.formatInvariant("%.3f", Float.valueOf(format.pixelWidthHeightRatio)));
        }
        ColorInfo colorInfo = format.colorInfo;
        if (colorInfo != null && colorInfo.isValid()) {
            sb.append(", color=").append(format.colorInfo.toLogString());
        }
        if (format.frameRate != -1.0f) {
            sb.append(", fps=").append(format.frameRate);
        }
        if (format.maxSubLayers != -1) {
            sb.append(", maxSubLayers=").append(format.maxSubLayers);
        }
        if (format.channelCount != -1) {
            sb.append(", channels=").append(format.channelCount);
        }
        if (format.sampleRate != -1) {
            sb.append(", sample_rate=").append(format.sampleRate);
        }
        if (format.language != null) {
            sb.append(", language=").append(format.language);
        }
        if (!format.labels.isEmpty()) {
            sb.append(", labels=[");
            on.appendTo(sb, (Iterable<? extends Object>) Lists.transform(format.labels, new Function() { // from class: androidx.media3.common.Format$$ExternalSyntheticLambda2
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return Format.lambda$toLogString$0((Label) obj);
                }
            }));
            sb.append("]");
        }
        if (format.selectionFlags != 0) {
            sb.append(", selectionFlags=[");
            on.appendTo(sb, (Iterable<? extends Object>) Util.getSelectionFlagStrings(format.selectionFlags));
            sb.append("]");
        }
        if (format.roleFlags != 0) {
            sb.append(", roleFlags=[");
            on.appendTo(sb, (Iterable<? extends Object>) Util.getRoleFlagStrings(format.roleFlags));
            sb.append("]");
        }
        if (format.customData != null) {
            sb.append(", customData=").append(format.customData);
        }
        if ((format.roleFlags & 32768) != 0) {
            sb.append(", auxiliaryTrackType=").append(Util.getAuxiliaryTrackTypeString(format.auxiliaryTrackType));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String lambda$toLogString$0(Label label) {
        return label.language + ": " + label.value;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(FIELD_ID, this.id);
        bundle.putString(FIELD_LABEL, this.label);
        bundle.putParcelableArrayList(FIELD_LABELS, BundleCollectionUtil.toBundleArrayList(this.labels, new Function() { // from class: androidx.media3.common.Format$$ExternalSyntheticLambda0
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ((Label) obj).toBundle();
            }
        }));
        bundle.putString(FIELD_LANGUAGE, this.language);
        bundle.putInt(FIELD_SELECTION_FLAGS, this.selectionFlags);
        bundle.putInt(FIELD_ROLE_FLAGS, this.roleFlags);
        int i = this.auxiliaryTrackType;
        if (i != DEFAULT.auxiliaryTrackType) {
            bundle.putInt(FIELD_AUXILIARY_TRACK_TYPE, i);
        }
        bundle.putInt(FIELD_AVERAGE_BITRATE, this.averageBitrate);
        bundle.putInt(FIELD_PEAK_BITRATE, this.peakBitrate);
        bundle.putString(FIELD_CODECS, this.codecs);
        bundle.putString(FIELD_CONTAINER_MIME_TYPE, this.containerMimeType);
        bundle.putString(FIELD_SAMPLE_MIME_TYPE, this.sampleMimeType);
        bundle.putInt(FIELD_MAX_INPUT_SIZE, this.maxInputSize);
        for (int i2 = 0; i2 < this.initializationData.size(); i2++) {
            bundle.putByteArray(keyForInitializationData(i2), this.initializationData.get(i2));
        }
        bundle.putParcelable(FIELD_DRM_INIT_DATA, this.drmInitData);
        bundle.putLong(FIELD_SUBSAMPLE_OFFSET_US, this.subsampleOffsetUs);
        bundle.putInt(FIELD_WIDTH, this.width);
        bundle.putInt(FIELD_HEIGHT, this.height);
        bundle.putFloat(FIELD_FRAME_RATE, this.frameRate);
        bundle.putInt(FIELD_ROTATION_DEGREES, this.rotationDegrees);
        bundle.putFloat(FIELD_PIXEL_WIDTH_HEIGHT_RATIO, this.pixelWidthHeightRatio);
        bundle.putByteArray(FIELD_PROJECTION_DATA, this.projectionData);
        bundle.putInt(FIELD_STEREO_MODE, this.stereoMode);
        ColorInfo colorInfo = this.colorInfo;
        if (colorInfo != null) {
            bundle.putBundle(FIELD_COLOR_INFO, colorInfo.toBundle());
        }
        bundle.putInt(FIELD_MAX_SUB_LAYERS, this.maxSubLayers);
        bundle.putInt(FIELD_CHANNEL_COUNT, this.channelCount);
        bundle.putInt(FIELD_SAMPLE_RATE, this.sampleRate);
        bundle.putInt(FIELD_PCM_ENCODING, this.pcmEncoding);
        bundle.putInt(FIELD_ENCODER_DELAY, this.encoderDelay);
        bundle.putInt(FIELD_ENCODER_PADDING, this.encoderPadding);
        bundle.putInt(FIELD_ACCESSIBILITY_CHANNEL, this.accessibilityChannel);
        bundle.putInt(FIELD_TILE_COUNT_HORIZONTAL, this.tileCountHorizontal);
        bundle.putInt(FIELD_TILE_COUNT_VERTICAL, this.tileCountVertical);
        bundle.putInt(FIELD_CRYPTO_TYPE, this.cryptoType);
        return bundle;
    }

    public static Format fromBundle(Bundle bundle) {
        ImmutableList fromBundleList;
        Builder builder = new Builder();
        BundleCollectionUtil.ensureClassLoader(bundle);
        String string = bundle.getString(FIELD_ID);
        Format format = DEFAULT;
        builder.setId((String) defaultIfNull(string, format.id)).setLabel((String) defaultIfNull(bundle.getString(FIELD_LABEL), format.label));
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(FIELD_LABELS);
        if (parcelableArrayList == null) {
            fromBundleList = ImmutableList.of();
        } else {
            fromBundleList = BundleCollectionUtil.fromBundleList(new Function() { // from class: androidx.media3.common.Format$$ExternalSyntheticLambda1
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return Label.fromBundle((Bundle) obj);
                }
            }, parcelableArrayList);
        }
        builder.setLabels(fromBundleList).setLanguage((String) defaultIfNull(bundle.getString(FIELD_LANGUAGE), format.language)).setSelectionFlags(bundle.getInt(FIELD_SELECTION_FLAGS, format.selectionFlags)).setRoleFlags(bundle.getInt(FIELD_ROLE_FLAGS, format.roleFlags)).setAuxiliaryTrackType(bundle.getInt(FIELD_AUXILIARY_TRACK_TYPE, format.auxiliaryTrackType)).setAverageBitrate(bundle.getInt(FIELD_AVERAGE_BITRATE, format.averageBitrate)).setPeakBitrate(bundle.getInt(FIELD_PEAK_BITRATE, format.peakBitrate)).setCodecs((String) defaultIfNull(bundle.getString(FIELD_CODECS), format.codecs)).setContainerMimeType((String) defaultIfNull(bundle.getString(FIELD_CONTAINER_MIME_TYPE), format.containerMimeType)).setSampleMimeType((String) defaultIfNull(bundle.getString(FIELD_SAMPLE_MIME_TYPE), format.sampleMimeType)).setMaxInputSize(bundle.getInt(FIELD_MAX_INPUT_SIZE, format.maxInputSize));
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            byte[] byteArray = bundle.getByteArray(keyForInitializationData(i));
            if (byteArray == null) {
                break;
            }
            arrayList.add(byteArray);
            i++;
        }
        Builder drmInitData = builder.setInitializationData(arrayList).setDrmInitData((DrmInitData) bundle.getParcelable(FIELD_DRM_INIT_DATA));
        String str = FIELD_SUBSAMPLE_OFFSET_US;
        Format format2 = DEFAULT;
        drmInitData.setSubsampleOffsetUs(bundle.getLong(str, format2.subsampleOffsetUs)).setWidth(bundle.getInt(FIELD_WIDTH, format2.width)).setHeight(bundle.getInt(FIELD_HEIGHT, format2.height)).setFrameRate(bundle.getFloat(FIELD_FRAME_RATE, format2.frameRate)).setRotationDegrees(bundle.getInt(FIELD_ROTATION_DEGREES, format2.rotationDegrees)).setPixelWidthHeightRatio(bundle.getFloat(FIELD_PIXEL_WIDTH_HEIGHT_RATIO, format2.pixelWidthHeightRatio)).setProjectionData(bundle.getByteArray(FIELD_PROJECTION_DATA)).setStereoMode(bundle.getInt(FIELD_STEREO_MODE, format2.stereoMode)).setMaxSubLayers(bundle.getInt(FIELD_MAX_SUB_LAYERS, format2.maxSubLayers));
        Bundle bundle2 = bundle.getBundle(FIELD_COLOR_INFO);
        if (bundle2 != null) {
            builder.setColorInfo(ColorInfo.fromBundle(bundle2));
        }
        builder.setChannelCount(bundle.getInt(FIELD_CHANNEL_COUNT, format2.channelCount)).setSampleRate(bundle.getInt(FIELD_SAMPLE_RATE, format2.sampleRate)).setPcmEncoding(bundle.getInt(FIELD_PCM_ENCODING, format2.pcmEncoding)).setEncoderDelay(bundle.getInt(FIELD_ENCODER_DELAY, format2.encoderDelay)).setEncoderPadding(bundle.getInt(FIELD_ENCODER_PADDING, format2.encoderPadding)).setAccessibilityChannel(bundle.getInt(FIELD_ACCESSIBILITY_CHANNEL, format2.accessibilityChannel)).setTileCountHorizontal(bundle.getInt(FIELD_TILE_COUNT_HORIZONTAL, format2.tileCountHorizontal)).setTileCountVertical(bundle.getInt(FIELD_TILE_COUNT_VERTICAL, format2.tileCountVertical)).setCryptoType(bundle.getInt(FIELD_CRYPTO_TYPE, format2.cryptoType));
        return builder.build();
    }

    private static String keyForInitializationData(int i) {
        return FIELD_INITIALIZATION_DATA + "_" + Integer.toString(i, 36);
    }

    private static String getDefaultLabel(List<Label> list, String str) {
        for (Label label : list) {
            if (TextUtils.equals(label.language, str)) {
                return label.value;
            }
        }
        return list.get(0).value;
    }
}
