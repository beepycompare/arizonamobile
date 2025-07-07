package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.utils.DropShadow;
import com.airbnb.lottie.utils.OffscreenLayer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
/* loaded from: classes3.dex */
public class ImageLayer extends BaseLayer {
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private DropShadowKeyframeAnimation dropShadowAnimation;
    private final Rect dst;
    private BaseKeyframeAnimation<Bitmap, Bitmap> imageAnimation;
    private final RectF layerBounds;
    private final LottieImageAsset lottieImageAsset;
    private OffscreenLayer offscreenLayer;
    private OffscreenLayer.ComposeOp offscreenOp;
    private final Paint paint;
    private final Rect src;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.paint = new LPaint(3);
        this.src = new Rect();
        this.dst = new Rect();
        this.layerBounds = new RectF();
        this.lottieImageAsset = lottieDrawable.getLottieImageAssetForId(layer.getRefId());
        if (getDropShadowEffect() != null) {
            this.dropShadowAnimation = new DropShadowKeyframeAnimation(this, this, getDropShadowEffect());
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void drawLayer(Canvas canvas, Matrix matrix, int i, DropShadow dropShadow) {
        Bitmap bitmap = getBitmap();
        if (bitmap == null || bitmap.isRecycled() || this.lottieImageAsset == null) {
            return;
        }
        float dpScale = Utils.dpScale();
        this.paint.setAlpha(i);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
        if (baseKeyframeAnimation != null) {
            this.paint.setColorFilter(baseKeyframeAnimation.getValue());
        }
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation = this.dropShadowAnimation;
        if (dropShadowKeyframeAnimation != null) {
            dropShadow = dropShadowKeyframeAnimation.evaluate(matrix, i);
        }
        this.src.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        if (this.lottieDrawable.getMaintainOriginalImageBounds()) {
            this.dst.set(0, 0, (int) (this.lottieImageAsset.getWidth() * dpScale), (int) (this.lottieImageAsset.getHeight() * dpScale));
        } else {
            this.dst.set(0, 0, (int) (bitmap.getWidth() * dpScale), (int) (bitmap.getHeight() * dpScale));
        }
        boolean z = dropShadow != null;
        if (z) {
            if (this.offscreenLayer == null) {
                this.offscreenLayer = new OffscreenLayer();
            }
            if (this.offscreenOp == null) {
                this.offscreenOp = new OffscreenLayer.ComposeOp();
            }
            this.offscreenOp.reset();
            dropShadow.applyWithAlpha(i, this.offscreenOp);
            this.layerBounds.set(this.dst.left, this.dst.top, this.dst.right, this.dst.bottom);
            matrix.mapRect(this.layerBounds);
            canvas = this.offscreenLayer.start(canvas, this.layerBounds, this.offscreenOp);
        }
        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, this.src, this.dst, this.paint);
        if (z) {
            this.offscreenLayer.finish();
            if (this.offscreenLayer.finishDecrementsCanvasSaveCount()) {
                return;
            }
        }
        canvas.restore();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        if (this.lottieImageAsset != null) {
            float dpScale = Utils.dpScale();
            if (this.lottieDrawable.getMaintainOriginalImageBounds()) {
                rectF.set(0.0f, 0.0f, this.lottieImageAsset.getWidth() * dpScale, this.lottieImageAsset.getHeight() * dpScale);
            } else {
                Bitmap bitmap = getBitmap();
                if (bitmap != null) {
                    rectF.set(0.0f, 0.0f, bitmap.getWidth() * dpScale, bitmap.getHeight() * dpScale);
                } else {
                    rectF.set(0.0f, 0.0f, this.lottieImageAsset.getWidth() * dpScale, this.lottieImageAsset.getHeight() * dpScale);
                }
            }
            this.boundsMatrix.mapRect(rectF);
        }
    }

    private Bitmap getBitmap() {
        Bitmap value;
        BaseKeyframeAnimation<Bitmap, Bitmap> baseKeyframeAnimation = this.imageAnimation;
        if (baseKeyframeAnimation == null || (value = baseKeyframeAnimation.getValue()) == null) {
            Bitmap bitmapForId = this.lottieDrawable.getBitmapForId(this.layerModel.getRefId());
            if (bitmapForId != null) {
                return bitmapForId;
            }
            LottieImageAsset lottieImageAsset = this.lottieImageAsset;
            if (lottieImageAsset != null) {
                return lottieImageAsset.getBitmap();
            }
            return null;
        }
        return value;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation2;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation3;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation4;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation5;
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.COLOR_FILTER) {
            if (lottieValueCallback == null) {
                this.colorFilterAnimation = null;
            } else {
                this.colorFilterAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            }
        } else if (t == LottieProperty.IMAGE) {
            if (lottieValueCallback == null) {
                this.imageAnimation = null;
            } else {
                this.imageAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            }
        } else if (t == LottieProperty.DROP_SHADOW_COLOR && (dropShadowKeyframeAnimation5 = this.dropShadowAnimation) != null) {
            dropShadowKeyframeAnimation5.setColorCallback(lottieValueCallback);
        } else if (t == LottieProperty.DROP_SHADOW_OPACITY && (dropShadowKeyframeAnimation4 = this.dropShadowAnimation) != null) {
            dropShadowKeyframeAnimation4.setOpacityCallback(lottieValueCallback);
        } else if (t == LottieProperty.DROP_SHADOW_DIRECTION && (dropShadowKeyframeAnimation3 = this.dropShadowAnimation) != null) {
            dropShadowKeyframeAnimation3.setDirectionCallback(lottieValueCallback);
        } else if (t == LottieProperty.DROP_SHADOW_DISTANCE && (dropShadowKeyframeAnimation2 = this.dropShadowAnimation) != null) {
            dropShadowKeyframeAnimation2.setDistanceCallback(lottieValueCallback);
        } else if (t != LottieProperty.DROP_SHADOW_RADIUS || (dropShadowKeyframeAnimation = this.dropShadowAnimation) == null) {
        } else {
            dropShadowKeyframeAnimation.setRadiusCallback(lottieValueCallback);
        }
    }
}
