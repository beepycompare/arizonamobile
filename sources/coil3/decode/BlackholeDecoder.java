package coil3.decode;

import coil3.ColorImage;
import coil3.Image;
import coil3.ImageLoader;
import coil3.decode.BlackholeDecoder;
import coil3.decode.Decoder;
import coil3.fetch.SourceFetchResult;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: BlackholeDecoder.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\tR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcoil3/decode/BlackholeDecoder;", "Lcoil3/decode/Decoder;", "imageFactory", "Lkotlin/Function0;", "Lcoil3/Image;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "decode", "Lcoil3/decode/DecodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Factory", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BlackholeDecoder implements Decoder {
    private final Function0<Image> imageFactory;

    /* JADX WARN: Multi-variable type inference failed */
    public BlackholeDecoder(Function0<? extends Image> function0) {
        this.imageFactory = function0;
    }

    @Override // coil3.decode.Decoder
    public Object decode(Continuation<? super DecodeResult> continuation) {
        return new DecodeResult(this.imageFactory.invoke(), false);
    }

    /* compiled from: BlackholeDecoder.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcoil3/decode/BlackholeDecoder$Factory;", "Lcoil3/decode/Decoder$Factory;", "imageFactory", "Lkotlin/Function0;", "Lcoil3/Image;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "create", "Lcoil3/decode/BlackholeDecoder;", "result", "Lcoil3/fetch/SourceFetchResult;", "options", "Lcoil3/request/Options;", "imageLoader", "Lcoil3/ImageLoader;", "Companion", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Factory implements Decoder.Factory {
        public static final Companion Companion = new Companion(null);
        public static final Image EMPTY_IMAGE = new ColorImage(0, 0, 0, 0, false, 30, null);
        private final Function0<Image> imageFactory;

        public Factory() {
            this(null, 1, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Factory(Function0<? extends Image> function0) {
            this.imageFactory = function0;
        }

        public /* synthetic */ Factory(Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new Function0() { // from class: coil3.decode.BlackholeDecoder$Factory$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Image image;
                    image = BlackholeDecoder.Factory.EMPTY_IMAGE;
                    return image;
                }
            } : function0);
        }

        @Override // coil3.decode.Decoder.Factory
        public BlackholeDecoder create(SourceFetchResult sourceFetchResult, Options options, ImageLoader imageLoader) {
            return new BlackholeDecoder(this.imageFactory);
        }

        /* compiled from: BlackholeDecoder.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcoil3/decode/BlackholeDecoder$Factory$Companion;", "", "<init>", "()V", "EMPTY_IMAGE", "Lcoil3/Image;", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}
