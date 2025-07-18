package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
/* loaded from: classes2.dex */
public class KeyAttribute extends Keys {
    private int mFrame;
    private String mTarget;
    private String mTransitionEasing;
    protected String TYPE = TypedValues.AttributesType.NAME;
    private Fit mCurveFit = null;
    private Visibility mVisibility = null;
    private float mAlpha = Float.NaN;
    private float mRotation = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float mTransitionPathRotate = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;

    /* loaded from: classes2.dex */
    public enum Fit {
        SPLINE,
        LINEAR
    }

    /* loaded from: classes2.dex */
    public enum Visibility {
        VISIBLE,
        INVISIBLE,
        GONE
    }

    public KeyAttribute(int i, String str) {
        this.mTarget = str;
        this.mFrame = i;
    }

    public String getTarget() {
        return this.mTarget;
    }

    public void setTarget(String str) {
        this.mTarget = str;
    }

    public String getTransitionEasing() {
        return this.mTransitionEasing;
    }

    public void setTransitionEasing(String str) {
        this.mTransitionEasing = str;
    }

    public Fit getCurveFit() {
        return this.mCurveFit;
    }

    public void setCurveFit(Fit fit) {
        this.mCurveFit = fit;
    }

    public Visibility getVisibility() {
        return this.mVisibility;
    }

    public void setVisibility(Visibility visibility) {
        this.mVisibility = visibility;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public void setAlpha(float f) {
        this.mAlpha = f;
    }

    public float getRotation() {
        return this.mRotation;
    }

    public void setRotation(float f) {
        this.mRotation = f;
    }

    public float getRotationX() {
        return this.mRotationX;
    }

    public void setRotationX(float f) {
        this.mRotationX = f;
    }

    public float getRotationY() {
        return this.mRotationY;
    }

    public void setRotationY(float f) {
        this.mRotationY = f;
    }

    public float getPivotX() {
        return this.mPivotX;
    }

    public void setPivotX(float f) {
        this.mPivotX = f;
    }

    public float getPivotY() {
        return this.mPivotY;
    }

    public void setPivotY(float f) {
        this.mPivotY = f;
    }

    public float getTransitionPathRotate() {
        return this.mTransitionPathRotate;
    }

    public void setTransitionPathRotate(float f) {
        this.mTransitionPathRotate = f;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public void setScaleX(float f) {
        this.mScaleX = f;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public void setScaleY(float f) {
        this.mScaleY = f;
    }

    public float getTranslationX() {
        return this.mTranslationX;
    }

    public void setTranslationX(float f) {
        this.mTranslationX = f;
    }

    public float getTranslationY() {
        return this.mTranslationY;
    }

    public void setTranslationY(float f) {
        this.mTranslationY = f;
    }

    public float getTranslationZ() {
        return this.mTranslationZ;
    }

    public void setTranslationZ(float f) {
        this.mTranslationZ = f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.TYPE);
        sb.append(":{\n");
        attributesToString(sb);
        sb.append("},\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void attributesToString(StringBuilder sb) {
        append(sb, TypedValues.AttributesType.S_TARGET, this.mTarget);
        sb.append("frame:").append(this.mFrame).append(",\n");
        append(sb, "easing", this.mTransitionEasing);
        if (this.mCurveFit != null) {
            sb.append("fit:'").append(this.mCurveFit).append("',\n");
        }
        if (this.mVisibility != null) {
            sb.append("visibility:'").append(this.mVisibility).append("',\n");
        }
        append(sb, "alpha", this.mAlpha);
        append(sb, "rotationX", this.mRotationX);
        append(sb, "rotationY", this.mRotationY);
        append(sb, "rotationZ", this.mRotation);
        append(sb, "pivotX", this.mPivotX);
        append(sb, "pivotY", this.mPivotY);
        append(sb, "pathRotate", this.mTransitionPathRotate);
        append(sb, "scaleX", this.mScaleX);
        append(sb, "scaleY", this.mScaleY);
        append(sb, "translationX", this.mTranslationX);
        append(sb, "translationY", this.mTranslationY);
        append(sb, "translationZ", this.mTranslationZ);
    }
}
