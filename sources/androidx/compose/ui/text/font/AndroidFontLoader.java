package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.compose.ui.text.font.AndroidFont;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
/* compiled from: AndroidFontLoader.android.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\n \t*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/font/AndroidFontLoader;", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cacheKey", "", "getCacheKey", "()Ljava/lang/Object;", "kotlin.jvm.PlatformType", "awaitLoad", "Landroid/graphics/Typeface;", "font", "Landroidx/compose/ui/text/font/Font;", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBlocking", "ui-text_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidFontLoader implements PlatformFontLoader {
    public static final int $stable = 8;
    private final Object cacheKey;
    private final Context context;

    public AndroidFontLoader(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public android.graphics.Typeface loadBlocking(Font font) {
        Object m8471constructorimpl;
        android.graphics.Typeface typeface;
        android.graphics.Typeface load;
        if (font instanceof AndroidFont) {
            AndroidFont androidFont = (AndroidFont) font;
            return androidFont.getTypefaceLoader().loadBlocking(this.context, androidFont);
        }
        if (font instanceof ResourceFont) {
            int mo6204getLoadingStrategyPKNRLFQ = font.mo6204getLoadingStrategyPKNRLFQ();
            if (FontLoadingStrategy.m6246equalsimpl0(mo6204getLoadingStrategyPKNRLFQ, FontLoadingStrategy.Companion.m6251getBlockingPKNRLFQ())) {
                typeface = AndroidFontLoader_androidKt.load((ResourceFont) font, this.context);
            } else if (FontLoadingStrategy.m6246equalsimpl0(mo6204getLoadingStrategyPKNRLFQ, FontLoadingStrategy.Companion.m6252getOptionalLocalPKNRLFQ())) {
                try {
                    Result.Companion companion = Result.Companion;
                    AndroidFontLoader androidFontLoader = this;
                    load = AndroidFontLoader_androidKt.load((ResourceFont) font, this.context);
                    m8471constructorimpl = Result.m8471constructorimpl(load);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    m8471constructorimpl = Result.m8471constructorimpl(ResultKt.createFailure(th));
                }
                typeface = Result.m8477isFailureimpl(m8471constructorimpl) ? null : m8471constructorimpl;
            } else if (FontLoadingStrategy.m6246equalsimpl0(mo6204getLoadingStrategyPKNRLFQ, FontLoadingStrategy.Companion.m6250getAsyncPKNRLFQ())) {
                throw new UnsupportedOperationException("Unsupported Async font load path");
            } else {
                throw new IllegalArgumentException("Unknown loading type " + ((Object) FontLoadingStrategy.m6248toStringimpl(font.mo6204getLoadingStrategyPKNRLFQ())));
            }
            return PlatformTypefaces_androidKt.setFontVariationSettings(typeface, ((ResourceFont) font).getVariationSettings(), this.context);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object awaitLoad(Font font, Continuation<? super android.graphics.Typeface> continuation) {
        AndroidFontLoader$awaitLoad$1 androidFontLoader$awaitLoad$1;
        int i;
        AndroidFontLoader androidFontLoader;
        if (continuation instanceof AndroidFontLoader$awaitLoad$1) {
            androidFontLoader$awaitLoad$1 = (AndroidFontLoader$awaitLoad$1) continuation;
            if ((androidFontLoader$awaitLoad$1.label & Integer.MIN_VALUE) != 0) {
                androidFontLoader$awaitLoad$1.label -= Integer.MIN_VALUE;
                Object obj = androidFontLoader$awaitLoad$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidFontLoader$awaitLoad$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (font instanceof AndroidFont) {
                        AndroidFont androidFont = (AndroidFont) font;
                        AndroidFont.TypefaceLoader typefaceLoader = androidFont.getTypefaceLoader();
                        Context context = this.context;
                        androidFontLoader$awaitLoad$1.label = 1;
                        Object awaitLoad = typefaceLoader.awaitLoad(context, androidFont, androidFontLoader$awaitLoad$1);
                        if (awaitLoad != coroutine_suspended) {
                            return awaitLoad;
                        }
                    } else if (font instanceof ResourceFont) {
                        Context context2 = this.context;
                        androidFontLoader$awaitLoad$1.L$0 = this;
                        androidFontLoader$awaitLoad$1.L$1 = font;
                        androidFontLoader$awaitLoad$1.label = 2;
                        obj = AndroidFontLoader_androidKt.loadAsync((ResourceFont) font, context2, androidFontLoader$awaitLoad$1);
                        if (obj != coroutine_suspended) {
                            androidFontLoader = this;
                        }
                    } else {
                        throw new IllegalArgumentException("Unknown font type: " + font);
                    }
                    return coroutine_suspended;
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                } else if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    font = (Font) androidFontLoader$awaitLoad$1.L$1;
                    androidFontLoader = (AndroidFontLoader) androidFontLoader$awaitLoad$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return PlatformTypefaces_androidKt.setFontVariationSettings((android.graphics.Typeface) obj, ((ResourceFont) font).getVariationSettings(), androidFontLoader.context);
            }
        }
        androidFontLoader$awaitLoad$1 = new AndroidFontLoader$awaitLoad$1(this, continuation);
        Object obj2 = androidFontLoader$awaitLoad$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidFontLoader$awaitLoad$1.label;
        if (i != 0) {
        }
        return PlatformTypefaces_androidKt.setFontVariationSettings((android.graphics.Typeface) obj2, ((ResourceFont) font).getVariationSettings(), androidFontLoader.context);
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public Object getCacheKey() {
        return this.cacheKey;
    }
}
