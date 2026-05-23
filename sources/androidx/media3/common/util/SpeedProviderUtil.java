package androidx.media3.common.util;

import androidx.media3.common.C;
import androidx.media3.common.audio.SpeedProvider;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Floats;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SpeedProviderUtil {
    private SpeedProviderUtil() {
    }

    public static long getDurationAfterSpeedProviderApplied(SpeedProvider speedProvider, long j) {
        long j2 = 0;
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        while (j2 < j) {
            long nextSpeedChangeTimeUs = speedProvider.getNextSpeedChangeTimeUs(j2);
            if (nextSpeedChangeTimeUs == C.TIME_UNSET) {
                nextSpeedChangeTimeUs = Long.MAX_VALUE;
            }
            Preconditions.checkState(nextSpeedChangeTimeUs > j2);
            d += (Math.min(nextSpeedChangeTimeUs, j) - j2) / speedProvider.getSpeed(j2);
            j2 = nextSpeedChangeTimeUs;
        }
        return (long) Math.floor(d);
    }

    public static float getSampleAlignedSpeed(SpeedProvider speedProvider, long j, int i) {
        Preconditions.checkArgument(j >= 0);
        Preconditions.checkArgument(i > 0);
        return speedProvider.getSpeed(Util.sampleCountToDurationUs(j, i));
    }

    public static long getNextSpeedChangeSamplePosition(SpeedProvider speedProvider, long j, int i) {
        Preconditions.checkArgument(j >= 0);
        Preconditions.checkArgument(i > 0);
        long nextSpeedChangeTimeUs = speedProvider.getNextSpeedChangeTimeUs(Util.sampleCountToDurationUs(j, i));
        if (nextSpeedChangeTimeUs == C.TIME_UNSET) {
            return -1L;
        }
        return Util.durationUsToSampleCount(nextSpeedChangeTimeUs, i);
    }

    /* loaded from: classes2.dex */
    public static final class SpeedProviderMapper {
        private final long[] inputSegmentStartTimesUs;
        private final long[] outputSegmentStartTimesUs;
        private final float[] speeds;

        public SpeedProviderMapper(SpeedProvider speedProvider) {
            LongArray longArray = new LongArray();
            LongArray longArray2 = new LongArray();
            ArrayList arrayList = new ArrayList();
            float speed = speedProvider.getSpeed(0L);
            longArray.add(0L);
            longArray2.add(0L);
            arrayList.add(Float.valueOf(speed));
            long nextSpeedChangeTimeUs = speedProvider.getNextSpeedChangeTimeUs(0L);
            Preconditions.checkState(speed > 0.0f);
            long j = 0;
            long j2 = nextSpeedChangeTimeUs;
            float f = speed;
            long j3 = 0;
            while (j2 != C.TIME_UNSET) {
                Preconditions.checkState(j2 > j3);
                Preconditions.checkState(f > 0.0f);
                j += Util.getPlayoutDurationForMediaDuration(j2 - j3, f);
                f = speedProvider.getSpeed(j2);
                longArray.add(j);
                longArray2.add(j2);
                arrayList.add(Float.valueOf(f));
                j3 = j2;
                j2 = speedProvider.getNextSpeedChangeTimeUs(j2);
            }
            this.outputSegmentStartTimesUs = longArray.toArray();
            this.inputSegmentStartTimesUs = longArray2.toArray();
            this.speeds = Floats.toArray(arrayList);
        }

        public long getAdjustedTimeUs(long j) {
            Preconditions.checkArgument((j == C.TIME_UNSET || j == Long.MIN_VALUE) ? false : true);
            Preconditions.checkArgument(j >= 0);
            int binarySearchFloor = Util.binarySearchFloor(this.inputSegmentStartTimesUs, j, true, true);
            return this.outputSegmentStartTimesUs[binarySearchFloor] + Util.getPlayoutDurationForMediaDuration(j - this.inputSegmentStartTimesUs[binarySearchFloor], this.speeds[binarySearchFloor]);
        }

        public long getOriginalTimeUs(long j) {
            Preconditions.checkArgument((j == C.TIME_UNSET || j == Long.MIN_VALUE) ? false : true);
            Preconditions.checkArgument(j >= 0);
            int binarySearchFloor = Util.binarySearchFloor(this.outputSegmentStartTimesUs, j, true, true);
            return this.inputSegmentStartTimesUs[binarySearchFloor] + Util.getMediaDurationForPlayoutDuration(j - this.outputSegmentStartTimesUs[binarySearchFloor], this.speeds[binarySearchFloor]);
        }
    }
}
