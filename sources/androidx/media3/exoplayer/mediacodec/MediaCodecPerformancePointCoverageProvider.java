package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodecInfo;
import android.os.Build;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class MediaCodecPerformancePointCoverageProvider {
    static final int COVERAGE_RESULT_NO = 1;
    static final int COVERAGE_RESULT_NO_PERFORMANCE_POINTS_UNSUPPORTED = 0;
    static final int COVERAGE_RESULT_YES = 2;
    private static Boolean shouldIgnorePerformancePoints;

    private MediaCodecPerformancePointCoverageProvider() {
    }

    public static int areResolutionAndFrameRateCovered(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        if (Build.VERSION.SDK_INT >= 29) {
            Boolean bool = shouldIgnorePerformancePoints;
            if (bool == null || !bool.booleanValue()) {
                return Api29.areResolutionAndFrameRateCovered(videoCapabilities, i, i2, d);
            }
            return 0;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Api29 {
        private Api29() {
        }

        public static int areResolutionAndFrameRateCovered(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
            List<MediaCodecInfo.VideoCapabilities.PerformancePoint> supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints();
            if (supportedPerformancePoints == null || supportedPerformancePoints.isEmpty()) {
                return 0;
            }
            int evaluatePerformancePointCoverage = evaluatePerformancePointCoverage(supportedPerformancePoints, new MediaCodecInfo.VideoCapabilities.PerformancePoint(i, i2, (int) d));
            if (evaluatePerformancePointCoverage == 1 && MediaCodecPerformancePointCoverageProvider.shouldIgnorePerformancePoints == null) {
                Boolean unused = MediaCodecPerformancePointCoverageProvider.shouldIgnorePerformancePoints = Boolean.valueOf(shouldIgnorePerformancePoints());
                if (MediaCodecPerformancePointCoverageProvider.shouldIgnorePerformancePoints.booleanValue()) {
                    return 0;
                }
            }
            return evaluatePerformancePointCoverage;
        }

        private static boolean shouldIgnorePerformancePoints() {
            if (Build.VERSION.SDK_INT >= 37) {
                return false;
            }
            int evaluateH264RequiredSupport = evaluateH264RequiredSupport(true);
            return Build.VERSION.SDK_INT >= 35 ? evaluateH264RequiredSupport == 1 : evaluateH264RequiredSupport(false) != 2 || evaluateH264RequiredSupport == 1;
        }

        private static int evaluateH264RequiredSupport(boolean z) {
            MediaCodecInfo.VideoCapabilities videoCapabilities;
            List<MediaCodecInfo.VideoCapabilities.PerformancePoint> supportedPerformancePoints;
            try {
                Format build = new Format.Builder().setSampleMimeType(MimeTypes.VIDEO_H264).build();
                if (build.sampleMimeType != null) {
                    List<MediaCodecInfo> decoderInfosSoftMatch = MediaCodecUtil.getDecoderInfosSoftMatch(MediaCodecSelector.DEFAULT, build, z, false);
                    for (int i = 0; i < decoderInfosSoftMatch.size(); i++) {
                        if (decoderInfosSoftMatch.get(i).capabilities != null && (videoCapabilities = decoderInfosSoftMatch.get(i).capabilities.getVideoCapabilities()) != null && (supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints()) != null && !supportedPerformancePoints.isEmpty()) {
                            return evaluatePerformancePointCoverage(supportedPerformancePoints, new MediaCodecInfo.VideoCapabilities.PerformancePoint(1280, 720, 60));
                        }
                    }
                }
            } catch (MediaCodecUtil.DecoderQueryException unused) {
            }
            return 0;
        }

        private static int evaluatePerformancePointCoverage(List<MediaCodecInfo.VideoCapabilities.PerformancePoint> list, MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).covers(performancePoint)) {
                    return 2;
                }
            }
            return 1;
        }
    }
}
