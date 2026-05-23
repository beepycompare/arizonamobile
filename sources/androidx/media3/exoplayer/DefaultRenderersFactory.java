package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.common.util.Log;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.audio.MediaCodecAudioRenderer;
import androidx.media3.exoplayer.image.BitmapFactoryImageDecoder;
import androidx.media3.exoplayer.image.ImageDecoder;
import androidx.media3.exoplayer.image.ImageRenderer;
import androidx.media3.exoplayer.mediacodec.DefaultMediaCodecAdapterFactory;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector;
import androidx.media3.exoplayer.metadata.MetadataOutput;
import androidx.media3.exoplayer.metadata.MetadataRenderer;
import androidx.media3.exoplayer.text.TextOutput;
import androidx.media3.exoplayer.text.TextRenderer;
import androidx.media3.exoplayer.video.MediaCodecVideoRenderer;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import androidx.media3.exoplayer.video.spherical.CameraMotionRenderer;
import com.google.common.base.Preconditions;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class DefaultRenderersFactory implements RenderersFactory {
    public static final long DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS = 5000;
    public static final int EXTENSION_RENDERER_MODE_OFF = 0;
    public static final int EXTENSION_RENDERER_MODE_ON = 1;
    public static final int EXTENSION_RENDERER_MODE_PREFER = 2;
    public static final int MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY = 50;
    private static final int METADATA_RENDERER_COUNT = 4;
    private static final String TAG = "DefaultRenderersFactory";
    private final DefaultMediaCodecAdapterFactory codecAdapterFactory;
    private final Context context;
    private boolean enableAudioOutputPlaybackParameters;
    private boolean enableDecoderFallback;
    private boolean enableFloatOutput;
    private boolean enableMediaCodecBufferDecodeOnlyFlag;
    private boolean enableMediaCodecVideoRendererDurationToProgressUs;
    private boolean enableMediaCodecVideoRendererPrewarming;
    private int extensionRendererMode = 0;
    private long allowedVideoJoiningTimeMs = 5000;
    private MediaCodecSelector mediaCodecSelector = MediaCodecSelector.DEFAULT;
    private boolean parseAv1SampleDependencies = true;
    private long lateThresholdToDropDecoderInputUs = 15000;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ExtensionRendererMode {
    }

    protected void buildMiscellaneousRenderers(Context context, Handler handler, int i, ArrayList<Renderer> arrayList) {
    }

    public DefaultRenderersFactory(Context context) {
        this.context = context;
        this.codecAdapterFactory = new DefaultMediaCodecAdapterFactory(context);
    }

    public final DefaultRenderersFactory setExtensionRendererMode(int i) {
        this.extensionRendererMode = i;
        return this;
    }

    public final DefaultRenderersFactory forceEnableMediaCodecAsynchronousQueueing() {
        this.codecAdapterFactory.forceEnableAsynchronous();
        return this;
    }

    public final DefaultRenderersFactory forceDisableMediaCodecAsynchronousQueueing() {
        this.codecAdapterFactory.forceDisableAsynchronous();
        return this;
    }

    public final DefaultRenderersFactory experimentalSetMediaCodecAsyncCryptoFlagEnabled(boolean z) {
        this.codecAdapterFactory.experimentalSetAsyncCryptoFlagEnabled(z);
        return this;
    }

    public final DefaultRenderersFactory setEnableDecoderFallback(boolean z) {
        this.enableDecoderFallback = z;
        return this;
    }

    public final DefaultRenderersFactory setMediaCodecSelector(MediaCodecSelector mediaCodecSelector) {
        this.mediaCodecSelector = mediaCodecSelector;
        return this;
    }

    public final DefaultRenderersFactory setEnableAudioFloatOutput(boolean z) {
        this.enableFloatOutput = z;
        return this;
    }

    @Deprecated
    public final DefaultRenderersFactory setEnableAudioTrackPlaybackParams(boolean z) {
        return setEnableAudioOutputPlaybackParameters(z);
    }

    public final DefaultRenderersFactory setEnableAudioOutputPlaybackParameters(boolean z) {
        this.enableAudioOutputPlaybackParameters = z;
        return this;
    }

    public final DefaultRenderersFactory experimentalSetEnableMediaCodecVideoRendererPrewarming(boolean z) {
        this.enableMediaCodecVideoRendererPrewarming = z;
        return this;
    }

    public final DefaultRenderersFactory experimentalSetParseAv1SampleDependencies(boolean z) {
        this.parseAv1SampleDependencies = z;
        return this;
    }

    public DefaultRenderersFactory experimentalSetEnableMediaCodecBufferDecodeOnlyFlag(boolean z) {
        this.enableMediaCodecBufferDecodeOnlyFlag = z;
        return this;
    }

    public DefaultRenderersFactory setEnableMediaCodecVideoRendererDurationToProgressUs(boolean z) {
        this.enableMediaCodecVideoRendererDurationToProgressUs = z;
        return this;
    }

    public final DefaultRenderersFactory setAllowedVideoJoiningTimeMs(long j) {
        this.allowedVideoJoiningTimeMs = j;
        return this;
    }

    public final DefaultRenderersFactory experimentalSetLateThresholdToDropDecoderInputUs(long j) {
        this.lateThresholdToDropDecoderInputUs = j;
        return this;
    }

    @Override // androidx.media3.exoplayer.RenderersFactory
    public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        Handler handler2;
        ArrayList<Renderer> arrayList = new ArrayList<>();
        buildVideoRenderers(this.context, this.extensionRendererMode, this.mediaCodecSelector, this.enableDecoderFallback, handler, videoRendererEventListener, this.allowedVideoJoiningTimeMs, arrayList);
        AudioSink buildAudioSink = buildAudioSink(this.context, this.enableFloatOutput, this.enableAudioOutputPlaybackParameters);
        if (buildAudioSink != null) {
            handler2 = handler;
            buildAudioRenderers(this.context, this.extensionRendererMode, this.mediaCodecSelector, this.enableDecoderFallback, buildAudioSink, handler2, audioRendererEventListener, arrayList);
        } else {
            handler2 = handler;
        }
        buildTextRenderers(this.context, textOutput, handler2.getLooper(), this.extensionRendererMode, arrayList);
        buildMetadataRenderers(this.context, metadataOutput, handler2.getLooper(), this.extensionRendererMode, arrayList);
        buildCameraMotionRenderers(this.context, this.extensionRendererMode, arrayList);
        buildImageRenderers(this.context, arrayList);
        buildMiscellaneousRenderers(this.context, handler2, this.extensionRendererMode, arrayList);
        return (Renderer[]) arrayList.toArray(new Renderer[0]);
    }

    protected void buildVideoRenderers(Context context, int i, MediaCodecSelector mediaCodecSelector, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, long j, ArrayList<Renderer> arrayList) {
        int i2;
        MediaCodecVideoRenderer.Builder enableDurationToProgressUs = new MediaCodecVideoRenderer.Builder(context).setCodecAdapterFactory(getCodecAdapterFactory()).setMediaCodecSelector(mediaCodecSelector).setAllowedJoiningTimeMs(j).setEnableDecoderFallback(z).setEventHandler(handler).setEventListener(videoRendererEventListener).setMaxDroppedFramesToNotify(50).experimentalSetParseAv1SampleDependencies(this.parseAv1SampleDependencies).experimentalSetLateThresholdToDropDecoderInputUs(this.lateThresholdToDropDecoderInputUs).setEnableDurationToProgressUs(this.enableMediaCodecVideoRendererDurationToProgressUs);
        if (Build.VERSION.SDK_INT >= 34) {
            enableDurationToProgressUs = enableDurationToProgressUs.experimentalSetEnableMediaCodecBufferDecodeOnlyFlag(this.enableMediaCodecBufferDecodeOnlyFlag);
        }
        arrayList.add(enableDurationToProgressUs.build());
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            try {
                i2 = size + 1;
                try {
                    arrayList.add(size, (Renderer) Class.forName("androidx.media3.decoder.vp9.LibvpxVideoRenderer").getConstructor(Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(Long.valueOf(j), handler, videoRendererEventListener, 50));
                    Log.i(TAG, "Loaded LibvpxVideoRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i2;
                    i2 = size;
                    try {
                        int i3 = i2 + 1;
                        try {
                            arrayList.add(i2, (Renderer) Class.forName("androidx.media3.decoder.av1.Libdav1dVideoRenderer").getConstructor(Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(Long.valueOf(j), handler, videoRendererEventListener, 50));
                            Log.i(TAG, "Loaded Libdav1dVideoRenderer.");
                        } catch (ClassNotFoundException unused2) {
                            i2 = i3;
                            i3 = i2;
                            arrayList.add(i3, (Renderer) Class.forName("androidx.media3.decoder.ffmpeg.ExperimentalFfmpegVideoRenderer").getConstructor(Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(Long.valueOf(j), handler, videoRendererEventListener, 50));
                            Log.i(TAG, "Loaded FfmpegVideoRenderer.");
                        }
                        arrayList.add(i3, (Renderer) Class.forName("androidx.media3.decoder.ffmpeg.ExperimentalFfmpegVideoRenderer").getConstructor(Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(Long.valueOf(j), handler, videoRendererEventListener, 50));
                        Log.i(TAG, "Loaded FfmpegVideoRenderer.");
                    } catch (Exception e) {
                        throw new IllegalStateException("Error instantiating AV1 extension", e);
                    }
                }
            } catch (ClassNotFoundException unused3) {
            }
            try {
                int i32 = i2 + 1;
                arrayList.add(i2, (Renderer) Class.forName("androidx.media3.decoder.av1.Libdav1dVideoRenderer").getConstructor(Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(Long.valueOf(j), handler, videoRendererEventListener, 50));
                Log.i(TAG, "Loaded Libdav1dVideoRenderer.");
            } catch (ClassNotFoundException unused4) {
            }
            try {
                arrayList.add(i32, (Renderer) Class.forName("androidx.media3.decoder.ffmpeg.ExperimentalFfmpegVideoRenderer").getConstructor(Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(Long.valueOf(j), handler, videoRendererEventListener, 50));
                Log.i(TAG, "Loaded FfmpegVideoRenderer.");
            } catch (ClassNotFoundException unused5) {
            } catch (Exception e2) {
                throw new IllegalStateException("Error instantiating FFmpeg extension", e2);
            }
        } catch (Exception e3) {
            throw new IllegalStateException("Error instantiating VP9 extension", e3);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(2:15|16)|17|18|19|20|21|(5:22|23|24|25|26)|(5:28|29|30|31|32)|34|35) */
    /* JADX WARN: Can't wrap try/catch for region: R(24:3|(1:5)|6|(5:7|8|9|10|11)|12|13|14|15|16|17|18|19|20|21|22|23|24|(2:25|26)|28|29|30|31|32|(2:34|35)) */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0167, code lost:
        r5 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0172, code lost:
        r11 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void buildAudioRenderers(Context context, int i, MediaCodecSelector mediaCodecSelector, boolean z, AudioSink audioSink, Handler handler, AudioRendererEventListener audioRendererEventListener, ArrayList<Renderer> arrayList) {
        int i2;
        int i3;
        int i4;
        arrayList.add(new MediaCodecAudioRenderer(context, getCodecAdapterFactory(), mediaCodecSelector, z, handler, audioRendererEventListener, audioSink));
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        if (i == 2) {
            size--;
        }
        try {
            try {
                i2 = size + 1;
                try {
                    arrayList.add(size, (Renderer) Class.forName("androidx.media3.decoder.midi.MidiRenderer").getConstructor(Context.class, Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(context, handler, audioRendererEventListener, audioSink));
                    Log.i(TAG, "Loaded MidiRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i2;
                    i2 = size;
                    try {
                        i3 = i2 + 1;
                    } catch (ClassNotFoundException unused2) {
                    }
                    try {
                        try {
                            arrayList.add(i2, (Renderer) Class.forName("androidx.media3.decoder.opus.LibopusAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                            Log.i(TAG, "Loaded LibopusAudioRenderer.");
                        } catch (ClassNotFoundException unused3) {
                            i2 = i3;
                            i3 = i2;
                            i4 = i3 + 1;
                            arrayList.add(i3, (Renderer) Class.forName("androidx.media3.decoder.flac.LibflacAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                            Log.i(TAG, "Loaded LibflacAudioRenderer.");
                            try {
                                int i5 = i4 + 1;
                                arrayList.add(i4, (Renderer) Class.forName("androidx.media3.decoder.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                                Log.i(TAG, "Loaded FfmpegAudioRenderer.");
                                try {
                                    Class<?> cls = Class.forName("androidx.media3.decoder.iamf.IamfAudioRenderer$Builder");
                                    Object newInstance = cls.getConstructor(AudioSink.class).newInstance(audioSink);
                                    cls.getMethod("setEventHandlerAndListener", Handler.class, AudioRendererEventListener.class).invoke(newInstance, handler, audioRendererEventListener);
                                    Renderer renderer = (Renderer) cls.getMethod("build", new Class[0]).invoke(newInstance, new Object[0]);
                                    Preconditions.checkNotNull(renderer);
                                    int i6 = i5 + 1;
                                    arrayList.add(i5, renderer);
                                    Log.i(TAG, "Loaded IamfAudioRenderer.");
                                    arrayList.add(i6, (Renderer) Class.forName("androidx.media3.decoder.mpegh.MpeghAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                                    Log.i(TAG, "Loaded MpeghAudioRenderer.");
                                } catch (Exception e) {
                                    throw new IllegalStateException("Error instantiating IAMF extension", e);
                                }
                            } catch (Exception e2) {
                                throw new IllegalStateException("Error instantiating FFmpeg extension", e2);
                            }
                        }
                        i4 = i3 + 1;
                        arrayList.add(i3, (Renderer) Class.forName("androidx.media3.decoder.flac.LibflacAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                        Log.i(TAG, "Loaded LibflacAudioRenderer.");
                        try {
                            int i52 = i4 + 1;
                            arrayList.add(i4, (Renderer) Class.forName("androidx.media3.decoder.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                            Log.i(TAG, "Loaded FfmpegAudioRenderer.");
                        } catch (ClassNotFoundException unused4) {
                        }
                        try {
                            Class<?> cls2 = Class.forName("androidx.media3.decoder.iamf.IamfAudioRenderer$Builder");
                            Object newInstance2 = cls2.getConstructor(AudioSink.class).newInstance(audioSink);
                            cls2.getMethod("setEventHandlerAndListener", Handler.class, AudioRendererEventListener.class).invoke(newInstance2, handler, audioRendererEventListener);
                            Renderer renderer2 = (Renderer) cls2.getMethod("build", new Class[0]).invoke(newInstance2, new Object[0]);
                            Preconditions.checkNotNull(renderer2);
                            int i62 = i52 + 1;
                            arrayList.add(i52, renderer2);
                            Log.i(TAG, "Loaded IamfAudioRenderer.");
                        } catch (ReflectiveOperationException unused5) {
                        }
                        arrayList.add(i62, (Renderer) Class.forName("androidx.media3.decoder.mpegh.MpeghAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                        Log.i(TAG, "Loaded MpeghAudioRenderer.");
                    } catch (Exception e3) {
                        throw new IllegalStateException("Error instantiating FLAC extension", e3);
                    }
                }
            } catch (Exception e4) {
                throw new IllegalStateException("Error instantiating MIDI extension", e4);
            }
        } catch (ClassNotFoundException unused6) {
        }
        try {
            i3 = i2 + 1;
            arrayList.add(i2, (Renderer) Class.forName("androidx.media3.decoder.opus.LibopusAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
            Log.i(TAG, "Loaded LibopusAudioRenderer.");
            i4 = i3 + 1;
            try {
                arrayList.add(i3, (Renderer) Class.forName("androidx.media3.decoder.flac.LibflacAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                Log.i(TAG, "Loaded LibflacAudioRenderer.");
            } catch (ClassNotFoundException unused7) {
                i3 = i4;
                i4 = i3;
                int i522 = i4 + 1;
                arrayList.add(i4, (Renderer) Class.forName("androidx.media3.decoder.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                Log.i(TAG, "Loaded FfmpegAudioRenderer.");
                Class<?> cls22 = Class.forName("androidx.media3.decoder.iamf.IamfAudioRenderer$Builder");
                Object newInstance22 = cls22.getConstructor(AudioSink.class).newInstance(audioSink);
                cls22.getMethod("setEventHandlerAndListener", Handler.class, AudioRendererEventListener.class).invoke(newInstance22, handler, audioRendererEventListener);
                Renderer renderer22 = (Renderer) cls22.getMethod("build", new Class[0]).invoke(newInstance22, new Object[0]);
                Preconditions.checkNotNull(renderer22);
                int i622 = i522 + 1;
                arrayList.add(i522, renderer22);
                Log.i(TAG, "Loaded IamfAudioRenderer.");
                arrayList.add(i622, (Renderer) Class.forName("androidx.media3.decoder.mpegh.MpeghAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                Log.i(TAG, "Loaded MpeghAudioRenderer.");
            }
            int i5222 = i4 + 1;
            try {
                arrayList.add(i4, (Renderer) Class.forName("androidx.media3.decoder.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                Log.i(TAG, "Loaded FfmpegAudioRenderer.");
            } catch (ClassNotFoundException unused8) {
                i4 = i5222;
                i5222 = i4;
                Class<?> cls222 = Class.forName("androidx.media3.decoder.iamf.IamfAudioRenderer$Builder");
                Object newInstance222 = cls222.getConstructor(AudioSink.class).newInstance(audioSink);
                cls222.getMethod("setEventHandlerAndListener", Handler.class, AudioRendererEventListener.class).invoke(newInstance222, handler, audioRendererEventListener);
                Renderer renderer222 = (Renderer) cls222.getMethod("build", new Class[0]).invoke(newInstance222, new Object[0]);
                Preconditions.checkNotNull(renderer222);
                int i6222 = i5222 + 1;
                arrayList.add(i5222, renderer222);
                Log.i(TAG, "Loaded IamfAudioRenderer.");
                arrayList.add(i6222, (Renderer) Class.forName("androidx.media3.decoder.mpegh.MpeghAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                Log.i(TAG, "Loaded MpeghAudioRenderer.");
            }
            Class<?> cls2222 = Class.forName("androidx.media3.decoder.iamf.IamfAudioRenderer$Builder");
            Object newInstance2222 = cls2222.getConstructor(AudioSink.class).newInstance(audioSink);
            cls2222.getMethod("setEventHandlerAndListener", Handler.class, AudioRendererEventListener.class).invoke(newInstance2222, handler, audioRendererEventListener);
            Renderer renderer2222 = (Renderer) cls2222.getMethod("build", new Class[0]).invoke(newInstance2222, new Object[0]);
            Preconditions.checkNotNull(renderer2222);
            int i62222 = i5222 + 1;
            arrayList.add(i5222, renderer2222);
            Log.i(TAG, "Loaded IamfAudioRenderer.");
            try {
                arrayList.add(i62222, (Renderer) Class.forName("androidx.media3.decoder.mpegh.MpeghAudioRenderer").getConstructor(Handler.class, AudioRendererEventListener.class, AudioSink.class).newInstance(handler, audioRendererEventListener, audioSink));
                Log.i(TAG, "Loaded MpeghAudioRenderer.");
            } catch (ClassNotFoundException unused9) {
            } catch (Exception e5) {
                throw new IllegalStateException("Error instantiating MPEG-H extension", e5);
            }
        } catch (Exception e6) {
            throw new IllegalStateException("Error instantiating Opus extension", e6);
        }
    }

    protected void buildTextRenderers(Context context, TextOutput textOutput, Looper looper, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new TextRenderer(textOutput, looper));
    }

    protected void buildMetadataRenderers(Context context, MetadataOutput metadataOutput, Looper looper, int i, ArrayList<Renderer> arrayList) {
        for (int i2 = 0; i2 < 4; i2++) {
            arrayList.add(new MetadataRenderer(metadataOutput, looper));
        }
    }

    protected void buildCameraMotionRenderers(Context context, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new CameraMotionRenderer());
    }

    @Deprecated
    protected void buildImageRenderers(ArrayList<Renderer> arrayList) {
        arrayList.add(new ImageRenderer(getImageDecoderFactory(this.context), null));
    }

    protected void buildImageRenderers(Context context, ArrayList<Renderer> arrayList) {
        buildImageRenderers(arrayList);
    }

    protected AudioSink buildAudioSink(Context context, boolean z, boolean z2) {
        return new DefaultAudioSink.Builder(context).setEnableFloatOutput(z).setEnableAudioOutputPlaybackParameters(z2).build();
    }

    @Override // androidx.media3.exoplayer.RenderersFactory
    public Renderer createSecondaryRenderer(Renderer renderer, Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        if (renderer.getTrackType() == 2) {
            return buildSecondaryVideoRenderer(renderer, this.context, this.extensionRendererMode, this.mediaCodecSelector, this.enableDecoderFallback, handler, videoRendererEventListener, this.allowedVideoJoiningTimeMs);
        }
        return null;
    }

    protected Renderer buildSecondaryVideoRenderer(Renderer renderer, Context context, int i, MediaCodecSelector mediaCodecSelector, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, long j) {
        if (this.enableMediaCodecVideoRendererPrewarming && renderer.getClass() == MediaCodecVideoRenderer.class) {
            MediaCodecVideoRenderer.Builder experimentalSetLateThresholdToDropDecoderInputUs = new MediaCodecVideoRenderer.Builder(context).setCodecAdapterFactory(getCodecAdapterFactory()).setMediaCodecSelector(mediaCodecSelector).setAllowedJoiningTimeMs(j).setEnableDecoderFallback(z).setEventHandler(handler).setEventListener(videoRendererEventListener).setMaxDroppedFramesToNotify(50).experimentalSetParseAv1SampleDependencies(this.parseAv1SampleDependencies).experimentalSetLateThresholdToDropDecoderInputUs(this.lateThresholdToDropDecoderInputUs);
            if (Build.VERSION.SDK_INT >= 34) {
                experimentalSetLateThresholdToDropDecoderInputUs = experimentalSetLateThresholdToDropDecoderInputUs.experimentalSetEnableMediaCodecBufferDecodeOnlyFlag(this.enableMediaCodecBufferDecodeOnlyFlag);
            }
            return experimentalSetLateThresholdToDropDecoderInputUs.build();
        }
        return null;
    }

    protected MediaCodecAdapter.Factory getCodecAdapterFactory() {
        return this.codecAdapterFactory;
    }

    protected ImageDecoder.Factory getImageDecoderFactory(Context context) {
        return new BitmapFactoryImageDecoder.Factory(context);
    }
}
