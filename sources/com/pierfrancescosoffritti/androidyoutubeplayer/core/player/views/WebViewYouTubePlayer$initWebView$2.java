package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WebViewYouTubePlayer.kt */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"com/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/WebViewYouTubePlayer$initWebView$2", "Landroid/webkit/WebChromeClient;", "onShowCustomView", "", "view", "Landroid/view/View;", "callback", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "onHideCustomView", "getDefaultVideoPoster", "Landroid/graphics/Bitmap;", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WebViewYouTubePlayer$initWebView$2 extends WebChromeClient {
    final /* synthetic */ WebViewYouTubePlayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebViewYouTubePlayer$initWebView$2(WebViewYouTubePlayer webViewYouTubePlayer) {
        this.this$0 = webViewYouTubePlayer;
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, final WebChromeClient.CustomViewCallback callback) {
        FullscreenListener fullscreenListener;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(callback, "callback");
        super.onShowCustomView(view, callback);
        fullscreenListener = this.this$0.listener;
        fullscreenListener.onEnterFullscreen(view, new Function0() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.WebViewYouTubePlayer$initWebView$2$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WebViewYouTubePlayer$initWebView$2.onShowCustomView$lambda$0(callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onShowCustomView$lambda$0(WebChromeClient.CustomViewCallback customViewCallback) {
        customViewCallback.onCustomViewHidden();
        return Unit.INSTANCE;
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        FullscreenListener fullscreenListener;
        super.onHideCustomView();
        fullscreenListener = this.this$0.listener;
        fullscreenListener.onExitFullscreen();
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
        if (defaultVideoPoster == null) {
            Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
            return createBitmap;
        }
        return defaultVideoPoster;
    }
}
