package androidx.media3.common.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
/* loaded from: classes2.dex */
public final class SonicAudioProcessor implements AudioProcessor {
    private static final float CLOSE_THRESHOLD = 1.0E-4f;
    private static final int MIN_BYTES_FOR_DURATION_SCALING_CALCULATION = 1024;
    public static final int SAMPLE_RATE_NO_CHANGE = -1;
    private ByteBuffer buffer;
    private AudioProcessor.AudioFormat inputAudioFormat;
    private long inputBytes;
    private boolean inputEnded;
    private AudioProcessor.AudioFormat outputAudioFormat;
    private ByteBuffer outputBuffer;
    private long outputBytes;
    private AudioProcessor.AudioFormat pendingInputAudioFormat;
    private AudioProcessor.AudioFormat pendingOutputAudioFormat;
    private int pendingOutputSampleRate;
    private boolean pendingSonicRecreation;
    private float pitch;
    private ShortBuffer shortBuffer;
    private final boolean shouldBeActiveWithDefaultParameters;
    private Sonic sonic;
    private float speed;

    public SonicAudioProcessor() {
        this(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SonicAudioProcessor(boolean z) {
        this.speed = 1.0f;
        this.pitch = 1.0f;
        this.pendingInputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.pendingOutputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.inputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.outputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
        ByteBuffer byteBuffer = EMPTY_BUFFER;
        this.buffer = byteBuffer;
        this.shortBuffer = byteBuffer.asShortBuffer();
        this.outputBuffer = EMPTY_BUFFER;
        this.pendingOutputSampleRate = -1;
        this.shouldBeActiveWithDefaultParameters = z;
    }

    public void setSpeed(float f) {
        Assertions.checkArgument(f > 0.0f);
        if (this.speed != f) {
            this.speed = f;
            this.pendingSonicRecreation = true;
        }
    }

    public void setPitch(float f) {
        Assertions.checkArgument(f > 0.0f);
        if (this.pitch != f) {
            this.pitch = f;
            this.pendingSonicRecreation = true;
        }
    }

    public void setOutputSampleRateHz(int i) {
        Assertions.checkArgument(i == -1 || i > 0);
        this.pendingOutputSampleRate = i;
    }

    public long getMediaDuration(long j) {
        if (this.outputBytes >= 1024) {
            long pendingInputBytes = this.inputBytes - ((Sonic) Assertions.checkNotNull(this.sonic)).getPendingInputBytes();
            if (this.outputAudioFormat.sampleRate == this.inputAudioFormat.sampleRate) {
                return Util.scaleLargeTimestamp(j, pendingInputBytes, this.outputBytes);
            }
            return Util.scaleLargeTimestamp(j, pendingInputBytes * this.outputAudioFormat.sampleRate, this.inputAudioFormat.sampleRate * this.outputBytes);
        }
        return (long) (this.speed * j);
    }

    public long getPlayoutDuration(long j) {
        if (this.outputBytes >= 1024) {
            long pendingInputBytes = this.inputBytes - ((Sonic) Assertions.checkNotNull(this.sonic)).getPendingInputBytes();
            if (this.outputAudioFormat.sampleRate == this.inputAudioFormat.sampleRate) {
                return Util.scaleLargeTimestamp(j, this.outputBytes, pendingInputBytes);
            }
            return Util.scaleLargeTimestamp(j, this.inputAudioFormat.sampleRate * this.outputBytes, pendingInputBytes * this.outputAudioFormat.sampleRate);
        }
        return (long) (j / this.speed);
    }

    public long getProcessedInputBytes() {
        return this.inputBytes - ((Sonic) Assertions.checkNotNull(this.sonic)).getPendingInputBytes();
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public long getDurationAfterProcessorApplied(long j) {
        return getPlayoutDuration(j);
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public AudioProcessor.AudioFormat configure(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.encoding != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
        }
        int i = this.pendingOutputSampleRate;
        if (i == -1) {
            i = audioFormat.sampleRate;
        }
        this.pendingInputAudioFormat = audioFormat;
        AudioProcessor.AudioFormat audioFormat2 = new AudioProcessor.AudioFormat(i, audioFormat.channelCount, 2);
        this.pendingOutputAudioFormat = audioFormat2;
        this.pendingSonicRecreation = true;
        return audioFormat2;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public boolean isActive() {
        if (this.pendingOutputAudioFormat.sampleRate != -1) {
            return this.shouldBeActiveWithDefaultParameters || !areParametersSetToDefaultValues();
        }
        return false;
    }

    private boolean areParametersSetToDefaultValues() {
        return Math.abs(this.speed - 1.0f) < 1.0E-4f && Math.abs(this.pitch - 1.0f) < 1.0E-4f && this.pendingOutputAudioFormat.sampleRate == this.pendingInputAudioFormat.sampleRate;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.inputBytes += remaining;
            ((Sonic) Assertions.checkNotNull(this.sonic)).queueInput(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void queueEndOfStream() {
        Sonic sonic = this.sonic;
        if (sonic != null) {
            sonic.queueEndOfStream();
        }
        this.inputEnded = true;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public ByteBuffer getOutput() {
        int outputSize;
        Sonic sonic = this.sonic;
        if (sonic != null && (outputSize = sonic.getOutputSize()) > 0) {
            if (this.buffer.capacity() < outputSize) {
                ByteBuffer order = ByteBuffer.allocateDirect(outputSize).order(ByteOrder.nativeOrder());
                this.buffer = order;
                this.shortBuffer = order.asShortBuffer();
            } else {
                this.buffer.clear();
                this.shortBuffer.clear();
            }
            sonic.getOutput(this.shortBuffer);
            this.outputBytes += outputSize;
            this.buffer.limit(outputSize);
            this.outputBuffer = this.buffer;
        }
        ByteBuffer byteBuffer = this.outputBuffer;
        this.outputBuffer = EMPTY_BUFFER;
        return byteBuffer;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public boolean isEnded() {
        if (this.inputEnded) {
            Sonic sonic = this.sonic;
            return sonic == null || sonic.getOutputSize() == 0;
        }
        return false;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void flush() {
        if (isActive()) {
            this.inputAudioFormat = this.pendingInputAudioFormat;
            this.outputAudioFormat = this.pendingOutputAudioFormat;
            if (this.pendingSonicRecreation) {
                this.sonic = new Sonic(this.inputAudioFormat.sampleRate, this.inputAudioFormat.channelCount, this.speed, this.pitch, this.outputAudioFormat.sampleRate);
            } else {
                Sonic sonic = this.sonic;
                if (sonic != null) {
                    sonic.flush();
                }
            }
        }
        this.outputBuffer = EMPTY_BUFFER;
        this.inputBytes = 0L;
        this.outputBytes = 0L;
        this.inputEnded = false;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void reset() {
        this.speed = 1.0f;
        this.pitch = 1.0f;
        this.pendingInputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.pendingOutputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.inputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.outputAudioFormat = AudioProcessor.AudioFormat.NOT_SET;
        ByteBuffer byteBuffer = EMPTY_BUFFER;
        this.buffer = byteBuffer;
        this.shortBuffer = byteBuffer.asShortBuffer();
        this.outputBuffer = EMPTY_BUFFER;
        this.pendingOutputSampleRate = -1;
        this.pendingSonicRecreation = false;
        this.sonic = null;
        this.inputBytes = 0L;
        this.outputBytes = 0L;
        this.inputEnded = false;
    }
}
