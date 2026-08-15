package androidx.media3.common;
/* loaded from: classes3.dex */
public final class VideoFrameProcessingException extends Exception {
    public final long presentationTimeUs;

    public static VideoFrameProcessingException from(Exception exc) {
        return from(exc, C.TIME_UNSET);
    }

    public static VideoFrameProcessingException from(Exception exc, long j) {
        if (exc instanceof VideoFrameProcessingException) {
            return (VideoFrameProcessingException) exc;
        }
        return new VideoFrameProcessingException(exc, j);
    }

    public VideoFrameProcessingException(String str) {
        this(str, (long) C.TIME_UNSET);
    }

    public VideoFrameProcessingException(String str, long j) {
        super(str + getPresentationTimeUsString(j));
        this.presentationTimeUs = j;
    }

    public VideoFrameProcessingException(String str, Throwable th) {
        this(str, th, C.TIME_UNSET);
    }

    public VideoFrameProcessingException(String str, Throwable th, long j) {
        super(str + getPresentationTimeUsString(j), th);
        this.presentationTimeUs = j;
    }

    public VideoFrameProcessingException(Throwable th) {
        this(th, (long) C.TIME_UNSET);
    }

    public VideoFrameProcessingException(Throwable th, long j) {
        super(getPresentationTimeUsString(j), th);
        this.presentationTimeUs = j;
    }

    private static String getPresentationTimeUsString(long j) {
        return j == C.TIME_UNSET ? " @UNSET" : " @" + j;
    }
}
