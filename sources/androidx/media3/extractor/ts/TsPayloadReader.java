package androidx.media3.extractor.ts;

import android.util.SparseArray;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.extractor.ExtractorOutput;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public interface TsPayloadReader {
    public static final int FLAG_DATA_ALIGNMENT_INDICATOR = 4;
    public static final int FLAG_PAYLOAD_UNIT_START_INDICATOR = 1;
    public static final int FLAG_RANDOM_ACCESS_INDICATOR = 2;

    /* loaded from: classes2.dex */
    public interface Factory {
        SparseArray<TsPayloadReader> createInitialPayloadReaders();

        TsPayloadReader createPayloadReader(int i, EsInfo esInfo);
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Flags {
    }

    void consume(ParsableByteArray parsableByteArray, int i) throws ParserException;

    void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator);

    void seek();

    /* loaded from: classes2.dex */
    public static final class EsInfo {
        public static final int AUDIO_TYPE_CLEAN_EFFECTS = 1;
        public static final int AUDIO_TYPE_HEARING_IMPAIRED = 2;
        public static final int AUDIO_TYPE_UNDEFINED = 0;
        public static final int AUDIO_TYPE_VISUAL_IMPAIRED_COMMENTARY = 3;
        public final int audioType;
        public final byte[] descriptorBytes;
        public final List<DvbSubtitleInfo> dvbSubtitleInfos;
        public final String language;
        public final int streamType;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes2.dex */
        public @interface AudioType {
        }

        public int getRoleFlags() {
            int i = this.audioType;
            if (i != 2) {
                return i != 3 ? 0 : 512;
            }
            return 2048;
        }

        public EsInfo(int i, String str, int i2, List<DvbSubtitleInfo> list, byte[] bArr) {
            List<DvbSubtitleInfo> unmodifiableList;
            this.streamType = i;
            this.language = str;
            this.audioType = i2;
            if (list == null) {
                unmodifiableList = Collections.emptyList();
            } else {
                unmodifiableList = Collections.unmodifiableList(list);
            }
            this.dvbSubtitleInfos = unmodifiableList;
            this.descriptorBytes = bArr;
        }
    }

    /* loaded from: classes2.dex */
    public static final class DvbSubtitleInfo {
        public final byte[] initializationData;
        public final String language;
        public final int type;

        public DvbSubtitleInfo(String str, int i, byte[] bArr) {
            this.language = str;
            this.type = i;
            this.initializationData = bArr;
        }
    }

    /* loaded from: classes2.dex */
    public static final class TrackIdGenerator {
        private static final int ID_UNSET = Integer.MIN_VALUE;
        private final int firstTrackId;
        private String formatId;
        private final String formatIdPrefix;
        private int trackId;
        private final int trackIdIncrement;

        public TrackIdGenerator(int i, int i2) {
            this(Integer.MIN_VALUE, i, i2);
        }

        public TrackIdGenerator(int i, int i2, int i3) {
            this.formatIdPrefix = i != Integer.MIN_VALUE ? i + RemoteSettings.FORWARD_SLASH_STRING : "";
            this.firstTrackId = i2;
            this.trackIdIncrement = i3;
            this.trackId = Integer.MIN_VALUE;
            this.formatId = "";
        }

        public void generateNewId() {
            int i = this.trackId;
            this.trackId = i == Integer.MIN_VALUE ? this.firstTrackId : i + this.trackIdIncrement;
            this.formatId = this.formatIdPrefix + this.trackId;
        }

        public int getTrackId() {
            maybeThrowUninitializedError();
            return this.trackId;
        }

        public String getFormatId() {
            maybeThrowUninitializedError();
            return this.formatId;
        }

        private void maybeThrowUninitializedError() {
            if (this.trackId == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }
    }
}
