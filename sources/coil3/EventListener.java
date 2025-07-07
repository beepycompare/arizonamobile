package coil3;

import android.graphics.Bitmap;
import coil3.EventListener;
import coil3.decode.DecodeResult;
import coil3.decode.Decoder;
import coil3.fetch.FetchResult;
import coil3.fetch.Fetcher;
import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.Options;
import coil3.request.SuccessResult;
import coil3.size.Size;
import coil3.size.SizeResolver;
import coil3.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: EventListener.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 02\u00020\u0001:\u0002/0B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0015H\u0016J \u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J*\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J \u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J*\u0010!\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\"H\u0016J\u0018\u0010#\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020$H\u0016J\u0018\u0010%\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020$H\u0016J\u0018\u0010&\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(H\u0016J\u0018\u0010)\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010+\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020,H\u0016J\u0018\u0010-\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020.H\u0016¨\u00061"}, d2 = {"Lcoil3/EventListener;", "Lcoil3/request/ImageRequest$Listener;", "<init>", "()V", "onStart", "", "request", "Lcoil3/request/ImageRequest;", "resolveSizeStart", "sizeResolver", "Lcoil3/size/SizeResolver;", "resolveSizeEnd", "size", "Lcoil3/size/Size;", "mapStart", "input", "", "mapEnd", "output", "keyStart", "keyEnd", "", "fetchStart", "fetcher", "Lcoil3/fetch/Fetcher;", "options", "Lcoil3/request/Options;", "fetchEnd", "result", "Lcoil3/fetch/FetchResult;", "decodeStart", "decoder", "Lcoil3/decode/Decoder;", "decodeEnd", "Lcoil3/decode/DecodeResult;", "transformStart", "Landroid/graphics/Bitmap;", "transformEnd", "transitionStart", "transition", "Lcoil3/transition/Transition;", "transitionEnd", "onCancel", "onError", "Lcoil3/request/ErrorResult;", "onSuccess", "Lcoil3/request/SuccessResult;", "Factory", "Companion", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class EventListener implements ImageRequest.Listener {
    public static final Companion Companion = new Companion(null);
    public static final EventListener NONE = new EventListener() { // from class: coil3.EventListener$Companion$NONE$1
    };

    public void decodeEnd(ImageRequest imageRequest, Decoder decoder, Options options, DecodeResult decodeResult) {
    }

    public void decodeStart(ImageRequest imageRequest, Decoder decoder, Options options) {
    }

    public void fetchEnd(ImageRequest imageRequest, Fetcher fetcher, Options options, FetchResult fetchResult) {
    }

    public void fetchStart(ImageRequest imageRequest, Fetcher fetcher, Options options) {
    }

    public void keyEnd(ImageRequest imageRequest, String str) {
    }

    public void keyStart(ImageRequest imageRequest, Object obj) {
    }

    public void mapEnd(ImageRequest imageRequest, Object obj) {
    }

    public void mapStart(ImageRequest imageRequest, Object obj) {
    }

    @Override // coil3.request.ImageRequest.Listener
    public void onCancel(ImageRequest imageRequest) {
    }

    @Override // coil3.request.ImageRequest.Listener
    public void onError(ImageRequest imageRequest, ErrorResult errorResult) {
    }

    @Override // coil3.request.ImageRequest.Listener
    public void onStart(ImageRequest imageRequest) {
    }

    @Override // coil3.request.ImageRequest.Listener
    public void onSuccess(ImageRequest imageRequest, SuccessResult successResult) {
    }

    public void resolveSizeEnd(ImageRequest imageRequest, Size size) {
    }

    public void resolveSizeStart(ImageRequest imageRequest, SizeResolver sizeResolver) {
    }

    public void transformEnd(ImageRequest imageRequest, Bitmap bitmap) {
    }

    public void transformStart(ImageRequest imageRequest, Bitmap bitmap) {
    }

    public void transitionEnd(ImageRequest imageRequest, Transition transition) {
    }

    public void transitionStart(ImageRequest imageRequest, Transition transition) {
    }

    /* compiled from: EventListener.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcoil3/EventListener$Factory;", "", "create", "Lcoil3/EventListener;", "request", "Lcoil3/request/ImageRequest;", "Companion", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface Factory {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final Factory NONE = new Factory() { // from class: coil3.EventListener$Factory$$ExternalSyntheticLambda0
            @Override // coil3.EventListener.Factory
            public final EventListener create(ImageRequest imageRequest) {
                EventListener NONE$lambda$0;
                NONE$lambda$0 = EventListener.Factory.NONE$lambda$0(imageRequest);
                return NONE$lambda$0;
            }
        };

        EventListener create(ImageRequest imageRequest);

        /* compiled from: EventListener.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0006"}, d2 = {"Lcoil3/EventListener$Factory$Companion;", "", "<init>", "()V", "NONE", "Lcoil3/EventListener$Factory;", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        static EventListener NONE$lambda$0(ImageRequest imageRequest) {
            return EventListener.NONE;
        }
    }

    /* compiled from: EventListener.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcoil3/EventListener$Companion;", "", "<init>", "()V", "NONE", "Lcoil3/EventListener;", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
