package androidx.media3.exoplayer;

import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.metadata.MetadataRenderer;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.text.TextRenderer;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import java.io.IOException;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class RendererHolder {
    static final int RENDERER_PREWARMING_STATE_NOT_PREWARMING_USING_PRIMARY = 0;
    static final int RENDERER_PREWARMING_STATE_NOT_PREWARMING_USING_SECONDARY = 1;
    static final int RENDERER_PREWARMING_STATE_PREWARMING_PRIMARY = 2;
    static final int RENDERER_PREWARMING_STATE_TRANSITIONING_TO_PRIMARY = 4;
    static final int RENDERER_PREWARMING_STATE_TRANSITIONING_TO_SECONDARY = 3;
    static final int REPLACE_STREAMS_DISABLE_RENDERERS_COMPLETED = 1;
    static final int REPLACE_STREAMS_DISABLE_RENDERERS_DISABLE_OFFLOAD_SCHEDULING = 2;
    private final int index;
    private final Renderer primaryRenderer;
    private final Renderer secondaryRenderer;
    private int prewarmingState = 0;
    private boolean primaryRequiresReset = false;
    private boolean secondaryRequiresReset = false;

    public RendererHolder(Renderer renderer, Renderer renderer2, int i) {
        this.primaryRenderer = renderer;
        this.index = i;
        this.secondaryRenderer = renderer2;
    }

    public boolean hasSecondary() {
        return this.secondaryRenderer != null;
    }

    public void startPrewarming() {
        int i;
        Assertions.checkState(!isPrewarming());
        if (isRendererEnabled(this.primaryRenderer)) {
            i = 3;
        } else {
            Renderer renderer = this.secondaryRenderer;
            i = (renderer == null || !isRendererEnabled(renderer)) ? 2 : 4;
        }
        this.prewarmingState = i;
    }

    public boolean isPrewarming() {
        return isPrimaryRendererPrewarming() || isSecondaryRendererPrewarming();
    }

    public boolean isRendererPrewarming(int i) {
        return (isPrimaryRendererPrewarming() && i == this.index) || (isSecondaryRendererPrewarming() && i != this.index);
    }

    private boolean isPrimaryRendererPrewarming() {
        int i = this.prewarmingState;
        return i == 2 || i == 4;
    }

    private boolean isSecondaryRendererPrewarming() {
        return this.prewarmingState == 3;
    }

    public int getEnabledRendererCount() {
        boolean isRendererEnabled = isRendererEnabled(this.primaryRenderer);
        Renderer renderer = this.secondaryRenderer;
        return (isRendererEnabled ? 1 : 0) + ((renderer == null || !isRendererEnabled(renderer)) ? 0 : 1);
    }

    public int getTrackType() {
        return this.primaryRenderer.getTrackType();
    }

    public long getReadingPositionUs(MediaPeriodHolder mediaPeriodHolder) {
        return ((Renderer) Objects.requireNonNull(getRendererReadingFromPeriod(mediaPeriodHolder))).getReadingPositionUs();
    }

    public boolean hasReadPeriodToEnd(MediaPeriodHolder mediaPeriodHolder) {
        return ((Renderer) Assertions.checkNotNull(getRendererReadingFromPeriod(mediaPeriodHolder))).hasReadStreamToEnd();
    }

    public void setCurrentStreamFinal(MediaPeriodHolder mediaPeriodHolder, long j) {
        setCurrentStreamFinalInternal((Renderer) Assertions.checkNotNull(getRendererReadingFromPeriod(mediaPeriodHolder)), j);
    }

    public void maybeSetOldStreamToFinal(TrackSelectorResult trackSelectorResult, TrackSelectorResult trackSelectorResult2, long j) {
        int i;
        boolean isRendererEnabled = trackSelectorResult.isRendererEnabled(this.index);
        boolean isRendererEnabled2 = trackSelectorResult2.isRendererEnabled(this.index);
        Renderer renderer = (this.secondaryRenderer == null || (i = this.prewarmingState) == 3 || (i == 0 && isRendererEnabled(this.primaryRenderer))) ? this.primaryRenderer : (Renderer) Assertions.checkNotNull(this.secondaryRenderer);
        if (!isRendererEnabled || renderer.isCurrentStreamFinal()) {
            return;
        }
        boolean z = getTrackType() == -2;
        RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[this.index];
        RendererConfiguration rendererConfiguration2 = trackSelectorResult2.rendererConfigurations[this.index];
        if (!isRendererEnabled2 || !Objects.equals(rendererConfiguration2, rendererConfiguration) || z || isPrewarming()) {
            setCurrentStreamFinalInternal(renderer, j);
        }
    }

    public void setAllNonPrewarmingRendererStreamsFinal(long j) {
        int i;
        if (isRendererEnabled(this.primaryRenderer) && (i = this.prewarmingState) != 4 && i != 2) {
            setCurrentStreamFinalInternal(this.primaryRenderer, j);
        }
        Renderer renderer = this.secondaryRenderer;
        if (renderer == null || !isRendererEnabled(renderer) || this.prewarmingState == 3) {
            return;
        }
        setCurrentStreamFinalInternal(this.secondaryRenderer, j);
    }

    private void setCurrentStreamFinalInternal(Renderer renderer, long j) {
        renderer.setCurrentStreamFinal();
        if (renderer instanceof TextRenderer) {
            ((TextRenderer) renderer).setFinalStreamEndPositionUs(j);
        }
    }

    public long getMinDurationToProgressUs(long j, long j2) {
        long durationToProgressUs = isRendererEnabled(this.primaryRenderer) ? this.primaryRenderer.getDurationToProgressUs(j, j2) : Long.MAX_VALUE;
        Renderer renderer = this.secondaryRenderer;
        return (renderer == null || !isRendererEnabled(renderer)) ? durationToProgressUs : Math.min(durationToProgressUs, this.secondaryRenderer.getDurationToProgressUs(j, j2));
    }

    public void enableMayRenderStartOfStream() {
        if (isRendererEnabled(this.primaryRenderer)) {
            this.primaryRenderer.enableMayRenderStartOfStream();
            return;
        }
        Renderer renderer = this.secondaryRenderer;
        if (renderer == null || !isRendererEnabled(renderer)) {
            return;
        }
        this.secondaryRenderer.enableMayRenderStartOfStream();
    }

    public void setPlaybackSpeed(float f, float f2) throws ExoPlaybackException {
        this.primaryRenderer.setPlaybackSpeed(f, f2);
        Renderer renderer = this.secondaryRenderer;
        if (renderer != null) {
            renderer.setPlaybackSpeed(f, f2);
        }
    }

    public void setTimeline(Timeline timeline) {
        this.primaryRenderer.setTimeline(timeline);
        Renderer renderer = this.secondaryRenderer;
        if (renderer != null) {
            renderer.setTimeline(timeline);
        }
    }

    public boolean isEnded() {
        boolean isEnded = isRendererEnabled(this.primaryRenderer) ? this.primaryRenderer.isEnded() : true;
        Renderer renderer = this.secondaryRenderer;
        return (renderer == null || !isRendererEnabled(renderer)) ? isEnded : isEnded & this.secondaryRenderer.isEnded();
    }

    public boolean isReadingFromPeriod(MediaPeriodHolder mediaPeriodHolder) {
        return getRendererReadingFromPeriod(mediaPeriodHolder) != null;
    }

    public boolean hasFinishedReadingFromPeriod(MediaPeriodHolder mediaPeriodHolder) {
        return hasFinishedReadingFromPeriodInternal(mediaPeriodHolder, this.primaryRenderer) && hasFinishedReadingFromPeriodInternal(mediaPeriodHolder, this.secondaryRenderer);
    }

    private boolean hasFinishedReadingFromPeriodInternal(MediaPeriodHolder mediaPeriodHolder, Renderer renderer) {
        if (renderer == null) {
            return true;
        }
        SampleStream sampleStream = mediaPeriodHolder.sampleStreams[this.index];
        if (renderer.getStream() == null || (renderer.getStream() == sampleStream && (sampleStream == null || renderer.hasReadStreamToEnd() || hasReachedServerSideInsertedAdsTransition(renderer, mediaPeriodHolder)))) {
            return true;
        }
        MediaPeriodHolder next = mediaPeriodHolder.getNext();
        return next != null && next.sampleStreams[this.index] == renderer.getStream();
    }

    private boolean hasReachedServerSideInsertedAdsTransition(Renderer renderer, MediaPeriodHolder mediaPeriodHolder) {
        MediaPeriodHolder next = mediaPeriodHolder.getNext();
        if (mediaPeriodHolder.info.isFollowedByTransitionToSameStream && next != null && next.prepared) {
            return (renderer instanceof TextRenderer) || (renderer instanceof MetadataRenderer) || renderer.getReadingPositionUs() >= next.getStartPositionRendererTime();
        }
        return false;
    }

    public void render(long j, long j2) throws ExoPlaybackException {
        if (isRendererEnabled(this.primaryRenderer)) {
            this.primaryRenderer.render(j, j2);
        }
        Renderer renderer = this.secondaryRenderer;
        if (renderer == null || !isRendererEnabled(renderer)) {
            return;
        }
        this.secondaryRenderer.render(j, j2);
    }

    public boolean allowsPlayback(MediaPeriodHolder mediaPeriodHolder) {
        Renderer rendererReadingFromPeriod = getRendererReadingFromPeriod(mediaPeriodHolder);
        return rendererReadingFromPeriod == null || rendererReadingFromPeriod.hasReadStreamToEnd() || rendererReadingFromPeriod.isReady() || rendererReadingFromPeriod.isEnded();
    }

    public void maybeThrowStreamError(MediaPeriodHolder mediaPeriodHolder) throws IOException {
        ((Renderer) Assertions.checkNotNull(getRendererReadingFromPeriod(mediaPeriodHolder))).maybeThrowStreamError();
    }

    public void start() throws ExoPlaybackException {
        if (this.primaryRenderer.getState() == 1 && this.prewarmingState != 4) {
            this.primaryRenderer.start();
            return;
        }
        Renderer renderer = this.secondaryRenderer;
        if (renderer == null || renderer.getState() != 1 || this.prewarmingState == 3) {
            return;
        }
        this.secondaryRenderer.start();
    }

    public void stop() {
        if (isRendererEnabled(this.primaryRenderer)) {
            ensureStopped(this.primaryRenderer);
        }
        Renderer renderer = this.secondaryRenderer;
        if (renderer == null || !isRendererEnabled(renderer)) {
            return;
        }
        ensureStopped(this.secondaryRenderer);
    }

    private void ensureStopped(Renderer renderer) {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }

    public void enable(RendererConfiguration rendererConfiguration, ExoTrackSelection exoTrackSelection, SampleStream sampleStream, long j, boolean z, boolean z2, long j2, long j3, MediaSource.MediaPeriodId mediaPeriodId, DefaultMediaClock defaultMediaClock) throws ExoPlaybackException {
        Format[] formats = getFormats(exoTrackSelection);
        int i = this.prewarmingState;
        if (i == 0 || i == 2 || i == 4) {
            this.primaryRequiresReset = true;
            this.primaryRenderer.enable(rendererConfiguration, formats, sampleStream, j, z, z2, j2, j3, mediaPeriodId);
            defaultMediaClock.onRendererEnabled(this.primaryRenderer);
            return;
        }
        this.secondaryRequiresReset = true;
        ((Renderer) Assertions.checkNotNull(this.secondaryRenderer)).enable(rendererConfiguration, formats, sampleStream, j, z, z2, j2, j3, mediaPeriodId);
        defaultMediaClock.onRendererEnabled(this.secondaryRenderer);
    }

    public void handleMessage(int i, Object obj, MediaPeriodHolder mediaPeriodHolder) throws ExoPlaybackException {
        ((Renderer) Assertions.checkNotNull(getRendererReadingFromPeriod(mediaPeriodHolder))).handleMessage(i, obj);
    }

    public void disable(DefaultMediaClock defaultMediaClock) throws ExoPlaybackException {
        disableRenderer(this.primaryRenderer, defaultMediaClock);
        Renderer renderer = this.secondaryRenderer;
        if (renderer != null) {
            boolean z = isRendererEnabled(renderer) && this.prewarmingState != 3;
            disableRenderer(this.secondaryRenderer, defaultMediaClock);
            maybeResetRenderer(false);
            if (z) {
                transferResources(true);
            }
        }
        this.prewarmingState = 0;
    }

    public void maybeHandlePrewarmingTransition() throws ExoPlaybackException {
        int i = this.prewarmingState;
        if (i == 3 || i == 4) {
            transferResources(i == 4);
            this.prewarmingState = this.prewarmingState != 4 ? 1 : 0;
        } else if (i == 2) {
            this.prewarmingState = 0;
        }
    }

    private void transferResources(boolean z) throws ExoPlaybackException {
        if (z) {
            ((Renderer) Assertions.checkNotNull(this.secondaryRenderer)).handleMessage(17, this.primaryRenderer);
        } else {
            this.primaryRenderer.handleMessage(17, Assertions.checkNotNull(this.secondaryRenderer));
        }
    }

    public void disablePrewarming(DefaultMediaClock defaultMediaClock) {
        if (isPrewarming()) {
            int i = this.prewarmingState;
            boolean z = i == 4 || i == 2;
            int i2 = i == 4 ? 1 : 0;
            disableRenderer(z ? this.primaryRenderer : (Renderer) Assertions.checkNotNull(this.secondaryRenderer), defaultMediaClock);
            maybeResetRenderer(z);
            this.prewarmingState = i2;
        }
    }

    public void maybeDisableOrResetPosition(SampleStream sampleStream, DefaultMediaClock defaultMediaClock, long j, boolean z) throws ExoPlaybackException {
        maybeDisableOrResetPositionInternal(this.primaryRenderer, sampleStream, defaultMediaClock, j, z);
        Renderer renderer = this.secondaryRenderer;
        if (renderer != null) {
            maybeDisableOrResetPositionInternal(renderer, sampleStream, defaultMediaClock, j, z);
        }
    }

    private void maybeDisableOrResetPositionInternal(Renderer renderer, SampleStream sampleStream, DefaultMediaClock defaultMediaClock, long j, boolean z) throws ExoPlaybackException {
        if (isRendererEnabled(renderer)) {
            if (sampleStream != renderer.getStream()) {
                disableRenderer(renderer, defaultMediaClock);
            } else if (z) {
                renderer.resetPosition(j);
            }
        }
    }

    private void disableRenderer(Renderer renderer, DefaultMediaClock defaultMediaClock) {
        Assertions.checkState(this.primaryRenderer == renderer || this.secondaryRenderer == renderer);
        if (isRendererEnabled(renderer)) {
            defaultMediaClock.onRendererDisabled(renderer);
            ensureStopped(renderer);
            renderer.disable();
        }
    }

    public void resetPosition(MediaPeriodHolder mediaPeriodHolder, long j) throws ExoPlaybackException {
        Renderer rendererReadingFromPeriod = getRendererReadingFromPeriod(mediaPeriodHolder);
        if (rendererReadingFromPeriod != null) {
            rendererReadingFromPeriod.resetPosition(j);
        }
    }

    public void reset() {
        if (!isRendererEnabled(this.primaryRenderer)) {
            maybeResetRenderer(true);
        }
        Renderer renderer = this.secondaryRenderer;
        if (renderer == null || isRendererEnabled(renderer)) {
            return;
        }
        maybeResetRenderer(false);
    }

    private void maybeResetRenderer(boolean z) {
        if (z) {
            if (this.primaryRequiresReset) {
                this.primaryRenderer.reset();
                this.primaryRequiresReset = false;
            }
        } else if (this.secondaryRequiresReset) {
            ((Renderer) Assertions.checkNotNull(this.secondaryRenderer)).reset();
            this.secondaryRequiresReset = false;
        }
    }

    public int replaceStreamsOrDisableRendererForTransition(MediaPeriodHolder mediaPeriodHolder, TrackSelectorResult trackSelectorResult, DefaultMediaClock defaultMediaClock) throws ExoPlaybackException {
        int replaceStreamsOrDisableRendererForTransitionInternal = replaceStreamsOrDisableRendererForTransitionInternal(this.primaryRenderer, mediaPeriodHolder, trackSelectorResult, defaultMediaClock);
        return replaceStreamsOrDisableRendererForTransitionInternal == 1 ? replaceStreamsOrDisableRendererForTransitionInternal(this.secondaryRenderer, mediaPeriodHolder, trackSelectorResult, defaultMediaClock) : replaceStreamsOrDisableRendererForTransitionInternal;
    }

    private int replaceStreamsOrDisableRendererForTransitionInternal(Renderer renderer, MediaPeriodHolder mediaPeriodHolder, TrackSelectorResult trackSelectorResult, DefaultMediaClock defaultMediaClock) throws ExoPlaybackException {
        if (renderer == null || !isRendererEnabled(renderer) || ((renderer == this.primaryRenderer && isPrimaryRendererPrewarming()) || (renderer == this.secondaryRenderer && isSecondaryRendererPrewarming()))) {
            return 1;
        }
        SampleStream stream = renderer.getStream();
        SampleStream[] sampleStreamArr = mediaPeriodHolder.sampleStreams;
        int i = this.index;
        boolean z = stream != sampleStreamArr[i];
        boolean isRendererEnabled = trackSelectorResult.isRendererEnabled(i);
        if (!isRendererEnabled || z) {
            if (!renderer.isCurrentStreamFinal()) {
                renderer.replaceStream(getFormats(trackSelectorResult.selections[this.index]), (SampleStream) Assertions.checkNotNull(mediaPeriodHolder.sampleStreams[this.index]), mediaPeriodHolder.getStartPositionRendererTime(), mediaPeriodHolder.getRendererOffset(), mediaPeriodHolder.info.id);
                return 3;
            } else if (renderer.isEnded()) {
                disableRenderer(renderer, defaultMediaClock);
                if (!isRendererEnabled || isPrewarming()) {
                    maybeResetRenderer(renderer == this.primaryRenderer);
                }
                return 1;
            } else {
                return 0;
            }
        }
        return 1;
    }

    private static Format[] getFormats(ExoTrackSelection exoTrackSelection) {
        int length = exoTrackSelection != null ? exoTrackSelection.length() : 0;
        Format[] formatArr = new Format[length];
        for (int i = 0; i < length; i++) {
            formatArr[i] = ((ExoTrackSelection) Assertions.checkNotNull(exoTrackSelection)).getFormat(i);
        }
        return formatArr;
    }

    public void release() {
        this.primaryRenderer.release();
        this.primaryRequiresReset = false;
        Renderer renderer = this.secondaryRenderer;
        if (renderer != null) {
            renderer.release();
            this.secondaryRequiresReset = false;
        }
    }

    public void setVideoOutput(Object obj) throws ExoPlaybackException {
        if (getTrackType() != 2) {
            return;
        }
        int i = this.prewarmingState;
        if (i == 4 || i == 1) {
            ((Renderer) Assertions.checkNotNull(this.secondaryRenderer)).handleMessage(1, obj);
        } else {
            this.primaryRenderer.handleMessage(1, obj);
        }
    }

    public void setVolume(float f) throws ExoPlaybackException {
        if (getTrackType() != 1) {
            return;
        }
        this.primaryRenderer.handleMessage(2, Float.valueOf(f));
        Renderer renderer = this.secondaryRenderer;
        if (renderer != null) {
            renderer.handleMessage(2, Float.valueOf(f));
        }
    }

    public boolean isRendererEnabled() {
        int i = this.prewarmingState;
        if (i == 0 || i == 2 || i == 4) {
            return isRendererEnabled(this.primaryRenderer);
        }
        return isRendererEnabled((Renderer) Assertions.checkNotNull(this.secondaryRenderer));
    }

    private static boolean isRendererEnabled(Renderer renderer) {
        return renderer.getState() != 0;
    }

    private Renderer getRendererReadingFromPeriod(MediaPeriodHolder mediaPeriodHolder) {
        if (mediaPeriodHolder != null && mediaPeriodHolder.sampleStreams[this.index] != null) {
            if (this.primaryRenderer.getStream() == mediaPeriodHolder.sampleStreams[this.index]) {
                return this.primaryRenderer;
            }
            Renderer renderer = this.secondaryRenderer;
            if (renderer != null && renderer.getStream() == mediaPeriodHolder.sampleStreams[this.index]) {
                return this.secondaryRenderer;
            }
        }
        return null;
    }
}
