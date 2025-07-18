package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.TypefaceResult;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: FontFamilyResolver.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017J:\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\u0006\u0010\"\u001a\u00020\u000fH\u0002R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"Landroidx/compose/ui/text/font/FontFamilyResolverImpl;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "platformResolveInterceptor", "Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "typefaceRequestCache", "Landroidx/compose/ui/text/font/TypefaceRequestCache;", "fontListFontFamilyTypefaceAdapter", "Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;", "platformFamilyTypefaceAdapter", "Landroidx/compose/ui/text/font/PlatformFontFamilyTypefaceAdapter;", "(Landroidx/compose/ui/text/font/PlatformFontLoader;Landroidx/compose/ui/text/font/PlatformResolveInterceptor;Landroidx/compose/ui/text/font/TypefaceRequestCache;Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;Landroidx/compose/ui/text/font/PlatformFontFamilyTypefaceAdapter;)V", "createDefaultTypeface", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceRequest;", "", "getPlatformFontLoader$ui_text_release", "()Landroidx/compose/ui/text/font/PlatformFontLoader;", "preload", "", TtmlNode.ATTR_TTS_FONT_FAMILY, "Landroidx/compose/ui/text/font/FontFamily;", "(Landroidx/compose/ui/text/font/FontFamily;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolve", "Landroidx/compose/runtime/State;", TtmlNode.ATTR_TTS_FONT_WEIGHT, "Landroidx/compose/ui/text/font/FontWeight;", TtmlNode.ATTR_TTS_FONT_STYLE, "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "resolve-DPcqOEQ", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/runtime/State;", "typefaceRequest", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FontFamilyResolverImpl implements FontFamily.Resolver {
    public static final int $stable = 8;
    private final Function1<TypefaceRequest, Object> createDefaultTypeface;
    private final FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter;
    private final PlatformFontFamilyTypefaceAdapter platformFamilyTypefaceAdapter;
    private final PlatformFontLoader platformFontLoader;
    private final PlatformResolveInterceptor platformResolveInterceptor;
    private final TypefaceRequestCache typefaceRequestCache;

    public FontFamilyResolverImpl(PlatformFontLoader platformFontLoader, PlatformResolveInterceptor platformResolveInterceptor, TypefaceRequestCache typefaceRequestCache, FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, PlatformFontFamilyTypefaceAdapter platformFontFamilyTypefaceAdapter) {
        this.platformFontLoader = platformFontLoader;
        this.platformResolveInterceptor = platformResolveInterceptor;
        this.typefaceRequestCache = typefaceRequestCache;
        this.fontListFontFamilyTypefaceAdapter = fontListFontFamilyTypefaceAdapter;
        this.platformFamilyTypefaceAdapter = platformFontFamilyTypefaceAdapter;
        this.createDefaultTypeface = new Function1<TypefaceRequest, Object>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$createDefaultTypeface$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(TypefaceRequest typefaceRequest) {
                State resolve;
                resolve = FontFamilyResolverImpl.this.resolve(TypefaceRequest.m6300copye1PVR60$default(typefaceRequest, null, null, 0, 0, null, 30, null));
                return resolve.getValue();
            }
        };
    }

    public final PlatformFontLoader getPlatformFontLoader$ui_text_release() {
        return this.platformFontLoader;
    }

    public /* synthetic */ FontFamilyResolverImpl(PlatformFontLoader platformFontLoader, PlatformResolveInterceptor platformResolveInterceptor, TypefaceRequestCache typefaceRequestCache, FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, PlatformFontFamilyTypefaceAdapter platformFontFamilyTypefaceAdapter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(platformFontLoader, (i & 2) != 0 ? PlatformResolveInterceptor.Companion.getDefault$ui_text_release() : platformResolveInterceptor, (i & 4) != 0 ? FontFamilyResolverKt.getGlobalTypefaceRequestCache() : typefaceRequestCache, (i & 8) != 0 ? new FontListFontFamilyTypefaceAdapter(FontFamilyResolverKt.getGlobalAsyncTypefaceCache(), null, 2, null) : fontListFontFamilyTypefaceAdapter, (i & 16) != 0 ? new PlatformFontFamilyTypefaceAdapter() : platformFontFamilyTypefaceAdapter);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0070 A[LOOP:0: B:23:0x006e->B:24:0x0070, LOOP_END] */
    @Override // androidx.compose.ui.text.font.FontFamily.Resolver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object preload(FontFamily fontFamily, Continuation<? super Unit> continuation) {
        FontFamilyResolverImpl$preload$1 fontFamilyResolverImpl$preload$1;
        int i;
        final FontFamilyResolverImpl fontFamilyResolverImpl;
        int size;
        int i2;
        if (continuation instanceof FontFamilyResolverImpl$preload$1) {
            fontFamilyResolverImpl$preload$1 = (FontFamilyResolverImpl$preload$1) continuation;
            if ((fontFamilyResolverImpl$preload$1.label & Integer.MIN_VALUE) != 0) {
                fontFamilyResolverImpl$preload$1.label -= Integer.MIN_VALUE;
                Object obj = fontFamilyResolverImpl$preload$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fontFamilyResolverImpl$preload$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!(fontFamily instanceof FontListFontFamily)) {
                        return Unit.INSTANCE;
                    }
                    FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter = this.fontListFontFamilyTypefaceAdapter;
                    PlatformFontLoader platformFontLoader = this.platformFontLoader;
                    fontFamilyResolverImpl$preload$1.L$0 = this;
                    fontFamilyResolverImpl$preload$1.L$1 = fontFamily;
                    fontFamilyResolverImpl$preload$1.label = 1;
                    if (fontListFontFamilyTypefaceAdapter.preload(fontFamily, platformFontLoader, fontFamilyResolverImpl$preload$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    fontFamilyResolverImpl = this;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    fontFamily = (FontFamily) fontFamilyResolverImpl$preload$1.L$1;
                    fontFamilyResolverImpl = (FontFamilyResolverImpl) fontFamilyResolverImpl$preload$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                List<Font> fonts = ((FontListFontFamily) fontFamily).getFonts();
                ArrayList arrayList = new ArrayList(fonts.size());
                size = fonts.size();
                for (i2 = 0; i2 < size; i2++) {
                    Font font = fonts.get(i2);
                    arrayList.add(new TypefaceRequest(fontFamilyResolverImpl.platformResolveInterceptor.interceptFontFamily(fontFamily), fontFamilyResolverImpl.platformResolveInterceptor.interceptFontWeight(font.getWeight()), fontFamilyResolverImpl.platformResolveInterceptor.m6284interceptFontStyleT2F_aPo(font.mo6212getStyle_LCdwA()), FontSynthesis.Companion.m6276getAllGVVA2EU(), fontFamilyResolverImpl.platformFontLoader.getCacheKey(), null));
                }
                fontFamilyResolverImpl.typefaceRequestCache.preWarmCache(arrayList, new Function1<TypefaceRequest, TypefaceResult>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final TypefaceResult invoke(TypefaceRequest typefaceRequest) {
                        FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter2;
                        Function1<? super TypefaceRequest, ? extends Object> function1;
                        PlatformFontFamilyTypefaceAdapter platformFontFamilyTypefaceAdapter;
                        Function1<? super TypefaceRequest, ? extends Object> function12;
                        fontListFontFamilyTypefaceAdapter2 = FontFamilyResolverImpl.this.fontListFontFamilyTypefaceAdapter;
                        function1 = FontFamilyResolverImpl.this.createDefaultTypeface;
                        TypefaceResult resolve = fontListFontFamilyTypefaceAdapter2.resolve(typefaceRequest, FontFamilyResolverImpl.this.getPlatformFontLoader$ui_text_release(), new Function1<TypefaceResult.Immutable, Unit>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$2.1
                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(TypefaceResult.Immutable immutable) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TypefaceResult.Immutable immutable) {
                                invoke2(immutable);
                                return Unit.INSTANCE;
                            }
                        }, function1);
                        if (resolve == null) {
                            platformFontFamilyTypefaceAdapter = FontFamilyResolverImpl.this.platformFamilyTypefaceAdapter;
                            function12 = FontFamilyResolverImpl.this.createDefaultTypeface;
                            TypefaceResult resolve2 = platformFontFamilyTypefaceAdapter.resolve(typefaceRequest, FontFamilyResolverImpl.this.getPlatformFontLoader$ui_text_release(), new Function1<TypefaceResult.Immutable, Unit>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$2.2
                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(TypefaceResult.Immutable immutable) {
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TypefaceResult.Immutable immutable) {
                                    invoke2(immutable);
                                    return Unit.INSTANCE;
                                }
                            }, function12);
                            if (resolve2 != null) {
                                return resolve2;
                            }
                            throw new IllegalStateException("Could not load font");
                        }
                        return resolve;
                    }
                });
                return Unit.INSTANCE;
            }
        }
        fontFamilyResolverImpl$preload$1 = new FontFamilyResolverImpl$preload$1(this, continuation);
        Object obj2 = fontFamilyResolverImpl$preload$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fontFamilyResolverImpl$preload$1.label;
        if (i != 0) {
        }
        List<Font> fonts2 = ((FontListFontFamily) fontFamily).getFonts();
        ArrayList arrayList2 = new ArrayList(fonts2.size());
        size = fonts2.size();
        while (i2 < size) {
        }
        fontFamilyResolverImpl.typefaceRequestCache.preWarmCache(arrayList2, new Function1<TypefaceRequest, TypefaceResult>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final TypefaceResult invoke(TypefaceRequest typefaceRequest) {
                FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter2;
                Function1<? super TypefaceRequest, ? extends Object> function1;
                PlatformFontFamilyTypefaceAdapter platformFontFamilyTypefaceAdapter;
                Function1<? super TypefaceRequest, ? extends Object> function12;
                fontListFontFamilyTypefaceAdapter2 = FontFamilyResolverImpl.this.fontListFontFamilyTypefaceAdapter;
                function1 = FontFamilyResolverImpl.this.createDefaultTypeface;
                TypefaceResult resolve = fontListFontFamilyTypefaceAdapter2.resolve(typefaceRequest, FontFamilyResolverImpl.this.getPlatformFontLoader$ui_text_release(), new Function1<TypefaceResult.Immutable, Unit>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$2.1
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(TypefaceResult.Immutable immutable) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TypefaceResult.Immutable immutable) {
                        invoke2(immutable);
                        return Unit.INSTANCE;
                    }
                }, function1);
                if (resolve == null) {
                    platformFontFamilyTypefaceAdapter = FontFamilyResolverImpl.this.platformFamilyTypefaceAdapter;
                    function12 = FontFamilyResolverImpl.this.createDefaultTypeface;
                    TypefaceResult resolve2 = platformFontFamilyTypefaceAdapter.resolve(typefaceRequest, FontFamilyResolverImpl.this.getPlatformFontLoader$ui_text_release(), new Function1<TypefaceResult.Immutable, Unit>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$2.2
                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(TypefaceResult.Immutable immutable) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TypefaceResult.Immutable immutable) {
                            invoke2(immutable);
                            return Unit.INSTANCE;
                        }
                    }, function12);
                    if (resolve2 != null) {
                        return resolve2;
                    }
                    throw new IllegalStateException("Could not load font");
                }
                return resolve;
            }
        });
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.text.font.FontFamily.Resolver
    /* renamed from: resolve-DPcqOEQ */
    public State<Object> mo6232resolveDPcqOEQ(FontFamily fontFamily, FontWeight fontWeight, int i, int i2) {
        return resolve(new TypefaceRequest(this.platformResolveInterceptor.interceptFontFamily(fontFamily), this.platformResolveInterceptor.interceptFontWeight(fontWeight), this.platformResolveInterceptor.m6284interceptFontStyleT2F_aPo(i), this.platformResolveInterceptor.m6285interceptFontSynthesisMscr08Y(i2), this.platformFontLoader.getCacheKey(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final State<Object> resolve(final TypefaceRequest typefaceRequest) {
        return this.typefaceRequestCache.runCached(typefaceRequest, new Function1<Function1<? super TypefaceResult, ? extends Unit>, TypefaceResult>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$resolve$result$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ TypefaceResult invoke(Function1<? super TypefaceResult, ? extends Unit> function1) {
                return invoke2((Function1<? super TypefaceResult, Unit>) function1);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final TypefaceResult invoke2(Function1<? super TypefaceResult, Unit> function1) {
                FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter;
                Function1<? super TypefaceRequest, ? extends Object> function12;
                PlatformFontFamilyTypefaceAdapter platformFontFamilyTypefaceAdapter;
                Function1<? super TypefaceRequest, ? extends Object> function13;
                fontListFontFamilyTypefaceAdapter = FontFamilyResolverImpl.this.fontListFontFamilyTypefaceAdapter;
                TypefaceRequest typefaceRequest2 = typefaceRequest;
                PlatformFontLoader platformFontLoader$ui_text_release = FontFamilyResolverImpl.this.getPlatformFontLoader$ui_text_release();
                function12 = FontFamilyResolverImpl.this.createDefaultTypeface;
                TypefaceResult resolve = fontListFontFamilyTypefaceAdapter.resolve(typefaceRequest2, platformFontLoader$ui_text_release, function1, function12);
                if (resolve == null) {
                    platformFontFamilyTypefaceAdapter = FontFamilyResolverImpl.this.platformFamilyTypefaceAdapter;
                    TypefaceRequest typefaceRequest3 = typefaceRequest;
                    PlatformFontLoader platformFontLoader$ui_text_release2 = FontFamilyResolverImpl.this.getPlatformFontLoader$ui_text_release();
                    function13 = FontFamilyResolverImpl.this.createDefaultTypeface;
                    TypefaceResult resolve2 = platformFontFamilyTypefaceAdapter.resolve(typefaceRequest3, platformFontLoader$ui_text_release2, function1, function13);
                    if (resolve2 != null) {
                        return resolve2;
                    }
                    throw new IllegalStateException("Could not load font");
                }
                return resolve;
            }
        });
    }
}
