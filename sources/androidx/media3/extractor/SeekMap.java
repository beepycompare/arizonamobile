package androidx.media3.extractor;

import androidx.media3.common.util.Assertions;
/* loaded from: classes2.dex */
public interface SeekMap {
    long getDurationUs();

    SeekPoints getSeekPoints(long j);

    boolean isSeekable();

    /* loaded from: classes2.dex */
    public static class Unseekable implements SeekMap {
        private final long durationUs;
        private final SeekPoints startSeekPoints;

        @Override // androidx.media3.extractor.SeekMap
        public boolean isSeekable() {
            return false;
        }

        public Unseekable(long j) {
            this(j, 0L);
        }

        public Unseekable(long j, long j2) {
            this.durationUs = j;
            this.startSeekPoints = new SeekPoints(j2 == 0 ? SeekPoint.START : new SeekPoint(0L, j2));
        }

        @Override // androidx.media3.extractor.SeekMap
        public long getDurationUs() {
            return this.durationUs;
        }

        @Override // androidx.media3.extractor.SeekMap
        public SeekPoints getSeekPoints(long j) {
            return this.startSeekPoints;
        }
    }

    /* loaded from: classes2.dex */
    public static final class SeekPoints {
        public final SeekPoint first;
        public final SeekPoint second;

        public SeekPoints(SeekPoint seekPoint) {
            this(seekPoint, seekPoint);
        }

        public SeekPoints(SeekPoint seekPoint, SeekPoint seekPoint2) {
            this.first = (SeekPoint) Assertions.checkNotNull(seekPoint);
            this.second = (SeekPoint) Assertions.checkNotNull(seekPoint2);
        }

        public String toString() {
            return "[" + this.first + (this.first.equals(this.second) ? "" : ", " + this.second) + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                SeekPoints seekPoints = (SeekPoints) obj;
                if (this.first.equals(seekPoints.first) && this.second.equals(seekPoints.second)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }
    }
}
